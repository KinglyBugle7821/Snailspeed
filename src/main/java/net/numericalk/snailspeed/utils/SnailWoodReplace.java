package net.numericalk.snailspeed.utils;

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
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.datagen.SnailBlockTagsProvider;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;

import static net.numericalk.snailspeed.utils.SnailBreakEvents.PlanksBlockCombo;

public class SnailWoodReplace {
    static Object[][] logBlocksCombo = {
            {Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD, Blocks.OAK_LOG, Blocks.OAK_LOG, SnailBlocks.TRIMMED_OAK_LOG, SnailBlocks.CRACKED_OAK_LOG, SnailBlocks.DAMAGED_OAK_LOG, SnailItems.OAK_LOG_BARK},
            {Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD, SnailBlocks.TAPPED_SPRUCE_LOG, SnailBlocks.DECAYED_SPRUCE_LOG, SnailBlocks.TRIMMED_SPRUCE_LOG, SnailBlocks.CRACKED_SPRUCE_LOG, SnailBlocks.DAMAGED_SPRUCE_LOG, SnailItems.SPRUCE_LOG_BARK},
            {Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD, SnailBlocks.TAPPED_BIRCH_LOG, SnailBlocks.DECAYED_BIRCH_LOG, SnailBlocks.TRIMMED_BIRCH_LOG, SnailBlocks.CRACKED_BIRCH_LOG, SnailBlocks.DAMAGED_BIRCH_LOG, SnailItems.BIRCH_LOG_BARK},
            {Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD, Blocks.JUNGLE_LOG, Blocks.JUNGLE_LOG, SnailBlocks.TRIMMED_JUNGLE_LOG, SnailBlocks.CRACKED_JUNGLE_LOG, SnailBlocks.DAMAGED_JUNGLE_LOG, SnailItems.JUNGLE_LOG_BARK},
            {Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD, Blocks.ACACIA_LOG, Blocks.ACACIA_LOG, SnailBlocks.TRIMMED_ACACIA_LOG, SnailBlocks.CRACKED_ACACIA_LOG, SnailBlocks.DAMAGED_ACACIA_LOG, SnailItems.ACACIA_LOG_BARK},
            {Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_LOG, SnailBlocks.TRIMMED_DARK_OAK_LOG, SnailBlocks.CRACKED_DARK_OAK_LOG, SnailBlocks.DAMAGED_DARK_OAK_LOG, SnailItems.DARK_OAK_LOG_BARK},
            {Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD, Blocks.MANGROVE_LOG, Blocks.MANGROVE_LOG, SnailBlocks.TRIMMED_MANGROVE_LOG, SnailBlocks.CRACKED_MANGROVE_LOG, SnailBlocks.DAMAGED_MANGROVE_LOG, SnailItems.MANGROVE_LOG_BARK},
            {Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD, Blocks.CHERRY_LOG, Blocks.CHERRY_LOG, SnailBlocks.TRIMMED_CHERRY_LOG, SnailBlocks.CRACKED_CHERRY_LOG, SnailBlocks.DAMAGED_CHERRY_LOG, SnailItems.CHERRY_LOG_BARK},
            {Blocks.PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_LOG, Blocks.PALE_OAK_WOOD, Blocks.STRIPPED_PALE_OAK_WOOD, SnailBlocks.TAPPED_PALE_OAK_LOG, SnailBlocks.DAMAGED_PALE_OAK_LOG, SnailBlocks.TRIMMED_PALE_OAK_LOG, SnailBlocks.CRACKED_PALE_OAK_LOG, SnailBlocks.DAMAGED_PALE_OAK_LOG, SnailItems.PALE_OAK_LOG_BARK},
            {Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.CRIMSON_STEM, Blocks.CRIMSON_STEM, SnailBlocks.TRIMMED_CRIMSON_STEM, SnailBlocks.CRACKED_CRIMSON_STEM, SnailBlocks.DAMAGED_CRIMSON_STEM, SnailItems.CRIMSON_STEM_BARK},
            {Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE, Blocks.WARPED_STEM, Blocks.WARPED_STEM, SnailBlocks.TRIMMED_WARPED_STEM, SnailBlocks.CRACKED_WARPED_STEM, SnailBlocks.DAMAGED_WARPED_STEM, SnailItems.WARPED_STEM_BARK},
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
                             degradeLogBig(world, pos, state, true);
                             damageItem(stack, player, world, true);
                             return false;
                         } else {
                             return true;
                         }
                     } else if (hasWoodenAxe(stack)){
                        if (!hasReachedDamaged(state)) {
                            degradeLogSmall(world, pos, state, true);
                            damageItem(stack, player, world, true);
                            return false;
                        } else {
                            return true;
                        }
                    } else if (stack.isOf(SnailItems.CIRCULAR_SAW)){
                        planksLog(world, pos, state);
                        return false;
                    } else {
                        if (!hasReachedDamaged(state)) {
                            degradeLogSmall(world, pos, state, false);
                            damageItem(stack, player, world, false);
                            return false;
                        } else {
                            return true;
                        }
                    }
                }
            }

            return true;
        });
    }
    public static void planksLog(World world, BlockPos pos, BlockState state) {
        for (Block[] blocks : PlanksBlockCombo) {
            Block inputLog = blocks[3]; // The log to match
            Block outputPlanks = blocks[0]; // The planks to place

            if (state.isOf(inputLog)) {
                world.setBlockState(pos, outputPlanks.getDefaultState());
                return;
            }
        }
    }

    private static boolean hasBetterAxe(ItemStack stack) {
        return (stack.isIn(SnailItemTagsProvider.IRON_TOOLS) && stack.isIn(ItemTags.AXES)) ||
                (stack.isIn(SnailItemTagsProvider.DIAMOND_TOOLS) && stack.isIn(ItemTags.AXES)) ||
                (stack.isIn(SnailItemTagsProvider.NETHERITE_TOOLS) && stack.isIn(ItemTags.AXES));
    }

    private static boolean hasStoneAxe(ItemStack stack) {
        return stack.isIn(SnailItemTagsProvider.STONE_TOOLS) && stack.isIn(ItemTags.AXES);
    }

    private static boolean hasReachedDamaged(BlockState state) {
        return state.isIn(SnailBlockTagsProvider.DAMAGED_LOGS);
    }

    private static void damageItem(ItemStack stack, PlayerEntity player, World world, boolean canDecrement) {
        if (!world.isClient()){
            if (stack.isDamageable()){
                stack.damage(1, player);
            } else if (canDecrement){
                stack.decrement(1);
            }
        }
    }

    private static void degradeLogSmall(World world, BlockPos pos, BlockState state, boolean canDrop) {
        if (world.isClient()) return;
        for (Object[] log : logBlocksCombo){
            Block trimmed = (Block) log[6];
            Block cracked = (Block) log[7];
            Block damaged = (Block) log[8];
            Item bark = (Item) log[9];
            for (int i = 0; i < 6; i++){
                if (state.isOf((Block) log[i])){
                    turnBlockTo(trimmed, pos, state, world);
                    if (canDrop) {
                        addDrop(world, bark, pos);
                    }
                    return;
                }
            }
            if (state.isOf(trimmed)){
                turnBlockTo(cracked, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.WOOD_DUST, pos);
                }
            } else if (state.isOf(cracked)){
                turnBlockTo(damaged, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.WOOD_DUST, pos);
                }
            }
        }
    }
    private static void degradeLogBig(World world, BlockPos pos, BlockState state, boolean canDrop) {
        if (world.isClient()) return;
        for (Object[] log : logBlocksCombo){
            Block trimmed = (Block) log[6];
            Block cracked = (Block) log[7];
            Block damaged = (Block) log[8];
            Item bark = (Item) log[9];
            for (int i = 0; i < 6; i++){
                if (state.isOf((Block) log[i])){
                    turnBlockTo(cracked, pos, state, world);
                    if (canDrop) {
                        addDrop(world, bark, pos);
                        addDrop(world, SnailItems.WOOD_DUST, pos);
                    }
                    return;
                }
            }
            if (state.isOf(trimmed)){
                turnBlockTo(damaged, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.WOOD_DUST, pos);
                    addDrop(world, SnailItems.WOOD_DUST, pos);
                }
            }
            if (state.isOf(cracked)){
                turnBlockTo(damaged, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.WOOD_DUST, pos);
                }
            }
        }
    }
    private static void turnBlockTo(Block block, BlockPos pos, BlockState state, World world) {
        if (!world.isClient()){
            world.setBlockState(pos, block.getStateWithProperties(state));
        }
    }

    private static void addDrop(World world, Item bark, BlockPos pos) {
        if (!world.isClient()){
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), bark.getDefaultStack());
        }
    }

    private static boolean hasWoodenAxe(ItemStack stack) {
        return stack.isIn(SnailItemTagsProvider.WOODEN_TOOLS) && stack.isIn(ItemTags.AXES);
    }

    private static boolean isTargetLogBlock(BlockState state) {
        return state.isIn(BlockTags.LOGS);
    }
}