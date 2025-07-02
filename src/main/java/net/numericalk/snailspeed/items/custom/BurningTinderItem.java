package net.numericalk.snailspeed.items.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.numericalk.snailspeed.items.SnailItems;

public class BurningTinderItem extends Item {
    public BurningTinderItem(Settings settings) {
        super(settings);
    }

    private int burningTinderTime = 20 * 3;

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
                    burningTinderTime = 20 * 3;
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
