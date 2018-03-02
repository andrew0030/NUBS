package andrews.ubs.handler.GuiOverlay;

import andrews.ubs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HighJumpsButton extends Gui
{
	
	private final ResourceLocation BUTTON = new ResourceLocation(Reference.MODID + ":textures/gui/gui_buttons.png");
	private final int tex_width = 16;
	private final int tex_height = 16;
	
//To Load the stamina bar
	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent event) 
	{
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) 
		{
		//To set the position
			int posX = event.getResolution().getScaledWidth() / 2 + 92;
			int posY = event.getResolution().getScaledHeight() - 39;
			
			Minecraft mc = Minecraft.getMinecraft();
			mc.renderEngine.bindTexture(BUTTON);
			
			float oneUnit = (float)16 / mc.thePlayer.getMaxHealth();
			int currentWidth = (int)(oneUnit * mc.thePlayer.getHealth());
			
			if(!mc.thePlayer.isCreative()) 
			{
				drawTexturedModalRect(posX, posY, 0, 0, tex_width, tex_height);
				drawTexturedModalRect(posX, posY, 0, 17, currentWidth, tex_height);
			}
			else if(mc.thePlayer.isCreative())
			{
				drawTexturedModalRect(posX, posY + 22, 0, 0, tex_width, tex_height);
				drawTexturedModalRect(posX, posY + 22, 0, 17, currentWidth, tex_height);
			}
		}
	}
}