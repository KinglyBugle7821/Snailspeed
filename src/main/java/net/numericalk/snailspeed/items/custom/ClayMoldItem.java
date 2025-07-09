package net.numericalk.snailspeed.items.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class ClayMoldItem extends Item {
    private final String requirement;

    public ClayMoldItem(Settings settings, String i) {
        super(settings);
        requirement = i;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.snailspeed.has_shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.snailspeed.guide.clay_mold_1"));
            tooltip.add(Text.translatable("tooltip.snailspeed.guide.clay_mold_2"));
            tooltip.add(Text.translatable("tooltip.snailspeed.guide.clay_mold_3", requirement));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
