package net.numericalk.utils;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.numericalk.datagen.SnailItemTagsProvider;

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
}
