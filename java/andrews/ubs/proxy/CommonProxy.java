package andrews.ubs.proxy;

import net.minecraft.item.Item;

public class CommonProxy
{
	public void registerItemObjRenderer(Item item, int meta, String id) {}
	public void registerItemRenderer(Item item, int meta, String id) {}
	
//Pre Init
	public void preinit() {}
	
//Init
	public void init() {}
	
//Post Init
	public void postinit() {}
	
}
