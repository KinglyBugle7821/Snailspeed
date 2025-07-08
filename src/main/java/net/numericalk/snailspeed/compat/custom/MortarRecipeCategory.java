package net.numericalk.snailspeed.compat.custom;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.compat.SnailRecipeCategories;

import java.util.LinkedList;
import java.util.List;

public class MortarRecipeCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE = Identifier.of(Snailspeed.MOD_ID,
            "textures/gui/compat/rei/mortar_rei_gui.png");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return SnailRecipeCategories.MORTAR;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.snailspeed.mortar");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(SnailBlocks.MORTAR.asItem().getDefaultStack());
    }

    // Done with the help:
    // https://github.com/TeamGalacticraft/Galacticraft/tree/main (MIT License)
    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        List<Widget> widgets = new LinkedList<>();

        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 39, startPoint.y + 37))
                .entries(display.getInputEntries().get(0)).markInput());

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 138, startPoint.y + 37))
                .entries(display.getOutputEntries().get(0)).markOutput());

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
