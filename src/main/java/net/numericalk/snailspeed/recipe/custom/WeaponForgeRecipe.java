package net.numericalk.snailspeed.recipe.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.utils.enums.SawCraftable;
import net.numericalk.snailspeed.utils.enums.WeaponPiece;
import net.numericalk.snailspeed.utils.records.SnailPacketCodec;

import java.util.List;
import java.util.Optional;

public record WeaponForgeRecipe(Ingredient inputHead, Ingredient inputAdditional, Ingredient inputGlue,
                                ItemStack sword, ItemStack axe, ItemStack pickaxe, ItemStack shovel,
                                ItemStack hoe, ItemStack bow, ItemStack crossbow, ItemStack arrow) implements Recipe<WeaponForgeRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputHead);
        list.add(this.inputAdditional);
        list.add(this.inputGlue);
        return list;
    }

    public ItemStack getOutput(WeaponPiece weaponPiece) {
        return switch (weaponPiece) {
            case SWORD -> sword;
            case AXE -> axe;
            case PICKAXE -> pickaxe;
            case SHOVEL -> shovel;
            case HOE -> hoe;
            case BOW -> bow;
            case CROSSBOW -> crossbow;
            case ARROW -> arrow;
        };
    }

    @Override
    public boolean matches(WeaponForgeRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        if (input.getStackInSlot(1).isOf(Items.LINGERING_POTION) && input.getStackInSlot(0).isOf(Items.ARROW)){
            return true;
        }
        return inputHead.test(input.getStackInSlot(0)) &&
                inputAdditional.test(input.getStackInSlot(1)) &&
                inputGlue.test(input.getStackInSlot(2));
    }

    @Override
    public ItemStack craft(WeaponForgeRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return switch (input.selected()){
            case SWORD -> sword.copy();
            case AXE -> axe.copy();
            case PICKAXE -> pickaxe.copy();
            case SHOVEL -> shovel.copy();
            case HOE -> hoe.copy();
            case BOW -> bow.copy();
            case CROSSBOW -> crossbow.copy();
            case ARROW -> arrow.copy();
        };
    }
    @Override
    public RecipeSerializer<? extends Recipe<WeaponForgeRecipeInput>> getSerializer() {
        return SnailRecipe.WEAPON_FORGE_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<WeaponForgeRecipeInput>> getType() {
        return SnailRecipe.WEAPON_FORGE_RECIPE_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        List<Optional<Ingredient>> slotsInputIdk = List.of(
                Optional.of(inputHead),
                Optional.of(inputAdditional),
                Optional.of(inputGlue)
        );
        return IngredientPlacement.forMultipleSlots(slotsInputIdk);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<WeaponForgeRecipe> {
        public static final MapCodec<WeaponForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("inputHead").forGetter(WeaponForgeRecipe::inputHead),
                Ingredient.CODEC.fieldOf("inputAdditional").forGetter(WeaponForgeRecipe::inputAdditional),
                Ingredient.CODEC.fieldOf("inputGlue").forGetter(WeaponForgeRecipe::inputGlue),

                ItemStack.CODEC.optionalFieldOf("sword", ItemStack.EMPTY).forGetter(WeaponForgeRecipe::sword),
                ItemStack.CODEC.optionalFieldOf("axe", ItemStack.EMPTY).forGetter(WeaponForgeRecipe::axe),
                ItemStack.CODEC.optionalFieldOf("pickaxe", ItemStack.EMPTY).forGetter(WeaponForgeRecipe::pickaxe),
                ItemStack.CODEC.optionalFieldOf("shovel", ItemStack.EMPTY).forGetter(WeaponForgeRecipe::shovel),
                ItemStack.CODEC.optionalFieldOf("hoe", ItemStack.EMPTY).forGetter(WeaponForgeRecipe::hoe),
                ItemStack.CODEC.optionalFieldOf("bow", ItemStack.EMPTY).forGetter(WeaponForgeRecipe::bow),
                ItemStack.CODEC.optionalFieldOf("crossbow", ItemStack.EMPTY).forGetter(WeaponForgeRecipe::crossbow),
                ItemStack.CODEC.optionalFieldOf("arrow", ItemStack.EMPTY).forGetter(WeaponForgeRecipe::arrow)
        ).apply(instance, WeaponForgeRecipe::new));

        public static final PacketCodec<RegistryByteBuf, WeaponForgeRecipe> PACKET_CODEC =
                SnailPacketCodec.tuple(
                        Ingredient.PACKET_CODEC, WeaponForgeRecipe::inputHead,
                        Ingredient.PACKET_CODEC, WeaponForgeRecipe::inputAdditional,
                        Ingredient.PACKET_CODEC, WeaponForgeRecipe::inputGlue,
                        ItemStack.PACKET_CODEC, WeaponForgeRecipe::sword,
                        ItemStack.PACKET_CODEC, WeaponForgeRecipe::axe,
                        ItemStack.PACKET_CODEC, WeaponForgeRecipe::pickaxe,
                        ItemStack.PACKET_CODEC, WeaponForgeRecipe::shovel,
                        ItemStack.PACKET_CODEC, WeaponForgeRecipe::hoe,
                        ItemStack.PACKET_CODEC, WeaponForgeRecipe::bow,
                        ItemStack.PACKET_CODEC, WeaponForgeRecipe::crossbow,
                        ItemStack.PACKET_CODEC, WeaponForgeRecipe::arrow,
                        WeaponForgeRecipe::new);

        @Override
        public MapCodec<WeaponForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, WeaponForgeRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
