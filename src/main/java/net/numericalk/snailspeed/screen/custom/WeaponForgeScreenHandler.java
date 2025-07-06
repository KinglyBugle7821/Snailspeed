package net.numericalk.snailspeed.screen.custom;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import net.numericalk.snailspeed.blocks.entity.custom.WeaponForgeBlockEntity;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.screen.SnailScreenHandlers;

import java.util.Objects;

public class WeaponForgeScreenHandler extends ScreenHandler {
    private final Inventory inv;
    private final WeaponForgeBlockEntity be;
    private final BlockPos pos;

    public WeaponForgeScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId, inventory, Objects.requireNonNull(inventory.player.getWorld().getBlockEntity(pos)));
    }
    public BlockPos getBlockPos() {
        return pos;
    }
    public WeaponForgeScreenHandler(int syncId, PlayerInventory playerInventory,
                                    BlockEntity blockEntity) {
        super(SnailScreenHandlers.WEAPON_FORGE_SCREEN_HANDLER, syncId);
        this.inv = ((Inventory) blockEntity);
        this.pos = blockEntity.getPos();
        this.be = ((WeaponForgeBlockEntity) blockEntity);

        this.addSlot(new Slot(inv, WeaponForgeBlockEntity.INPUT_HEAD, 44, 18));
        this.addSlot(new Slot(inv, WeaponForgeBlockEntity.INPUT_ADDITIONAL, 44, 54));
        this.addSlot(new Slot(inv, WeaponForgeBlockEntity.INPUT_GLUE, 26, 36) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(SnailItemTagsProvider.GLUES);
            }
        });

        this.addSlot(new Slot(inv, WeaponForgeBlockEntity.OUTPUT, 98, 36) {
            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                be.decrementInputNoPlayer();
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

            if (invSlot == WeaponForgeBlockEntity.OUTPUT) {
                if (!this.insertItem(originalStack, this.inv.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }

                be.decrementInputNoPlayer();
                be.playForgingSound(player);
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
