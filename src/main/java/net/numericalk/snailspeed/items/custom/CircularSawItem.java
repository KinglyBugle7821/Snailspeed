package net.numericalk.snailspeed.items.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.SnailBlocks;

import java.util.List;

public class CircularSawItem extends Item {
    public CircularSawItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = context.getWorld().getBlockState(pos);
        ItemStack stack = context.getPlayer().getMainHandStack();

        if (state.isIn(BlockTags.WOODEN_SLABS)) {
            world.setBlockState(pos, SnailBlocks.SAW_TABLE.getDefaultState());
            stack.decrement(1);
            world.playSound(player, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.SUCCESS;
        }
        if (state.isOf(Blocks.STONE_SLAB)) {
            world.setBlockState(pos, Blocks.STONECUTTER.getDefaultState());
            stack.decrement(1);
            world.playSound(player, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.snailspeed.has_shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.snailspeed.item.circular_saw"));
            tooltip.add(Text.translatable("tooltip.snailspeed.guide.circular_saw_1"));
            tooltip.add(Text.translatable("tooltip.snailspeed.guide.circular_saw_2"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
