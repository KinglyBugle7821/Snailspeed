package net.numericalk.snailspeed.utils;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;

public class SnailLootTableMod {

    private static final Identifier CREEPER_ID = Identifier.of("minecraft", "entities/creeper");
    private static final Identifier ZOMBIE_ID = Identifier.of("minecraft", "entities/zombie");
    private static final Identifier HUSK_ID = Identifier.of("minecraft", "entities/husk");
    private static final Identifier DROWNED_ID = Identifier.of("minecraft", "entities/drowned");
    private static final Identifier SKELETON_ID = Identifier.of("minecraft", "entities/skeleton");
    private static final Identifier BOGGED_ID = Identifier.of("minecraft", "entities/bogged");
    private static final Identifier STRAY_ID = Identifier.of("minecraft", "entities/stray");
    private static final Identifier SPIDER_ID = Identifier.of("minecraft", "entities/spider");
    private static final Identifier CAVE_SPIDER_ID = Identifier.of("minecraft", "entities/cave_spider");

    private static final Identifier SHORT_GRASS_ID = Identifier.of("minecraft", "blocks/short_grass");
    private static final Identifier TALL_GRASS_ID = Identifier.of("minecraft", "blocks/tall_grass");

    private static final Identifier GRASS_BLOCK_ID = Identifier.of("minecraft", "blocks/grass_block");
    private static final Identifier DIRT_ID = Identifier.of("minecraft", "blocks/dirt");
    private static final Identifier COARSE_DIRT_ID = Identifier.of("minecraft", "blocks/coarse_dirt");

    private static final Identifier TORCH_ID = Identifier.of("minecraft", "blocks/torch");
    private static final Identifier REDSTONE_TORCH_ID = Identifier.of("minecraft", "blocks/redstone_torch");
    private static final Identifier SOUL_TORCH_ID = Identifier.of("minecraft", "blocks/soul_torch");
    private static final Identifier LANTERN_ID = Identifier.of("minecraft", "blocks/lantern");
    private static final Identifier SOUL_LANTERN_ID = Identifier.of("minecraft", "blocks/soul_lantern");

    private static final Identifier BLACK_CANDLE_ID = Identifier.of("minecraft", "block/black_candle");
    private static final Identifier BLUE_CANDLE_ID = Identifier.of("minecraft", "block/blue_candle");
    private static final Identifier BROWN_CANDLE_ID = Identifier.of("minecraft", "block/brown_candle");
    private static final Identifier CYAN_CANDLE_ID = Identifier.of("minecraft", "block/cyan_candle");
    private static final Identifier GRAY_CANDLE_ID = Identifier.of("minecraft", "block/gray_candle");
    private static final Identifier GREEN_CANDLE_ID = Identifier.of("minecraft", "block/green_candle");
    private static final Identifier LIGHT_BLUE_CANDLE_ID = Identifier.of("minecraft", "block/light_blue_candle");
    private static final Identifier LIGHT_GRAY_CANDLE_ID = Identifier.of("minecraft", "block/light_gray_candle");
    private static final Identifier LIME_CANDLE_ID = Identifier.of("minecraft", "block/lime_candle");
    private static final Identifier MAGENTA_CANDLE_ID = Identifier.of("minecraft", "block/magenta_candle");
    private static final Identifier ORANGE_CANDLE_ID = Identifier.of("minecraft", "block/orange_candle");
    private static final Identifier PINK_CANDLE_ID = Identifier.of("minecraft", "block/pink_candle");
    private static final Identifier PURPLE_CANDLE_ID = Identifier.of("minecraft", "block/purple_candle");
    private static final Identifier RED_CANDLE_ID = Identifier.of("minecraft", "block/red_candle");
    private static final Identifier WHITE_CANDLE_ID = Identifier.of("minecraft", "block/white_candle");
    private static final Identifier YELLOW_CANDLE_ID = Identifier.of("minecraft", "block/yellow_candle");

    private static final Identifier CHEST_ID = Identifier.of("minecraft", "block/chest");
    private static final Identifier BARREL_ID = Identifier.of("minecraft", "block/barrel");

