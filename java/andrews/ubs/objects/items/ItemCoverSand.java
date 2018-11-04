package andrews.ubs.objects.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemCoverSand extends Item implements IHasModel
{
	public ItemCoverSand(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.itemtab);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			tooltip.add("\u00A7f" + "=================");
			tooltip.add("Use on Falling Trap");
			tooltip.add("Frame to Cover it");
			tooltip.add("\u00A7f" + "=================");
			tooltip.add("Use Covered");
			tooltip.add("Trap While Sneaking");
			tooltip.add("to Remove Cover");
			tooltip.add("\u00A7f" + "=================");
        }
		else
		{
			tooltip.add("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for More Information");
		}
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}