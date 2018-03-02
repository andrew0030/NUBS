package andrews.ubs.proxy;

import andrews.ubs.capabilities.chakra.Chakra;
import andrews.ubs.capabilities.chakra.ChakraStorage;
import andrews.ubs.handler.UltimateBlockStormEventHandler;
import andrews.ubs.handler.UltimateBlockStormRenderHandler;
import andrews.ubs.handler.GuiOverlay.ChakraBar;
import andrews.ubs.handler.GuiOverlay.HighJumpsButton;
import andrews.ubs.handler.GuiOverlay.StaminaBar;
import andrews.ubs.handler.GuiOverlay.WaterWalkButton;
import andrews.ubs.init.UltimateBlockStormBiomes;
import andrews.ubs.init.UltimateBlockStormBlocks;
import andrews.ubs.init.UltimateBlockStormEntities;
import andrews.ubs.init.UltimateBlockStormItems;
import andrews.ubs.init.UltimateBlockStormTools;
import andrews.ubs.tileentity.TileEntityJar;
import andrews.ubs.tileentity.render.RendererJar;
import andrews.ubs.utils.IChakra;
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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy implements CommonProxy {

	@Override
	public void preinit() {
		
	//To register the Renders
		UltimateBlockStormItems.registerRenders();
    	UltimateBlockStormBlocks.registerRenders();
    	UltimateBlockStormTools.registerRenders();
		
    //To register the entities client sided
    	UltimateBlockStormEntities.registerEntities();
    	
    //To register the Entity Renderes
    	UltimateBlockStormRenderHandler.registerEntityRenderers();
    	
    //To load the events
		MinecraftForge.EVENT_BUS.register(new UltimateBlockStormEventHandler());
			
	}

	@Override
	public void init() {
		
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
		UltimateBlockStormBiomes.registerBiomes();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new RendererJar());
		
	}

	@Override
	public void postinit() 
	{
		MinecraftForge.EVENT_BUS.register(new ChakraBar());
		MinecraftForge.EVENT_BUS.register(new StaminaBar());
		MinecraftForge.EVENT_BUS.register(new HighJumpsButton());
		MinecraftForge.EVENT_BUS.register(new WaterWalkButton());
	}
}