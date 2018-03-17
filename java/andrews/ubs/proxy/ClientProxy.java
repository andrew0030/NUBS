package andrews.ubs.proxy;

import org.apache.logging.log4j.Level;

import andrews.ubs.handler.UltimateBlockStormClientEventHandler;
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
import andrews.ubs.utils.UtilsLogger;
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
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void preinit() {
		
	//To register the Renders
		UltimateBlockStormItems.registerRenders();
    	UltimateBlockStormBlocks.registerRenders();
    	UltimateBlockStormTools.registerRenders();
    	
    //To register the Entity Renderes
    	UltimateBlockStormRenderHandler.registerEntityRenderers();
			
	}

	@Override
	public void init() {
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new RendererJar());
		
		registerBlockColorHandler(UltimateBlockStormBlocks.falling_trap_grass);
	}

	@Override
	public void postinit() 
	{
		MinecraftForge.EVENT_BUS.register(new ChakraBar());
		MinecraftForge.EVENT_BUS.register(new StaminaBar());
		MinecraftForge.EVENT_BUS.register(new HighJumpsButton());
		MinecraftForge.EVENT_BUS.register(new WaterWalkButton());
		MinecraftForge.EVENT_BUS.register(new UltimateBlockStormClientEventHandler());
	}
	
/**
 *Block Color Handler 
 */
	private void registerBlockColorHandler(Block block)
	{
        if (block instanceof IBlockColor)
        {
            Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((IBlockColor)block, block);
        }
    }
    
/**
 *Item Color Handler 
 */
    private void registerItemColorHandler(Item item)
    {
        if (item instanceof IItemColor)
        {
            Minecraft.getMinecraft().getItemColors().registerItemColorHandler((IItemColor)item, item);
        }
    }
}