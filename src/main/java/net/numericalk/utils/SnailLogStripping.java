package net.numericalk.utils;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItems;

public class SnailLogStripping {
    public static void logStripping() {
        Object[][] itemDrop = {
                {Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD, SnailItems.OAK_LOG_BARK},
                {Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD, SnailItems.SPRUCE_LOG_BARK},
                {Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD, SnailItems.BIRCH_LOG_BARK},
                {Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD, SnailItems.JUNGLE_LOG_BARK},
                {Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD, SnailItems.ACACIA_LOG_BARK},
                {Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD, SnailItems.DARK_OAK_LOG_BARK},
                {Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD, SnailItems.MANGROVE_LOG_BARK},
                {Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD, SnailItems.CHERRY_LOG_BARK},
                {Blocks.PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_LOG, Blocks.PALE_OAK_WOOD, Blocks.STRIPPED_PALE_OAK_WOOD, SnailItems.PALE_OAK_LOG_BARK},
                {Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE, SnailItems.CRIMSON_STEM_BARK},
                {Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE, SnailItems.WARPED_STEM_BARK}
        };

        UseBlockCallback.EVENT.register((playerEntity, world, hand, blockHitResult) -> {
            BlockPos pos = blockHitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            ItemStack stack = playerEntity.getStackInHand(hand);

            for (Object[] entry : itemDrop) {
                Block barkedLog = (Block) entry[0];
                Block strippedLog = (Block) entry[1];
                Block barkedWood = (Block) entry[2];
                Block strippedWood = (Block) entry[3];
                Item barkDrop = (Item) entry[4];
                if (stack.isIn(ItemTags.AXES)) {
                    if (state.isOf(barkedLog)){
                        if (world instanceof ServerWorld serverWorld) {
                            ItemStack drop = new ItemStack(barkDrop, 1);
                            Block.dropStack(serverWorld, pos, drop);
                        }
                        world.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        stack.damage(1, playerEntity, playerEntity.getPreferredEquipmentSlot(stack));

                        world.setBlockState(pos, strippedLog.getStateWithProperties(state));
                    }
                    if (state.isOf(barkedWood)){
                        if (world instanceof ServerWorld serverWorld) {
                            ItemStack drop = new ItemStack(barkDrop, 2);
                            Block.dropStack(serverWorld, pos, drop);
                        }
                        world.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        stack.damage(1, playerEntity, playerEntity.getPreferredEquipmentSlot(stack));

                        world.setBlockState(pos, strippedWood.getStateWithProperties(state));
                    }
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        });
    }
}
