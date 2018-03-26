package andrews.ubs.blocks;

import java.util.List;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.handler.UltimateBlockStormSoundHandler;
import andrews.ubs.init.UltimateBlockStormBlocks;
import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFallingTrapFrameSmart extends Block 
{

	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0F, 0.0625F * 14F, 0F, 1.0F, 1.0F, 1.0F);
	
	public BlockFallingTrapFrameSmart(String name) 
	{
		super(Material.WOOD);
		this.setSoundType(SoundType.WOOD);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.useNeighborBrightness = true;
		this.setHardness(2);
		this.setCreativeTab(UltimateBlockStormMod.instance.itemtab);
	}
	
//this is used to make the block break on collision
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{	
		if (!worldIn.isRemote)
        {	
			if(entityIn instanceof EntityPlayer)
			{
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), UltimateBlockStormSoundHandler.fall_trap, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
			}
        }
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
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
	
//this is used so the block will not render the pixels without a texture black
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
		
//this is used to call the bounding box
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return BOUNDING_BOX;
	}
	
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
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(heldItem != null)
		{
			
		//Grass Version
			if(heldItem.getItem() == UltimateBlockStormItems.cover_grass)
			{
				worldIn.setBlockState(pos, UltimateBlockStormBlocks.falling_trap_grass.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
				if(!playerIn.isCreative())
				{
					heldItem.stackSize--;
				}
			}
			
		//Stone Version
			if(heldItem.getItem() == UltimateBlockStormItems.cover_stone)
			{
				worldIn.setBlockState(pos, UltimateBlockStormBlocks.falling_trap_stone.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
				if(!playerIn.isCreative())
				{
					heldItem.stackSize--;
				}
			}
			
		//Cobblestone Version
			if(heldItem.getItem() == UltimateBlockStormItems.cover_cobblestone)
			{
				worldIn.setBlockState(pos, UltimateBlockStormBlocks.falling_trap_cobblestone.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
				if(!playerIn.isCreative())
				{
					heldItem.stackSize--;
				}
			}
			
		//Netherrack Version
			if(heldItem.getItem() == UltimateBlockStormItems.cover_nether)
			{
				worldIn.setBlockState(pos, UltimateBlockStormBlocks.falling_trap_nether.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
				if(!playerIn.isCreative())
				{
					heldItem.stackSize--;
				}
			}
			
		//Sand Version
			if(heldItem.getItem() == UltimateBlockStormItems.cover_sand)
			{
				worldIn.setBlockState(pos, UltimateBlockStormBlocks.falling_trap_sand.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
				if(!playerIn.isCreative())
				{
					heldItem.stackSize--;
				}
			}
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}
}