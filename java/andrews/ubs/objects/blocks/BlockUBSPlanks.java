package andrews.ubs.objects.blocks;

import andrews.ubs.Main;
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
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockUBSPlanks extends Block implements IMetaName, IHasModel
{
	public static final PropertyEnum<BlockUBSPlanks.EnumType> VARIANT = PropertyEnum.<BlockUBSPlanks.EnumType>create("variant", BlockUBSPlanks.EnumType.class);
	
	public BlockUBSPlanks(String name)
	{
		super(Material.WOOD);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.setCreativeTab(Main.instance.blocktab);
		this.setSoundType(SoundType.WOOD);
		setHardness(2);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockUBSPlanks.EnumType.CHAKRA_INFUSED));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(name));
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((BlockUBSPlanks.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(BlockUBSPlanks.EnumType blockubsplanks$enumtype : BlockUBSPlanks.EnumType.values())
		{
			items.add(new ItemStack(this, 1, blockubsplanks$enumtype.getMeta()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, BlockUBSPlanks.EnumType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((BlockUBSPlanks.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, (int)(getMetaFromState(world.getBlockState(pos))));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	public static enum EnumType implements IStringSerializable
	{
		
		CHAKRA_INFUSED(0, "chakra_infused"),
		AVOCADO(1, "avocado");
		
	//This is an array of all the values inside of enumtype 
		private static final BlockUBSPlanks.EnumType[] META_LOOKUP = new BlockUBSPlanks.EnumType[values().length];
		private final int meta;
		private final String name, unlocalizedName;
		
		private EnumType(int meta, String name)
		{
			this(meta, name, name);
		}
		
		private EnumType(int meta, String name, String unlocalizedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}
		
		@Override
		public String getName()
		{
			return this.name;
		}
		
		public int getMeta() 
		{
			return this.meta;
		}
		
		public String getUnlocalizedName() 
		{
			return this.unlocalizedName;
		}
		
		@Override
		public String toString() 
		{
			return this.name;
		}
		
		public static BlockUBSPlanks.EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}
		
		static 
		{
			for(BlockUBSPlanks.EnumType blockubsplanks$enumtype : values())
			{
				META_LOOKUP[blockubsplanks$enumtype.getMeta()] = blockubsplanks$enumtype;
			}
		}
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return BlockUBSPlanks.EnumType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}