package net.numericalk.snailspeed.blocks.entity.custom;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
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
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.custom.FilteringTrayBlock;
import net.numericalk.snailspeed.blocks.entity.ImplementedInventory;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.recipe.custom.BrickFurnaceRecipe;
import net.numericalk.snailspeed.recipe.custom.BrickFurnaceRecipeInput;
import net.numericalk.snailspeed.recipe.custom.FilteringTrayRecipe;
import net.numericalk.snailspeed.recipe.custom.FilteringTrayRecipeInput;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class FilteringTrayBlockEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    private final ServerRecipeManager.MatchGetter<FilteringTrayRecipeInput, FilteringTrayRecipe> matchGetter;

    private static final int INPUT_1 = 0;
    private static final int INPUT_2 = 1;

    public FilteringTrayBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.FILTERING_TRAY, pos, state);
        this.matchGetter = ServerRecipeManager.createCachedMatchGetter(SnailRecipe.FILTERING_TRAY_RECIPE_TYPE);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("Progress", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("Progress");
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

    public void tick(World world1, BlockPos pos, BlockState state) {
        for (int i = 0; i < 2; i++) {
            if (this.getStack(i).isOf(SnailItems.AIR)) {
                this.setStack(i, ItemStack.EMPTY);
            }
        }
        filterItem(world1, pos, state);
    }

    private int progress = 0;
    private int maxProgress = 20 * 60 * 3;
    private void filterItem(World world1, BlockPos pos, BlockState state) {
        if (!world1.isClient()) {
            if(hasRecipe(state)) {
                increaseCraftingProgress();
                spawnWaterParticle(world1, pos, state);

                if (hasCraftingFinished(maxProgress)) {
                    craftItem();
                    resetProgress();
                    markDirty();
                    world1.updateListeners(pos, getCachedState(), getCachedState(), 3);
                }
            } else {
                resetProgress();
            }
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<RecipeEntry<FilteringTrayRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        this.setStack(INPUT_1, SnailItems.AIR.getDefaultStack());
        this.setStack(INPUT_2, SnailItems.AIR.getDefaultStack());
        this.setStack(INPUT_1, new ItemStack(output.getItem(), 1));
    }

    private boolean hasCraftingFinished(int maxProgress) {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe(BlockState state) {
        if (state.get(FilteringTrayBlock.HAS_FILTER)){
            Optional<RecipeEntry<FilteringTrayRecipe>> recipe = getCurrentRecipe();
            if(recipe.isEmpty()) {
                return false;
            }
            Ingredient input1 = recipe.get().value().input1();
            Ingredient input2 = recipe.get().value().input2();

            return getOutputOf(input1, input2);
        }
        return false;
    }
    private boolean getOutputOf(Ingredient input1, Ingredient input2) {
        ItemStack input1Slot = this.getStack(INPUT_1);
        ItemStack input2Slot = this.getStack(INPUT_2);

        return input1.test(input1Slot) &&
                input2.test(input2Slot);
    }

    public Optional<RecipeEntry<FilteringTrayRecipe>> getCurrentRecipe() {
        return this.matchGetter.getFirstMatch(new FilteringTrayRecipeInput(
                inventory.get(INPUT_1),
                inventory.get(INPUT_2)
        ), (ServerWorld) this.world);
    }
    private void spawnWaterParticle(World world1, BlockPos pos, BlockState state) {
        if (!world1.isClient()) {
            ((ServerWorld) world1).spawnParticles(
                    ParticleTypes.DRIPPING_WATER,
                    pos.getX() + 0.5, pos.getY() + 0.7, pos.getZ() + 0.5,
                    1,
                    0.2, 0, 0.2,
                    0.01
            );
        }
    }


}
