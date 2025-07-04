package net.numericalk.snailspeed.recipe.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record FilteringTrayRecipeInput(ItemStack input1, ItemStack input2) implements RecipeInput {

    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot){
            case 0 -> input1;
            case 1 -> input2;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        };
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return input1.isEmpty() && input2.isEmpty();
    }
}
