package net.numericalk.snailspeed.recipe.special;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import net.numericalk.snailspeed.recipe.SnailRecipe;

public class SnailTippedArrowRecipe extends SpecialCraftingRecipe {
    public SnailTippedArrowRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput craftingRecipeInput, World world) {
        if (craftingRecipeInput.getWidth() == 2 && craftingRecipeInput.getHeight() == 2 && craftingRecipeInput.getStackCount() == 4) {
            for (int i = 0; i < craftingRecipeInput.getHeight(); i++) {
                for (int j = 0; j < craftingRecipeInput.getWidth(); j++) {
                    ItemStack itemStack = craftingRecipeInput.getStackInSlot(j, i);
                    if (itemStack.isEmpty()) {
                        return false;
                    }

                    if (j == 1 && i == 1) {
                        if (!itemStack.isOf(Items.LINGERING_POTION)) {
                            return false;
                        }
                    } else if (!itemStack.isOf(Items.ARROW)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public ItemStack craft(CraftingRecipeInput craftingRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup) {
        ItemStack itemStack = craftingRecipeInput.getStackInSlot(1, 1);
        if (!itemStack.isOf(Items.LINGERING_POTION)) {
            return ItemStack.EMPTY;
        } else {
            ItemStack itemStack2 = new ItemStack(Items.TIPPED_ARROW, 3);
            itemStack2.set(DataComponentTypes.POTION_CONTENTS, itemStack.get(DataComponentTypes.POTION_CONTENTS));
            return itemStack2;
        }
    }

    @Override
    public RecipeSerializer<SnailTippedArrowRecipe> getSerializer() {
        return SnailRecipe.SNAIL_TIPPED_ARROW;
    }
}
