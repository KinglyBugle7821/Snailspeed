package net.numericalk.snailspeed.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.numericalk.snailspeed.Snailspeed;

import java.util.List;

public class SnailPlacedFeatures {
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final RegistryKey<PlacedFeature> GRAPHITE_ORE_PLACED_KEY = registerKey("graphite_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> ctx) {
        var configuredFeatures = ctx.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(ctx, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(SnailConfiguredFeatures.TIN_ORE_KEY),
                SnailOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(70))));
        register(ctx, GRAPHITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(SnailConfiguredFeatures.GRAPHITE_ORE_KEY),
                SnailOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(12))));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Snailspeed.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
