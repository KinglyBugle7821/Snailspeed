package net.numericalk.blocks.custom;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CrackedLogBlock extends PillarBlock {
    private static final VoxelShape SHAPE_Y = Block.createCuboidShape(3,0,3,13,16,13);
    private static final VoxelShape SHAPE_X = Block.createCuboidShape(0,3,3,16,13,13);
    private static final VoxelShape SHAPE_Z = Block.createCuboidShape(3,3,0,13,13,16);

    public CrackedLogBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(AXIS)) {
            case X -> SHAPE_X;
            case Y -> SHAPE_Y;
            case Z -> SHAPE_Z;
            default -> SHAPE_Y;
        };
    }
}
