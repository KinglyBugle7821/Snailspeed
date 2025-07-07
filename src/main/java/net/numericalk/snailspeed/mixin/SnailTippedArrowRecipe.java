package net.numericalk.snailspeed.mixin;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.TippedArrowRecipe;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TippedArrowRecipe.class)
public class SnailTippedArrowRecipe {
    @Inject(method = "matches(Lnet/minecraft/recipe/input/CraftingRecipeInput;Lnet/minecraft/world/World;)Z", at = @At("HEAD"), cancellable = true)
    public void modifyTippedArrowCrafting(CraftingRecipeInput craftingRecipeInput, World world, CallbackInfoReturnable<Boolean> cir) {
        if (craftingRecipeInput.getWidth() == 2 && craftingRecipeInput.getHeight() == 2 && craftingRecipeInput.getStackCount() == 4) {
            for (int i = 0; i < craftingRecipeInput.getHeight(); i++) {
                for (int j = 0; j < craftingRecipeInput.getWidth(); j++) {
                    ItemStack itemStack = craftingRecipeInput.getStackInSlot(j, i);
                    if (itemStack.isEmpty()) {
                        cir.setReturnValue(false);
                    }

                    if (j == 1 && i == 1) {
                        if (!itemStack.isOf(Items.LINGERING_POTION)) {
                            cir.setReturnValue(false);
                        }
                    } else if (!itemStack.isOf(Items.ARROW)) {
                        cir.setReturnValue(false);
                    }
                }
            }

            cir.setReturnValue(true);
        } else {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "craft*", at = @At("HEAD"), cancellable = true)
    private void modifyTippedArrowResult(CraftingRecipeInput input, RegistryWrapper.WrapperLookup lookup, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack center = input.getStackInSlot(1, 1);

        if (center.getItem() == Items.LINGERING_POTION) {
            PotionContentsComponent potion = center.get(DataComponentTypes.POTION_CONTENTS);

            if (potion != null) {
                ItemStack customArrow = new ItemStack(Items.TIPPED_ARROW, 3); // make 16 instead of 8?
                customArrow.set(DataComponentTypes.POTION_CONTENTS, potion);
                cir.setReturnValue(customArrow);
            } else {
                cir.setReturnValue(ItemStack.EMPTY);
            }

            cir.cancel();
        }
    }
}
