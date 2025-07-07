package net.numericalk.snailspeed.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.numericalk.snailspeed.advancement.SnailCriteria;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class BrickOvenBaseBlock extends HorizontalFacingBlock {

    public static final VoxelShape SHAPE_BASE = Block.createCuboidShape(0, 0, 0, 16, 2, 16);

    public static final VoxelShape SHAPE_LEFT_WALL_NORTH = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(14, 2, 0, 16, 14, 14),
            BooleanBiFunction.OR);
    public static final VoxelShape SHAPE_LEFT_WALL_EAST = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(2, 2, 14, 16, 14, 16),
            BooleanBiFunction.OR
    );
    public static final VoxelShape SHAPE_LEFT_WALL_SOUTH = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 2, 2, 2, 14, 16),
            BooleanBiFunction.OR
    );
    public static final VoxelShape SHAPE_LEFT_WALL_WEST = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 2, 0, 14, 14, 2),
            BooleanBiFunction.OR
    );

    public static final VoxelShape SHAPE_SIDE_WALL_NORTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(14, 2, 0, 16, 14, 14),
            Block.createCuboidShape(0, 2, 0, 2, 14, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_SIDE_WALL_EAST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(2, 2, 14, 16, 14, 16),
            Block.createCuboidShape(2, 2, 0, 16, 14, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_SIDE_WALL_SOUTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 2, 2, 2, 14, 16),
            Block.createCuboidShape(14, 2, 2, 16, 14, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_SIDE_WALL_WEST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 2, 0, 14, 14, 2),
            Block.createCuboidShape(0, 2, 14, 14, 14, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_WALL_NORTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(14, 2, 0, 16, 14, 14),
            Block.createCuboidShape(0, 2, 0, 2, 14, 14),
            Block.createCuboidShape(0, 2, 14, 16, 14, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_WALL_EAST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(2, 2, 14, 16, 14, 16),
            Block.createCuboidShape(2, 2, 0, 16, 14, 2),
            Block.createCuboidShape(0, 2, 0, 2, 14, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_WALL_SOUTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 2, 2, 2, 14, 16),
            Block.createCuboidShape(14, 2, 2, 16, 14, 16),
            Block.createCuboidShape(0, 2, 0, 16, 14, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_WALL_WEST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 2, 0, 14, 14, 2),
            Block.createCuboidShape(0, 2, 14, 14, 14, 16),
            Block.createCuboidShape(14, 2, 0, 16, 14, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_TRAY_NORTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(14, 2, 0, 16, 14, 14),
            Block.createCuboidShape(0, 2, 0, 2, 14, 14),
            Block.createCuboidShape(0, 2, 14, 16, 14, 16),
            Block.createCuboidShape(2, 7, 0, 14, 8, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_TRAY_EAST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(2, 2, 14, 16, 14, 16),
            Block.createCuboidShape(2, 2, 0, 16, 14, 2),
            Block.createCuboidShape(0, 2, 0, 2, 14, 16),
            Block.createCuboidShape(2, 7, 2, 16, 8, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_TRAY_SOUTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 2, 2, 2, 14, 16),
            Block.createCuboidShape(14, 2, 2, 16, 14, 16),
            Block.createCuboidShape(0, 2, 0, 16, 14, 2),
            Block.createCuboidShape(2, 7, 2, 14, 8, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_TRAY_WEST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 2, 0, 14, 14, 2),
            Block.createCuboidShape(0, 2, 14, 14, 14, 16),
            Block.createCuboidShape(14, 2, 0, 16, 14, 16),
            Block.createCuboidShape(0, 7, 2, 14, 8, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_LID_NORTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(14, 2, 0, 16, 14, 14),
            Block.createCuboidShape(0, 2, 0, 2, 14, 14),
            Block.createCuboidShape(0, 2, 14, 16, 14, 16),
            Block.createCuboidShape(2, 7, 0, 14, 8, 14),
            Block.createCuboidShape(0, 14, 0, 16, 15, 5),
            Block.createCuboidShape(0, 14, 11, 16, 15, 16),
            Block.createCuboidShape(0, 14, 5, 5, 15, 11),
            Block.createCuboidShape(11, 14, 5, 16, 15, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_LID_EAST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(2, 2, 14, 16, 14, 16),
            Block.createCuboidShape(2, 2, 0, 16, 14, 2),
            Block.createCuboidShape(0, 2, 0, 2, 14, 16),
            Block.createCuboidShape(2, 7, 2, 16, 8, 14),
            Block.createCuboidShape(11, 14, 0, 16, 15, 16),
            Block.createCuboidShape(0, 14, 0, 5, 15, 16),
            Block.createCuboidShape(5, 14, 0, 11, 15, 5),
            Block.createCuboidShape(5, 14, 11, 11, 15, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_LID_SOUTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 2, 2, 2, 14, 16),
            Block.createCuboidShape(14, 2, 2, 16, 14, 16),
            Block.createCuboidShape(0, 2, 0, 16, 14, 2),
            Block.createCuboidShape(2, 7, 2, 14, 8, 16),
            Block.createCuboidShape(0, 14, 11, 16, 15, 16),
            Block.createCuboidShape(0, 14, 0, 16, 15, 5),
            Block.createCuboidShape(11, 14, 5, 16, 15, 11),
            Block.createCuboidShape(0, 14, 5, 5, 15, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_LID_WEST = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 2, 0, 14, 14, 2),
            Block.createCuboidShape(0, 2, 14, 14, 14, 16),
            Block.createCuboidShape(14, 2, 0, 16, 14, 16),
            Block.createCuboidShape(0, 7, 2, 14, 8, 14),
            Block.createCuboidShape(0, 14, 0, 5, 15, 16),
            Block.createCuboidShape(11, 14, 0, 16, 15, 16),
            Block.createCuboidShape(5, 14, 11, 11, 15, 16),
            Block.createCuboidShape(5, 14, 0, 11, 15, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_FULL = Block.createCuboidShape(0, 0, 0, 16, 16, 16);
    public static final IntProperty STAGES = IntProperty.of("stages", 0, 6);
    private static final MapCodec<BrickOvenBaseBlock> CODEC = BrickOvenBaseBlock.createCodec(BrickOvenBaseBlock::new);

    public BrickOvenBaseBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(STAGES)) {
            case 0 -> SHAPE_BASE;
            case 1 -> switch (state.get(FACING)) {
                case SOUTH -> SHAPE_LEFT_WALL_SOUTH;
                case WEST -> SHAPE_LEFT_WALL_WEST;
                case EAST -> SHAPE_LEFT_WALL_EAST;
                default -> SHAPE_LEFT_WALL_NORTH;
            };
            case 2 -> switch (state.get(FACING)) {
                case SOUTH -> SHAPE_SIDE_WALL_SOUTH;
                case WEST -> SHAPE_SIDE_WALL_WEST;
                case EAST -> SHAPE_SIDE_WALL_EAST;
                default -> SHAPE_SIDE_WALL_NORTH;
            };
            case 3 -> switch (state.get(FACING)) {
                case SOUTH -> SHAPE_WALL_SOUTH;
                case WEST -> SHAPE_WALL_WEST;
                case EAST -> SHAPE_WALL_EAST;
                default -> SHAPE_WALL_NORTH;
            };
            case 4 -> switch (state.get(FACING)) {
                case SOUTH -> SHAPE_TRAY_SOUTH;
                case WEST -> SHAPE_TRAY_WEST;
                case EAST -> SHAPE_TRAY_EAST;
                default -> SHAPE_TRAY_NORTH;
            };
            case 5 -> switch (state.get(FACING)) {
                case SOUTH -> SHAPE_LID_SOUTH;
                case WEST -> SHAPE_LID_WEST;
                case EAST -> SHAPE_LID_EAST;
                default -> SHAPE_LID_NORTH;
            };
            default -> SHAPE_FULL;
        };
    }
    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            switch (state.get(STAGES)) {
                case 1 -> dropItem(world, pos, Items.BRICK, 1);
                case 2 -> dropItem(world, pos, Items.BRICK, 2);
                case 3 -> dropItem(world, pos, Items.BRICK, 3);
                case 4 -> dropItem(world, pos, Items.BRICK, 4);
                case 5 -> dropItem(world, pos, Items.BRICK, 5);
                case 6 -> dropItem(world, pos, Items.BRICK, 6);
                default -> dropItem(world, pos, SnailItems.AIR, 1);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }
    private void dropItem(World world, BlockPos pos, Item item, int count) {
        for (int i = 0; i < count; i++) {
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), item.getDefaultStack());
        }
    }
    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.BRICK) && state.get(STAGES) < 6) {
            world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
            world.setBlockState(pos, state.cycle(STAGES));
            if (!player.isCreative()) {
                stack.decrement(1);
            }
        }
        if (stack.isOf(Items.CLAY_BALL) && state.get(STAGES) == 6) {
            world.playSound(player, pos, SoundEvents.BLOCK_SLIME_BLOCK_PLACE, SoundCategory.BLOCKS, 1f, 1f);
            world.setBlockState(pos, SnailBlocks.BRICK_OVEN.getStateWithProperties(state));
            if (player instanceof ServerPlayerEntity serverPlayer){
                SnailCriteria.BUILDING_BRICK_OVEN.trigger(serverPlayer);
            }
            if (!player.isCreative()) {
                stack.decrement(1);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, STAGES);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.snailspeed.has_shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.snailspeed.block.brick_oven_base"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
