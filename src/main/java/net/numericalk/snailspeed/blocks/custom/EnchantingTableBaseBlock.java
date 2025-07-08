package net.numericalk.snailspeed.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.numericalk.snailspeed.advancement.SnailCriteria;
import net.numericalk.snailspeed.blocks.entity.custom.BrickOvenBlockEntity;
import org.jetbrains.annotations.Nullable;

public class EnchantingTableBaseBlock extends Block {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 12, 16);

    public static final IntProperty STAGES = IntProperty.of("stages", 0, 2);

    private static final int BASE = 0;
    private static final int DIAMOND = 1;
    private static final int RED_CARPET = 2;

    public EnchantingTableBaseBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock() && newState.getBlock() != Blocks.ENCHANTING_TABLE) {
            switch (state.get(STAGES)){
                case BASE -> dropItem(world, pos, Items.AIR, 1);
                case DIAMOND -> dropItem(world, pos, Items.DIAMOND, 1);
                case RED_CARPET -> {
                    dropItem(world, pos, Items.DIAMOND, 1);
                    dropItem(world, pos, Items.RED_CARPET, 1);
                }
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGES);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(STAGES) == BASE && stack.isOf(Items.DIAMOND)){
            world.setBlockState(pos, state.with(STAGES, DIAMOND));
            stack.decrement(1);
            return ActionResult.SUCCESS;
        } else if (state.get(STAGES) == DIAMOND && stack.isOf(Items.RED_CARPET)){
            world.setBlockState(pos, state.with(STAGES, RED_CARPET));
            stack.decrement(1);
            return ActionResult.SUCCESS;
        } else if (state.get(STAGES) == RED_CARPET && stack.isOf(Items.BOOK)){
            world.setBlockState(pos, Blocks.ENCHANTING_TABLE.getDefaultState());
            stack.decrement(1);
            if (player instanceof ServerPlayerEntity serverPlayer){
                SnailCriteria.BUILDING_ENCHANTING_TABLE.trigger(serverPlayer);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(STAGES, 0);
    }
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
