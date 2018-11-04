package andrews.ubs.objects.blocks;

import java.util.Random;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


	
public abstract class BlockAvocadoSlab extends BlockSlab
{
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);
	
	public BlockAvocadoSlab(String name)
	{
		super(Material.WOOD);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setSoundType(SoundType.WOOD);
		this.setHardness(2F);
		this.useNeighborBrightness = !this.isDouble();
		this.setCreativeTab(Main.instance.blocktab);
		
		IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
		if(!this.isDouble())
		{
			state.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
		}
		this.setDefaultState(state);
		
		BlockInit.BLOCKS.add(this);
	}

	@Override
	public String getUnlocalizedName(int meta)
	{
		return super.getUnlocalizedName();
	}

	@Override
	public IProperty<?> getVariantProperty()
	{
		return VARIANT;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack)
	{
		return Variant.DEFAULT;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(BlockInit.AVOCADO_SLAB_HALF);
	}
	
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(BlockInit.AVOCADO_SLAB_HALF);
	}
	
	@Override
	public final IBlockState getStateFromMeta(final int meta)
	{
		IBlockState blockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
		
		if(!this.isDouble())
		{
			blockstate = blockstate.withProperty(HALF, ((meta&8)!=0)?EnumBlockHalf.TOP:EnumBlockHalf.BOTTOM);
		}
		return blockstate;
	}
	
	@Override
	public final int getMetaFromState(final IBlockState state)
	{
		int meta = 0;
		
		if(!this.isDouble()&& state.getValue(HALF)==EnumBlockHalf.TOP)
		{
			meta |= 8;
		}
		return meta;
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		if(!this.isDouble())
		{
			return new BlockStateContainer(this, new IProperty[] {VARIANT, HALF});
		}
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	public static enum Variant implements IStringSerializable
	{
		DEFAULT;

		@Override
		public String getName() 
		{
			return "default";
		}
	}
}