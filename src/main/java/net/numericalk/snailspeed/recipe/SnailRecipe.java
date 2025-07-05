package net.numericalk.snailspeed.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.recipe.custom.*;

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

    public static final RecipeSerializer<SawTableRecipe> SAW_TABLE_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Snailspeed.MOD_ID, "saw_table"),
            new SawTableRecipe.Serializer());
    public static final RecipeType<SawTableRecipe> SAW_TABLE_RECIPE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Snailspeed.MOD_ID, "saw_table"), new RecipeType<SawTableRecipe>() {
                @Override
                public String toString() {
                    return "saw_table";
                }
            });

    public static final RecipeSerializer<BrickFurnaceRecipe> BRICK_FURNACE_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Snailspeed.MOD_ID, "brick_furnace"),
            new BrickFurnaceRecipe.Serializer());
    public static final RecipeType<BrickFurnaceRecipe> BRICK_FURNACE_RECIPE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Snailspeed.MOD_ID, "brick_furnace"), new RecipeType<BrickFurnaceRecipe>() {
                @Override
                public String toString() {
                    return "brick_furnace";
                }
            });

    public static final RecipeSerializer<FilteringTrayRecipe> FILTERING_TRAY_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Snailspeed.MOD_ID, "filtering_tray"),
            new FilteringTrayRecipe.Serializer());
    public static final RecipeType<FilteringTrayRecipe> FILTERING_TRAY_RECIPE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Snailspeed.MOD_ID, "filtering_tray"), new RecipeType<FilteringTrayRecipe>() {
                @Override
                public String toString() {
                    return "filtering_tray";
                }
            });

    public static final RecipeSerializer<BrickOvenCookingRecipe> BRICK_OVEN_COOKING_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Snailspeed.MOD_ID, "brick_oven_cooking"),
            new BrickOvenCookingRecipe.Serializer());
    public static final RecipeType<BrickOvenCookingRecipe> BRICK_OVEN_COOKING_RECIPE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Snailspeed.MOD_ID, "brick_oven_cooking"), new RecipeType<BrickOvenCookingRecipe>() {
                @Override
                public String toString() {
                    return "brick_oven_cooking";
                }
            });

    public static final RecipeSerializer<BrickOvenSmeltingRecipe> BRICK_OVEN_SMELTING_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Snailspeed.MOD_ID, "brick_oven_smelting"),
            new BrickOvenSmeltingRecipe.Serializer());
    public static final RecipeType<BrickOvenSmeltingRecipe> BRICK_OVEN_SMELTING_RECIPE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Snailspeed.MOD_ID, "brick_oven_smelting"), new RecipeType<BrickOvenSmeltingRecipe>() {
                @Override
                public String toString() {
                    return "brick_oven_smelting";
                }
            });


    public static void initialize() {

    }
}