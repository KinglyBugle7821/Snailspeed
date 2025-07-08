package net.numericalk.snailspeed.utils;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.*;
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
    private static final Identifier FARMLAND_ID = Identifier.of("minecraft", "blocks/farmland");
    private static final Identifier PODZOL_ID = Identifier.of("minecraft", "blocks/podzol_id");
    private static final Identifier ROOTED_DIRT_ID = Identifier.of("minecraft", "blocks/farmland");
    private static final Identifier MOSS_BLOCK_ID = Identifier.of("minecraft", "blocks/moss_block");
    private static final Identifier PALE_MOSS_BLOCK_ID = Identifier.of("minecraft", "blocks/pale_moss_block");

    private static final Identifier TORCH_ID = Identifier.of("minecraft", "blocks/torch");
    private static final Identifier SOUL_TORCH_ID = Identifier.of("minecraft", "blocks/soul_torch");
    private static final Identifier LANTERN_ID = Identifier.of("minecraft", "blocks/lantern");
    private static final Identifier SOUL_LANTERN_ID = Identifier.of("minecraft", "blocks/soul_lantern");

    private static final Identifier OBSIDIAN_ID = Identifier.of("minecraft", "blocks/obsidian");

    private static final Identifier BLACK_CANDLE_ID = Identifier.of("minecraft", "blocks/black_candle");
    private static final Identifier BLUE_CANDLE_ID = Identifier.of("minecraft", "blocks/blue_candle");
    private static final Identifier BROWN_CANDLE_ID = Identifier.of("minecraft", "blocks/brown_candle");
    private static final Identifier CYAN_CANDLE_ID = Identifier.of("minecraft", "blocks/cyan_candle");
    private static final Identifier GRAY_CANDLE_ID = Identifier.of("minecraft", "blocks/gray_candle");
    private static final Identifier GREEN_CANDLE_ID = Identifier.of("minecraft", "blocks/green_candle");
    private static final Identifier LIGHT_BLUE_CANDLE_ID = Identifier.of("minecraft", "blocks/light_blue_candle");
    private static final Identifier LIGHT_GRAY_CANDLE_ID = Identifier.of("minecraft", "blocks/light_gray_candle");
    private static final Identifier LIME_CANDLE_ID = Identifier.of("minecraft", "blocks/lime_candle");
    private static final Identifier MAGENTA_CANDLE_ID = Identifier.of("minecraft", "blocks/magenta_candle");
    private static final Identifier ORANGE_CANDLE_ID = Identifier.of("minecraft", "blocks/orange_candle");
    private static final Identifier PINK_CANDLE_ID = Identifier.of("minecraft", "blocks/pink_candle");
    private static final Identifier PURPLE_CANDLE_ID = Identifier.of("minecraft", "blocks/purple_candle");
    private static final Identifier RED_CANDLE_ID = Identifier.of("minecraft", "blocks/red_candle");
    private static final Identifier WHITE_CANDLE_ID = Identifier.of("minecraft", "blocks/white_candle");
    private static final Identifier YELLOW_CANDLE_ID = Identifier.of("minecraft", "blocks/yellow_candle");

    private static final Identifier BLACK_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/black_candle_cake");
    private static final Identifier BLUE_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/blue_candle_cake");
    private static final Identifier BROWN_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/brown_candle_cake");
    private static final Identifier CYAN_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/cyan_candle_cake");
    private static final Identifier GRAY_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/gray_candle_cake");
    private static final Identifier GREEN_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/green_candle_cake");
    private static final Identifier LIGHT_BLUE_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/light_blue_candle_cake");
    private static final Identifier LIGHT_GRAY_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/light_gray_candle_cake");
    private static final Identifier LIME_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/lime_candle_cake");
    private static final Identifier MAGENTA_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/magenta_candle_cake");
    private static final Identifier ORANGE_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/orange_candle_cake");
    private static final Identifier PINK_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/pink_candle_cake");
    private static final Identifier PURPLE_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/purple_candle_cake");
    private static final Identifier RED_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/red_candle_cake");
    private static final Identifier WHITE_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/white_candle_cake");
    private static final Identifier YELLOW_CANDLE_CAKE_ID = Identifier.of("minecraft", "blocks/yellow_candle_cake");


    private static final Identifier CHEST_ID = Identifier.of("minecraft", "blocks/chest");
    private static final Identifier BARREL_ID = Identifier.of("minecraft", "blocks/barrel");

    static final Identifier[] candles = {
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
            YELLOW_CANDLE_ID,

            BLACK_CANDLE_CAKE_ID,
            BLUE_CANDLE_CAKE_ID,
            BROWN_CANDLE_CAKE_ID,
            CYAN_CANDLE_CAKE_ID,
            GRAY_CANDLE_CAKE_ID,
            GREEN_CANDLE_CAKE_ID,
            LIGHT_BLUE_CANDLE_CAKE_ID,
            LIGHT_GRAY_CANDLE_CAKE_ID,
            LIME_CANDLE_CAKE_ID,
            MAGENTA_CANDLE_CAKE_ID,
            ORANGE_CANDLE_CAKE_ID,
            PINK_CANDLE_CAKE_ID,
            PURPLE_CANDLE_CAKE_ID,
            RED_CANDLE_CAKE_ID,
            WHITE_CANDLE_CAKE_ID,
            YELLOW_CANDLE_CAKE_ID
    };
    private static final Block[] JS_DROP_ROCK_BRO = {
            Blocks.SMOOTH_STONE,
            Blocks.STONE_SLAB,
            Blocks.SMOOTH_STONE_SLAB,
            Blocks.STONE_STAIRS,
            Blocks.STONE_BRICKS,
            Blocks.CRACKED_STONE_BRICKS,
            Blocks.CHISELED_STONE_BRICKS,
            Blocks.STONE_BRICK_SLAB,
            Blocks.STONE_BRICK_STAIRS,
            Blocks.STONE_BRICK_WALL,

            Blocks.COBBLESTONE_SLAB,
            Blocks.COBBLESTONE_STAIRS,
            Blocks.COBBLESTONE_WALL,
            Blocks.MOSSY_COBBLESTONE,
            Blocks.MOSSY_COBBLESTONE_SLAB,
            Blocks.MOSSY_COBBLESTONE_STAIRS,
            Blocks.MOSSY_COBBLESTONE_WALL,

            Blocks.ANDESITE,
            Blocks.POLISHED_ANDESITE,
            Blocks.ANDESITE_SLAB,
            Blocks.POLISHED_ANDESITE_SLAB,
            Blocks.ANDESITE_STAIRS,
            Blocks.POLISHED_ANDESITE_STAIRS,
            Blocks.ANDESITE_WALL,

            Blocks.GRANITE,
            Blocks.POLISHED_GRANITE,
            Blocks.GRANITE_SLAB,
            Blocks.POLISHED_GRANITE_SLAB,
            Blocks.GRANITE_STAIRS,
            Blocks.POLISHED_GRANITE_STAIRS,
            Blocks.GRANITE_WALL,

            Blocks.DIORITE,
            Blocks.POLISHED_DIORITE,
            Blocks.DIORITE_SLAB,
            Blocks.POLISHED_DIORITE_SLAB,
            Blocks.DIORITE_STAIRS,
            Blocks.POLISHED_DIORITE_STAIRS,
            Blocks.DIORITE_WALL,

            Blocks.TUFF,
            Blocks.POLISHED_TUFF,
            Blocks.TUFF_SLAB,
            Blocks.POLISHED_TUFF_SLAB,
            Blocks.TUFF_STAIRS,
            Blocks.POLISHED_TUFF_STAIRS,
            Blocks.TUFF_WALL,
            Blocks.TUFF_BRICKS,
            Blocks.TUFF_BRICK_SLAB,
            Blocks.TUFF_BRICK_STAIRS,
            Blocks.TUFF_BRICK_WALL,
            Blocks.CHISELED_TUFF,
            Blocks.CHISELED_TUFF_BRICKS,

            Blocks.POLISHED_DEEPSLATE,
            Blocks.DEEPSLATE_BRICKS,
            Blocks.DEEPSLATE_TILES,
            Blocks.CRACKED_DEEPSLATE_BRICKS,
            Blocks.CRACKED_DEEPSLATE_TILES,
            Blocks.CHISELED_DEEPSLATE,
            Blocks.COBBLED_DEEPSLATE_SLAB,
            Blocks.POLISHED_DEEPSLATE_SLAB,
            Blocks.DEEPSLATE_BRICK_SLAB,
            Blocks.DEEPSLATE_TILE_SLAB,
            Blocks.COBBLED_DEEPSLATE_STAIRS,
            Blocks.POLISHED_DEEPSLATE_STAIRS,
            Blocks.DEEPSLATE_BRICK_STAIRS,
            Blocks.DEEPSLATE_TILE_STAIRS,
            Blocks.COBBLED_DEEPSLATE_WALL,
            Blocks.POLISHED_DEEPSLATE_WALL,
            Blocks.DEEPSLATE_BRICK_WALL,
            Blocks.DEEPSLATE_TILE_WALL,

            Blocks.SANDSTONE,
            Blocks.CHISELED_SANDSTONE,
            Blocks.SMOOTH_SANDSTONE,
            Blocks.SANDSTONE_SLAB,
            Blocks.SMOOTH_SANDSTONE_SLAB,
            Blocks.SANDSTONE_STAIRS,
            Blocks.SMOOTH_SANDSTONE_STAIRS,
            Blocks.SANDSTONE_WALL,
            Blocks.RED_SANDSTONE,
            Blocks.CHISELED_RED_SANDSTONE,
            Blocks.SMOOTH_RED_SANDSTONE,
            Blocks.RED_SANDSTONE_SLAB,
            Blocks.SMOOTH_RED_SANDSTONE_SLAB,
            Blocks.RED_SANDSTONE_STAIRS,
            Blocks.SMOOTH_RED_SANDSTONE_STAIRS,
            Blocks.RED_SANDSTONE_WALL
    };
    public static void modifyLootTables() {
        LootTableEvents.REPLACE.register((registryKey, lootTable, lootTableSource, wrapperLookup) -> {
            for (Identifier id : candles) {
                if (id.equals(registryKey.getValue())) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1f))
                            .conditionally(RandomChanceLootCondition.builder(1f))
                            .with(ItemEntry.builder(Items.STRING))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                    LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                    return tableBuilder.build();
                }
            }
            if (TORCH_ID.equals(registryKey.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.STICK))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }
            if (SOUL_TORCH_ID.equals(registryKey.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(SnailItems.SOUL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }
            if (LANTERN_ID.equals(registryKey.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.STICK))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                LootTable.Builder tableBuilder = LootTable.builder().pool(poolBuilder);
                return tableBuilder.build();
            }
            if (SOUL_LANTERN_ID.equals(registryKey.getValue())) {
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

            if (SHORT_GRASS_ID.equals(registryKey.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(itemRegistry, SnailItems.FLINT_FLAKE)))
                        .with(ItemEntry.builder(SnailBlocks.GRASS_SHEAF.asItem()))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());

                builder.pool(poolBuilder.build());
            }
            if (TALL_GRASS_ID.equals(registryKey.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(0.9f))
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
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(SnailItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                builder.pool(poolBuilder.build());
            }
        });
    }
}
