package andrews.ubs.util.registrymanager;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaCap;
import andrews.ubs.capabilities.ninja.NinjaStorage;
import andrews.ubs.entity.behavior.UBSBehavior;
import andrews.ubs.handlers.UBSCapabilityHandler;
import andrews.ubs.handlers.UBSFuelHandler;
import andrews.ubs.handlers.UBSSoundHandler;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.EntityInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.network.PacketHandler;
import andrews.ubs.objects.blocks.BlockAvocadoDoor;
import andrews.ubs.objects.blocks.item.ItemBlockDoor;
import andrews.ubs.util.interfaces.IHasModel;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStamina;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryManager 
{	
//Used to register the items from the blocks
	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
	}
	
//Used to register the items
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
//Used to register the models for the items and Blocks
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{	
		for(Block block : BlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
		
		for(Item item : ItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
	}
	
//Pre Init
	public static void preInitRegistries()
	{
	//To make a dispenser dispense entities and not just the items (smoke bombs)
    	UBSBehavior.DispenserBehaviorRegistry();
		
    //The Capability Handler
    	MinecraftForge.EVENT_BUS.register(new UBSCapabilityHandler());
    	
    //Capabillities
    	UBSCapabilityHandler.register();
    
    //Network Handler
    	PacketHandler.init(Reference.MODID);
    	
		Main.proxy.preinit();
	}
	
//Init
	public static void initRegistries()
	{	
	//SoundHandler Registry
		UBSSoundHandler.registerSounds();
		
	//Fuel Handler Registry
		GameRegistry.registerFuelHandler(new UBSFuelHandler());
		
		Main.proxy.init();
	}
	
//Post Init
	public static void postInitRegistries()
	{
		Main.proxy.postinit();
	}
}