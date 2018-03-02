package andrews.ubs.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockStoneSalt extends Block {

	public BlockStoneSalt(String name) {
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
		this.setHardness(3);
	}
	
//this is used to set the toll type (shovel, pickaxe, axe...)
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}
	
//this is used to set the Tool level(Wood, Stone, Iron...)
	@Override
	public int getHarvestLevel(IBlockState state) {
		return 1;
	}

//Get the Item that this Block should drop when harvested
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return UltimateBlockStormItems.salt;
    }

//Get the quantity dropped based on the given fortune level
    public int quantityDroppedWithBonus(int fortune, Random random) {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }

//Returns the quantity of items to drop on block destruction
    public int quantityDropped(Random random) {
        return 4 + random.nextInt(2);
    }

//Spawns this Block's drops into the World as EntityItems.
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this))
        {
            return 1 + RANDOM.nextInt(5);
        }
        return 0;
    }

}
