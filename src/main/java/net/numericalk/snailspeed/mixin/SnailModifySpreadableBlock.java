package net.numericalk.snailspeed.mixin;

import net.minecraft.block.*;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpreadableBlock.class)
public class SnailModifySpreadableBlock {
    @Redirect(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean redirectIsOf(BlockState instance, Block block) {
        return instance.isOf(block) || (block == Blocks.DIRT && instance.isOf(SnailBlocks.UNSTEADY_DIRT));
    }
}
