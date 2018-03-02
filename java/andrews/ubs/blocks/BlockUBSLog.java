package andrews.ubs.blocks;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.utils.IMetaName;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockUBSLog extends BlockLog implements IMetaName
{
	public static final PropertyEnum<BlockUBSPlanks.EnumType> VARIANT = PropertyEnum.<BlockUBSPlanks.EnumType>create("variant", BlockUBSPlanks.EnumType.class, new Predicate<BlockUBSPlanks.EnumType>()
	{
		public boolean apply(@Nullable BlockUBSPlanks.EnumType apply)
		{
			return apply.getMeta() < 2;
		}
	});
	
	public BlockUBSLog(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
		this.setSoundType(SoundType.WOOD);
		setHardness(2.0F);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockUBSPlanks.EnumType.CHAKRA_INFUSED).withProperty(LOG_AXIS, EnumAxis.Y));
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
	public IBlockState getStateFromMeta(int meta) 
	{
		IBlockState state = this.getDefaultState().withProperty(VARIANT, BlockUBSPlanks.EnumType.byMetadata((meta & 1) % 2));
		
		switch(meta & 6)
		{
		case 0:
			state = state.withProperty(LOG_AXIS, EnumAxis.Y);
			break;
			
		case 2:
			state = state.withProperty(LOG_AXIS, EnumAxis.X);
			break;
			
		case 4:
			state = state.withProperty(LOG_AXIS, EnumAxis.Z);
			break;
			
		default:
			state = state.withProperty(LOG_AXIS, EnumAxis.NONE);
			break;
		}
		
		return state;
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = 0;
		i = i | ((BlockUBSPlanks.EnumType)state.getValue(VARIANT)).getMeta();
		
		switch((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
		{
		case X:
			i |= 2;
			break;
			
		case Y:
			i |= 4;
			break;
			
		case Z:
			i |= 6;
		}
		
		return i;
	}
	
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT, LOG_AXIS});
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockUBSPlanks.EnumType)state.getValue(VARIANT)).getMeta());
	}
	
	@Override
	public int damageDropped(IBlockState state)
    {
        return ((BlockUBSPlanks.EnumType)state.getValue(VARIANT)).getMeta();
    }
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return BlockUBSPlanks.EnumType.values()[stack.getItemDamage()].getName();
	}
}
