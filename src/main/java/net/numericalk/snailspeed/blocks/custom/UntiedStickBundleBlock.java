package net.numericalk.snailspeed.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.block.PillarBlock.changeRotation;

public class UntiedStickBundleBlock extends FallingBlock {

    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;
    public static final MapCodec<UntiedStickBundleBlock> CODEC = UntiedStickBundleBlock.createCodec(UntiedStickBundleBlock::new);

    public UntiedStickBundleBlock(Settings settings) {
        super(settings);
        this.setDefaultState( this.getDefaultState().with(AXIS, Direction.Axis.Y));
    }
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return changeRotation(state, rotation);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(SnailItems.GRASS_TWINE)){
            world.setBlockState(pos, SnailBlocks.STICK_BUNDLE.getStateWithProperties(state));
            if (!player.isCreative()){
                stack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }
}
