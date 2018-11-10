package andrews.ubs.init;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.entity.EntityCrab;
import andrews.ubs.entity.EntityPoisonSmokeBomb;
import andrews.ubs.entity.EntitySmokeBomb;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{
	public static void registerEntities()
	{
		
	//Smoke Bomb
		registerEntity("SmokeBomb", EntitySmokeBomb.class, -1, 64);
		
	//Poison Smoke Bomb
		registerEntity("PoisonSmokeBomb", EntityPoisonSmokeBomb.class, 0, 64);
		
	//Crab
		registerEntity("Crab", EntityCrab.class, Reference.ENTITY_CRAB, 32, 15759104, 15779840);
		
	//Poison Smoke Bomb
//		EntityRegistry.registerModEntity(EntityShuriken.class, "Shuriken", 1, UltimateBlockStormMod.instance, 64, 1, true);
		
//		EntityRegistry.addSpawn(EntityCrab.class.getName(), 10, 1, 3, EnumCreatureType.CREATURE, biomes);
	}
	
/**
 * This is used to make The registration of entities easier
 */
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) 
	{
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range) 
	{
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true);
	}
}