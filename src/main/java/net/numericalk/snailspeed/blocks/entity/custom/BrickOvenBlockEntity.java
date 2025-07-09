package net.numericalk.snailspeed.blocks.entity.custom;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.custom.BrickOvenBlock;
import net.numericalk.snailspeed.blocks.entity.ImplementedInventory;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.compat.custom.BrickOvenSmeltingRecipeDisplay;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.recipe.custom.BrickOvenCookingRecipe;
import net.numericalk.snailspeed.recipe.custom.BrickOvenCookingRecipeInput;
import net.numericalk.snailspeed.recipe.custom.BrickOvenSmeltingRecipe;
import net.numericalk.snailspeed.recipe.custom.BrickOvenSmeltingRecipeInput;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BrickOvenBlockEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);
    private final ServerRecipeManager.MatchGetter<BrickOvenCookingRecipeInput, BrickOvenCookingRecipe> matchGetterCooking;
    private final ServerRecipeManager.MatchGetter<BrickOvenSmeltingRecipeInput, BrickOvenSmeltingRecipe> matchGetterSmelting;

    public BrickOvenBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.BRICK_OVEN, pos, state);
        this.matchGetterCooking = ServerRecipeManager.createCachedMatchGetter(SnailRecipe.BRICK_OVEN_COOKING_RECIPE_TYPE);
        this.matchGetterSmelting = ServerRecipeManager.createCachedMatchGetter(SnailRecipe.BRICK_OVEN_SMELTING_RECIPE_TYPE);
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putFloat("FireTime", fireTime);
        nbt.putIntArray("CookTime", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        fireTime = nbt.getFloat("FireTime");

        int[] savedProgress = nbt.getIntArray("CookTime");
        System.arraycopy(savedProgress, 0, progress, 0, Math.min(savedProgress.length, progress.length));
    }

    public float fireTime;
    public float maxFireTime = 20 * 60 * 10;

    private final int[] progress = new int[5];
    private int maxProgress;

    public void tick(World world1, BlockPos pos, BlockState state) {
        for (int i = 0; i < 6; i++) {
            if (this.getStack(i).isOf(SnailItems.AIR)) {
                this.setStack(i, ItemStack.EMPTY);
            }
        }
        if (hasFuel() && isLit(state)) {
            decreaseFireTime();
            if (fireTime <= 0) {
                fireTime = 0;
                setLitState(0, world1, pos, state);
                this.getStack(5).decrement(1);
            } else if (fireTime <= 20 * 60 * 3 && state.get(BrickOvenBlock.LIT).equals(3)) {
                setLitState(2, world1, pos, state);
            }
        } else if (hasFuel()) {
            displayHasFuel(world1, pos, state);
            resetFireTime();
        }
        else {
            resetFireTime();
        }

        if (state.get(BrickOvenBlock.LIT).equals(2)) {
            maxProgress = 20 * 60 * 2;
            cookItem(state, world1, pos, maxProgress);
        } else if (state.get(BrickOvenBlock.LIT).equals(3)) {
            maxProgress = 20 * 60;
            smeltItem(state, world1, pos, maxProgress);
        }
    }

    private void spawnSmokeParticle(World world, BlockPos pos, BlockState state) {
        if (world instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(
                    ParticleTypes.SMOKE,
                    pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5,
                    1,
                    0, 0.2, 0,
                    0.01
            );
        }
    }

    private void smeltItem(BlockState state, World world1, BlockPos pos, int maxProgress) {
        if (world1.isClient()) return;
        for (int i = 0; i < 5; i++) {
            if(hasRecipe(i, true)) {
                increaseCraftingProgress(i);
                spawnSmokeParticle(world1, pos, state);

                if (hasCraftingFinished(maxProgress, i)) {
                    craftItem(i, true);
                    resetProgress(i);
                    markDirty();
                    world1.updateListeners(pos, getCachedState(), getCachedState(), 3);
                }
            } else {
                resetProgress(i);
            }
        }
    }

    private void cookItem(BlockState state, World world1, BlockPos pos, int maxProgress) {
        if (world1.isClient()) return;
        for (int i = 0; i < 5; i++) {
            if(hasRecipe(i, false)) {
                increaseCraftingProgress(i);
                spawnSmokeParticle(world1, pos, state);

                if (hasCraftingFinished(maxProgress, i)) {
                    craftItem(i, false);
                    resetProgress(i);
                    markDirty();
                    world1.updateListeners(pos, getCachedState(), getCachedState(), 3);
                }
            } else {
                resetProgress(i);
            }
        }
    }

    private void resetProgress(int i) {
        progress[i] = 0;
    }

    private boolean hasCraftingFinished(int maxProgress, int i) {
        return progress[i] >= maxProgress;
    }
    private void craftItem(int i, boolean isSmelting) {
        if (!isSmelting) {
            Optional<RecipeEntry<BrickOvenCookingRecipe>> recipe = getCurrentCookingRecipe(i);
            if (recipe.isEmpty()) {
                return;
            }
            ItemStack output = recipe.get().value().output();
            this.setStack(i, output.copy());
        } else {
            Optional<RecipeEntry<BrickOvenSmeltingRecipe>> recipe = getCurrentSmeltingRecipe(i);
            if (recipe.isEmpty()) {
                return;
            }
            ItemStack output = recipe.get().value().output();
            this.setStack(i, output.copy());
        }
    }

    private void increaseCraftingProgress(int i) {
        progress[i]++;
    }

    private Optional<RecipeEntry<BrickOvenCookingRecipe>> getCurrentCookingRecipe(int currentInput) {
        return this.matchGetterCooking.getFirstMatch(new BrickOvenCookingRecipeInput(
                inventory.get(currentInput)
        ), (ServerWorld) this.world);
    }
    private Optional<RecipeEntry<BrickOvenSmeltingRecipe>> getCurrentSmeltingRecipe(int currentInput) {
        return this.matchGetterSmelting.getFirstMatch(new BrickOvenSmeltingRecipeInput(
                inventory.get(currentInput)
        ), (ServerWorld) this.world);
    }
    private boolean hasRecipe(int i, boolean isSmelting) {
        if (!isSmelting){
            Optional<RecipeEntry<BrickOvenCookingRecipe>> recipe = getCurrentCookingRecipe(i);
            if(recipe.isEmpty()) {
                return false;
            }
            Ingredient input = recipe.get().value().input();

            return getOutputOf(input, i);
        }
        Optional<RecipeEntry<BrickOvenSmeltingRecipe>> recipe = getCurrentSmeltingRecipe(i);
        if(recipe.isEmpty()) {
            return false;
        }
        Ingredient input = recipe.get().value().input();

        return getOutputOf(input, i);
    }
    private boolean getOutputOf(Ingredient input, int currentInput) {
        ItemStack inputSlot = this.getStack(currentInput);

        return input.test(inputSlot);
    }
    private void setLitState(int lit, World world1, BlockPos pos, BlockState state) {
        world1.setBlockState(pos, state.with(BrickOvenBlock.LIT, lit));
    }

    private void displayHasFuel(World world1, BlockPos pos, BlockState state) {
        world1.setBlockState(pos, state.with(BrickOvenBlock.LIT, 1));
    }

    private void decreaseFireTime() {
        fireTime = Math.max(0, fireTime - 1);
    }

    public void calculatedAddedFireTime(TagKey<Item> fuelType) {
        if (fuelType == SnailItemTagsProvider.CAMPFIRE_FUEL) {
            fireTime += ((1200f/100f) * 50f);
        } else if (fuelType == SnailItemTagsProvider.OVEN_FUEL) {
            fireTime += ((2400f/100f) * 50f);
        }
    }

    private void resetFireTime() {
        if (this.getStack(5).isIn(SnailItemTagsProvider.CAMPFIRE_FUEL)) {
            fireTime = 20 * 30;
        } else if (this.getStack(5).isIn(SnailItemTagsProvider.OVEN_FUEL)) {
            fireTime = 20 * 60;
        }
    }

    public float getMaxFireTime() {
        return maxFireTime;
    }

    public float getFireTime() {
        return fireTime;
    }

    private boolean isLit(BlockState state) {
        return state.get(BrickOvenBlock.LIT) >= 2;
    }

    private boolean hasFuel() {
        return !this.getStack(5).isEmpty();
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    private static final Item[][] COOKING_RECIPES = {
            {Items.POTATO, Items.BAKED_POTATO},
            {Items.CHORUS_FRUIT, Items.POPPED_CHORUS_FRUIT},
            {Items.CHICKEN, Items.COOKED_CHICKEN},
            {Items.COD, Items.COOKED_COD},
            {Items.MUTTON, Items.COOKED_MUTTON},
            {Items.PORKCHOP, Items.COOKED_PORKCHOP},
            {Items.RABBIT, Items.COOKED_RABBIT},
            {Items.SALMON, Items.COOKED_SALMON},
            {Items.KELP, Items.DRIED_KELP},
            {Items.BEEF, Items.COOKED_BEEF},
    };
    private static final Item[][] SMELTING_RECIPES = {
            {Items.POTATO, SnailItems.BURNT_POTATO},
            {Items.CHORUS_FRUIT, SnailItems.BURNT_POPPED_CHORUS_FRUIT},
            {Items.CHICKEN, SnailItems.BURNT_CHICKEN},
            {Items.COD, SnailItems.BURNT_COD},
            {Items.MUTTON, SnailItems.BURNT_MUTTON},
            {Items.PORKCHOP, SnailItems.BURNT_PORKCHOP},
            {Items.RABBIT, SnailItems.BURNT_RABBIT},
            {Items.SALMON, SnailItems.BURNT_SALMON},
            {Items.KELP, SnailItems.BURNT_KELP},
            {Items.BEEF, SnailItems.BURNT_BEEF},
            {SnailItems.COPPER_DUST, SnailItems.COPPER_NUGGET},
            {SnailItems.IRON_DUST, Items.IRON_NUGGET},
            {SnailItems.GOLD_DUST, Items.GOLD_NUGGET},
            {SnailItems.TIN_DUST, SnailItems.TIN_NUGGET}
    };
}
