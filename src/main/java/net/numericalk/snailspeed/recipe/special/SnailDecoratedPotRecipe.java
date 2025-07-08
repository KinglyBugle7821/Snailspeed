package net.numericalk.snailspeed.recipe.special;

import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.block.entity.Sherds;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.world.World;
import net.numericalk.snailspeed.recipe.SnailRecipe;

public class SnailDecoratedPotRecipe extends SpecialCraftingRecipe {
    public SnailDecoratedPotRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    private static ItemStack getBack(CraftingRecipeInput input) {
        return input.getStackInSlot(1, 0);
    }

    private static ItemStack getLeft(CraftingRecipeInput input) {
        return input.getStackInSlot(0, 0);
    }

    private static ItemStack getRight(CraftingRecipeInput input) {
        return input.getStackInSlot(1, 1);
    }

    private static ItemStack getFront(CraftingRecipeInput input) {
        return input.getStackInSlot(0, 1);
    }

    public boolean matches(CraftingRecipeInput craftingRecipeInput, World world) {
        return craftingRecipeInput.getWidth() == 2 && craftingRecipeInput.getHeight() == 2 && craftingRecipeInput.getStackCount() == 4
                ? getBack(craftingRecipeInput).isIn(ItemTags.DECORATED_POT_INGREDIENTS)
                && getLeft(craftingRecipeInput).isIn(ItemTags.DECORATED_POT_INGREDIENTS)
                && getRight(craftingRecipeInput).isIn(ItemTags.DECORATED_POT_INGREDIENTS)
                && getFront(craftingRecipeInput).isIn(ItemTags.DECORATED_POT_INGREDIENTS)
                : false;
    }

    public ItemStack craft(CraftingRecipeInput craftingRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup) {
        Sherds sherds = new Sherds(
                getBack(craftingRecipeInput).getItem(),
                getLeft(craftingRecipeInput).getItem(),
                getRight(craftingRecipeInput).getItem(),
                getFront(craftingRecipeInput).getItem()
        );
        return DecoratedPotBlockEntity.getStackWith(sherds);
    }

    @Override
    public RecipeSerializer<SnailDecoratedPotRecipe> getSerializer() {
        return SnailRecipe.SNAIL_DECORATED_POT;
    }
}
