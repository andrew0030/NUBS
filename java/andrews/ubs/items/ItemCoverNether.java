package andrews.ubs.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemCoverNether extends Item
{
	public ItemCoverNether(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.itemtab);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advancedToolTip)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			list.add("\u00A7f" + "=================");
			list.add("Use on Falling Trap");
			list.add("Frame to Cover it");
			list.add("\u00A7f" + "=================");
			list.add("Click on Covered");
			list.add("Trap While Sneaking");
			list.add("to Remove Cover");
			list.add("\u00A7f" + "=================");
        }
		else
		{
            list.add("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for More Information");
		}
	}
}
