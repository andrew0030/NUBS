package andrews.ubs.gui.overlay;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.util.interfaces.INinja;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Bars extends Gui
{
	
	private final ResourceLocation CHAKRA_BAR = new ResourceLocation(Reference.MODID + ":textures/gui/chakra_bar.png");
	private final ResourceLocation STAMINA_BAR = new ResourceLocation(Reference.MODID + ":textures/gui/stamina_bar.png");
	private final int tex_width = 102;
	private final int tex_height = 11;
	
//To Load the stamina bar
	@SubscribeEvent
	public void onRenderGameOverlayBar(RenderGameOverlayEvent.Text event) //Bars and Numbers
	{
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) 
		{		
			Minecraft mc = Minecraft.getMinecraft();
			
			INinja ninjaCap = mc.player.getCapability(NinjaProvider.NINJA_CAP, null);
			
		//To set the Position of the Bar and Number
			int posXNumber = event.getResolution().getScaledWidth() / 2 + 180;
			int posYNumber = event.getResolution().getScaledHeight() + 39;		
			int posX = event.getResolution().getScaledWidth() / 2 + 92;
			int posY = event.getResolution().getScaledHeight() - 22;
			
		//The Values For The Number
			int maxChakraValue = (int) ninjaCap.getMaxChakra();
			int chakraValue = (int) ninjaCap.getChakra();
			
		//How Much of the Bar Should be Rendered
			float points = ninjaCap.getChakra();
			int texture_width = (int) (points);
			
			mc.renderEngine.bindTexture(CHAKRA_BAR);
			mc.renderEngine.bindTexture(STAMINA_BAR);
			
			if(mc.player != null)
			{
				if(!mc.player.isCreative()) 
				{
					drawTexturedModalRect(posX, posY, 0, 0, tex_width, tex_height);			    //The Bar
					drawTexturedModalRect(posX + 1, posY + 1, 0, 11, texture_width, tex_height);
					
					GlStateManager.pushMatrix();												//The Number
					GlStateManager.pushAttrib();
					GlStateManager.disableDepth();
					mc.fontRenderer.drawString(chakraValue + "/" + maxChakraValue, posX + 5, posY + 2, Color.BLACK.getRGB());
					GL11.glColor4f(1F, 1F, 1F, 1F);
					GlStateManager.popAttrib();
					GlStateManager.popMatrix();
				}
			}
		}
	}
}