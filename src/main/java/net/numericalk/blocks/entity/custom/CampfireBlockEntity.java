package net.numericalk.blocks.entity.custom;

import com.sun.jna.platform.win32.OaIdl;
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
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.blocks.custom.CampfireBlock;
import net.numericalk.blocks.entity.ImplementedInventory;
import net.numericalk.blocks.entity.SnailBlockEntities;
import net.numericalk.datagen.SnailItemTagsProvider;
import org.jetbrains.annotations.Nullable;


//TODO : IMPROVE FIRE DEGRADING LOGIC AND ADD RECIPE
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

    //TODO : ADD FIRE DEGRADE TIME LIMIT

    private int progress = 0;
    private final int maxProgress = 20 * 5;
    public void tick(World world1, BlockPos pos, BlockState state) {

        System.out.println(fireDegradeTime);
        if (!canExtinguishFire(state) && fireDegradeTime > 0 && getLitBlockState(state) > 1){
            fireDegradeTime --;
        } else if (canExtinguishFire(state)){
            extinguishFire(world1, state);
        }
        if (canUpgradeFire(state, 2, 200f)){
            upgradeFire(world1, state, 2);
        }
        if (canDegradeFire(state, 3)){
            degradeFire(world1, state, 3);
        }
        if (canUpgradeFire(state, 3, 400f)){
            upgradeFire(world1, state, 3);
        }
        if (canDegradeFire(state, 4)){
            degradeFire(world1, state, 4);
        }
    }

    private boolean canExtinguishFire(BlockState state){
        return state.get(CampfireBlock.LIT) == 2 && fireDegradeTime <= 0;
    }
    private void extinguishFire(World world1, BlockState state){
        world1.setBlockState(pos, state.with(CampfireBlock.LIT, 1));
        setFireDegradeTime(fireDegradeTimeFinal);
    }

    private boolean canDegradeFire(BlockState state, int currentLitState) {
        return getLitBlockState(state) == currentLitState && fireDegradeTime <= fireDegradeTimeFinal;
    }
    private void degradeFire(World world1, BlockState state, int currentLitState){
        world1.setBlockState(pos, state.with(CampfireBlock.LIT, currentLitState - 1));
    }

    private boolean canUpgradeFire(BlockState state, int currentLitState, float timeNeededToUpgrade){
        return getLitBlockState(state) == currentLitState && timeNeededToUpgradeFire(timeNeededToUpgrade);
    }
    private void upgradeFire(World world1, BlockState state, int currentLitState){
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
