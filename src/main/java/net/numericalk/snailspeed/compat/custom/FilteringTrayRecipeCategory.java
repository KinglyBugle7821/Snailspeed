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

import java.util.LinkedList;
import java.util.List;

import static net.numericalk.snailspeed.compat.SnailRecipeCategories.FILTERING_TRAY;

public class FilteringTrayRecipeCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE = Identifier.of(Snailspeed.MOD_ID,
            "textures/gui/compat/rei/filtering_tray_rei_gui.png");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return FILTERING_TRAY;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.snailspeed.filtering_tray");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(SnailBlocks.FILTERING_TRAY.asItem().getDefaultStack());
    }

    // Done with the help:
    // https://github.com/TeamGalacticraft/Galacticraft/tree/main (MIT License)
    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        List<Widget> widgets = new LinkedList<>();

        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82)));
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 26, startPoint.y + 35))
                .entries(display.getInputEntries().get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 62, startPoint.y + 35))
                .entries(display.getInputEntries().get(1)).markInput());

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 116, startPoint.y + 35))
                .entries(display.getOutputEntries().get(0)).markOutput());

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
