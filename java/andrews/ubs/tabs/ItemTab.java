package andrews.ubs.tabs;

import andrews.ubs.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
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
		return new ItemStack(ItemInit.CHOPSTICKS);
	}
}
