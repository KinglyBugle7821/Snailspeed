package net.numericalk.snailspeed.blocks.custom;

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
import net.minecraft.server.network.ServerPlayerEntity;
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
import net.numericalk.snailspeed.advancement.SnailCriteria;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.blocks.entity.custom.BrickFurnaceBlockEntity;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.utils.SnailMoldType;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BrickFurnaceBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty LIT = IntProperty.of("lit", 0, 3);
    public static final BooleanProperty LID = BooleanProperty.of("lid");
    public static final BooleanProperty CRUCIBLE = BooleanProperty.of("crucible");
    private static final MapCodec<BrickFurnaceBlock> CODEC = BrickFurnaceBlock.createCodec(BrickFurnaceBlock::new);

    public BrickFurnaceBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public static int getLuminance(BlockState state) {
        return switch (state.get(LIT)) {
            case 2 -> 15;
            case 3 -> 10;
            default -> 0;
        };
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BrickFurnaceBlockEntity(pos, state);
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            if (world.getBlockEntity(pos) instanceof BrickFurnaceBlockEntity be) {
                if (!be.getStack(0).isIn(SnailItemTagsProvider.MOLTEN_ITEMS)) {
                    ItemScatterer.spawn(world, pos, be);
                }
                if (state.get(CRUCIBLE)) {
                    ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailBlocks.CRUCIBLE.asItem().getDefaultStack());
                }
                if (state.get(LID)) {
                    ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), SnailItems.FURNACE_LID.getDefaultStack());
                }
                world.updateComparators(pos, this);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, SnailBlockEntities.BRICK_FURNACE,
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

    private static final Item[][] MOLDING_RECIPE = {
            {SnailItems.MOLTEN_COPPER, SnailItems.COPPER_SWORD_BLADE, SnailItems.COPPER_AXE_HEAD, SnailItems.COPPER_PICKAXE_HEAD, SnailItems.COPPER_SHOVEL_HEAD, SnailItems.COPPER_HOE_HEAD, Items.COPPER_INGOT, SnailItems.COPPER_PLATE},
            {SnailItems.MOLTEN_IRON, SnailItems.IRON_SWORD_BLADE, SnailItems.IRON_AXE_HEAD, SnailItems.IRON_PICKAXE_HEAD, SnailItems.IRON_SHOVEL_HEAD, SnailItems.IRON_HOE_HEAD, Items.IRON_INGOT, SnailItems.IRON_PLATE},
            {SnailItems.MOLTEN_GOLD, SnailItems.GOLDEN_SWORD_BLADE, SnailItems.GOLDEN_AXE_HEAD, SnailItems.GOLDEN_PICKAXE_HEAD, SnailItems.GOLDEN_SHOVEL_HEAD, SnailItems.GOLDEN_HOE_HEAD, Items.GOLD_INGOT, SnailItems.GOLDEN_PLATE},
            {SnailItems.MOLTEN_BRONZE, SnailItems.BRONZE_SWORD_BLADE, SnailItems.BRONZE_AXE_HEAD, SnailItems.BRONZE_PICKAXE_HEAD, SnailItems.BRONZE_SHOVEL_HEAD, SnailItems.BRONZE_HOE_HEAD, SnailItems.BRONZE_INGOT, SnailItems.BRONZE_PLATE},
            {SnailItems.MOLTEN_STEEL, SnailItems.STEEL_SWORD_BLADE, SnailItems.STEEL_AXE_HEAD, SnailItems.STEEL_PICKAXE_HEAD, SnailItems.STEEL_SHOVEL_HEAD, SnailItems.STEEL_HOE_HEAD, SnailItems.STEEL_INGOT, SnailItems.STEEL_PLATE}
    };

    private static final Item[][] EXTRA_INGOT_RECIPES = {
            {SnailItems.MOLTEN_TIN, SnailItems.TIN_INGOT},
            {SnailItems.MOLTEN_NETHERITE, Items.NETHERITE_INGOT}
    };
    private static final Item[][] EXTRA_BLOCK_RECIPES = {
            {SnailItems.MOLTEN_COPPER_BLOCK, Items.COPPER_BLOCK},
            {SnailItems.MOLTEN_BRONZE_BLOCK, SnailItems.BRONZE_BLOCK},
            {SnailItems.MOLTEN_TIN_BLOCK, SnailItems.TIN_BLOCK},
            {SnailItems.MOLTEN_IRON_BLOCK, Items.IRON_BLOCK},
            {SnailItems.MOLTEN_GOLD_BLOCK, Items.GOLD_BLOCK},
            {SnailItems.MOLTEN_STEEL_BLOCK, SnailItems.STEEL_BLOCK},
            {SnailItems.MOLTEN_REDSTONE_BLOCK, Items.REDSTONE_BLOCK},
            {SnailItems.MOLTEN_GLASS, Items.GLASS},
            {SnailItems.MOLTEN_STONE, Items.STONE},
            {SnailItems.MOLTEN_SMOOTH_STONE, Items.SMOOTH_STONE},
            {SnailItems.MOLTEN_DEEPSLATE, Items.DEEPSLATE},
            {SnailItems.MOLTEN_SMOOTH_QUARTZ_BLOCK, Items.SMOOTH_QUARTZ},
            {SnailItems.MOLTEN_NETHERITE_BLOCK, Items.NETHERITE_BLOCK}
    };
    private static final Item[][] EXTRA_BUCKET_RECIPES = {
            {SnailItems.MOLTEN_IRON_BLOCK, Items.BUCKET}
    };

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Vec3d hitPos = hit.getPos();
        double relativeY = hitPos.y - pos.getY();

        if (world.getBlockEntity(pos) instanceof BrickFurnaceBlockEntity brickFurnaceBlockEntity) {
            if (relativeY > 0.75) {
                if (canPutCrucible(stack, state)) {
                    world.setBlockState(pos, state.with(CRUCIBLE, true));
                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }
                if (canPutLid(stack, state)) {
                    world.setBlockState(pos, state.with(LID, true));
                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }
                if (canPutItem(stack, state)) {
                    for (int i = 0; i < 5; i++) {
                        if (brickFurnaceBlockEntity.getStack(i).isEmpty() && !brickFurnaceBlockEntity.getStack(i).isIn(SnailItemTagsProvider.MOLTEN_ITEMS)) {
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
                if (canTakeItem(stack, state)) {
                    for (int i = 4; i > -1; i--) {
                        if (!brickFurnaceBlockEntity.getStack(i).isEmpty() && !brickFurnaceBlockEntity.getStack(i).isIn(SnailItemTagsProvider.MOLTEN_ITEMS)) {
                            player.giveOrDropStack(brickFurnaceBlockEntity.getStack(i));
                            brickFurnaceBlockEntity.setStack(i, SnailItems.AIR.getDefaultStack());
                            world.updateListeners(pos, state, state,  3);
                            world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                            return ActionResult.SUCCESS;
                        }
                    }
                }
                if (canTakeCrucible(stack, state) && brickFurnaceBlockEntity.isEmpty()) {
                    world.setBlockState(pos, state.with(CRUCIBLE, false));
                    player.giveOrDropStack(SnailBlocks.CRUCIBLE.asItem().getDefaultStack());
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }
                if (canTakeLid(stack, state)) {
                    world.setBlockState(pos, state.with(LID, false));
                    player.giveOrDropStack(SnailItems.FURNACE_LID.getDefaultStack());
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }
                for (SnailMoldType moldType : MOLD_TYPES) {
                    Item[][] extra = null;
                    if (moldType.moldIndex == 6) extra = EXTRA_INGOT_RECIPES;
                    else if (moldType.moldIndex == 8) extra = EXTRA_BLOCK_RECIPES;
                    else if (moldType.moldIndex == 9) extra = EXTRA_BUCKET_RECIPES;

                    ActionResult result = castTool(world, pos, state, player, stack, brickFurnaceBlockEntity,
                            moldType, MOLDING_RECIPE, extra);
                    if (result != ActionResult.PASS) return result;
                }

            } else {
                if (brickFurnaceBlockEntity.getStack(5).isEmpty() && isFuel(stack)) {
                    world.updateListeners(pos, state, state, 3);
                    brickFurnaceBlockEntity.setStack(5, stack.copyWithCount(1));
                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }
                    world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
                    return ActionResult.SUCCESS;
                }
                if (canLitFurnaceWith(Items.FLINT_AND_STEEL, stack, state)) {
                    litFurnaceWith(SoundEvents.ITEM_FLINTANDSTEEL_USE, stack, player, state, world, pos);
                    return ActionResult.SUCCESS;
                } else if (canLitFurnaceWith(Items.FIRE_CHARGE, stack, state) ||
                        canLitFurnaceWith(SnailItems.BURNING_TINDER, stack, state)) {
                    litFurnaceWith(SoundEvents.ITEM_FIRECHARGE_USE, stack, player, state, world, pos);
                    return ActionResult.SUCCESS;
                } else if (canLitBlueFire(SnailItems.SOUL, stack, state, world, pos)) {
                    litBlueFire(stack, player, state, world, pos);
                    return ActionResult.SUCCESS;
                }

                if (canFeedFire(stack, state, player, pos, world)) {
                    feedFire(world, pos, player, stack);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }

    private ActionResult castTool(World world, BlockPos pos, BlockState state, PlayerEntity player,
                                  ItemStack stack, BrickFurnaceBlockEntity be,
                                  SnailMoldType moldType, Item[][] recipe, Item[][] extraRecipe) {
        if (!stack.isOf(moldType.item)) return ActionResult.PASS;

        Item inputItem = be.getStack(0).getItem();
        boolean matched = false;

        for (Item[] entry : recipe) {
            if (entry.length <= moldType.moldIndex) continue;
            if (entry[0] != inputItem) continue;

            Item result = entry[moldType.moldIndex];
            if (result == null || result == SnailItems.AIR) continue;

            if (!moldType.canCastHighSmelting && result != null && ((result.toString().contains("iron") || result.toString().equals("bucket")) || result.toString().contains("steel"))) continue;

            player.giveOrDropStack(result.getDefaultStack());
            be.setStack(0, SnailItems.AIR.getDefaultStack());
            matched = true;
            break;
        }

        if (!matched && extraRecipe != null) {
            for (Item[] entry : extraRecipe) {
                if (entry[0] != inputItem) continue;

                Item result = entry[1];
                if (result == null || result == SnailItems.AIR) continue;

                if (!moldType.canCastHighSmelting && result != null && (result.toString().contains("iron") || result.toString().contains("steel"))) continue;

                player.giveOrDropStack(result.getDefaultStack());
                be.setStack(0, SnailItems.AIR.getDefaultStack());
                matched = true;
                break;
            }
        }

        if (matched) {
            if (moldType.consumeMold) {
                stack.decrement(1);
            }

            for (int i = 1; i < 5; i++) {
                be.setStack(i, SnailItems.AIR.getDefaultStack());
            }

            world.updateListeners(pos, state, state, 3);
            world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
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
        if (stack.isDamageable() && !player.isCreative()) {
            stack.damage(1, player);
        } else if (!player.isCreative()) {
            stack.decrement(1);
        }
        world.playSound(player, pos, soundEvent, SoundCategory.BLOCKS, 1f, 1f);
    }

    private void litBlueFire(ItemStack stack, PlayerEntity player, BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(LIT, 3));
        if (player instanceof ServerPlayerEntity serverPlayer){
            SnailCriteria.SOUL_FIRE.trigger(serverPlayer);
        }
        if (stack.isDamageable() && !player.isCreative()) {
            stack.damage(1, player);
        } else if (!player.isCreative()) {
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
        if (!(world.getBlockEntity(pos) instanceof BrickFurnaceBlockEntity brickFurnaceBlockEntity)) return;
        if (stack.isIn(SnailItemTagsProvider.CAMPFIRE_FUEL)) {
            brickFurnaceBlockEntity.calculatedAddedFireTime(SnailItemTagsProvider.CAMPFIRE_FUEL);
        } else if (stack.isIn(SnailItemTagsProvider.OVEN_FUEL)) {
            brickFurnaceBlockEntity.calculatedAddedFireTime(SnailItemTagsProvider.OVEN_FUEL);
        }
        if (!player.isCreative()) {
            stack.decrement(1);
        }
    }

    private boolean canFeedFire(ItemStack stack, BlockState state, PlayerEntity player, BlockPos pos, World world) {
        if (!(world.getBlockEntity(pos) instanceof BrickFurnaceBlockEntity brickFurnaceBlockEntity)) return false;

        return (stack.isIn(SnailItemTagsProvider.CAMPFIRE_FUEL) || stack.isIn(SnailItemTagsProvider.OVEN_FUEL))
                && state.get(LIT) >= 2
                && !player.isSneaking()
                && brickFurnaceBlockEntity.getFireTime() < brickFurnaceBlockEntity.getMaxFireTime();
    }

    private static final List<SnailMoldType> MOLD_TYPES = List.of(
            new SnailMoldType(SnailItems.SWORD_CLAY_MOLD, 1, false, true),
            new SnailMoldType(SnailItems.SWORD_GRAPHITE_MOLD, 1, true, false),
            new SnailMoldType(SnailItems.AXE_CLAY_MOLD, 2, false, true),
            new SnailMoldType(SnailItems.AXE_GRAPHITE_MOLD, 2, true, false),
            new SnailMoldType(SnailItems.PICKAXE_CLAY_MOLD, 3, false, true),
            new SnailMoldType(SnailItems.PICKAXE_GRAPHITE_MOLD, 3, true, false),
            new SnailMoldType(SnailItems.SHOVEL_CLAY_MOLD, 4, false, true),
            new SnailMoldType(SnailItems.SHOVEL_GRAPHITE_MOLD, 4, true, false),
            new SnailMoldType(SnailItems.HOE_CLAY_MOLD, 5, false, true),
            new SnailMoldType(SnailItems.HOE_GRAPHITE_MOLD, 5, true, false),
            new SnailMoldType(SnailItems.INGOT_CLAY_MOLD, 6, false, true),
            new SnailMoldType(SnailItems.INGOT_GRAPHITE_MOLD, 6, true, false),
            new SnailMoldType(SnailItems.PLATE_CLAY_MOLD, 7, false, true),
            new SnailMoldType(SnailItems.PLATE_GRAPHITE_MOLD, 7, true, false),
            new SnailMoldType(SnailItems.BLOCK_CLAY_MOLD, 8, false, true),
            new SnailMoldType(SnailItems.BLOCK_GRAPHITE_MOLD, 8, true, false),
            new SnailMoldType(SnailItems.BUCKET_CLAY_MOLD, 9, false, true),
            new SnailMoldType(SnailItems.BUCKET_GRAPHITE_MOLD, 9, true, false)
    );


}