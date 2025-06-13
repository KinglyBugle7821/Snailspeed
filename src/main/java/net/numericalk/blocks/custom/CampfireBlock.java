package net.numericalk.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
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
import net.numericalk.blocks.entity.SnailBlockEntities;
import net.numericalk.blocks.entity.custom.CampfireBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

//CHANGE TO BLOCK ENTITY
public class CampfireBlock extends BlockWithEntity implements BlockEntityProvider{

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

    private static final VoxelShape SHAPE_BASE = Stream.of(
            Block.createCuboidShape(6, 0, 3, 10, 1, 13),
            Block.createCuboidShape(10, 0, 4, 12, 1, 12),
            Block.createCuboidShape(3, 0, 6, 4, 1, 10),
            Block.createCuboidShape(4, 0, 4, 6, 1, 12),
            Block.createCuboidShape(12, 0, 6, 13, 1, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_FULL = Block.createCuboidShape(2, 0, 2, 13, 10, 13);
    public CampfireBlock(Settings settings) {
        super(settings);
    }

    public static final MapCodec<CampfireBlock> CODEC = CampfireBlock.createCodec(CampfireBlock::new);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(STAGES) == 1){
            return SHAPE_BASE;
        }
        return SHAPE_FULL;
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
        if (stack.isOf(Items.STICK) && state.get(STAGES) < 5){
            if (!world.isClient()){
                world.setBlockState(pos, state.cycle(STAGES));
            }
            stack.decrement(1);
            return ActionResult.SUCCESS;
        }
        if (stack.isOf(Items.FLINT_AND_STEEL) && state.get(LIT) == 1 && state.get(STAGES) == 5){
            if (!world.isClient()){
                world.setBlockState(pos, state.with(LIT, 2));
            }
            world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1f, 1f);
            stack.damage(1, player);
            return ActionResult.SUCCESS;
        }
        if (stack.isOf(Items.FIRE_CHARGE) && state.get(LIT) == 1 && state.get(STAGES) == 5){
            if (!world.isClient()){
                world.setBlockState(pos, state.with(LIT, 2));
            }
            world.playSound(player, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1f, 1f);
            stack.decrement(1);
            return ActionResult.SUCCESS;
        }

        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient()){
            return null;
        }
        return validateTicker(type, SnailBlockEntities.CAMPFIRE_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) ->
                blockEntity.tick(world1, pos, state));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGES, LIT);
    }
}
