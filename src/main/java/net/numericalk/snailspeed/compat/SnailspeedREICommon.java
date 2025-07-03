package net.numericalk.snailspeed.compat;

import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
import net.numericalk.snailspeed.compat.custom.*;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.recipe.custom.ArmorForgeRecipe;
import net.numericalk.snailspeed.recipe.custom.BrickFurnaceRecipe;
import net.numericalk.snailspeed.recipe.custom.SawTableRecipe;

public class SnailspeedREICommon implements REICommonPlugin {
    @Override
    public void registerDisplays(ServerDisplayRegistry registry) {
        registry.beginRecipeFiller(ArmorForgeRecipe.class)
                .filterType(SnailRecipe.ARMOR_FORGE_RECIPE_TYPE)
                .fill(ArmorForgeRecipeDisplay::new);
        registry.beginRecipeFiller(SawTableRecipe.class)
                .filterType(SnailRecipe.SAW_TABLE_RECIPE_TYPE)
                .fill(SawTableRecipeDisplay::new);
        registry.beginRecipeFiller(BrickFurnaceRecipe.class)
                .filterType(SnailRecipe.BRICK_FURNACE_RECIPE_TYPE)
                .fill(BrickFurnaceRecipeDisplay::new);
    }

    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(ArmorForgeRecipeCategory.ARMOR_FORGE.getIdentifier(), ArmorForgeRecipeDisplay.SERIALIZER);
        registry.register(SawTableRecipeCategory.SAW_TABLE.getIdentifier(), SawTableRecipeDisplay.SERIALIZER);
        registry.register(BrickFurnaceRecipeCategory.BRICK_FURNACE.getIdentifier(), BrickFurnaceRecipeDisplay.SERIALIZER);
    }
}
