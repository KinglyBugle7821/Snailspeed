package net.numericalk.snailspeed.screen.custom;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;

public class SmallBarrelScreen extends HandledScreen<ScreenHandler> {
    private static final Identifier GUI_TEXTURE = Identifier.of(Snailspeed.MOD_ID, "textures/gui/container/small_barrel_gui.png");
    private final PlayerInventory playerInventory;
    public SmallBarrelScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.playerInventory = inventory;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(RenderLayer::getGuiTextured, GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(textRenderer, title, 8, 6, 0x404040, false);
        context.drawText(textRenderer, playerInventory.getDisplayName(), 8, 38, 0x404040, false);
    }



    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
