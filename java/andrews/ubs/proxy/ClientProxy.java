package andrews.ubs.proxy;

import andrews.ubs.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerItemObjRenderer(Item item, int meta, String id)
	{
		OBJLoader.INSTANCE.addDomain(Reference.MODID);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void preinit()
	{
		super.preinit();
	}
	
	@Override
	public void init()
	{
		super.init();
	}
	
	@Override
	public void postinit()
	{
		super.postinit();
	}
	
}
