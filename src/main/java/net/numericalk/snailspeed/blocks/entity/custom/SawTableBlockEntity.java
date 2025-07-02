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
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.numericalk.snailspeed.blocks.entity.ImplementedInventory;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.recipe.custom.ArmorForgeRecipe;
import net.numericalk.snailspeed.recipe.custom.SawTableRecipe;
import net.numericalk.snailspeed.recipe.custom.SawTableRecipeInput;
import net.numericalk.snailspeed.screen.custom.SawTableScreenHandler;
import net.numericalk.snailspeed.utils.enums.SawCraftable;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SawTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public static final int INPUT = 0;
    public static final int INPUT_ADDITIONAL = 1;
    public static final int OUTPUT = 2;
    private final ServerRecipeManager.MatchGetter<SawTableRecipeInput, SawTableRecipe> matchGetter;

    public SawTableBlockEntity(BlockPos pos, BlockState state) {
        super(SnailBlockEntities.SAW_TABLE, pos, state);
        this.matchGetter = ServerRecipeManager.createCachedMatchGetter(SnailRecipe.SAW_TABLE_RECIPE_TYPE);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
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
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.snailspeed.saw_table");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new SawTableScreenHandler(syncId, playerInventory, this);
    }

    SawCraftable selected = SawCraftable.STAIRS;

    public void setSelectedPiece(SawCraftable selected) {
        this.selected = selected;
    }

    public void tick(World world1, BlockPos pos, BlockState state) {
        if (hasRecipe()) {
            tryToCraftItem();
        } else {
            ItemStack stack = getStack(OUTPUT);
            Optional<RecipeEntry<SawTableRecipe>> recipe = getCurrentRecipe();

            if (recipe.isEmpty()) {
                System.out.println("Recipe Is Empty");
                setStack(OUTPUT, ItemStack.EMPTY);
                return;
            }
            switch (selected){
                case STAIRS -> {
                    if (!stack.isOf(recipe.get().value().stairs().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case SLAB -> {
                    if (!stack.isOf(recipe.get().value().slab().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case DOOR -> {
                    if (!stack.isOf(recipe.get().value().door().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case BED -> {
                    if (!stack.isOf(recipe.get().value().bed().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case FENCE -> {
                    if (!stack.isOf(recipe.get().value().fence().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case FENCE_GATE -> {
                    if (!stack.isOf(recipe.get().value().fenceGate().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case CHEST -> {
                    if (!stack.isOf(recipe.get().value().chest().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case BARREL -> {
                    if (!stack.isOf(recipe.get().value().barrel().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case PLANKS -> {
                    if (!stack.isOf(recipe.get().value().planks().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case HANGING_SIGN -> {
                    if (!stack.isOf(recipe.get().value().hangingSign().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case SIGN -> {
                    if (!stack.isOf(recipe.get().value().sign().getItem())){
                        removeStack(OUTPUT);
                    }
                }
                case TRAPDOOR -> {
                    if (!stack.isOf(recipe.get().value().trapdoor().getItem())){
                        removeStack(OUTPUT);
                    }
                }
            }
        }
    }



    public void tryToCraftItem() {
        Optional<RecipeEntry<SawTableRecipe>> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().value().getOutput(selected);
        if (getStack(OUTPUT).isEmpty()){
            this.setStack(OUTPUT, new ItemStack(output.getItem(), this.getStack(OUTPUT).getCount() + output.getCount()));
        }
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<SawTableRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }

        Ingredient input = recipe.get().value().mainInput();
        Ingredient additionalInput = recipe.get().value().additionalInput();
        if (getOutputOf(input, additionalInput)) {
            ItemStack output = recipe.get().value().getOutput(selected);
            return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
        }
        return false;
    }

    private boolean getOutputOf(Ingredient input, Ingredient additionalInput) {
        ItemStack inputSlot = this.getStack(INPUT);
        ItemStack additionalInputSlot = this.getStack(INPUT_ADDITIONAL);

        return input.test(inputSlot) && additionalInput.test(additionalInputSlot);
    }

    private Optional<RecipeEntry<SawTableRecipe>> getCurrentRecipe() {
        return this.matchGetter.getFirstMatch(new SawTableRecipeInput(
                inventory.get(INPUT),
                inventory.get(INPUT_ADDITIONAL),
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

    public void decrementInput() {
        this.getStack(INPUT).decrement(1);
        if (!getStack(INPUT_ADDITIONAL).isIn(ItemTags.AXES)){
            this.getStack(INPUT_ADDITIONAL).decrement(1);
        }
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


}
