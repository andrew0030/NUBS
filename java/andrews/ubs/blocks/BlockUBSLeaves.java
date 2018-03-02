package andrews.ubs.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.init.UltimateBlockStormBlocks;
import andrews.ubs.utils.IMetaName;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockUBSLeaves extends BlockLeaves implements IMetaName
{
	public static final PropertyEnum<BlockUBSPlanks.EnumType> VARIANT = PropertyEnum.<BlockUBSPlanks.EnumType>create("variant", BlockUBSPlanks.EnumType.class, new Predicate<BlockUBSPlanks.EnumType>()
	{
		public boolean apply(@Nullable BlockUBSPlanks.EnumType apply)
		{
			return apply.getMeta() < 2;
		}
	});
	
	public BlockUBSLeaves(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
		this.setSoundType(SoundType.PLANT);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockUBSPlanks.EnumType.CHAKRA_INFUSED));
	}
	
	@Override 
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, BlockUBSPlanks.EnumType.byMetadata(meta % 2)).withProperty(DECAYABLE, Boolean.valueOf((meta & 2) == 2)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 4) > 2));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((BlockUBSPlanks.EnumType)state.getValue(VARIANT)).getMeta();// - 4

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 2;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            i |= 4;
        }

        return i;
    }
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> items) 
	{
		for(BlockUBSPlanks.EnumType blockubsplanks$enumtype : BlockUBSPlanks.EnumType.values())
		{
			items.add(new ItemStack(this, 1, blockubsplanks$enumtype.getMeta()));
		}
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockUBSPlanks.EnumType)state.getValue(VARIANT)).getMeta());
	}
	
	@Override
	public int damageDropped(IBlockState state)
    {
        return ((BlockUBSPlanks.EnumType)state.getValue(VARIANT)).getMeta();// - 4;
    }
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return BlockUBSPlanks.EnumType.values()[stack.getItemDamage()].getName();
	}
	
//To make apples (not) drop
	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {return;}
	
//Sapling drop Chance (Vanila Default is 20)
	@Override
	protected int getSaplingDropChance(IBlockState state) {return 20;}
	
	 @Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	 {
		 return Item.getItemFromBlock(UltimateBlockStormBlocks.sapling);
	 }
	 
	@Override
	public EnumType getWoodType(int meta) {return null;}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) 
	{
		return java.util.Arrays.asList(new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMeta()));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT,DECAYABLE,CHECK_DECAY});
	}
	

//Used to determine ambient occlusion and culling when rebuilding chunks for render
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
		return BlockRenderLayer.CUTOUT_MIPPED;
    }
	
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? true : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

}
