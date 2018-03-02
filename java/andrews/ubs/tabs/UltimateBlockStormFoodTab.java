package andrews.ubs.tabs;

import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class UltimateBlockStormFoodTab extends CreativeTabs{

	public UltimateBlockStormFoodTab() {
		super("UBS Foods");
		this.setBackgroundImageName("items.png");

	}

	@Override
	public Item getTabIconItem() {
		return UltimateBlockStormItems.ramen;
		
	}
	
	@Override
	public boolean hasSearchBar() {
		return false;
	}

}
