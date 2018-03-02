package andrews.ubs.blocks;

import java.util.Random;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.init.UltimateBlockStormBlocks;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockChakraInfusedDoor extends BlockDoor {

	public BlockChakraInfusedDoor(String name) 
	{
		super(Material.WOOD);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setSoundType(SoundType.WOOD);
		this.setHardness(2F);
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
	}
	
/**
 * So that you pick block the right item
 */
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
	{
		return new ItemStack(UltimateBlockStormBlocks.chakra_infused_door);
	}
	
/**
 * So that you only drop one of the door
 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null : Item.getItemFromBlock(UltimateBlockStormBlocks.chakra_infused_door);
	}
}
