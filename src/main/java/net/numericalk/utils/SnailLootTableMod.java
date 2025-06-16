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
