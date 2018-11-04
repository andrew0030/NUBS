package andrews.ubs.init;

import java.util.ArrayList;
import java.util.List;

import andrews.ubs.Reference;
import andrews.ubs.objects.items.ItemBackpack;
import andrews.ubs.objects.items.ItemBacon;
import andrews.ubs.objects.items.ItemBaconCooked;
import andrews.ubs.objects.items.ItemBigBowl;
import andrews.ubs.objects.items.ItemCalamari;
import andrews.ubs.objects.items.ItemCalamariCooked;
import andrews.ubs.objects.items.ItemChakraBerries;
import andrews.ubs.objects.items.ItemChakraInfusedAxePart;
import andrews.ubs.objects.items.ItemChakraInfusedPickaxePart;
import andrews.ubs.objects.items.ItemChakraInfusedShovelPart;
import andrews.ubs.objects.items.ItemChopsticks;
import andrews.ubs.objects.items.ItemCoverCobblestone;
import andrews.ubs.objects.items.ItemCoverGrass;
import andrews.ubs.objects.items.ItemCoverNether;
import andrews.ubs.objects.items.ItemCoverSand;
import andrews.ubs.objects.items.ItemCoverStone;
import andrews.ubs.objects.items.ItemCrabMeat;
import andrews.ubs.objects.items.ItemCrabMeatCooked;
import andrews.ubs.objects.items.ItemCrushedQuartz;
import andrews.ubs.objects.items.ItemCrusher;
import andrews.ubs.objects.items.ItemFlour;
import andrews.ubs.objects.items.ItemPoisonSmokeBomb;
import andrews.ubs.objects.items.ItemRamen;
import andrews.ubs.objects.items.ItemSalad;
import andrews.ubs.objects.items.ItemSalt;
import andrews.ubs.objects.items.ItemShuriken;
import andrews.ubs.objects.items.ItemSlicedSalad;
import andrews.ubs.objects.items.ItemSlicedTomato;
import andrews.ubs.objects.items.ItemSmokeBomb;
import andrews.ubs.objects.items.ItemSpecialClay;
import andrews.ubs.objects.items.ItemTomato;
import andrews.ubs.objects.items.ItemTomatoSalad;
import andrews.ubs.objects.items.ItemTomatoSeeds;
import andrews.ubs.objects.items.ItemUncookedBowl;
import andrews.ubs.objects.tools.ItemAdvancedChakraInfusedTool;
import andrews.ubs.objects.tools.ItemChakraInfusedTool;
import andrews.ubs.objects.tools.ItemKatana;
import andrews.ubs.objects.tools.ItemKitchenKnife;
import andrews.ubs.objects.tools.ItemKubikiribocho;
import andrews.ubs.objects.tools.ItemShibuki;
import andrews.ubs.objects.tools.ItemTripleBladedScythe;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit
{
	public static final List<Item> ITEMS = new ArrayList<Item>();

//Materials
	public static final ToolMaterial IRON_MATERIAL = EnumHelper.addToolMaterial(Reference.MODID + ":Iron", 2, 300, 3.0F, 1.0F, 12);
	public static final ToolMaterial CHAKRA_MATERIAL = EnumHelper.addToolMaterial(Reference.MODID + ":Chakra", 2, 1000, 3.0F, 4.0F, 12);
	public static final ToolMaterial ADVANCED_CHAKRA_MATERIAL = EnumHelper.addToolMaterial(Reference.MODID + ":AdvancedChakra", 3, 2000, 4.5F, 5.0F, 12);
	public static final ToolMaterial KATANA_MATERIAL = EnumHelper.addToolMaterial(Reference.MODID + ":Iron", 2, 800, 3.0F, 7.0F, 12);
	public static final ToolMaterial TRIPLE_BLADED_SCYTHE_MATERIAL = EnumHelper.addToolMaterial(Reference.MODID + ":RedIron", 2, 2000, 3.0F, 11.0F, 12);
	public static final ToolMaterial KUBIKIRIBOCHO_MATERIAL = EnumHelper.addToolMaterial(Reference.MODID + ":shwordIron", 2, 2000, 3.0F, 11.0F, 12);
	public static final ToolMaterial SHIBUKI_MATERIAL = EnumHelper.addToolMaterial(Reference.MODID + ":ShibukiIron", 2, 2000, 3.0F, 9.0F, 12);
	
//Items
	public static final Item CHAKRA_BERRIES = new ItemChakraBerries("chakra_berries");
	public static final Item BACON = new ItemBacon("bacon");
	public static final Item CALAMARI = new ItemCalamari("calamari");
	public static final Item BIG_BOWL = new ItemBigBowl("big_bowl");
	public static final Item RAMEN = new ItemRamen("ramen");
	public static final Item CHOPSTICKS = new ItemChopsticks("chopsticks");
	public static final Item CRUSHED_QUARTZ = new ItemCrushedQuartz("crushed_quartz");
	public static final Item SPECIAL_CLAY = new ItemSpecialClay("special_clay");
	public static final Item CRUSHER = new ItemCrusher("crusher");
	public static final Item UNCOOKED_BOWL = new ItemUncookedBowl("uncooked_bowl");
	public static final Item FLOUR = new ItemFlour("flour");
	public static final Item CALAMARI_COOKED = new ItemCalamariCooked("calamari_cooked");
	public static final Item SALAD = new ItemSalad("salad");
	public static final Item SLICED_SALAD = new ItemSlicedSalad("sliced_salad");
	public static final Item TOMATO_SEEDS = new ItemTomatoSeeds("tomato_seeds");
	public static final Item TOMATO = new ItemTomato("tomato");
	public static final Item SLICED_TOMATO = new ItemSlicedTomato("sliced_tomato");
	public static final Item SALT = new ItemSalt("salt");
	public static final Item BACON_COOKED = new ItemBaconCooked("bacon_cooked");
	public static final Item TOMATO_SALAD = new ItemTomatoSalad("tomato_salad");
	public static final Item CHAKRA_INFUSED_SHOVEL_PART = new ItemChakraInfusedShovelPart("chakra_infused_shovel_part");
	public static final Item CHAKRA_INFUSED_PICKAXE_PART = new ItemChakraInfusedPickaxePart("chakra_infused_pickaxe_part");
	public static final Item CHAKRA_INFUSED_AXE_PART = new ItemChakraInfusedAxePart("chakra_infused_axe_part");
	public static final Item CRAB_MEAT = new ItemCrabMeat("crab_meat");
	public static final Item CRAB_MEAT_COOKED = new ItemCrabMeatCooked("crab_meat_cooked");
	public static final Item BACKPACK = new ItemBackpack("backpack");
	public static final Item COVER_GRASS = new ItemCoverGrass("cover_grass");
	public static final Item COVER_STONE = new ItemCoverStone("cover_stone");
	public static final Item COVER_COBBLESTONE = new ItemCoverCobblestone("cover_cobblestone");
	public static final Item COVER_NETHER = new ItemCoverNether("cover_nether");
	public static final Item COVER_SAND = new ItemCoverSand("cover_sand");
	
//Weapons and Tools
	public static final Item SMOKE_BOMB = new ItemSmokeBomb("smoke_bomb");
	public static final Item POISON_SMOKE_BOMB = new ItemPoisonSmokeBomb("poison_smoke_bomb");
	public static final Item SHURIKEN = new ItemShuriken("shuriken");
	public static final Item KITCHEN_KNIFE = new ItemKitchenKnife("kitchen_knife", IRON_MATERIAL);
	public static final Item CHAKRA_INFUSED_TOOL = new ItemChakraInfusedTool("chakra_infused_tool", CHAKRA_MATERIAL);
	public static final Item ADVANCED_CHAKRA_INFUSED_TOOL = new ItemAdvancedChakraInfusedTool("advanced_chakra_infused_tool", ADVANCED_CHAKRA_MATERIAL);
	public static final Item KATANA = new ItemKatana("katana", KATANA_MATERIAL);
	public static final Item TRIPLE_BLADED_SCYTHE = new ItemTripleBladedScythe("triple_bladed_scythe", TRIPLE_BLADED_SCYTHE_MATERIAL);
	public static final Item KUBIKIRIBOCHO = new ItemKubikiribocho("kubikiribocho", KUBIKIRIBOCHO_MATERIAL);
	public static final Item SHIBUKI = new ItemShibuki("shibuki", SHIBUKI_MATERIAL);
	
}
