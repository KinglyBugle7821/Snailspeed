package net.numericalk.snailspeed.recipe.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.utils.records.SnailPacketCodec;

import java.util.List;
import java.util.Optional;

public record WeaponForgeRecipe(Ingredient inputHead, Ingredient inputAdditional, Ingredient inputGlue,
                                ItemStack output) implements Recipe<WeaponForgeRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputHead);
        list.add(this.inputAdditional);
        list.add(this.inputGlue);
        return list;
    }

    public ItemStack getOutput() {
        return output;
    }

    @Override
    public boolean matches(WeaponForgeRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return inputHead.test(input.getStackInSlot(0)) &&
                inputAdditional.test(input.getStackInSlot(1)) &&
                inputGlue.test(input.getStackInSlot(2));
    }

    @Override
    public ItemStack craft(WeaponForgeRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return output.copy();
    }
    @Override
    public RecipeSerializer<? extends Recipe<WeaponForgeRecipeInput>> getSerializer() {
        return SnailRecipe.WEAPON_FORGE_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<WeaponForgeRecipeInput>> getType() {
        return SnailRecipe.WEAPON_FORGE_RECIPE_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        List<Optional<Ingredient>> slotsInputIdk = List.of(
                Optional.of(inputHead),
                Optional.of(inputAdditional),
                Optional.of(inputGlue)
        );
        return IngredientPlacement.forMultipleSlots(slotsInputIdk);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<WeaponForgeRecipe> {
        public static final MapCodec<WeaponForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("inputHead").forGetter(WeaponForgeRecipe::inputHead),
                Ingredient.CODEC.fieldOf("inputAdditional").forGetter(WeaponForgeRecipe::inputAdditional),
                Ingredient.CODEC.fieldOf("inputGlue").forGetter(WeaponForgeRecipe::inputGlue),

                ItemStack.CODEC.fieldOf("output").forGetter(WeaponForgeRecipe::output)
        ).apply(instance, WeaponForgeRecipe::new));

        public static final PacketCodec<RegistryByteBuf, WeaponForgeRecipe> PACKET_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, WeaponForgeRecipe::inputHead,
                        Ingredient.PACKET_CODEC, WeaponForgeRecipe::inputAdditional,
                        Ingredient.PACKET_CODEC, WeaponForgeRecipe::inputGlue,
                        ItemStack.PACKET_CODEC, WeaponForgeRecipe::output,
                        WeaponForgeRecipe::new);

        @Override
        public MapCodec<WeaponForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, WeaponForgeRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
