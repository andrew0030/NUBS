package andrews.ubs.gui.buttons;

import andrews.ubs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonPoints extends GuiButton
{
	private final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/main_buttons.png");
	
	private int buttonWidth = 7;
	private int buttonHeight = 7;
	private int u = 126;
	private int v = 0;
	
	public boolean active = false;
	
	public GuiButtonPoints(int buttonId, int x, int y)
	{
		super(buttonId, x, y, 7, 7, "");
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{		
		if(visible)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			if(mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height)
			{
				hovered = true;
			}
			else
			{
				hovered = false;
			}
			
			if(hovered)
			{
				v = 7;
			}
			else
			{
				v = 0;
			}
			drawTexturedModalRect(x, y, u, v, width, height);
		}
	}
}