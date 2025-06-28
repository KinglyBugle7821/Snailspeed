package net.numericalk.snailspeed.screen.custom;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ArmorForgeScreen extends HandledScreen<ArmorForgeScreenHandler> {
    private ArmorPiece selectedPiece = ArmorPiece.HELMET;
    private List<ArmorSelectButtonWidget> pieceButtons = new ArrayList<>();

    private static final Identifier GUI_TEXTURE =
            Identifier.of(Snailspeed.MOD_ID, "textures/gui/container/armor_forge_gui.png");

    public ArmorForgeScreen(ArmorForgeScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();

        pieceButtons.clear();

        int x1 = this.x + 13;
        int x2 = this.x + 147;
        int startY = this.y + 24;

        int splitIndex = 2;
        ArmorPiece[] pieces = ArmorPiece.values();

        for (int i = 0; i < pieces.length; i++) {
            ArmorPiece piece = pieces[i];
            int x = (i < splitIndex) ? x1 : x2;
            int y = startY + (i < splitIndex ? i : i - splitIndex) * 18;
            ArmorSelectButtonWidget button = new ArmorSelectButtonWidget(x, y, piece, (selected) -> {
                this.selectedPiece = selected;
                updateSelection();
            });
            pieceButtons.add(button);
            this.addDrawableChild(button);
        }


        updateSelection();
    }

    private void updateSelection() {
        for (ArmorSelectButtonWidget button : pieceButtons) {
            button.setSelected(button.getPiece() == selectedPiece);
        }
    }


    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(RenderLayer::getGuiTextured, GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    public ArmorPiece getSelectedPiece() {
        return selectedPiece;
    }

    public enum ArmorPiece {
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS;
    }
    public class ArmorSelectButtonWidget extends PressableWidget {
        private static final Identifier DEFAULT_FRAME = Identifier.of(Snailspeed.MOD_ID, "container/button");
        private static final Identifier SELECTED_FRAME = Identifier.of(Snailspeed.MOD_ID, "container/button_selected");
        private static final Map<ArmorPiece, Identifier> ICONS = Map.of(
                ArmorPiece.HELMET, Identifier.of(Snailspeed.MOD_ID, "container/armor_forge/helmet_outline"),
                ArmorPiece.CHESTPLATE, Identifier.of(Snailspeed.MOD_ID, "container/armor_forge/chestplate_outline"),
                ArmorPiece.LEGGINGS, Identifier.of(Snailspeed.MOD_ID, "container/armor_forge/leggings_outline"),
                ArmorPiece.BOOTS, Identifier.of(Snailspeed.MOD_ID, "container/armor_forge/boots_outline")
        );

        private final ArmorPiece piece;
        private final Consumer<ArmorPiece> onClick;
        private boolean selected;

        public ArmorSelectButtonWidget(int x, int y, ArmorPiece piece, Consumer<ArmorPiece> onClick) {
            super(x, y, 16, 16, Text.empty());
            this.piece = piece;
            this.onClick = onClick;
        }

        @Override
        public void onPress() {
            this.onClick.accept(piece);
        }

        @Override
        public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
            Identifier icon = ICONS.get(piece);
            Identifier frame = this.selected ? SELECTED_FRAME : DEFAULT_FRAME;

            context.drawGuiTexture(RenderLayer::getGuiTextured, frame, this.getX(), this.getY(), this.width, this.height);
            int iconSize = 16;
            int iconX = this.getX() + (this.width - iconSize) / 2;
            int iconY = this.getY() + (this.height - iconSize) / 2;
            context.drawGuiTexture(RenderLayer::getGuiTextured, icon, iconX, iconY, iconSize, iconSize);
        }

        @Override
        protected void appendClickableNarrations(NarrationMessageBuilder builder) {

        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public ArmorPiece getPiece() {
            return piece;
        }
    }
}