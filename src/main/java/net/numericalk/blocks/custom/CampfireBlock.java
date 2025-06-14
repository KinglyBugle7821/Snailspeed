package net.numericalk.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.numericalk.blocks.entity.SnailBlockEntities;
import net.numericalk.blocks.entity.custom.CampfireBlockEntity;
import net.numericalk.datagen.SnailItemTagsProvider;
import net.numericalk.items.SnailItems;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class CampfireBlock extends BlockWithEntity implements BlockEntityProvider{

    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    //1 Bark
    //2 One Stick
    //3 Two Sticks
    //4 Three Sticks
    //5 Four Sticks
    //6 Burnt
    public static final IntProperty STAGES = IntProperty.of("stages", 1, 6);

    //1 Unlit
    //2 Small Fire
    //3 Medium Fire
    //4 Large Fire
    public static final IntProperty LIT = IntProperty.of("lit", 1, 4);

    //1 No Stick
    //2 One Stick
    //3 Two Sticks
    //4 Three Sticks
    public static final IntProperty COOKING = IntProperty.of("cooking", 1, 4);

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

    public static int getLuminance(BlockState state) {
        return switch (state.get(LIT)){
            case 1 -> 0;
            case 2 -> 7;
            case 3 -> 11;
            case 4 -> 15;
            default -> 7;
        };
    }

    private static final VoxelShape SHAPE_BASE = Stream.of(
            Block.createCuboidShape(6, 0, 3, 10, 1, 13),
            Block.createCuboidShape(10, 0, 4, 12, 1, 12),
            Block.createCuboidShape(3, 0, 6, 4, 1, 10),
            Block.createCuboidShape(4, 0, 4, 6, 1, 12),
            Block.createCuboidShape(12, 0, 6, 13, 1, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_FULL =
            Block.createCuboidShape(2, 0, 2, 13, 10, 13);
    private static final VoxelShape SHAPE_FULL_1_WEST = Stream.of(
            Block.createCuboidShape(7, 0, 0, 9, 16, 1),
            Block.createCuboidShape(2, 0, 2, 13, 10, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_FULL_2_WEST = Stream.of(
            Block.createCuboidShape(7, 0, 0, 9, 16, 1),
            Block.createCuboidShape(7, 0, 15, 9, 16, 16),
            Block.createCuboidShape(2, 0, 2, 13, 10, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_FULL_3_WEST = Stream.of(
            Block.createCuboidShape(7, 0, 0, 9, 16, 1),
            Block.createCuboidShape(7, 0, 15, 9, 16, 16),
            Block.createCuboidShape(7, 15, 1, 9, 16, 15),
            Block.createCuboidShape(2, 0, 2, 13, 10, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_FULL_1_NORTH = Stream.of(
            Block.createCuboidShape(15, 0, 7, 16, 16, 9),
            Block.createCuboidShape(2, 0, 2, 13, 10, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_FULL_2_NORTH = Stream.of(
            Block.createCuboidShape(0, 0, 7, 1, 16, 9),
            Block.createCuboidShape(15, 0, 7, 16, 16, 9),
            Block.createCuboidShape(2, 0, 2, 13, 10, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_FULL_3_NORTH = Stream.of(
            Block.createCuboidShape(0, 0, 7, 1, 16, 9),
            Block.createCuboidShape(15, 0, 7, 16, 16, 9),
            Block.createCuboidShape(1, 15, 7, 15, 16, 9),
            Block.createCuboidShape(2, 0, 2, 13, 10, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public CampfireBlock(Settings settings) {
        super(settings);
    }

    public static final MapCodec<CampfireBlock> CODEC = CampfireBlock.createCodec(CampfireBlock::new);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(STAGES) == 1){
            return SHAPE_BASE;
        }
        switch (state.get(COOKING)){
            case 2 -> {
                switch (state.get(FACING)){
                    case Direction.WEST, Direction.EAST -> {
                        return SHAPE_FULL_1_WEST;
                    }
                    default -> {
                        return SHAPE_FULL_1_NORTH;
                    }
                }
            }
            case 3 -> {
                switch (state.get(FACING)){
                    case Direction.WEST, Direction.EAST -> {
                        return SHAPE_FULL_2_WEST;
                    }
                    default -> {
                        return SHAPE_FULL_2_NORTH;
                    }
                }
            }
            case 4 -> {
                switch (state.get(FACING)){
                    case Direction.WEST, Direction.EAST -> {
                        return SHAPE_FULL_3_WEST;
                    }
                    default -> {
                        return SHAPE_FULL_3_NORTH;
                    }
                }
            }
            default -> {
                return SHAPE_FULL;
            }
        }
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CampfireBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof CampfireBlockEntity) {
                ItemScatterer.spawn(world, pos, ((CampfireBlockEntity) blockEntity));
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (world.getBlockEntity(pos) instanceof CampfireBlockEntity campfireBlockEntity) {
            if (!stack.isEmpty() && state.get(COOKING) == 4) {
                for (int i = 0; i < 3; i++) {
                    if (campfireBlockEntity.getStack(i).isEmpty()) {
                        campfireBlockEntity.setStack(i, stack.copyWithCount(1));
                        world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                        if (!player.isCreative()) {
                            stack.decrement(1);
                        }
                        world.updateListeners(pos, state, state, 0);
                        return ActionResult.SUCCESS;
                    }
                }
            }
            if (stack.isEmpty() && state.get(COOKING) == 4){
                for (int i = 0; i < 3; i++) {
                    if (!campfireBlockEntity.getStack(i).isEmpty()){
                        world.updateListeners(pos, state, state, 0);
                        world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                        player.giveOrDropStack(campfireBlockEntity.getStack(i));
                        campfireBlockEntity.setStack(i, Items.AIR.getDefaultStack());
                        return ActionResult.SUCCESS;
                    }
                }
            }
        }


        if (stack.isOf(Items.STICK) && state.get(STAGES) < 5){
            if (!world.isClient()){
                world.setBlockState(pos, state.cycle(STAGES));
            }
            if (!player.isCreative()){
                stack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        if (stack.isOf(Items.FLINT_AND_STEEL) && state.get(LIT) == 1 && state.get(STAGES) == 5){
            if (!world.isClient()){
                world.setBlockState(pos, state.with(LIT, 2));
            }
            world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1f, 1f);
            if (!player.isCreative()){
                stack.damage(1, player);
            }
            return ActionResult.SUCCESS;
        }
        if ((stack.isOf(Items.FIRE_CHARGE) || stack.isOf(SnailItems.BURNING_TINDER)) && state.get(LIT) == 1 && state.get(STAGES) == 5){
            if (!world.isClient()){
                world.setBlockState(pos, state.with(LIT, 2));
            }
            world.playSound(player, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1f, 1f);
            if (!player.isCreative()){
                stack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        if (stack.isIn(SnailItemTagsProvider.CAMPFIRE_FUEL) && state.get(LIT) == 2 && !player.isSneaking()){
            if (!world.isClient()) {
                BlockEntity be = world.getBlockEntity(pos);
                if (be instanceof CampfireBlockEntity campfireBlockEntity) {
                    campfireBlockEntity.calculateAddedFireTime();
                }
            }
            if (!player.isCreative()){
                stack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        if (stack.isIn(SnailItemTagsProvider.CAMPFIRE_FUEL) && state.get(LIT) == 3 && !player.isSneaking()){
            if (!world.isClient()) {
                BlockEntity be = world.getBlockEntity(pos);
                if (be instanceof CampfireBlockEntity campfireBlockEntity) {
                    campfireBlockEntity.calculateAddedFireTime();
                }
            }
            if (!player.isCreative()){
                stack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }

        if (stack.isOf(Items.STICK) && state.get(STAGES) == 5 && state.get(COOKING) < 4){
            if (!world.isClient()){
                world.setBlockState(pos, state.cycle(COOKING));
            }
            if (!player.isCreative()){
                stack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient()){
            return null;
        }
        return validateTicker(type, SnailBlockEntities.CAMPFIRE_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) ->
                blockEntity.tick(world1, pos, state1));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGES, LIT, COOKING, FACING);
    }
}
