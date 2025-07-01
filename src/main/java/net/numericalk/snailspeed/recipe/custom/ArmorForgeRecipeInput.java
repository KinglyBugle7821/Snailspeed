package net.numericalk.snailspeed.recipe.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;
import net.numericalk.snailspeed.utils.enums.ArmorPiece;

public record ArmorForgeRecipeInput(ItemStack inputPlate, ItemStack inputBinding, ItemStack inputFastener, ItemStack inputTool, ArmorPiece selectedPiece) implements RecipeInput {

    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot) {
            case 0 -> this.inputPlate;
            case 1 -> this.inputBinding;
            case 2 -> this.inputFastener;
            case 3 -> this.inputTool;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        };
    }

    @Override
    public int size() {
        return 4;
    }

    @Override
    public boolean isEmpty() {
        return this.inputPlate.isEmpty() && this.inputBinding.isEmpty() && this.inputFastener.isEmpty() && this.inputTool.isEmpty();
    }
}
