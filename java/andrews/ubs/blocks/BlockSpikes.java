package andrews.ubs.blocks;

import java.util.List;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.EnumFaceDirection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSpikes extends Block 
{
	public static final PropertyDirection FACING = BlockDirectional.FACING;
	
	public static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB(0F, 0.0625F * 8F, 0F, 1.0F, 1.0F, 1.0F);
	public static final AxisAlignedBB AABB_UP = new AxisAlignedBB(0F, 0F, 0F, 1.0F, 0.0625F * 8F, 1.0F);
	public static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0F, 0F, 0.0625F * 8F, 1F, 1F, 1F);
	public static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 0.0625F * 8F);
	public static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.0625F * 8F, 0F, 0F, 1F, 1F, 1F);
	public static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0F, 0F, 0F, 0.0625F * 8F, 1F, 1F);
	
	public static DamageSource spikes = new DamageSource("spikes");

	public BlockSpikes(String name)
	{
		super(Material.WOOD);
		this.setSoundType(SoundType.WOOD);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.useNeighborBrightness = true;
		this.setHardness(2);
		this.setCreativeTab(UltimateBlockStormMod.instance.itemtab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
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
	
//This is Used to set the Collision Box
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
	{
		return NULL_AABB;
	}
	
//Called When an Entity Collided with the Block
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    	if(entityIn instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer) entityIn;
    		
    		if(!player.isCreative())
    		{
	    		entityIn.motionX *= 0.2D;
		        entityIn.motionY *= 0.2D;
		        entityIn.motionZ *= 0.2D;
    		}
	        
	        entityIn.attackEntityFrom(spikes, 4.0F);
    	}
    	else if(entityIn instanceof EntityLivingBase)
    	{
	        entityIn.motionX *= 0.2D;
	        entityIn.motionY *= 0.2D;
	        entityIn.motionZ *= 0.2D;
	        
	        entityIn.attackEntityFrom(spikes, 4.0F);
    	}
    }
    
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
//    	return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, BlockPistonBase.getFacingFromEntity(pos, placer));
    	return canPlaceBlock(worldIn, pos, facing.getOpposite()) ? this.getDefaultState().withProperty(FACING, facing) : this.getDefaultState().withProperty(FACING, EnumFacing.DOWN);
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
}
