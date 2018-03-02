package andrews.ubs.tabs;

import andrews.ubs.init.UltimateBlockStormBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class UltimateBlockStormBlockTab extends CreativeTabs
{

	public UltimateBlockStormBlockTab() 
	{
		super("UBS Blocks");
		this.setBackgroundImageName("items.png");
	}

	@Override
	public Item getTabIconItem() 
	{
		return Item.getItemFromBlock(UltimateBlockStormBlocks.log);
		
	}
	
	@Override
	public boolean hasSearchBar()
	{
		return false;
	}

}
