package andrews.ubs.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockTab extends CreativeTabs
{
	public BlockTab(String label)
	{
		super("UBS Blocks");
		this.setBackgroundImageName("items.png");
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK));
	}
}
