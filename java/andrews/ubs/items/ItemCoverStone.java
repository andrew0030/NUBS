package andrews.ubs.items;

import java.util.List;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemCoverStone extends Item
{
	public ItemCoverStone(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.itemtab);
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
	 {
		par2List.add("\u00A7f" + "=================");
		par2List.add("Use on Falling Trap");
		par2List.add("Frame to Cover it");
		par2List.add("\u00A7f" + "=================");
		par2List.add("Click on Covered");
		par2List.add("Trap While Sneaking");
		par2List.add("to Remove Cover");
		par2List.add("\u00A7f" + "=================");
	 }
}
