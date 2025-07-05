package net.numericalk.snailspeed.items.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.SnailBlocks;

import java.util.List;

public class BarkSpudItem extends Item {
    //Bark Blud😂😂😂😂
    public BarkSpudItem(Settings settings) {
        super(settings);
    }

    Block[][] tappedLog = {
            {Blocks.SPRUCE_LOG, SnailBlocks.TAPPED_SPRUCE_LOG},
            {Blocks.BIRCH_LOG, SnailBlocks.TAPPED_BIRCH_LOG},
            {Blocks.PALE_OAK_LOG, SnailBlocks.TAPPED_PALE_OAK_LOG}
    };

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        BlockState state = context.getWorld().getBlockState(pos);
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        PlayerEntity player = context.getPlayer();
        for (Block[] blocks : tappedLog) {
            if (state.isOf(blocks[0])) {
                world.setBlockState(pos, blocks[1].getStateWithProperties(state));
                world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1f, 1f);
                stack.damage(1, player);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.snailspeed.has_shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.snailspeed.item.bark_spud"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
