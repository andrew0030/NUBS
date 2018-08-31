package andrews.ubs.objects.blocks;

import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;

public class BlockAvocadoSlabHalf extends BlockAvocadoSlab
{
	public BlockAvocadoSlabHalf(String name)
	{
		super(name);
		
//		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
		ItemInit.ITEMS.add(new ItemSlab(BlockInit.AVOCADO_SLAB_HALF, BlockInit.AVOCADO_SLAB_DOUBLE, BlockInit.AVOCADO_SLAB_HALF).setRegistryName(name));
	}

	@Override
	public boolean isDouble()
	{
		return false;
	}

}
