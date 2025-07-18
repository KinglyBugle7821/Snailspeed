package net.numericalk.snailspeed.items.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.numericalk.snailspeed.items.SnailItems;

import java.util.List;

public class AirItem extends Item {
    public AirItem(Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        return SnailItems.MOLTEN_TERRACOTTA.getRecipeRemainder();
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        stack.decrement(64);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.snailspeed.has_shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.snailspeed.item.air"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
