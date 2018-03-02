package andrews.ubs.blocks;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockAvocadoTrapdoor extends BlockTrapDoor {

	public BlockAvocadoTrapdoor(String name) {
		super(Material.WOOD);
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Reference.MODID, name));
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(UltimateBlockStormMod.instance.blocktab);
	}

}
