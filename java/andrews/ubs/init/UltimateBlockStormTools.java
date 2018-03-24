package andrews.ubs.init;

import andrews.ubs.Reference;
import andrews.ubs.items.ItemAdvancedChakraInfusedTool;
import andrews.ubs.items.ItemChakraInfusedTool;
import andrews.ubs.items.ItemKatana;
import andrews.ubs.items.ItemKitchenKnife;
import andrews.ubs.items.ItemTripleBladedScythe;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UltimateBlockStormTools 
{
	
//Create Materials
	public static final ToolMaterial ironMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":Iron", 2, 300, 3.0F, 1.0F, 12);
	public static final ToolMaterial chakraMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":Chakra", 2, 1000, 3.0F, 4.0F, 12);
	public static final ToolMaterial advancedChakraMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":AdvancedChakra", 3, 2000, 4.5F, 5.0F, 12);
	public static final ToolMaterial katanaMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":Iron", 2, 800, 3.0F, 7.0F, 12);
	public static final ToolMaterial tripleBladedScytheMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":RedIron", 2, 2000, 3.0F, 11.0F, 12);

	
//Tools
	public static ItemKitchenKnife kitchen_knife;
	public static ItemChakraInfusedTool chakra_infused_tool;
	public static ItemAdvancedChakraInfusedTool advanced_chakra_infused_tool;
	public static ItemKatana katana;
	public static ItemTripleBladedScythe triple_bladed_scythe;
	
//Tools Init
	public static void init() 
	{
		kitchen_knife = new ItemKitchenKnife(ironMaterial, "kitchen_knife");
		chakra_infused_tool = new ItemChakraInfusedTool(chakraMaterial, "chakra_infused_tool");
		advanced_chakra_infused_tool = new ItemAdvancedChakraInfusedTool(advancedChakraMaterial, "advanced_chakra_infused_tool");
		katana = new ItemKatana(katanaMaterial, "katana");
		triple_bladed_scythe = new ItemTripleBladedScythe(tripleBladedScytheMaterial, "triple_bladed_scythe");
	}

//Tools Registration
	public static void register() 
	{
		registerItem(kitchen_knife);
		registerItem(chakra_infused_tool);
		registerItem(advanced_chakra_infused_tool);
		registerItem(katana);
		registerItem(triple_bladed_scythe);
	}
	
//Tools Renderer Registration
	public static void registerRenders() 
	{
		registerRender(kitchen_knife);
		registerRender(chakra_infused_tool);
		registerRender(advanced_chakra_infused_tool);
		registerRender(katana);
	}
	
	public static void registerItem(Item item) 
	{
		GameRegistry.register(item);
		UtilsLogger.getLogger().info("Registered Item: " + item.getUnlocalizedName().substring(5));	
	}
	
	public static void registerRender(Item item) 
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		UtilsLogger.getLogger().info("Registered Render for " + item.getUnlocalizedName().substring(5));
	}
}
