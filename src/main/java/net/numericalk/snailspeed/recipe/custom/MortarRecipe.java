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

public record MortarRecipe(Ingredient input, ItemStack output) implements Recipe<MortarRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.input);
        return list;
    }
    public ItemStack getOutput() {
        return output;
    }

    @Override
    public boolean matches(MortarRecipeInput input, World world) {
        if (world.isClient()) return false;
        return this.input.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(MortarRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<MortarRecipeInput>> getSerializer() {
        return SnailRecipe.MORTAR_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<MortarRecipeInput>> getType() {
        return SnailRecipe.MORTAR_RECIPE_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(input);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<MortarRecipe> {
        public static final MapCodec<MortarRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("input").forGetter(MortarRecipe::input),

                ItemStack.CODEC.fieldOf("output").forGetter(MortarRecipe::output)
        ).apply(instance, MortarRecipe::new));

        public static final PacketCodec<RegistryByteBuf, MortarRecipe> PACKET_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, MortarRecipe::input,

                        ItemStack.PACKET_CODEC, MortarRecipe::output,
                        MortarRecipe::new);

        @Override
        public MapCodec<MortarRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, MortarRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
