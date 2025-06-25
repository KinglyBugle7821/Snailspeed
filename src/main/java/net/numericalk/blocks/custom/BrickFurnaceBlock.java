package net.numericalk.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.blocks.entity.SnailBlockEntities;
import net.numericalk.blocks.entity.custom.BrickFurnaceBlockEntity;
import net.numericalk.datagen.SnailItemTagsProvider;
import net.numericalk.items.SnailItems;
import org.jetbrains.annotations.Nullable;

public class BrickFurnaceBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<BrickFurnaceBlock> CODEC = BrickFurnaceBlock.createCodec(BrickFurnaceBlock::new);
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty LIT = IntProperty.of("lit", 0, 3);
    public static final BooleanProperty LID = BooleanProperty.of("lid");
    public static final BooleanProperty CRUCIBLE = BooleanProperty.of("crucible");

    public BrickFurnaceBlock(Settings settings) {
        super(settings);
    }
    public static int getLuminance(BlockState state) {
        if (state.get(LIT).equals(2)){
            return 15;
        } else if (state.get(LIT).equals(3)){
            return 10;
        }
        return 0;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BrickFurnaceBlockEntity(pos, state);
    }
    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof BrickFurnaceBlockEntity be) {
                if (!be.getStack(0).isIn(SnailItemTagsProvider.MOLTEN_ITEMS)){
                    ItemScatterer.spawn(world, pos, ((BrickFurnaceBlockEntity) blockEntity));
                }
                if (state.get(CRUCIBLE)){
                    ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailBlocks.CRUCIBLE.asItem().getDefaultStack());
                }
                if (state.get(LID)){
                    ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.FURNACE_LID.getDefaultStack());
                }
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient()){
            return null;
        }
        return validateTicker(type, SnailBlockEntities.BRICK_FURNACE_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) ->
                        blockEntity.tick(world1, pos, state1));
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, LID, FACING, CRUCIBLE);
    }
    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(LIT, 0)
                .with(LID, false)
                .with(CRUCIBLE, false);
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    Item[][] moldingRecipe = {
            {SnailItems.MOLTEN_COPPER, SnailItems.COPPER_SWORD_BLADE, SnailItems.COPPER_AXE_HEAD, SnailItems.COPPER_PICKAXE_HEAD, SnailItems.COPPER_SHOVEL_HEAD, SnailItems.COPPER_HOE_HEAD, Items.COPPER_INGOT},
            {SnailItems.MOLTEN_IRON, SnailItems.IRON_SWORD_BLADE, SnailItems.IRON_AXE_HEAD, SnailItems.IRON_PICKAXE_HEAD, SnailItems.IRON_SHOVEL_HEAD, SnailItems.IRON_HOE_HEAD, Items.IRON_INGOT},
            {SnailItems.MOLTEN_GOLD, SnailItems.GOLDEN_SWORD_BLADE, SnailItems.GOLDEN_AXE_HEAD, SnailItems.GOLDEN_PICKAXE_HEAD, SnailItems.GOLDEN_SHOVEL_HEAD, SnailItems.GOLDEN_HOE_HEAD, Items.GOLD_INGOT}
    };

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Vec3d hitPos = hit.getPos();
        double relativeY = hitPos.y - pos.getY();

        if (world.getBlockEntity(pos) instanceof BrickFurnaceBlockEntity brickFurnaceBlockEntity){
            if (relativeY > 0.75) {
                if (canPutCrucible(stack, state)){
                    world.setBlockState(pos, state.with(CRUCIBLE, true));
                    if (!player.isCreative()){
                        stack.decrement(1);
                    }
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }
                if (canPutLid(stack, state)){
                    world.setBlockState(pos, state.with(LID, true));
                    if (!player.isCreative()){
                        stack.decrement(1);
                    }
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }
                if (canPutItem(stack, state)){
                    for (int i = 0; i < 5; i++){
                        if (brickFurnaceBlockEntity.getStack(i).isEmpty() && !brickFurnaceBlockEntity.getStack(i).isIn(SnailItemTagsProvider.MOLTEN_ITEMS)){
                            world.updateListeners(pos, state, state, 3);
                            brickFurnaceBlockEntity.setStack(i, stack.copyWithCount(1));
                            if (!player.isCreative()) {
                                stack.decrement(1);
                            }
                            world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                            return ActionResult.SUCCESS;
                        }
                    }
                }
                if (canTakeItem(stack, state)){
                    for (int i = 4; i > -1; i--) {
                        if (!brickFurnaceBlockEntity.getStack(i).isEmpty() && !brickFurnaceBlockEntity.getStack(i).isIn(SnailItemTagsProvider.MOLTEN_ITEMS)){
                            world.updateListeners(pos, state, state,  3);
                            world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                            player.giveOrDropStack(brickFurnaceBlockEntity.getStack(i));
                            brickFurnaceBlockEntity.setStack(i, Items.AIR.getDefaultStack());
                            return ActionResult.SUCCESS;
                        }
                    }
                }
                if (canTakeCrucible(stack, state) && brickFurnaceBlockEntity.isEmpty()){
                    world.setBlockState(pos, state.with(CRUCIBLE, false));
                    player.giveOrDropStack(SnailBlocks.CRUCIBLE.asItem().getDefaultStack());
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }
                if (canTakeLid(stack, state)){
                    world.setBlockState(pos, state.with(LID, false));
                    player.giveOrDropStack(SnailItems.FURNACE_LID.getDefaultStack());
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }

                if (canCraftTools(stack, state, brickFurnaceBlockEntity)){
                    if (stack.isOf(SnailItems.SWORD_CLAY_MOLD)){
                        for (Item[] entry : moldingRecipe){
                            world.updateListeners(pos, state, state,  3);
                            if (brickFurnaceBlockEntity.getStack(0).isOf(entry[0])){
                                player.giveOrDropStack(entry[1].getDefaultStack());
                            }
                        }
                        for (int i = 0; i < 5; i++){
                            brickFurnaceBlockEntity.setStack(i, Items.AIR.getDefaultStack());
                        }
                        stack.decrement(1);
                        world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1f, 1f);

                        return ActionResult.SUCCESS;
                    } else if (stack.isOf(SnailItems.AXE_CLAY_MOLD)){
                        for (Item[] entry : moldingRecipe){
                            world.updateListeners(pos, state, state,  3);
                            if (brickFurnaceBlockEntity.getStack(0).isOf(entry[0])){
                                player.giveOrDropStack(entry[2].getDefaultStack());
                            }
                        }
                        for (int i = 0; i < 5; i++){
                            brickFurnaceBlockEntity.setStack(i, Items.AIR.getDefaultStack());
                        }
                        stack.decrement(1);
                        world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1f, 1f);

                        return ActionResult.SUCCESS;
                    } else if (stack.isOf(SnailItems.PICKAXE_CLAY_MOLD)){
                        for (Item[] entry : moldingRecipe){
                            world.updateListeners(pos, state, state,  3);
                            if (brickFurnaceBlockEntity.getStack(0).isOf(entry[0])){
                                player.giveOrDropStack(entry[3].getDefaultStack());
                            }
                        }
                        for (int i = 0; i < 5; i++){
                            brickFurnaceBlockEntity.setStack(i, Items.AIR.getDefaultStack());
                        }
                        stack.decrement(1);
                        world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1f, 1f);

                        return ActionResult.SUCCESS;
                    } else if (stack.isOf(SnailItems.SHOVEL_CLAY_MOLD)){
                        for (Item[] entry : moldingRecipe){
                            world.updateListeners(pos, state, state,  3);
                            if (brickFurnaceBlockEntity.getStack(0).isOf(entry[0])){
                                player.giveOrDropStack(entry[4].getDefaultStack());
                            }
                        }
                        for (int i = 0; i < 5; i++){
                            brickFurnaceBlockEntity.setStack(i, Items.AIR.getDefaultStack());
                        }
                        stack.decrement(1);
                        world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1f, 1f);

                        return ActionResult.SUCCESS;
                    } else if (stack.isOf(SnailItems.HOE_CLAY_MOLD)){
                        for (Item[] entry : moldingRecipe){
                            world.updateListeners(pos, state, state,  3);
                            if (brickFurnaceBlockEntity.getStack(0).isOf(entry[0])){
                                player.giveOrDropStack(entry[5].getDefaultStack());
                            }
                        }
                        for (int i = 0; i < 5; i++){
                            brickFurnaceBlockEntity.setStack(i, Items.AIR.getDefaultStack());
                        }
                        stack.decrement(1);
                        world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1f, 1f);

                        return ActionResult.SUCCESS;
                    } else if (stack.isOf(SnailItems.INGOT_CLAY_MOLD)){
                        for (Item[] entry : moldingRecipe){
                            world.updateListeners(pos, state, state,  3);
                            if (brickFurnaceBlockEntity.getStack(0).isOf(entry[0])){
                                player.giveOrDropStack(entry[6].getDefaultStack());
                            }
                        }
                        for (int i = 0; i < 5; i++){
                            brickFurnaceBlockEntity.setStack(i, Items.AIR.getDefaultStack());
                        }
                        stack.decrement(1);
                        world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1f, 1f);

                        return ActionResult.SUCCESS;
                    }

                }
            } else {
                if (brickFurnaceBlockEntity.getStack(5).isEmpty() && isFuel(stack)){
                    world.updateListeners(pos, state, state, 3);
                    brickFurnaceBlockEntity.setStack(5, stack.copyWithCount(1));
                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }
                if (canLitFurnaceWith(Items.FLINT_AND_STEEL, stack, state)){
                    litFurnaceWith(SoundEvents.ITEM_FLINTANDSTEEL_USE, stack, player, state, world, pos);
                    return ActionResult.SUCCESS;
                } else if (canLitFurnaceWith(Items.FIRE_CHARGE, stack, state) ||
                        canLitFurnaceWith(SnailItems.BURNING_TINDER, stack, state)){
                    litFurnaceWith(SoundEvents.ITEM_FIRECHARGE_USE, stack, player, state, world, pos);
                    return ActionResult.SUCCESS;
                } else if (canLitBlueFire(SnailItems.SOUL, stack, state, world, pos)){
                    litBlueFire(stack, player, state, world, pos);
                    return ActionResult.SUCCESS;
                }

                if (canFeedFire(stack, state, player, pos, world)){
                    feedFire(world, pos, player, stack);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }

    private boolean canCraftTools(ItemStack stack, BlockState state, BrickFurnaceBlockEntity brickFurnaceBlockEntity) {
        if (brickFurnaceBlockEntity.getStack(0).isIn(SnailItemTagsProvider.MOLTEN_ITEMS)){
            return stack.isIn(SnailItemTagsProvider.CLAY_MOLD) && state.get(CRUCIBLE).equals(true) && state.get(LID).equals(false);
        }
        return false;
    }

    private boolean canTakeLid(ItemStack stack, BlockState state) {
        return stack.isEmpty() && state.get(LID).equals(true);
    }
    private boolean canTakeCrucible(ItemStack stack, BlockState state) {
        return stack.isEmpty() && state.get(CRUCIBLE).equals(true) && state.get(LID).equals(false);
    }

    private boolean canPutLid(ItemStack stack, BlockState state) {
        return stack.isOf(SnailItems.FURNACE_LID) && state.get(LID).equals(false);
    }

    private boolean canPutCrucible(ItemStack stack, BlockState state) {
        return stack.isOf(SnailBlocks.CRUCIBLE.asItem()) && state.get(CRUCIBLE).equals(false) && state.get(LID).equals(false);
    }

    private boolean canPutItem(ItemStack stack, BlockState state) {
        return !stack.isEmpty() && state.get(CRUCIBLE).equals(true) && state.get(LID).equals(false);
    }

    private boolean canTakeItem(ItemStack stack, BlockState state) {
        return stack.isEmpty() && state.get(LID).equals(false);
    }
    private boolean isFuel(ItemStack stack) {
        return stack.isIn(SnailItemTagsProvider.CAMPFIRE_FUEL) || stack.isIn(SnailItemTagsProvider.OVEN_FUEL);
    }
    private boolean canLitFurnaceWith(Item item, ItemStack stack, BlockState state) {
        return stack.isOf(item) && state.get(LIT).equals(1);
    }
    private void litFurnaceWith(SoundEvent soundEvent, ItemStack stack, PlayerEntity player, BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(LIT, 2));
        if (stack.isDamageable() && !player.isCreative()){
            stack.damage(1, player);
        }else if (!player.isCreative()){
            stack.decrement(1);
        }
        world.playSound(player, pos, soundEvent, SoundCategory.BLOCKS, 1f, 1f);
    }

    private void litBlueFire(ItemStack stack, PlayerEntity player, BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(LIT, 3));
        if (stack.isDamageable() && !player.isCreative()){
            stack.damage(1, player);
        } else if (!player.isCreative()){
            stack.decrement(1);
        }
        world.playSound(player, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1f, 1f);
    }
    private boolean canLitBlueFire(Item soul, ItemStack stack, BlockState state, World world, BlockPos pos) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof BrickFurnaceBlockEntity brickFurnaceBlockEntity) {
            return stack.isOf(soul) && state.get(LIT).equals(2) && (brickFurnaceBlockEntity.getFireTime() >= 20 * 60 * 3);
        }
        return false;
    }

    private void feedFire(World world, BlockPos pos, PlayerEntity player, ItemStack stack) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof BrickFurnaceBlockEntity brickFurnaceBlockEntity) {
            if (stack.isIn(SnailItemTagsProvider.CAMPFIRE_FUEL)){
                brickFurnaceBlockEntity.calculatedAddedFireTime(SnailItemTagsProvider.CAMPFIRE_FUEL);
            } else if (stack.isIn(SnailItemTagsProvider.OVEN_FUEL)){
                brickFurnaceBlockEntity.calculatedAddedFireTime(SnailItemTagsProvider.OVEN_FUEL);
            }
            if (!player.isCreative()){
                stack.decrement(1);
            }
        }
    }
    private boolean canFeedFire(ItemStack stack, BlockState state, PlayerEntity player, BlockPos pos, World world) {
        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof BrickFurnaceBlockEntity brickFurnaceBlockEntity)) return false;

        return (stack.isIn(SnailItemTagsProvider.CAMPFIRE_FUEL) || stack.isIn(SnailItemTagsProvider.OVEN_FUEL))
                && state.get(LIT) >= 2
                && !player.isSneaking()
                && brickFurnaceBlockEntity.getFireTime() < brickFurnaceBlockEntity.getMaxFireTime();
    }
}
