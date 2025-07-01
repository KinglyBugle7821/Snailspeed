package net.numericalk.snailspeed.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.recipe.custom.ArmorForgeRecipe;

public class SnailRecipe {
    public static final RecipeSerializer<ArmorForgeRecipe> ARMOR_FORGE_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Snailspeed.MOD_ID, "armor_forge"),
                    new ArmorForgeRecipe.Serializer());

    public static final RecipeType<ArmorForgeRecipe> ARMOR_FORGE_RECIPE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Snailspeed.MOD_ID, "armor_forge"), new RecipeType<ArmorForgeRecipe>() {
                @Override
                public String toString() {
                    return "armor_forge";
                }
            });

    public static void initialize() {

    }
}
