package andrews.ubs.objects.blocks;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.Block;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFallingTrapFrame extends Block implements IHasModel
{
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0F, 0.0625F * 14F, 0F, 1.0F, 1.0F, 1.0F);
	
	public BlockFallingTrapFrame(String name) 
	{
		super(Material.WOOD);
		this.setSoundType(SoundType.WOOD);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.useNeighborBrightness = true;
		this.setHardness(2);
		this.setCreativeTab(Main.instance.itemtab);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
//this is used to make the block break on collision
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{	
		if (!worldIn.isRemote)
        {	
			if(entityIn instanceof EntityLivingBase)
			{
//				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), UltimateBlockStormSoundHandler.fall_trap, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
				EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, new ItemStack(Items.STICK, 4));
				item.setPickupDelay(40); //To Set a Small Pickup Delay
				worldIn.spawnEntity(item); //To Spawn the Item
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
		
//this is used to call the bounding box
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return BOUNDING_BOX;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) 
	{
		return NULL_AABB;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{	
		if(player.getHeldItem(hand) != null)
		{
			Item heldItem = player.getHeldItem(hand).getItem();
			ItemStack heldItemStack = player.getHeldItem(hand);
			
		//Grass Version
			if(heldItem == ItemInit.COVER_GRASS)
			{
				worldIn.setBlockState(pos, BlockInit.FALLING_TRAP_GRASS.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
				if(!player.isCreative())
				{
					heldItemStack.shrink(1);
				}
			}
			
		//Stone Version
			if(heldItem == ItemInit.COVER_STONE)
			{
				worldIn.setBlockState(pos, BlockInit.FALLING_TRAP_STONE.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
				if(!player.isCreative())
				{
					heldItemStack.shrink(1);
				}
			}
			
		//Cobblestone Version
			if(heldItem == ItemInit.COVER_COBBLESTONE)
			{
				worldIn.setBlockState(pos, BlockInit.FALLING_TRAP_COBBLESTONE.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
				if(!player.isCreative())
				{
					heldItemStack.shrink(1);
				}
			}
			
		//Netherrack Version
			if(heldItem == ItemInit.COVER_NETHER)
			{
				worldIn.setBlockState(pos, BlockInit.FALLING_TRAP_NETHER.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
				if(!player.isCreative())
				{
					heldItemStack.shrink(1);
				}
			}
			
		//Sand Version
			if(heldItem == ItemInit.COVER_SAND)
			{
				worldIn.setBlockState(pos, BlockInit.FALLING_TRAP_SAND.getDefaultState(), 2);
				worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, SoundCategory.BLOCKS, 1.6F, 1.6F);
				if(!player.isCreative())
				{
					heldItemStack.shrink(1);
				}
			}
		}
		return super.onBlockActivated(worldIn, pos, state, player, hand, facing, hitX, hitY, hitZ);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}