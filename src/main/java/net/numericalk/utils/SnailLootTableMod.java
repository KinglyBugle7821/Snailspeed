package net.numericalk.utils;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.numericalk.blocks.SnailBlocks;
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


    private static final Identifier SHORT_GRASS_ID = Identifier.of("minecraft", "blocks/short_grass");
    private static final Identifier TALL_GRASS_ID = Identifier.of("minecraft", "blocks/tall_grass");

    public static void modifyLootTables() {

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
        });
    }
}
