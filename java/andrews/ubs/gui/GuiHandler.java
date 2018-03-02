package andrews.ubs.gui;

import andrews.ubs.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID)
		{
		case Reference.BACKPACK:
			return new ContainerBackpack(player.inventory, new InventoryBackpack(player.inventory.getCurrentItem()), player);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch(ID)
		{
		case Reference.BACKPACK:
			return new GuiBackpack(new InventoryBackpack(player.inventory.getCurrentItem()));
		}
		return null;
	}
	
}
