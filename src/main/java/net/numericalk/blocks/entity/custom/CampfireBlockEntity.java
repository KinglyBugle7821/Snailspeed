package net.numericalk.blocks.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.blocks.custom.CampfireBlock;
import net.numericalk.blocks.entity.ImplementedInventory;
import net.numericalk.blocks.entity.SnailBlockEntities;
import net.numericalk.items.SnailItems;
import net.numericalk.recipe.CampfireRecipe;
import net.numericalk.recipe.CampfireRecipeInput;
import net.numericalk.recipe.SnailRecipes;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CampfireBlockEntity extends BlockEntity implements ImplementedInventory {

    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int INPUT_SLOT_3 = 2;

    private int progress = 0;
    private int maxProgress = 72;

    private final float fireDegradeTimeFinal = 1200f;
    private float fireDegradeTime = fireDegradeTimeFinal;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public CampfireBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.CAMPFIRE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putFloat("FireDegradeTime", fireDegradeTime);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        fireDegradeTime = nbt.getFloat("FireDegradeTime");
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

        if(hasRecipe()) {
            System.out.println(progress);
            increaseCraftingProgress();
            markDirty(world, pos, state);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }

        //FIRE DEGRADING LOGIC
        if (state.get(CampfireBlock.LIT) >= 2 && fireDegradeTime > 0){
            fireDegradeTime --;
        } else if (state.get(CampfireBlock.LIT) == 2 && fireDegradeTime <= 0){
            world1.setBlockState(pos, state.with(CampfireBlock.LIT, 1));
            setFireDegradeTime(fireDegradeTimeFinal);
        }
        if (state.get(CampfireBlock.LIT) == 2 && timeNeededToUpgradeFire(200f)){
            world1.setBlockState(pos, state.with(CampfireBlock.LIT, 3));
        }
        if (state.get(CampfireBlock.LIT) == 3 && fireDegradeTime <= fireDegradeTimeFinal){
            world1.setBlockState(pos, state.with(CampfireBlock.LIT, 2));
        }
        if (state.get(CampfireBlock.LIT) == 3 && timeNeededToUpgradeFire(400f)){
            world1.setBlockState(pos, state.with(CampfireBlock.LIT, 4));
        }
        if (state.get(CampfireBlock.LIT) == 4 && fireDegradeTime <= fireDegradeTimeFinal * 3){
            world1.setBlockState(pos, state.with(CampfireBlock.LIT, 3));
        }
    }

    private boolean timeNeededToUpgradeFire(float upgradeFirePercentage){
        return fireDegradeTime >= (upgradeFirePercentage / 100f) * fireDegradeTimeFinal;
    }

    public void calculateAddedFireTime() {
        fireDegradeTime += ((fireDegradeTimeFinal/100f) * 25f);
    }

    public float getFireDegradeTime() {
        return fireDegradeTime;
    }

    public void setFireDegradeTime(float fireDegradeTime) {
        this.fireDegradeTime = fireDegradeTime;
    }
    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = 72;
    }
    private void increaseCraftingProgress() {
        this.progress++;
    }

    private void craftItem() {
        Optional<RecipeEntry<CampfireRecipe>> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().value().output();
        for (int i = 0; i < 3; i++){
            this.removeStack(i, 1);
            this.setStack(i, new ItemStack(output.getItem(),
                    this.getStack(i).getCount() + output.getCount()));
        }
    }
    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }
    private boolean hasRecipe() {
        Optional<RecipeEntry<CampfireRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()){
            return false;
        }

        ItemStack output = recipe.get().value().output();

        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeEntry<CampfireRecipe>> getCurrentRecipe() {
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = this.getStack(i);
            if (!stack.isEmpty()) {
                Optional<RecipeEntry<CampfireRecipe>> recipe = ((ServerWorld) this.getWorld())
                        .getRecipeManager()
                        .getFirstMatch(SnailRecipes.CAMPFIRE_TYPE, new CampfireRecipeInput(stack), this.getWorld());

                if (recipe.isPresent()) {
                    return recipe;
                }
            }
        }
        return Optional.empty();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        for (int i = 0; i < 3; i++) {
            int maxCount = this.getStack(i).isEmpty() ? 64 : this.getStack(i).getMaxCount();
            int currentCount = this.getStack(i).getCount();

            if (maxCount >= currentCount + count){
                return true;
            }
        }

        return false;
    }
    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        for (int i = 0; i < 3; i++){
            if (this.getStack(i).isEmpty() || this.getStack(i).getItem() == output.getItem()){
                return true;
            }
        }
        return false;
    }
}
