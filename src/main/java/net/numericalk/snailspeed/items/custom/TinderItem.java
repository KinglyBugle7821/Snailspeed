package net.numericalk.snailspeed.items.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.numericalk.snailspeed.items.SnailItems;

import java.util.Random;

public class TinderItem extends Item{
    public TinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 20 * 5;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return ActionResult.SUCCESS;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            Random random = new Random();
            int randomNumber = random.nextInt(1, 3);
            if (randomNumber == 1) {
                if (player.getOffHandStack().isOf(Items.STICK) && stack.isOf(SnailItems.TINDER)) {
                    if (!world.isClient) {
                        player.setStackInHand(Hand.MAIN_HAND, SnailItems.BURNING_TINDER.getDefaultStack());
                        world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1f, 1f);
                    }
                }
            }
        }
        return stack;
    }
}
