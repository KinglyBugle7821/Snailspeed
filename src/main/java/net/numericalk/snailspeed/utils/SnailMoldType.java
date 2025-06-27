package net.numericalk.snailspeed.utils;

import net.minecraft.item.Item;

public class SnailMoldType {
    public final Item item;
    public final int moldIndex;
    public final boolean canCastHighSmelting;
    public final boolean consumeMold;

    public SnailMoldType(Item item, int moldIndex, boolean canCastHighSmelting, boolean consumeMold) {
        this.item = item;
        this.moldIndex = moldIndex;
        this.canCastHighSmelting = canCastHighSmelting;
        this.consumeMold = consumeMold;
    }
}
