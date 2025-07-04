package net.numericalk.snailspeed.blocks.custom;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.blocks.entity.custom.CustomTorchBlockEntity;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;
import net.numericalk.snailspeed.items.SnailItems;
import org.jetbrains.annotations.Nullable;

public class CustomTorchBlock extends BlockWithEntity implements BlockEntityProvider {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 10.0, 10.0);
    protected static final MapCodec<SimpleParticleType> PARTICLE_TYPE_CODEC = Registries.PARTICLE_TYPE
            .getCodec()
            .<SimpleParticleType>comapFlatMap(
                    particleType -> particleType instanceof SimpleParticleType simpleParticleType
                            ? DataResult.success(simpleParticleType)
                            : DataResult.error(() -> "Not a SimpleParticleType: " + particleType),
                    particleType -> particleType
            )
            .fieldOf("particle_options");
    protected final SimpleParticleType particle;

    public static final MapCodec<CustomTorchBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(PARTICLE_TYPE_CODEC.forGetter(block -> block.particle), createSettingsCodec()).apply(instance, CustomTorchBlock::new));

    public static final IntProperty LIT = IntProperty.of("lit", 0, 2);

    public static final int LIT_UNLIT = 0;
    public static final int LIT_LIT = 1;
    public static final int LIT_ASH = 2;

    public CustomTorchBlock(SimpleParticleType particle, Settings settings) {
        super(settings);
        this.particle = particle;
    }
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (canLitTorchWith(Items.FLINT_AND_STEEL, stack, state, world, pos)) {
            litTorchWith(SoundEvents.ITEM_FLINTANDSTEEL_USE, stack, player, state, world, pos);
            return ActionResult.SUCCESS;
        } else if (canLitTorchWith(Items.FIRE_CHARGE, stack, state, world, pos)
                || canLitTorchWith(SnailItems.BURNING_TINDER, stack, state, world, pos)) {
            litTorchWith(SoundEvents.ITEM_FIRECHARGE_USE, stack, player, state, world, pos);
            return ActionResult.SUCCESS;
        }

        if (canFeedFire(stack, state, player, pos, world)) {
            feedFire(world, pos, player, stack);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    private void litTorchWith(SoundEvent soundEvent, ItemStack stack, PlayerEntity player, BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.cycle(LIT));
        world.playSound(player, pos, soundEvent, SoundCategory.BLOCKS, 1f, 1f);
        if (stack.isDamageable() && !player.isCreative()) {
            stack.damage(1, player);
        }else if (!player.isCreative()) {
            stack.decrement(1);
        }
    }
    private boolean canLitTorchWith(Item item, ItemStack stack, BlockState state, World world, BlockPos pos) {
        return stack.isOf(item) && (state.get(LIT).equals(LIT_UNLIT)) && rainFireHandler(world, pos);
    }

    private boolean rainFireHandler(World world, BlockPos pos) {
        if (!world.isRaining() && !world.isThundering()) {
            return true;
        } else if (!isSkyVisible(world, pos) && (world.isRaining() || world.isThundering())) {
            return true;
        }
        return false;
    }
    private boolean isSkyVisible(World world1, BlockPos pos) {
        int worldHeight = world1.getHeight();

        for (int y = pos.getY() + 1; y < worldHeight; y++) {
            BlockPos abovePos = new BlockPos(pos.getX(), y, pos.getZ());
            if (!world1.isAir(abovePos)) {
                return false;
            }
        }

        return true;
    }
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public static int getLuminance(BlockState state) {
        if (state.get(LIT).equals(1)) {
            return 15;
        } else {
            return 0;
        }
    }
    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(LIT, 0);
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CustomTorchBlockEntity(pos, state);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (world instanceof World w){
            switch (state.get(LIT)){
                case LIT_UNLIT -> {
                    dropItem(w, pos, Items.COAL, 1);
                    dropItem(w, pos, Items.STICK, 1);
                }
                case LIT_LIT -> dropItem(w, pos, Items.STICK, 1);
                case LIT_ASH -> dropItem(w, pos, Items.CHARCOAL, 1);
            }
            super.onBroken(world, pos, state);
        }
    }

    private void dropItem(World world, BlockPos pos, Item item, int count) {
        for (int i = 0; i < count; i++) {
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), item.getDefaultStack());
        }
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
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }
    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, SnailBlockEntities.TORCH,
                (world1, pos, state1, blockEntity) ->
                        blockEntity.tick(world1, pos, state1));
    }
    private boolean canFeedFire(ItemStack stack, BlockState state, PlayerEntity player, BlockPos pos, World world) {
        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof CustomTorchBlockEntity customTorchBE)) return false;

        return stack.isIn(SnailItemTagsProvider.CAMPFIRE_FUEL)
                && state.get(LIT) >= LIT_LIT
                && !player.isSneaking()
                && customTorchBE.getFireDegradeTime() < customTorchBE.getFireDegradeTimeLimit();
    }
    private void feedFire(World world, BlockPos pos, PlayerEntity player, ItemStack stack) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof CustomTorchBlockEntity customTorchBE) {
            customTorchBE.calculateAddedFireTime();
        }
        if (!player.isCreative()) {
            stack.decrement(1);
        }
    }
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT) == LIT_LIT) {
            double d = pos.getX() + 0.5;
            double e = pos.getY() + 0.7;
            double f = pos.getZ() + 0.5;
            world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0, 0.0, 0.0);
            world.addParticle(this.particle, d, e, f, 0.0, 0.0, 0.0);
        }
    }
}
