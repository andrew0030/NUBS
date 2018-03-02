package andrews.ubs.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNetherChakraOre extends Block
{
	public BlockNetherChakraOre(String name)
	{
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
		this.setHardness(3);
	}
	
//this is used to set the tool type (shovel, pickaxe, axe...)
	@Override
	public String getHarvestTool(IBlockState state)
	{
		return "pickaxe";
	}
	
//this is used to set the Tool level(Wood, Stone, Iron...)
	@Override
	public int getHarvestLevel(IBlockState state)
	{
		return 2;
	}
}
