package net.numericalk.snailspeed.blocks.entity.custom;

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
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.custom.FilteringTrayBlock;
import net.numericalk.snailspeed.blocks.entity.ImplementedInventory;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;
import org.jetbrains.annotations.Nullable;

public class FilteringTrayBlockEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    public FilteringTrayBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.FILTERING_TRAY_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("Progress", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("Progress");
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
        filterItem(world1, pos, state);

        if (this.getStack(4).isIn(SnailItemTagsProvider.FILTERS)){
            world1.setBlockState(pos, state.with(FilteringTrayBlock.HAS_FILTER, true));
        } else {
            world1.setBlockState(pos, state.with(FilteringTrayBlock.HAS_FILTER, false));
        }
    }
    Item[][] filteringRecipe ={
            {SnailItems.GROUND_GRAPHITE, Items.CLAY_BALL, Items.AIR, Items.AIR, SnailItems.REFINED_GRAPHITE}
    };
    private final int INPUT_1 = 0;
    private final int INPUT_2 = 1;
    private final int INPUT_3 = 2;
    private final int INPUT_4 = 3;

    private int progress = 0;
    private int maxProgress = 20 * 60 * 3;
    private void filterItem(World world1, BlockPos pos, BlockState state) {
        boolean matchedRecipe = false;

        for (Item[] items : filteringRecipe){
            Item input1 = items[0];
            Item input2 = items[1];
            Item input3 = items[2];
            Item input4 = items[3];
            Item output = items[4];

            if (getStack(INPUT_1).isOf(input1) &&
                    getStack(INPUT_2).isOf(input2) &&
                    getStack(INPUT_3).isOf(input3) &&
                    getStack(INPUT_4).isOf(input4) &&
                    state.get(FilteringTrayBlock.HAS_FILTER)) {

                matchedRecipe = true;
                progress++;
                spawnWaterParticle(world1, pos, state);

                if (progress >= maxProgress) {
                    world1.updateListeners(pos, getCachedState(), getCachedState(), FilteringTrayBlock.NOTIFY_ALL);
                    setStack(INPUT_1, new ItemStack(output));
                    setStack(INPUT_2, new ItemStack(SnailItems.AIR));
                    setStack(INPUT_3, new ItemStack(SnailItems.AIR));
                    setStack(INPUT_4, new ItemStack(SnailItems.AIR));

                    world1.updateListeners(pos, getCachedState(), getCachedState(), FilteringTrayBlock.NOTIFY_ALL);

                    progress = 0;
                }
                break;
            }
        }

        if (!matchedRecipe) {
            progress = 0;
        }
    }

    private void spawnWaterParticle(World world1, BlockPos pos, BlockState state) {
        if (!world1.isClient){
            ((ServerWorld) world1).spawnParticles(
                    ParticleTypes.DRIPPING_WATER,
                    pos.getX() + 0.5, pos.getY() + 0.7, pos.getZ() + 0.5,
                    1,
                    0.2, 0, 0.2,
                    0.01
            );
        }
    }
}
