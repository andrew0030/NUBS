package andrews.ubs.items;

import java.util.List;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemCrusher extends Item {
	
	private Object type;

	public ItemCrusher(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.itemtab);
		this.setMaxStackSize(1);
		this.setMaxDamage(50);
	}

	@Override
	public boolean isRepairable()
	{
		return false;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack )
	{
		ItemStack copy = itemStack.copy();
		copy.setItemDamage( itemStack.getItemDamage() + 1 );

		return copy;
	}

	@Override
	public boolean hasContainerItem(ItemStack stack )
	{
		return true;
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
	{
	par2List.add("\u00A77" + "Used in crafting tables");
	}
}