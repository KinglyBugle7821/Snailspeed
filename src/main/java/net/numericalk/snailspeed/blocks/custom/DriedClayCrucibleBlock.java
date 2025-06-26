package net.numericalk.snailspeed.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.block.WireOrientation;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.blocks.entity.custom.DriedClayCrucibleBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class DriedClayCrucibleBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final MapCodec<DriedClayCrucibleBlock> CODEC = DriedClayCrucibleBlock.createCodec(DriedClayCrucibleBlock::new);
    public static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(6, 1, 5, 10, 2, 6),
            Block.createCuboidShape(6, 1, 10, 10, 2, 11),
            Block.createCuboidShape(5, 1, 6, 6, 2, 10),
            Block.createCuboidShape(10, 1, 6, 11, 2, 10),
            Block.createCuboidShape(6, 2, 4, 10, 10, 5),
            Block.createCuboidShape(6, 2, 11, 10, 10, 12),
            Block.createCuboidShape(4, 2, 6, 5, 10, 10),
            Block.createCuboidShape(11, 2, 6, 12, 10, 10),
            Block.createCuboidShape(5, 2, 5, 6, 10, 6),
            Block.createCuboidShape(5, 2, 10, 6, 10, 11),
            Block.createCuboidShape(10, 2, 10, 11, 10, 11),
            Block.createCuboidShape(6, 0, 6, 10, 1, 10),
            Block.createCuboidShape(10, 2, 5, 11, 10, 6)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public DriedClayCrucibleBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DriedClayCrucibleBlockEntity(pos, state);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);
        checkSupport(state, world, pos);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        checkSupport(state, world, pos);
    }

    private void checkSupport(BlockState state, World world, BlockPos pos) {
        if (!world.getBlockState(pos.down()).isSideSolidFullSquare(world, pos.down(), net.minecraft.util.math.Direction.UP)) {
            world.breakBlock(pos, true);
        }
    }
    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient()){
            return null;
        }
        return validateTicker(type, SnailBlockEntities.DRIED_CLAY_CRUCIBLE_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) ->
                        blockEntity.tick(world1, pos, state1));
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSideSolidFullSquare(world, pos.down(), net.minecraft.util.math.Direction.UP);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
