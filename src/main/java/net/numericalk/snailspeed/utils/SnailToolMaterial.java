package net.numericalk.snailspeed.utils;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.numericalk.snailspeed.datagen.SnailBlockTagsProvider;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;

public class SnailToolMaterial {
    public static final ToolMaterial FLINT_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            10,
            1.0F,
            1.0F,
            7,
            SnailItemTagsProvider.FLINT_FLAKE_REPAIRABLE
    );
    public static final ToolMaterial FLINT_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            32,
            2.0F,
            1.0F,
            10,
            SnailItemTagsProvider.FLINT_FLAKE_REPAIRABLE
    );
    public static final ToolMaterial COPPER_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            67,
            1.0F,
            2.0F,
            20,
            SnailItemTagsProvider.COPPER_TOOL_REPAIRABLE
    );

    public static final ToolMaterial BRONZE_TOOL_MATERIAL = new ToolMaterial(
            SnailBlockTagsProvider.INCORRECT_FOR_BRONZE_TOOL,
            131,
            2.0F,
            3.0F,
            20,
            SnailItemTagsProvider.COPPER_TOOL_REPAIRABLE
    );
}
