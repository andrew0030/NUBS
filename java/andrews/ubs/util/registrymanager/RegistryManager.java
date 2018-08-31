package andrews.ubs.util.registrymanager;

import andrews.ubs.Main;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.objects.blocks.BlockAvocadoDoor;
import andrews.ubs.objects.blocks.item.ItemBlockDoor;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryManager 
{	
	
//Pre Init
	public static void preInitRegistries()
	{
		Main.proxy.preinit();
	}
	
//Init
	public static void initRegistries()
	{
		Main.proxy.init();
	}
	
//Post Init
	public static void postInitRegistries()
	{
		Main.proxy.postinit();
	}
	
//Used to register the items
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
//Used to register the items from the blocks
	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
	}
	
//Used to register the models for the items and Blocks
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{		
		for(Item item : ItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : BlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
}