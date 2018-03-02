package andrews.ubs.blocks;

import andrews.ubs.Reference;
import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BlockSalad extends BlockCrops {
	
	public BlockSalad(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		
	}
	
//Sets the Seed Drop
	@Override
	protected Item getSeed() {
		return UltimateBlockStormItems.salad;
	}
	
//Sets the Crop Drop
	@Override
	protected Item getCrop() {
		return UltimateBlockStormItems.salad;
	}

}
