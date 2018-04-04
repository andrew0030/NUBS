package andrews.ubs.blocks;

import java.util.List;

import andrews.ubs.Reference;
import andrews.ubs.handler.UltimateBlockStormSoundHandler;
import andrews.ubs.init.UltimateBlockStormBlocks;
import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BlockFallingTrapGrassSmart extends Block
{
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0F, 0.0625F * 14F, 0F, 1.0F, 1.0F, 1.0F);
	
	public BlockFallingTrapGrassSmart(String name) 
	{
		super(Material.WOOD);
		this.setSoundType(SoundType.PLANT);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setHardness(2);
		this.lightOpacity = 15;
	}
	
//this is used to make the block break on collision
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{	
		if (!worldIn.isRemote)
	    {	
			if(entityIn instanceof EntityLivingBase)
			{
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), UltimateBlockStormSoundHandler.fall_trap, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
				worldIn.notifyNeighborsOfStateChange(pos, this);
				EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, new ItemStack(Items.STICK, 4));
				item.setPickupDelay(40); //To Set a Small Pickup Delay
				worldIn.spawnEntityInWorld(item); //To Spawn the Item
			}
	    }
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	}
	
//this is used to set if the block should allow light to pass through
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
//This is Used so the Blocks next to this one render properly
	@Override
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
	
//This is Used to set the Collision Box
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn)
	{
		if(entityIn instanceof EntityPlayer)
		{
			addCollisionBoxToList(pos, entityBox, collidingBoxes, NULL_AABB);
		}
		else
		{
			addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
		}
	}
	
//So that you pick block the right item
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
	{
		return new ItemStack(UltimateBlockStormBlocks.falling_trap_frame_smart);
	}
	
//to make the block drop chakra berries when right clicked
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote)
		{
			if(playerIn.isSneaking())
			{
				if(!playerIn.isCreative())
				{
					EntityItem item = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(UltimateBlockStormItems.cover_grass));
					item.setNoPickupDelay();
					worldIn.spawnEntityInWorld(item);
				}
				worldIn.setBlockState(pos, UltimateBlockStormBlocks.falling_trap_frame_smart.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_REMOVE_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
			}
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }
	
//Used so grass can be placed on top of the Block
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable)
	{
		if(plantable instanceof BlockBush)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
