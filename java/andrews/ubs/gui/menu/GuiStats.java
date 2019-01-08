package andrews.ubs.gui.menu;

import java.awt.Color;
import java.io.IOException;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.capabilities.stats.StatsProvider;
import andrews.ubs.controlls.KeyBinds;
import andrews.ubs.gui.buttons.GuiButtonClan;
import andrews.ubs.gui.buttons.GuiButtonJutsus;
import andrews.ubs.gui.buttons.GuiButtonNinjaAnimal;
import andrews.ubs.gui.buttons.GuiButtonParty;
import andrews.ubs.gui.buttons.GuiButtonPoints;
import andrews.ubs.gui.buttons.GuiButtonStats;
import andrews.ubs.gui.buttons.GuiButtonTailedBeast;
import andrews.ubs.init.ItemInit;
import andrews.ubs.network.PacketHandler;
import andrews.ubs.network.message.client.MessageStatRaised;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStats;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiStats extends GuiScreen
{
	
	private final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/gui/menus/menu.png");
	private final ResourceLocation scroll = new ResourceLocation(Reference.MODID + ":textures/gui/menus/scrolls.png");
	private final ResourceLocation button = new ResourceLocation(Reference.MODID + ":textures/gui/buttons/main_buttons.png");
	private final ResourceLocation details = new ResourceLocation(Reference.MODID + ":textures/gui/menus/stats_details.png");
	private final ResourceLocation releases = new ResourceLocation(Reference.MODID + ":textures/gui/menus/releases.png");
	
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
	private GuiButtonPoints reserve;
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
	private final int RESERVE = 8;
	private final int MEDITATION = 9;
	private final int NINJUTSU = 10;
	private final int TAIJUTSU = 11;
	private final int GENJUTSU = 12;
	
//Draw the GUI
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		IStats statsCap = mc.player.getCapability(StatsProvider.STATS_CAP, null);
		
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
	//Menu Details (Player background, 3 slots next to player)
		mc.renderEngine.bindTexture(details);
		drawTexturedModalRect(centerX + 23, centerY + 28, 0, 0, 51, 64);
		drawTexturedModalRect(centerX + 4, centerY + 30, 51, 0, 18, 18);
		drawTexturedModalRect(centerX + 4, centerY + 51, 51, 18, 18, 18);
		drawTexturedModalRect(centerX + 4, centerY + 72, 51, 36, 18, 18);
		
	//Player in Menu
		EntityPlayer player = mc.player;
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		GuiInventory.drawEntityOnScreen(centerX + 48, centerY + 85, 26, (mouseX - (centerX + 48)) * -1, (mouseY - (centerY + 42)) * -1, player);
		GlStateManager.popAttrib();
		GlStateManager.popMatrix();
		
	//Experience bar
		mc.renderEngine.bindTexture(button);
		drawTexturedModalRect(centerX + 4, centerY + 22, 0, 42, 202, 5);
		//Light green bar
		drawTexturedModalRect(centerX + 5, centerY + 23, 0, 47, 40, 3);
				
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		GlStateManager.translate(centerX + 140, centerY + 16, 0);
		GlStateManager.scale(0.7, 0.7, 0.7);
		mc.fontRenderer.drawStringWithShadow("\u00A7lEXP:20/100", 0, 0, 0x37b742);
		GlStateManager.color(1, 1, 1);
		GlStateManager.popAttrib();
		GlStateManager.popMatrix();
		
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		GlStateManager.translate(centerX + 207, centerY + 22, 0);
		GlStateManager.scale(0.7, 0.7, 0.7);
		mc.fontRenderer.drawStringWithShadow("\u00A7lLvl:5", 0, 0, 0xcecaca);
		GlStateManager.color(1, 1, 1);
		GlStateManager.popAttrib();
		GlStateManager.popMatrix();
		
	//Releases
		mc.renderEngine.bindTexture(releases);
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		GlStateManager.translate(centerX + 111, centerY + 36, 0);
		GlStateManager.scale(0.25, 0.25, 0.25);
		drawTexturedModalRect(0, 0, 0, 0, 50, 50);//fire
		GlStateManager.translate(54, 0, 0);
		drawTexturedModalRect(0, 0, 50, 0, 50, 50);//air
		GlStateManager.translate(54, 0, 0);
		drawTexturedModalRect(0, 0, 100, 0, 50, 50);//lightning
		GlStateManager.translate(54, 0, 0);
		drawTexturedModalRect(0, 0, 150, 0, 50, 50);//earth
		GlStateManager.translate(54, 0, 0);
		drawTexturedModalRect(0, 0, 200, 0, 50, 50);//water
		GlStateManager.popAttrib();
		GlStateManager.popMatrix();
		
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		mc.fontRenderer.drawString("Releases:", centerX + 111, centerY + 28, Color.BLACK.getRGB());
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
		reserve.drawButton(mc, mouseX, mouseY, partialTicks);
		meditation.drawButton(mc, mouseX, mouseY, partialTicks);
		ninjutsu.drawButton(mc, mouseX, mouseY, partialTicks);
		taijutsu.drawButton(mc, mouseX, mouseY, partialTicks);
		genjutsu.drawButton(mc, mouseX, mouseY, partialTicks);
		
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		GlStateManager.translate((width / 2) + 90, (height / 2) + 50, 0);
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
		mc.fontRenderer.drawString("Available Points: " + (int) statsCap.getAvPoint(), fontPosX - 8, fontPosY - 9, Color.BLACK.getRGB());
		
		//All the stats names
		mc.fontRenderer.drawString("Strength", fontPosX + 4, fontPosY, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Defense", fontPosX + 4, fontPosY + 9, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Chakra", fontPosX + 4, fontPosY + 18, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Meditation", fontPosX + 4, fontPosY + 27, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Ninjutsu", fontPosX + 4, fontPosY + 36, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Taijutsu", fontPosX + 4, fontPosY + 45, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Genjutsu", fontPosX + 4, fontPosY + 54, Color.BLACK.getRGB());
		mc.fontRenderer.drawStringWithShadow("\u00A7lTotal", fontPosX - 8, fontPosY + 63, Color.LIGHT_GRAY.getRGB());
		//All the stats levels
		mc.fontRenderer.drawString("Lvl\u00A78\u00A7l:\u00A70" + (int)statsCap.getStrength(), fontPosX + 58, fontPosY, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl\u00A78\u00A7l:\u00A70" + (int)statsCap.getDefense(), fontPosX + 58, fontPosY + 9, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl\u00A78\u00A7l:\u00A70" + (int)statsCap.getReserve(), fontPosX + 58, fontPosY + 18, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl\u00A78\u00A7l:\u00A70" + (int)statsCap.getMeditation(), fontPosX + 58, fontPosY + 27, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl\u00A78\u00A7l:\u00A70" + (int)statsCap.getNinjutsu(), fontPosX + 58, fontPosY + 36, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl\u00A78\u00A7l:\u00A70" + (int)statsCap.getTaijutsu(), fontPosX + 58, fontPosY + 45, Color.BLACK.getRGB());
		mc.fontRenderer.drawString("Lvl\u00A78\u00A7l:\u00A70" + (int)statsCap.getGenjutsu(), fontPosX + 58, fontPosY + 54, Color.BLACK.getRGB());
		int total = (int)(statsCap.getStrength() + statsCap.getDefense() + statsCap.getReserve() + statsCap.getMeditation() + statsCap.getNinjutsu() + statsCap.getTaijutsu() + statsCap.getGenjutsu());
		mc.fontRenderer.drawString("\u00A7l" + total, fontPosX + 58, fontPosY + 63, Color.BLACK.getRGB());
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
		buttonList.add(reserve = new GuiButtonPoints(RESERVE, (width / 2) - 124, (height / 2) + 31));
		buttonList.add(meditation = new GuiButtonPoints(MEDITATION, (width / 2) - 124, (height / 2) + 40));
		buttonList.add(ninjutsu = new GuiButtonPoints(NINJUTSU, (width / 2) - 124, (height / 2) + 49));
		buttonList.add(taijutsu = new GuiButtonPoints(TAIJUTSU, (width / 2) - 124, (height / 2) + 58));
		buttonList.add(genjutsu = new GuiButtonPoints(GENJUTSU, (width / 2) - 124, (height / 2) + 67));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		Minecraft mc = Minecraft.getMinecraft();
		IStats statsCap = mc.player.getCapability(StatsProvider.STATS_CAP, null);
		switch(button.id)
		{
		case STATS:
			mc.displayGuiScreen(new GuiStats());
			break;
		case JUTSUS:
			mc.displayGuiScreen(new GuiJutsus());
			break;
		case TAILED_BEAST:
			mc.displayGuiScreen(new GuiTailedBeast());
			break;
		case CLAN:
			mc.displayGuiScreen(new GuiClan());
			break;
		case PARTY:
			mc.displayGuiScreen(new GuiParty());
			break;
		case NINJA_ANIMAL:
			mc.displayGuiScreen(new GuiNinjaAnimal());
			break;
		case STRENGHT:
			if(statsCap.getAvPoint() > 0)
			{
				PacketHandler.INSTANCE.sendToServer(new MessageStatRaised((byte) 0));
			}
			break;
		case DEFENSE:
			if(statsCap.getAvPoint() > 0)
			{
				PacketHandler.INSTANCE.sendToServer(new MessageStatRaised((byte) 1));
			}
			break;
		case RESERVE:
			if(statsCap.getAvPoint() > 0)
			{
				PacketHandler.INSTANCE.sendToServer(new MessageStatRaised((byte) 2));
			}
			break;
		case MEDITATION:
			if(statsCap.getAvPoint() > 0)
			{
				PacketHandler.INSTANCE.sendToServer(new MessageStatRaised((byte) 3));
			}
			break;
		case NINJUTSU:
			if(statsCap.getAvPoint() > 0)
			{
				PacketHandler.INSTANCE.sendToServer(new MessageStatRaised((byte) 4));
			}
			break;
		case TAIJUTSU:
			if(statsCap.getAvPoint() > 0)
			{
				PacketHandler.INSTANCE.sendToServer(new MessageStatRaised((byte) 5));
			}
			break;
		case GENJUTSU:
			if(statsCap.getAvPoint() > 0)
			{
				PacketHandler.INSTANCE.sendToServer(new MessageStatRaised((byte) 6));
			}
			break;
		}
		super.actionPerformed(button);
	}
	
//Checks if a key was typed
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		super.keyTyped(typedChar, keyCode);
		if (keyCode == 1 || keyCode == KeyBinds.KEY_MENU.getKeyCode())
		{
            this.mc.player.closeScreen();
		}
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}