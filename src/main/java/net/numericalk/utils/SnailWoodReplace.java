package net.numericalk.utils;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.numericalk.blocks.SnailBlocks;

public class SnailWoodReplace {
    public static void replaceWoodBlock() {

        Object[][] logToTrimmed = {
                {Blocks.OAK_LOG, SnailBlocks.TRIMMED_OAK_LOG},
                {Blocks.STRIPPED_OAK_LOG, SnailBlocks.TRIMMED_OAK_LOG},
                {Blocks.SPRUCE_LOG, SnailBlocks.TRIMMED_SPRUCE_LOG},
                {Blocks.STRIPPED_SPRUCE_LOG, SnailBlocks.TRIMMED_SPRUCE_LOG},
                {Blocks.BIRCH_LOG, SnailBlocks.TRIMMED_BIRCH_LOG},
                {Blocks.STRIPPED_BIRCH_LOG, SnailBlocks.TRIMMED_BIRCH_LOG},
                {Blocks.JUNGLE_LOG, SnailBlocks.TRIMMED_JUNGLE_LOG},
                {Blocks.STRIPPED_JUNGLE_LOG, SnailBlocks.TRIMMED_JUNGLE_LOG},
                {Blocks.ACACIA_LOG, SnailBlocks.TRIMMED_ACACIA_LOG},
                {Blocks.STRIPPED_ACACIA_LOG, SnailBlocks.TRIMMED_ACACIA_LOG},
                {Blocks.DARK_OAK_LOG, SnailBlocks.TRIMMED_DARK_OAK_LOG},
                {Blocks.STRIPPED_DARK_OAK_LOG, SnailBlocks.TRIMMED_DARK_OAK_LOG},
                {Blocks.MANGROVE_LOG, SnailBlocks.TRIMMED_MANGROVE_LOG},
                {Blocks.STRIPPED_MANGROVE_LOG, SnailBlocks.TRIMMED_MANGROVE_LOG},
                {Blocks.CHERRY_LOG, SnailBlocks.TRIMMED_CHERRY_LOG},
                {Blocks.STRIPPED_CHERRY_LOG, SnailBlocks.TRIMMED_CHERRY_LOG},
                {Blocks.PALE_OAK_LOG, SnailBlocks.TRIMMED_PALE_OAK_LOG},
                {Blocks.STRIPPED_PALE_OAK_LOG, SnailBlocks.TRIMMED_PALE_OAK_LOG},
                {Blocks.CRIMSON_STEM, SnailBlocks.TRIMMED_CRIMSON_STEM},
                {Blocks.STRIPPED_CRIMSON_STEM, SnailBlocks.TRIMMED_CRIMSON_STEM},
                {Blocks.WARPED_STEM, SnailBlocks.TRIMMED_WARPED_STEM},
                {Blocks.STRIPPED_WARPED_STEM, SnailBlocks.TRIMMED_WARPED_STEM}
        };
        Object[][] woodToTrimmed = {
                {Blocks.OAK_WOOD, SnailBlocks.TRIMMED_OAK_LOG},
                {Blocks.STRIPPED_OAK_WOOD, SnailBlocks.TRIMMED_OAK_LOG},
                {Blocks.SPRUCE_WOOD, SnailBlocks.TRIMMED_SPRUCE_LOG},
                {Blocks.STRIPPED_SPRUCE_WOOD, SnailBlocks.TRIMMED_SPRUCE_LOG},
                {Blocks.BIRCH_WOOD, SnailBlocks.TRIMMED_BIRCH_LOG},
                {Blocks.STRIPPED_BIRCH_WOOD, SnailBlocks.TRIMMED_BIRCH_LOG},
                {Blocks.JUNGLE_WOOD, SnailBlocks.TRIMMED_JUNGLE_LOG},
                {Blocks.STRIPPED_JUNGLE_WOOD, SnailBlocks.TRIMMED_JUNGLE_LOG},
                {Blocks.ACACIA_WOOD, SnailBlocks.TRIMMED_ACACIA_LOG},
                {Blocks.STRIPPED_ACACIA_WOOD, SnailBlocks.TRIMMED_ACACIA_LOG},
                {Blocks.DARK_OAK_WOOD, SnailBlocks.TRIMMED_DARK_OAK_LOG},
                {Blocks.STRIPPED_DARK_OAK_WOOD, SnailBlocks.TRIMMED_DARK_OAK_LOG},
                {Blocks.MANGROVE_WOOD, SnailBlocks.TRIMMED_MANGROVE_LOG},
                {Blocks.STRIPPED_MANGROVE_WOOD, SnailBlocks.TRIMMED_MANGROVE_LOG},
                {Blocks.CHERRY_WOOD, SnailBlocks.TRIMMED_CHERRY_LOG},
                {Blocks.STRIPPED_CHERRY_WOOD, SnailBlocks.TRIMMED_CHERRY_LOG},
                {Blocks.PALE_OAK_WOOD, SnailBlocks.TRIMMED_PALE_OAK_LOG},
                {Blocks.STRIPPED_PALE_OAK_WOOD, SnailBlocks.TRIMMED_PALE_OAK_LOG},
                {Blocks.CRIMSON_HYPHAE, SnailBlocks.TRIMMED_CRIMSON_STEM},
                {Blocks.STRIPPED_CRIMSON_HYPHAE, SnailBlocks.TRIMMED_CRIMSON_STEM},
                {Blocks.WARPED_HYPHAE, SnailBlocks.TRIMMED_WARPED_STEM},
                {Blocks.STRIPPED_WARPED_HYPHAE, SnailBlocks.TRIMMED_WARPED_STEM}
        };
        Object[][] trimmedToCracked = {
                {SnailBlocks.TRIMMED_OAK_LOG, SnailBlocks.CRACKED_OAK_LOG},
                {SnailBlocks.TRIMMED_SPRUCE_LOG, SnailBlocks.CRACKED_SPRUCE_LOG},
                {SnailBlocks.TRIMMED_BIRCH_LOG, SnailBlocks.CRACKED_BIRCH_LOG},
                {SnailBlocks.TRIMMED_JUNGLE_LOG, SnailBlocks.CRACKED_JUNGLE_LOG},
                {SnailBlocks.TRIMMED_ACACIA_LOG, SnailBlocks.CRACKED_ACACIA_LOG},
                {SnailBlocks.TRIMMED_DARK_OAK_LOG, SnailBlocks.CRACKED_DARK_OAK_LOG},
                {SnailBlocks.TRIMMED_MANGROVE_LOG, SnailBlocks.CRACKED_MANGROVE_LOG},
                {SnailBlocks.TRIMMED_CHERRY_LOG, SnailBlocks.CRACKED_CHERRY_LOG},
                {SnailBlocks.TRIMMED_PALE_OAK_LOG, SnailBlocks.CRACKED_PALE_OAK_LOG},
                {SnailBlocks.TRIMMED_CRIMSON_STEM, SnailBlocks.CRACKED_CRIMSON_STEM},
                {SnailBlocks.TRIMMED_WARPED_STEM, SnailBlocks.CRACKED_WARPED_STEM}
        };
        Object[][] crackedToDamaged = {
                {SnailBlocks.CRACKED_OAK_LOG, SnailBlocks.DAMAGED_OAK_LOG},
                {SnailBlocks.CRACKED_SPRUCE_LOG, SnailBlocks.DAMAGED_SPRUCE_LOG},
                {SnailBlocks.CRACKED_BIRCH_LOG, SnailBlocks.DAMAGED_BIRCH_LOG},
                {SnailBlocks.CRACKED_JUNGLE_LOG, SnailBlocks.DAMAGED_JUNGLE_LOG},
                {SnailBlocks.CRACKED_ACACIA_LOG, SnailBlocks.DAMAGED_ACACIA_LOG},
                {SnailBlocks.CRACKED_DARK_OAK_LOG, SnailBlocks.DAMAGED_DARK_OAK_LOG},
                {SnailBlocks.CRACKED_MANGROVE_LOG, SnailBlocks.DAMAGED_MANGROVE_LOG},
                {SnailBlocks.CRACKED_CHERRY_LOG, SnailBlocks.DAMAGED_CHERRY_LOG},
                {SnailBlocks.CRACKED_PALE_OAK_LOG, SnailBlocks.DAMAGED_PALE_OAK_LOG},
                {SnailBlocks.CRACKED_CRIMSON_STEM, SnailBlocks.DAMAGED_CRIMSON_STEM},
                {SnailBlocks.CRACKED_WARPED_STEM, SnailBlocks.DAMAGED_WARPED_STEM}
        };

        PlayerBlockBreakEvents.AFTER.register((world, playerEntity, blockPos, blockState, blockEntity) -> {
            for (Object[] entry : logToTrimmed){
                Block logBlock = (Block) entry[0];
                Block trimmedLogBlock = (Block) entry[1];

                if (blockState.isOf(logBlock)){
                    world.setBlockState(blockPos, trimmedLogBlock.getStateWithProperties(blockState));
                }
            }
            for (Object[] entry : woodToTrimmed){
                Block woodBlock = (Block) entry[0];
                Block trimmedLogBlock = (Block) entry[1];

                if (blockState.isOf(woodBlock)){
                    world.setBlockState(blockPos, trimmedLogBlock.getStateWithProperties(blockState));
                }
            }
            for (Object[] entry : trimmedToCracked) {
                Block trimmedLogBlock = (Block) entry[0];
                Block crackedLogBlock = (Block) entry[1];

                if (blockState.isOf(trimmedLogBlock)){
                    world.setBlockState(blockPos, crackedLogBlock.getStateWithProperties(blockState));
                }
            }
            for (Object[] entry : crackedToDamaged) {
                Block crackedLogBlock = (Block) entry[0];
                Block damagedLogBlock = (Block) entry[1];

                if (blockState.isOf(crackedLogBlock)){
                    world.setBlockState(blockPos, damagedLogBlock.getStateWithProperties(blockState));
                }
            }
        });
    }
}
