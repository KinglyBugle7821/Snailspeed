package net.numericalk.utils;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.datagen.SnailBlockTagsProvider;
import net.numericalk.datagen.SnailItemTagsProvider;
import net.numericalk.items.SnailItems;

public class SnailBreakEvents {
    static Block[][] StoneBlockCombo = {
            {Blocks.STONE, SnailBlocks.SCRATCHED_STONE, SnailBlocks.CRACKED_STONE, Blocks.COBBLESTONE, SnailBlocks.FRACTURED_STONE, SnailBlocks.CRUMBLED_STONE},
            {Blocks.DEEPSLATE, SnailBlocks.SCRATCHED_DEEPSLATE, SnailBlocks.CRACKED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE, SnailBlocks.FRACTURED_DEEPSLATE, SnailBlocks.CRUMBLED_DEEPSLATE}
    };

    public static void playerBreak(){
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            if (whatIsTarget(Blocks.STONE, player, state) || whatIsTarget(Blocks.DEEPSLATE, player, state)) {
                if (playerHas(Items.FLINT, player)) {
                    degradeStoneSmall(world, pos, state);
                    decrementStack(player, world);
                    givePlayer(SnailItems.FLINT_FLAKE, world, player);
                }
            }
            if (wgatIsTarget(SnailBlockTagsProvider.STONE_BLOCK, player, state)){
                ItemStack stack = player.getMainHandStack();
                if (hasBetterPickaxe(stack)){
                    return true;
                } else if (hasIronPickaxe(stack)){
                    if (!hasReachedCrumbled(state)) {
                        degradeStoneHuge(world, pos, state);
                        damageItem(stack, player, world);
                        return false;
                    } else {
                        return true;
                    }
                } else if(hasStonePickaxe(stack)){
                    if (!hasReachedCrumbled(state)) {
                        degradeStoneBig(world, pos, state);
                        damageItem(stack, player, world);
                        return false;
                    } else {
                        return true;
                    }
                } else if (hasWoodenPickaxe(stack)){
                    if (!hasReachedCrumbled(state)) {
                        degradeStoneSmall(world, pos, state);
                        damageItem(stack, player, world);
                        return false;
                    } else {
                        return true;
                    }
                }
                return false;
            }
            return true;
        });
    }

    private static boolean hasBetterPickaxe(ItemStack stack) {
        return (stack.isIn(ItemTags.DIAMOND_TOOL_MATERIALS) && stack.isIn(ItemTags.PICKAXES)) ||
                (stack.isIn(ItemTags.NETHERITE_TOOL_MATERIALS) && stack.isIn(ItemTags.PICKAXES));
    }

    private static boolean hasWoodenPickaxe(ItemStack stack) {
        return stack.isIn(ItemTags.WOODEN_TOOL_MATERIALS) && stack.isIn(ItemTags.PICKAXES);
    }

    private static boolean hasStonePickaxe(ItemStack stack) {
        return stack.isIn(ItemTags.STONE_TOOL_MATERIALS) && stack.isIn(ItemTags.PICKAXES);
    }
    private static boolean hasIronPickaxe(ItemStack stack) {
        return stack.isIn(ItemTags.IRON_TOOL_MATERIALS) && stack.isIn(ItemTags.PICKAXES);
    }

    private static boolean hasReachedCrumbled(BlockState state) {
        return state.isIn(SnailBlockTagsProvider.CRUMBLED_STONE_BLOCK);
    }

    private static void damageItem(ItemStack stack, PlayerEntity player, World world) {
        if (!world.isClient()){
            if (stack.isDamageable()){
                stack.damage(1, player);
            }
            else stack.decrement(1);
        }
    }

    private static void decrementStack(PlayerEntity player, World world) {
        if (!world.isClient()){
            player.getMainHandStack().decrement(1);
        }
    }
    private static void degradeStoneHuge(World world, BlockPos pos, BlockState state) {
        for (Block[] stone : StoneBlockCombo){
            Block scratched = stone[1];
            Block cracked = stone[2];
            Block cobbled = stone[3];
            Block fractured = stone[4];
            Block crumbled = stone[5];
            if (state.isOf(stone[0])){
                turnBlockTo(cobbled, pos, state, world);
                addDrop(world, SnailItems.STONE_DUST, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
            } else if (state.isOf(scratched)){
                turnBlockTo(fractured, pos, state, world);
                addDrop(world, SnailItems.PEBBLE, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
                addDrop(world, SnailItems.STONE_DUST, pos);
            } else if (state.isOf(cracked)){
                turnBlockTo(crumbled, pos, state, world);
                addDrop(world, SnailItems.PEBBLE, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
                addDrop(world, SnailItems.STONE_DUST, pos);
            } else if (state.isOf(cobbled)){
                turnBlockTo(crumbled, pos, state, world);
                addDrop(world, SnailItems.STONE_DUST, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
            } else if (state.isOf(fractured)){
                turnBlockTo(crumbled, pos, state, world);
                addDrop(world, SnailItems.STONE_DUST, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
            }
        }
    }

    private static void degradeStoneBig(World world, BlockPos pos, BlockState state) {
        for (Block[] stone : StoneBlockCombo){
            Block scratched = stone[1];
            Block cracked = stone[2];
            Block cobbled = stone[3];
            Block fractured = stone[4];
            Block crumbled = stone[5];
            if (state.isOf(stone[0])){
                turnBlockTo(cracked, pos, state, world);
                addDrop(world, SnailItems.STONE_DUST, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
            } else if (state.isOf(scratched)){
                turnBlockTo(cobbled, pos, state, world);
                addDrop(world, SnailItems.PEBBLE, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
            } else if (state.isOf(cracked)){
                turnBlockTo(fractured, pos, state, world);
                addDrop(world, SnailItems.PEBBLE, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
            } else if (state.isOf(cobbled)){
                turnBlockTo(crumbled, pos, state, world);
                addDrop(world, SnailItems.STONE_DUST, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
            } else if (state.isOf(fractured)){
                turnBlockTo(crumbled, pos, state, world);
                addDrop(world, SnailItems.STONE_DUST, pos);
                addDrop(world, SnailItems.PEBBLE, pos);
            }
        }
    }
    private static void degradeStoneSmall(World world, BlockPos pos, BlockState state) {
        for (Block[] stone : StoneBlockCombo){
            Block scratched = stone[1];
            Block cracked = stone[2];
            Block cobbled = stone[3];
            Block fractured = stone[4];
            Block crumbled = stone[5];
            if (state.isOf(stone[0])){
                turnBlockTo(scratched, pos, state, world);
                addDrop(world, SnailItems.STONE_DUST, pos);
            } else if (state.isOf(scratched)){
                turnBlockTo(cracked, pos, state, world);
                addDrop(world, SnailItems.PEBBLE, pos);
            } else if (state.isOf(cracked)){
                turnBlockTo(cobbled, pos, state, world);
                addDrop(world, SnailItems.PEBBLE, pos);
            } else if (state.isOf(cobbled)){
                turnBlockTo(fractured, pos, state, world);
                addDrop(world, SnailItems.STONE_DUST, pos);
            } else if (state.isOf(fractured)){
                turnBlockTo(crumbled, pos, state, world);
                addDrop(world, SnailItems.STONE_DUST, pos);
            }
        }
    }

    private static void turnBlockTo(Block block, BlockPos pos, BlockState state, World world) {
        if (!world.isClient()){
            world.setBlockState(pos, block.getStateWithProperties(state));
        }
    }

    private static void addDrop(World world, Item item, BlockPos pos) {
        if (!world.isClient()){
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), item.getDefaultStack());
        }
    }
    private static void givePlayer(Item item, World world, PlayerEntity player){
        if (!world.isClient()){
            player.giveOrDropStack(item.getDefaultStack());
        }
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
