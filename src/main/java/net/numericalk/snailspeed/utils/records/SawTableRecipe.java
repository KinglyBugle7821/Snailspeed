package net.numericalk.snailspeed.utils.records;

import net.minecraft.item.Item;

public record SawTableRecipe(Item stairs, Item slab, Item door,
                             Item fence, Item fenceGate,
                             Item chest, Item barrel, Item bed, Item planks,
                             Item hangingSign, Item sign, Item trapdoor) {
}
