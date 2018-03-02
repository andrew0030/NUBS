package andrews.ubs.blocks;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.util.ResourceLocation;

public class BlockAvocadoLadder extends BlockLadder 
{
	
	public BlockAvocadoLadder(String name) 
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
		this.setSoundType(SoundType.WOOD);
	}

}
