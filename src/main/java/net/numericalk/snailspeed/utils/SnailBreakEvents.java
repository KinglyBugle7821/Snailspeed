package net.numericalk.snailspeed.utils;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.datagen.SnailBlockTagsProvider;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;

import static net.numericalk.snailspeed.utils.SnailWoodReplace.planksLog;

public class SnailBreakEvents {
    static Block[][] StoneBlockCombo = {
            {Blocks.STONE, SnailBlocks.SCRATCHED_STONE, SnailBlocks.CRACKED_STONE, Blocks.COBBLESTONE, SnailBlocks.FRACTURED_STONE, SnailBlocks.CRUMBLED_STONE},
            {Blocks.DEEPSLATE, SnailBlocks.SCRATCHED_DEEPSLATE, SnailBlocks.CRACKED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE, SnailBlocks.FRACTURED_DEEPSLATE, SnailBlocks.CRUMBLED_DEEPSLATE}
    };
    static final Block[] jsDropRockBro = {
            Blocks.SMOOTH_STONE,
            Blocks.STONE_SLAB,
            Blocks.SMOOTH_STONE_SLAB,
            Blocks.STONE_STAIRS,
            Blocks.STONE_BRICKS,
            Blocks.CRACKED_STONE_BRICKS,
            Blocks.CHISELED_STONE_BRICKS,
            Blocks.STONE_BRICK_SLAB,
            Blocks.STONE_BRICK_STAIRS,
            Blocks.STONE_BRICK_WALL,

            Blocks.COBBLESTONE_SLAB,
            Blocks.COBBLESTONE_STAIRS,
            Blocks.COBBLESTONE_WALL,
            Blocks.MOSSY_COBBLESTONE,
            Blocks.MOSSY_COBBLESTONE_SLAB,
            Blocks.MOSSY_COBBLESTONE_STAIRS,
            Blocks.MOSSY_COBBLESTONE_WALL,

            Blocks.ANDESITE,
            Blocks.POLISHED_ANDESITE,
            Blocks.ANDESITE_SLAB,
            Blocks.POLISHED_ANDESITE_SLAB,
            Blocks.ANDESITE_STAIRS,
            Blocks.POLISHED_ANDESITE_STAIRS,
            Blocks.ANDESITE_WALL,

            Blocks.GRANITE,
            Blocks.POLISHED_GRANITE,
            Blocks.GRANITE_SLAB,
            Blocks.POLISHED_GRANITE_SLAB,
            Blocks.GRANITE_STAIRS,
            Blocks.POLISHED_GRANITE_STAIRS,
            Blocks.GRANITE_WALL,

            Blocks.DIORITE,
            Blocks.POLISHED_DIORITE,
            Blocks.DIORITE_SLAB,
            Blocks.POLISHED_DIORITE_SLAB,
            Blocks.DIORITE_STAIRS,
            Blocks.POLISHED_DIORITE_STAIRS,
            Blocks.DIORITE_WALL,

            Blocks.TUFF,
            Blocks.POLISHED_TUFF,
            Blocks.TUFF_SLAB,
            Blocks.POLISHED_TUFF_SLAB,
            Blocks.TUFF_STAIRS,
            Blocks.POLISHED_TUFF_STAIRS,
            Blocks.TUFF_WALL,
            Blocks.TUFF_BRICKS,
            Blocks.TUFF_BRICK_SLAB,
            Blocks.TUFF_BRICK_STAIRS,
            Blocks.TUFF_BRICK_WALL,
            Blocks.CHISELED_TUFF,
            Blocks.CHISELED_TUFF_BRICKS,

            Blocks.POLISHED_DEEPSLATE,
            Blocks.DEEPSLATE_BRICKS,
            Blocks.DEEPSLATE_TILES,
            Blocks.CRACKED_DEEPSLATE_BRICKS,
            Blocks.CRACKED_DEEPSLATE_TILES,
            Blocks.CHISELED_DEEPSLATE,
            Blocks.COBBLED_DEEPSLATE_SLAB,
            Blocks.POLISHED_DEEPSLATE_SLAB,
            Blocks.DEEPSLATE_BRICK_SLAB,
            Blocks.DEEPSLATE_TILE_SLAB,
            Blocks.COBBLED_DEEPSLATE_STAIRS,
            Blocks.POLISHED_DEEPSLATE_STAIRS,
            Blocks.DEEPSLATE_BRICK_STAIRS,
            Blocks.DEEPSLATE_TILE_STAIRS,
            Blocks.COBBLED_DEEPSLATE_WALL,
            Blocks.POLISHED_DEEPSLATE_WALL,
            Blocks.DEEPSLATE_BRICK_WALL,
            Blocks.DEEPSLATE_TILE_WALL,

            Blocks.SANDSTONE,
            Blocks.CHISELED_SANDSTONE,
            Blocks.SMOOTH_SANDSTONE,
            Blocks.SANDSTONE_SLAB,
            Blocks.SMOOTH_SANDSTONE_SLAB,
            Blocks.SANDSTONE_STAIRS,
            Blocks.SMOOTH_SANDSTONE_STAIRS,
            Blocks.SANDSTONE_WALL,
            Blocks.RED_SANDSTONE,
            Blocks.CHISELED_RED_SANDSTONE,
            Blocks.SMOOTH_RED_SANDSTONE,
            Blocks.RED_SANDSTONE_SLAB,
            Blocks.SMOOTH_RED_SANDSTONE_SLAB,
            Blocks.RED_SANDSTONE_STAIRS,
            Blocks.SMOOTH_RED_SANDSTONE_STAIRS,
            Blocks.RED_SANDSTONE_WALL
    };

