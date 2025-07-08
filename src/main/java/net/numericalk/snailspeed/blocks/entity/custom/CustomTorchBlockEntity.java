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
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.numericalk.snailspeed.blocks.custom.CustomTorchBlock;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import org.jetbrains.annotations.Nullable;

public class CustomTorchBlockEntity extends BlockEntity {
    public final float fireDegradeTimeFinal = 20f * 60f * 30f;
    private float fireDegradeTime = fireDegradeTimeFinal;

    public CustomTorchBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.TORCH, pos, state);
    }

    public void tick(World world1, BlockPos pos, BlockState state) {
        if (state.get(CustomTorchBlock.LIT) == CustomTorchBlock.LIT_LIT){
            if (fireDegradeTime <= 0){
                world1.setBlockState(pos, state.with(CustomTorchBlock.LIT, CustomTorchBlock.LIT_ASH));
                setFireDegradeTime(fireDegradeTimeFinal);
            } else {
                fireDegradeTime--;
            }
            if (((world1.isRaining() || world1.isThundering()) && !isBiomeHot(world1, pos)) && world1.isSkyVisible(pos)){
                world1.setBlockState(pos, state.with(CustomTorchBlock.LIT, CustomTorchBlock.LIT_UNLIT));
                setFireDegradeTime(fireDegradeTimeFinal);
            }
        }
    }
    private boolean isBiomeHot(World world, BlockPos pos){
        RegistryEntry<Biome> biome = world.getBiome(pos);
        Biome.Precipitation precipitation = biome.value().getPrecipitation(pos, 62);
        return precipitation == Biome.Precipitation.NONE;
    }
    public void setFireDegradeTime(int fireDegradeTime){
        this.fireDegradeTime = fireDegradeTime;
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
