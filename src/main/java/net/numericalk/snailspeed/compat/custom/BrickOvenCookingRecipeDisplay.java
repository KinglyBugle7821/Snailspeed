package net.numericalk.snailspeed.compat.custom;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.RecipeEntry;
import net.numericalk.snailspeed.compat.SnailRecipeCategories;
import net.numericalk.snailspeed.recipe.custom.BrickOvenCookingRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BrickOvenCookingRecipeDisplay extends BasicDisplay {
    public BrickOvenCookingRecipeDisplay(RecipeEntry<BrickOvenCookingRecipe> recipe) {
        super(List.of(
                        EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0))),
                List.of(EntryIngredient.of(
                        EntryStacks.of(recipe.value().output())
                ))
        );
    }
    public BrickOvenCookingRecipeDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
        this.inputs = inputs;
        this.outputs = outputs;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return SnailRecipeCategories.BRICK_OVEN_COOKING;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return SERIALIZER;
    }
    public static final DisplaySerializer<BrickOvenCookingRecipeDisplay> SERIALIZER = DisplaySerializer.of(
            RecordCodecBuilder.<BrickOvenCookingRecipeDisplay>mapCodec(instance ->
                    instance.group(
                            EntryIngredient.codec().listOf().fieldOf("inputs").forGetter(BrickOvenCookingRecipeDisplay::getInputEntries),
                            EntryIngredient.codec().listOf().fieldOf("outputs").forGetter(BrickOvenCookingRecipeDisplay::getOutputEntries)
                    ).apply(instance, BrickOvenCookingRecipeDisplay::new)
            ),
            PacketCodec.tuple(
                    PacketCodecs.collection(ArrayList::new, EntryIngredient.streamCodec()),
                    BrickOvenCookingRecipeDisplay::getInputEntries,
                    PacketCodecs.collection(ArrayList::new, EntryIngredient.streamCodec()),
                    BrickOvenCookingRecipeDisplay::getOutputEntries,
                    BrickOvenCookingRecipeDisplay::new
            )
    );
}
