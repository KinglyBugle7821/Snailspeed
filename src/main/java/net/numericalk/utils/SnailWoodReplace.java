package net.numericalk.utils;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItems;

public class SnailWoodReplace {

    static Object[][] logBreakingPhases = {
            {Blocks.OAK_LOG, SnailBlocks.TRIMMED_OAK_LOG, SnailBlocks.CRACKED_OAK_LOG, SnailBlocks.DAMAGED_OAK_LOG, SnailItems.OAK_LOG_BARK},
            {Blocks.SPRUCE_LOG, SnailBlocks.TRIMMED_SPRUCE_LOG, SnailBlocks.CRACKED_SPRUCE_LOG, SnailBlocks.DAMAGED_SPRUCE_LOG, SnailItems.SPRUCE_LOG_BARK},
            {Blocks.BIRCH_LOG, SnailBlocks.TRIMMED_BIRCH_LOG, SnailBlocks.CRACKED_BIRCH_LOG, SnailBlocks.DAMAGED_BIRCH_LOG, SnailItems.BIRCH_LOG_BARK},
            {Blocks.JUNGLE_LOG, SnailBlocks.TRIMMED_JUNGLE_LOG, SnailBlocks.CRACKED_JUNGLE_LOG, SnailBlocks.DAMAGED_JUNGLE_LOG, SnailItems.JUNGLE_LOG_BARK},
            {Blocks.ACACIA_LOG, SnailBlocks.TRIMMED_ACACIA_LOG, SnailBlocks.CRACKED_ACACIA_LOG, SnailBlocks.DAMAGED_ACACIA_LOG, SnailItems.ACACIA_LOG_BARK},
            {Blocks.DARK_OAK_LOG, SnailBlocks.TRIMMED_DARK_OAK_LOG, SnailBlocks.CRACKED_DARK_OAK_LOG, SnailBlocks.DAMAGED_DARK_OAK_LOG, SnailItems.DARK_OAK_LOG_BARK},
            {Blocks.MANGROVE_LOG, SnailBlocks.TRIMMED_MANGROVE_LOG, SnailBlocks.CRACKED_MANGROVE_LOG, SnailBlocks.DAMAGED_MANGROVE_LOG, SnailItems.MANGROVE_LOG_BARK},
            {Blocks.CHERRY_LOG, SnailBlocks.TRIMMED_CHERRY_LOG, SnailBlocks.CRACKED_CHERRY_LOG, SnailBlocks.DAMAGED_CHERRY_LOG, SnailItems.CHERRY_LOG_BARK},
            {Blocks.PALE_OAK_LOG, SnailBlocks.TRIMMED_PALE_OAK_LOG, SnailBlocks.CRACKED_PALE_OAK_LOG, SnailBlocks.DAMAGED_PALE_OAK_LOG, SnailItems.PALE_OAK_LOG_BARK},
            {Blocks.CRIMSON_STEM, SnailBlocks.TRIMMED_CRIMSON_STEM, SnailBlocks.CRACKED_CRIMSON_STEM, SnailBlocks.DAMAGED_CRIMSON_STEM, SnailItems.CRIMSON_STEM_BARK},
            {Blocks.WARPED_STEM, SnailBlocks.TRIMMED_WARPED_STEM, SnailBlocks.CRACKED_WARPED_STEM, SnailBlocks.DAMAGED_WARPED_STEM, SnailItems.WARPED_STEM_BARK},
    };
    static Object[][] strippedLogBreakingPhases = {
            {Blocks.STRIPPED_OAK_LOG, SnailBlocks.TRIMMED_OAK_LOG, SnailBlocks.CRACKED_OAK_LOG, SnailBlocks.DAMAGED_OAK_LOG},
            {Blocks.STRIPPED_SPRUCE_LOG, SnailBlocks.TRIMMED_SPRUCE_LOG, SnailBlocks.CRACKED_SPRUCE_LOG, SnailBlocks.DAMAGED_SPRUCE_LOG},
            {Blocks.STRIPPED_BIRCH_LOG, SnailBlocks.TRIMMED_BIRCH_LOG, SnailBlocks.CRACKED_BIRCH_LOG, SnailBlocks.DAMAGED_BIRCH_LOG},
            {Blocks.STRIPPED_JUNGLE_LOG, SnailBlocks.TRIMMED_JUNGLE_LOG, SnailBlocks.CRACKED_JUNGLE_LOG, SnailBlocks.DAMAGED_JUNGLE_LOG},
            {Blocks.STRIPPED_ACACIA_LOG, SnailBlocks.TRIMMED_ACACIA_LOG, SnailBlocks.CRACKED_ACACIA_LOG, SnailBlocks.DAMAGED_ACACIA_LOG},
            {Blocks.STRIPPED_DARK_OAK_LOG, SnailBlocks.TRIMMED_DARK_OAK_LOG, SnailBlocks.CRACKED_DARK_OAK_LOG, SnailBlocks.DAMAGED_DARK_OAK_LOG},
            {Blocks.STRIPPED_MANGROVE_LOG, SnailBlocks.TRIMMED_MANGROVE_LOG, SnailBlocks.CRACKED_MANGROVE_LOG, SnailBlocks.DAMAGED_MANGROVE_LOG},
            {Blocks.STRIPPED_CHERRY_LOG, SnailBlocks.TRIMMED_CHERRY_LOG, SnailBlocks.CRACKED_CHERRY_LOG, SnailBlocks.DAMAGED_CHERRY_LOG},
            {Blocks.STRIPPED_PALE_OAK_LOG, SnailBlocks.TRIMMED_PALE_OAK_LOG, SnailBlocks.CRACKED_PALE_OAK_LOG, SnailBlocks.DAMAGED_PALE_OAK_LOG},
            {Blocks.STRIPPED_CRIMSON_STEM, SnailBlocks.TRIMMED_CRIMSON_STEM, SnailBlocks.CRACKED_CRIMSON_STEM, SnailBlocks.DAMAGED_CRIMSON_STEM},
            {Blocks.STRIPPED_WARPED_STEM, SnailBlocks.TRIMMED_WARPED_STEM, SnailBlocks.CRACKED_WARPED_STEM, SnailBlocks.DAMAGED_WARPED_STEM},
    };
    static Object[][] woodBreakingPhases = {
            {Blocks.OAK_WOOD, SnailBlocks.TRIMMED_OAK_LOG, SnailBlocks.CRACKED_OAK_LOG, SnailBlocks.DAMAGED_OAK_LOG, SnailItems.OAK_LOG_BARK},
            {Blocks.SPRUCE_WOOD, SnailBlocks.TRIMMED_SPRUCE_LOG, SnailBlocks.CRACKED_SPRUCE_LOG, SnailBlocks.DAMAGED_SPRUCE_LOG, SnailItems.SPRUCE_LOG_BARK},
            {Blocks.BIRCH_WOOD, SnailBlocks.TRIMMED_BIRCH_LOG, SnailBlocks.CRACKED_BIRCH_LOG, SnailBlocks.DAMAGED_BIRCH_LOG, SnailItems.BIRCH_LOG_BARK},
            {Blocks.JUNGLE_WOOD, SnailBlocks.TRIMMED_JUNGLE_LOG, SnailBlocks.CRACKED_JUNGLE_LOG, SnailBlocks.DAMAGED_JUNGLE_LOG, SnailItems.JUNGLE_LOG_BARK},
            {Blocks.ACACIA_WOOD, SnailBlocks.TRIMMED_ACACIA_LOG, SnailBlocks.CRACKED_ACACIA_LOG, SnailBlocks.DAMAGED_ACACIA_LOG, SnailItems.ACACIA_LOG_BARK},
            {Blocks.DARK_OAK_WOOD, SnailBlocks.TRIMMED_DARK_OAK_LOG, SnailBlocks.CRACKED_DARK_OAK_LOG, SnailBlocks.DAMAGED_DARK_OAK_LOG, SnailItems.DARK_OAK_LOG_BARK},
            {Blocks.MANGROVE_WOOD, SnailBlocks.TRIMMED_MANGROVE_LOG, SnailBlocks.CRACKED_MANGROVE_LOG, SnailBlocks.DAMAGED_MANGROVE_LOG, SnailItems.MANGROVE_LOG_BARK},
            {Blocks.CHERRY_WOOD, SnailBlocks.TRIMMED_CHERRY_LOG, SnailBlocks.CRACKED_CHERRY_LOG, SnailBlocks.DAMAGED_CHERRY_LOG, SnailItems.CHERRY_LOG_BARK},
            {Blocks.PALE_OAK_WOOD, SnailBlocks.TRIMMED_PALE_OAK_LOG, SnailBlocks.CRACKED_PALE_OAK_LOG, SnailBlocks.DAMAGED_PALE_OAK_LOG, SnailItems.PALE_OAK_LOG_BARK},
            {Blocks.CRIMSON_HYPHAE, SnailBlocks.TRIMMED_CRIMSON_STEM, SnailBlocks.CRACKED_CRIMSON_STEM, SnailBlocks.DAMAGED_CRIMSON_STEM, SnailItems.CRIMSON_STEM_BARK},
            {Blocks.WARPED_HYPHAE, SnailBlocks.TRIMMED_WARPED_STEM, SnailBlocks.CRACKED_WARPED_STEM, SnailBlocks.DAMAGED_WARPED_STEM, SnailItems.WARPED_STEM_BARK},
    };
    static Object[][] strippedWoodBreakingPhases = {
            {Blocks.STRIPPED_OAK_WOOD, SnailBlocks.TRIMMED_OAK_LOG, SnailBlocks.CRACKED_OAK_LOG, SnailBlocks.DAMAGED_OAK_LOG},
            {Blocks.STRIPPED_SPRUCE_WOOD, SnailBlocks.TRIMMED_SPRUCE_LOG, SnailBlocks.CRACKED_SPRUCE_LOG, SnailBlocks.DAMAGED_SPRUCE_LOG},
            {Blocks.STRIPPED_BIRCH_WOOD, SnailBlocks.TRIMMED_BIRCH_LOG, SnailBlocks.CRACKED_BIRCH_LOG, SnailBlocks.DAMAGED_BIRCH_LOG},
            {Blocks.STRIPPED_JUNGLE_WOOD, SnailBlocks.TRIMMED_JUNGLE_LOG, SnailBlocks.CRACKED_JUNGLE_LOG, SnailBlocks.DAMAGED_JUNGLE_LOG},
            {Blocks.STRIPPED_ACACIA_WOOD, SnailBlocks.TRIMMED_ACACIA_LOG, SnailBlocks.CRACKED_ACACIA_LOG, SnailBlocks.DAMAGED_ACACIA_LOG},
            {Blocks.STRIPPED_DARK_OAK_WOOD, SnailBlocks.TRIMMED_DARK_OAK_LOG, SnailBlocks.CRACKED_DARK_OAK_LOG, SnailBlocks.DAMAGED_DARK_OAK_LOG},
            {Blocks.STRIPPED_MANGROVE_WOOD, SnailBlocks.TRIMMED_MANGROVE_LOG, SnailBlocks.CRACKED_MANGROVE_LOG, SnailBlocks.DAMAGED_MANGROVE_LOG},
            {Blocks.STRIPPED_CHERRY_WOOD, SnailBlocks.TRIMMED_CHERRY_LOG, SnailBlocks.CRACKED_CHERRY_LOG, SnailBlocks.DAMAGED_CHERRY_LOG},
            {Blocks.STRIPPED_PALE_OAK_WOOD, SnailBlocks.TRIMMED_PALE_OAK_LOG, SnailBlocks.CRACKED_PALE_OAK_LOG, SnailBlocks.DAMAGED_PALE_OAK_LOG},
            {Blocks.STRIPPED_CRIMSON_HYPHAE, SnailBlocks.TRIMMED_CRIMSON_STEM, SnailBlocks.CRACKED_CRIMSON_STEM, SnailBlocks.DAMAGED_CRIMSON_STEM},
            {Blocks.STRIPPED_WARPED_HYPHAE, SnailBlocks.TRIMMED_WARPED_STEM, SnailBlocks.CRACKED_WARPED_STEM, SnailBlocks.DAMAGED_WARPED_STEM},
    };
    static Block[] anyLogBlock = {
            Blocks.OAK_LOG, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_OAK_WOOD, SnailBlocks.TRIMMED_OAK_LOG, SnailBlocks.CRACKED_OAK_LOG, SnailBlocks.DAMAGED_OAK_LOG,
            Blocks.SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_WOOD, SnailBlocks.TRIMMED_SPRUCE_LOG, SnailBlocks.CRACKED_SPRUCE_LOG, SnailBlocks.DAMAGED_SPRUCE_LOG,
            Blocks.BIRCH_LOG, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_WOOD, SnailBlocks.TRIMMED_BIRCH_LOG, SnailBlocks.CRACKED_BIRCH_LOG, SnailBlocks.DAMAGED_BIRCH_LOG,
            Blocks.JUNGLE_LOG, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_WOOD, SnailBlocks.TRIMMED_JUNGLE_LOG, SnailBlocks.CRACKED_JUNGLE_LOG, SnailBlocks.DAMAGED_JUNGLE_LOG,
            Blocks.ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_WOOD, SnailBlocks.TRIMMED_ACACIA_LOG, SnailBlocks.CRACKED_ACACIA_LOG, SnailBlocks.DAMAGED_ACACIA_LOG,
            Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_WOOD, SnailBlocks.TRIMMED_DARK_OAK_LOG, SnailBlocks.CRACKED_DARK_OAK_LOG, SnailBlocks.DAMAGED_DARK_OAK_LOG,
            Blocks.MANGROVE_LOG, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_WOOD, SnailBlocks.TRIMMED_MANGROVE_LOG, SnailBlocks.CRACKED_MANGROVE_LOG, SnailBlocks.DAMAGED_MANGROVE_LOG,
            Blocks.CHERRY_LOG, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_LOG, Blocks.STRIPPED_CHERRY_WOOD, SnailBlocks.TRIMMED_CHERRY_LOG, SnailBlocks.CRACKED_CHERRY_LOG, SnailBlocks.DAMAGED_CHERRY_LOG,
            Blocks.PALE_OAK_LOG, Blocks.PALE_OAK_WOOD, Blocks.STRIPPED_PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_WOOD, SnailBlocks.TRIMMED_PALE_OAK_LOG, SnailBlocks.CRACKED_PALE_OAK_LOG, SnailBlocks.DAMAGED_PALE_OAK_LOG,
            Blocks.CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_HYPHAE, SnailBlocks.TRIMMED_CRIMSON_STEM, SnailBlocks.CRACKED_CRIMSON_STEM, SnailBlocks.DAMAGED_CRIMSON_STEM,
            Blocks.WARPED_STEM, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_STEM, Blocks.STRIPPED_WARPED_HYPHAE, SnailBlocks.TRIMMED_WARPED_STEM, SnailBlocks.CRACKED_WARPED_STEM, SnailBlocks.DAMAGED_WARPED_STEM
    };

