package andrews.ubs.proxy;

import andrews.ubs.controlls.KeyBinds;
import andrews.ubs.handlers.UBSEventHandler;
import andrews.ubs.init.BiomeInit;
import andrews.ubs.init.EntityInit;
import andrews.ubs.world.gen.ChakraBerryBushGen;
import andrews.ubs.world.gen.ChakraInfusedBushGen;
import andrews.ubs.world.gen.ChakraInfusedFlowerGen;
import andrews.ubs.world.gen.ChakraInfusedMushroomGen;
import andrews.ubs.world.gen.ChakraInfusedTallBushGen;
import andrews.ubs.world.gen.ForestHutGen;
import andrews.ubs.world.gen.OreGen;
import andrews.ubs.world.gen.TreeGen;
import andrews.ubs.world.gen.WildSaladGen;
import andrews.ubs.world.gen.WildTomatoGen;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
	public void registerItemObjRenderer(Item item, int meta, String id) {}
	public void registerItemRenderer(Item item, int meta, String id) {}
	public void registerItemVariantRenderer(Item item, int meta, String filename, String id) {}
	
//Pre Init
	public void preinit()
	{	
	//To register the server events
		MinecraftForge.EVENT_BUS.register(new UBSEventHandler());
	}
	
//Init
	public void init()
	{
	//Entity Registry
		EntityInit.registerEntities();
		
	//To register the Ore Generator
			GameRegistry.registerWorldGenerator(new OreGen(), 0);
			
	//To register Generation in Biomes
		/** Trees */
		GameRegistry.registerWorldGenerator(new TreeGen(), 0);
		/** Plains */
		GameRegistry.registerWorldGenerator(new WildSaladGen(), 0);
		GameRegistry.registerWorldGenerator(new WildTomatoGen(), 0);
		/** Chakra Biome */
		GameRegistry.registerWorldGenerator(new ChakraInfusedBushGen(), 0);
		GameRegistry.registerWorldGenerator(new ChakraBerryBushGen(), 0);
		GameRegistry.registerWorldGenerator(new ChakraInfusedFlowerGen(), 0);
		GameRegistry.registerWorldGenerator(new ChakraInfusedMushroomGen(), 0);
		GameRegistry.registerWorldGenerator(new ChakraInfusedTallBushGen(), 0);
		GameRegistry.registerWorldGenerator(new ForestHutGen(), 0);
		
	//To register the Biomes
		BiomeInit.registerBiomes();
	}
	
//Post Init
	public void postinit() {}
	
}
