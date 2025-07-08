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
import net.numericalk.snailspeed.recipe.custom.MortarRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MortarRecipeDisplay extends BasicDisplay {
    public MortarRecipeDisplay(RecipeEntry<MortarRecipe> recipe) {
        super(List.of(
                EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0))),

                List.of(EntryIngredient.of(EntryStacks.of(recipe.value().output())))
        );
    }
    public MortarRecipeDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
        this.inputs = inputs;
        this.outputs = outputs;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return SnailRecipeCategories.MORTAR;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return SERIALIZER;
    }
    public static final DisplaySerializer<MortarRecipeDisplay> SERIALIZER = DisplaySerializer.of(
            RecordCodecBuilder.<MortarRecipeDisplay>mapCodec(instance ->
                    instance.group(
                            EntryIngredient.codec().listOf().fieldOf("inputs").forGetter(MortarRecipeDisplay::getInputEntries),
                            EntryIngredient.codec().listOf().fieldOf("outputs").forGetter(MortarRecipeDisplay::getOutputEntries)
                    ).apply(instance, MortarRecipeDisplay::new)
            ),
            PacketCodec.tuple(
                    PacketCodecs.collection(ArrayList::new, EntryIngredient.streamCodec()),
                    MortarRecipeDisplay::getInputEntries,
                    PacketCodecs.collection(ArrayList::new, EntryIngredient.streamCodec()),
                    MortarRecipeDisplay::getOutputEntries,
                    MortarRecipeDisplay::new
            )
    );

}
