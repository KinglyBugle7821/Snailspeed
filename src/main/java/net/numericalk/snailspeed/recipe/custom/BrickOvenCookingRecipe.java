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

public record BrickOvenCookingRecipe(Ingredient input, ItemStack output) implements Recipe<BrickOvenCookingRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.input);
        return list;
    }
    public ItemStack getOutput() {
        return output;
    }


    @Override
    public boolean matches(BrickOvenCookingRecipeInput input, World world) {
        return this.input.test(input.getStackInSlot(0)) ||
                this.input.test(input.getStackInSlot(1)) ||
                this.input.test(input.getStackInSlot(2)) ||
                this.input.test(input.getStackInSlot(3)) ||
                this.input.test(input.getStackInSlot(4));
    }

    @Override
    public ItemStack craft(BrickOvenCookingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<BrickOvenCookingRecipeInput>> getSerializer() {
        return SnailRecipe.BRICK_OVEN_COOKING_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<BrickOvenCookingRecipeInput>> getType() {
        return SnailRecipe.BRICK_OVEN_COOKING_RECIPE_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(input);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }
    public static class Serializer implements RecipeSerializer<BrickOvenCookingRecipe> {
        public static final MapCodec<BrickOvenCookingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("input").forGetter(BrickOvenCookingRecipe::input),

                ItemStack.CODEC.fieldOf("output").forGetter(BrickOvenCookingRecipe::output)
        ).apply(instance, BrickOvenCookingRecipe::new));

        public static final PacketCodec<RegistryByteBuf, BrickOvenCookingRecipe> PACKET_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, BrickOvenCookingRecipe::input,

                        ItemStack.PACKET_CODEC, BrickOvenCookingRecipe::output,
                        BrickOvenCookingRecipe::new);

        @Override
        public MapCodec<BrickOvenCookingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, BrickOvenCookingRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
