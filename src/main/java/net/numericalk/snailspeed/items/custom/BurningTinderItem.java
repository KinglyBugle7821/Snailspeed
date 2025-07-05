package net.numericalk.snailspeed.items.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.numericalk.snailspeed.items.SnailItems;

import java.util.List;

public class BurningTinderItem extends Item {
    public BurningTinderItem(Settings settings) {
        super(settings);
    }

    private int burningTinderTime = 20 * 10;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if (!stack.isDamaged()) {
                    stack.setDamage(burningTinderTime);
                }

                burningTinderTime--;

                if (burningTinderTime <= 0) {
                    player.getInventory().setStack(slot, SnailItems.BURNT_TINDER.getDefaultStack());
                    burningTinderTime = 20 * 10;
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.snailspeed.has_shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.snailspeed.item.burning_tinder"));
        }
        tooltip.add(Text.literal("Burning Time Remaining: " + burningTinderTime));

        super.appendTooltip(stack, context, tooltip, type);
    }
}
