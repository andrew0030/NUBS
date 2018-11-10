package andrews.ubs.objects.blocks;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.handlers.UBSEnumHandler;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.objects.blocks.item.ItemBlockVariants;
import andrews.ubs.util.interfaces.IHasModel;
import andrews.ubs.util.interfaces.IMetaName;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class BlockUBSLog extends BlockLog implements IMetaName, IHasModel
{
	public static final PropertyEnum<UBSEnumHandler.EnumType> VARIANT = PropertyEnum.<UBSEnumHandler.EnumType>create("variant", UBSEnumHandler.EnumType.class, new Predicate<UBSEnumHandler.EnumType>()
	{
		public boolean apply(@Nullable UBSEnumHandler.EnumType apply)
		{
			return apply.getMeta() < 2;
		}
	});
	
	public BlockUBSLog(String name) 
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.blocktab);
		this.setSoundType(SoundType.WOOD);
		this.setHardness(2.0F);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, UBSEnumHandler.EnumType.CHAKRA_INFUSED).withProperty(LOG_AXIS, EnumAxis.Y));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(UBSEnumHandler.EnumType customblockplanks$enumtype : UBSEnumHandler.EnumType.values())
		{
			items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		IBlockState state = this.getDefaultState().withProperty(VARIANT, UBSEnumHandler.EnumType.byMetadata((meta & 1) % 2));
		
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
		}
		
		return state;
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = 0;
		i = i | ((UBSEnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
		
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
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT,LOG_AXIS});
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((UBSEnumHandler.EnumType)state.getValue(VARIANT)).getMeta());
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((UBSEnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return UBSEnumHandler.EnumType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < UBSEnumHandler.EnumType.values().length; i++)
		{
			Main.proxy.registerItemVariantRenderer(Item.getItemFromBlock(this), i, "log_" + UBSEnumHandler.EnumType.values()[i].getName(), "inventory");
		}
	}	
}
