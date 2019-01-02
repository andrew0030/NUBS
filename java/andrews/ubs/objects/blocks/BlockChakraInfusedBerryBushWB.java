package andrews.ubs.objects.blocks;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChakraInfusedBerryBushWB extends BlockBush implements IPlantable
{
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625F * 1F, 0F, 0.0625F * 1F, 0.0625F * 15F, 0.0625F * 15F, 0.0625F * 15F);
	
	public BlockChakraInfusedBerryBushWB(String name) 
	{
		super(Material.PLANTS);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setSoundType(SoundType.PLANT);
		
		BlockInit.BLOCKS.add(this);
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
	
//this is used to call the bounding box
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BOUNDING_BOX;
	}
	
//to make the block drop chakra berries (harvest)
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote)
		{
			EntityItem berry = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(ItemInit.CHAKRA_BERRIES));
			berry.setNoPickupDelay();
			worldIn.spawnEntity(berry);
		//to make the block become a chakra bush without berries
			worldIn.setBlockState(pos, BlockInit.CHAKRA_INFUSED_BERRY_BUSH.getDefaultState(), 2);
		}
		
        return true;
	}
	
//to make the block drop chakra berries (start breaking)
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
	{
		if(!worldIn.isRemote)
		{
			EntityItem berry = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(ItemInit.CHAKRA_BERRIES));
			berry.setNoPickupDelay();
			worldIn.spawnEntity(berry);
			
		//to make the block become a chakra bush without berries
			worldIn.setBlockState(pos, BlockInit.CHAKRA_INFUSED_BERRY_BUSH.getDefaultState(), 2);
		}
		
    }
	
//Called When an Entity Collided with the Block
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.motionX *= 0.2D;
        entityIn.motionY *= 0.2D;
        entityIn.motionZ *= 0.2D;
    }
    
//So that you pick block the right item
  	@Override
  	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
  	{
  		return new ItemStack(BlockInit.CHAKRA_INFUSED_BERRY_BUSH);
  	}
}

