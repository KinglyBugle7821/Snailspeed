package net.numericalk.snailspeed.blocks.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import org.jetbrains.annotations.Nullable;

import static net.numericalk.snailspeed.blocks.custom.CampfireBlock.LIT;

public class DriedClayCrucibleBlockEntity extends BlockEntity {
    public DriedClayCrucibleBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.DRIED_CLAY_CRUCIBLE, pos, state);
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
        if (isDriedClayCrucible(state)) {
            if (isRaining(world1, pos) && world1.isSkyVisible(pos)) {
                resetProgress();
            } else if (isBesideCampfire(world1, pos)) {
                if (hasProgressComplete()) {
                    fireClayCrucible(world1, pos, state);
                }
                increaseProgress();
                spawnSmokeParticle(world1, pos);
            }
            else if (!isBesideCampfire(world1, pos)) {
                pauseProgress();
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
                return true;
            }
        }
        return false;
    }


    private void spawnSmokeParticle(World world1, BlockPos pos) {
        if (!world1.isClient) {
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

    private void fireClayCrucible(World world1, BlockPos pos, BlockState state) {
        if (world1.isClient()) {
            return;
        }
        world1.setBlockState(pos, SnailBlocks.CRUCIBLE.getStateWithProperties(state));
    }

    private boolean hasProgressComplete() {
        return dryTimeRemaining >= maxDryTime;
    }

    private boolean isRaining(World world1, BlockPos pos) {
        return (world1.isRaining() || world1.isThundering()) && !isBiomeHot(world1, pos);
    }
    private boolean isBiomeHot(World world, BlockPos pos){
        RegistryEntry<Biome> biome = world.getBiome(pos);
        Biome.Precipitation precipitation = biome.value().getPrecipitation(pos, 62);
        return precipitation == Biome.Precipitation.NONE;
    }
    private boolean isDriedClayCrucible(BlockState state1) {
        return state1.isOf(SnailBlocks.DRIED_CLAY_CRUCIBLE);
    }
}
