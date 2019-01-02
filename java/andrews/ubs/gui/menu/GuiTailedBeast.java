package andrews.ubs.gui.menu;

import java.awt.Color;
import java.io.IOException;

import andrews.ubs.Reference;
import andrews.ubs.gui.buttons.GuiButtonClan;
import andrews.ubs.gui.buttons.GuiButtonJutsus;
import andrews.ubs.gui.buttons.GuiButtonNinjaAnimal;
import andrews.ubs.gui.buttons.GuiButtonParty;
import andrews.ubs.gui.buttons.GuiButtonStats;
import andrews.ubs.gui.buttons.GuiButtonTailedBeast;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiTailedBeast extends GuiScreen
{
	
	private final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/menus/menu.png");
	private final ResourceLocation scroll = new ResourceLocation(Reference.MODID + ":textures/gui/menus/scrolls.png");
	
	private final int tex_width = 256;
	private final int tex_height = 180;
	private final int scroll_width = 39;
	private final int scroll_height = 199;
	
	private GuiButtonStats stats;
	private GuiButtonJutsus jutsus;
	private GuiButtonTailedBeast tailedBeast;
	private GuiButtonClan clan;
	private GuiButtonParty party;
	private GuiButtonNinjaAnimal ninjaAnimal;
	
	private final int STATS = 0;
	private final int JUTSUS = 1;
	private final int TAILED_BEAST = 2;
	private final int CLAN = 3;
	private final int PARTY = 4;
	private final int NINJA_ANIMAL = 5;
	
//Draw the GUI
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
//		super.drawScreen(mouseX, mouseY, partialTicks);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(texture);
		int centerX = (width / 2) - tex_width / 2;
		int centerY = (height / 2) - tex_height / 2; 
		drawTexturedModalRect(centerX, centerY, 0, 0, tex_width, tex_height);
		mc.renderEngine.bindTexture(scroll);
		drawTexturedModalRect(centerX + 255, centerY - 9, 39, 0, scroll_width, scroll_height);
		drawTexturedModalRect(centerX - 38, centerY - 9, 0, 0, scroll_width, scroll_height);
		
		drawTexturedModalRect(centerX - 37, centerY + 75, 0, 199, 37, 9);
		stats.drawButton(mc, mouseX, mouseY, partialTicks);
		jutsus.drawButton(mc, mouseX, mouseY, partialTicks);
		tailedBeast.drawButton(mc, mouseX, mouseY, partialTicks);
		clan.drawButton(mc, mouseX, mouseY, partialTicks);
		party.drawButton(mc, mouseX, mouseY, partialTicks);
		ninjaAnimal.drawButton(mc, mouseX, mouseY, partialTicks);
		
		mc.fontRenderer.drawString("Tailed Beasts (WIP)", centerX + 4, centerY + 6, Color.BLACK.getRGB());
	}
	
//Gets called every time the GUI updates (screen rescale, fullscreen mode...) 
	@Override
	public void initGui()
	{
		buttonList.clear();
		buttonList.add(stats = new GuiButtonStats(STATS, (width / 2) - 157, (height / 2) - 65));
		buttonList.add(jutsus = new GuiButtonJutsus(JUTSUS, (width / 2) - 157, (height / 2) - 43));
		buttonList.add(tailedBeast = new GuiButtonTailedBeast(TAILED_BEAST, (width / 2) - 157, (height / 2) - 21));
		tailedBeast.active = true;
		buttonList.add(clan = new GuiButtonClan(CLAN, (width / 2) - 157, (height / 2) + 1));
		buttonList.add(party = new GuiButtonParty(PARTY, (width / 2) - 157, (height / 2) + 23));
		buttonList.add(ninjaAnimal = new GuiButtonNinjaAnimal(NINJA_ANIMAL, (width / 2) - 157, (height / 2) + 45));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		switch(button.id)
		{
		case STATS:
			Minecraft.getMinecraft().displayGuiScreen(new GuiStats());
			break;
		case JUTSUS:
			Minecraft.getMinecraft().displayGuiScreen(new GuiJutsus());
			break;
		case TAILED_BEAST:
			Minecraft.getMinecraft().displayGuiScreen(new GuiTailedBeast());
			break;
		case CLAN:
			Minecraft.getMinecraft().displayGuiScreen(new GuiClan());
			break;
		case PARTY:
			Minecraft.getMinecraft().displayGuiScreen(new GuiParty());
			break;
		case NINJA_ANIMAL:
			Minecraft.getMinecraft().displayGuiScreen(new GuiNinjaAnimal());
			break;
		}
		super.actionPerformed(button);
	}
	
//Checks if a key was typed
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
