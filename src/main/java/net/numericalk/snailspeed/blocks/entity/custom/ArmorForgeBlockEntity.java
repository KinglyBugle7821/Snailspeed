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
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.entity.ImplementedInventory;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.screen.custom.ArmorForgeScreen;
import net.numericalk.snailspeed.screen.custom.ArmorForgeScreenHandler;
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
        if (hasRecipe()){
            askToCreateArmor();
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

    private void askToCreateArmor() {
        var screen = MinecraftClient.getInstance().currentScreen;
        if (screen instanceof ArmorForgeScreen forgeScreen) {
            ArmorForgeScreen.ArmorPiece selected = forgeScreen.getSelectedPiece();
            for (Item[] armorPiece : armorRecipe){
                Item plate = armorPiece[0];
                Item binding = armorPiece[1];
                Item fastener = armorPiece[2];
                Item tool = armorPiece[3];
                Item helmet = armorPiece[4];
                Item chestplate = armorPiece[5];
                Item leggings = armorPiece[6];
                Item boots = armorPiece[7];

                ItemStack plateSlot = this.getStack(PLATE_SLOT);
                ItemStack bindingSlot = this.getStack(BINDING_SLOT);
                ItemStack fastenerSlot = this.getStack(FASTENER_SLOT);
                ItemStack toolSlot = this.getStack(TOOL_SLOT);
                if (selected.equals(ArmorForgeScreen.ArmorPiece.HELMET)){
                    if ((plateSlot.isOf(plate) && plateSlot.getCount() >= plate_helmet) &&
                            (bindingSlot.isOf(binding) && bindingSlot.getCount() >= binding_helmet) &&
                            (fastenerSlot.isOf(fastener) && fastenerSlot.getCount() >= fastener_helmet) &&
                            (toolSlot.isOf(tool))){
                        setStack(OUTPUT, helmet.getDefaultStack());
                    }
                } else if (selected.equals(ArmorForgeScreen.ArmorPiece.CHESTPLATE)){
                    if ((plateSlot.isOf(plate) && plateSlot.getCount() >= plate_chestplate) &&
                            (bindingSlot.isOf(binding) && bindingSlot.getCount() >= binding_chestplate) &&
                            (fastenerSlot.isOf(fastener) && fastenerSlot.getCount() >= fastener_chestplate) &&
                            (toolSlot.isOf(tool))){
                        setStack(OUTPUT, chestplate.getDefaultStack());
                    }
                } else if (selected.equals(ArmorForgeScreen.ArmorPiece.LEGGINGS)){
                    if ((plateSlot.isOf(plate) && plateSlot.getCount() >= plate_leggings) &&
                            (bindingSlot.isOf(binding) && bindingSlot.getCount() >= binding_leggings) &&
                            (fastenerSlot.isOf(fastener) && fastenerSlot.getCount() >= fastener_leggings) &&
                            (toolSlot.isOf(tool))){
                        setStack(OUTPUT, leggings.getDefaultStack());
                    }
                } else if (selected.equals(ArmorForgeScreen.ArmorPiece.BOOTS)){
                    if ((plateSlot.isOf(plate) && plateSlot.getCount() >= plate_boots) &&
                            (bindingSlot.isOf(binding) && bindingSlot.getCount() >= binding_boots) &&
                            (fastenerSlot.isOf(fastener) && fastenerSlot.getCount() >= fastener_boots) &&
                            (toolSlot.isOf(tool))){
                        setStack(OUTPUT, boots.getDefaultStack());
                    }
                }
            }
        }
    }

    private boolean hasRecipe() {
        var screen = MinecraftClient.getInstance().currentScreen;
        if (screen instanceof ArmorForgeScreen forgeScreen) {
            ArmorForgeScreen.ArmorPiece selected = forgeScreen.getSelectedPiece();
            for (Item[] armorPiece : armorRecipe){
                Item plate = armorPiece[0];
                Item binding = armorPiece[1];
                Item fastener = armorPiece[2];
                Item tool = armorPiece[3];

                ItemStack plateSlot = this.getStack(PLATE_SLOT);
                ItemStack bindingSlot = this.getStack(BINDING_SLOT);
                ItemStack fastenerSlot = this.getStack(FASTENER_SLOT);
                ItemStack toolSlot = this.getStack(TOOL_SLOT);
                if (selected.equals(ArmorForgeScreen.ArmorPiece.HELMET)){
                    if ((plateSlot.isOf(plate) && plateSlot.getCount() >= plate_helmet) &&
                            (bindingSlot.isOf(binding) && bindingSlot.getCount() >= binding_helmet) &&
                            (fastenerSlot.isOf(fastener) && fastenerSlot.getCount() >= fastener_helmet) &&
                            (toolSlot.isOf(tool))){
                        return true;
                    }
                } else if (selected.equals(ArmorForgeScreen.ArmorPiece.CHESTPLATE)){
                    if ((plateSlot.isOf(plate) && plateSlot.getCount() >= plate_chestplate) &&
                            (bindingSlot.isOf(binding) && bindingSlot.getCount() >= binding_chestplate) &&
                            (fastenerSlot.isOf(fastener) && fastenerSlot.getCount() >= fastener_chestplate) &&
                            (toolSlot.isOf(tool))){
                        return true;
                    }
                } else if (selected.equals(ArmorForgeScreen.ArmorPiece.LEGGINGS)){
                    if ((plateSlot.isOf(plate) && plateSlot.getCount() >= plate_leggings) &&
                            (bindingSlot.isOf(binding) && bindingSlot.getCount() >= binding_leggings) &&
                            (fastenerSlot.isOf(fastener) && fastenerSlot.getCount() >= fastener_leggings) &&
                            (toolSlot.isOf(tool))){
                        return true;
                    }
                } else if (selected.equals(ArmorForgeScreen.ArmorPiece.BOOTS)){
                    if ((plateSlot.isOf(plate) && plateSlot.getCount() >= plate_boots) &&
                            (bindingSlot.isOf(binding) && bindingSlot.getCount() >= binding_boots) &&
                            (fastenerSlot.isOf(fastener) && fastenerSlot.getCount() >= fastener_boots) &&
                            (toolSlot.isOf(tool))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void decrementInput(PlayerEntity player) {
        var screen = MinecraftClient.getInstance().currentScreen;

        if (screen instanceof ArmorForgeScreen forgeScreen) {
            ArmorForgeScreen.ArmorPiece selected = forgeScreen.getSelectedPiece();
            if (selected.equals(ArmorForgeScreen.ArmorPiece.HELMET)){
                this.getStack(PLATE_SLOT).decrement(plate_helmet);
                this.getStack(BINDING_SLOT).decrement(binding_helmet);
                this.getStack(FASTENER_SLOT).decrement(fastener_helmet);
                this.getStack(TOOL_SLOT).damage(1, player);
                markDirty();
            } else if (selected.equals(ArmorForgeScreen.ArmorPiece.CHESTPLATE)){
                this.getStack(PLATE_SLOT).decrement(plate_chestplate);
                this.getStack(BINDING_SLOT).decrement(binding_chestplate);
                this.getStack(FASTENER_SLOT).decrement(fastener_chestplate);
                this.getStack(TOOL_SLOT).damage(1, player);
                markDirty();
            } else if (selected.equals(ArmorForgeScreen.ArmorPiece.LEGGINGS)){
                this.getStack(PLATE_SLOT).decrement(plate_leggings);
                this.getStack(BINDING_SLOT).decrement(binding_leggings);
                this.getStack(FASTENER_SLOT).decrement(fastener_leggings);
                this.getStack(TOOL_SLOT).damage(1, player);
                markDirty();
            } else if (selected.equals(ArmorForgeScreen.ArmorPiece.BOOTS)){
                this.getStack(PLATE_SLOT).decrement(plate_boots);
                this.getStack(BINDING_SLOT).decrement(binding_boots);
                this.getStack(FASTENER_SLOT).decrement(fastener_boots);
                this.getStack(TOOL_SLOT).damage(1, player);
                markDirty();
            }
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
}
