package andrews.ubs.blocks;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class BlockAvocadoStairs extends BlockStairs {
	
	public BlockAvocadoStairs(String name) {
		super(Blocks.COAL_BLOCK.getDefaultState());
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
		this.useNeighborBrightness = true;
		this.setSoundType(SoundType.WOOD);
		setHardness(2);

	}

}
