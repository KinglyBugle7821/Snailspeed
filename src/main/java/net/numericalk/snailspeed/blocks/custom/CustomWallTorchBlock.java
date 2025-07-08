package net.numericalk.snailspeed.blocks.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.blocks.entity.custom.CustomTorchBlockEntity;
import net.numericalk.snailspeed.blocks.entity.custom.CustomWallTorchBlockEntity;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.Map;

public class CustomWallTorchBlock extends CustomTorchBlock{
    public static final MapCodec<CustomWallTorchBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(PARTICLE_TYPE_CODEC.forGetter(block -> block.particle), createSettingsCodec()).apply(instance, CustomWallTorchBlock::new)
    );

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
        this.setDefaultState(this.stateManager.getDefaultState().with(WallTorchBlock.FACING, Direction.NORTH).with(CustomTorchBlock.LIT, CustomTorchBlock.LIT_UNLIT));
    }
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getBoundingShape(state);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (canLitTorchWith(Items.FLINT_AND_STEEL, stack, state, world, pos)) {
            litTorchWith(SoundEvents.ITEM_FLINTANDSTEEL_USE, stack, player, state, world, pos);
            return ActionResult.SUCCESS;
        } else if (canLitTorchWith(Items.FIRE_CHARGE, stack, state, world, pos)
                || canLitTorchWith(SnailItems.BURNING_TINDER, stack, state, world, pos)) {
            litTorchWith(SoundEvents.ITEM_FIRECHARGE_USE, stack, player, state, world, pos);
            return ActionResult.SUCCESS;
        }

        if (stack.isOf(SnailItems.HELLSTONE_DUST)){
            world.playSound(player, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1f, 1f);
            if (!player.isCreative()){
                stack.decrement(1);
            }
            world.setBlockState(pos, Blocks.WALL_TORCH.getStateWithProperties(state));
            return ActionResult.SUCCESS;
        }

        if (state.get(LIT) == LIT_ASH && stack.isIn(SnailItemTagsProvider.OVEN_FUEL)){
            if (world.getBlockEntity(pos) instanceof CustomTorchBlockEntity customTorchBlockEntity){
                world.setBlockState(pos, state.with(LIT, LIT_UNLIT));
                customTorchBlockEntity.setFireDegradeTime(customTorchBlockEntity.fireDegradeTimeFinal);
                if (!player.isCreative()){
                    stack.decrement(1);
                }
                return ActionResult.SUCCESS;
            } else if (world.getBlockEntity(pos) instanceof CustomWallTorchBlockEntity customWallTorchBlockEntity){
                world.setBlockState(pos, state.with(LIT, LIT_UNLIT));
                customWallTorchBlockEntity.setFireDegradeTime(customWallTorchBlockEntity.fireDegradeTimeFinal);
                if (!player.isCreative()){
                    stack.decrement(1);
                }
                return ActionResult.SUCCESS;
            }
        }

        if (canFeedFire(stack, state, player, pos, world)) {
            feedFire(world, pos, player, stack);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    public static VoxelShape getBoundingShape(BlockState state) {
        return BOUNDING_SHAPES.get(state.get(WallTorchBlock.FACING));
    }
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT) == LIT_LIT){
            Direction direction = state.get(WallTorchBlock.FACING);
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
        return canPlaceAt(world, pos, state.get(WallTorchBlock.FACING));
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
                blockState = blockState.with(WallTorchBlock.FACING, direction2);
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
        return direction.getOpposite() == state.get(WallTorchBlock.FACING) && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(WallTorchBlock.FACING, rotation.rotate(state.get(WallTorchBlock.FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(WallTorchBlock.FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WallTorchBlock.FACING, CustomTorchBlock.LIT);
    }
}
