package net.numericalk;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroups;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.blocks.entity.SnailBlockEntities;
import net.numericalk.items.SnailItemGroup;
import net.numericalk.items.SnailItems;
import net.numericalk.utils.SnailBreakEvents;
import net.numericalk.utils.SnailLogStripping;
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
		SnailBlockEntities.initialize();

		SnailLootTableMod.modifyLootTables();
		SnailWoodReplace.replaceWoodBlock();
		SnailLogStripping.logStripping();
		SnailBreakEvents.playerBreak();
		BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.CAMPFIRE_BASE, RenderLayer.getCutout());

	}
}