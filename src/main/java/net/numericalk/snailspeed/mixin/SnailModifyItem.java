package net.numericalk.snailspeed.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.datagen.SnailBlockTagsProvider;
import net.numericalk.snailspeed.utils.SnailToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(Item.class)
public abstract class SnailModifyItem {
    @Inject(method = "getMiningSpeed", at = @At("HEAD"), cancellable = true)
    private void modifyMiningSpeed(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cir) {
        if ((Object)this == Items.FLINT) {
            if (state.isIn(BlockTags.STONE_ORE_REPLACEABLES) || state.isIn(SnailBlockTagsProvider.STONE_BLOCK)) {
                cir.setReturnValue(3.0F);
            }
        }
    }
}
