package andrews.ubs.init;

import andrews.ubs.Reference;
import andrews.ubs.handler.UltimateBlockStormEnumHandler;
import andrews.ubs.handler.UltimateBlockStormEnumHandler.ClothPieceTypes;
import andrews.ubs.items.ItemBackpack;
import andrews.ubs.items.ItemBacon;
import andrews.ubs.items.ItemBigBowl;
import andrews.ubs.items.ItemCalamari;
import andrews.ubs.items.ItemCalamariCooked;
import andrews.ubs.items.ItemChakraBerries;
import andrews.ubs.items.ItemChakraInfusedAxePart;
import andrews.ubs.items.ItemChakraInfusedPickaxePart;
import andrews.ubs.items.ItemChakraInfusedShovelPart;
import andrews.ubs.items.ItemChopsticks;
import andrews.ubs.items.ItemClothPiece;
import andrews.ubs.items.ItemCookedBacon;
import andrews.ubs.items.ItemCookedCrabMeat;
import andrews.ubs.items.ItemCoverCobblestone;
import andrews.ubs.items.ItemCoverGrass;
import andrews.ubs.items.ItemCoverNether;
import andrews.ubs.items.ItemCoverSand;
import andrews.ubs.items.ItemCoverStone;
import andrews.ubs.items.ItemCrabMeat;
import andrews.ubs.items.ItemCrushedQuartz;
import andrews.ubs.items.ItemCrusher;
import andrews.ubs.items.ItemFlour;
import andrews.ubs.items.ItemPoisonSmokeBomb;
import andrews.ubs.items.ItemRamen;
import andrews.ubs.items.ItemSalad;
import andrews.ubs.items.ItemSalt;
import andrews.ubs.items.ItemShuriken;
import andrews.ubs.items.ItemSlicedSalad;
import andrews.ubs.items.ItemSlicedTomato;
import andrews.ubs.items.ItemSmokeBomb;
import andrews.ubs.items.ItemSpecialClay;
import andrews.ubs.items.ItemTomato;
import andrews.ubs.items.ItemTomatoSalad;
import andrews.ubs.items.ItemTomatoSeeds;
import andrews.ubs.items.ItemTripleBladedScythe;
import andrews.ubs.items.ItemUncookedBowl;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UltimateBlockStormItems {
	
//Sets the Items
	public static Item big_bowl;
	public static Item ramen;
	public static Item chopsticks;
	public static Item crushed_quartz;
	public static Item special_clay;
	public static Item crusher;
	public static Item uncooked_bowl;
	public static Item flour;
	public static Item calamari;
	public static Item calamari_cooked;
	public static Item smoke_bomb;
	public static Item salad;
	public static Item sliced_salad;
	public static Item tomato_seeds;
	public static Item tomato;
	public static Item sliced_tomato;
	public static Item salt;
	public static Item bacon;
	public static Item bacon_cooked;
	public static Item tomato_salad;
	public static Item poison_smoke_bomb;
	public static Item chakra_infused_shovel_part;
	public static Item chakra_infused_pickaxe_part;
	public static Item chakra_infused_axe_part;
	public static Item crab_meat;
	public static Item cooked_crab_meat;
	public static Item chakra_berries;
	public static Item backpack;
	public static Item shuriken;
	public static Item cover_grass;
	public static Item cover_stone;
	public static Item cover_cobblestone;
	public static Item cover_nether;
	public static Item cover_sand;
	public static Item cloth_piece;

	
	public static void init() {
		big_bowl = new ItemBigBowl("big_bowl");
		ramen = new ItemRamen("ramen");
		chopsticks = new ItemChopsticks("chopsticks");
		crushed_quartz = new ItemCrushedQuartz("crushed_quartz");
		special_clay = new ItemSpecialClay("special_clay");
		crusher = new ItemCrusher("crusher");
		uncooked_bowl = new ItemUncookedBowl("uncooked_bowl");
		flour = new ItemFlour("flour");
		calamari = new ItemCalamari("calamari");
		calamari_cooked = new ItemCalamariCooked("calamari_cooked");
		smoke_bomb = new ItemSmokeBomb("smoke_bomb");
		salad = new ItemSalad("salad");
		sliced_salad = new ItemSlicedSalad("sliced_salad");
		tomato_seeds = new ItemTomatoSeeds("tomato_seeds");
		tomato = new ItemTomato("tomato");
		sliced_tomato = new ItemSlicedTomato("sliced_tomato");
		salt = new ItemSalt("salt");
		bacon = new ItemBacon("bacon");
		bacon_cooked = new ItemCookedBacon("bacon_cooked");
		tomato_salad = new ItemTomatoSalad("tomato_salad");
		poison_smoke_bomb = new ItemPoisonSmokeBomb("poison_smoke_bomb");
		chakra_infused_shovel_part = new ItemChakraInfusedShovelPart("chakra_infused_shovel_part");
		chakra_infused_pickaxe_part = new ItemChakraInfusedPickaxePart("chakra_infused_pickaxe_part");
		chakra_infused_axe_part = new ItemChakraInfusedAxePart("chakra_infused_axe_part");
		crab_meat = new ItemCrabMeat("crab_meat");
		cooked_crab_meat = new ItemCookedCrabMeat("cooked_crab_meat");
		chakra_berries = new ItemChakraBerries("chakra_berries");
		backpack = new ItemBackpack("backpack");
		shuriken = new ItemShuriken("shuriken");
		cover_grass = new ItemCoverGrass("cover_grass");
		cover_stone = new ItemCoverStone("cover_stone");
		cover_cobblestone = new ItemCoverCobblestone("cover_cobblestone");
		cover_nether = new ItemCoverNether("cover_nether");
		cover_sand = new ItemCoverSand("cover_sand");
		cloth_piece = new ItemClothPiece("cloth_piece");

	}
	
	public static void register() {
		registerItem(big_bowl);
		registerItem(ramen);
		registerItem(chopsticks);
		registerItem(crushed_quartz);
		registerItem(special_clay);
		registerItem(crusher);
		registerItem(uncooked_bowl);
		registerItem(flour);
		registerItem(calamari);
		registerItem(calamari_cooked);
		registerItem(smoke_bomb);
		registerItem(salad);
		registerItem(sliced_salad);
		registerItem(tomato_seeds);
		registerItem(tomato);
		registerItem(sliced_tomato);
		registerItem(salt);
		registerItem(bacon);
		registerItem(bacon_cooked);
		registerItem(tomato_salad);
		registerItem(poison_smoke_bomb);
		registerItem(chakra_infused_shovel_part);
		registerItem(chakra_infused_pickaxe_part);
		registerItem(chakra_infused_axe_part);
		registerItem(crab_meat);
		registerItem(cooked_crab_meat);
		registerItem(chakra_berries);
		registerItem(backpack);
		registerItem(shuriken);
		registerItem(cover_grass);
		registerItem(cover_stone);
		registerItem(cover_cobblestone);
		registerItem(cover_nether);
		registerItem(cover_sand);
		registerItem(cloth_piece);
		
	}
	
	public static void registerRenders() {
		registerRender(big_bowl);
		registerRender(ramen);
		registerRender(chopsticks);
		registerRender(crushed_quartz);
		registerRender(special_clay);
		registerRender(crusher);
		registerRender(uncooked_bowl);
		registerRender(flour);
		registerRender(calamari);
		registerRender(calamari_cooked);
		registerRender(smoke_bomb);
		registerRender(salad);
		registerRender(sliced_salad);
		registerRender(tomato_seeds);
		registerRender(tomato);
		registerRender(sliced_tomato);
		registerRender(salt);
		registerRender(bacon);
		registerRender(bacon_cooked);
		registerRender(tomato_salad);
		registerRender(poison_smoke_bomb);
		registerRender(chakra_infused_shovel_part);
		registerRender(chakra_infused_pickaxe_part);
		registerRender(chakra_infused_axe_part);
		registerRender(crab_meat);
		registerRender(cooked_crab_meat);
		registerRender(chakra_berries);
		registerRender(backpack);
		registerRender(shuriken);
		registerRender(cover_grass);
		registerRender(cover_stone);
		registerRender(cover_cobblestone);
		registerRender(cover_nether);
		registerRender(cover_sand);
		for(int i = 0; i < UltimateBlockStormEnumHandler.ClothPieceTypes.values().length; i++)
		{
			registerRender(cloth_piece, i, "cloth_piece_" + ClothPieceTypes.values()[i].getName());
		}
		
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
	
	public static void registerRender(Item item, int meta, String fileName)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
		UtilsLogger.getLogger().info("Registered Render for " + item.getUnlocalizedName().substring(5) + "_" + ClothPieceTypes.values()[meta].getName());
	}

}
