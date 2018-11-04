package andrews.ubs.objects.tools;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class ItemTripleBladedScythe extends ItemSword implements IHasModel
{

	public ItemTripleBladedScythe(String name, ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.tooltab);
		this.setMaxStackSize(1);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemObjRenderer(this, 0, "inventory");
	}
}