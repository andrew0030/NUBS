package andrews.ubs.objects.blocks;

import andrews.ubs.Main;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class BlockChakraInfusedSlabDouble extends BlockAvocadoSlab
{
	public BlockChakraInfusedSlabDouble(String name)
	{
		super(name);
	}

	@Override
	public boolean isDouble()
	{
		return true;
	}
}
