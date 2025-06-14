package net.numericalk.items.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.numericalk.items.SnailItems;

public class TinderItem extends Item {
    public TinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (user.getOffHandStack().isOf(Items.STICK) && user.getMainHandStack().isOf(SnailItems.TINDER)){
            user.setStackInHand(hand, SnailItems.BURNING_TINDER.getDefaultStack());
            world.playSound(user, user.getBlockPos(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    private int burningTinderTime = 20 * 3;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && stack.isOf(SnailItems.BURNING_TINDER)) {
            if (entity instanceof PlayerEntity player) {
                if (!stack.isDamaged()) {
                    stack.setDamage(burningTinderTime); // 3 seconds (60 ticks)
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
