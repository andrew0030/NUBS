package andrews.ubs.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemTab extends CreativeTabs
{
	public ItemTab(String label)
	{
		super("UBS Items");
		this.setBackgroundImageName("items.png");
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(Items.STICK);
	}
}