    static Block[][] PlanksBlockCombo = {
            {Blocks.OAK_PLANKS, SnailBlocks.DAMAGED_OAK_PLANKS, Blocks.OAK_SLAB, Blocks.OAK_LOG},
            {Blocks.SPRUCE_PLANKS, SnailBlocks.DAMAGED_SPRUCE_PLANKS, Blocks.SPRUCE_SLAB, Blocks.SPRUCE_LOG},
            {Blocks.BIRCH_PLANKS, SnailBlocks.DAMAGED_BIRCH_PLANKS, Blocks.BIRCH_SLAB, Blocks.BIRCH_LOG},
            {Blocks.JUNGLE_PLANKS, SnailBlocks.DAMAGED_JUNGLE_PLANKS, Blocks.JUNGLE_SLAB, Blocks.JUNGLE_LOG},
            {Blocks.ACACIA_PLANKS, SnailBlocks.DAMAGED_ACACIA_PLANKS, Blocks.ACACIA_SLAB, Blocks.ACACIA_LOG},
            {Blocks.DARK_OAK_PLANKS, SnailBlocks.DAMAGED_DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_LOG},
            {Blocks.MANGROVE_PLANKS, SnailBlocks.DAMAGED_MANGROVE_PLANKS, Blocks.MANGROVE_SLAB, Blocks.MANGROVE_LOG},
            {Blocks.CHERRY_PLANKS, SnailBlocks.DAMAGED_CHERRY_PLANKS, Blocks.CHERRY_SLAB, Blocks.CHERRY_LOG},
            {Blocks.PALE_OAK_PLANKS, SnailBlocks.DAMAGED_PALE_OAK_PLANKS, Blocks.PALE_OAK_SLAB, Blocks.PALE_OAK_LOG},
            {Blocks.CRIMSON_PLANKS, SnailBlocks.DAMAGED_CRIMSON_PLANKS, Blocks.CRIMSON_SLAB, Blocks.CRIMSON_STEM},
            {Blocks.WARPED_PLANKS, SnailBlocks.DAMAGED_WARPED_PLANKS, Blocks.WARPED_SLAB, Blocks.WARPED_STEM},
            {Blocks.BAMBOO_PLANKS, SnailBlocks.DAMAGED_BAMBOO_PLANKS, Blocks.BAMBOO_SLAB, Blocks.BAMBOO_BLOCK}
    };

