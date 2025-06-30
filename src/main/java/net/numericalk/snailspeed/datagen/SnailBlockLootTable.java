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
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.numericalk.snailspeed.blocks.SnailBlocksBrain;
import net.numericalk.snailspeed.items.SnailItems;

import java.util.concurrent.CompletableFuture;

public class SnailBlockLootTable extends FabricBlockLootTableProvider {
    public SnailBlockLootTable(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        Object[] trimmedLogs = {
                SnailBlocksBrain.TRIMMED_OAK_LOG,
                SnailBlocksBrain.TRIMMED_SPRUCE_LOG,
                SnailBlocksBrain.TRIMMED_BIRCH_LOG,
                SnailBlocksBrain.TRIMMED_JUNGLE_LOG,
                SnailBlocksBrain.TRIMMED_ACACIA_LOG,
                SnailBlocksBrain.TRIMMED_DARK_OAK_LOG,
                SnailBlocksBrain.TRIMMED_MANGROVE_LOG,
                SnailBlocksBrain.TRIMMED_CHERRY_LOG,
                SnailBlocksBrain.TRIMMED_PALE_OAK_LOG,
                SnailBlocksBrain.TRIMMED_CRIMSON_STEM,
                SnailBlocksBrain.TRIMMED_WARPED_STEM
        };
        Object[] crackedLogs = {
                SnailBlocksBrain.CRACKED_OAK_LOG,
                SnailBlocksBrain.CRACKED_SPRUCE_LOG,
                SnailBlocksBrain.CRACKED_BIRCH_LOG,
                SnailBlocksBrain.CRACKED_JUNGLE_LOG,
                SnailBlocksBrain.CRACKED_ACACIA_LOG,
                SnailBlocksBrain.CRACKED_DARK_OAK_LOG,
                SnailBlocksBrain.CRACKED_MANGROVE_LOG,
                SnailBlocksBrain.CRACKED_CHERRY_LOG,
                SnailBlocksBrain.CRACKED_PALE_OAK_LOG,
                SnailBlocksBrain.CRACKED_CRIMSON_STEM,
                SnailBlocksBrain.CRACKED_WARPED_STEM
        };
        Object[] damagedLogs = {
                SnailBlocksBrain.DAMAGED_OAK_LOG,
                SnailBlocksBrain.DAMAGED_SPRUCE_LOG,
                SnailBlocksBrain.DAMAGED_BIRCH_LOG,
                SnailBlocksBrain.DAMAGED_JUNGLE_LOG,
                SnailBlocksBrain.DAMAGED_ACACIA_LOG,
                SnailBlocksBrain.DAMAGED_DARK_OAK_LOG,
                SnailBlocksBrain.DAMAGED_MANGROVE_LOG,
                SnailBlocksBrain.DAMAGED_CHERRY_LOG,
                SnailBlocksBrain.DAMAGED_PALE_OAK_LOG,
                SnailBlocksBrain.DAMAGED_CRIMSON_STEM,
                SnailBlocksBrain.DAMAGED_WARPED_STEM
        };
        Object[] damagedPlanks = {
                SnailBlocksBrain.DAMAGED_OAK_PLANKS,
                SnailBlocksBrain.DAMAGED_SPRUCE_PLANKS,
                SnailBlocksBrain.DAMAGED_BIRCH_PLANKS,
                SnailBlocksBrain.DAMAGED_JUNGLE_PLANKS,
                SnailBlocksBrain.DAMAGED_ACACIA_PLANKS,
                SnailBlocksBrain.DAMAGED_DARK_OAK_PLANKS,
                SnailBlocksBrain.DAMAGED_MANGROVE_PLANKS,
                SnailBlocksBrain.DAMAGED_CHERRY_PLANKS,
                SnailBlocksBrain.DAMAGED_PALE_OAK_PLANKS,
                SnailBlocksBrain.DAMAGED_BAMBOO_PLANKS,
                SnailBlocksBrain.DAMAGED_CRIMSON_PLANKS,
                SnailBlocksBrain.DAMAGED_WARPED_PLANKS
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
        for (Object entry : damagedPlanks) {
            Block damaged = (Block) entry;

            addDrop(damaged, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(2), new ConstantLootNumberProvider(2)))
                    .with(ItemEntry.builder(SnailItems.WOOD_DUST))))
            );
        }
        addDrop(SnailBlocksBrain.CAMPFIRE_BASE);
        addDrop(SnailBlocksBrain.BRICK_OVEN_BASE);
        addDrop(SnailBlocksBrain.BRICK_FURNACE_BASE);
        addDrop(SnailBlocksBrain.FILTERING_TRAY_BASE);
        addDrop(SnailBlocksBrain.BRICK_OVEN, bundledBlockDrop(SnailBlocksBrain.BRICK_OVEN_BASE, Items.BRICK, 4));
        addDrop(SnailBlocksBrain.BRICK_FURNACE, bundledBlockDrop(SnailBlocksBrain.BRICK_FURNACE_BASE, Items.BRICK, 2));

        addDrop(SnailBlocksBrain.GRASS_SHEAF);
        addDrop(SnailBlocksBrain.DRIED_GRASS_SHEAF);
        addDrop(SnailBlocksBrain.CLAY_BRICK);
        addDrop(SnailBlocksBrain.DRIED_CLAY_BRICK);

        addDrop(SnailBlocksBrain.FIRED_BRICK, bundledBlockDrop(SnailBlocksBrain.FIRED_BRICK, Items.BRICK, 1));

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

        addDrop(SnailBlocksBrain.UNTIED_STICK_BUNDLE, bundledBlockDrop(SnailBlocksBrain.UNTIED_STICK_BUNDLE, Items.STICK, 4));
        addDrop(SnailBlocksBrain.STICK_BUNDLE);
        addDrop(SnailBlocksBrain.UNTIED_THATCH_BLOCK, bundledBlockDrop(SnailBlocksBrain.UNTIED_THATCH_BLOCK, SnailBlocksBrain.DRIED_GRASS_SHEAF.asItem(), 4));
        addDrop(SnailBlocksBrain.THATCH_BLOCK);

        addDrop(SnailBlocksBrain.MORTAR);

        addDrop(SnailBlocksBrain.UNSTEADY_DIRT);
        addDrop(SnailBlocksBrain.UNSTEADY_ROOTED_DIRT);
        addDrop(SnailBlocksBrain.UNSTEADY_COARSE_DIRT);

        addDrop(SnailBlocksBrain.CLAY_CRUCIBLE);
        addDrop(SnailBlocksBrain.DRIED_CLAY_CRUCIBLE);
        addDrop(SnailBlocksBrain.CRUCIBLE);

        addDrop(SnailBlocksBrain.CLAY_MOLD);
        addDrop(SnailBlocksBrain.DRIED_CLAY_BRICK);

        addDrop(SnailBlocksBrain.RESIN_BOWL);
        addDrop(SnailBlocksBrain.FILTERING_TRAY);

        addDrop(SnailBlocksBrain.TIN_ORE, multipleOreDrops(SnailBlocksBrain.TIN_ORE, SnailItems.RAW_TIN, 1f, 2f));
        addDrop(SnailBlocksBrain.DEEPSLATE_TIN_ORE, multipleOreDrops(SnailBlocksBrain.DEEPSLATE_TIN_ORE, SnailItems.RAW_TIN, 1f, 2f));

        addDrop(SnailBlocksBrain.GRAPHITE_ORE, multipleOreDrops(SnailBlocksBrain.GRAPHITE_ORE, SnailItems.RAW_GRAPHITE, 1f, 1f));
        addDrop(SnailBlocksBrain.DEEPSLATE_GRAPHITE_ORE, multipleOreDrops(SnailBlocksBrain.DEEPSLATE_GRAPHITE_ORE, SnailItems.RAW_GRAPHITE, 1f, 1f));

        addDrop(SnailBlocksBrain.ARMOR_FORGE);
        addDrop(SnailBlocksBrain.SMALL_BARREL);
        addDrop(SnailBlocksBrain.SAW_TABLE);
    }
    public LootTable.Builder bundledBlockDrop(Block drop, Item drop2, float count) {
        return this.dropsWithSilkTouch(drop,
                this.applyExplosionDecay(drop, ItemEntry.builder(drop2)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))));
    }
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
