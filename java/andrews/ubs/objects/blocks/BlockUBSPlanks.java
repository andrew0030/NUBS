package andrews.ubs.objects.blocks;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.handlers.UBSEnumHandler;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.objects.blocks.item.ItemBlockVariants;
import andrews.ubs.util.interfaces.IHasModel;
import andrews.ubs.util.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockUBSPlanks extends Block implements IMetaName, IHasModel
{
	public static final PropertyEnum<UBSEnumHandler.EnumType> VARIANT = PropertyEnum.<UBSEnumHandler.EnumType>create("variant", UBSEnumHandler.EnumType.class);
	
	public BlockUBSPlanks(String name)
	{
		super(Material.WOOD);
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.blocktab);
		this.setSoundType(SoundType.WOOD);
		setHardness(2);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, UBSEnumHandler.EnumType.CHAKRA_INFUSED));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((UBSEnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
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
		return this.getDefaultState().withProperty(VARIANT, UBSEnumHandler.EnumType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((UBSEnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
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
			Main.proxy.registerItemVariantRenderer(Item.getItemFromBlock(this), i, "planks_" + UBSEnumHandler.EnumType.values()[i].getName(), "inventory");
		}
	}
}