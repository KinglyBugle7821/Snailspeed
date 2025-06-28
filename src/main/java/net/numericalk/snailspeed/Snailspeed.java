package net.numericalk.snailspeed;

import net.fabricmc.api.ModInitializer;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.items.SnailItemGroup;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.screen.SnailScreenHandlers;
import net.numericalk.snailspeed.utils.*;
import net.numericalk.snailspeed.world.gen.SnailWorldGen;
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
		SnailScreenHandlers.initialize();

		SnailWorldGen.generateModdedWorldGen();

		SnailLootTableMod.modifyLootTables();
		SnailLogStripping.logStripping();
		SnailSetBlockOnFire.SetOnFire();
		SnailWoodReplace.replaceWood();
		SnailBreakEvents.playerBreak();

	}
}