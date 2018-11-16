package andrews.ubs.objects.blocks;

import java.util.Random;

import andrews.ubs.Main;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockChakraInfusedSlabHalf extends BlockAvocadoSlab implements IHasModel
{
	public BlockChakraInfusedSlabHalf(String name)
	{
		super(name);
		
		ItemInit.ITEMS.add(new ItemSlab(this, this, BlockInit.CHAKRA_INFUSED_SLAB_DOUBLE).setRegistryName(name));
	}

	@Override
	public boolean isDouble()
	{
		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_SLAB_HALF);
	}
	
	@Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Item.getItemFromBlock(BlockInit.CHAKRA_INFUSED_SLAB_HALF));
    }
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
