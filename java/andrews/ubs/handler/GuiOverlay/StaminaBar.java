package andrews.ubs.handler.GuiOverlay;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.capabilities.stamina.StaminaProvider;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.IStamina;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class StaminaBar extends Gui
{
	
	private final ResourceLocation BAR = new ResourceLocation(Reference.MODID + ":textures/gui/stamina_bar.png");
	private final int tex_width = 102;
	private final int tex_height = 11;
	
//To Load the stamina bar
	@SubscribeEvent
	public void onRenderGameOverlayBar(RenderGameOverlayEvent.Text event) //Stamina Bar and Number
	{
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) 
		{		
			Minecraft mc = Minecraft.getMinecraft();
			
			IStamina stamina = mc.thePlayer.getCapability(StaminaProvider.STAMINA_CAP, null);
			
		//To set the Position of the Bar and Number	
			int posX = event.getResolution().getScaledWidth() / 2 + 92;
			int posY = event.getResolution().getScaledHeight() - 12;
			
		//The Values For The Number
			int maxStaminaValue = (int) stamina.getMaxStamina();
			int staminaValue = (int) stamina.getStamina();
			
		//How Much of the Bar Should be Rendered
			float points = stamina.getStamina();
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
					GL11.glColor4f(0F, 0F, 0F, 1F);
					mc.fontRendererObj.drawString(staminaValue + "/" + maxStaminaValue, posX + 5, posY + 2, Color.BLACK.getRGB());
					GL11.glColor4f(1F, 1F, 1F, 1F);
					GlStateManager.popAttrib();
					GlStateManager.popMatrix();
				}
			}
		}
	}
}