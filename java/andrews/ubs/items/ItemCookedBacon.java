package andrews.ubs.items;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

public class ItemCookedBacon extends ItemFood 
{

	public ItemCookedBacon(String name) 
	{
		super(7, 8, true);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.foodtab);
	}

}