    // Logs
    private static final Identifier OAK_LOG_ID = Identifier.of("minecraft", "block/oak_log");
    private static final Identifier SPRUCE_LOG_ID = Identifier.of("minecraft", "block/spruce_log");
    private static final Identifier BIRCH_LOG_ID = Identifier.of("minecraft", "block/birch_log");
    private static final Identifier JUNGLE_LOG_ID = Identifier.of("minecraft", "block/jungle_log");
    private static final Identifier ACACIA_LOG_ID = Identifier.of("minecraft", "block/acacia_log");
    private static final Identifier DARK_OAK_LOG_ID = Identifier.of("minecraft", "block/dark_oak_log");
    private static final Identifier MANGROVE_LOG_ID = Identifier.of("minecraft", "block/mangrove_log");
    private static final Identifier CHERRY_LOG_ID = Identifier.of("minecraft", "block/cherry_log");
    private static final Identifier PALE_OAK_LOG_ID = Identifier.of("minecraft", "block/pale_oak_log");
    private static final Identifier CRIMSON_STEM_ID = Identifier.of("minecraft", "block/crimson_stem");
    private static final Identifier WARPED_STEM_ID = Identifier.of("minecraft", "block/warped_stem");

    // Woods
    private static final Identifier OAK_WOOD_ID = Identifier.of("minecraft", "block/oak_wood");
    private static final Identifier SPRUCE_WOOD_ID = Identifier.of("minecraft", "block/spruce_wood");
    private static final Identifier BIRCH_WOOD_ID = Identifier.of("minecraft", "block/birch_wood");
    private static final Identifier JUNGLE_WOOD_ID = Identifier.of("minecraft", "block/jungle_wood");
    private static final Identifier ACACIA_WOOD_ID = Identifier.of("minecraft", "block/acacia_wood");
    private static final Identifier DARK_OAK_WOOD_ID = Identifier.of("minecraft", "block/dark_oak_wood");
    private static final Identifier MANGROVE_WOOD_ID = Identifier.of("minecraft", "block/mangrove_wood");
    private static final Identifier CHERRY_WOOD_ID = Identifier.of("minecraft", "block/cherry_wood");
    private static final Identifier PALE_OAK_WOOD_ID = Identifier.of("minecraft", "block/pale_oak_wood");
    private static final Identifier CRIMSON_HYPHAE_ID = Identifier.of("minecraft", "block/crimson_hyphae");
    private static final Identifier WARPED_HYPHAE_ID = Identifier.of("minecraft", "block/warped_hyphae");

    // Stripped Logs
    private static final Identifier STRIPPED_OAK_LOG_ID = Identifier.of("minecraft", "block/stripped_oak_log");
    private static final Identifier STRIPPED_SPRUCE_LOG_ID = Identifier.of("minecraft", "block/stripped_spruce_log");
    private static final Identifier STRIPPED_BIRCH_LOG_ID = Identifier.of("minecraft", "block/stripped_birch_log");
    private static final Identifier STRIPPED_JUNGLE_LOG_ID = Identifier.of("minecraft", "block/stripped_jungle_log");
    private static final Identifier STRIPPED_ACACIA_LOG_ID = Identifier.of("minecraft", "block/stripped_acacia_log");
    private static final Identifier STRIPPED_DARK_OAK_LOG_ID = Identifier.of("minecraft", "block/stripped_dark_oak_log");
    private static final Identifier STRIPPED_MANGROVE_LOG_ID = Identifier.of("minecraft", "block/stripped_mangrove_log");
    private static final Identifier STRIPPED_CHERRY_LOG_ID = Identifier.of("minecraft", "block/stripped_cherry_log");
    private static final Identifier STRIPPED_PALE_OAK_LOG_ID = Identifier.of("minecraft", "block/stripped_pale_oak_log");
    private static final Identifier STRIPPED_CRIMSON_STEM_ID = Identifier.of("minecraft", "block/stripped_crimson_stem");
    private static final Identifier STRIPPED_WARPED_STEM_ID = Identifier.of("minecraft", "block/stripped_warped_stem");

