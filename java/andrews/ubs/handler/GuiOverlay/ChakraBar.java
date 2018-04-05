package andrews.ubs.handler.GuiOverlay;

import java.awt.Color;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.White;
import org.lwjgl.opengl.GL11;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.utils.IChakra;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChakraBar extends Gui
{
	
	private final ResourceLocation BAR = new ResourceLocation(Reference.MODID + ":textures/gui/chakra_bar.png");
	private final int tex_width = 102;
	private final int tex_height = 11;
	
//To Load the stamina bar
	@SubscribeEvent
	public void onRenderGameOverlayBar(RenderGameOverlayEvent.Text event) //Chakra Bar and Number
	{
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) 
		{		
			Minecraft mc = Minecraft.getMinecraft();
			
			IChakra chakra = mc.thePlayer.getCapability(ChakraProvider.CHAKRA_CAP, null);
			
		//To set the Position of the Bar and Number
			int posXNumber = event.getResolution().getScaledWidth() / 2 + 180;
			int posYNumber = event.getResolution().getScaledHeight() + 39;		
			int posX = event.getResolution().getScaledWidth() / 2 + 92;
			int posY = event.getResolution().getScaledHeight() - 22;
			
		//The Values For The Number
			int maxChakraValue = (int) chakra.getMaxChakra();
			int chakraValue = (int) chakra.getChakra();
			
		//How Much of the Bar Should be Rendered
			float points = chakra.getChakra();
			int texture_width = (int) (points);
			
			mc.renderEngine.bindTexture(BAR);
			
			if(mc.thePlayer != null)
			{
				if(!mc.thePlayer.isCreative()) 
				{
					drawTexturedModalRect(posX, posY, 0, 0, tex_width, tex_height);			    //The Bar
					drawTexturedModalRect(posX + 1, posY + 1, 0, 11, texture_width, tex_height);
					
					GlStateManager.pushMatrix();												//The Number
					GlStateManager.pushAttrib();
					GlStateManager.disableDepth();
					mc.fontRendererObj.drawString(chakraValue + "/" + maxChakraValue, posX + 5, posY + 2, Color.BLACK.getRGB());
					GL11.glColor4f(1F, 1F, 1F, 1F);
					GlStateManager.popAttrib();
					GlStateManager.popMatrix();
				}
			}
		}
	}
}