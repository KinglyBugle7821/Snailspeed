package net.numericalk.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.block.WireOrientation;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.blocks.entity.custom.BrickFurnaceBlockEntity;
import net.numericalk.datagen.SnailItemTagsProvider;
import net.numericalk.items.SnailItems;
import org.jetbrains.annotations.Nullable;

import static net.numericalk.blocks.custom.ClayMoldBlock.MOLD_SHAPE;

public class FiredClayMoldBlock extends HorizontalFacingBlock {
    public static final MapCodec<FiredClayMoldBlock> CODEC = FiredClayMoldBlock.createCodec(FiredClayMoldBlock::new);
    public static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 2, 16);
    public FiredClayMoldBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(MOLD_SHAPE);
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
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            switch (state.get(MOLD_SHAPE)){
                case 0 -> ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.BLANK_CLAY_MOLD.getDefaultStack());
                case 1 -> ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.SWORD_CLAY_MOLD.getDefaultStack());
                case 2 -> ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.AXE_CLAY_MOLD.getDefaultStack());
                case 3 -> ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.PICKAXE_CLAY_MOLD.getDefaultStack());
                case 4 -> ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.SHOVEL_CLAY_MOLD.getDefaultStack());
                case 5 -> ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.HOE_CLAY_MOLD.getDefaultStack());
                case 6 -> ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.INGOT_CLAY_MOLD.getDefaultStack());
            }
            world.updateComparators(pos, this);
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
}
