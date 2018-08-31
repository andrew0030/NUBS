package andrews.ubs.objects.blocks;

import java.util.Random;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCandel extends Block implements IHasModel
{
	public static final PropertyDirection FACING = BlockDirectional.FACING;
	
	public static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB(0.0625F * 3F, 0.0625F * 4F, 0.0625F * 3F, 0.0625F * 13F, 1, 0.0625F * 13F);
	public static final AxisAlignedBB AABB_UP = new AxisAlignedBB(0.0625F * 3F, 0F, 0.0625F * 4F, 0.0625F * 12F, 0.0625F * 7F, 0.0625F * 12F);
	public static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.0625F * 4F, 0.0625F * 1F, 0.0625F * 2F, 0.0625F * 12F, 0.0625F * 14F, 1F);
	public static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.0625F * 4F, 0.0625F * 1F, 0F, 0.0625F * 12F, 0.0625F * 14F, 0.0625F * 14F);
	public static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.0625F * 2F, 0.0625F * 1F, 0.0625F * 4F, 1F, 0.0625F * 14F, 0.0625F * 12F);
	public static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0F, 0.0625F * 1F, 0.0625F * 4F, 0.0625F * 14F, 0.0625F * 14F, 0.0625F * 12F);
	
	public BlockCandel(String name)
	{
		super(Material.IRON);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.useNeighborBrightness = true;
		this.setHardness(2);
		this.setCreativeTab(Main.instance.blocktab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setLightLevel(1);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
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
	
//The Collision box
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	{
		return NULL_AABB;
	}
	
//this is used to call the bounding box
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

        switch (enumfacing)
        {
            case EAST:
                return AABB_EAST;
            case WEST:
                return AABB_WEST;
            case SOUTH:
                return AABB_SOUTH;
            case NORTH:
            default:
                return AABB_NORTH;
            case UP:
                return AABB_UP;
            case DOWN:
                return AABB_DOWN;
        }
    }
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        EnumFacing enumfacing = (EnumFacing)stateIn.getValue(FACING);

        switch (enumfacing)
        {
        	case EAST:
        		worldIn.spawnParticle(EnumParticleTypes.FLAME, pos.getX() + 0.63, pos.getY() + 0.9, pos.getZ() + 0.5, 0, 0, 0, new int[0]);
        		break;
            case WEST:
                worldIn.spawnParticle(EnumParticleTypes.FLAME, pos.getX() + 0.37, pos.getY() + 0.9, pos.getZ() + 0.5, 0, 0, 0, new int[0]);
                break;
            case SOUTH:
                worldIn.spawnParticle(EnumParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.9, pos.getZ() + 0.63, 0, 0, 0, new int[0]);
                break;
            case NORTH:
            	worldIn.spawnParticle(EnumParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.9, pos.getZ() + 0.37, 0, 0, 0, new int[0]);
                break;
            case UP:
            	worldIn.spawnParticle(EnumParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.48, pos.getZ() + 0.5, 0, 0, 0, new int[0]);
            	break;
            case DOWN:
            	worldIn.spawnParticle(EnumParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.82, pos.getZ() + 0.5, 0, 0, 0, new int[0]);
        }
    }
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
	{
		return canPlaceBlock(world, pos, facing.getOpposite()) ? this.getDefaultState().withProperty(FACING, facing) : this.getDefaultState().withProperty(FACING, EnumFacing.DOWN);
	}
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
    	return state.getValue(FACING).getIndex();
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
    	return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
    	return new BlockStateContainer(this, FACING);
    }
    
//Check whether this block can be placed on the block in the given direction.
    protected static boolean canPlaceBlock(World worldIn, BlockPos pos, EnumFacing direction)
    {
        BlockPos blockpos = pos.offset(direction);
        return worldIn.getBlockState(blockpos).isSideSolid(worldIn, blockpos, direction.getOpposite());
    }
    
//Check whether this Block can be placed on the given side
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
    {
        return canPlaceBlock(worldIn, pos, side.getOpposite());
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        for (EnumFacing enumfacing : EnumFacing.values())
        {
            if (canPlaceBlock(worldIn, pos, enumfacing))
            {
                return true;
            }
        }
        return false;
    }
    
//Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
//change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
//lock, etc.
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
    	
        if (this.checkForDrop(worldIn, pos, state) && !canPlaceBlock(worldIn, pos, ((EnumFacing)state.getValue(FACING)).getOpposite()))
        if(this.checkForDrop(worldIn, pos, state))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }
    
    private boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.canPlaceBlockAt(worldIn, pos))
        {
            return true;
        }
        else
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
            return false;
        }
    }
    
    @Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
