package net.numericalk.snailspeed.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.compat.custom.*;
import net.numericalk.snailspeed.screen.custom.ArmorForgeScreen;
import net.numericalk.snailspeed.screen.custom.SawTableScreen;
import net.numericalk.snailspeed.screen.custom.WeaponForgeScreen;

@Environment(EnvType.CLIENT)
public class SnailspeedREIClient implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ArmorForgeRecipeCategory());
        registry.addWorkstations(SnailRecipeCategories.ARMOR_FORGE, EntryStacks.of(SnailBlocks.ARMOR_FORGE));
        registry.add(new SawTableRecipeCategory());
        registry.addWorkstations(SnailRecipeCategories.SAW_TABLE, EntryStacks.of(SnailBlocks.SAW_TABLE));
        registry.add(new BrickFurnaceRecipeCategory());
        registry.addWorkstations(SnailRecipeCategories.BRICK_FURNACE, EntryStacks.of(SnailBlocks.BRICK_FURNACE));
        registry.add(new FilteringTrayRecipeCategory());
        registry.addWorkstations(SnailRecipeCategories.FILTERING_TRAY, EntryStacks.of(SnailBlocks.FILTERING_TRAY));
        registry.add(new BrickOvenCookingRecipeCategory());
        registry.addWorkstations(SnailRecipeCategories.BRICK_OVEN_COOKING, EntryStacks.of(SnailBlocks.BRICK_OVEN));
        registry.add(new BrickOvenSmeltingRecipeCategory());
        registry.addWorkstations(SnailRecipeCategories.BRICK_OVEN_SMELTING, EntryStacks.of(SnailBlocks.BRICK_OVEN));
        registry.add(new WeaponForgeRecipeCategory());
        registry.addWorkstations(SnailRecipeCategories.WEAPON_FORGE, EntryStacks.of(SnailBlocks.WEAPON_FORGE));
        registry.add(new MortarRecipeCategory());
        registry.addWorkstations(SnailRecipeCategories.MORTAR, EntryStacks.of(SnailBlocks.MORTAR));
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 84,
                        ((screen.height - 166) / 2) + 30, 8, 7), ArmorForgeScreen.class,
                SnailRecipeCategories.ARMOR_FORGE);
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 71,
                        ((screen.height - 166) / 2) + 38, 7, 8), ArmorForgeScreen.class,
                SnailRecipeCategories.ARMOR_FORGE);
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 84,
                        ((screen.height - 166) / 2) + 52, 8, 7), ArmorForgeScreen.class,
                SnailRecipeCategories.ARMOR_FORGE);
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 98,
                        ((screen.height - 166) / 2) + 38, 7, 8), ArmorForgeScreen.class,
                SnailRecipeCategories.ARMOR_FORGE);

        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 16,
                        ((screen.height - 166) / 2) + 36, 13, 13), SawTableScreen.class,
                SnailRecipeCategories.SAW_TABLE);

        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 67,
                        ((screen.height - 166) / 2) + 36, 22, 15), WeaponForgeScreen.class,
                SnailRecipeCategories.WEAPON_FORGE);
    }
}
