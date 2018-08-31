package andrews.ubs.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class FoodTab extends CreativeTabs
{
	public FoodTab(String label)
	{
		super("UBS Foods");
		this.setBackgroundImageName("items.png");
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(Items.PORKCHOP);
	}
}
