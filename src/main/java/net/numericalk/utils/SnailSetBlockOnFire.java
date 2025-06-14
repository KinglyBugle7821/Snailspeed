package net.numericalk.utils;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.numericalk.blocks.SnailBlocks;

public class SnailSetBlockOnFire {
    public static void SetOnFire(){
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.TRIMMED_OAK_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.TRIMMED_SPRUCE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.TRIMMED_BIRCH_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.TRIMMED_JUNGLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.TRIMMED_ACACIA_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.TRIMMED_DARK_OAK_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.TRIMMED_MANGROVE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.TRIMMED_CHERRY_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.TRIMMED_PALE_OAK_LOG, 5, 20);

        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.CRACKED_OAK_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.CRACKED_SPRUCE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.CRACKED_BIRCH_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.CRACKED_JUNGLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.CRACKED_ACACIA_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.CRACKED_DARK_OAK_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.CRACKED_MANGROVE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.CRACKED_CHERRY_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.CRACKED_PALE_OAK_LOG, 5, 20);

        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.DAMAGED_OAK_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.DAMAGED_SPRUCE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.DAMAGED_BIRCH_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.DAMAGED_JUNGLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.DAMAGED_ACACIA_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.DAMAGED_DARK_OAK_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.DAMAGED_MANGROVE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.DAMAGED_CHERRY_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.DAMAGED_PALE_OAK_LOG, 5, 20);

        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.GRASS_SHEAF, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(SnailBlocks.DRIED_GRASS_SHEAF, 80, 100);
    }
}
