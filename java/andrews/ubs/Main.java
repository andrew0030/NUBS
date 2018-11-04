package andrews.ubs;

import andrews.ubs.proxy.CommonProxy;
import andrews.ubs.tabs.BlockTab;
import andrews.ubs.tabs.FoodTab;
import andrews.ubs.tabs.ItemTab;
import andrews.ubs.tabs.ToolsTab;
import andrews.ubs.util.logger.UBSLogger;
import andrews.ubs.util.registrymanager.RegistryManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.NAME)
public class Main
{
	//###################################################
	//  Developer Mode			   						#
	//Used To Enable and Disable Logger Information   	#
	//								   					#
	public static final boolean DEVELOPER_MODE = true;//#
	//###################################################
	
//An instance for the Mod
	@Instance(Reference.MODID)
    public static Main instance;
	
//Server and Client Proxy
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
//Sets the Tabs
	public static final CreativeTabs itemtab = new ItemTab("UBS Items");
	public static final CreativeTabs foodtab = new FoodTab("UBS Foods");
	public static final CreativeTabs blocktab = new BlockTab("UBS Blocks");
	public static final CreativeTabs tooltab = new ToolsTab("UBS Tools");
    
//PreInit
    @EventHandler
    public static void preinit(FMLPreInitializationEvent event)
    {
    	UBSLogger.getLogger().info("[Main] Forge PreInitializationEvent");
    	RegistryManager.preInitRegistries();
    }
    
//Init
    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
    	UBSLogger.getLogger().info("[Main] Forge InitializationEvent");
    	RegistryManager.initRegistries();
    }
    
//PostInit
    @EventHandler
    public static void postinit(FMLPostInitializationEvent event)
    {
    	UBSLogger.getLogger().info("[Main] Forge PostInitializationEvent");
    	RegistryManager.postInitRegistries();
    }  
}
