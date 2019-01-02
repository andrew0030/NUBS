package andrews.ubs.gui.menu;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.opengl.GLSync;

import andrews.ubs.Reference;
import andrews.ubs.gui.buttons.GuiButtonClan;
import andrews.ubs.gui.buttons.GuiButtonJutsus;
import andrews.ubs.gui.buttons.GuiButtonNinjaAnimal;
import andrews.ubs.gui.buttons.GuiButtonParty;
import andrews.ubs.gui.buttons.GuiButtonPoints;
import andrews.ubs.gui.buttons.GuiButtonStats;
import andrews.ubs.gui.buttons.GuiButtonTailedBeast;
import andrews.ubs.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiStats extends GuiScreen
{
	
	private final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/menus/menu.png");
	private final ResourceLocation scroll = new ResourceLocation(Reference.MODID + ":textures/gui/menus/scrolls.png");
	private final ResourceLocation button = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/main_buttons.png");
	
	private final int tex_width = 256;
	private final int tex_height = 180;
	private final int scroll_width = 39;
	private final int scroll_height = 199;
	
	//Buttons to change menu
	private GuiButtonStats stats;
	private GuiButtonJutsus jutsus;
	private GuiButtonTailedBeast tailedBeast;
	private GuiButtonClan clan;
	private GuiButtonParty party;
	private GuiButtonNinjaAnimal ninjaAnimal;
	//Buttons to add points
	private GuiButtonPoints strength;
	private GuiButtonPoints defense;
	private GuiButtonPoints chakra;
	private GuiButtonPoints meditation;
	private GuiButtonPoints ninjutsu;
	private GuiButtonPoints taijutsu;
	private GuiButtonPoints genjutsu;
	
	//Button Ids to change menu
	private final int STATS = 0;
	private final int JUTSUS = 1;
	private final int TAILED_BEAST = 2;
	private final int CLAN = 3;
	private final int PARTY = 4;
	private final int NINJA_ANIMAL = 5;
	//Button Ids to add points
	private final int STRENGHT = 6;
	private final int DEFENSE = 7;
	private final int CHAKRA = 8;
	private final int MEDITATION = 9;
	private final int NINJUTSU = 10;
	private final int TAIJUTSU = 11;
	private final int GENJUTSU = 12;
	
//Draw the GUI
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
//		super.drawScreen(mouseX, mouseY, partialTicks);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(texture);
		int centerX = (width / 2) - tex_width / 2;
		int centerY = (height / 2) - tex_height / 2; 
	//Main menu texture
		drawTexturedModalRect(centerX, centerY, 0, 0, tex_width, tex_height);
	//Left and Right scroll
		mc.renderEngine.bindTexture(scroll);
		drawTexturedModalRect(centerX + 255, centerY - 9, 39, 0, scroll_width, scroll_height);
		drawTexturedModalRect(centerX - 38, centerY - 9, 0, 0, scroll_width, scroll_height);
		
	//Experience bar
		mc.renderEngine.bindTexture(button);
		drawTexturedModalRect(centerX + 4, centerY + 22, 0, 42, 202, 5);
		//Light green bar
		drawTexturedModalRect(centerX + 5, centerY + 23, 0, 47, 40, 3);
				
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		GlStateManager.translate(centerX + 140, centerY + 16, 0);
		GlStateManager.scale(0.7, 0.7, 0.7);
		mc.fontRenderer.drawStringWithShadow("§lEXP:20/100", 0, 0, 0x37b742);
		GlStateManager.color(1, 1, 1);
		GlStateManager.popAttrib();
		GlStateManager.popMatrix();
		
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		GlStateManager.translate(centerX + 207, centerY + 22, 0);
		GlStateManager.scale(0.7, 0.7, 0.7);
		mc.fontRenderer.drawStringWithShadow("§lLvl:5", 0, 0, 0xcecaca);
		GlStateManager.color(1, 1, 1);
		GlStateManager.popAttrib();
		GlStateManager.popMatrix();
		
	//Costume buttons
		mc.renderEngine.bindTexture(scroll);
		drawTexturedModalRect(centerX - 37, centerY + 31, 0, 199, 37, 9);
		stats.drawButton(mc, mouseX, mouseY, partialTicks);
		jutsus.drawButton(mc, mouseX, mouseY, partialTicks);
		tailedBeast.drawButton(mc, mouseX, mouseY, partialTicks);
		clan.drawButton(mc, mouseX, mouseY, partialTicks);
		party.drawButton(mc, mouseX, mouseY, partialTicks);
		ninjaAnimal.drawButton(mc, mouseX, mouseY, partialTicks);
		//Points buttons
		strength.drawButton(mc, mouseX, mouseY, partialTicks);
		defense.drawButton(mc, mouseX, mouseY, partialTicks);
		chakra.drawButton(mc, mouseX, mouseY, partialTicks);
		meditation.drawButton(mc, mouseX, mouseY, partialTicks);
		ninjutsu.drawButton(mc, mouseX, mouseY, partialTicks);
		taijutsu.drawButton(mc, mouseX, mouseY, partialTicks);
		genjutsu.drawButton(mc, mouseX, mouseY, partialTicks);
		
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		GlStateManager.translate((width / 2) - 10, (height / 2) - 58, 0);
		GlStateManager.scale(2, 2, 2);
		GlStateManager.enableLight(0);
		mc.getRenderItem().renderItemIntoGUI(new ItemStack(ItemInit.RAMEN), 0, 0);
		GlStateManager.popAttrib();
		GlStateManager.popMatrix();
		
		mc.fontRenderer.drawString("Stats (WIP)", centerX + 4, centerY + 6, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("name: " + mc.player.getName(), centerX + 4, centerY + 14, Color.BLACK.getRGB());
		
		int fontPosX = centerX + 12;
		int fontPosY = centerY + 103;
		//Available points
		mc.fontRenderer.drawString("Available Points: 10", fontPosX - 8, fontPosY - 9, Color.BLACK.getRGB());
		
		//All the stats names
		mc.fontRenderer.drawString("Strength", fontPosX, fontPosY, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Defense", fontPosX, fontPosY + 9, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Chakra", fontPosX, fontPosY + 18, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Meditation", fontPosX, fontPosY + 27, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Ninjutsu", fontPosX, fontPosY + 36, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Taijutsu", fontPosX, fontPosY + 45, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Genjutsu", fontPosX, fontPosY + 54, Color.BLACK.getRGB());
		mc.fontRenderer.drawStringWithShadow("§lTotal", fontPosX - 8, fontPosY + 63, Color.LIGHT_GRAY.getRGB());
		//All the stats levels
		mc.fontRenderer.drawString("Lvl:15", fontPosX + 58, fontPosY, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl:30", fontPosX + 58, fontPosY + 9, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl:35", fontPosX + 58, fontPosY + 18, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl:12", fontPosX + 58, fontPosY + 27, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl:17", fontPosX + 58, fontPosY + 36, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl:4", fontPosX + 58, fontPosY + 45, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl:2", fontPosX + 58, fontPosY + 54, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("§l115", fontPosX + 58, fontPosY + 63, Color.BLACK.getRGB());
	}
	
//Gets called every time the GUI updates (screen rescale, fullscreen mode...) 
	@Override
	public void initGui()
	{
		buttonList.clear();
		buttonList.add(stats = new GuiButtonStats(STATS, (width / 2) - 157, (height / 2) - 65));
		stats.active = true;
		buttonList.add(jutsus = new GuiButtonJutsus(JUTSUS, (width / 2) - 157, (height / 2) - 43));
		buttonList.add(tailedBeast = new GuiButtonTailedBeast(TAILED_BEAST, (width / 2) - 157, (height / 2) - 21));
		buttonList.add(clan = new GuiButtonClan(CLAN, (width / 2) - 157, (height / 2) + 1));
		buttonList.add(party = new GuiButtonParty(PARTY, (width / 2) - 157, (height / 2) + 23));
		buttonList.add(ninjaAnimal = new GuiButtonNinjaAnimal(NINJA_ANIMAL, (width / 2) - 157, (height / 2) + 45));
		//All stats buttons
		buttonList.add(strength = new GuiButtonPoints(STRENGHT, (width / 2) - 124, (height / 2) + 13));
		buttonList.add(defense = new GuiButtonPoints(DEFENSE, (width / 2) - 124, (height / 2) + 22));
		buttonList.add(chakra = new GuiButtonPoints(CHAKRA, (width / 2) - 124, (height / 2) + 31));
		buttonList.add(meditation = new GuiButtonPoints(MEDITATION, (width / 2) - 124, (height / 2) + 40));
		buttonList.add(ninjutsu = new GuiButtonPoints(NINJUTSU, (width / 2) - 124, (height / 2) + 49));
		buttonList.add(taijutsu = new GuiButtonPoints(TAIJUTSU, (width / 2) - 124, (height / 2) + 58));
		buttonList.add(genjutsu = new GuiButtonPoints(GENJUTSU, (width / 2) - 124, (height / 2) + 67));
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
