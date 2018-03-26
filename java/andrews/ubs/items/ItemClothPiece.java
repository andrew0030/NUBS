package andrews.ubs.items;

import java.util.List;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.handler.UltimateBlockStormEnumHandler.ClothPieceTypes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemClothPiece extends Item
{
	public ItemClothPiece(String name)
	{
		this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Reference.MODID, name));
        this.setCreativeTab(UltimateBlockStormMod.instance.itemtab);
        this.setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> items)
	{
		for(int i = 0; i < ClothPieceTypes.values().length; i++)
		{
			items.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		for(int i = 0; i < ClothPieceTypes.values().length; i++)
		{
			if(stack.getItemDamage() == i)
			{
				return this.getUnlocalizedName() + "." + ClothPieceTypes.values()[i].getName();
			}
			else 
			{
				continue;
			}
		}
		return this.getUnlocalizedName() + "." + ClothPieceTypes.WHITE.getName();
	}
}
