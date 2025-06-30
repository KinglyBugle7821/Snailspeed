package net.numericalk.snailspeed.screen.custom;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import net.numericalk.snailspeed.blocks.entity.custom.ArmorForgeBlockEntity;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.screen.SnailScreenHandlers;

import java.util.Objects;

public class ArmorForgeScreenHandler extends ScreenHandler {
    private final Inventory inv;
    private final ArmorForgeBlockEntity be;
    private final BlockPos pos;

    public ArmorForgeScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId, inventory, Objects.requireNonNull(inventory.player.getWorld().getBlockEntity(pos)));
    }
    public BlockPos getBlockPos() {
        return pos;
    }
    public ArmorForgeScreenHandler(int syncId, PlayerInventory playerInventory,
                                   BlockEntity blockEntity) {
        super(SnailScreenHandlers.ARMOR_FORGE_SCREEN_HANDLER, syncId);
        this.inv = ((Inventory) blockEntity);
        this.pos = blockEntity.getPos();
        this.be = ((ArmorForgeBlockEntity) blockEntity);

        this.addSlot(new Slot(inv, ArmorForgeBlockEntity.PLATE_SLOT, 80, 7){
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(SnailItemTagsProvider.PLATES);
            }
        });
        this.addSlot(new Slot(inv, ArmorForgeBlockEntity.BINDING_SLOT, 53, 34) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(SnailItemTagsProvider.BINDERS);
            }
        });
        this.addSlot(new Slot(inv, ArmorForgeBlockEntity.FASTENER_SLOT, 107, 34){
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(SnailItemTagsProvider.FASTENERS);
            }
        });
        this.addSlot(new Slot(inv, ArmorForgeBlockEntity.TOOL_SLOT, 80, 61) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(SnailItemTagsProvider.HAMMERS);
            }
        });
        this.addSlot(new Slot(inv, ArmorForgeBlockEntity.OUTPUT, 80, 34){
            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                be.decrementInput(player);
                be.playForgingSound(player);
            }

            @Override
            public boolean canTakeItems(PlayerEntity playerEntity) {
                return true;
            }

            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (invSlot == ArmorForgeBlockEntity.OUTPUT) {
                be.decrementInput(player);
                be.playForgingSound(player);

                if (!this.insertItem(originalStack, this.inv.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickTransfer(originalStack, newStack);
            } else if (invSlot < this.inv.size()) {
                if (!this.insertItem(originalStack, this.inv.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.insertItem(originalStack, 0, this.inv.size(), false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inv.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