    // Stripped Woods
    private static final Identifier STRIPPED_OAK_WOOD_ID = Identifier.of("minecraft", "block/stripped_oak_wood");
    private static final Identifier STRIPPED_SPRUCE_WOOD_ID = Identifier.of("minecraft", "block/stripped_spruce_wood");
    private static final Identifier STRIPPED_BIRCH_WOOD_ID = Identifier.of("minecraft", "block/stripped_birch_wood");
    private static final Identifier STRIPPED_JUNGLE_WOOD_ID = Identifier.of("minecraft", "block/stripped_jungle_wood");
    private static final Identifier STRIPPED_ACACIA_WOOD_ID = Identifier.of("minecraft", "block/stripped_acacia_wood");
    private static final Identifier STRIPPED_DARK_OAK_WOOD_ID = Identifier.of("minecraft", "block/stripped_dark_oak_wood");
    private static final Identifier STRIPPED_MANGROVE_WOOD_ID = Identifier.of("minecraft", "block/stripped_mangrove_wood");
    private static final Identifier STRIPPED_CHERRY_WOOD_ID = Identifier.of("minecraft", "block/stripped_cherry_wood");
    private static final Identifier STRIPPED_PALE_OAK_WOOD_ID = Identifier.of("minecraft", "block/stripped_pale_oak_wood");
    private static final Identifier STRIPPED_CRIMSON_HYPHAE_ID = Identifier.of("minecraft", "block/stripped_crimson_hyphae");
    private static final Identifier STRIPPED_WARPED_HYPHAE_ID = Identifier.of("minecraft", "block/stripped_warped_hyphae");

    private static final Identifier STONE_ID = Identifier.of("minecraft", "block/stone");
    private static final Identifier DEEPSLATE_ID = Identifier.of("minecraft", "block/deepslate");

    static final Identifier[] logs = {
            // Oak
            OAK_LOG_ID,
            OAK_WOOD_ID,
            STRIPPED_OAK_LOG_ID,
            STRIPPED_OAK_WOOD_ID,

            // Spruce
            SPRUCE_LOG_ID,
            SPRUCE_WOOD_ID,
            STRIPPED_SPRUCE_LOG_ID,
            STRIPPED_SPRUCE_WOOD_ID,

            // Birch
            BIRCH_LOG_ID,
            BIRCH_WOOD_ID,
            STRIPPED_BIRCH_LOG_ID,
            STRIPPED_BIRCH_WOOD_ID,

            // Jungle
            JUNGLE_LOG_ID,
            JUNGLE_WOOD_ID,
            STRIPPED_JUNGLE_LOG_ID,
            STRIPPED_JUNGLE_WOOD_ID,

            // Acacia
            ACACIA_LOG_ID,
            ACACIA_WOOD_ID,
            STRIPPED_ACACIA_LOG_ID,
            STRIPPED_ACACIA_WOOD_ID,

            // Dark Oak
            DARK_OAK_LOG_ID,
            DARK_OAK_WOOD_ID,
            STRIPPED_DARK_OAK_LOG_ID,
            STRIPPED_DARK_OAK_WOOD_ID,

            // Mangrove
            MANGROVE_LOG_ID,
            MANGROVE_WOOD_ID,
            STRIPPED_MANGROVE_LOG_ID,
            STRIPPED_MANGROVE_WOOD_ID,

            // Cherry
            CHERRY_LOG_ID,
            CHERRY_WOOD_ID,
            STRIPPED_CHERRY_LOG_ID,
            STRIPPED_CHERRY_WOOD_ID,

            // Pale Oak
            PALE_OAK_LOG_ID,
            PALE_OAK_WOOD_ID,
            STRIPPED_PALE_OAK_LOG_ID,
            STRIPPED_PALE_OAK_WOOD_ID,

            // Crimson
            CRIMSON_STEM_ID,
            CRIMSON_HYPHAE_ID,
            STRIPPED_CRIMSON_STEM_ID,
            STRIPPED_CRIMSON_HYPHAE_ID,

            // Warped
            WARPED_STEM_ID,
            WARPED_HYPHAE_ID,
            STRIPPED_WARPED_STEM_ID,
            STRIPPED_WARPED_HYPHAE_ID
    };

