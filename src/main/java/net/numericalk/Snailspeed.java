package net.numericalk;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.impl.content.registry.FlammableBlockRegistryImpl;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItemGroup;
import net.numericalk.items.SnailItems;
import net.numericalk.utils.SnailLootTableMod;
import net.numericalk.utils.SnailWoodReplace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Snailspeed implements ModInitializer {
	public static final String MOD_ID = "snailspeed";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SnailItems.initialize();
		SnailBlocks.initialize();
		SnailItemGroup.initialize();

		SnailLootTableMod.modifyLootTables();
		SnailWoodReplace.replaceWoodBlock();
	}
}