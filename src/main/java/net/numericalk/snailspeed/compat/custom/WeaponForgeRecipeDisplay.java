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
import net.minecraft.item.Items;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.RecipeEntry;
import net.numericalk.snailspeed.compat.SnailRecipeCategories;
import net.numericalk.snailspeed.recipe.custom.WeaponForgeRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WeaponForgeRecipeDisplay extends BasicDisplay {
    @SuppressWarnings("unchecked")
    public WeaponForgeRecipeDisplay(RecipeEntry<WeaponForgeRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0)),
                        EntryIngredients.ofIngredient(recipe.value().getIngredients().get(1)),
                        EntryIngredients.ofIngredient(recipe.value().getIngredients().get(2))),
                List.of(EntryIngredient.of(
                        Stream.of(recipe.value().sword(),
                                        recipe.value().axe(),
                                        recipe.value().pickaxe(),
                                        recipe.value().shovel(),
                                        recipe.value().hoe(),
                                        recipe.value().bow(),
                                        recipe.value().crossbow(),
                                        recipe.value().arrow()
                                )
                                .filter(stack -> stack != null && !stack.isOf(Items.AIR))
                                .map(EntryStacks::of)
                                .toArray(EntryStack[]::new)
                ))
        );
    }
    public WeaponForgeRecipeDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
        this.inputs = inputs;
        this.outputs = outputs;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return SnailRecipeCategories.WEAPON_FORGE;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return SERIALIZER;
    }
    public static final DisplaySerializer<WeaponForgeRecipeDisplay> SERIALIZER = DisplaySerializer.of(
            RecordCodecBuilder.<WeaponForgeRecipeDisplay>mapCodec(instance ->
                    instance.group(
                            EntryIngredient.codec().listOf().fieldOf("inputs").forGetter(WeaponForgeRecipeDisplay::getInputEntries),
                            EntryIngredient.codec().listOf().fieldOf("outputs").forGetter(WeaponForgeRecipeDisplay::getOutputEntries)
                    ).apply(instance, WeaponForgeRecipeDisplay::new)
            ),
            PacketCodec.tuple(
                    PacketCodecs.collection(ArrayList::new, EntryIngredient.streamCodec()),
                    WeaponForgeRecipeDisplay::getInputEntries,
                    PacketCodecs.collection(ArrayList::new, EntryIngredient.streamCodec()),
                    WeaponForgeRecipeDisplay::getOutputEntries,
                    WeaponForgeRecipeDisplay::new
            )
    );
}
