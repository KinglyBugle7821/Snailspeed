package net.numericalk.mixin;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Blocks.class)
public class SnailModifyLog {

    @Inject(method = "createLogSettings", at = @At("RETURN"), cancellable = true)
    private static void init(MapColor topMapColor, MapColor sideMapColor, BlockSoundGroup sounds, CallbackInfoReturnable<AbstractBlock.Settings> cir) {
        AbstractBlock.Settings original = cir.getReturnValue();
        AbstractBlock.Settings modified = AbstractBlock.Settings.create()
                .mapColor((state) -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(4.0F)
                .hardness(6.0F)
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
                .strength(6.0F)
                .hardness(8.0F)
                .requiresTool()
                .sounds(BlockSoundGroup.NETHER_STEM);
        cir.setReturnValue(modified);
    }
}
