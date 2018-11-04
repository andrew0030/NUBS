package andrews.ubs.objects.blocks;

import andrews.ubs.Main;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.objects.blocks.item.ItemBlockSlab;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class BlockAvocadoSlabHalf extends BlockAvocadoSlab implements IHasModel
{
	public BlockAvocadoSlabHalf(String name)
	{
		super(name);
		
		ItemInit.ITEMS.add(new ItemBlockSlab(BlockInit.AVOCADO_SLAB_HALF, BlockInit.AVOCADO_SLAB_HALF, BlockInit.AVOCADO_SLAB_DOUBLE).setRegistryName(name));
	}

	@Override
	public boolean isDouble()
	{
		return false;
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
