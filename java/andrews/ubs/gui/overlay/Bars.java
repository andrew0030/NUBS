package andrews.ubs.gui.overlay;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.entity.EntityCrab;
import andrews.ubs.init.EntityInit;
import andrews.ubs.network.PacketHandler;
import andrews.ubs.network.message.server.MessageSandCloudParticles;
import andrews.ubs.util.interfaces.INinja;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiOverlayDebug;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.PostConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Bars extends Gui
{
	
	private final ResourceLocation BARS = new ResourceLocation(Reference.MODID + ":textures/gui/bars.png");
	private final int tex_width = 102;
	private final int tex_height = 11;
	
//To Load the stamina bar
	@SubscribeEvent
	public void onRenderGameOverlayBar(RenderGameOverlayEvent.Pre event) //Bars and Numbers
	{
		if(event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) 
		{		
			Minecraft mc = Minecraft.getMinecraft();
			
			INinja ninjaCap = mc.player.getCapability(NinjaProvider.NINJA_CAP, null);
			
		//To set the Position of the Bar and Number
			int posXMain = event.getResolution().getScaledWidth() - event.getResolution().getScaledWidth() + 5;
			int posYMain = event.getResolution().getScaledHeight() - event.getResolution().getScaledHeight() + 5;	
			int posXBars = event.getResolution().getScaledWidth() - event.getResolution().getScaledWidth() + 37;
			int posYBars = event.getResolution().getScaledHeight() - event.getResolution().getScaledHeight() + 9;	
			
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
				if(!mc.player.isCreative() && !mc.player.isSpectator()) 
				{	
					EntityPlayer player = mc.player;
					mc.renderEngine.bindTexture(BARS);
		            drawTexturedModalRect(posXBars + 10, posYBars, 0, 32, tex_width, tex_height);
					drawTexturedModalRect(posXBars + 11, posYBars, 0, 55, texture_width_chakra, tex_height);
					drawTexturedModalRect(posXBars, posYBars + 12, 0, 44, tex_width, tex_height);			    
					drawTexturedModalRect(posXBars + 1, posYBars + 12, 0, 66, texture_width_stamina, tex_height);
					
					GlStateManager.pushMatrix();
					GlStateManager.pushAttrib();
					GlStateManager.translate(0, 0, -80);
					drawTexturedModalRect(posXMain, posYMain, 0, 0, 31, 31);
		            GuiInventory.drawEntityOnScreen(posXMain + 16, posYMain + 29, 14, -30F, -10F, player);
		            GlStateManager.popAttrib();
		            GlStateManager.popMatrix();
		            
		            mc.fontRenderer.drawString(chakraValue + "/" + maxChakraValue, posXBars + 20, posYBars + 2, Color.BLACK.getRGB());
					mc.fontRenderer.drawString(staminaValue + "/" + maxStaminaValue, posXBars + 9, posYBars + 14, Color.BLACK.getRGB());
				}
			}
		}
	}
}