package andrews.ubs.objects.blocks;

import java.util.Random;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public abstract class BlockAvocadoSlab extends BlockSlab implements IHasModel
{	
	public BlockAvocadoSlab(String name)
	{
		super(Material.WOOD);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setSoundType(SoundType.WOOD);
		this.setHardness(2F);
		this.setCreativeTab(Main.instance.blocktab);
		this.useNeighborBrightness = true;
		
		IBlockState state = this.blockState.getBaseState();
        if(!this.isDouble())
        {
            state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
        }
        setDefaultState(state);
		
		BlockInit.BLOCKS.add(this);
	}
	
	@Override
    public String getUnlocalizedName(int meta) 
    {
        return this.getUnlocalizedName();
    }

    @Override
    public IProperty<?> getVariantProperty() 
    {
        return HALF;
    }
    
    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return EnumBlockHalf.BOTTOM;
    }
    
    @Override
    public int damageDropped(IBlockState state) 
    {
        return 0;
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta) 
    {
        if(!this.isDouble())
        {
            return this.getDefaultState().withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
        }
        return this.getDefaultState();
    }
    
    @Override
    public int getMetaFromState(IBlockState state) 
    {
        if(!this.isDouble())
        {
            return 0;
        }
        
        return ((EnumBlockHalf)state.getValue(HALF)).ordinal() + 1;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) 
    {
        return Item.getItemFromBlock(BlockInit.AVOCADO_SLAB_HALF);
    }
    
    @Override
    protected BlockStateContainer createBlockState() 
    {
        return new BlockStateContainer(this, new IProperty[] {HALF});
    }
    
    @Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
}