package net.numericalk.snailspeed.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class TrimmedLogBlock extends PillarBlock {
    private static final VoxelShape SHAPE_Y = Block.createCuboidShape(1, 0, 1, 15, 16, 15);
    private static final VoxelShape SHAPE_X = Block.createCuboidShape(0, 1, 1, 16, 15, 15);
    private static final VoxelShape SHAPE_Z = Block.createCuboidShape(1, 1, 0, 15, 15, 16);

    public TrimmedLogBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(AXIS)) {
            case X -> SHAPE_X;
            case Y -> SHAPE_Y;
            case Z -> SHAPE_Z;
        };
    }
}
