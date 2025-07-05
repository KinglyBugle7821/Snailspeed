package net.numericalk.snailspeed.screen.custom;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.StonecutterScreen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.networking.packets.SawSelectRecipePayload;
import net.numericalk.snailspeed.utils.enums.SawCraftable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class SawTableScreen extends HandledScreen<SawTableScreenHandler> {
    private SawCraftable defaultSelectedPiece = SawCraftable.STAIRS;
    private final List<SawCraftableSelectButtonWidget> pieceButtons = new ArrayList<>();
    private static final Identifier SCROLLER_TEXTURE = Identifier.ofVanilla("container/stonecutter/scroller");
    private static final Identifier SCROLLER_DISABLED_TEXTURE = Identifier.ofVanilla("container/stonecutter/scroller_disabled");
    private float scrollAmount;
    private boolean mouseClicked;
    private int scrollOffset;
    private boolean canCraft = true;

    private static final Identifier GUI_TEXTURE = Identifier.of(Snailspeed.MOD_ID, "textures/gui/container/saw_table_gui.png");

    public SawTableScreen(SawTableScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.pieceButtons.clear();
        updateWidgets();
    }

    private void updateWidgets() {
        this.clearChildren();

        int startX = this.x + 52;
        int startY = this.y + 15;
        int spacingX = 16;
        int spacingY = 16;

        int columns = 4;
        int rows = 3;
        int visible = columns * rows;

        SawCraftable[] pieces = SawCraftable.values();

        for (int index = scrollOffset; index < scrollOffset + visible && index < pieces.length; index++) {
            int local = index - scrollOffset;
            int col = local % columns;
            int row = local / columns;

            int x = startX + col * spacingX;
            int y = startY + row * spacingY;

            SawCraftable piece = pieces[index];

            SawCraftableSelectButtonWidget button = new SawCraftableSelectButtonWidget(x, y, piece, selected -> {
                this.defaultSelectedPiece = selected;
                updateSelection();
            });

            this.addDrawableChild(button);
            pieceButtons.add(button);
        }

        updateSelection();
    }


    public SawCraftable getDefaultSelectedPiece() {
        return defaultSelectedPiece;
    }


    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseClicked = false;
        if (this.canCraft) {
            int i = this.x + 52;
            int j = this.y + 14;
            int k = this.scrollOffset + 12;

            for (int l = this.scrollOffset; l < k; l++) {
                int m = l - this.scrollOffset;
                double d = mouseX - (i + m % 4 * 16);
                double e = mouseY - (j + (double) m / 4 * 18);
                if (d >= 0.0 && e >= 0.0 && d < 16.0 && e < 18.0 && this.handler.onButtonClick(this.client.player, l)) {
                    MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.client.interactionManager.clickButton(this.handler.syncId, l);
                    return true;
                }
            }

            i = this.x + 119;
            j = this.y + 9;
            if (mouseX >= i && mouseX < i + 12 && mouseY >= j && mouseY < j + 54) {
                this.mouseClicked = true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }
    private void updateSelection() {
        for (SawCraftableSelectButtonWidget button : pieceButtons) {
            button.setSelected(button.getPiece() == defaultSelectedPiece);
        }
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = this.x;
        int j = this.y;
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        int k = (int)(41.0F * this.scrollAmount);
        Identifier identifier = this.shouldScroll() ? SCROLLER_TEXTURE : SCROLLER_DISABLED_TEXTURE;

        context.drawTexture(RenderLayer::getGuiTextured, GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);
        context.drawGuiTexture(RenderLayer::getGuiTextured, identifier, i + 119, j + 15 + k, 12, 15);
    }
    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.mouseClicked && this.shouldScroll()) {
            int i = this.y + 14;
            int j = i + 54;
            this.scrollAmount = ((float)mouseY - i - 7.5F) / (j - i - 15.0F);
            this.scrollAmount = MathHelper.clamp(this.scrollAmount, 0.0F, 1.0F);
            this.scrollOffset = (int)(this.scrollAmount * getMaxScroll() + 0.5) * 4;
            updateWidgets();
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount)) {
            return true;
        } else {
            if (this.shouldScroll()) {
                int i = this.getMaxScroll();
                float f = (float)verticalAmount / i;
                this.scrollAmount = MathHelper.clamp(this.scrollAmount - f, 0.0F, 1.0F);
                this.scrollOffset = (int)(this.scrollAmount * i + 0.5) * 4;
                updateWidgets();
            }

            return true;
        }
    }
    protected int getMaxScroll() {
        return Math.max(0, (SawCraftable.values().length + 3) / 4 - 3);
    }

    private boolean shouldScroll() {
        return SawCraftable.values().length > 12;
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
    public class SawCraftableSelectButtonWidget extends PressableWidget {
        private static final Identifier DEFAULT_FRAME = Identifier.of(Snailspeed.MOD_ID, "container/button");
        private static final Identifier SELECTED_FRAME = Identifier.of(Snailspeed.MOD_ID, "container/button_selected");
        private static final Map<SawCraftable, Identifier> ICONS = Map.ofEntries(
                Map.entry(SawCraftable.STAIRS, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/stairs_outline")),
                Map.entry(SawCraftable.SLAB, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/slab_outline")),
                Map.entry(SawCraftable.DOOR, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/door_outline")),
                Map.entry(SawCraftable.BED, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/bed_outline")),
                Map.entry(SawCraftable.FENCE, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/fence_outline")),
                Map.entry(SawCraftable.FENCE_GATE, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/fence_gate_outline")),
                Map.entry(SawCraftable.CHEST, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/chest_outline")),
                Map.entry(SawCraftable.BARREL, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/barrel_outline")),
                Map.entry(SawCraftable.PLANKS, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/planks_outline")),
                Map.entry(SawCraftable.HANGING_SIGN, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/hanging_sign_outline")),
                Map.entry(SawCraftable.SIGN, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/sign_outline")),
                Map.entry(SawCraftable.TRAPDOOR, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/trapdoor_outline")),
                Map.entry(SawCraftable.BOAT, Identifier.of(Snailspeed.MOD_ID, "container/saw_table/boat_outline"))
        );

        private final SawCraftable piece;
        private final Consumer<SawCraftable> onClick;
        private boolean selected;

        public SawCraftableSelectButtonWidget(int x, int y, SawCraftable piece, Consumer<SawCraftable> onClick) {
            super(x, y, 17, 17, Text.empty());
            this.piece = piece;
            this.onClick = onClick;
        }

        @Override
        public void onPress() {
            this.onClick.accept(piece);

            updateSelection();

            ClientPlayNetworking.send(new SawSelectRecipePayload(handler.getBlockPos(), getDefaultSelectedPiece()));
        }

        @Override
        public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
            Identifier icon = ICONS.get(piece);
            Identifier frame = this.selected ? SELECTED_FRAME : DEFAULT_FRAME;

            context.drawGuiTexture(RenderLayer::getGuiTextured, frame, this.getX(), this.getY(), this.width, this.height);
            int iconSize = 15;
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

        public SawCraftable getPiece() {
            return piece;
        }
    }

}