package andrews.ubs.tabs;

import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class UltimateBlockStormItemTab extends CreativeTabs
{
	public UltimateBlockStormItemTab() 
	{
		super("UBS Items");
		this.setBackgroundImageName("items.png");
	}

	@Override
	public Item getTabIconItem() 
	{
		return UltimateBlockStormItems.chopsticks;
	}
}
