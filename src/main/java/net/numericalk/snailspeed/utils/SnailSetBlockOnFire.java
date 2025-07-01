package net.numericalk.snailspeed.utils;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.numericalk.snailspeed.blocks.SnailBlocks;

public class SnailSetBlockOnFire {
    public static void SetOnFire() {
        FlammableBlockRegistry defaultInstance = FlammableBlockRegistry.getDefaultInstance();
        defaultInstance.add(SnailBlocks.TRIMMED_OAK_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.TRIMMED_SPRUCE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.TRIMMED_BIRCH_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.TRIMMED_JUNGLE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.TRIMMED_ACACIA_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.TRIMMED_DARK_OAK_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.TRIMMED_MANGROVE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.TRIMMED_CHERRY_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.TRIMMED_PALE_OAK_LOG, 5, 20);

        defaultInstance.add(SnailBlocks.CRACKED_OAK_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.CRACKED_SPRUCE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.CRACKED_BIRCH_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.CRACKED_JUNGLE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.CRACKED_ACACIA_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.CRACKED_DARK_OAK_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.CRACKED_MANGROVE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.CRACKED_CHERRY_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.CRACKED_PALE_OAK_LOG, 5, 20);

        defaultInstance.add(SnailBlocks.DAMAGED_OAK_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_SPRUCE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_BIRCH_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_JUNGLE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_ACACIA_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_DARK_OAK_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_MANGROVE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_CHERRY_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_PALE_OAK_LOG, 5, 20);

        defaultInstance.add(SnailBlocks.DAMAGED_OAK_PLANKS, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_SPRUCE_PLANKS, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_BIRCH_PLANKS, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_JUNGLE_PLANKS, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_ACACIA_PLANKS, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_DARK_OAK_PLANKS, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_MANGROVE_PLANKS, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_CHERRY_PLANKS, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_BAMBOO_PLANKS, 5, 20);
        defaultInstance.add(SnailBlocks.DAMAGED_PALE_OAK_PLANKS, 5, 20);

        defaultInstance.add(SnailBlocks.GRASS_SHEAF, 30, 60);
        defaultInstance.add(SnailBlocks.DRIED_GRASS_SHEAF, 80, 100);

        defaultInstance.add(SnailBlocks.TAPPED_SPRUCE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.TAPPED_BIRCH_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.TAPPED_PALE_OAK_LOG, 5, 20);

        defaultInstance.add(SnailBlocks.DECAYED_SPRUCE_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.DECAYED_BIRCH_LOG, 5, 20);
        defaultInstance.add(SnailBlocks.DECAYED_PALE_OAK_LOG, 5, 20);

        defaultInstance.add(SnailBlocks.STICK_BUNDLE, 5, 20);
        defaultInstance.add(SnailBlocks.UNTIED_STICK_BUNDLE, 5, 20);

        defaultInstance.add(SnailBlocks.RESIN_BOWL, 5, 20);
    }
}
