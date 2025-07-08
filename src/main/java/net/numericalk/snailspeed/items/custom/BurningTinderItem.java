package net.numericalk.snailspeed.items.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.misc.SnailComponent;

import java.util.List;

public class BurningTinderItem extends Item {
    public BurningTinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (stack.contains(SnailComponent.BURNING_ITEM) && !world.isClient() && entity instanceof PlayerEntity player){
            float burningTinderTime = stack.get(SnailComponent.BURNING_ITEM);
            stack.set(SnailComponent.BURNING_ITEM, --burningTinderTime);
            if (burningTinderTime <= 0) {
                player.getInventory().setStack(slot, SnailItems.BURNT_TINDER.getDefaultStack());
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.contains(SnailComponent.BURNING_ITEM)){
            if(!Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.snailspeed.has_shift_down"));
            } else {
                tooltip.add(Text.translatable("tooltip.snailspeed.item.burning_tinder"));
            }

            float burningTinderTime = stack.get(SnailComponent.BURNING_ITEM);
            tooltip.add(Text.literal("Burning Time Remaining: " + Math.round(burningTinderTime / 10) + "s"));

        } else {
            if(!Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.snailspeed.has_shift_down"));
            } else {
                tooltip.add(Text.translatable("tooltip.snailspeed.item.burning_tinder"));
            }
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
