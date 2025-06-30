package net.numericalk.snailspeed.blocks.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.entity.ImplementedInventory;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.screen.custom.ArmorForgeScreen;
import net.numericalk.snailspeed.screen.custom.ArmorForgeScreenHandler;
import net.numericalk.snailspeed.utils.enums.ArmorPiece;
import org.jetbrains.annotations.Nullable;

public class ArmorForgeBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    public static final int PLATE_SLOT = 0;
    public static final int BINDING_SLOT = 1;
    public static final int FASTENER_SLOT = 2;
    public static final int TOOL_SLOT = 3;
    public static final int OUTPUT = 4;

    public ArmorForgeBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.ARMOR_FORGE_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        super.readNbt(nbt, registryLookup);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.snailspeed.armor_forge");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ArmorForgeScreenHandler(syncId, playerInventory, this);
    }

    public void tick(World world1, BlockPos pos, BlockState state) {
        System.out.println(hasRecipe());
        if (hasRecipe()){
            askToCreateArmor(world1);
        } else {
            removeStack(OUTPUT);
        }
    }

    private final int plate_helmet = 3;
    private final int plate_chestplate = 5;
    private final int plate_leggings = 4;
    private final int plate_boots = 2;

    private final int binding_helmet = 2;
    private final int binding_chestplate = 4;
    private final int binding_leggings = 3;
    private final int binding_boots = 1;

    private final int fastener_helmet = 4;
    private final int fastener_chestplate = 7;
    private final int fastener_leggings = 5;
    private final int fastener_boots = 3;

    Item[][] armorRecipe = {
            {SnailItems.COPPER_PLATE, SnailItems.LEATHER_STRIP, SnailItems.COPPER_RIVET, SnailItems.COPPER_HAMMER, SnailItems.COPPER_HELMET, SnailItems.COPPER_CHESTPLATE, SnailItems.COPPER_LEGGINGS, SnailItems.COPPER_BOOTS},
            {SnailItems.BRONZE_PLATE, SnailItems.LEATHER_STRIP, SnailItems.IRON_BOLT, SnailItems.COPPER_HAMMER, SnailItems.BRONZE_HELMET, SnailItems.BRONZE_CHESTPLATE, SnailItems.BRONZE_LEGGINGS, SnailItems.BRONZE_BOOTS},
            {SnailItems.GOLDEN_PLATE, SnailItems.LEATHER_STRIP, SnailItems.IRON_BOLT, SnailItems.COPPER_HAMMER, Items.GOLDEN_HELMET, Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS, Items.GOLDEN_BOOTS},
            {SnailItems.IRON_PLATE, SnailItems.LEATHER_STRIP, SnailItems.IRON_BOLT, SnailItems.IRON_HAMMER, Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS},
            {SnailItems.STEEL_PLATE, SnailItems.CHAIN_LINKS, SnailItems.IRON_BOLT, SnailItems.IRON_HAMMER, SnailItems.STEEL_HELMET, SnailItems.STEEL_CHESTPLATE, SnailItems.STEEL_LEGGINGS, SnailItems.STEEL_BOOTS},
    };

    ArmorPiece selected = ArmorPiece.HELMET;

    public void setSelectedPiece(ArmorPiece selected) {
        this.selected = selected;
    }
    private boolean hasRecipe() {
        for (Item[] armorPiece : armorRecipe) {
            Item plate = armorPiece[0];
            Item binding = armorPiece[1];
            Item fastener = armorPiece[2];
            Item tool = armorPiece[3];

            if (selected == ArmorPiece.HELMET) {
                if (getOutputOf(plate, binding, fastener, tool, plate_helmet, binding_helmet, fastener_helmet)) {
                    return true;
                }
            } else if (selected == ArmorPiece.CHESTPLATE) {
                if (getOutputOf(plate, binding, fastener, tool, plate_chestplate, binding_chestplate, fastener_chestplate)) {
                    return true;
                }
            } else if (selected == ArmorPiece.LEGGINGS) {
                if (getOutputOf(plate, binding, fastener, tool, plate_leggings, binding_leggings, fastener_leggings)) {
                    return true;
                }
            } else if (selected == ArmorPiece.BOOTS) {
                if (getOutputOf(plate, binding, fastener, tool, plate_boots, binding_boots, fastener_boots)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void askToCreateArmor(World world) {
        for (Item[] armorPiece : armorRecipe){
            Item plate = armorPiece[0];
            Item binding = armorPiece[1];
            Item fastener = armorPiece[2];
            Item tool = armorPiece[3];
            Item helmet = armorPiece[4];
            Item chestplate = armorPiece[5];
            Item leggings = armorPiece[6];
            Item boots = armorPiece[7];

            switch (selected){
                case HELMET -> setOutputOf(helmet, plate, binding, fastener, tool, plate_helmet, binding_helmet, fastener_helmet, world);
                case CHESTPLATE -> setOutputOf(chestplate, plate, binding, fastener, tool, plate_chestplate, binding_chestplate, fastener_chestplate, world);
                case LEGGINGS -> setOutputOf(leggings, plate, binding, fastener, tool, plate_leggings, binding_leggings, fastener_leggings, world);
                case BOOTS -> setOutputOf(boots, plate, binding, fastener, tool, plate_boots, binding_boots, fastener_boots, world);
            }
        }
    }

    private void setOutputOf(Item item, Item plate, Item binding, Item fastener, Item tool, int plateCount, int bindingCount, int fastenerCount, World world) {
        ItemStack plateSlot = this.getStack(PLATE_SLOT);
        ItemStack bindingSlot = this.getStack(BINDING_SLOT);
        ItemStack fastenerSlot = this.getStack(FASTENER_SLOT);
        ItemStack toolSlot = this.getStack(TOOL_SLOT);
        if ((plateSlot.isOf(plate) && plateSlot.getCount() >= plateCount) &&
                (bindingSlot.isOf(binding) && bindingSlot.getCount() >= bindingCount) &&
                (fastenerSlot.isOf(fastener) && fastenerSlot.getCount() >= fastenerCount) &&
                (toolSlot.isOf(tool))){
            this.setStack(OUTPUT, item.getDefaultStack());
        }
    }
    private boolean getOutputOf(Item plate, Item binding, Item fastener, Item tool, int plateCount, int bindingCount, int fastenerCount) {
        ItemStack plateSlot = this.getStack(PLATE_SLOT);
        ItemStack bindingSlot = this.getStack(BINDING_SLOT);
        ItemStack fastenerSlot = this.getStack(FASTENER_SLOT);
        ItemStack toolSlot = this.getStack(TOOL_SLOT);
        return (plateSlot.isOf(plate) && (plateSlot.getCount() >= plateCount)) &&
                (bindingSlot.isOf(binding) && (bindingSlot.getCount() >= bindingCount)) &&
                (fastenerSlot.isOf(fastener) && (fastenerSlot.getCount() >= fastenerCount)) && (toolSlot.isOf(tool));
    }

    public void decrementInput(PlayerEntity player) {
        if (selected.equals(ArmorPiece.HELMET)){
            this.getStack(PLATE_SLOT).decrement(plate_helmet);
            this.getStack(BINDING_SLOT).decrement(binding_helmet);
            this.getStack(FASTENER_SLOT).decrement(fastener_helmet);
            this.getStack(TOOL_SLOT).damage(1, player);
            markDirty();
        } else if (selected.equals(ArmorPiece.CHESTPLATE)){
            this.getStack(PLATE_SLOT).decrement(plate_chestplate);
            this.getStack(BINDING_SLOT).decrement(binding_chestplate);
            this.getStack(FASTENER_SLOT).decrement(fastener_chestplate);
            this.getStack(TOOL_SLOT).damage(1, player);
            markDirty();
        } else if (selected.equals(ArmorPiece.LEGGINGS)){
            this.getStack(PLATE_SLOT).decrement(plate_leggings);
            this.getStack(BINDING_SLOT).decrement(binding_leggings);
            this.getStack(FASTENER_SLOT).decrement(fastener_leggings);
            this.getStack(TOOL_SLOT).damage(1, player);
            markDirty();
        } else if (selected.equals(ArmorPiece.BOOTS)){
            this.getStack(PLATE_SLOT).decrement(plate_boots);
            this.getStack(BINDING_SLOT).decrement(binding_boots);
            this.getStack(FASTENER_SLOT).decrement(fastener_boots);
            this.getStack(TOOL_SLOT).damage(1, player);
            markDirty();
        }
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

    public void playForgingSound(PlayerEntity player) {
        World world1 = player.getWorld();
        BlockPos pos = player.getBlockPos();
        world1.playSound(player, pos, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS, 1f, 1f);
    }
}