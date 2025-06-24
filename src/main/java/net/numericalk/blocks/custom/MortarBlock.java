package net.numericalk.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.math.random.RandomSplitter;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.block.WireOrientation;
import net.numericalk.blocks.entity.custom.MortarBlockEntity;
import net.numericalk.items.SnailItems;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class MortarBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final MapCodec<MortarBlock> CODEC = MortarBlock.createCodec(MortarBlock::new);
    public static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(6, 0, 3, 10, 1, 13),
            Block.createCuboidShape(10, 0, 4, 12, 1, 12),
            Block.createCuboidShape(3, 0, 6, 4, 1, 10),
            Block.createCuboidShape(4, 0, 4, 6, 1, 12),
            Block.createCuboidShape(12, 0, 6, 13, 1, 10),
            Block.createCuboidShape(2, 1, 6, 3, 2, 10),
            Block.createCuboidShape(1, 2, 5, 2, 3, 11),
            Block.createCuboidShape(14, 2, 5, 15, 3, 11),
            Block.createCuboidShape(13, 1, 6, 14, 2, 10),
            Block.createCuboidShape(6, 1, 2, 10, 2, 3),
            Block.createCuboidShape(6, 1, 13, 10, 2, 14),
            Block.createCuboidShape(3, 1, 4, 4, 2, 6),
            Block.createCuboidShape(3, 1, 10, 4, 2, 12),
            Block.createCuboidShape(12, 1, 10, 13, 2, 12),
            Block.createCuboidShape(12, 1, 4, 13, 2, 6),
            Block.createCuboidShape(4, 1, 3, 6, 2, 4),
            Block.createCuboidShape(10, 1, 3, 12, 2, 4),
            Block.createCuboidShape(10, 1, 12, 12, 2, 13),
            Block.createCuboidShape(4, 1, 12, 6, 2, 13),
            Block.createCuboidShape(2, 1, 5, 3, 2, 6),
            Block.createCuboidShape(2, 1, 10, 3, 2, 11),
            Block.createCuboidShape(3, 1, 12, 4, 2, 13),
            Block.createCuboidShape(3, 1, 3, 4, 2, 4),
            Block.createCuboidShape(12, 1, 3, 13, 2, 4),
            Block.createCuboidShape(12, 1, 12, 13, 2, 13),
            Block.createCuboidShape(13, 1, 10, 14, 2, 11),
            Block.createCuboidShape(13, 1, 5, 14, 2, 6),
            Block.createCuboidShape(10, 1, 2, 11, 2, 3),
            Block.createCuboidShape(5, 1, 2, 6, 2, 3),
            Block.createCuboidShape(5, 1, 13, 6, 2, 14),
            Block.createCuboidShape(10, 1, 13, 11, 2, 14),
            Block.createCuboidShape(5, 2, 1, 11, 3, 2),
            Block.createCuboidShape(5, 2, 14, 11, 3, 15),
            Block.createCuboidShape(2, 2, 3, 3, 3, 5),
            Block.createCuboidShape(3, 2, 2, 5, 3, 3),
            Block.createCuboidShape(3, 2, 13, 5, 3, 14),
            Block.createCuboidShape(2, 2, 11, 3, 3, 13),
            Block.createCuboidShape(11, 2, 13, 13, 3, 14),
            Block.createCuboidShape(13, 2, 11, 14, 3, 13),
            Block.createCuboidShape(13, 2, 3, 14, 3, 5),
            Block.createCuboidShape(11, 2, 2, 13, 3, 3)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public MortarBlock(Settings settings) {
        super(settings);
    }
    Random random = new Random() {
        @Override
        public Random split() {
            return null;
        }

        @Override
        public RandomSplitter nextSplitter() {
            return null;
        }

        @Override
        public void setSeed(long seed) {

        }

        @Override
        public int nextInt() {
            return 1;
        }

        @Override
        public int nextInt(int bound) {
            return 4;
        }

        @Override
        public long nextLong() {
            return 0;
        }

        @Override
        public boolean nextBoolean() {
            return false;
        }

        @Override
        public float nextFloat() {
            return 0;
        }

        @Override
        public double nextDouble() {
            return 0;
        }

        @Override
        public double nextGaussian() {
            return 0;
        }
    };

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof MortarBlockEntity mortarBlockEntity){
            if (canPutItem(stack)) {
                if (mortarBlockEntity.getStack(0).isEmpty()) {
                    mortarBlockEntity.setStack(0, stack.copyWithCount(1));
                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);

                    world.updateListeners(pos, state, state, 0);
                    return ActionResult.SUCCESS;
                }
            }
            if (HasPestle(stack)){
                int randomChance = random.nextInt();
                if (randomChance == 1){
                    Item crushedItem = getCrushedRecipe(mortarBlockEntity.getStack(0).getItem());
                    if (hasRecipe(mortarBlockEntity)){
                        mortarBlockEntity.setStack(0, crushedItem.getDefaultStack());
                        world.playSound(player, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
                    }
                }
                stack.damage(1, player);
                return ActionResult.SUCCESS;
            }
            if (canTakeItem(stack, state)){
                if (!mortarBlockEntity.getStack(0).isEmpty()){
                    world.updateListeners(pos, state, state, 0);
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    player.giveOrDropStack(mortarBlockEntity.getStack(0));
                    mortarBlockEntity.setStack(0, Items.AIR.getDefaultStack());
                    return ActionResult.SUCCESS;
                }
            }
        }

        return ActionResult.PASS;
    }

    private boolean hasRecipe(MortarBlockEntity mortarBlockEntity) {
        for (Object[] entry : crushingRecipe) {
            if  (mortarBlockEntity.getStack(0).isOf((Item) entry[0])){
                return true;
            }
        }
        return false;
    }

    private boolean HasPestle(ItemStack stack) {
        return stack.isOf(SnailItems.PESTLE);
    }

    private Item getCrushedRecipe(Item raw) {
        for (Object[] entry : crushingRecipe) {
            if (entry[0] == raw) return (Item) entry[1];
        }
        return null;
    }
    Object[][] crushingRecipe = {
            {Items.RAW_COPPER, SnailItems.COPPER_DUST},
            {Items.RAW_IRON, SnailItems.IRON_DUST},
            {Items.RAW_GOLD, SnailItems.GOLD_DUST}
    };
    private boolean canTakeItem(ItemStack stack, BlockState state) {
        return stack.isEmpty();
    }

    private boolean canPutItem(ItemStack stack) {
        return !stack.isEmpty();
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
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
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSideSolidFullSquare(world, pos.down(), net.minecraft.util.math.Direction.UP);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MortarBlockEntity(pos, state);
    }
}
