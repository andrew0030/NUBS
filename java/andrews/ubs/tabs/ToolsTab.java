package andrews.ubs.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ToolsTab extends CreativeTabs
{
	public ToolsTab(String label)
	{
		super("UBS Tools");
		this.setBackgroundImageName("items.png");
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(Items.DIAMOND_SWORD);
	}
}
