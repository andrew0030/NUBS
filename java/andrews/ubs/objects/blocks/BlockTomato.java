package andrews.ubs.objects.blocks;

import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTomato extends BlockCrops
{	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0F, 0F - 0.0625F, 0F, 0.0625F * 16F, 0.0625F * 17F, 0.0625F * 16F);
	
	public BlockTomato(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		
		BlockInit.BLOCKS.add(this);
	}
	
//Sets the Seed Drop
	@Override
	protected Item getSeed()
	{
		return ItemInit.TOMATO_SEEDS;
	}
	
//Sets the Crop Drop
	@Override
	protected Item getCrop()
	{
		return ItemInit.TOMATO;
	}
	
//To make the block break if something is on top of it
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.canBlockStay(worldIn, pos))
        {
            worldIn.destroyBlock(pos, true);
        }
    }
	
	public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
        {
            Material material = worldIn.getBlockState(pos.offset(enumfacing.UP)).getMaterial();

            if (material.isSolid() || material == Material.LAVA)
            {
                return false;
            }
        }

        IBlockState state = worldIn.getBlockState(pos.down());
        return state.getBlock().canSustainPlant(state, worldIn, pos.down(), EnumFacing.UP, this) && !worldIn.getBlockState(pos.up()).getMaterial().isLiquid();
    }
	
//this is used to call the bounding box
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BOUNDING_BOX;
	}
}
