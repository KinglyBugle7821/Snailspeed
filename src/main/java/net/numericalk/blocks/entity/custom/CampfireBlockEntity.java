package net.numericalk.blocks.entity.custom;

import net.minecraft.block.BeaconBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.blocks.custom.CampfireBlock;
import net.numericalk.blocks.entity.ImplementedInventory;
import net.numericalk.blocks.entity.SnailBlockEntities;
import net.numericalk.items.SnailItems;
import org.jetbrains.annotations.Nullable;

import static net.numericalk.blocks.custom.CampfireBlock.*;

public class CampfireBlockEntity extends BlockEntity implements ImplementedInventory {

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
        nbt.putIntArray("CookTime", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        fireDegradeTime = nbt.getFloat("FireDegradeTime");

        int[] savedProgress = nbt.getIntArray("CookTime");
        for (int i = 0; i < Math.min(savedProgress.length, progress.length); i++) {
            progress[i] = savedProgress[i];
        }
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

    private final int[] progress = new int[3];
    private int maxProgress;
    public void tick(World world1, BlockPos pos, BlockState state) {

        if (!canExtinguishFire(state) && fireDegradeTime > 0 && getLitBlockState(state) > CampfireBlock.LIT_UNLIT){
            fireDegradeTime --;
        } else if (canExtinguishFire(state)){
            extinguishFire(world1, pos, state);
        }

        if (isWorldRaining(state, world1) && isSkyVisible(world1, pos)){
            extinguishFireWithoutBeingBurnt(world1, pos, state);
        }
        if (canUpgradeFire(state, LIT_SMALL, 200f)){
            upgradeFire(world1, pos, state, LIT_SMALL);
        }
        if (canDegradeFire(state, LIT_MEDIUM)){
            degradeFire(world1, pos, state, LIT_MEDIUM);
        }
        if (canUpgradeFire(state, LIT_MEDIUM, 400f)){
            upgradeFire(world1, pos, state, LIT_MEDIUM);
        }
        if (canDegradeFire(state, LIT_LARGE)){
            degradeFire(world1, pos, state, LIT_LARGE);
        }

        //RECIPE

        if (getLitBlockState(state) == 2){
            maxProgress = 20 * 60 * 5;
            cookItem(world1, pos, maxProgress);
        }
        if (getLitBlockState(state) == 3){
            maxProgress = 20 * 60 * 3;
            cookItem(world1, pos, maxProgress);
        }
        if (getLitBlockState(state) == 4){
            maxProgress = 20 * 60;
            burnItem(world1, pos, maxProgress);
        }
    }

    private void extinguishFireWithoutBeingBurnt(World world1, BlockPos pos, BlockState state) {
        world1.setBlockState(pos, state.with(CampfireBlock.LIT, 1));
        setFireDegradeTime(fireDegradeTimeFinal);
    }

    public boolean isSkyVisible(World world1, BlockPos pos) {
        int worldHeight = world1.getHeight();

        for (int y = pos.getY() + 1; y < worldHeight; y++) {
            BlockPos abovePos = new BlockPos(pos.getX(), y, pos.getZ());
            if (!world1.isAir(abovePos)) {
                return false;
            }
        }

        return true;
    }

    private boolean isWorldRaining(BlockState state, World world1) {
        return (world1.isRaining() || world1.isThundering()) && state.get(LIT) >= LIT_SMALL;
    }

    private void burnItem(World world1, BlockPos pos, int maxProgress) {
        for (int i = 0; i < 3; i++) {
            ItemStack stack = getStack(i);
            if (stack.isEmpty()) continue;

            Item cooked = getBurntItem(stack.getItem());
            if (cooked != null) {
                progress[i]++;
                if (progress[i] >= maxProgress) {
                    setStack(i, new ItemStack(cooked));
                    progress[i] = 0;

                    if (!world1.isClient) {
                        markDirty();
                        world1.updateListeners(pos, getCachedState(), getCachedState(), 3);
                    }
                }
            } else {
                progress[i] = 0;
            }
        }
    }

    private void cookItem(World world1, BlockPos pos, int maxProgress) {
        for (int i = 0; i < 3; i++) {
            ItemStack stack = getStack(i);
            if (stack.isEmpty()) continue;

            Item cooked = getCookedItem(stack.getItem());
            if (cooked != null) {
                progress[i]++;
                if (progress[i] >= maxProgress) {
                    setStack(i, new ItemStack(cooked));
                    progress[i] = 0;

                    if (!world1.isClient) {
                        markDirty();
                        world1.updateListeners(pos, getCachedState(), getCachedState(), 3);
                    }
                }
            } else {
                progress[i] = 0;
            }
        }
    }

    private Item getCookedItem(Item raw) {
        for (Object[] entry : cookingRecipe) {
            if (entry[0] == raw) return (Item) entry[1];
            if (entry[1] == raw) return (Item) entry[2];
        }
        return null;
    }
    private Item getBurntItem(Item raw) {
        for (Object[] entry : cookingRecipe) {
            if (entry[0] == raw) return (Item) entry[2];
        }
        return null;
    }

    Object[][] cookingRecipe = {
            {Items.POTATO, Items.BAKED_POTATO, SnailItems.BURNT_POTATO},
            {Items.CHORUS_FRUIT, Items.POPPED_CHORUS_FRUIT, SnailItems.BURNT_POPPED_CHORUS_FRUIT},
            {Items.CHICKEN, Items.COOKED_CHICKEN, SnailItems.BURNT_CHICKEN},
            {Items.COD, Items.COOKED_COD, SnailItems.BURNT_COD},
            {Items.MUTTON, Items.COOKED_MUTTON, SnailItems.BURNT_MUTTON},
            {Items.PORKCHOP, Items.COOKED_PORKCHOP, SnailItems.BURNT_PORKCHOP},
            {Items.RABBIT, Items.COOKED_RABBIT, SnailItems.BURNT_RABBIT},
            {Items.SALMON, Items.COOKED_SALMON, SnailItems.BURNT_SALMON},
            {Items.KELP, Items.DRIED_KELP, SnailItems.BURNT_KELP},
            {Items.BEEF, Items.COOKED_BEEF, SnailItems.BURNT_BEEF},
    };



    private boolean canExtinguishFire(BlockState state){
        return state.get(CampfireBlock.LIT) == 2 && fireDegradeTime <= 0;
    }
    private void extinguishFire(World world1, BlockPos pos, BlockState state){
        world1.setBlockState(pos, state.with(CampfireBlock.LIT, 1).with(CampfireBlock.STAGES, 6));
        setFireDegradeTime(fireDegradeTimeFinal);
    }

    private boolean canDegradeFire(BlockState state, int currentLitState) {
        return getLitBlockState(state) == currentLitState && fireDegradeTime <= fireDegradeTimeFinal;
    }
    private void degradeFire(World world1, BlockPos pos, BlockState state, int currentLitState){
        world1.setBlockState(pos, state.with(CampfireBlock.LIT, currentLitState - 1));
    }

    private boolean canUpgradeFire(BlockState state, int currentLitState, float timeNeededToUpgrade){
        return getLitBlockState(state) == currentLitState && timeNeededToUpgradeFire(timeNeededToUpgrade);
    }
    private void upgradeFire(World world1, BlockPos pos, BlockState state, int currentLitState){
        world1.setBlockState(pos, state.with(CampfireBlock.LIT, currentLitState + 1));
    }
    public int getLitBlockState(BlockState state){
        return state.get(CampfireBlock.LIT);
    }
    public int getStagesBlockState(BlockState state){
        return state.get(CampfireBlock.STAGES);
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

    public float getFireDegradeTimeLimit() {
        return fireDegradeTimeFinal * 4f;
    }
}
