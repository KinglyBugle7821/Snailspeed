package net.numericalk.snailspeed.recipe.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;
import net.numericalk.snailspeed.utils.enums.ArmorPiece;

public record ArmorForgeRecipeInput(ItemStack inputPlate, ItemStack inputBinding, ItemStack inputFastener, ItemStack inputTool, ArmorPiece selected) implements RecipeInput {

    public ArmorPiece getSelectedPiece(){
        return selected;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        ItemStack stack;
        switch (slot){
            case 0 -> stack = this.inputPlate;
            case 1 -> stack = this.inputBinding;
            case 2 -> stack = this.inputFastener;
            case 3 -> stack = this.inputTool;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        }
        return stack;
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
