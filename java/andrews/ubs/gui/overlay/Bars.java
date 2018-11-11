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
	public void onRenderGameOverlayBar(RenderGameOverlayEvent event) //Bars and Numbers
	{
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) 
		{		
			Minecraft mc = Minecraft.getMinecraft();
			
			INinja ninjaCap = mc.player.getCapability(NinjaProvider.NINJA_CAP, null);
			
		//To set the Position of the Bar and Number
			int posXchakra = event.getResolution().getScaledWidth() / 2 + 92;
			int posYchakra = event.getResolution().getScaledHeight() - 22;	
			int posXstamina = event.getResolution().getScaledWidth() / 2 + 92;
			int posYstamina = event.getResolution().getScaledHeight() - 12;
			
		//The Values For The Number
			int maxChakraValue = (int) ninjaCap.getMaxChakra();
			int chakraValue = (int) ninjaCap.getChakra();
			int maxStaminaValue = (int) ninjaCap.getMaxStamina();
			int staminaValue = (int) ninjaCap.getStamina();
			
		//How Much of the Bar Should be Rendered
			int texture_width_chakra = (int) Math.floor(ninjaCap.getChakra() / ninjaCap.getMaxChakra() * 100);
			int texture_width_stamina = (int) Math.floor(ninjaCap.getStamina() / ninjaCap.getMaxStamina() * 100);
			
			if(mc.player != null)
			{
				if(!mc.player.isCreative()) 
				{	
					GlStateManager.pushMatrix();												
					GlStateManager.pushAttrib();
					GlStateManager.disableDepth();
					mc.renderEngine.bindTexture(CHAKRA_BAR);
					drawTexturedModalRect(posXchakra, posYchakra, 0, 0, tex_width, tex_height);			    
					drawTexturedModalRect(posXchakra + 1, posYchakra + 1, 0, 11, texture_width_chakra, tex_height);
					mc.renderEngine.bindTexture(STAMINA_BAR);
					drawTexturedModalRect(posXstamina, posYstamina, 0, 0, tex_width, tex_height);			    
					drawTexturedModalRect(posXstamina + 1, posYstamina + 1, 0, 11, texture_width_stamina, tex_height);
					GL11.glColor4f(0F, 0F, 0F, 1F);
					mc.fontRenderer.drawString(chakraValue + "/" + maxChakraValue, posXchakra + 5, posYchakra + 2, Color.BLACK.getRGB());
					mc.fontRenderer.drawString(staminaValue + "/" + maxStaminaValue, posXstamina + 5, posYstamina + 2, Color.BLACK.getRGB());
					GL11.glColor4f(1F, 1F, 1F, 1F);
					GlStateManager.popAttrib();
					GlStateManager.popMatrix();
				}
			}
		}
	}
}