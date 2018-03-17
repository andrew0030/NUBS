package andrews.ubs.handler;

import andrews.ubs.init.UltimateBlockStormBlocks;
import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class UltimateBlockStormFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
	//Chopsticks
		if(fuel.getItem().equals(UltimateBlockStormItems.chopsticks))
		{
			return 200;
		}
	//Chakra Infused Stairs
		if(fuel.getItem().equals(Item.getItemFromBlock(UltimateBlockStormBlocks.chakra_infused_stairs)))
		{
			return 300;
		}
	//Avocado Stairs
		if(fuel.getItem().equals(Item.getItemFromBlock(UltimateBlockStormBlocks.avocado_stairs)))
		{
			return 300;
		}
		return 0;
	}
}
