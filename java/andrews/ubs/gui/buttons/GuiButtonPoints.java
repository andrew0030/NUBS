package andrews.ubs.gui.buttons;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.stats.StatsProvider;
import andrews.ubs.util.interfaces.IStats;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;

public class GuiButtonPoints extends GuiButton
{
	private final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/main_buttons.png");
	
	private int buttonWidth = 9;
	private int buttonHeight = 7;
	private int u = 126;
	private int v = 0;
	
	public boolean active;
	
	public GuiButtonPoints(int buttonId, int x, int y)
	{
		super(buttonId, x, y, 9, 7, "");
	}
	
	@Override
	public void playPressSound(SoundHandler soundHandlerIn)
	{
		if(this.active == true)
		{
			soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0F));
		}
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{			
		IStats statsCap = mc.player.getCapability(StatsProvider.STATS_CAP, null);
		
		if(visible)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			if(mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height || statsCap.getAvPoint() == 0)
			{
				hovered = true;
			}
			else
			{
				hovered = false;
			}
			
			//Used to set active for the play sound
			if(statsCap.getAvPoint() == 0 && this.active == true)
			{
				this.active = false;
			}
			else if(statsCap.getAvPoint() > 0 && this.active == false)
			{
				this.active = true;
			}
			
			//change the texture pick position so the texture of the button changes
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