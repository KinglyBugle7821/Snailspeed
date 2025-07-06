package net.numericalk.snailspeed.screen.custom;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.networking.packets.WeaponSelectPayload;
import net.numericalk.snailspeed.utils.enums.WeaponPiece;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class WeaponForgeScreen extends HandledScreen<WeaponForgeScreenHandler> {
    private WeaponPiece defaultSelectedPiece = WeaponPiece.SWORD;
    private List<WeaponSelectButtonWidget> pieceButtons = new ArrayList<>();

    private static final Identifier GUI_TEXTURE =
            Identifier.of(Snailspeed.MOD_ID, "textures/gui/container/weapon_forge_gui.png");

    public WeaponForgeScreen(WeaponForgeScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();

        pieceButtons.clear();

        int x1 = this.x + 125;
        int x2 = this.x + 150;
        int startY = this.y + 6;

        int splitIndex = 4;
        WeaponPiece[] pieces = WeaponPiece.values();

        for (int i = 0; i < pieces.length; i++) {
            WeaponPiece piece = pieces[i];
            int x = (i < splitIndex) ? x1 : x2;
            int y = startY + (i < splitIndex ? i : i - splitIndex) * 18;
            WeaponSelectButtonWidget button = new WeaponSelectButtonWidget(x, y, piece, (selected) -> {
                this.defaultSelectedPiece = selected;
                updateSelection();
            });
            pieceButtons.add(button);
            this.addDrawableChild(button);
        }


        updateSelection();
    }

    private void updateSelection() {
        for (WeaponSelectButtonWidget button : pieceButtons) {
            button.setSelected(button.getPiece() == defaultSelectedPiece);
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

    public WeaponPiece getDefaultSelectedPiece() {
        return defaultSelectedPiece;
    }

    public class WeaponSelectButtonWidget extends PressableWidget {
        private static final Identifier DEFAULT_FRAME = Identifier.of(Snailspeed.MOD_ID, "container/button");
        private static final Identifier SELECTED_FRAME = Identifier.of(Snailspeed.MOD_ID, "container/button_selected");
        private static final Map<WeaponPiece, Identifier> ICONS = Map.of(
                WeaponPiece.SWORD, Identifier.of(Snailspeed.MOD_ID, "container/weapon_forge/sword_outline"),
                WeaponPiece.AXE, Identifier.of(Snailspeed.MOD_ID, "container/weapon_forge/axe_outline"),
                WeaponPiece.PICKAXE, Identifier.of(Snailspeed.MOD_ID, "container/weapon_forge/pickaxe_outline"),
                WeaponPiece.SHOVEL, Identifier.of(Snailspeed.MOD_ID, "container/weapon_forge/shovel_outline"),
                WeaponPiece.HOE, Identifier.of(Snailspeed.MOD_ID, "container/weapon_forge/hoe_outline"),
                WeaponPiece.BOW, Identifier.of(Snailspeed.MOD_ID, "container/weapon_forge/bow_outline"),
                WeaponPiece.CROSSBOW, Identifier.of(Snailspeed.MOD_ID, "container/weapon_forge/crossbow_outline"),
                WeaponPiece.ARROW, Identifier.of(Snailspeed.MOD_ID, "container/weapon_forge/arrow_outline")
        );

        private final WeaponPiece piece;
        private final Consumer<WeaponPiece> onClick;
        private boolean selected;

        public WeaponSelectButtonWidget(int x, int y, WeaponPiece piece, Consumer<WeaponPiece> onClick) {
            super(x, y, 16, 16, Text.empty());
            this.piece = piece;
            this.onClick = onClick;
        }

        @Override
        public void onPress() {
            this.onClick.accept(piece);
            updateSelection();

            ClientPlayNetworking.send(new WeaponSelectPayload(handler.getBlockPos(), getDefaultSelectedPiece()));
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

        public WeaponPiece getPiece() {
            return piece;
        }
    }
}