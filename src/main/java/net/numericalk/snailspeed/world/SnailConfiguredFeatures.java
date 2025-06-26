package net.numericalk.snailspeed.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.SnailBlocks;

import java.util.List;

public class SnailConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GRAPHITE_ORE_KEY = registerKey("graphite_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> ctx){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> tinOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, SnailBlocks.TIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, SnailBlocks.DEEPSLATE_TIN_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> graphiteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, SnailBlocks.GRAPHITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, SnailBlocks.DEEPSLATE_GRAPHITE_ORE.getDefaultState()));

        register(ctx, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(tinOres, 12));
        register(ctx, GRAPHITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(graphiteOres, 8));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Snailspeed.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
