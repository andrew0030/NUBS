package andrews.ubs.handlers;

import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class UBSFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
	//Chopsticks
		if(fuel.getItem().equals(ItemInit.CHOPSTICKS))
		{
			return 200;
		}
	//Chakra Infused Stairs
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_STAIRS)))
		{
			return 300;
		}
	//Avocado Stairs
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.AVOCADO_STAIRS)))
		{
			return 300;
		}
	//Avocado Button
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.AVOCADO_BUTTON)))
		{
			return 100;
		}
	//Chakra Infused Button
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_BUTTON)))
		{
			return 100;
		}
	//Chakra Infused Door
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_DOOR)))
		{
			return 200;
		}
	//Avocado Door
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.AVOCADO_DOOR)))
		{
			return 200;
		}
	//Chakra Infused Fence
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_FENCE)))
		{
			return 300;
		}
	//Avocado Fence
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.AVOCADO_FENCE)))
		{
			return 300;
		}
	//Chakra Infused Fencegate
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_FENCE_GATE)))
		{
			return 300;
		}
	//Avocado Fencegate
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.AVOCADO_FENCE_GATE)))
		{
			return 300;
		}
	//Chakra Infused Ladder
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_LADDER)))
		{
			return 300;
		}
	//Avocado Ladder
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.AVOCADO_LADDER)))
		{
			return 300;
		}
	//Chakra Infused Pressure Plate
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_PRESSURE_PLATE)))
		{
			return 300;
		}
	//Avocado Pressure Plate
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.AVOCADO_PRESSURE_PLATE)))
		{
			return 300;
		}
	//Chakra Infused Trapdoor
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_TRAPDOOR)))
		{
			return 300;
		}
	//Avocado Trapdoor
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.AVOCADO_TRAPDOOR)))
		{
			return 300;
		}
	//Chakra Infused Slab
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_SLAB_HALF)))
		{
			return 150;
		}
	//Avocado Slab
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.AVOCADO_SLAB_HALF)))
		{
			return 150;
		}
	//Chakra Infused Planks
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.PLANKS)))
		{
			return 300;
		}
	//Avocado Log
		if(fuel.getItem().equals(Item.getItemFromBlock(BlockInit.LOG)))
		{
			return 300;
		}
		return 0;
	}
}
