package andrews.ubs.items;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class ItemKatana extends ItemSword
{

	public ItemKatana(ToolMaterial material, String name)
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.tooltab);
		this.setMaxDamage(800);
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
	
}
