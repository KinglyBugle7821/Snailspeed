package net.numericalk.snailspeed.blocks.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.custom.CustomLanternBlock;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import org.jetbrains.annotations.Nullable;

public class CustomLanternBlockEntity extends BlockEntity {
    public final float fireDegradeTimeFinal = 20f * 60f * 45f;
    private float fireDegradeTime = fireDegradeTimeFinal;

    public CustomLanternBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.LANTERN, pos, state);
    }

    public void tick(World world1, BlockPos pos, BlockState state) {
        if (state.get(CustomLanternBlock.LIT) == CustomLanternBlock.LIT_LIT){
            if (fireDegradeTime <= 0){
                world1.setBlockState(pos, state.with(CustomLanternBlock.LIT, CustomLanternBlock.LIT_ASH));
            } else {
                fireDegradeTime--;
            }
        }
    }

    public void calculateAddedFireTime() {
        fireDegradeTime += ((fireDegradeTimeFinal/100f) * 50f);
    }

    public float getFireDegradeTime() {
        return fireDegradeTime;
    }

    public void setFireDegradeTime(float fireDegradeTime) {
        this.fireDegradeTime = fireDegradeTime;
    }

    public float getFireDegradeTimeLimit() {
        return fireDegradeTimeFinal;
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
