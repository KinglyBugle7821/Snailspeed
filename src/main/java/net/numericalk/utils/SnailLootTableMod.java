package net.numericalk.utils;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.numericalk.items.SnailItems;

public class SnailLootTableMod {

    private static final Identifier OAK_LOG_ID = Identifier.of("minecraft", "blocks/oak_log");
    private static final Identifier STRIPPED_OAK_LOG_ID = Identifier.of("minecraft", "blocks/stripped_oak_log");
    private static final Identifier OAK_WOOD_ID = Identifier.of("minecraft", "blocks/oak_wood");

    private static final Identifier SPRUCE_LOG_ID = Identifier.of("minecraft", "blocks/spruce_log");
    private static final Identifier STRIPPED_SPRUCE_LOG_ID = Identifier.of("minecraft", "blocks/stripped_spruce_log");
    private static final Identifier SPRUCE_WOOD_ID = Identifier.of("minecraft", "blocks/spruce_wood");

    private static final Identifier BIRCH_LOG_ID = Identifier.of("minecraft", "blocks/birch_log");
    private static final Identifier STRIPPED_BIRCH_LOG_ID = Identifier.of("minecraft", "blocks/stripped_birch_log");
    private static final Identifier BIRCH_WOOD_ID = Identifier.of("minecraft", "blocks/birch_wood");

    private static final Identifier JUNGLE_LOG_ID = Identifier.of("minecraft", "blocks/jungle_log");
    private static final Identifier STRIPPED_JUNGLE_LOG_ID = Identifier.of("minecraft", "blocks/stripped_jungle_log");
    private static final Identifier JUNGLE_WOOD_ID = Identifier.of("minecraft", "blocks/jungle_wood");

    private static final Identifier ACACIA_LOG_ID = Identifier.of("minecraft", "blocks/acacia_log");
    private static final Identifier STRIPPED_ACACIA_LOG_ID = Identifier.of("minecraft", "blocks/stripped_acacia_log");
    private static final Identifier ACACIA_WOOD_ID = Identifier.of("minecraft", "blocks/acacia_wood");

    private static final Identifier DARK_OAK_LOG_ID = Identifier.of("minecraft", "blocks/dark_oak_log");
    private static final Identifier STRIPPED_DARK_OAK_LOG_ID = Identifier.of("minecraft", "blocks/stripped_dark_oak_log");
    private static final Identifier DARK_OAK_WOOD_ID = Identifier.of("minecraft", "blocks/dark_oak_wood");

    private static final Identifier MANGROVE_LOG_ID = Identifier.of("minecraft", "blocks/mangrove_log");
    private static final Identifier STRIPPED_MANGROVE_LOG_ID = Identifier.of("minecraft", "blocks/stripped_mangrove_log");
    private static final Identifier MANGROVE_WOOD_ID = Identifier.of("minecraft", "blocks/mangrove_wood");

    private static final Identifier CHERRY_LOG_ID = Identifier.of("minecraft", "blocks/cherry_log");
    private static final Identifier STRIPPED_CHERRY_LOG_ID = Identifier.of("minecraft", "blocks/stripped_cherry_log");
    private static final Identifier CHERRY_WOOD_ID = Identifier.of("minecraft", "blocks/cherry_wood");

    private static final Identifier PALE_OAK_LOG_ID = Identifier.of("minecraft", "blocks/pale_oak_log");
    private static final Identifier STRIPPED_PALE_OAK_LOG_ID = Identifier.of("minecraft", "blocks/stripped_pale_oak_log");
    private static final Identifier PALE_OAK_WOOD_ID = Identifier.of("minecraft", "blocks/pale_oak_wood");

    private static final Identifier CRIMSON_STEM_ID = Identifier.of("minecraft", "blocks/crimson_stem");
    private static final Identifier STRIPPED_CRIMSON_STEM_ID = Identifier.of("minecraft", "blocks/stripped_crimson_stem");
    private static final Identifier CRIMSON_HYPHAE_ID = Identifier.of("minecraft", "blocks/crimson_hyphae");

    private static final Identifier WARPED_STEM_ID = Identifier.of("minecraft", "blocks/warped_stem");
    private static final Identifier STRIPPED_WARPED_STEM_ID = Identifier.of("minecraft", "blocks/stripped_warped_stem");
    private static final Identifier WARPED_HYPHAE_ID = Identifier.of("minecraft", "blocks/warped_hyphae");

    public static void modifyLootTables() {
        Object[][] logToBark = {
                { OAK_LOG_ID, OAK_WOOD_ID, STRIPPED_OAK_LOG_ID, SnailItems.OAK_LOG_BARK },
                { SPRUCE_LOG_ID, SPRUCE_WOOD_ID, STRIPPED_SPRUCE_LOG_ID, SnailItems.SPRUCE_LOG_BARK },
                { BIRCH_LOG_ID, BIRCH_WOOD_ID, STRIPPED_BIRCH_LOG_ID, SnailItems.BIRCH_LOG_BARK },
                { JUNGLE_LOG_ID, JUNGLE_WOOD_ID, STRIPPED_JUNGLE_LOG_ID, SnailItems.JUNGLE_LOG_BARK },
                { ACACIA_LOG_ID, ACACIA_WOOD_ID, STRIPPED_ACACIA_LOG_ID, SnailItems.ACACIA_LOG_BARK },
                { DARK_OAK_LOG_ID, DARK_OAK_WOOD_ID, STRIPPED_DARK_OAK_LOG_ID, SnailItems.DARK_OAK_LOG_BARK },
                { MANGROVE_LOG_ID, MANGROVE_WOOD_ID, STRIPPED_MANGROVE_LOG_ID, SnailItems.MANGROVE_LOG_BARK },
                { CHERRY_LOG_ID, CHERRY_WOOD_ID, STRIPPED_CHERRY_LOG_ID, SnailItems.CHERRY_LOG_BARK },
                { PALE_OAK_LOG_ID, PALE_OAK_WOOD_ID, STRIPPED_PALE_OAK_LOG_ID, SnailItems.PALE_OAK_LOG_BARK },
                { CRIMSON_STEM_ID, CRIMSON_HYPHAE_ID, STRIPPED_CRIMSON_STEM_ID, SnailItems.CRIMSON_STEM_BARK },
                { WARPED_STEM_ID, WARPED_HYPHAE_ID, STRIPPED_WARPED_STEM_ID, SnailItems.WARPED_STEM_BARK },
        };

        LootTableEvents.REPLACE.register((registryKey, lootTable, lootTableSource, wrapperLookup) -> {
            for (Object[] entry : logToBark) {
                Identifier log = (Identifier) entry[0];
                Identifier wood = (Identifier) entry[1];
                Identifier strippedLog = (Identifier) entry[2];
                Item bark = (Item) entry[3];

                if (log.equals(registryKey.getValue())) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(1.0F))
                            .with(ItemEntry.builder(bark))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)).build());

                    return LootTable.builder().pool(poolBuilder).build();
                }

                if (wood.equals(registryKey.getValue())) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(1.0F))
                            .with(ItemEntry.builder(bark))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2)).build());

                    return LootTable.builder().pool(poolBuilder).build();
                }
                if (wood.equals(registryKey.getValue())) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(1.0F))
                            .with(ItemEntry.builder(bark))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2)).build());

                    return LootTable.builder().pool(poolBuilder).build();
                }
                if (strippedLog.equals(registryKey.getValue())) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(1.0F))
                            .with(ItemEntry.builder(SnailItems.WOOD_DUST))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)).build());

                    return LootTable.builder().pool(poolBuilder).build();
                }
            }
            return lootTable;
        });
    }
}
