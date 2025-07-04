package net.numericalk.snailspeed.blocks.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.blocks.entity.custom.CustomWallTorchBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class CustomWallTorchBlock extends CustomTorchBlock{
    public static final MapCodec<CustomWallTorchBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(PARTICLE_TYPE_CODEC.forGetter(block -> block.particle), createSettingsCodec()).apply(instance, CustomWallTorchBlock::new)
    );    public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;

    private static final Map<Direction, VoxelShape> BOUNDING_SHAPES = Maps.newEnumMap(
            ImmutableMap.of(
                    Direction.NORTH,
                    Block.createCuboidShape(5.5, 3.0, 11.0, 10.5, 13.0, 16.0),
                    Direction.SOUTH,
                    Block.createCuboidShape(5.5, 3.0, 0.0, 10.5, 13.0, 5.0),
                    Direction.WEST,
                    Block.createCuboidShape(11.0, 3.0, 5.5, 16.0, 13.0, 10.5),
                    Direction.EAST,
                    Block.createCuboidShape(0.0, 3.0, 5.5, 5.0, 13.0, 10.5)
            )
    );

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CustomWallTorchBlockEntity(pos, state);
    }
    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, SnailBlockEntities.WALL_TORCH,
                (world1, pos, state1, blockEntity) ->
                        blockEntity.tick(world1, pos, state1));
    }
    @Override
    public MapCodec<CustomWallTorchBlock> getCodec() {
        return CODEC;
    }
    public CustomWallTorchBlock(SimpleParticleType simpleParticleType, Settings settings) {
        super(simpleParticleType, settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(CustomTorchBlock.LIT, CustomTorchBlock.LIT_UNLIT));
    }
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getBoundingShape(state);
    }

    public static VoxelShape getBoundingShape(BlockState state) {
        return BOUNDING_SHAPES.get(state.get(FACING));
    }
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT) == LIT_LIT){
            Direction direction = state.get(FACING);
            double d = pos.getX() + 0.5;
            double e = pos.getY() + 0.7;
            double f = pos.getZ() + 0.5;
            double g = 0.22;
            double h = 0.27;
            Direction direction2 = direction.getOpposite();
            world.addParticle(ParticleTypes.SMOKE, d + 0.27 * direction2.getOffsetX(), e + 0.22, f + 0.27 * direction2.getOffsetZ(), 0.0, 0.0, 0.0);
            world.addParticle(this.particle, d + 0.27 * direction2.getOffsetX(), e + 0.22, f + 0.27 * direction2.getOffsetZ(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return canPlaceAt(world, pos, state.get(FACING));
    }

    public static boolean canPlaceAt(WorldView world, BlockPos pos, Direction facing) {
        BlockPos blockPos = pos.offset(facing.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isSideSolidFullSquare(world, blockPos, facing);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = this.getDefaultState();
        WorldView worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction[] directions = ctx.getPlacementDirections();

        for (Direction direction : directions) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction2 = direction.getOpposite();
                blockState = blockState.with(FACING, direction2);
                if (blockState.canPlaceAt(worldView, blockPos)) {
                    return blockState;
                }
            }
        }

        return null;
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        return direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
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
        builder.add(FACING, CustomTorchBlock.LIT);
    }
}
