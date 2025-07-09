package net.numericalk.snailspeed.blocks.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.StonecutterBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.StonecutterScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.entity.ImplementedInventory;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.recipe.custom.WeaponForgeRecipe;
import net.numericalk.snailspeed.recipe.custom.WeaponForgeRecipeInput;
import net.numericalk.snailspeed.screen.custom.WeaponForgeScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class WeaponForgeBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public static final int INPUT_HEAD = 0;
    public static final int INPUT_ADDITIONAL = 1;
    public static final int INPUT_GLUE = 2;
    public static final int OUTPUT = 3;
    private final ServerRecipeManager.MatchGetter<WeaponForgeRecipeInput, WeaponForgeRecipe> matchGetter;

    public WeaponForgeBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.WEAPON_FORGE, pos, state);
        this.matchGetter = ServerRecipeManager.createCachedMatchGetter(SnailRecipe.WEAPON_FORGE_RECIPE_TYPE);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        super.readNbt(nbt, registryLookup);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.snailspeed.weapon_forge");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new WeaponForgeScreenHandler(syncId, playerInventory, this);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (hasRecipe()) {
            tryToCreateWeapon();
        } else {
            removeStack(OUTPUT);
        }
    }

    private boolean hasRecipe() {

        Optional<RecipeEntry<WeaponForgeRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }

        Ingredient inputHead = recipe.get().value().inputHead();
        Ingredient inputAdditional = recipe.get().value().inputAdditional();
        Ingredient inputGlue = recipe.get().value().inputGlue();

        return getOutputOf(inputHead, inputAdditional, inputGlue);
    }

    private Optional<RecipeEntry<WeaponForgeRecipe>> getCurrentRecipe() {
        return this.matchGetter.getFirstMatch(new WeaponForgeRecipeInput(
                inventory.get(INPUT_HEAD),
                inventory.get(INPUT_ADDITIONAL),
                inventory.get(INPUT_GLUE)
        ), (ServerWorld) this.world);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT).isEmpty() || this.getStack(OUTPUT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(OUTPUT).isEmpty() ? 1 : this.getStack(OUTPUT).getMaxCount();
        int currentCount = this.getStack(OUTPUT).getCount();

        return maxCount >= currentCount + count;
    }

    public void tryToCreateWeapon() {
        if (this.getStack(OUTPUT).isEmpty()){
            Optional<RecipeEntry<WeaponForgeRecipe>> recipe = getCurrentRecipe();

            ItemStack output = recipe.get().value().getOutput();
            this.setStack(OUTPUT, new ItemStack(output.getItem(),
                    this.getStack(OUTPUT).getCount() + output.getCount()));

        }
    }

    public void decrementInputNoPlayer() {
        this.getStack(INPUT_HEAD).decrement(1);
        this.getStack(INPUT_ADDITIONAL).decrement(1);
        this.getStack(INPUT_GLUE).decrement(1);
        markDirty();
    }

    private boolean getOutputOf(Ingredient inputHead, Ingredient inputAdditional, Ingredient inputGlue) {
        ItemStack inputHead1 = this.getStack(INPUT_HEAD);
        ItemStack inputAdditional1 = this.getStack(INPUT_ADDITIONAL);
        ItemStack inputGlue1 = this.getStack(INPUT_GLUE);

        return inputHead.test(inputHead1) &&
                inputAdditional.test(inputAdditional1) &&
                inputGlue.test(inputGlue1);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    public void playForgingSound(PlayerEntity player) {
        World world = player.getWorld();
        BlockPos pos = player.getBlockPos();
        world.playSound(player, pos, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS, 1f, 1f);
    }
}