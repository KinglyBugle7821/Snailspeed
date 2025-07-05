package net.numericalk.snailspeed.blocks.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.custom.CustomTorchBlock;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import org.jetbrains.annotations.Nullable;

public class CustomWallTorchBlockEntity extends BlockEntity {
    public CustomWallTorchBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.WALL_TORCH, pos, state);
    }

    private final float fireDegradeTimeFinal = 20f * 60f * 30f;
    private float fireDegradeTime = fireDegradeTimeFinal;

    public void tick(World world1, BlockPos pos, BlockState state) {
        if (fireDegradeTime <= 0){
            world1.setBlockState(pos, state.with(CustomTorchBlock.LIT, CustomTorchBlock.LIT_ASH));
        }
        fireDegradeTime--;
        if ((world1.isRaining() || world1.isThundering()) && world1.isSkyVisible(pos)){
            world1.setBlockState(pos, state.with(CustomTorchBlock.LIT, CustomTorchBlock.LIT_UNLIT));
            setFireDegradeTime(fireDegradeTimeFinal);
        }
    }
    public void setFireDegradeTime(float fireDegradeTime) {
        this.fireDegradeTime = fireDegradeTime;
    }
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putFloat("FireDegradeTime", fireDegradeTime);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
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
}
