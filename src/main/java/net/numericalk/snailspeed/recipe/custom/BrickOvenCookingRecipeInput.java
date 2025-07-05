package net.numericalk.snailspeed.recipe.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record BrickOvenCookingRecipeInput(ItemStack input) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }
    @Override
    public boolean isEmpty() {
        return input.isEmpty();
    }
}
