package net.numericalk.snailspeed.recipe.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.utils.enums.ArmorPiece;

import java.util.List;
import java.util.Optional;

public record ArmorForgeRecipe(Ingredient inputPlate, Ingredient inputBinding, Ingredient inputFastener, Ingredient inputTool,
                                ItemStack outputHelmet, ItemStack outputChestplate, ItemStack outputLeggings, ItemStack outputBoots) implements Recipe<ArmorForgeRecipeInput> {

    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputPlate);
        list.add(this.inputBinding);
        list.add(this.inputFastener);
        list.add(this.inputTool);
        return list;
    }

    public ItemStack getOutput(ArmorPiece armorPiece) {
        return switch (armorPiece) {
            case HELMET -> outputHelmet;
            case CHESTPLATE -> outputChestplate;
            case LEGGINGS -> outputLeggings;
            case BOOTS -> outputBoots;
        };
    }

    @Override
    public boolean matches(ArmorForgeRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }

        return inputPlate.test(input.getStackInSlot(0)) &&
                inputBinding.test(input.getStackInSlot(1)) &&
                inputFastener.test(input.getStackInSlot(2)) &&
                inputTool.test(input.getStackInSlot(3));
    }

    @Override
    public ItemStack craft(ArmorForgeRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return switch (input.selectedPiece()) {
            case HELMET -> outputHelmet.copy();
            case CHESTPLATE -> outputChestplate.copy();
            case LEGGINGS -> outputLeggings.copy();
            case BOOTS -> outputBoots.copy();
        };
    }

    @Override
    public RecipeSerializer<? extends Recipe<ArmorForgeRecipeInput>> getSerializer() {
        return SnailRecipe.ARMOR_FORGE_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<ArmorForgeRecipeInput>> getType() {
        return SnailRecipe.ARMOR_FORGE_RECIPE_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        List<Optional<Ingredient>> slotsInputIdk = List.of(
                Optional.of(inputPlate),
                Optional.of(inputBinding),
                Optional.of(inputFastener),
                Optional.of(inputTool)
        );

        return IngredientPlacement.forMultipleSlots(slotsInputIdk);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return outputHelmet.copy();
    }

    public static class Serializer implements RecipeSerializer<ArmorForgeRecipe> {
        public static final MapCodec<ArmorForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("inputPlate").forGetter(ArmorForgeRecipe::inputPlate),
                Ingredient.CODEC.fieldOf("inputBinding").forGetter(ArmorForgeRecipe::inputBinding),
                Ingredient.CODEC.fieldOf("inputFastener").forGetter(ArmorForgeRecipe::inputFastener),
                Ingredient.CODEC.fieldOf("inputTool").forGetter(ArmorForgeRecipe::inputTool),
                ItemStack.CODEC.optionalFieldOf("outputHelmet", ItemStack.EMPTY).forGetter(ArmorForgeRecipe::outputHelmet),
                ItemStack.CODEC.optionalFieldOf("outputChestplate", ItemStack.EMPTY).forGetter(ArmorForgeRecipe::outputChestplate),
                ItemStack.CODEC.optionalFieldOf("outputLeggings", ItemStack.EMPTY).forGetter(ArmorForgeRecipe::outputLeggings),
                ItemStack.CODEC.optionalFieldOf("outputBoots", ItemStack.EMPTY).forGetter(ArmorForgeRecipe::outputBoots)
        ).apply(instance, ArmorForgeRecipe::new));
        public static final PacketCodec<RegistryByteBuf, ArmorForgeRecipe> PACKET_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, ArmorForgeRecipe::inputPlate,
                        Ingredient.PACKET_CODEC, ArmorForgeRecipe::inputBinding,
                        Ingredient.PACKET_CODEC, ArmorForgeRecipe::inputFastener,
                        Ingredient.PACKET_CODEC, ArmorForgeRecipe::inputTool,
                        ItemStack.PACKET_CODEC, ArmorForgeRecipe::outputHelmet,
                        ItemStack.PACKET_CODEC, ArmorForgeRecipe::outputChestplate,
                        ItemStack.PACKET_CODEC, ArmorForgeRecipe::outputLeggings,
                        ItemStack.PACKET_CODEC, ArmorForgeRecipe::outputBoots,
                        ArmorForgeRecipe::new);

        @Override
        public MapCodec<ArmorForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, ArmorForgeRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
