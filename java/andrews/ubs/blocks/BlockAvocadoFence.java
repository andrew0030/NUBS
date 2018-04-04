package andrews.ubs.blocks;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.init.UltimateBlockStormBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockAvocadoFence extends BlockFence {

	public BlockAvocadoFence(String name) {
		super(Material.WOOD, Material.WOOD.getMaterialMapColor());
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
		this.setSoundType(SoundType.WOOD);
		this.setHardness(2F);
		this.useNeighborBrightness = true;
	}
	
//To make the fence connect to the fencegate, and to set which blocks it can't connect too
	
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        return block == Blocks.BARRIER ? false 
        	: block == UltimateBlockStormBlocks.chakra_infused_fence_gate ? true 
        	: block == UltimateBlockStormBlocks.avocado_fence_gate ? true
        	: block == UltimateBlockStormBlocks.grill ? false 
        	: ((!(block instanceof BlockFence) || block.getMaterial(null) != this.blockMaterial) && !(block instanceof BlockFenceGate) ? (block.getMaterial(null).isOpaque() && iblockstate.isFullCube() ? block.getMaterial(null) != Material.GOURD : false) : true);
    }
}
