package net.numericalk.blocks.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItems;

public class TiedThatchBlock extends PillarBlock {
    public TiedThatchBlock(Settings settings) {
        super(settings);
    }
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (player.getMainHandStack().isEmpty()){
            world.setBlockState(pos, SnailBlocks.UNTIED_THATCH_BLOCK.getStateWithProperties(state));
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.GRASS_TWINE.getDefaultStack());

            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
