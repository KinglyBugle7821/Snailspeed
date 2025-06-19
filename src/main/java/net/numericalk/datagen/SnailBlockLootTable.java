package net.numericalk.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItems;

import java.util.concurrent.CompletableFuture;

public class SnailBlockLootTable extends FabricBlockLootTableProvider {
    public SnailBlockLootTable(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        Object[] trimmedLogs = {
                SnailBlocks.TRIMMED_OAK_LOG,
                SnailBlocks.TRIMMED_SPRUCE_LOG,
                SnailBlocks.TRIMMED_BIRCH_LOG,
                SnailBlocks.TRIMMED_JUNGLE_LOG,
                SnailBlocks.TRIMMED_ACACIA_LOG,
                SnailBlocks.TRIMMED_DARK_OAK_LOG,
                SnailBlocks.TRIMMED_MANGROVE_LOG,
                SnailBlocks.TRIMMED_CHERRY_LOG,
                SnailBlocks.TRIMMED_PALE_OAK_LOG,
                SnailBlocks.TRIMMED_CRIMSON_STEM,
                SnailBlocks.TRIMMED_WARPED_STEM
        };
        Object[] crackedLogs = {
                SnailBlocks.CRACKED_OAK_LOG,
                SnailBlocks.CRACKED_SPRUCE_LOG,
                SnailBlocks.CRACKED_BIRCH_LOG,
                SnailBlocks.CRACKED_JUNGLE_LOG,
                SnailBlocks.CRACKED_ACACIA_LOG,
                SnailBlocks.CRACKED_DARK_OAK_LOG,
                SnailBlocks.CRACKED_MANGROVE_LOG,
                SnailBlocks.CRACKED_CHERRY_LOG,
                SnailBlocks.CRACKED_PALE_OAK_LOG,
                SnailBlocks.CRACKED_CRIMSON_STEM,
                SnailBlocks.CRACKED_WARPED_STEM
        };
        Object[] damagedLogs = {
                SnailBlocks.DAMAGED_OAK_LOG,
                SnailBlocks.DAMAGED_SPRUCE_LOG,
                SnailBlocks.DAMAGED_BIRCH_LOG,
                SnailBlocks.DAMAGED_JUNGLE_LOG,
                SnailBlocks.DAMAGED_ACACIA_LOG,
                SnailBlocks.DAMAGED_DARK_OAK_LOG,
                SnailBlocks.DAMAGED_MANGROVE_LOG,
                SnailBlocks.DAMAGED_CHERRY_LOG,
                SnailBlocks.DAMAGED_PALE_OAK_LOG,
                SnailBlocks.DAMAGED_CRIMSON_STEM,
                SnailBlocks.DAMAGED_WARPED_STEM
        };
        for (Object entry : trimmedLogs) {
            Block trimmed = (Block) entry;

            addDrop(trimmed, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(1)))
                    .with(ItemEntry.builder(SnailItems.WOOD_DUST))))
            );
        }
        for (Object entry : crackedLogs) {
            Block cracked = (Block) entry;

            addDrop(cracked, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(1)))
                    .with(ItemEntry.builder(SnailItems.WOOD_DUST))))
            );
        }
        for (Object entry : damagedLogs) {
            Block damaged = (Block) entry;

            addDrop(damaged, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(3)))
                    .with(ItemEntry.builder(Items.STICK))))
            );
        }
        addDrop(SnailBlocks.CAMPFIRE_BASE);
        addDrop(SnailBlocks.BRICK_OVEN, bundledBlockDrop(SnailBlocks.BRICK_OVEN, Items.BRICK, 4));

        addDrop(SnailBlocks.GRASS_SHEAF);
        addDrop(SnailBlocks.DRIED_GRASS_SHEAF);
        addDrop(SnailBlocks.CLAY_BRICK);
        addDrop(SnailBlocks.DRIED_CLAY_BRICK);

        addDrop(SnailBlocks.FIRED_BRICK, bundledBlockDrop(SnailBlocks.FIRED_BRICK, Items.BRICK, 1));

        addDropWithSilkTouch(SnailBlocks.SCRATCHED_STONE, Blocks.COBBLESTONE);
        addDropWithSilkTouch(SnailBlocks.CRACKED_STONE, Blocks.COBBLESTONE);
        addDrop(SnailBlocks.FRACTURED_STONE, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.PEBBLE, LootPool.builder()
                .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(2), new ConstantLootNumberProvider(4)))
                .with(ItemEntry.builder(SnailItems.PEBBLE))))
        );
        addDrop(SnailBlocks.CRUMBLED_STONE, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.STONE_DUST, LootPool.builder()
                        .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(3)))
                        .with(ItemEntry.builder(SnailItems.PEBBLE))))
        );

        addDropWithSilkTouch(SnailBlocks.SCRATCHED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
        addDropWithSilkTouch(SnailBlocks.CRACKED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
        addDrop(SnailBlocks.FRACTURED_DEEPSLATE, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.PEBBLE, LootPool.builder()
                .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(2), new ConstantLootNumberProvider(4)))
                .with(ItemEntry.builder(SnailItems.PEBBLE))))
        );
        addDrop(SnailBlocks.CRUMBLED_DEEPSLATE, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.STONE_DUST, LootPool.builder()
                .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(3)))
                .with(ItemEntry.builder(SnailItems.PEBBLE))))
        );

        addDrop(Blocks.GRANITE, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.STONE_DUST, LootPool.builder()
                .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(3)))
                .with(ItemEntry.builder(SnailItems.STONE_DUST))))
        );
        addDrop(Blocks.DIORITE, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.STONE_DUST, LootPool.builder()
                .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(3)))
                .with(ItemEntry.builder(SnailItems.STONE_DUST))))
        );
        addDrop(Blocks.ANDESITE, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.STONE_DUST, LootPool.builder()
                .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(3)))
                .with(ItemEntry.builder(SnailItems.STONE_DUST))))
        );

        addDrop(SnailBlocks.UNTIED_STICK_BUNDLE, bundledBlockDrop(SnailBlocks.UNTIED_STICK_BUNDLE, Items.STICK, 4));
        addDrop(SnailBlocks.STICK_BUNDLE);
        addDrop(SnailBlocks.UNTIED_THATCH_BLOCK, bundledBlockDrop(SnailBlocks.UNTIED_THATCH_BLOCK, SnailBlocks.DRIED_GRASS_SHEAF.asItem(), 4));
        addDrop(SnailBlocks.THATCH_BLOCK);

        addDrop(SnailBlocks.UNSTEADY_DIRT);
        addDrop(SnailBlocks.UNSTEADY_COARSE_DIRT);
    }
    public LootTable.Builder bundledBlockDrop(Block drop, Item drop2, float count) {
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ItemEntry.builder(drop2).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))));
    }
}
