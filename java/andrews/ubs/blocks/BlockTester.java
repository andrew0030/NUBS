package andrews.ubs.blocks;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTester extends Block
{
	
	public BlockTester(String name)
	{
		super(Material.AIR);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
	}
	
//this is used so the block will not render the pixels without a texture black
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
	
//this is used so we can see the blocks around this one, without rendering problems
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
		
//this is used to get rid of the shadows
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
	{
		return NULL_AABB;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{
		if(entityIn instanceof EntityPlayer)
		{
			String message = String.format("Block now Active");

	        entityIn.addChatMessage(new TextComponentString(message));
	        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
	}
}
