package net.numericalk.snailspeed.blocks.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SmithingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.entity.ImplementedInventory;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.recipe.custom.ArmorForgeRecipe;
import net.numericalk.snailspeed.recipe.custom.ArmorForgeRecipeInput;
import net.numericalk.snailspeed.screen.custom.ArmorForgeScreenHandler;
import net.numericalk.snailspeed.utils.enums.ArmorPiece;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ArmorForgeBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    public static final int PLATE_SLOT = 0;
    public static final int BINDING_SLOT = 1;
    public static final int FASTENER_SLOT = 2;
    public static final int TOOL_SLOT = 3;
    public static final int OUTPUT = 4;
    private final ServerRecipeManager.MatchGetter<ArmorForgeRecipeInput, ArmorForgeRecipe> matchGetter;

    public ArmorForgeBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.ARMOR_FORGE, pos, state);
        this.matchGetter = ServerRecipeManager.createCachedMatchGetter(SnailRecipe.ARMOR_FORGE_RECIPE_TYPE);
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
        return Text.translatable("block.snailspeed.armor_forge");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ArmorForgeScreenHandler(syncId, playerInventory, this);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        boolean hasRecipe = hasRecipe();
        if (hasTrimRecipe((ServerWorld) world)) {
            applyTrim((ServerWorld) world);
        } else if (hasRecipe) {
            tryToCreateArmor();
        } else {
            cleanOutputSlot();
        }
    }
    private boolean hasTrimRecipe(ServerWorld serverWorld) {
        ItemStack template = inventory.get(BINDING_SLOT);
        ItemStack armor = inventory.get(PLATE_SLOT);
        ItemStack material = inventory.get(FASTENER_SLOT);

        SmithingRecipeInput input = new SmithingRecipeInput(template, armor, material);

        Optional<RecipeEntry<SmithingRecipe>> match = serverWorld.getRecipeManager()
                .getFirstMatch(RecipeType.SMITHING, input, serverWorld);

        return match.filter(recipe -> recipe.value() instanceof SmithingTrimRecipe).isPresent();
    }

    private void applyTrim(ServerWorld serverWorld) {
        ItemStack template = inventory.get(BINDING_SLOT);
        ItemStack armor = inventory.get(PLATE_SLOT);
        ItemStack material = inventory.get(FASTENER_SLOT);

        SmithingRecipeInput input = new SmithingRecipeInput(template, armor, material);

        Optional<RecipeEntry<SmithingRecipe>> match = serverWorld.getRecipeManager()
                .getFirstMatch(RecipeType.SMITHING, input, serverWorld);

        if (match.isPresent() && match.get().value() instanceof SmithingTrimRecipe trimRecipe) {
            ItemStack result = trimRecipe.craft(input, serverWorld.getRegistryManager());

            inventory.set(OUTPUT, result);
            markDirty();
        }
    }


    private void cleanOutputSlot() {
        ItemStack stack = getStack(OUTPUT);
        Optional<RecipeEntry<ArmorForgeRecipe>> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            setStack(OUTPUT, ItemStack.EMPTY);
            return;
        }
        switch (selected){
            case HELMET -> {
                if (!stack.isOf(recipe.get().value().outputHelmet().getItem())){
                    removeStack(OUTPUT);
                }
            }
            case CHESTPLATE -> {
                if (!stack.isOf(recipe.get().value().outputChestplate().getItem())){
                    removeStack(OUTPUT);
                }
            }
            case LEGGINGS -> {
                if (!stack.isOf(recipe.get().value().outputLeggings().getItem())){
                    removeStack(OUTPUT);
                }
            }
            case BOOTS -> {
                if (!stack.isOf(recipe.get().value().outputBoots().getItem())){
                    removeStack(OUTPUT);
                }
            }
        }
    }

    private ArmorPiece selected = ArmorPiece.HELMET;

    public void setSelectedPiece(ArmorPiece selected) {
        this.selected = selected;
    }

    private boolean hasRecipe() {

        Optional<RecipeEntry<ArmorForgeRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }

        Ingredient inputPlate = recipe.get().value().inputPlate();
        Ingredient inputBinding = recipe.get().value().inputBinding();
        Ingredient inputFastener = recipe.get().value().inputFastener();
        Ingredient inputTool = recipe.get().value().inputTool();
        if (getOutputOf(inputPlate, inputBinding, inputFastener, inputTool, selected.plateCount, selected.bindingCount, selected.fastenerCount)) {
            ItemStack output = recipe.get().value().getOutput(selected);
            return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
        }
        return false;
    }

    private Optional<RecipeEntry<ArmorForgeRecipe>> getCurrentRecipe() {
        return this.matchGetter.getFirstMatch(new ArmorForgeRecipeInput(
                inventory.get(PLATE_SLOT),
                inventory.get(BINDING_SLOT),
                inventory.get(FASTENER_SLOT),
                inventory.get(TOOL_SLOT),
                selected
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

    public void tryToCreateArmor() {
        Optional<RecipeEntry<ArmorForgeRecipe>> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().value().getOutput(selected);
        this.setStack(OUTPUT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT).getCount() + output.getCount()));
    }

    public void decrementInputNoPlayer() {
        this.getStack(PLATE_SLOT).decrement(selected.plateCount);
        this.getStack(BINDING_SLOT).decrement(selected.bindingCount);
        this.getStack(FASTENER_SLOT).decrement(selected.fastenerCount);
        markDirty();
    }

    private boolean getOutputOf(Ingredient plate, Ingredient binding, Ingredient fastener, Ingredient tool, int plateCount, int bindingCount, int fastenerCount) {
        ItemStack plateSlot = this.getStack(PLATE_SLOT);
        ItemStack bindingSlot = this.getStack(BINDING_SLOT);
        ItemStack fastenerSlot = this.getStack(FASTENER_SLOT);
        ItemStack toolSlot = this.getStack(TOOL_SLOT);

        return plate.test(plateSlot) && plateSlot.getCount() >= plateCount &&
                binding.test(bindingSlot) && bindingSlot.getCount() >= bindingCount &&
                fastener.test(fastenerSlot) && fastenerSlot.getCount() >= fastenerCount &&
                tool.test(toolSlot);
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