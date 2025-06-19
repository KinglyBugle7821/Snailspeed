package net.numericalk.blocks.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.blocks.custom.CampfireBlock;
import net.numericalk.blocks.entity.SnailBlockEntities;
import org.jetbrains.annotations.Nullable;

import static net.numericalk.blocks.custom.CampfireBlock.LIT;
import static net.numericalk.blocks.custom.CampfireBlock.STAGES;

public class DriedClayBrickBlockEntity extends BlockEntity {
    public DriedClayBrickBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.DRIED_CLAY_BLOCK_ENTITY, pos, state);
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
    private final int maxDryTime = 20 * 60 * 2;

    public void tick(World world1, BlockPos pos, BlockState state) {
        if (isDriedClayBrick(state)){
            if (isBesideCampfire(world1, pos) && !isRaining(world1)){
                if (hasProgressComplete()){
                    fireClayBrick(world1, pos, state);
                }
                increaseProgress();
                spawnSmokeParticle(world1, pos);
            }
            else if (!isBesideCampfire(world1, pos)){
                pauseProgress();
            }
            else if (isRaining(world1)){
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private boolean isBesideCampfire(World world, BlockPos pos) {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockPos offsetPos = pos.offset(direction);
            BlockState neighborState = world.getBlockState(offsetPos);
            if (neighborState.isOf(SnailBlocks.CAMPFIRE_BASE) && neighborState.get(LIT).equals(4)) {
                System.out.println(direction.getName() + " side is lit campfire");
                return true;
            }
        }
        return false;
    }


    private void spawnSmokeParticle(World world1, BlockPos pos) {
        if (!world1.isClient){
            ((ServerWorld) world1).spawnParticles(
                    ParticleTypes.WHITE_SMOKE,
                    pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5,
                    1,
                    0.2, 0, 0.2,
                    0.001
            );
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

    private void fireClayBrick(World world1, BlockPos pos, BlockState state) {
        if (world1.isClient()){
            return;
        }
        world1.setBlockState(pos, SnailBlocks.FIRED_BRICK.getStateWithProperties(state));
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

    private boolean isDriedClayBrick(BlockState state1) {
        return state1.isOf(SnailBlocks.DRIED_CLAY_BRICK);
    }
}
