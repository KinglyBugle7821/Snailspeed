package net.numericalk.snailspeed.compat.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.shedaniel.rei.api.client.favorites.FavoriteEntryType;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.Registry;
import net.minecraft.resource.Resource;
import net.minecraft.resource.metadata.ResourceFilter;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.compat.SnailRecipeCategories;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.recipe.custom.ArmorForgeRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ArmorForgeRecipeDisplay extends BasicDisplay {
    @SuppressWarnings("unchecked")
    public ArmorForgeRecipeDisplay(RecipeEntry<ArmorForgeRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0)),
                        EntryIngredients.ofIngredient(recipe.value().getIngredients().get(1)),
                        EntryIngredients.ofIngredient(recipe.value().getIngredients().get(2)),
                        EntryIngredients.ofIngredient(recipe.value().getIngredients().get(3))),
                List.of(EntryIngredient.of(Stream.of(recipe.value().outputHelmet(),
                                        recipe.value().outputChestplate(),
                                        recipe.value().outputLeggings(),
                                        recipe.value().outputBoots()
                                )
                                .filter(stack -> stack != null && !stack.isOf(Items.AIR))
                                .map(EntryStacks::of)
                                .toArray(EntryStack[]::new)
                ))
        );
    }
    public ArmorForgeRecipeDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
        this.inputs = inputs;
        this.outputs = outputs;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return SnailRecipeCategories.ARMOR_FORGE;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return SERIALIZER;
    }
    public static final DisplaySerializer<ArmorForgeRecipeDisplay> SERIALIZER = DisplaySerializer.of(
            RecordCodecBuilder.<ArmorForgeRecipeDisplay>mapCodec(instance ->
                    instance.group(
                            EntryIngredient.codec().listOf().fieldOf("inputs").forGetter(ArmorForgeRecipeDisplay::getInputEntries),
                            EntryIngredient.codec().listOf().fieldOf("outputs").forGetter(ArmorForgeRecipeDisplay::getOutputEntries)
                    ).apply(instance, ArmorForgeRecipeDisplay::new)
            ),
            PacketCodec.tuple(
                    PacketCodecs.collection(ArrayList::new, EntryIngredient.streamCodec()),
                    ArmorForgeRecipeDisplay::getInputEntries,
                    PacketCodecs.collection(ArrayList::new, EntryIngredient.streamCodec()),
                    ArmorForgeRecipeDisplay::getOutputEntries,
                    ArmorForgeRecipeDisplay::new
            )
    );

}
