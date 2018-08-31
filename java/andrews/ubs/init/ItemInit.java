package andrews.ubs.init;

import java.util.ArrayList;
import java.util.List;

import andrews.ubs.objects.blocks.item.ItemBlockDoor;
import andrews.ubs.objects.items.ItemBacon;
import andrews.ubs.objects.items.ItemCalamari;
import andrews.ubs.objects.items.ItemChakraBerries;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class ItemInit
{
	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item CHAKRA_BERRIES = new ItemChakraBerries("chakra_berries");
	public static final Item BACON = new ItemBacon("bacon");
	public static final Item CALAMARI = new ItemCalamari("calamari");
	
}
