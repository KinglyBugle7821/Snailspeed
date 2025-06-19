package net.numericalk.mixin;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Blocks.class)
public class SnailModifyLog {
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
    private static void init(MapColor mapColor, CallbackInfoReturnable<AbstractBlock.Settings> cir){
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
        return 4.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=sand")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeSandHardness(float originalHardness) {
        return 4.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=snow_block")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeSnowHardness(float originalHardness) {
        return 4.0f;
    }
    @ModifyArg(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=grass_block")), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;strength(F)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static float changeGrassBlockHardness(float originalHardness) {
        return 4.0f;
    }
}
