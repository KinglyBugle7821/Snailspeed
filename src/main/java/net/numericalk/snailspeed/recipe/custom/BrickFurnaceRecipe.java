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
import net.numericalk.snailspeed.utils.enums.SawCraftable;
import net.numericalk.snailspeed.utils.records.SnailPacketCodec;

import java.util.List;
import java.util.Optional;

public record BrickFurnaceRecipe(Ingredient input1, Ingredient input2, Ingredient input3, Ingredient input4, Ingredient input5, ItemStack output) implements Recipe<BrickFurnaceRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.input1);
        list.add(this.input2);
        list.add(this.input3);
        list.add(this.input4);
        list.add(this.input5);
        return list;
    }

    public ItemStack getOutput() {
        return output;
    }

    @Override
    public boolean matches(BrickFurnaceRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return input1.test(input.getStackInSlot(0)) &&
                input2.test(input.getStackInSlot(1)) &&
                input3.test(input.getStackInSlot(2)) &&
                input4.test(input.getStackInSlot(3)) &&
                input5.test(input.getStackInSlot(4));
    }

    @Override
    public ItemStack craft(BrickFurnaceRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<BrickFurnaceRecipeInput>> getSerializer() {
        return SnailRecipe.BRICK_FURNACE_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<BrickFurnaceRecipeInput>> getType() {
        return SnailRecipe.BRICK_FURNACE_RECIPE_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        List<Optional<Ingredient>> slotsInputIdk = List.of(
                Optional.of(input1),
                Optional.of(input2),
                Optional.of(input3),
                Optional.of(input4),
                Optional.of(input5)
        );
        return IngredientPlacement.forMultipleSlots(slotsInputIdk);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;  
    }

    public static class Serializer implements RecipeSerializer<BrickFurnaceRecipe> {
        public static final MapCodec<BrickFurnaceRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("input1").forGetter(BrickFurnaceRecipe::input1),
                Ingredient.CODEC.fieldOf("input2").forGetter(BrickFurnaceRecipe::input2),
                Ingredient.CODEC.fieldOf("input3").forGetter(BrickFurnaceRecipe::input3),
                Ingredient.CODEC.fieldOf("input4").forGetter(BrickFurnaceRecipe::input4),
                Ingredient.CODEC.fieldOf("input5").forGetter(BrickFurnaceRecipe::input5),

                ItemStack.CODEC.fieldOf("output").forGetter(BrickFurnaceRecipe::output)
        ).apply(instance, BrickFurnaceRecipe::new));

        public static final PacketCodec<RegistryByteBuf, BrickFurnaceRecipe> PACKET_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, BrickFurnaceRecipe::input1,
                        Ingredient.PACKET_CODEC, BrickFurnaceRecipe::input2,
                        Ingredient.PACKET_CODEC, BrickFurnaceRecipe::input3,
                        Ingredient.PACKET_CODEC, BrickFurnaceRecipe::input4,
                        Ingredient.PACKET_CODEC, BrickFurnaceRecipe::input5,
                        ItemStack.PACKET_CODEC, BrickFurnaceRecipe::output,
                        BrickFurnaceRecipe::new);

        @Override
        public MapCodec<BrickFurnaceRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, BrickFurnaceRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
