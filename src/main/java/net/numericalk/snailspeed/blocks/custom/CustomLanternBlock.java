package net.numericalk.snailspeed.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.blocks.entity.custom.CustomLanternBlockEntity;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;
import org.jetbrains.annotations.Nullable;

public class CustomLanternBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<CustomLanternBlock> CODEC = createCodec(CustomLanternBlock::new);
    public static final IntProperty LIT = IntProperty.of("lit", 0, 2);
    public static final BooleanProperty HANGING = Properties.HANGING;
    protected static final VoxelShape STANDING_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 7.0, 11.0), Block.createCuboidShape(6.0, 7.0, 6.0, 10.0, 9.0, 10.0)
    );
    protected static final VoxelShape HANGING_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(5.0, 1.0, 5.0, 11.0, 8.0, 11.0), Block.createCuboidShape(6.0, 8.0, 6.0, 10.0, 10.0, 10.0)
    );
    public static final int LIT_UNLIT = 0;
    public static final int LIT_LIT = 1;
    public static final int LIT_ASH = 2;
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());

        for (Direction direction : ctx.getPlacementDirections()) {
            if (direction.getAxis() == Direction.Axis.Y) {
                BlockState blockState = this.getDefaultState().with(HANGING, direction == Direction.UP);
                if (blockState.canPlaceAt(ctx.getWorld(), ctx.getBlockPos())) {
                    return blockState.with(LIT, LIT_UNLIT);
                }
            }
        }

        return null;
    }
    public CustomLanternBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(HANGING, false).with(LIT, LIT_UNLIT));
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, SnailBlockEntities.LANTERN,
                (world1, pos, state1, blockEntity) ->
                        blockEntity.tick(world1, pos, state1));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CustomLanternBlockEntity(pos, state);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (canLitLanternWith(Items.FLINT_AND_STEEL, stack, state, world, pos)) {
            litLanternWith(SoundEvents.ITEM_FLINTANDSTEEL_USE, stack, player, state, world, pos);
            return ActionResult.SUCCESS;
        } else if (canLitLanternWith(Items.FIRE_CHARGE, stack, state, world, pos)
                || canLitLanternWith(SnailItems.BURNING_TINDER, stack, state, world, pos)) {
            litLanternWith(SoundEvents.ITEM_FIRECHARGE_USE, stack, player, state, world, pos);
            return ActionResult.SUCCESS;
        }

        if (state.get(LIT) == LIT_ASH && stack.isIn(SnailItemTagsProvider.OVEN_FUEL) && world.getBlockEntity(pos) instanceof CustomLanternBlockEntity customLanternBlockEntity){
            world.setBlockState(pos, state.with(LIT, LIT_UNLIT));
            customLanternBlockEntity.setFireDegradeTime(customLanternBlockEntity.fireDegradeTimeFinal);
            if (!player.isCreative()){
                stack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }

        if (canFeedFire(stack, state, player, pos, world)) {
            feedFire(world, pos, player, stack);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        super.onStateReplaced(state, world, pos, newState, moved);

        if (newState.isOf(Blocks.AIR)){
            switch (state.get(LIT)){
                case LIT_UNLIT -> dropItem(world, pos, SnailBlocks.LANTERN.asItem(), 1);
                case LIT_LIT, LIT_ASH -> {
                    dropItem(world, pos, Items.CHAIN, 1);
                    dropItem(world, pos, Items.IRON_NUGGET, 2);
                }
            }
            super.onBroken(world, pos, state);
        }
    }
    private void dropItem(World world, BlockPos pos, Item item, int count) {
        for (int i = 0; i < count; i++) {
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), item.getDefaultStack());
        }
    }
    private boolean canFeedFire(ItemStack stack, BlockState state, PlayerEntity player, BlockPos pos, World world) {
        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof CustomLanternBlockEntity customLanternBlockEntity)) return false;

        return stack.isIn(SnailItemTagsProvider.CAMPFIRE_FUEL)
                && state.get(LIT) == LIT_LIT
                && !player.isSneaking()
                && customLanternBlockEntity.getFireDegradeTime() < customLanternBlockEntity.getFireDegradeTimeLimit();
    }
    private void feedFire(World world, BlockPos pos, PlayerEntity player, ItemStack stack) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof CustomLanternBlockEntity customLanternBlockEntity) {
            customLanternBlockEntity.calculateAddedFireTime();
        }
        if (!player.isCreative()) {
            stack.decrement(1);
        }
    }
    private void litLanternWith(SoundEvent soundEvent, ItemStack stack, PlayerEntity player, BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(LIT, LIT_LIT));
        world.playSound(player, pos, soundEvent, SoundCategory.BLOCKS, 1f, 1f);
        if (stack.isDamageable() && !player.isCreative()) {
            stack.damage(1, player);
        }else if (!player.isCreative()) {
            stack.decrement(1);
        }
    }
    private boolean canLitLanternWith(Item item, ItemStack stack, BlockState state, World world, BlockPos pos) {
        return stack.isOf(item) && (state.get(LIT).equals(LIT_UNLIT));
    }
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(HANGING) ? HANGING_SHAPE : STANDING_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HANGING, LIT);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = attachedDirection(state).getOpposite();
        return Block.sideCoversSmallSquare(world, pos.offset(direction), direction.getOpposite());
    }

    protected static Direction attachedDirection(BlockState state) {
        return state.get(HANGING) ? Direction.DOWN : Direction.UP;
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
        return attachedDirection(state).getOpposite() == direction && !state.canPlaceAt(world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    public static int getLuminance(BlockState state) {
        if (state.get(LIT) == LIT_LIT){
            return 15;
        } else {
            return 0;
        }
    }
}
