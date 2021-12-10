
package net.mcreator.betamodalpha.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.betamodalpha.BetamodAlphaMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MenuGuiWindow extends ContainerScreen<MenuGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = MenuGui.guistate;
	public MenuGuiWindow(MenuGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("betamod_alpha:textures/menu.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betamod_alpha:textures/ca_marche_ou_pas.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + -1, 0, 0, 178, 141, 178, 141);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Wolfy mod version alpha1", 30, 6, -26215);
		this.font.drawString(ms, "cliquez sur le bouton pour voir", 3, 111, -3355444);
		this.font.drawString(ms, "les mises \u00E0 jours.", 3, 123, -3355444);
		this.font.drawString(ms, "Testez vos minerais et faites vos", 6, 60, -3355444);
		this.font.drawString(ms, "retour \u00E0 Wolfy", 5, 71, -3355444);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 54, this.guiTop + 18, 55, 20, new StringTextComponent("mourir"), e -> {
			if (true) {
				BetamodAlphaMod.PACKET_HANDLER.sendToServer(new MenuGui.ButtonPressedMessage(0, x, y, z));
				MenuGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 86, 80, 20, new StringTextComponent("mise à jour"), e -> {
			if (true) {
				BetamodAlphaMod.PACKET_HANDLER.sendToServer(new MenuGui.ButtonPressedMessage(1, x, y, z));
				MenuGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
