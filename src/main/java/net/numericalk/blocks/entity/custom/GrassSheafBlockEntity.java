package net.numericalk.blocks.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.blocks.entity.SnailBlockEntities;
import org.jetbrains.annotations.Nullable;

public class GrassSheafBlockEntity extends BlockEntity {
    public GrassSheafBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.GRASS_SHEAF_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("DryTimeRemaining", dryTimeRemaining);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        dryTimeRemaining = nbt.getInt("DryTimeRemaining");
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
    private int dryTimeRemaining = 0;
    private final int maxDryTime = 20 * 60 * 5;

    public void tick(World world1, BlockPos pos, BlockState state) {
        if (isGrassSheaf(state)){
            System.out.println("It is Grass Sheaf");
            if (!isRaining(world1) && hasDaylight(world1, pos)){
                System.out.println("IT should Work : " + dryTimeRemaining);
                if (hasProgressComplete()){
                    dryGrassSheaf(world1, pos, state);
                }
                increaseProgress();
            } else if (!hasDaylight(world1, pos)){
                pauseProgress();
            } else if (isRaining(world1)){
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        dryTimeRemaining = 0;
    }

    private void pauseProgress() {
    }

    private void increaseProgress() {
        dryTimeRemaining++;
    }

    private void dryGrassSheaf(World world1, BlockPos pos, BlockState state) {
        if (world1.isClient()){
            return;
        }
        world1.setBlockState(pos, SnailBlocks.DRIED_GRASS_SHEAF.getStateWithProperties(state));
    }

    private boolean hasProgressComplete() {
        return dryTimeRemaining >= maxDryTime;
    }

    private boolean hasDaylight(World world1, BlockPos pos) {
        return world1.getLightLevel(LightType.SKY, pos.up()) == 15;
    }

    private boolean isRaining(World world1) {
        return world1.isRaining() || world1.isThundering();
    }

    private boolean isGrassSheaf(BlockState state1) {
        return state1.isOf(SnailBlocks.GRASS_SHEAF);
    }
}
