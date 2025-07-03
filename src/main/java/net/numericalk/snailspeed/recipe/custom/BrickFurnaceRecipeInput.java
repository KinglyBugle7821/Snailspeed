package net.numericalk.snailspeed.recipe.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record BrickFurnaceRecipeInput(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack input5) implements RecipeInput {

    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot){
            case 0 -> this.input1;
            case 1 -> this.input2;
            case 2 -> this.input3;
            case 3 -> this.input4;
            case 4 -> this.input5;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        };
    }

    @Override
    public int size() {
        return 5;
    }

    @Override
    public boolean isEmpty() {
        return this.input1.isEmpty() && this.input2.isEmpty() && this.input3.isEmpty() && this.input4.isEmpty() && this.input5.isEmpty();
    }
}
