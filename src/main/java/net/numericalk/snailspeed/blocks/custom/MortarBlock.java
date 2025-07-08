package net.numericalk.snailspeed.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
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
import net.numericalk.snailspeed.blocks.entity.custom.BrickOvenBlockEntity;
import net.numericalk.snailspeed.blocks.entity.custom.MortarBlockEntity;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.recipe.custom.MortarRecipe;
import net.numericalk.snailspeed.recipe.custom.MortarRecipeInput;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MortarBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    private final ServerRecipeManager.MatchGetter<MortarRecipeInput, MortarRecipe> matchGetter;
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
    private static final MapCodec<MortarBlock> CODEC = MortarBlock.createCodec(MortarBlock::new);

    public MortarBlock(Settings settings) {
        super(settings);
        this.matchGetter = ServerRecipeManager.createCachedMatchGetter(SnailRecipe.MORTAR_RECIPE_TYPE);
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof MortarBlockEntity) {
                ItemScatterer.spawn(world, pos, ((MortarBlockEntity) blockEntity));
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof MortarBlockEntity mortarBlockEntity) {
            ItemStack rightHand = player.getMainHandStack();
            ItemStack leftHand = player.getOffHandStack();
            if (hasPestle(rightHand, leftHand)) {
                if (hasRecipe(mortarBlockEntity, world)){
                    grindItem(mortarBlockEntity, world);
                    world.playSound(player, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
                    world.markDirty(pos);
                    world.updateListeners(pos, state, state, 3);
                    return ActionResult.SUCCESS;
                } else {
                    world.playSound(player, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }
            }
            if (canPutItem(stack, mortarBlockEntity)) {
                mortarBlockEntity.setStack(0, stack.copyWithCount(1));
                if (!player.isCreative()) {
                    stack.decrement(1);
                }
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                world.markDirty(pos);
                world.updateListeners(pos, state, state, 0);
                return ActionResult.SUCCESS;
            }
            if (canTakeItem(mortarBlockEntity, rightHand, leftHand)) {
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                player.giveOrDropStack(mortarBlockEntity.getStack(0));
                mortarBlockEntity.setStack(0, SnailItems.AIR.getDefaultStack());
                world.markDirty(pos);
                world.updateListeners(pos, state, state, 0);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    private static boolean hasPestle(ItemStack mainHand, ItemStack leftHand) {
        return mainHand.isOf(SnailItems.PESTLE) || leftHand.isOf(SnailItems.PESTLE);
    }

    private static boolean canTakeItem(MortarBlockEntity mortarBlockEntity, ItemStack rightHand, ItemStack leftHand) {
        return !mortarBlockEntity.getStack(0).isEmpty()
                && (rightHand.isEmpty() || leftHand.isEmpty()) && !(rightHand.isOf(SnailItems.PESTLE) || leftHand.isOf(SnailItems.PESTLE));
    }


    private static boolean canPutItem(ItemStack stack, MortarBlockEntity mortarBlockEntity) {
        return !stack.isEmpty() && mortarBlockEntity.getStack(0).isEmpty() && !stack.isOf(SnailItems.PESTLE);
    }
    private boolean hasRecipe(MortarBlockEntity mortarBlockEntity, World world) {
        if (world.isClient()) return false;
        Optional<RecipeEntry<MortarRecipe>> recipe = getCurrentRecipe(mortarBlockEntity, world);
        if (recipe.isEmpty()) {
            System.out.println("RECIPE IS SUPER EMPTY");
            return false;
        }

        Ingredient input = recipe.get().value().input();
        return getOutputOf(input, mortarBlockEntity);
    }

    private Optional<RecipeEntry<MortarRecipe>> getCurrentRecipe(MortarBlockEntity mortarBlockEntity, World world) {
        return this.matchGetter.getFirstMatch(new MortarRecipeInput(
                mortarBlockEntity.inventory.get(0)
        ), (ServerWorld) world);
    }

    public void grindItem(MortarBlockEntity mortarBlockEntity, World world) {
        Optional<RecipeEntry<MortarRecipe>> recipe = getCurrentRecipe(mortarBlockEntity, world);

        ItemStack output = recipe.get().value().getOutput();
        mortarBlockEntity.setStack(0, new ItemStack(output.getItem(), 1));
    }
    private boolean getOutputOf(Ingredient input, MortarBlockEntity mortarBlockEntity) {
        ItemStack inputSlot = mortarBlockEntity.getStack(0);

        return input.test(inputSlot);
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
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, SnailBlockEntities.MORTAR,
                (world1, pos, state1, blockEntity) ->
                        blockEntity.tick(world1, pos, state1));
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
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.snailspeed.has_shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.snailspeed.block.mortar"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }

}