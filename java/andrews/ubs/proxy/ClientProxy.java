package andrews.ubs.proxy;

import andrews.ubs.handler.UltimateBlockStormClientEventHandler;
import andrews.ubs.handler.UltimateBlockStormRenderHandler;
import andrews.ubs.handler.GuiOverlay.ChakraBar;
import andrews.ubs.handler.GuiOverlay.HighJumpsButton;
import andrews.ubs.handler.GuiOverlay.StaminaBar;
import andrews.ubs.handler.GuiOverlay.WaterWalkButton;
import andrews.ubs.init.UltimateBlockStormBlocks;
import andrews.ubs.init.UltimateBlockStormItems;
import andrews.ubs.init.UltimateBlockStormTools;
import andrews.ubs.tileentity.TileEntityJar;
import andrews.ubs.tileentity.render.RendererJar;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void preinit() {
		super.preinit();
	//To register the Renders
		UltimateBlockStormItems.registerRenders();
    	UltimateBlockStormBlocks.registerRenders();
    	UltimateBlockStormTools.registerRenders();
    	
    //To register the Entity Renderes
    	UltimateBlockStormRenderHandler.registerEntityRenderers();
			
	}

	@Override
	public void init() {
		super.init();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new RendererJar());
		
		registerBlockColorHandler(UltimateBlockStormBlocks.falling_trap_grass);
	}

	@Override
	public void postinit() 
	{
		super.postinit();
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
	    Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler( new IBlockColor()
	    {
	    	@Override
	    	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex)
	    	{
	    		return BiomeColorHelper.getGrassColorAtPos(worldIn, pos);
	    	}
	    }, block);
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