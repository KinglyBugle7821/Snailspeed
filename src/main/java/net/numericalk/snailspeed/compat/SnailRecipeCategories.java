package net.numericalk.snailspeed.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.compat.custom.ArmorForgeRecipeDisplay;
import net.numericalk.snailspeed.compat.custom.FilteringTrayRecipeDisplay;
import net.numericalk.snailspeed.compat.custom.SawTableRecipeDisplay;

public class SnailRecipeCategories {
    public static final CategoryIdentifier<ArmorForgeRecipeDisplay> ARMOR_FORGE =
            CategoryIdentifier.of(Snailspeed.MOD_ID, "armor_forge");
    public static final CategoryIdentifier<ArmorForgeRecipeDisplay> BRICK_FURNACE =
            CategoryIdentifier.of(Snailspeed.MOD_ID, "brick_furnace");
    public static final CategoryIdentifier<FilteringTrayRecipeDisplay> FILTERING_TRAY =
            CategoryIdentifier.of(Snailspeed.MOD_ID, "filtering_tray");
    public static final CategoryIdentifier<SawTableRecipeDisplay> SAW_TABLE =
            CategoryIdentifier.of(Snailspeed.MOD_ID, "saw_table");

}
