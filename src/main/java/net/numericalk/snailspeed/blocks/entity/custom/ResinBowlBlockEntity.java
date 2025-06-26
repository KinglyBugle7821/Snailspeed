package net.numericalk.snailspeed.blocks.entity.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.blocks.custom.ResinBowlBlock;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.datagen.SnailBlockTagsProvider;
import org.jetbrains.annotations.Nullable;

public class ResinBowlBlockEntity extends BlockEntity {
    public ResinBowlBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.RESIN_BOWL_BLOCK_ENTITY, pos, state);
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

    private int progress = 0;
    private final int maxProgress = 20 * 60 * 5;
    public void tick(World world1, BlockPos pos, BlockState state) {
        if (hasTappedLog(world1, state, pos)){
            increaseProgress();
            if (hasProgressComplete()){
                world1.setBlockState(pos, state.with(ResinBowlBlock.HAS_RESIN, true));
                decayLog(world1, pos, state);
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    Block[][] decayingLog = {
            {SnailBlocks.TAPPED_SPRUCE_LOG, SnailBlocks.DECAYED_SPRUCE_LOG},
            {SnailBlocks.TAPPED_BIRCH_LOG, SnailBlocks.DECAYED_BIRCH_LOG},
            {SnailBlocks.TAPPED_PALE_OAK_LOG, SnailBlocks.DECAYED_PALE_OAK_LOG}
    };

    private void decayLog(World world1, BlockPos pos, BlockState state) {
        for (Block[] block : decayingLog){
            System.out.println("Decaying Log");
            if (state.get(ResinBowlBlock.FACING) == Direction.NORTH && world1.getBlockState(pos.south()).isOf(block[0])){
                world1.setBlockState(pos.south(), block[1].getStateWithProperties(state));
                System.out.println("Log Decayed");
            }
            if (state.get(ResinBowlBlock.FACING) == Direction.EAST && world1.getBlockState(pos.west()).isOf(block[0])){
                world1.setBlockState(pos.west(), block[1].getStateWithProperties(state));
                System.out.println("Log Decayed");
            }
            if (state.get(ResinBowlBlock.FACING) == Direction.SOUTH && world1.getBlockState(pos.north()).isOf(block[0])){
                world1.setBlockState(pos.north(), block[1].getStateWithProperties(state));
                System.out.println("Log Decayed");
            }
            if (state.get(ResinBowlBlock.FACING) == Direction.WEST && world1.getBlockState(pos.east()).isOf(block[0])){
                world1.setBlockState(pos.east(), block[1].getStateWithProperties(state));
                System.out.println("Log Decayed");
            }
        }
    }

    private boolean hasProgressComplete() {
        return progress >= maxProgress;
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void increaseProgress() {
        progress++;
    }

    private boolean hasTappedLog(World world1, BlockState state, BlockPos pos) {
        if (state.get(ResinBowlBlock.FACING) == Direction.NORTH){
            return world1.getBlockState(pos.south()).isIn(SnailBlockTagsProvider.TAPPED_LOGS);
        } else if (state.get(ResinBowlBlock.FACING) == Direction.EAST){
            return world1.getBlockState(pos.west()).isIn(SnailBlockTagsProvider.TAPPED_LOGS);
        } else if (state.get(ResinBowlBlock.FACING) == Direction.SOUTH){
            return world1.getBlockState(pos.north()).isIn(SnailBlockTagsProvider.TAPPED_LOGS);
        } else if (state.get(ResinBowlBlock.FACING) == Direction.WEST){
            return world1.getBlockState(pos.east()).isIn(SnailBlockTagsProvider.TAPPED_LOGS);
        }
        return false;
    }
}
