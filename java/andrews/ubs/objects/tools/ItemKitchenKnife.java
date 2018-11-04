package andrews.ubs.objects.tools;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class ItemKitchenKnife extends ItemSword implements IHasModel 
{
	public ItemKitchenKnife(String name, ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.tooltab);
		
		ItemInit.ITEMS.add(this);
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
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
