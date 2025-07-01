package net.numericalk.snailspeed;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.numericalk.snailspeed.datagen.*;
import net.numericalk.snailspeed.world.SnailConfiguredFeatures;
import net.numericalk.snailspeed.world.SnailPlacedFeatures;

public class SnailspeedDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(SnailModelProvider::new);
        pack.addProvider(SnailLangProvider::new);
        pack.addProvider(SnailBlockTagsProvider::new);
        pack.addProvider(SnailItemTagsProvider::new);
        pack.addProvider(SnailBlockLootTable::new);
        pack.addProvider(SnailRecipeProvider::new);
        pack.addProvider(SnailRegistryDataGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, SnailConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, SnailPlacedFeatures::bootstrap);
    }
}
