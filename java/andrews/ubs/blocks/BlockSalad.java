package andrews.ubs.blocks;

import andrews.ubs.Reference;
import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSalad extends BlockCrops {
	
	public BlockSalad(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		
	}
	
//Sets the Seed Drop
	@Override
	protected Item getSeed() {
		return UltimateBlockStormItems.salad;
	}
	
//Sets the Crop Drop
	@Override
	protected Item getCrop() {
		return UltimateBlockStormItems.salad;
	}
}
