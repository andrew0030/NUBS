package andrews.ubs.gui.buttons;

import andrews.ubs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonJutsus extends GuiButton
{
	private final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/main_buttons.png");
	private final ResourceLocation cover = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/main_buttons_covers.png");
	
	private int buttonWidth = 21;
	private int buttonHeight = 21;
	private int u = 21;
	private int v = 0;
	
	public boolean active = false;
	
	public GuiButtonJutsus(int buttonId, int x, int y)
	{
		super(buttonId, x, y, 21, 21, "");
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{		
		if(visible)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			if(mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height || active == true)
			{
				hovered = true;
			}
			else
			{
				hovered = false;
			}
			
			if(hovered)
			{
				v = 21;
			}
			else
			{
				v = 0;
			}
			drawTexturedModalRect(x, y, u, v, width, height);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(cover);
			GlStateManager.pushMatrix();
			GlStateManager.pushAttrib();
			GlStateManager.translate(x + 3, y + 3, 0);
			GlStateManager.scale(0.2, 0.2, 0.2);
			drawTexturedModalRect(0, 0, 75, 0, 75, 75);
			GlStateManager.popAttrib();
			GlStateManager.popMatrix();
		}
	}
}
