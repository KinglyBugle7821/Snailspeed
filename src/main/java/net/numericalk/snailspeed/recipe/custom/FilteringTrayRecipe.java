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

import java.util.List;
import java.util.Optional;

public record FilteringTrayRecipe(Ingredient input1, Ingredient input2, ItemStack output) implements Recipe<FilteringTrayRecipeInput> {

    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.input1);
        list.add(this.input2);
        return list;
    }

    public ItemStack getOutput() {
        return output;
    }

    @Override
    public boolean matches(FilteringTrayRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return input1.test(input.getStackInSlot(0)) &&
                input2.test(input.getStackInSlot(1));
    }

    @Override
    public ItemStack craft(FilteringTrayRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<FilteringTrayRecipeInput>> getSerializer() {
        return SnailRecipe.FILTERING_TRAY_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<FilteringTrayRecipeInput>> getType() {
        return SnailRecipe.FILTERING_TRAY_RECIPE_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        List<Optional<Ingredient>> slotsInputIdk = List.of(
                Optional.of(input1),
                Optional.of(input2)
        );
        return IngredientPlacement.forMultipleSlots(slotsInputIdk);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<FilteringTrayRecipe> {
        public static final MapCodec<FilteringTrayRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("input1").forGetter(FilteringTrayRecipe::input1),
                Ingredient.CODEC.fieldOf("input2").forGetter(FilteringTrayRecipe::input2),

                ItemStack.CODEC.fieldOf("output").forGetter(FilteringTrayRecipe::output)
        ).apply(instance, FilteringTrayRecipe::new));

        public static final PacketCodec<RegistryByteBuf, FilteringTrayRecipe> PACKET_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, FilteringTrayRecipe::input1,
                        Ingredient.PACKET_CODEC, FilteringTrayRecipe::input2,

                        ItemStack.PACKET_CODEC, FilteringTrayRecipe::output,
                        FilteringTrayRecipe::new);

        @Override
        public MapCodec<FilteringTrayRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, FilteringTrayRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
