package andrews.ubs.tabs;

import andrews.ubs.init.UltimateBlockStormTools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class UltimateBlockStormToolsTab extends CreativeTabs{

	public UltimateBlockStormToolsTab() {
		super("UBS Tools");
		this.setBackgroundImageName("items.png");

	}

	@Override
	public Item getTabIconItem() {
		return UltimateBlockStormTools.kitchen_knife;
		
	}
	
	@Override
	public boolean hasSearchBar() {
		return false;
	}

}
