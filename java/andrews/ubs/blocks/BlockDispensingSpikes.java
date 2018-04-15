package andrews.ubs.blocks;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class BlockDispensingSpikes extends Block
{
	public static final PropertyDirection FACING = BlockDirectional.FACING;
	public static final PropertyBool ACTIVE = PropertyBool.create("active");
	
	public BlockDispensingSpikes(String name)
	{
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
		setSoundType(SoundType.STONE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, Boolean.valueOf(false)));
	}
}
