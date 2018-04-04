package andrews.ubs.init;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.entity.EntityCrab;
import andrews.ubs.entity.EntityPoisonSmokeBomb;
import andrews.ubs.entity.EntityShuriken;
import andrews.ubs.entity.EntitySmokeBomb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class UltimateBlockStormEntities 
{
	public static void registerEntities()
	{
		
	//Smoke Bomb
		EntityRegistry.registerModEntity(EntitySmokeBomb.class, "SmokeBomb", -1, UltimateBlockStormMod.instance, 64, 1, true);
		
	//Poison Smoke Bomb
		EntityRegistry.registerModEntity(EntityPoisonSmokeBomb.class, "PoisonSmokeBomb", 0, UltimateBlockStormMod.instance, 64, 1, true);
		
	//Crab
		registerEntity("Crab", EntityCrab.class, Reference.ENTITY_CRAB, 32, 15759104, 15779840);
		
	//Poison Smoke Bomb
		EntityRegistry.registerModEntity(EntityShuriken.class, "Shuriken", 1, UltimateBlockStormMod.instance, 64, 1, true);
		
//		EntityRegistry.addSpawn(EntityCrab.class.getName(), 10, 1, 3, EnumCreatureType.CREATURE, biomes);
	}
	
/**
 * This is used to make The registration of entities easier
 */
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) 
	{
		
		EntityRegistry.registerModEntity(entity, name, id, UltimateBlockStormMod.instance, range, 1, true, color1, color2);
	}
	
}
