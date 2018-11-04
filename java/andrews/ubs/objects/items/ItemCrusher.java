package andrews.ubs.objects.items;

import java.util.List;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemCrusher extends Item implements IHasModel
{	
	private Object type;

	public ItemCrusher(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.itemtab);
		this.setMaxStackSize(1);
		this.setMaxDamage(50);
		
		ItemInit.ITEMS.add(this);
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
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		tooltip.add("\u00A77" + "Used in crafting tables");
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}