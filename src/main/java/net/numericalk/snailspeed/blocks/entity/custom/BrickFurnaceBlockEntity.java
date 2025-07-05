package net.numericalk.snailspeed.blocks.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.custom.BrickFurnaceBlock;
import net.numericalk.snailspeed.blocks.entity.ImplementedInventory;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.recipe.custom.ArmorForgeRecipe;
import net.numericalk.snailspeed.recipe.custom.ArmorForgeRecipeInput;
import net.numericalk.snailspeed.recipe.custom.BrickFurnaceRecipe;
import net.numericalk.snailspeed.recipe.custom.BrickFurnaceRecipeInput;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BrickFurnaceBlockEntity extends BlockEntity implements ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);
    private final ServerRecipeManager.MatchGetter<BrickFurnaceRecipeInput, BrickFurnaceRecipe> matchGetter;

    public BrickFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.BRICK_FURNACE, pos, state);
        this.matchGetter = ServerRecipeManager.createCachedMatchGetter(SnailRecipe.BRICK_FURNACE_RECIPE_TYPE);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putFloat("FireTime", fireTime);
        nbt.putInt("CookTime", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        fireTime = nbt.getFloat("FireTime");
        progress = nbt.getInt("CookTime");
    }

    private final int INPUT_1 = 0;
    private final int INPUT_2 = 1;
    private final int INPUT_3 = 2;
    private final int INPUT_4 = 3;
    private final int INPUT_5 = 4;

    private int progress = 0;
    private int maxProgress;

    public float fireTime;
    public float maxFireTime = 20 * 60 * 10;
    public void tick(World world1, BlockPos pos, BlockState state) {
        for (int i = 0; i < 5; i++) {
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
            } else if (fireTime <= 20 * 60 * 3 && state.get(BrickFurnaceBlock.LIT).equals(3)) {
                setLitState(2, world1, pos, state);
            }
        } else if (hasFuel()) {
            displayHasFuel(world1, pos, state);
            resetFireTime();
        }
        else {
            resetFireTime();
        }
        if (!world1.isClient()){
            if (state.get(BrickFurnaceBlock.LIT).equals(2)) {
                maxProgress = 20 * 60 * 3;
                smeltItem(state, world1, pos, maxProgress);
            } else if (state.get(BrickFurnaceBlock.LIT).equals(3)) {
                maxProgress = 20 * 60;
                smeltItem(state, world1, pos, maxProgress);
            }
        }
    }

    private void smeltItem(BlockState state, World world1, BlockPos pos, int maxProgress) {
        if(hasRecipe(state)) {
            increaseCraftingProgress();
            spawnSmokeParticle(world1, pos, state);

            if (hasCraftingFinished(maxProgress)) {
                craftItem(world1);
                resetProgress();
                markDirty();
                world1.updateListeners(pos, getCachedState(), getCachedState(), 3);
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem(World world) {
        Optional<RecipeEntry<BrickFurnaceRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        if (output.isIn(SnailItemTagsProvider.MOLTEN_ITEMS)){
            for (int i = 0; i <= INPUT_5; i++){
                this.setStack(i, new ItemStack(output.getItem(), this.getStack(i).getCount() + output.getCount()));
                markDirty();
                world.updateListeners(pos, getCachedState(), getCachedState(), 3);
            }
        } else {
            for (int i = 0; i <= INPUT_5; i++){
                this.setStack(i, SnailItems.AIR.getDefaultStack());
            }
            this.setStack(INPUT_1, new ItemStack(output.getItem(), 1));
            for (int i = 1; i <= INPUT_5; i++){
                this.setStack(i, SnailItems.AIR.getDefaultStack());
            }
            markDirty();
            world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    }

    private boolean hasCraftingFinished(int maxProgress) {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private Optional<RecipeEntry<BrickFurnaceRecipe>> getCurrentRecipe() {
        return this.matchGetter.getFirstMatch(new BrickFurnaceRecipeInput(
                inventory.get(INPUT_1),
                inventory.get(INPUT_2),
                inventory.get(INPUT_3),
                inventory.get(INPUT_4),
                inventory.get(INPUT_5)
        ), (ServerWorld) this.world);
    }
    private boolean hasRecipe(BlockState state) {
        if (state.get(BrickFurnaceBlock.LID)){
            Optional<RecipeEntry<BrickFurnaceRecipe>> recipe = getCurrentRecipe();
            if(recipe.isEmpty()) {
                return false;
            }
            Ingredient input1 = recipe.get().value().input1();
            Ingredient input2 = recipe.get().value().input2();
            Ingredient input3 = recipe.get().value().input3();
            Ingredient input4 = recipe.get().value().input4();
            Ingredient input5 = recipe.get().value().input5();

            return getOutputOf(input1, input2, input3, input4, input5);
        }
        return false;
    }

    private boolean getOutputOf(Ingredient input1, Ingredient input2, Ingredient input3, Ingredient input4, Ingredient input5) {
        ItemStack input1Slot = this.getStack(INPUT_1);
        ItemStack input2Slot = this.getStack(INPUT_2);
        ItemStack input3Slot = this.getStack(INPUT_3);
        ItemStack input4Slot = this.getStack(INPUT_4);
        ItemStack input5Slot = this.getStack(INPUT_5);

        return input1.test(input1Slot) &&
                input2.test(input2Slot)&&
                input3.test(input3Slot)&&
                input4.test(input4Slot) &&
                input5.test(input5Slot);
    }

    private void spawnSmokeParticle(World world1, BlockPos pos, BlockState state) {
        if (!world1.isClient) {
            ((ServerWorld) world1).spawnParticles(
                    ParticleTypes.SMOKE,
                    pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5,
                    1,
                    0, 0.2, 0,
                    0.01
            );
        }
    }

    private void resetFireTime() {
        if (this.getStack(5).isIn(SnailItemTagsProvider.CAMPFIRE_FUEL)) {
            fireTime = 20 * 30;
        } else if (this.getStack(5).isIn(SnailItemTagsProvider.OVEN_FUEL)) {
            fireTime = 20 * 60;
        }
    }

    private void displayHasFuel(World world1, BlockPos pos, BlockState state) {
        world1.setBlockState(pos, state.with(BrickFurnaceBlock.LIT, 1));
    }

    private void setLitState(int lit, World world1, BlockPos pos, BlockState state) {
        world1.setBlockState(pos, state.with(BrickFurnaceBlock.LIT, lit));
    }

    private void decreaseFireTime() {
        fireTime = Math.max(0, fireTime - 1);
    }

    private boolean isLit(BlockState state) {
        return state.get(BrickFurnaceBlock.LIT) >= 2;
    }

    private boolean hasFuel() {
        return !this.getStack(5).isEmpty();
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public void calculatedAddedFireTime(TagKey<Item> fuelType) {
        if (fuelType == SnailItemTagsProvider.CAMPFIRE_FUEL) {
            fireTime += ((1200f/100f) * 50f);
        } else if (fuelType == SnailItemTagsProvider.OVEN_FUEL) {
            fireTime += ((2400f/100f) * 50f);
        }
    }

    public float getMaxFireTime() {
        return maxFireTime;
    }

    public float getFireTime() {
        return fireTime;
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
}
