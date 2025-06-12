package net.numericalk;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.numericalk.datagen.*;

public class SnailspeedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(SnailModelProvider::new);
		pack.addProvider(SnailLangProvider::new);
		pack.addProvider(SnailBlockTagsProvider::new);
		pack.addProvider(SnailItemTagsProvider::new);
		pack.addProvider(SnailBlockLootTable::new);
	}
}
