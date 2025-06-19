package net.numericalk.utils;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ItemScatterer;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.datagen.SnailBlockTagsProvider;
import net.numericalk.items.SnailItems;

public class SnailBreakEvents {
    static Object[][] StoneBlockCombo = {
            {Blocks.STONE, SnailBlocks.SCRATCHED_STONE, SnailBlocks.CRACKED_STONE, Blocks.COBBLESTONE, SnailBlocks.FRACTURED_STONE, SnailBlocks.CRUMBLED_STONE},
            {Blocks.DEEPSLATE, SnailBlocks.SCRATCHED_DEEPSLATE, SnailBlocks.CRACKED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE, SnailBlocks.FRACTURED_DEEPSLATE, SnailBlocks.CRUMBLED_DEEPSLATE}
    };

    public static void playerBreak(){
//        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
//            if (wgatIsTarget(SnailBlockTagsProvider.STONE_BLOCK, player, state)) {
//                if (playerHas(Items.FLINT, player)) {
//                    world.setBlockState(pos, SnailBlocks.SCRATCHED_STONE.getDefaultState());
//
//                    ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.PEBBLE.getDefaultStack());
//                    player.giveOrDropStack(SnailItems.FLINT_FLAKE.getDefaultStack());
//                    player.getMainHandStack().decrement(1);
//                }
//            }
//            return true;
//        });
    }

    private static boolean wgatIsTarget(TagKey<Block> targetBlockTag, PlayerEntity player, BlockState state) {
        return !player.isCreative() && state.isIn(targetBlockTag);
    }

    private static boolean playerHas(Item item, PlayerEntity player) {
        ItemStack mainHandItem = player.getMainHandStack();
        return mainHandItem.getItem() == item;
    }
}
