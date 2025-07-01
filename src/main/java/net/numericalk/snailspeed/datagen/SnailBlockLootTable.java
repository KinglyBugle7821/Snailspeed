package net.numericalk.snailspeed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;

import java.util.concurrent.CompletableFuture;

public class SnailBlockLootTable extends FabricBlockLootTableProvider {
    public SnailBlockLootTable(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        Block[] trimmedLogs = {
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
        Block[] crackedLogs = {
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
        Block[] damagedLogs = {
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
        Block[] damagedPlanks = {
                SnailBlocks.DAMAGED_OAK_PLANKS,
                SnailBlocks.DAMAGED_SPRUCE_PLANKS,
                SnailBlocks.DAMAGED_BIRCH_PLANKS,
                SnailBlocks.DAMAGED_JUNGLE_PLANKS,
                SnailBlocks.DAMAGED_ACACIA_PLANKS,
                SnailBlocks.DAMAGED_DARK_OAK_PLANKS,
                SnailBlocks.DAMAGED_MANGROVE_PLANKS,
                SnailBlocks.DAMAGED_CHERRY_PLANKS,
                SnailBlocks.DAMAGED_PALE_OAK_PLANKS,
                SnailBlocks.DAMAGED_BAMBOO_PLANKS,
                SnailBlocks.DAMAGED_CRIMSON_PLANKS,
                SnailBlocks.DAMAGED_WARPED_PLANKS
        };

        Block[] logs = {
                // Oak
                Blocks.OAK_LOG,
                Blocks.OAK_WOOD,
                Blocks.STRIPPED_OAK_LOG,
                Blocks.STRIPPED_OAK_WOOD,

                // Spruce
                Blocks.SPRUCE_LOG,
                Blocks.SPRUCE_WOOD,
                Blocks.STRIPPED_SPRUCE_LOG,
                Blocks.STRIPPED_SPRUCE_WOOD,

                // Birch
                Blocks.BIRCH_LOG,
                Blocks.BIRCH_WOOD,
                Blocks.STRIPPED_BIRCH_LOG,
                Blocks.STRIPPED_BIRCH_WOOD,

                // Jungle
                Blocks.JUNGLE_LOG,
                Blocks.JUNGLE_WOOD,
                Blocks.STRIPPED_JUNGLE_LOG,
                Blocks.STRIPPED_JUNGLE_WOOD,

                // Acacia
                Blocks.ACACIA_LOG,
                Blocks.ACACIA_WOOD,
                Blocks.STRIPPED_ACACIA_LOG,
                Blocks.STRIPPED_ACACIA_WOOD,

                // Dark Oak
                Blocks.DARK_OAK_LOG,
                Blocks.DARK_OAK_WOOD,
                Blocks.STRIPPED_DARK_OAK_LOG,
                Blocks.STRIPPED_DARK_OAK_WOOD,

                // Mangrove
                Blocks.MANGROVE_LOG,
                Blocks.MANGROVE_WOOD,
                Blocks.STRIPPED_MANGROVE_LOG,
                Blocks.STRIPPED_MANGROVE_WOOD,

                // Cherry
                Blocks.CHERRY_LOG,
                Blocks.CHERRY_WOOD,
                Blocks.STRIPPED_CHERRY_LOG,
                Blocks.STRIPPED_CHERRY_WOOD,

                // Pale Oak
                Blocks.PALE_OAK_LOG,
                Blocks.PALE_OAK_WOOD,
                Blocks.STRIPPED_PALE_OAK_LOG,
                Blocks.STRIPPED_PALE_OAK_WOOD,

                // Crimson
                Blocks.CRIMSON_STEM,
                Blocks.CRIMSON_HYPHAE,
                Blocks.STRIPPED_CRIMSON_STEM,
                Blocks.STRIPPED_CRIMSON_HYPHAE,

                // Warped
                Blocks.WARPED_STEM,
                Blocks.WARPED_HYPHAE,
                Blocks.STRIPPED_WARPED_STEM,
                Blocks.STRIPPED_WARPED_HYPHAE
        };



        for (Block trimmedLog : trimmedLogs) {

            addDrop(trimmedLog, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(1)))
                    .with(ItemEntry.builder(SnailItems.WOOD_DUST))))
            );
        }
        for (Block crackedLog : crackedLogs) {

            addDrop(crackedLog, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(1)))
                    .with(ItemEntry.builder(SnailItems.WOOD_DUST))))
            );
        }
        for (Block damagedLog : damagedLogs) {

            addDrop(damagedLog, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(3)))
                    .with(ItemEntry.builder(Items.STICK))))
            );
        }
        for (Block damagedPlank : damagedPlanks) {

            addDrop(damagedPlank, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(2), new ConstantLootNumberProvider(2)))
                    .with(ItemEntry.builder(SnailItems.WOOD_DUST))))
            );
        }
        addDrop(SnailBlocks.CAMPFIRE_BASE);
        addDrop(SnailBlocks.BRICK_OVEN_BASE);
        addDrop(SnailBlocks.BRICK_FURNACE_BASE);
        addDrop(SnailBlocks.FILTERING_TRAY_BASE);
        addDrop(SnailBlocks.BRICK_OVEN, bundledBlockDrop(SnailBlocks.BRICK_OVEN_BASE, Items.BRICK, 4));
        addDrop(SnailBlocks.BRICK_FURNACE, bundledBlockDrop(SnailBlocks.BRICK_FURNACE_BASE, Items.BRICK, 2));

        addDrop(SnailBlocks.GRASS_SHEAF);
        addDrop(SnailBlocks.DRIED_GRASS_SHEAF);
        addDrop(SnailBlocks.CLAY_BRICK);
        addDrop(SnailBlocks.DRIED_CLAY_BRICK);

        addDrop(SnailBlocks.FIRED_BRICK, bundledBlockDrop(SnailBlocks.FIRED_BRICK, Items.BRICK, 1));

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

        addDrop(SnailBlocks.MORTAR);

        addDrop(SnailBlocks.UNSTEADY_DIRT);
        addDrop(SnailBlocks.UNSTEADY_ROOTED_DIRT);
        addDrop(SnailBlocks.UNSTEADY_COARSE_DIRT);

        addDrop(SnailBlocks.CLAY_CRUCIBLE);
        addDrop(SnailBlocks.DRIED_CLAY_CRUCIBLE);
        addDrop(SnailBlocks.CRUCIBLE);

        addDrop(SnailBlocks.CLAY_MOLD);
        addDrop(SnailBlocks.DRIED_CLAY_BRICK);

        addDrop(SnailBlocks.RESIN_BOWL);
        addDrop(SnailBlocks.FILTERING_TRAY);

        addDrop(SnailBlocks.TIN_ORE, multipleOreDrops(SnailBlocks.TIN_ORE, SnailItems.RAW_TIN, 1f, 2f));
        addDrop(SnailBlocks.DEEPSLATE_TIN_ORE, multipleOreDrops(SnailBlocks.DEEPSLATE_TIN_ORE, SnailItems.RAW_TIN, 1f, 2f));

        addDrop(SnailBlocks.GRAPHITE_ORE, multipleOreDrops(SnailBlocks.GRAPHITE_ORE, SnailItems.RAW_GRAPHITE, 1f, 1f));
        addDrop(SnailBlocks.DEEPSLATE_GRAPHITE_ORE, multipleOreDrops(SnailBlocks.DEEPSLATE_GRAPHITE_ORE, SnailItems.RAW_GRAPHITE, 1f, 1f));

        addDrop(SnailBlocks.ARMOR_FORGE);
        addDrop(SnailBlocks.SMALL_BARREL);
        addDrop(SnailBlocks.SAW_TABLE);
    }

    public LootTable.Builder bundledBlockDrop(Block drop, Item drop2, float count) {
        return this.dropsWithSilkTouch(drop,
                this.applyExplosionDecay(drop, ItemEntry.builder(drop2)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ItemEntry.builder(item)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
