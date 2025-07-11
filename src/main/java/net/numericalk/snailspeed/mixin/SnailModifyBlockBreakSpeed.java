package net.numericalk.snailspeed.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Blocks.class)
public class SnailModifyBlockBreakSpeed {
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=oak_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeOakWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=spruce_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeSpruceWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=birch_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeBirchWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=jungle_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeJungleWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=acacia_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeAcaciaWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=dark_oak_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeDarkOakWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=mangrove_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeMangroveWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=cherry_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeCherryWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=pale_oak_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changePaleOakWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=crimson_hyphae")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeCrimsonHyphaeHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=warped_hyphae")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeWarpedHyphaeHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=oak_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeOakPlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=spruce_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeSprucePlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=birch_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeBirchPlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=jungle_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeJunglePlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=acacia_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeAcaciaPlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=dark_oak_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDarkOakPlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=mangrove_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeMangrovePlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=cherry_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeCherryPlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=pale_oak_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changePaleOakPlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=crimson_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeCrimsonPlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=warped_planks")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeWarpedPlanksStrength(Args args) {
        float hardness = 3.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }

    //CONSTANT

    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_oak_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippedOakWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_spruce_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippedSpruceWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_birch_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippedBirchWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_jungle_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippedJungleWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_acacia_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippedAcaciaWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_dark_oak_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippedDarkOakWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_mangrove_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippedMangroveWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_cherry_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippedCherryWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_pale_oak_wood")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippedPaleOakWoodHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_crimson_hyphae")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippeCrimsonHyphaeHardness(float originalHardness) {
        return 6.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stripped_warped_hyphae")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeStrippedWarpedHyphaeHardness(float originalHardness) {
        return 6.0f;
    }

    @Inject(method = "createLogSettings", at = @At("RETURN"), cancellable = true)
    private static void init(MapColor topMapColor, MapColor sideMapColor, BlockSoundGroup sounds, CallbackInfoReturnable<AbstractBlock.Settings> cir) {
        AbstractBlock.Settings original = cir.getReturnValue();
        AbstractBlock.Settings modified = AbstractBlock.Settings.create()
                .mapColor((state) -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(6.0F, 2.0F)
                .sounds(sounds)
                .burnable()
                .requiresTool();
        cir.setReturnValue(modified);
    }
    @Inject(method = "createNetherStemSettings", at = @At("RETURN"), cancellable = true)
    private static void init(MapColor mapColor, CallbackInfoReturnable<AbstractBlock.Settings> cir) {
        AbstractBlock.Settings original = cir.getReturnValue();
        AbstractBlock.Settings modified = AbstractBlock.Settings.create()
                .mapColor((state) -> mapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(6.0F, 2.0F)
                .requiresTool()
                .sounds(BlockSoundGroup.NETHER_STEM);
        cir.setReturnValue(modified);
    }

    //DIRT AND STONE

    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=dirt")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeDirtHardness(float originalHardness) {
        return 4.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=coarse_dirt")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeCoarseDirtHardness(float originalHardness) {
        return 4.5f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=gravel")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeGravelHardness(float originalHardness) {
        return 3.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=sand")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeSandHardness(float originalHardness) {
        return 3.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=snow_block")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeSnowHardness(float originalHardness) {
        return 3.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=grass_block")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeGrassBlockHardness(float originalHardness) {
        return 3.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=farmland")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeFarmlandHardness(float originalHardness) {
        return 3.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=podzol")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changePodzolHardness(float originalHardness) {
        return 3.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=rooted_dirt")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeRootedDirtHardness(float originalHardness) {
        return 3.0f;
    }

    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=stone")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeStoneStrength(Args args) {
        float hardness = 6.0f;
        float resistance = 6.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=cobblestone")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeCobblestoneStrength(Args args) {
        float hardness = 6.5f;
        float resistance = 6.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=mossy_cobblestone")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeMossyCobblestoneStrength(Args args) {
        float hardness = 6.5f;
        float resistance = 6.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }

    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=coal_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeCoalOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deepslate_coal_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDeepslateCoalOreStrength(Args args) {
        float hardness = 7.5f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=copper_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeCopperOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deepslate_copper_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDeepslateCopperOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=lapis_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeLapisOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deepslate_lapis_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDeepslateLapisOreStrength(Args args) {
        float hardness = 7.5f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=iron_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeIronOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deepslate_iron_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDeepslateIronOreStrength(Args args) {
        float hardness = 7.5f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=gold_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeGoldOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deepslate_gold_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDeepslateGoldOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=redstone_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeRedstoneOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deepslate_redstone_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDeepslateRedstoneOreStrength(Args args) {
        float hardness = 7.05f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=emerald_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeEmeraldOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deepslate_emerald_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDeepslateEmeraldOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=diamond_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDiamondOreStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deepslate_diamond_ore")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDeepslateDiamondOreStrength(Args args) {
        float hardness = 7.5f;
        float resistance = 3.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }

    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deepslate")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeDeepslateStrength(Args args) {
        float hardness = 7.0f;
        float resistance = 6.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
    @ModifyArgs(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=cobbled_deepslate")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void changeCobbledDeepslateStrength(Args args) {
        float hardness = 7.5f;
        float resistance = 6.0f;

        args.set(0, hardness);
        args.set(1, resistance);
    }
}
