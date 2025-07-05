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

public record BrickOvenSmeltingRecipe(Ingredient input, ItemStack output) implements Recipe<BrickOvenSmeltingRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.input);
        return list;
    }
    public ItemStack getOutput() {
        return output;
    }


    @Override
    public boolean matches(BrickOvenSmeltingRecipeInput input, World world) {
        return this.input.test(input.getStackInSlot(0)) ||
                this.input.test(input.getStackInSlot(1)) ||
                this.input.test(input.getStackInSlot(2)) ||
                this.input.test(input.getStackInSlot(3)) ||
                this.input.test(input.getStackInSlot(4));
    }

    @Override
    public ItemStack craft(BrickOvenSmeltingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<BrickOvenSmeltingRecipeInput>> getSerializer() {
        return SnailRecipe.BRICK_OVEN_SMELTING_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<BrickOvenSmeltingRecipeInput>> getType() {
        return SnailRecipe.BRICK_OVEN_SMELTING_RECIPE_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(input);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }
    public static class Serializer implements RecipeSerializer<BrickOvenSmeltingRecipe> {
        public static final MapCodec<BrickOvenSmeltingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("input").forGetter(BrickOvenSmeltingRecipe::input),

                ItemStack.CODEC.fieldOf("output").forGetter(BrickOvenSmeltingRecipe::output)
        ).apply(instance, BrickOvenSmeltingRecipe::new));

        public static final PacketCodec<RegistryByteBuf, BrickOvenSmeltingRecipe> PACKET_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, BrickOvenSmeltingRecipe::input,

                        ItemStack.PACKET_CODEC, BrickOvenSmeltingRecipe::output,
                        BrickOvenSmeltingRecipe::new);

        @Override
        public MapCodec<BrickOvenSmeltingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, BrickOvenSmeltingRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
