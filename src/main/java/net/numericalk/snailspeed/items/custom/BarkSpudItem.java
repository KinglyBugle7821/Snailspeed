package net.numericalk.snailspeed.items.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.SnailBlocksBrain;

public class BarkSpudItem extends Item {
    //Bark Blud😂😂😂😂
    public BarkSpudItem(Settings settings) {
        super(settings);
    }

    Block[][] tappedLog = {
            {Blocks.SPRUCE_LOG, SnailBlocksBrain.TAPPED_SPRUCE_LOG},
            {Blocks.BIRCH_LOG, SnailBlocksBrain.TAPPED_BIRCH_LOG},
            {Blocks.PALE_OAK_LOG, SnailBlocksBrain.TAPPED_PALE_OAK_LOG}
    };

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        BlockState state = context.getWorld().getBlockState(pos);
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        PlayerEntity player = context.getPlayer();
        for (Block[] blocks : tappedLog){
            if (state.isOf(blocks[0])){
                world.setBlockState(pos, blocks[1].getStateWithProperties(state));
                world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1f, 1f);
                stack.damage(1, player);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
