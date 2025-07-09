package net.numericalk.snailspeed.recipe.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record WeaponForgeRecipeInput(ItemStack inputHead, ItemStack inputAdditional, ItemStack inputGlue) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot){
            case 0 -> this.inputHead;
            case 1 -> this.inputAdditional;
            case 2 -> this.inputGlue;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        };
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public boolean isEmpty() {
        return this.inputHead.isEmpty() && this.inputAdditional.isEmpty() && this.inputGlue.isEmpty();
    }

}