    static Identifier[] candles = {
            BLACK_CANDLE_ID,
            BLUE_CANDLE_ID,
            BROWN_CANDLE_ID,
            CYAN_CANDLE_ID,
            GRAY_CANDLE_ID,
            GREEN_CANDLE_ID,
            LIGHT_BLUE_CANDLE_ID,
            LIGHT_GRAY_CANDLE_ID,
            LIME_CANDLE_ID,
            MAGENTA_CANDLE_ID,
            ORANGE_CANDLE_ID,
            PINK_CANDLE_ID,
            PURPLE_CANDLE_ID,
            RED_CANDLE_ID,
            WHITE_CANDLE_ID,
            YELLOW_CANDLE_ID
    };
    public static void modifyLootTables() {

        LootTableEvents.REPLACE.register((registryKey, lootTable, lootTableSource, wrapperLookup) -> {
            if (STONE_ID.equals(registryKey.getValue()) || DEEPSLATE_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(SurvivesExplosionLootCondition.builder().build())
                        .with(ItemEntry.builder(SnailItems.ROCK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0f, 3f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }

            for (Identifier id : logs){
                if (id.equals(registryKey.getValue())){
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1f))
                            .conditionally(SurvivesExplosionLootCondition.builder().build())
                            .with(ItemEntry.builder(Items.STICK))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0f, 5f)).build());

                    LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                    return tableBuilder.build();
                }
            }

            if (GRASS_BLOCK_ID.equals(registryKey.getValue()) || DIRT_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(SnailBlocks.UNSTEADY_DIRT.asItem()))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }

            if (CHEST_ID.equals(registryKey.getValue()) || BARREL_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(Items.STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 8.0f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }
            for (Identifier id : candles){
                if (id.equals(registryKey.getValue())){
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1f))
                            .conditionally(RandomChanceLootCondition.builder(1f))
                            .with(ItemEntry.builder(Items.STRING))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                    LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                    return tableBuilder.build();
                }
            }

            if (GRASS_BLOCK_ID.equals(registryKey.getValue()) || DIRT_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(SnailBlocks.UNSTEADY_DIRT.asItem()))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }
            if (COARSE_DIRT_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(SnailBlocks.UNSTEADY_COARSE_DIRT.asItem()))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }

            if (TORCH_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.STICK))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }
            if (REDSTONE_TORCH_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.STICK))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }
            if (SOUL_TORCH_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(SnailItems.SOUL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }
            if (LANTERN_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.STICK))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }
            if (SOUL_LANTERN_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(SnailItems.SOUL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }
            return lootTable;
        });

        LootTableEvents.MODIFY.register((registryKey, builder, lootTableSource, wrapperLookup) -> {
            RegistryEntryLookup<Item> itemRegistry = wrapperLookup.getOrThrow(RegistryKeys.ITEM);

            if (SHORT_GRASS_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(itemRegistry, SnailItems.FLINT_FLAKE)))
                        .with(ItemEntry.builder(SnailBlocks.GRASS_SHEAF.asItem()))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                builder.pool(poolBuilder.build());
            }
            if (TALL_GRASS_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(0.85f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(itemRegistry, SnailItems.FLINT_FLAKE)))
                        .with(ItemEntry.builder(SnailBlocks.GRASS_SHEAF.asItem()))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)).build());

                builder.pool(poolBuilder.build());
            }

            if(CREEPER_ID.equals(registryKey.getValue()) ||
                ZOMBIE_ID.equals(registryKey.getValue()) ||
                HUSK_ID.equals(registryKey.getValue()) ||
                DROWNED_ID.equals(registryKey.getValue()) ||
                SKELETON_ID.equals(registryKey.getValue()) ||
                BOGGED_ID.equals(registryKey.getValue()) ||
                STRAY_ID.equals(registryKey.getValue()) ||
                SPIDER_ID.equals(registryKey.getValue()) ||
                CAVE_SPIDER_ID.equals(registryKey.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f)) // Drops 75% of the time
                        .with(ItemEntry.builder(SnailItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                builder.pool(poolBuilder.build());
            }
        });
    }
}
