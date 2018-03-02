package andrews.ubs.blocks;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.tileentity.TileEntityJar;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCookieJar extends Block implements ITileEntityProvider
{

	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625F * 2F, 0F, 0.0625F * 2F, 0.0625F * 14F, 0.0625F * 13F, 0.0625F * 14F);
	
	public BlockCookieJar(String name) 
	{
		super(Material.GLASS);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
		this.setSoundType(SoundType.GLASS);
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
			
//this is used to call the bounding box
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return BOUNDING_BOX;
	}
	
//this is used so we dont get a black filler texture on the empty spots of the texture
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
		return BlockRenderLayer.CUTOUT_MIPPED;
    }

//to bind the tileentity to the block
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
	return new TileEntityJar();
	}
	
//to edit whats going to happen if somebody interacts with the block
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote)
		{
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if(tileEntity instanceof TileEntityJar)
			{
				TileEntityJar jar = (TileEntityJar) tileEntity;
				if(heldItem != null)
				{
					if(heldItem.getItem() == Items.COOKIE)
					{
						if(jar.addCookie())
						{
							heldItem.stackSize--;
							return true;
						}
					}
				}
				jar.removeCookie();
			}
		}
		return true;
	}
	
//to make the block drop the cookies if it gets destroyed 
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		if (!worldIn.isRemote)
		{
			TileEntity tileEntity = worldIn.getTileEntity(pos);
				
			if (tileEntity instanceof TileEntityJar)
			{
				TileEntityJar jar = (TileEntityJar) tileEntity;
					
				while (jar.cookieCount > 0)
				{
					jar.removeCookie();
				}
			}
		}	
		super.breakBlock(worldIn, pos, state);
	}
	
}
