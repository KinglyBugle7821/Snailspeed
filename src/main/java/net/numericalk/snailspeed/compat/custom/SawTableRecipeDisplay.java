package net.numericalk.snailspeed.compat.custom;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.RecipeEntry;
import net.numericalk.snailspeed.compat.SnailRecipeCategories;
import net.numericalk.snailspeed.recipe.custom.SawTableRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SawTableRecipeDisplay extends BasicDisplay {
    @SuppressWarnings("unchecked")
    public SawTableRecipeDisplay(RecipeEntry<SawTableRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0)),
                        EntryIngredients.ofIngredient(recipe.value().getIngredients().get(1))),
                List.of(EntryIngredient.of(Stream.of(recipe.value().stairs(),
                                        recipe.value().slab(),
                                        recipe.value().door(),
                                        recipe.value().bed(),
                                        recipe.value().fence(),
                                        recipe.value().fenceGate(),
                                        recipe.value().chest(),
                                        recipe.value().barrel(),
                                        recipe.value().planks(),
                                        recipe.value().hangingSign(),
                                        recipe.value().sign(),
                                        recipe.value().trapdoor()
                                )
                                .filter(stack -> stack != null && !stack.isOf(Items.AIR))
                                .map(EntryStacks::of)
                                .toArray(EntryStack[]::new)
                ))
        );
    }
    public SawTableRecipeDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
        this.inputs = inputs;
        this.outputs = outputs;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return SnailRecipeCategories.SAW_TABLE;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return SERIALIZER;
    }
    public static final DisplaySerializer<SawTableRecipeDisplay> SERIALIZER = DisplaySerializer.of(
            RecordCodecBuilder.<SawTableRecipeDisplay>mapCodec(instance ->
                    instance.group(
                            EntryIngredient.codec().listOf().fieldOf("inputs").forGetter(SawTableRecipeDisplay::getInputEntries),
                            EntryIngredient.codec().listOf().fieldOf("outputs").forGetter(SawTableRecipeDisplay::getOutputEntries)
                    ).apply(instance, SawTableRecipeDisplay::new)
            ),
            PacketCodec.tuple(
                    PacketCodecs.collection(ArrayList::new, EntryIngredient.streamCodec()),
                    SawTableRecipeDisplay::getInputEntries,
                    PacketCodecs.collection(ArrayList::new, EntryIngredient.streamCodec()),
                    SawTableRecipeDisplay::getOutputEntries,
                    SawTableRecipeDisplay::new
            )
    );
    
}
