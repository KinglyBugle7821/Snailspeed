package net.numericalk.utils;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItems;

public class SnailBreakEvents {
    public static void playerBreak(){
        PlayerBlockBreakEvents.AFTER.register((world, playerEntity, blockPos, blockState, blockEntity) -> {
            if (!playerEntity.isCreative() && blockState.isOf(Blocks.STONE)) {
                ItemStack mainHandItem = playerEntity.getMainHandStack();

                if (mainHandItem.getItem() == Items.FLINT) {
                    world.setBlockState(blockPos, SnailBlocks.SCRATCHED_STONE.getDefaultState());

                    playerEntity.giveOrDropStack(SnailItems.FLINT_FLAKE.getDefaultStack());
                    playerEntity.getMainHandStack().decrement(1);
                }
            }
        });
    }
}
