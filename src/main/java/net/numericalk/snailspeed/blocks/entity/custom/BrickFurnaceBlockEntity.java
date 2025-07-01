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
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.custom.BrickFurnaceBlock;
import net.numericalk.snailspeed.blocks.entity.ImplementedInventory;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;
import org.jetbrains.annotations.Nullable;

public class BrickFurnaceBlockEntity extends BlockEntity implements ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);

    public BrickFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.BRICK_FURNACE, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putFloat("FireTime", fireTime);
        nbt.putInt("CookTime", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        fireTime = nbt.getFloat("FireTime");
        progress = nbt.getInt("CookTime");
    }

    private final int INPUT_1 = 0;
    private final int INPUT_2 = 1;
    private final int INPUT_3 = 2;
    private final int INPUT_4 = 3;
    private final int INPUT_5 = 4;

    private int progress = 0;
    private int maxProgress;

    public float fireTime;
    public float maxFireTime = 20 * 60 * 10;
    public void tick(World world1, BlockPos pos, BlockState state) {

        for (int i = 0; i < 5; i++) {
            if (this.getStack(i).isOf(SnailItems.AIR)) {
                this.setStack(i, ItemStack.EMPTY);
            }
        }

        if (hasFuel() && isLit(state)) {
            decreaseFireTime();
            if (fireTime <= 0) {
                fireTime = 0;
                setLitState(0, world1, pos, state);
                this.getStack(5).decrement(1);
            } else if (fireTime <= 20 * 60 * 3 && state.get(BrickFurnaceBlock.LIT).equals(3)) {
                setLitState(2, world1, pos, state);
            }
        } else if (hasFuel()) {
            displayHasFuel(world1, pos, state);
            resetFireTime();
        }
        else {
            resetFireTime();
        }

        if (state.get(BrickFurnaceBlock.LIT).equals(2)) {
            maxProgress = 20 * 60 * 3;
            smeltItem(state, world1, pos, maxProgress);
        } else if (state.get(BrickFurnaceBlock.LIT).equals(3)) {
            maxProgress = 20 * 60;
            smeltItem(state, world1, pos, maxProgress);
        }
    }

    private void smeltItem(BlockState state, World world1, BlockPos pos, int maxProgress) {
        boolean matchedRecipe = false;

        for (Item[] items : smeltingRecipe) {
            Item input1 = items[0];
            Item input2 = items[1];
            Item input3 = items[2];
            Item input4 = items[3];
            Item input5 = items[4];
            Item output = items[5];

            if (getStack(INPUT_1).isOf(input1) &&
                    getStack(INPUT_2).isOf(input2) &&
                    getStack(INPUT_3).isOf(input3) &&
                    getStack(INPUT_4).isOf(input4) &&
                    getStack(INPUT_5).isOf(input5) &&
                    state.get(BrickFurnaceBlock.LID)) {

                matchedRecipe = true;
                progress++;
                spawnSmokeParticle(world1, pos, state);

                if (progress >= maxProgress) {
                    setStack(INPUT_1, new ItemStack(output));
                    setStack(INPUT_2, new ItemStack(output));
                    setStack(INPUT_3, new ItemStack(output));
                    setStack(INPUT_4, new ItemStack(output));
                    setStack(INPUT_5, new ItemStack(output));

                    progress = 0;

                    if (!world1.isClient) {
                        markDirty();
                        world1.updateListeners(pos, getCachedState(), getCachedState(), BrickFurnaceBlock.NOTIFY_ALL);
                    }
                }
                break;
            }
        }

        if (!matchedRecipe) {
            progress = 0;
        }
    }


    Item[][] smeltingRecipe ={
            {SnailItems.COPPER_NUGGET, SnailItems.COPPER_NUGGET, SnailItems.COPPER_NUGGET, SnailItems.COPPER_NUGGET, SnailItems.COPPER_NUGGET, SnailItems.MOLTEN_COPPER},
            {Items.IRON_NUGGET, Items.IRON_NUGGET, Items.IRON_NUGGET, Items.IRON_NUGGET, Items.IRON_NUGGET, SnailItems.MOLTEN_IRON},
            {Items.GOLD_NUGGET, Items.GOLD_NUGGET, Items.GOLD_NUGGET, Items.GOLD_NUGGET, Items.GOLD_NUGGET, SnailItems.MOLTEN_GOLD},
            {SnailItems.TIN_NUGGET, SnailItems.TIN_NUGGET, SnailItems.TIN_NUGGET, SnailItems.TIN_NUGGET, SnailItems.TIN_NUGGET, SnailItems.MOLTEN_TIN},
            {SnailItems.BRONZE_NUGGET, SnailItems.BRONZE_NUGGET, SnailItems.BRONZE_NUGGET, SnailItems.BRONZE_NUGGET, SnailItems.BRONZE_NUGGET, SnailItems.MOLTEN_BRONZE},
            {SnailItems.STEEL_CHUNK, SnailItems.STEEL_CHUNK, SnailItems.STEEL_CHUNK, Items.AIR, Items.AIR, SnailItems.MOLTEN_STEEL},
            {SnailItems.COPPER_NUGGET, SnailItems.COPPER_NUGGET, SnailItems.COPPER_NUGGET, SnailItems.COPPER_NUGGET, SnailItems.TIN_NUGGET, SnailItems.MOLTEN_BRONZE},
            {Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.DIAMOND, Items.DIAMOND, SnailItems.MOLTEN_STEEL},

            {Items.COPPER_INGOT, Items.AIR, Items.AIR, Items.AIR, Items.AIR, SnailItems.MOLTEN_COPPER},
            {Items.IRON_INGOT, Items.AIR, Items.AIR, Items.AIR, Items.AIR, SnailItems.MOLTEN_IRON},
            {Items.GOLD_INGOT, Items.AIR, Items.AIR, Items.AIR, Items.AIR, SnailItems.MOLTEN_GOLD},
            {SnailItems.TIN_INGOT, Items.AIR, Items.AIR, Items.AIR, Items.AIR, SnailItems.MOLTEN_TIN},
            {SnailItems.BRONZE_INGOT, Items.AIR, Items.AIR, Items.AIR, Items.AIR, SnailItems.MOLTEN_BRONZE},
            {SnailItems.STEEL_INGOT, Items.AIR, Items.AIR, Items.AIR, Items.AIR, SnailItems.MOLTEN_STEEL}
    };

    private void spawnSmokeParticle(World world1, BlockPos pos, BlockState state) {
        if (!world1.isClient) {
            ((ServerWorld) world1).spawnParticles(
                    ParticleTypes.SMOKE,
                    pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5,
                    1,
                    0, 0.2, 0,
                    0.01
            );
        }
    }

    private void resetFireTime() {
        if (this.getStack(5).isIn(SnailItemTagsProvider.CAMPFIRE_FUEL)) {
            fireTime = 20 * 30;
        } else if (this.getStack(5).isIn(SnailItemTagsProvider.OVEN_FUEL)) {
            fireTime = 20 * 60;
        }
    }

    private void displayHasFuel(World world1, BlockPos pos, BlockState state) {
        world1.setBlockState(pos, state.with(BrickFurnaceBlock.LIT, 1));
    }

    private void setLitState(int lit, World world1, BlockPos pos, BlockState state) {
        world1.setBlockState(pos, state.with(BrickFurnaceBlock.LIT, lit));
    }

    private void decreaseFireTime() {
        fireTime = Math.max(0, fireTime - 1);
    }

    private boolean isLit(BlockState state) {
        return state.get(BrickFurnaceBlock.LIT) >= 2;
    }

    private boolean hasFuel() {
        return !this.getStack(5).isEmpty();
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public void calculatedAddedFireTime(TagKey<Item> fuelType) {
        if (fuelType == SnailItemTagsProvider.CAMPFIRE_FUEL) {
            fireTime += ((1200f/100f) * 50f);
        } else if (fuelType == SnailItemTagsProvider.OVEN_FUEL) {
            fireTime += ((2400f/100f) * 50f);
        }
    }

    public float getMaxFireTime() {
        return maxFireTime;
    }

    public float getFireTime() {
        return fireTime;
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
