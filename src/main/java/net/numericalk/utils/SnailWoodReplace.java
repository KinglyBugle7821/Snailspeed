package net.numericalk.utils;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.datagen.SnailBlockTagsProvider;
import net.numericalk.items.SnailItems;

public class SnailWoodReplace {
    static Object[][] logBlocksCombo = {
            {Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD, SnailBlocks.TRIMMED_OAK_LOG, SnailBlocks.CRACKED_OAK_LOG, SnailBlocks.DAMAGED_OAK_LOG, SnailItems.OAK_LOG_BARK},
            {Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD, SnailBlocks.TRIMMED_SPRUCE_LOG, SnailBlocks.CRACKED_SPRUCE_LOG, SnailBlocks.DAMAGED_SPRUCE_LOG, SnailItems.SPRUCE_LOG_BARK},
            {Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD, SnailBlocks.TRIMMED_BIRCH_LOG, SnailBlocks.CRACKED_BIRCH_LOG, SnailBlocks.DAMAGED_BIRCH_LOG, SnailItems.BIRCH_LOG_BARK},
            {Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD, SnailBlocks.TRIMMED_JUNGLE_LOG, SnailBlocks.CRACKED_JUNGLE_LOG, SnailBlocks.DAMAGED_JUNGLE_LOG, SnailItems.JUNGLE_LOG_BARK},
            {Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD, SnailBlocks.TRIMMED_ACACIA_LOG, SnailBlocks.CRACKED_ACACIA_LOG, SnailBlocks.DAMAGED_ACACIA_LOG, SnailItems.ACACIA_LOG_BARK},
            {Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD, SnailBlocks.TRIMMED_DARK_OAK_LOG, SnailBlocks.CRACKED_DARK_OAK_LOG, SnailBlocks.DAMAGED_DARK_OAK_LOG, SnailItems.DARK_OAK_LOG_BARK},
            {Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD, SnailBlocks.TRIMMED_MANGROVE_LOG, SnailBlocks.CRACKED_MANGROVE_LOG, SnailBlocks.DAMAGED_MANGROVE_LOG, SnailItems.MANGROVE_LOG_BARK},
            {Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD, SnailBlocks.TRIMMED_CHERRY_LOG, SnailBlocks.CRACKED_CHERRY_LOG, SnailBlocks.DAMAGED_CHERRY_LOG, SnailItems.CHERRY_LOG_BARK},
            {Blocks.PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_LOG, Blocks.PALE_OAK_WOOD, Blocks.STRIPPED_PALE_OAK_WOOD, SnailBlocks.TRIMMED_PALE_OAK_LOG, SnailBlocks.CRACKED_PALE_OAK_LOG, SnailBlocks.DAMAGED_PALE_OAK_LOG, SnailItems.PALE_OAK_LOG_BARK},
            {Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE, SnailBlocks.TRIMMED_CRIMSON_STEM, SnailBlocks.CRACKED_CRIMSON_STEM, SnailBlocks.DAMAGED_CRIMSON_STEM, SnailItems.CRIMSON_STEM_BARK},
            {Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE, SnailBlocks.TRIMMED_WARPED_STEM, SnailBlocks.CRACKED_WARPED_STEM, SnailBlocks.DAMAGED_WARPED_STEM, SnailItems.WARPED_STEM_BARK},
    };

    public static void replaceWood(){
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            ItemStack stack = player.getMainHandStack();
            if (!player.isCreative()){
                if (isTargetLogBlock(state)){
                     if (hasBetterAxe(stack)){
                        return true;
                    } else if(hasStoneAxe(stack)){
                         if (!hasReachedDamaged(state)) {
                             degradeLogBig(world, pos, state);
                             damageItem(stack, player);
                             return false;
                         } else {
                             return true;
                         }
                     } else if (hasWoodenAxe(stack)){
                        if (!hasReachedDamaged(state)) {
                            degradeLogSmall(world, pos, state);
                            damageItem(stack, player);
                            return false;
                        } else {
                            return true;
                        }
                    }
                    return false;
                }
            }

            return true;
        });
    }

    private static boolean hasBetterAxe(ItemStack stack) {
        return (stack.isIn(ItemTags.IRON_TOOL_MATERIALS) && stack.isIn(ItemTags.AXES)) ||
                (stack.isIn(ItemTags.DIAMOND_TOOL_MATERIALS) && stack.isIn(ItemTags.AXES)) ||
                (stack.isIn(ItemTags.NETHERITE_TOOL_MATERIALS) && stack.isIn(ItemTags.AXES));
    }

    private static boolean hasStoneAxe(ItemStack stack) {
        return stack.isIn(ItemTags.STONE_TOOL_MATERIALS) && stack.isIn(ItemTags.AXES);
    }

    private static boolean hasReachedDamaged(BlockState state) {
        return state.isIn(SnailBlockTagsProvider.DAMAGED_LOGS);
    }

    private static void damageItem(ItemStack stack, PlayerEntity player) {
        if (stack.isDamageable()){
            stack.damage(1, player);
        }
        else stack.decrement(1);
    }

    private static void degradeLogSmall(World world, BlockPos pos, BlockState state) {
        for (Object[] log : logBlocksCombo){
            Block trimmed = (Block) log[4];
            Block cracked = (Block) log[5];
            Block damaged = (Block) log[6];
            Item bark = (Item) log[7];
            for (int i = 0; i < 4; i++){
                if (state.isOf((Block) log[i])){
                    world.setBlockState(pos, trimmed.getStateWithProperties(state));
                    addDrop(world, bark, pos);
                    return;
                }
            }
            if (state.isOf(trimmed)){
                world.setBlockState(pos, cracked.getStateWithProperties(state));
                addDrop(world, SnailItems.WOOD_DUST, pos);
            } else if (state.isOf(cracked)){
                world.setBlockState(pos, damaged.getStateWithProperties(state));
                addDrop(world, SnailItems.WOOD_DUST, pos);
            }
        }
    }
    private static void degradeLogBig(World world, BlockPos pos, BlockState state) {
        for (Object[] log : logBlocksCombo){
            Block trimmed = (Block) log[4];
            Block cracked = (Block) log[5];
            Block damaged = (Block) log[6];
            Item bark = (Item) log[7];
            for (int i = 0; i < 4; i++){
                if (state.isOf((Block) log[i])){
                    System.out.println("Player Changed The Block");
                    world.setBlockState(pos, cracked.getStateWithProperties(state));
                    addDrop(world, bark, pos);
                    addDrop(world, SnailItems.WOOD_DUST, pos);
                    return;
                }
            }
            if (state.isOf(trimmed)){
                world.setBlockState(pos, damaged.getStateWithProperties(state));
                addDrop(world, SnailItems.WOOD_DUST, pos);
                addDrop(world, SnailItems.WOOD_DUST, pos);
            }
            if (state.isOf(cracked)){
                world.setBlockState(pos, damaged.getStateWithProperties(state));
                addDrop(world, SnailItems.WOOD_DUST, pos);
            }
        }
    }

    private static void addDrop(World world, Item bark, BlockPos pos) {
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), bark.getDefaultStack());
    }

    private static boolean hasWoodenAxe(ItemStack stack) {
        return stack.isIn(ItemTags.WOODEN_TOOL_MATERIALS) && stack.isIn(ItemTags.AXES);
    }

    private static boolean isTargetLogBlock(BlockState state) {
        return state.isIn(BlockTags.LOGS);
    }
}