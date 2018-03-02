package andrews.ubs;

import andrews.ubs.capabilities.chakra.Chakra;
import andrews.ubs.capabilities.chakra.ChakraStorage;
import andrews.ubs.capabilities.stamina.Stamina;
import andrews.ubs.capabilities.stamina.StaminaStorage;
import andrews.ubs.gui.GuiHandler;
import andrews.ubs.handler.UltimateBlockStormCapabilityHandler;
import andrews.ubs.handler.UltimateBlockStormEventHandler;
import andrews.ubs.handler.UltimateBlockStormFuelHandler;
import andrews.ubs.handler.UltimateBlockStormRecipeHandler;
import andrews.ubs.handler.UltimateBlockStormSoundHandler;
import andrews.ubs.init.UltimateBlockStormBlocks;
import andrews.ubs.init.UltimateBlockStormItems;
import andrews.ubs.init.UltimateBlockStormTools;
import andrews.ubs.network.PacketHandler;
import andrews.ubs.proxy.CommonProxy;
import andrews.ubs.tabs.UltimateBlockStormBlockTab;
import andrews.ubs.tabs.UltimateBlockStormFoodTab;
import andrews.ubs.tabs.UltimateBlockStormItemTab;
import andrews.ubs.tabs.UltimateBlockStormToolsTab;
import andrews.ubs.tileentity.TileEntityJar;
import andrews.ubs.utils.DispenserBehavior;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.IStamina;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.NAME)
public class UltimateBlockStormMod {
	
    @Instance(Reference.MODID)
    public static UltimateBlockStormMod instance;
	
//Server and Client Proxy
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
//Sets the Tabs
    public UltimateBlockStormItemTab itemtab;
    public UltimateBlockStormBlockTab blocktab;
    public UltimateBlockStormFoodTab foodtab;
    public UltimateBlockStormToolsTab tooltab;
    
/**   
 *PreInit
 */   
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	
    //Logger message
    	UtilsLogger.getLogger().info("Pre Initialize [#}<======================================================================>{#]");
    	
    //creative tabs
    	blocktab = new UltimateBlockStormBlockTab();
    	itemtab = new UltimateBlockStormItemTab();
    	foodtab = new UltimateBlockStormFoodTab();
    	tooltab = new UltimateBlockStormToolsTab();
    	
    //items and blocks
    	UltimateBlockStormBlocks.init();
    	UltimateBlockStormBlocks.register();
    	UltimateBlockStormTools.init();
    	UltimateBlockStormTools.register();
    	UltimateBlockStormItems.init();
    	UltimateBlockStormItems.register();
    	
    //To make a dispenser dispense entities and not just the items (smoke bombs)
    	DispenserBehavior.DispenserBehaviorRegistry();
    	
    //Capabilities Handler
    	MinecraftForge.EVENT_BUS.register(new UltimateBlockStormCapabilityHandler());
    	
    //Capabilities
    	CapabilityManager.INSTANCE.register(IChakra.class, new ChakraStorage(), Chakra.class);
    	CapabilityManager.INSTANCE.register(IStamina.class, new StaminaStorage(), Stamina.class);
    	
    	PacketHandler.init(Reference.MODID);
    	
    //To load the ClientPreInitProxy and ServerPreInitProxy
    	proxy.preinit();
    	
    }
    
/**
 *Init
 */
	@EventHandler
    public void init(FMLInitializationEvent event) {
		
	//Logger message
    	UtilsLogger.getLogger().info("Initialize [#}<======================================================================>{#]");	
		
	//To Register Recipes
		UltimateBlockStormRecipeHandler.registerCraftingRecipes();
		UltimateBlockStormRecipeHandler.registerFurnaceRecipes();
		
	//to Register TileEntities
		GameRegistry.registerTileEntity(TileEntityJar.class, Reference.MODID + "TileEntityJar");
		
	//To make blocks flammable
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.log, 5, 5);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.planks, 5, 20);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.chakra_infused_slab_half, 5, 20);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.chakra_infused_slab_double, 5, 20);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.chakra_infused_fence, 5, 20);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.chakra_infused_fence_gate, 5, 20);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.leaves, 30, 60);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.avocado_fence, 5, 20);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.avocado_fence_gate, 5, 20);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.chakra_infused_stairs, 5, 20);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.avocado_stairs, 5, 20);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.avocado_slab_half, 5, 20);
		Blocks.FIRE.setFireInfo(UltimateBlockStormBlocks.avocado_slab_double, 5, 20);
		
	//To create furnace fuel
		GameRegistry.registerFuelHandler(new UltimateBlockStormFuelHandler());
		
	//To load the sounds
		UltimateBlockStormSoundHandler.init();
    	
	//To load the ClientInitProxy and ServerInitProxy
    	proxy.init();
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	
    }
	
/**
 *PostInit
 */
    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    	
    //Logger message
    	UtilsLogger.getLogger().info("Post Initialize [#}<======================================================================>{#]");
    	
    //To load the ClientPostInitProxy and ServerPostInitProxy
    	proxy.postinit();
    	
    }
    
}
