package andrews.ubs.objects.items;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemShuriken extends Item implements IHasModel
{	
	public ItemShuriken(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.tooltab);
		this.setMaxStackSize(16);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}