    public static void playerBreak(){
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            if (wgatIsTarget(SnailBlockTagsProvider.STONE_BLOCK, player, state)) {
                ItemStack stack = player.getMainHandStack();
                if (playerHas(Items.FLINT, player)) {
                    degradeStoneSmall(world, pos, state, true);
                    damageItem(stack, player, world, true);
                    givePlayer(SnailItems.FLINT_FLAKE, player, world);
                }
            }
            if (wgatIsTarget(SnailBlockTagsProvider.STONE_BLOCK, player, state)){
                ItemStack stack = player.getMainHandStack();
                if (hasBetterPickaxe(stack)){
                    return true;
                } else if (hasIronPickaxe(stack)){
                    if (!hasReachedCrumbled(state)) {
                        degradeStoneHuge(world, pos, state, true);
                        damageItem(stack, player, world, true);
                        return false;
                    } else {
                        return true;
                    }
                } else if(hasStonePickaxe(stack)){
                    if (!hasReachedCrumbled(state)) {
                        degradeStoneBig(world, pos, state, true);
                        damageItem(stack, player, world, true);
                        return false;
                    } else {
                        return true;
                    }
                } else if (hasWoodenPickaxe(stack)){
                    if (!hasReachedCrumbled(state)) {
                        degradeStoneSmall(world, pos, state, true);
                        damageItem(stack, player, world, true);
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    if (!hasReachedCrumbled(state)) {
                        degradeStoneSmall(world, pos, state, false);
                        damageItem(stack, player, world, false);
                        return false;
                    } else {
                        return true;
                    }
                }
            }
//            if (wgatIsTarget(BlockTags.LOGS, player, state)){
//                ItemStack stack = player.getMainHandStack();
//                if (stack.isOf(SnailItems.CIRCULAR_SAW)){
//                    planksLog(world, pos, state);
//                }
//            }

            if (wgatIsTarget(BlockTags.PLANKS, player, state)){
                ItemStack stack = player.getMainHandStack();

                if (hasBetterAxe(stack)){
                    return true;
                } else if (hasWoodenAxe(stack) || hasStoneAxe(stack)){
                    if (!hasReachedDamaged(state)) {
                        degradePlanks(world, pos, state, true);
                        damageItem(stack, player, world, true);
                        return false;
                    } else {
                        return true;
                    }
                } else if (stack.isOf(SnailItems.CIRCULAR_SAW)){
                    halfSlab(world, pos, state);
                    return false;
                } else {
                    if (!hasReachedDamaged(state)) {
                        degradePlanks(world, pos, state, false);
                        damageItem(stack, player, world, false);
                        return false;
                    } else {
                        return true;
                    }
                }
            }
            return true;
        });

        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if (wgatIsTarget(SnailBlockTagsProvider.ORES, player, state) ||
                wgatIsTarget(SnailBlockTagsProvider.DEEPSLATE_ORES, player, state) ||
                whatIsTarget(Blocks.NETHER_GOLD_ORE, player, state)){
                degradeOreBlock(world, pos, state);
            }
        });
    }



    private static void halfSlab(World world, BlockPos pos, BlockState state) {
        for (Block[] blocks : PlanksBlockCombo) {
            Block inputLog = blocks[0];
            Block outputPlanks = blocks[2];

            if (state.isOf(inputLog)) {
                world.setBlockState(pos, outputPlanks.getDefaultState());
                return;
            }
        }
    }

    private static boolean hasReachedDamaged(BlockState state) {
        return state.isIn(SnailBlockTagsProvider.DAMAGED_PLANKS);
    }


    private static void degradePlanks(World world, BlockPos pos, BlockState state, boolean canDrop) {
        if (world.isClient()) return;
        for (Block[] entry : PlanksBlockCombo){
            Block normal = entry[0];
            Block damaged = entry[1];
            if (state.isOf(normal)){
                turnBlockTo(damaged, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.WOOD_DUST, pos);
                    addDrop(world, SnailItems.WOOD_DUST, pos);
                }
            }
        }
    }
    private static boolean hasWoodenAxe(ItemStack stack) {
        return stack.isIn(SnailItemTagsProvider.WOODEN_TOOLS) && stack.isIn(ItemTags.AXES);
    }

    private static boolean hasStoneAxe(ItemStack stack) {
        return stack.isIn(SnailItemTagsProvider.STONE_TOOLS) && stack.isIn(ItemTags.AXES);
    }

    private static boolean hasBetterAxe(ItemStack stack) {
        return  (stack.isIn(SnailItemTagsProvider.IRON_TOOLS) && stack.isIn(ItemTags.AXES)) ||
                (stack.isIn(SnailItemTagsProvider.DIAMOND_TOOLS) && stack.isIn(ItemTags.AXES)) ||
                (stack.isIn(SnailItemTagsProvider.NETHERITE_TOOLS) && stack.isIn(ItemTags.AXES));
    }

    private static boolean hasBetterPickaxe(ItemStack stack) {
        return (stack.isIn(SnailItemTagsProvider.DIAMOND_TOOLS) && stack.isIn(ItemTags.PICKAXES)) ||
                (stack.isIn(SnailItemTagsProvider.NETHERITE_TOOLS) && stack.isIn(ItemTags.PICKAXES));
    }

    private static boolean hasWoodenPickaxe(ItemStack stack) {
        return stack.isIn(SnailItemTagsProvider.WOODEN_TOOLS) && stack.isIn(ItemTags.PICKAXES);
    }

    private static boolean hasStonePickaxe(ItemStack stack) {
        return stack.isIn(SnailItemTagsProvider.STONE_TOOLS) && stack.isIn(ItemTags.PICKAXES);
    }
    private static boolean hasIronPickaxe(ItemStack stack) {
        return stack.isIn(SnailItemTagsProvider.IRON_TOOLS) && stack.isIn(ItemTags.PICKAXES);
    }

    private static boolean hasReachedCrumbled(BlockState state) {
        return state.isIn(SnailBlockTagsProvider.CRUMBLED_STONE_BLOCK);
    }

    private static void damageItem(ItemStack stack, PlayerEntity player, World world, boolean canDecrement) {
        if (world.isClient()) return;
        if (stack.isDamageable()){
            stack.damage(1, player);
        }
        if (canDecrement){
            stack.decrement(1);
        }
    }

    private static void degradeOreBlock(World world, BlockPos pos, BlockState state){
        if (world.isClient()) return;
        if (state.isIn(SnailBlockTagsProvider.ORES)){
            turnBlockTo(Blocks.STONE, pos, state, world);
        } else if (state.isIn(SnailBlockTagsProvider.DEEPSLATE_ORES)){
            turnBlockTo(Blocks.DEEPSLATE, pos, state, world);
        } else if (state.isOf(Blocks.NETHER_GOLD_ORE)){
            turnBlockTo(Blocks.NETHERRACK, pos, state, world);
        }
    }

    private static void degradeStoneHuge(World world, BlockPos pos, BlockState state, boolean canDrop) {
        if (world.isClient()) return;
        for (Block[] stone : StoneBlockCombo){
            Block scratched = stone[1];
            Block cracked = stone[2];
            Block cobbled = stone[3];
            Block fractured = stone[4];
            Block crumbled = stone[5];
            if (state.isOf(stone[0])){
                turnBlockTo(cobbled, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.STONE_DUST, pos);
                    addDrop(world, SnailItems.PEBBLE, pos);
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            } else if (state.isOf(scratched)){
                turnBlockTo(fractured, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.PEBBLE, pos);
                    addDrop(world, SnailItems.PEBBLE, pos);
                    addDrop(world, SnailItems.STONE_DUST, pos);
                }
            } else if (state.isOf(cracked)){
                turnBlockTo(crumbled, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.PEBBLE, pos);
                    addDrop(world, SnailItems.PEBBLE, pos);
                    addDrop(world, SnailItems.STONE_DUST, pos);
                }
            } else if (state.isOf(cobbled)){
                turnBlockTo(crumbled, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.STONE_DUST, pos);
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            } else if (state.isOf(fractured)){
                turnBlockTo(crumbled, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            }
        }
    }

    private static void degradeStoneBig(World world, BlockPos pos, BlockState state, boolean canDrop) {
        if (world.isClient()) return;
        for (Block[] stone : StoneBlockCombo){
            Block scratched = stone[1];
            Block cracked = stone[2];
            Block cobbled = stone[3];
            Block fractured = stone[4];
            Block crumbled = stone[5];
            if (state.isOf(stone[0])){
                turnBlockTo(cracked, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.STONE_DUST, pos);
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            } else if (state.isOf(scratched)){
                turnBlockTo(cobbled, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.PEBBLE, pos);
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            } else if (state.isOf(cracked)){
                turnBlockTo(fractured, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.PEBBLE, pos);
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            } else if (state.isOf(cobbled)){
                turnBlockTo(crumbled, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.STONE_DUST, pos);
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            } else if (state.isOf(fractured)){
                turnBlockTo(crumbled, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            }
        }
    }
    private static void degradeStoneSmall(World world, BlockPos pos, BlockState state, boolean canDrop) {
        if (world.isClient()) return;
        for (Block[] stone : StoneBlockCombo){
            Block scratched = stone[1];
            Block cracked = stone[2];
            Block cobbled = stone[3];
            Block fractured = stone[4];
            Block crumbled = stone[5];
            if (state.isOf(stone[0])){
                turnBlockTo(scratched, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.STONE_DUST, pos);
                }
            } else if (state.isOf(scratched)){
                turnBlockTo(cracked, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            } else if (state.isOf(cracked)){
                turnBlockTo(cobbled, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            } else if (state.isOf(cobbled)){
                turnBlockTo(fractured, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.STONE_DUST, pos);
                }
            } else if (state.isOf(fractured)){
                turnBlockTo(crumbled, pos, state, world);
                if (canDrop){
                    addDrop(world, SnailItems.PEBBLE, pos);
                }
            }
        }
    }

    private static void turnBlockTo(Block block, BlockPos pos, BlockState state, World world) {
        if (world.isClient()) return;
        world.setBlockState(pos, block.getStateWithProperties(state));
    }

    private static void addDrop(World world, Item item, BlockPos pos) {
        if (world.isClient()) return;
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), item.getDefaultStack());
    }
    private static void givePlayer(Item item, PlayerEntity player, World world){
        if (world.isClient()) return;
        player.giveOrDropStack(item.getDefaultStack());
    }

    private static boolean wgatIsTarget(TagKey<Block> targetBlockTag, PlayerEntity player, BlockState state) {
        return !player.isCreative() && state.isIn(targetBlockTag);
    }
    private static boolean whatIsTarget(Block block, PlayerEntity player, BlockState state) {
        return !player.isCreative() && state.isOf(block);
    }

    private static boolean playerHas(Item item, PlayerEntity player) {
        ItemStack mainHandItem = player.getMainHandStack();
        return mainHandItem.getItem() == item;
    }
}
