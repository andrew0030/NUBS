package andrews.ubs.objects.items;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

public class ItemBacon extends ItemFood implements IHasModel
{
	public ItemBacon(String name) 
	{
		super(3, 4, false);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.foodtab);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
