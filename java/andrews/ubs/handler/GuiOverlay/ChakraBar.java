package andrews.ubs.handler.GuiOverlay;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.utils.IChakra;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChakraBar extends Gui
{
	
	private final ResourceLocation BAR = new ResourceLocation(Reference.MODID + ":textures/gui/chakra_bar.png");
	private final int tex_width = 102;
	private final int tex_height = 10;
	
//To Load the stamina bar
	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent event) 
	{
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) 
		{		
			
			IChakra chakra = Minecraft.getMinecraft().thePlayer.getCapability(ChakraProvider.CHAKRA_CAP, null);
			
		//To set the position
			int posX = event.getResolution().getScaledWidth() / 2 + 92;
			int posY = event.getResolution().getScaledHeight() - 22;
			
			Minecraft mc = Minecraft.getMinecraft();
			mc.renderEngine.bindTexture(BAR);
			
			float points = chakra.getChakra();
			int texture_width = (int) (points);
			
			if(!mc.thePlayer.isCreative()) 
			{
				drawTexturedModalRect(posX, posY, 0, 0, tex_width, tex_height);
				drawTexturedModalRect(posX + 1, posY + 1, 0, 10, texture_width, tex_height);
			}
		}
	}
}