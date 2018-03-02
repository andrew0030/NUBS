package andrews.ubs.handler;

import andrews.ubs.init.UltimateBlockStormBlocks;
import andrews.ubs.init.UltimateBlockStormItems;
import andrews.ubs.init.UltimateBlockStormTools;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class UltimateBlockStormRecipeHandler {
	
	public static void registerCraftingRecipes() {
		
//shapeless crafting
		GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 2), UltimateBlockStormItems.chopsticks);
		GameRegistry.addShapelessRecipe(new ItemStack(UltimateBlockStormItems.tomato_seeds, 3), UltimateBlockStormItems.tomato);
		
//shaped crafting
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.chopsticks), new Object [] { "sx", "sx", 's', new ItemStack(Items.STICK) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.stone_path, 8), new Object [] {"xx", "ss", 's', new ItemStack(Blocks.STONE_SLAB) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.camp_fire), new Object [] { "xxx", "xlx", "sss", 'l', Blocks.LOG, 's', new ItemStack(Blocks.STONE) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.camp_fire), new Object [] { "xxx", "xlx", "sss", 'l', Blocks.LOG2, 's', new ItemStack(Blocks.STONE) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.camp_fire), new Object [] { "xxx", "xlx", "sss", 'l', UltimateBlockStormBlocks.log, 's', new ItemStack(Blocks.STONE) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.crushed_quartz), new Object [] { "qx", "cx", 'q', new ItemStack(Items.QUARTZ), 'c', new ItemStack(UltimateBlockStormItems.crusher, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.special_clay, 3), new Object [] { "axx", "bxx", "cxx", 'a', new ItemStack(UltimateBlockStormItems.crushed_quartz), 'b', new ItemStack(Items.DYE, 1, 15), 'c', new ItemStack(Items.CLAY_BALL) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.crusher), new Object [] { "xrx", "pop", "psp", 'r', new ItemStack(Items.STICK), 'p', Blocks.PLANKS, 'o', new ItemStack(Blocks.STONE), 's', Blocks.WOODEN_SLAB });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.crusher), new Object [] { "xrx", "pop", "psp", 'r', new ItemStack(Items.STICK), 'p', UltimateBlockStormBlocks.planks, 'o', new ItemStack(Blocks.STONE), 's', UltimateBlockStormBlocks.avocado_slab_half });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.crusher), new Object [] { "xrx", "pop", "psp", 'r', new ItemStack(Items.STICK), 'p', UltimateBlockStormBlocks.planks, 'o', new ItemStack(Blocks.STONE), 's', UltimateBlockStormBlocks.chakra_infused_slab_half });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.uncooked_bowl), new Object [] { "xxx", "uxu", "uuu", 'u', new ItemStack(UltimateBlockStormItems.special_clay) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.flour), new Object [] { "wx", "cx", 'w', new ItemStack(Items.WHEAT), 'c', new ItemStack(UltimateBlockStormItems.crusher, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormTools.kitchen_knife), new Object [] { "xix", "xix", "xcx", 'i', new ItemStack(Items.IRON_INGOT), 'c', new ItemStack(Blocks.HARDENED_CLAY, 15) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.sliced_salad), new Object [] { "xk", "xs", 's', new ItemStack(UltimateBlockStormItems.salad), 'k', new ItemStack(UltimateBlockStormTools.kitchen_knife, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.sliced_tomato), new Object [] { "xk", "xt", 't', new ItemStack(UltimateBlockStormItems.tomato), 'k', new ItemStack(UltimateBlockStormTools.kitchen_knife, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.tomato_salad), new Object [] { "ls", "bt", 'l', new ItemStack(UltimateBlockStormItems.sliced_salad), 's', new ItemStack(UltimateBlockStormItems.salt), 'b', new ItemStack(UltimateBlockStormItems.big_bowl), 't', new ItemStack(UltimateBlockStormItems.sliced_tomato) });
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.CRAFTING_TABLE), new Object [] { "pp", "pp", 'p', UltimateBlockStormBlocks.planks });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.salad), new Object [] { "ks", "sx", 'k', new ItemStack(UltimateBlockStormTools.kitchen_knife), 's', new ItemStack(UltimateBlockStormBlocks.wild_salad) });
		GameRegistry.addShapedRecipe(new ItemStack(Items.SHIELD), new Object [] { "wiw", "www", "xwx", 'w', UltimateBlockStormBlocks.planks, 'i', new ItemStack(Items.IRON_INGOT) });
	//Chakra Infused Things
		GameRegistry.addShapedRecipe(new ItemStack(Items.STICK, 4), new Object [] { "px", "px", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.chakra_infused_ladder, 3), new Object [] { "wsw", "wsw", "wsw", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 0), 's', new ItemStack(Items.STICK) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.planks, 4, 0), new Object [] { "lx", "xx", 'l', new ItemStack(UltimateBlockStormBlocks.log, 1, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.chakra_infused_button, 1), new Object [] { "px", "xx", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 1, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.chakra_infused_stairs, 4), new Object [] { "pxx", "ppx", "ppp", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.chakra_infused_slab_half,  6), new Object [] { "ppp", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.chakra_infused_fence, 3), new Object [] { "psp", "psp", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 0), 's', new ItemStack(Items.STICK) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.chakra_infused_fence_gate), new Object [] { "sps", "sps", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 0), 's', new ItemStack(Items.STICK) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.chakra_infused_door), new Object [] { "wwx", "wwx", "wwx", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.chakra_infused_pressure_plate), new Object [] { "xxx", "xxx", "wwx", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.chakra_infused_trapdoor, 2), new Object [] { "xxx", "www", "www", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormTools.chakra_infused_tool), new Object [] { "sai", "xdp", "ixx", 's', new ItemStack(UltimateBlockStormItems.chakra_infused_shovel_part), 'a', new ItemStack(UltimateBlockStormItems.chakra_infused_axe_part), 'i', new ItemStack(Items.IRON_INGOT), 'd', new ItemStack(Items.STICK), 'p', new ItemStack(UltimateBlockStormItems.chakra_infused_pickaxe_part) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.chakra_infused_shovel_part), new Object [] { "wwx", "www", "xwx", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.chakra_infused_pickaxe_part), new Object [] { "wwx", "xxw", "xxw", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormItems.chakra_infused_axe_part), new Object [] { "wwx", "www", "wxx", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormTools.advanced_chakra_infused_tool), new Object [] { "ddi", "dtd", "ddd", 'd', new ItemStack(Items.DIAMOND), 'i', new ItemStack(Blocks.IRON_BLOCK), 't', new ItemStack(UltimateBlockStormTools.chakra_infused_tool) });
	//Avocado Things
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.avocado_button, 1), new Object [] { "px", "xx", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 1, 1) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.avocado_ladder, 3), new Object [] { "wsw", "wsw", "wsw", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 1, 1), 's', new ItemStack(Items.STICK) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.avocado_pressure_plate), new Object [] { "xxx", "xxx", "wwx", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 1, 1) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.avocado_door), new Object [] { "wwx", "wwx", "wwx", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 1, 1) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.avocado_fence_gate), new Object [] { "sps", "sps", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 1, 1), 's', new ItemStack(Items.STICK) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.avocado_fence, 3), new Object [] { "psp", "psp", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 1, 1), 's', new ItemStack(Items.STICK) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.avocado_slab_half,  6), new Object [] { "ppp", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 1, 1) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.avocado_stairs, 4), new Object [] { "pxx", "ppx", "ppp", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 1, 1) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.avocado_trapdoor, 2), new Object [] { "xxx", "www", "www", 'w', new ItemStack(UltimateBlockStormBlocks.planks, 1, 1) });
		GameRegistry.addShapedRecipe(new ItemStack(Items.STICK, 4), new Object [] { "px", "px", 'p', new ItemStack(UltimateBlockStormBlocks.planks, 1, 1) });
		GameRegistry.addShapedRecipe(new ItemStack(UltimateBlockStormBlocks.planks, 4, 1), new Object [] { "lx", "xx", 'l', new ItemStack(UltimateBlockStormBlocks.log, 1, 1) });


	//registered message
		UtilsLogger.getLogger().info("Registered Crafting Recipes!");
	}
	
	public static void registerFurnaceRecipes() {
		
	//furnace recipes
		GameRegistry.addSmelting(UltimateBlockStormItems.uncooked_bowl, new ItemStack(UltimateBlockStormItems.big_bowl), 1.0F);
		GameRegistry.addSmelting(UltimateBlockStormItems.calamari, new ItemStack(UltimateBlockStormItems.calamari_cooked), 0.35F);
		GameRegistry.addSmelting(UltimateBlockStormItems.bacon, new ItemStack(UltimateBlockStormItems.bacon_cooked), 0.35F);
		GameRegistry.addSmelting(UltimateBlockStormItems.crab_meat, new ItemStack(UltimateBlockStormItems.cooked_crab_meat), 0.35F);
		
	//registered message
		UtilsLogger.getLogger().info("Registered Furnace Recipes!");
	}

}
