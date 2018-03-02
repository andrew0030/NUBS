package andrews.ubs.init;

import andrews.ubs.Reference;
import andrews.ubs.blocks.BlockAvocadoButton;
import andrews.ubs.blocks.BlockAvocadoDoor;
import andrews.ubs.blocks.BlockAvocadoFence;
import andrews.ubs.blocks.BlockAvocadoFenceGate;
import andrews.ubs.blocks.BlockAvocadoLadder;
import andrews.ubs.blocks.BlockAvocadoPressurePlate;
import andrews.ubs.blocks.BlockAvocadoSlabDouble;
import andrews.ubs.blocks.BlockAvocadoSlabHalf;
import andrews.ubs.blocks.BlockAvocadoStairs;
import andrews.ubs.blocks.BlockAvocadoTrapdoor;
import andrews.ubs.blocks.BlockCampFire;
import andrews.ubs.blocks.BlockChakraInfusedBerryBush;
import andrews.ubs.blocks.BlockChakraInfusedBerryBushWB;
import andrews.ubs.blocks.BlockChakraInfusedBush;
import andrews.ubs.blocks.BlockChakraInfusedButton;
import andrews.ubs.blocks.BlockChakraInfusedDoor;
import andrews.ubs.blocks.BlockChakraInfusedFence;
import andrews.ubs.blocks.BlockChakraInfusedFenceGate;
import andrews.ubs.blocks.BlockChakraInfusedFlower;
import andrews.ubs.blocks.BlockChakraInfusedGrass;
import andrews.ubs.blocks.BlockChakraInfusedLadder;
import andrews.ubs.blocks.BlockChakraInfusedMushroom;
import andrews.ubs.blocks.BlockChakraInfusedPressurePlate;
import andrews.ubs.blocks.BlockChakraInfusedSlabDouble;
import andrews.ubs.blocks.BlockChakraInfusedSlabHalf;
import andrews.ubs.blocks.BlockChakraInfusedStairs;
import andrews.ubs.blocks.BlockChakraInfusedTrapdoor;
import andrews.ubs.blocks.BlockChakraOre;
import andrews.ubs.blocks.BlockCookieJar;
import andrews.ubs.blocks.BlockCookingPot;
import andrews.ubs.blocks.BlockEndChakraOre;
import andrews.ubs.blocks.BlockGrill;
import andrews.ubs.blocks.BlockNetherChakraOre;
import andrews.ubs.blocks.BlockSalad;
import andrews.ubs.blocks.BlockStonePath;
import andrews.ubs.blocks.BlockStoneSalt;
import andrews.ubs.blocks.BlockTomato;
import andrews.ubs.blocks.BlockUBSLeaves;
import andrews.ubs.blocks.BlockUBSLog;
import andrews.ubs.blocks.BlockUBSPlanks;
import andrews.ubs.blocks.BlockUBSSapling;
import andrews.ubs.blocks.BlockWildSalad;
import andrews.ubs.blocks.BlockWildTomato;
import andrews.ubs.blocks.item.ItemBlockVariants;
import andrews.ubs.items.ItemBlockDoor;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UltimateBlockStormBlocks {
	
//Sets the Blocks
	public static Block chakra_infused_stairs;
	public static Block grill;
	public static BlockChakraInfusedSlabHalf chakra_infused_slab_half;
	public static BlockChakraInfusedSlabDouble chakra_infused_slab_double;
	public static Block chakra_infused_fence;
	public static Block chakra_infused_fence_gate;
	public static Block salad;
	public static Block chakra_infused_door;
	public static Block chakra_infused_button;
	public static Block chakra_infused_pressure_plate;
	public static Block chakra_infused_trapdoor;
	public static Block tomato;
	public static BlockBush wild_salad;
	public static Block camp_fire;
	public static Block stone_salt;
	public static Block nether_salt;
	public static Block chakra_infused_ladder;
	public static Block planks, leaves, log, sapling;
	public static Block avocado_pressure_plate;
	public static Block avocado_fence;
	public static Block avocado_fence_gate;
	public static Block avocado_trapdoor;
	public static Block avocado_button;
	public static BlockAvocadoSlabHalf avocado_slab_half;
	public static BlockAvocadoSlabDouble avocado_slab_double;
	public static Block avocado_stairs;
	public static Block avocado_ladder;
	public static Block stone_path;
	public static Block avocado_door;
	public static Block chakra_infused_grass;
	public static Block cookie_jar;
	public static Block chakra_infused_bush;
	public static Block chakra_infused_tall_bush;
	public static Block chakra_infused_berry_bush;
	public static Block chakra_infused_berry_bushwb;
	public static Block chakra_infused_mushroom;
	public static Block chakra_infused_flower;
	public static Block wild_tomato;
	public static Block chakra_ore;
	public static Block nether_chakra_ore;
	public static Block end_chakra_ore;
	public static Block cooking_pot;
	
	public static void init() {
		chakra_infused_stairs = new BlockChakraInfusedStairs("chakra_infused_stairs");
		grill = new BlockGrill("grill");
		chakra_infused_slab_half = new BlockChakraInfusedSlabHalf("chakra_infused_slab_half");
		chakra_infused_slab_double = new BlockChakraInfusedSlabDouble("chakra_infused_slab_double");
		chakra_infused_fence = new BlockChakraInfusedFence("chakra_infused_fence");
		chakra_infused_fence_gate = new BlockChakraInfusedFenceGate("chakra_infused_fence_gate");
		salad = new BlockSalad("salad");
		chakra_infused_door = new BlockChakraInfusedDoor("chakra_infused_door");
		chakra_infused_button = new BlockChakraInfusedButton("chakra_infused_button");
		chakra_infused_pressure_plate = new BlockChakraInfusedPressurePlate("chakra_infused_pressure_plate");
		chakra_infused_trapdoor = new BlockChakraInfusedTrapdoor("chakra_infused_trapdoor");
		tomato = new BlockTomato("tomato");
		wild_salad = new BlockWildSalad("wild_salad");
		camp_fire = new BlockCampFire("camp_fire");
		stone_salt = new BlockStoneSalt("stone_salt");
		nether_salt = new BlockStoneSalt("nether_salt");
		chakra_infused_ladder = new BlockChakraInfusedLadder("chakra_infused_ladder");
		planks = new BlockUBSPlanks("planks");
		log = new BlockUBSLog("log");
		leaves = new BlockUBSLeaves("leaves");
		sapling = new BlockUBSSapling("sapling");
		avocado_pressure_plate = new BlockAvocadoPressurePlate("avocado_pressure_plate");
		avocado_fence = new BlockAvocadoFence("avocado_fence");
		avocado_fence_gate = new BlockAvocadoFenceGate("avocado_fence_gate");
		avocado_trapdoor = new BlockAvocadoTrapdoor("avocado_trapdoor");
		avocado_button = new BlockAvocadoButton("avocado_button");
		avocado_slab_half = new BlockAvocadoSlabHalf("avocado_slab_half");
		avocado_slab_double = new BlockAvocadoSlabDouble("avocado_slab_double");
		avocado_stairs = new BlockAvocadoStairs("avocado_stairs");
		avocado_ladder = new BlockAvocadoLadder("avocado_ladder");
		stone_path = new BlockStonePath("stone_path");
		avocado_door = new BlockAvocadoDoor("avocado_door");
		chakra_infused_grass = new BlockChakraInfusedGrass("chakra_infused_grass");
		cookie_jar = new BlockCookieJar("cookie_jar");
		chakra_infused_bush = new BlockChakraInfusedBush("chakra_infused_bush");
		chakra_infused_tall_bush = new BlockChakraInfusedBush("chakra_infused_tall_bush");
		chakra_infused_berry_bush = new BlockChakraInfusedBerryBush("chakra_infused_berry_bush");
		chakra_infused_berry_bushwb = new BlockChakraInfusedBerryBushWB("chakra_infused_berry_bushwb");
		chakra_infused_mushroom = new BlockChakraInfusedMushroom("chakra_infused_mushroom");
		chakra_infused_flower = new BlockChakraInfusedFlower("chakra_infused_flower");
		wild_tomato = new BlockWildTomato("wild_tomato");
		chakra_ore = new BlockChakraOre("chakra_ore");
		nether_chakra_ore = new BlockNetherChakraOre("nether_chakra_ore");
		end_chakra_ore = new BlockEndChakraOre("end_chakra_ore");
		cooking_pot = new BlockCookingPot("cooking_pot");
		
	}

	public static void register() {
		registerBlock(chakra_infused_stairs);
		registerBlock(grill);
		registerBlock(chakra_infused_slab_half, new ItemSlab(chakra_infused_slab_half, chakra_infused_slab_half, chakra_infused_slab_double));
		GameRegistry.register(chakra_infused_slab_double);
		registerBlock(chakra_infused_fence);
		registerBlock(chakra_infused_fence_gate);
		GameRegistry.register(salad);
		registerBlock(chakra_infused_door, new ItemBlockDoor(chakra_infused_door));
		registerBlock(chakra_infused_button);
		registerBlock(chakra_infused_pressure_plate);
		registerBlock(chakra_infused_trapdoor);
		GameRegistry.register(tomato);
		registerBlock(wild_salad);
		registerBlock(camp_fire);
		registerBlock(stone_salt);
		registerBlock(nether_salt);
		registerBlock(chakra_infused_ladder);
		registerBlock(planks, new ItemBlockVariants(planks));
		registerBlock(log, new ItemBlockVariants(log));
		registerBlock(leaves, new ItemBlockVariants(leaves));
		registerBlock(sapling, new ItemBlockVariants(sapling));
		registerBlock(avocado_pressure_plate);
		registerBlock(avocado_fence);
		registerBlock(avocado_fence_gate);
		registerBlock(avocado_trapdoor);
		registerBlock(avocado_button);
		registerBlock(avocado_slab_half, new ItemSlab(avocado_slab_half, avocado_slab_half, avocado_slab_double));
		GameRegistry.register(avocado_slab_double);
		registerBlock(avocado_stairs);
		registerBlock(avocado_ladder);
		registerBlock(stone_path);
		registerBlock(avocado_door, new ItemBlockDoor(avocado_door));
		registerBlock(chakra_infused_grass);
		registerBlock(cookie_jar);
		registerBlock(chakra_infused_bush);
		registerBlock(chakra_infused_tall_bush);
		registerBlock(chakra_infused_berry_bush);
		GameRegistry.register(chakra_infused_berry_bushwb);
		registerBlock(chakra_infused_mushroom);
		registerBlock(chakra_infused_flower);
		GameRegistry.register(wild_tomato);
		registerBlock(chakra_ore);
		registerBlock(nether_chakra_ore);
		registerBlock(end_chakra_ore);
		registerBlock(cooking_pot);
		
	}
	
	public static void registerRenders() {
		registerRender(chakra_infused_stairs);
		registerRender(grill);
		registerRender(chakra_infused_slab_half);
		registerRender(chakra_infused_fence);
		registerRender(chakra_infused_fence_gate);
		registerRender(chakra_infused_door);
		registerRender(chakra_infused_button);
		registerRender(chakra_infused_pressure_plate);
		registerRender(chakra_infused_trapdoor);
		registerRender(wild_salad);
		registerRender(camp_fire);
		registerRender(stone_salt);
		registerRender(nether_salt);
		registerRender(chakra_infused_ladder);
		registerRender(avocado_pressure_plate);
		registerRender(avocado_fence);
		registerRender(avocado_fence_gate);
		registerRender(avocado_trapdoor);
		registerRender(avocado_button);
		registerRender(avocado_slab_half);
		registerRender(avocado_stairs);
		registerRender(avocado_ladder);
		registerRender(stone_path);
		registerRender(avocado_door);
		registerRender(chakra_infused_grass);
		registerRender(cookie_jar);
		registerRender(chakra_infused_bush);
		registerRender(chakra_infused_tall_bush);
		registerRender(chakra_infused_berry_bush);
		registerRender(chakra_infused_mushroom);
		registerRender(chakra_infused_flower);
		registerRender(chakra_ore);
		registerRender(nether_chakra_ore);
		registerRender(end_chakra_ore);
		registerRender(cooking_pot);
		
		for(int i = 0; i < BlockUBSPlanks.EnumType.values().length; i++)
		{
			registerRenderWithVariants(planks, i, "planks_" + BlockUBSPlanks.EnumType.values()[i].getName());
			registerRenderWithVariants(log, i, "log_" + BlockUBSPlanks.EnumType.values()[i].getName());
			registerRenderWithVariants(leaves, i, "leaves_" + BlockUBSPlanks.EnumType.values()[i].getName());
			registerRenderWithVariants(sapling, i, "sapling_" + BlockUBSPlanks.EnumType.values()[i].getName());
		}
		
	}

	public static void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		UtilsLogger.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerBlock(Block block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		UtilsLogger.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		UtilsLogger.getLogger().info("Registered Render for: " + block.getUnlocalizedName().substring(5));	
	}
	
//With Variants
	public static void registerRenderWithVariants(Block block, int meta, String filename) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), "inentory"));
		UtilsLogger.getLogger().info("Registered Render for: " + block.getUnlocalizedName().substring(5));	
	}

}
