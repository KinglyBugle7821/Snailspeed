package net.numericalk.blocks.entity.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.blocks.custom.CampfireBlock;
import net.numericalk.blocks.entity.ImplementedInventory;
import net.numericalk.blocks.entity.SnailBlockEntities;
import org.jetbrains.annotations.Nullable;

public class CampfireBlockEntity extends BlockEntity implements ImplementedInventory {
    private int fireDegradeTime = 100;
    private final int fireDegradeTimeFinal = fireDegradeTime;

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);

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
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
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
        if (state.get(CampfireBlock.LIT) == 2 && fireDegradeTime > 0){
            fireDegradeTime --;
            System.out.println(fireDegradeTime);
        }
        if (state.get(CampfireBlock.LIT) == 2 && fireDegradeTime == 0){
            world1.setBlockState(pos, state.with(CampfireBlock.LIT, 1));
            setFireDegradeTime(fireDegradeTimeFinal);
            System.out.println(fireDegradeTime);
        }
    }
    private int calculateFireAddedTime() {
        return fireDegradeTime += ((fireDegradeTime/100) * 25);
    }

    public int getFireDegradeTime() {
        return fireDegradeTime;
    }

    public void setFireDegradeTime(int fireDegradeTime) {
        this.fireDegradeTime = fireDegradeTime;
    }
}
