package andrews.ubs.items;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.init.UltimateBlockStormBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.util.ResourceLocation;

public class ItemSalad extends ItemSeedFood {

	public ItemSalad(String name) {
		super(7, 5, UltimateBlockStormBlocks.salad, Blocks.FARMLAND);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.foodtab);
		this.maxStackSize = 16;

	}

}
