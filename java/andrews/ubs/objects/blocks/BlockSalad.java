package andrews.ubs.objects.blocks;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockSalad extends BlockCrops
{	
	public BlockSalad(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		
		BlockInit.BLOCKS.add(this);
	}
	
//Sets the Seed Drop
	@Override
	protected Item getSeed()
	{
		return ItemInit.SALAD;
	}
	
//Sets the Crop Drop
	@Override
	protected Item getCrop()
	{
		return ItemInit.SALAD;
	}
}
