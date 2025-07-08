package net.numericalk.snailspeed.compat;

import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
import net.numericalk.snailspeed.compat.custom.*;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.recipe.custom.*;

public class SnailspeedREICommon implements REICommonPlugin {
    @Override
    public void registerDisplays(ServerDisplayRegistry registry) {
        registry.beginRecipeFiller(ArmorForgeRecipe.class)
                .filterType(SnailRecipe.ARMOR_FORGE_RECIPE_TYPE)
                .fill(ArmorForgeRecipeDisplay::new);
        registry.beginRecipeFiller(SawTableRecipe.class)
                .filterType(SnailRecipe.SAW_TABLE_RECIPE_TYPE)
                .fill(SawTableRecipeDisplay::new);
        registry.beginRecipeFiller(BrickOvenCookingRecipe.class)
                .filterType(SnailRecipe.BRICK_OVEN_COOKING_RECIPE_TYPE)
                .fill(BrickOvenCookingRecipeDisplay::new);
        registry.beginRecipeFiller(BrickOvenSmeltingRecipe.class)
                .filterType(SnailRecipe.BRICK_OVEN_SMELTING_RECIPE_TYPE)
                .fill(BrickOvenSmeltingRecipeDisplay::new);
        registry.beginRecipeFiller(BrickFurnaceRecipe.class)
                .filterType(SnailRecipe.BRICK_FURNACE_RECIPE_TYPE)
                .fill(BrickFurnaceRecipeDisplay::new);
        registry.beginRecipeFiller(FilteringTrayRecipe.class)
                .filterType(SnailRecipe.FILTERING_TRAY_RECIPE_TYPE)
                .fill(FilteringTrayRecipeDisplay::new);
        registry.beginRecipeFiller(WeaponForgeRecipe.class)
                .filterType(SnailRecipe.WEAPON_FORGE_RECIPE_TYPE)
                .fill(WeaponForgeRecipeDisplay::new);
        registry.beginRecipeFiller(MortarRecipe.class)
                .filterType(SnailRecipe.MORTAR_RECIPE_TYPE)
                .fill(MortarRecipeDisplay::new);

    }

    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(SnailRecipeCategories.ARMOR_FORGE.getIdentifier(), ArmorForgeRecipeDisplay.SERIALIZER);
        registry.register(SnailRecipeCategories.SAW_TABLE.getIdentifier(), SawTableRecipeDisplay.SERIALIZER);
        registry.register(SnailRecipeCategories.BRICK_FURNACE.getIdentifier(), BrickFurnaceRecipeDisplay.SERIALIZER);
        registry.register(SnailRecipeCategories.FILTERING_TRAY.getIdentifier(), FilteringTrayRecipeDisplay.SERIALIZER);
        registry.register(SnailRecipeCategories.BRICK_OVEN_COOKING.getIdentifier(), BrickOvenCookingRecipeDisplay.SERIALIZER);
        registry.register(SnailRecipeCategories.BRICK_OVEN_SMELTING.getIdentifier(), BrickOvenSmeltingRecipeDisplay.SERIALIZER);
        registry.register(SnailRecipeCategories.WEAPON_FORGE.getIdentifier(), WeaponForgeRecipeDisplay.SERIALIZER);
        registry.register(SnailRecipeCategories.MORTAR.getIdentifier(), MortarRecipeDisplay.SERIALIZER);
    }
}
