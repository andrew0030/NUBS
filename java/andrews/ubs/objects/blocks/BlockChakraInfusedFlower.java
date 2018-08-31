package andrews.ubs.objects.blocks;

import java.util.Random;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChakraInfusedFlower extends BlockBush implements IPlantable, IHasModel
{	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625F * 4F, 0F, 0.0625F * 4F, 0.0625F * 12F, 0.0625F * 14F, 0.0625F * 12F);

	public BlockChakraInfusedFlower(String name)
	{
		super(Material.PLANTS);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setSoundType(SoundType.PLANT);
		this.setCreativeTab(Main.instance.blocktab);
		this.useNeighborBrightness = true;	
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
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
	
//this is used to spawn particles
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		super.randomDisplayTick(stateIn, worldIn, pos, rand);
	       
	//Particle Spawning Speed
		if (rand.nextInt(1) == 0) 
		{
			worldIn.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + (rand.nextDouble()), pos.getY() + 0.2 + rand.nextDouble(), pos.getZ() + (rand.nextDouble()), (rand.nextDouble() - 0.5D) * 2.0D, - rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, new int[0]);
			worldIn.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + (rand.nextDouble()), pos.getY() + 0.2 + rand.nextDouble(), pos.getZ() + (rand.nextDouble()), (rand.nextDouble() - 0.5D) * 2.0D, - rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, new int[0]);	
		}
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
}

