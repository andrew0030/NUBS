package andrews.ubs.objects.blocks;

import java.util.Random;

import andrews.ubs.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockAvocadoSlabDouble extends BlockAvocadoSlab
{
	public BlockAvocadoSlabDouble(String name)
	{
		super(name);
	}

	@Override
	public boolean isDouble()
	{
		return true;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(BlockInit.AVOCADO_SLAB_HALF);
	}
	
	@Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Item.getItemFromBlock(BlockInit.AVOCADO_SLAB_HALF));
    }
}