    static Item[] woodLevelTool = {
            SnailItems.FLINT_FLAKE, SnailItems.FLINT_HATCHET, Items.WOODEN_AXE, Items.GOLDEN_AXE
    };
    static Item[] stoneLevelTool = {
            Items.STONE_AXE
    };

    public static void replaceWoodBlock() {
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            if (!player.isCreative()){
                if (isTargetLog(state)){
                    if(isLevelWood(player)){
                        breakLogLevelWood(state, world, pos);
                        damageItem(player);
                        return isDamaged(state);
                    } else if (isLevelStone(player)){
                        breakLogLevelStone(state, world, pos);
                        damageItem(player);
                        return isDamaged(state);
                    }
                }
                if (isTargetStrippedLog(state)){
                    if(isLevelWood(player)){
                        breakStrippedLogLevelWood(state, world, pos);
                        damageItem(player);
                        return isDamaged(state);
                    } else if (isLevelStone(player)){
                        breakStrippedLogLevelStone(state, world, pos);
                        damageItem(player);
                        return isDamaged(state);
                    }
                }
                if (isTargetWood(state)){
                    if (isLevelWood(player)){
                        breakWoodLevelWood(state, world, pos);
                        damageItem(player);
                        return isDamaged(state);
                    } else if (isLevelStone(player)){
                        breakWoodLevelStone(state, world, pos);
                        damageItem(player);
                        return isDamaged(state);
                    }
                }
                if (isTargetStrippedWood(state)){
                    if (isLevelWood(player)){
                        breakStrippedWoodLevelWood(state, world, pos);
                        damageItem(player);
                        return isDamaged(state);
                    } else if (isLevelStone(player)){
                        breakStrippedWoodLevelStone(state, world, pos);
                        damageItem(player);
                        return isDamaged(state);
                    }
                }
                if (targetIsAnyWoodOrLogBlock(state)){
                    return false;
                }
                return true;
            }
            return true;
        });
    }

    private static void damageItem(PlayerEntity player) {
        if (player.getMainHandStack().isDamageable()){
            player.getMainHandStack().damage(1, player);
        }
        else {
            player.getMainHandStack().decrement(1);
        }
    }

    private static boolean targetIsAnyWoodOrLogBlock(BlockState state) {
        for (Block entry : anyLogBlock){
            if (state.isOf(entry)) return true;
        }
        return false;
    }


    private static boolean isTargetStrippedWood(BlockState state) {
        for (Object[] entry : strippedWoodBreakingPhases){
            Block strippedWoodBlock = (Block) entry[0];
            Block trimmedLogBlock = (Block) entry[1];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            if (state.isOf(strippedWoodBlock) ||
                    state.isOf(trimmedLogBlock) ||
                    state.isOf(crackedLogBlock) ||
                    state.isOf(damagedLogBlock)) return true;
        }
        return false;
    }


    private static boolean isTargetWood(BlockState state) {
        for (Object[] entry : woodBreakingPhases){
            Block woodBlock = (Block) entry[0];
            Block trimmedLogBlock = (Block) entry[1];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            if (state.isOf(woodBlock) ||
                    state.isOf(trimmedLogBlock) ||
                    state.isOf(crackedLogBlock) ||
                    state.isOf(damagedLogBlock)) return true;
        }
        return false;
    }

    private static boolean isTargetStrippedLog(BlockState state) {
        for (Object[] entry : strippedLogBreakingPhases){
            Block strippedLogBlock = (Block) entry[0];
            Block trimmedLogBlock = (Block) entry[1];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            if (state.isOf(strippedLogBlock) ||
                    state.isOf(trimmedLogBlock) ||
                    state.isOf(crackedLogBlock) ||
                    state.isOf(damagedLogBlock)) return true;
        }
        return false;
    }

    private static boolean isTargetLog(BlockState state) {
        for (Object[] entry : logBreakingPhases){
            Block logBlock = (Block) entry[0];
            Block trimmedLogBlock = (Block) entry[1];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            if (state.isOf(logBlock) ||
                    state.isOf(trimmedLogBlock) ||
                    state.isOf(crackedLogBlock) ||
                    state.isOf(damagedLogBlock)) return true;
        }
        return false;
    }

    private static boolean isLevelStone(PlayerEntity player) {
        for (Item stoneTool : stoneLevelTool){
            if (player.getMainHandStack().isOf(stoneTool)) return true;
        }
        return false;
    }

    private static boolean isLevelWood(PlayerEntity player) {
        for (Item woodenTool : woodLevelTool){
            if (player.getMainHandStack().isOf(woodenTool)) return true;
        }
        return false;
    }

    private static boolean isDamaged(BlockState state) {
        for (Object[] entry : logBreakingPhases){
            Block damagedLogBlock = (Block) entry[3];
            if (state.isOf(damagedLogBlock)) return true;
        }
        return false;
    }

    private static void breakStrippedWoodLevelStone(BlockState state, World world, BlockPos pos) {
        for (Object[] entry : strippedWoodBreakingPhases){
            Block strippedWoodBlock = (Block) entry[0];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            Item woodDust = SnailItems.WOOD_DUST;

            if (state.isOf(strippedWoodBlock)){
                destroyStageTo(crackedLogBlock, state, world, pos, woodDust, woodDust, woodDust);
            } else if (state.isOf(crackedLogBlock)){
                destroyStageTo(damagedLogBlock, state, world, pos, woodDust);
            }
        }
    }

    private static void breakStrippedWoodLevelWood(BlockState state, World world, BlockPos pos) {
        for (Object[] entry : strippedWoodBreakingPhases){
            Block strippedWoodBlock = (Block) entry[0];
            Block trimmedLogBlock = (Block) entry[1];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            Item woodDust = SnailItems.WOOD_DUST;

            if (state.isOf(strippedWoodBlock)){
                destroyStageTo(trimmedLogBlock, state, world, pos, woodDust);
            } else if (state.isOf(trimmedLogBlock)){
                destroyStageTo(crackedLogBlock, state, world, pos, woodDust);
            } else if (state.isOf(crackedLogBlock)){
                destroyStageTo(damagedLogBlock, state, world, pos, woodDust);
            }
        }
    }
    private static void breakWoodLevelStone(BlockState state, World world, BlockPos pos) {
        for (Object[] entry : woodBreakingPhases){
            Block woodBlock = (Block) entry[0];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            Item logBark = (Item) entry[4];
            Item woodDust = SnailItems.WOOD_DUST;

            if (state.isOf(woodBlock)){
                destroyStageTo(crackedLogBlock, state, world, pos, logBark, logBark, woodDust);
            } else if (state.isOf(crackedLogBlock)){
                destroyStageTo(damagedLogBlock, state, world, pos, woodDust);
            }
        }
    }
    private static void breakWoodLevelWood(BlockState state, World world, BlockPos pos) {
        for (Object[] entry : woodBreakingPhases){
            Block woodBlock = (Block) entry[0];
            Block trimmedLogBlock = (Block) entry[1];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            Item logBark = (Item) entry[4];
            Item woodDust = SnailItems.WOOD_DUST;

            if (state.isOf(woodBlock)){
                destroyStageTo(trimmedLogBlock, state, world, pos, logBark, logBark);
            } else if (state.isOf(trimmedLogBlock)){
                destroyStageTo(crackedLogBlock, state, world, pos, woodDust);
            } else if (state.isOf(crackedLogBlock)){
                destroyStageTo(damagedLogBlock, state, world, pos, woodDust);
            }
        }
    }
    private static void breakStrippedLogLevelStone(BlockState state, World world, BlockPos pos) {
        for (Object[] entry : strippedLogBreakingPhases){
            Block strippedLogBlock = (Block) entry[0];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            Item woodDust = SnailItems.WOOD_DUST;

            if (state.isOf(strippedLogBlock)){
                destroyStageTo(crackedLogBlock, state, world, pos, woodDust, woodDust);
            } else if (state.isOf(crackedLogBlock)){
                destroyStageTo(damagedLogBlock, state, world, pos, woodDust);
            }
        }
    }

    private static void breakStrippedLogLevelWood(BlockState state, World world, BlockPos pos) {
        for (Object[] entry : strippedLogBreakingPhases){
            Block strippedLogBlock = (Block) entry[0];
            Block trimmedLogBlock = (Block) entry[1];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            Item woodDust = SnailItems.WOOD_DUST;

            if (state.isOf(strippedLogBlock)){
                destroyStageTo(trimmedLogBlock, state, world, pos, woodDust);
            } else if (state.isOf(trimmedLogBlock)){
                destroyStageTo(crackedLogBlock, state, world, pos, woodDust);
            } else if (state.isOf(crackedLogBlock)){
                destroyStageTo(damagedLogBlock, state, world, pos, woodDust);
            }
        }
    }

    private static void breakLogLevelStone(BlockState state, World world, BlockPos pos) {
        for (Object[] entry : logBreakingPhases){
            Block logBlock = (Block) entry[0];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            Item logBark = (Item) entry[4];
            Item woodDust = SnailItems.WOOD_DUST;

            if (state.isOf(logBlock)){
                destroyStageTo(crackedLogBlock, state, world, pos, logBark, woodDust);
            } else if (state.isOf(crackedLogBlock)){
                destroyStageTo(damagedLogBlock, state, world, pos, woodDust);
            }
        }
    }

    private static void breakLogLevelWood(BlockState state, World world, BlockPos pos) {
        for (Object[] entry : logBreakingPhases){
            Block logBlock = (Block) entry[0];
            Block trimmedLogBlock = (Block) entry[1];
            Block crackedLogBlock = (Block) entry[2];
            Block damagedLogBlock = (Block) entry[3];
            Item logBark = (Item) entry[4];
            Item woodDust = SnailItems.WOOD_DUST;

            if (state.isOf(logBlock)){
                destroyStageTo(trimmedLogBlock, state, world, pos, logBark);
            } else if (state.isOf(trimmedLogBlock)){
                destroyStageTo(crackedLogBlock, state, world, pos, woodDust);
            } else if (state.isOf(crackedLogBlock)){
                destroyStageTo(damagedLogBlock, state, world, pos, woodDust);
            }
        }
    }

    public static void destroyStageTo(Block stage, BlockState state, World world, BlockPos pos, Item drop){
        world.setBlockState(pos, stage.getStateWithProperties(state));
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), drop.getDefaultStack());
    }
    public static void destroyStageTo(Block stage, BlockState state, World world, BlockPos pos, Item drop1, Item drop2){
        world.setBlockState(pos, stage.getStateWithProperties(state));
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), drop1.getDefaultStack());
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), drop2.getDefaultStack());
    }
    public static void destroyStageTo(Block stage, BlockState state, World world, BlockPos pos, Item drop1, Item drop2, Item drop3){
        world.setBlockState(pos, stage.getStateWithProperties(state));
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), drop1.getDefaultStack());
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), drop2.getDefaultStack());
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), drop3.getDefaultStack());
    }
}
