package net.numericalk.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
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
        addDrop(SnailBlocks.GRASS_SHEAF);
        addDrop(SnailBlocks.DRIED_GRASS_SHEAF);

        addDropWithSilkTouch(SnailBlocks.SCRATCHED_STONE, Blocks.COBBLESTONE);

        addDrop(SnailBlocks.UNTIED_STICK_BUNDLE, StickBundleDrop(SnailBlocks.UNTIED_STICK_BUNDLE));
        addDrop(SnailBlocks.STICK_BUNDLE);

        addDrop(SnailBlocks.UNSTEADY_DIRT);
        addDrop(SnailBlocks.UNSTEADY_COARSE_DIRT);
    }
    public LootTable.Builder StickBundleDrop(Block drop) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay
                        (drop, ItemEntry.builder(Items.STICK)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider
                                        .create(4.0f)))));
    }
}
