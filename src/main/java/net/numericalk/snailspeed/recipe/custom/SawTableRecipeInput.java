package net.numericalk.snailspeed.recipe.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;
import net.numericalk.snailspeed.utils.enums.SawCraftable;

public record SawTableRecipeInput(ItemStack input, ItemStack additionalInput, SawCraftable selected) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot){
            case 0 -> this.input;
            case 1 -> this.additionalInput;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        };
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return this.input.isEmpty() && this.additionalInput.isEmpty();
    }
}
