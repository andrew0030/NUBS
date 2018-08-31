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
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChakraInfusedBerryBush extends BlockBush implements IPlantable, IHasModel
{
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625F * 1F, 0F, 0.0625F * 1F, 0.0625F * 15F, 0.0625F * 15F, 0.0625F * 15F);
	
	public BlockChakraInfusedBerryBush(String name) 
	{
		super(Material.PLANTS);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.blocktab);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
		
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
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}
	
//to make the bush grow berries
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
	{
		super.randomTick(worldIn, pos, state, random);
		// doesn't grow with every update.
		// 40% of the time it grows
		final int GROW_CHANCE = 30;
		if(random.nextInt(100) < GROW_CHANCE)
		{
			worldIn.setBlockState(pos, BlockInit.CHAKRA_INFUSED_BERRY_BUSH_WB.getDefaultState());
		}
	}
	
//Called When an Entity Collided with the Block
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.motionX *= 0.2D;
        entityIn.motionY *= 0.2D;
        entityIn.motionZ *= 0.2D;
    }
    
    @Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}

