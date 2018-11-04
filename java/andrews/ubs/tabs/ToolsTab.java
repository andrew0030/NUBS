package andrews.ubs.tabs;

import andrews.ubs.init.ItemInit;
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
		return new ItemStack(ItemInit.TRIPLE_BLADED_SCYTHE);
	}
}
