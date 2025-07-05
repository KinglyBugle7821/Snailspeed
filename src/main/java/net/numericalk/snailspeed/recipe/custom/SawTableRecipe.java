package net.numericalk.snailspeed.recipe.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.utils.enums.SawCraftable;
import net.numericalk.snailspeed.utils.records.SnailPacketCodec;

import java.util.List;
import java.util.Optional;

public record SawTableRecipe(Ingredient mainInput, Ingredient additionalInput,
                             ItemStack stairs, ItemStack slab, ItemStack door,
                             ItemStack bed, ItemStack fence, ItemStack fenceGate,
                             ItemStack chest, ItemStack barrel, ItemStack planks,
                             ItemStack hangingSign, ItemStack sign, ItemStack trapdoor,
                             ItemStack boat) implements Recipe<SawTableRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.mainInput);
        list.add(this.additionalInput);
        return list;
    }

    public ItemStack getOutput(SawCraftable sawCraftable) {
        return switch (sawCraftable) {
            case STAIRS -> stairs;
            case SLAB -> slab;
            case DOOR -> door;
            case BED -> bed;
            case FENCE -> fence;
            case FENCE_GATE -> fenceGate;
            case CHEST -> chest;
            case BARREL -> barrel;
            case PLANKS -> planks;
            case HANGING_SIGN -> hangingSign;
            case SIGN -> sign;
            case TRAPDOOR -> trapdoor;
            case BOAT -> boat;
        };
    }

    @Override
    public boolean matches(SawTableRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return mainInput.test(input.getStackInSlot(0)) &&
                additionalInput.test(input.getStackInSlot(1));
    }

    @Override
    public ItemStack craft(SawTableRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return switch (input.selected()){
            case STAIRS -> stairs.copy();
            case SLAB -> slab.copy();
            case DOOR -> door.copy();
            case BED -> bed.copy();
            case FENCE -> fence.copy();
            case FENCE_GATE -> fenceGate.copy();
            case CHEST -> chest.copy();
            case BARREL -> barrel.copy();
            case PLANKS -> planks.copy();
            case HANGING_SIGN -> hangingSign.copy();
            case SIGN -> sign.copy();
            case TRAPDOOR -> trapdoor.copy();
            case BOAT -> boat.copy();
        };
    }

    @Override
    public RecipeSerializer<? extends Recipe<SawTableRecipeInput>> getSerializer() {
        return SnailRecipe.SAW_TABLE_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<SawTableRecipeInput>> getType() {
        return SnailRecipe.SAW_TABLE_RECIPE_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        List<Optional<Ingredient>> slotsInputIdk = List.of(
                Optional.of(mainInput),
                Optional.of(additionalInput)
        );
        return IngredientPlacement.forMultipleSlots(slotsInputIdk);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<SawTableRecipe> {
        public static final MapCodec<SawTableRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("input").forGetter(SawTableRecipe::mainInput),
                Ingredient.CODEC.fieldOf("additionalInput").forGetter(SawTableRecipe::additionalInput),

                ItemStack.CODEC.optionalFieldOf("stairs", ItemStack.EMPTY).forGetter(SawTableRecipe::stairs),
                ItemStack.CODEC.optionalFieldOf("slab", ItemStack.EMPTY).forGetter(SawTableRecipe::slab),
                ItemStack.CODEC.optionalFieldOf("door", ItemStack.EMPTY).forGetter(SawTableRecipe::door),
                ItemStack.CODEC.optionalFieldOf("bed", ItemStack.EMPTY).forGetter(SawTableRecipe::bed),
                ItemStack.CODEC.optionalFieldOf("fence", ItemStack.EMPTY).forGetter(SawTableRecipe::fence),
                ItemStack.CODEC.optionalFieldOf("fenceGate", ItemStack.EMPTY).forGetter(SawTableRecipe::fenceGate),
                ItemStack.CODEC.optionalFieldOf("chest", ItemStack.EMPTY).forGetter(SawTableRecipe::chest),
                ItemStack.CODEC.optionalFieldOf("barrel", ItemStack.EMPTY).forGetter(SawTableRecipe::barrel),
                ItemStack.CODEC.optionalFieldOf("planks", ItemStack.EMPTY).forGetter(SawTableRecipe::planks),
                ItemStack.CODEC.optionalFieldOf("hangingSign", ItemStack.EMPTY).forGetter(SawTableRecipe::hangingSign),
                ItemStack.CODEC.optionalFieldOf("sign", ItemStack.EMPTY).forGetter(SawTableRecipe::sign),
                ItemStack.CODEC.optionalFieldOf("trapdoor", ItemStack.EMPTY).forGetter(SawTableRecipe::trapdoor),
                ItemStack.CODEC.optionalFieldOf("boat", ItemStack.EMPTY).forGetter(SawTableRecipe::boat)
        ).apply(instance, SawTableRecipe::new));

        public static final PacketCodec<RegistryByteBuf, SawTableRecipe> PACKET_CODEC =
                SnailPacketCodec.tuple(
                        Ingredient.PACKET_CODEC, SawTableRecipe::mainInput,
                        Ingredient.PACKET_CODEC, SawTableRecipe::additionalInput,
                        ItemStack.PACKET_CODEC, SawTableRecipe::stairs,
                        ItemStack.PACKET_CODEC, SawTableRecipe::slab,
                        ItemStack.PACKET_CODEC, SawTableRecipe::door,
                        ItemStack.PACKET_CODEC, SawTableRecipe::bed,
                        ItemStack.PACKET_CODEC, SawTableRecipe::fence,
                        ItemStack.PACKET_CODEC, SawTableRecipe::fenceGate,
                        ItemStack.PACKET_CODEC, SawTableRecipe::chest,
                        ItemStack.PACKET_CODEC, SawTableRecipe::barrel,
                        ItemStack.PACKET_CODEC, SawTableRecipe::planks,
                        ItemStack.PACKET_CODEC, SawTableRecipe::hangingSign,
                        ItemStack.PACKET_CODEC, SawTableRecipe::sign,
                        ItemStack.PACKET_CODEC, SawTableRecipe::trapdoor,
                        ItemStack.PACKET_CODEC, SawTableRecipe::boat,
                        SawTableRecipe::new);

        @Override
        public MapCodec<SawTableRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, SawTableRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}