package andrews.ubs.blocks;

import java.util.Random;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCampFire extends Block 
{

	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0F, 0F, 0F, 1.0F, 0.0625F * 8F, 1.0F);
	
	public BlockCampFire(String name) 
	{
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
		this.useNeighborBrightness = true;
		this.setLightLevel(1);
		setHardness(3.5F);
	}
	
//this is used to set the toll type (shovel, pickaxe, axe...)
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}
		
//this is used to set the Tool level(Wood, Stone, Iron...)
	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}
	
//this is used to set damage sources if an entity walks on top of this block
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
        {
        	
        //to set the entity on fire
        	entityIn.setFire(5);
        //to deal extra damage while the entity is in the block
            entityIn.attackEntityFrom(DamageSource.inFire, 2.0F);
        }
    super.onEntityWalk(worldIn, pos, entityIn);
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
	
//this is used to spawn particles
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        super.randomDisplayTick(stateIn, worldIn, pos, rand);
        
    //Particle Spawning Speed
        if (rand.nextInt(1) == 0) 
        {
        	
        	worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
        	
        //Fire Particles
            worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)((float)pos.getX() + 0.5D + rand.nextDouble() * 0.6D - 0.3D), (double)((float)pos.getY() + 0.5D + rand.nextDouble() * 0.6D - 0.4D), (double)((float)pos.getZ() + 0.5D + rand.nextDouble() * 0.6D - 0.3D), 0.0D, 0.0D, 0.0D, new int[0]);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)((float)pos.getX() + 0.5D + rand.nextDouble() * 0.6D - 0.3D), (double)((float)pos.getY() + 0.5D + rand.nextDouble() * 0.6D - 0.4D), (double)((float)pos.getZ() + 0.5D + rand.nextDouble() * 0.6D - 0.3D), 0.0D, 0.0D, 0.0D, new int[0]);
        //Smoke Particles
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)((float)pos.getX() + 0.5D + rand.nextDouble() * 0.6D - 0.3D), (double)((float)pos.getY() + 1.1D + rand.nextDouble() * 0.6D - 0.4D), (double)((float)pos.getZ() + 0.5D + rand.nextDouble() * 0.6D - 0.3D), 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }

}
