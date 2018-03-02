package andrews.ubs.init;

import andrews.ubs.utils.UtilsLogger;
import andrews.ubs.world.biome.BiomeAvocado;
import andrews.ubs.world.biome.BiomeChakraInfused;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class UltimateBlockStormBiomes 
{
	public static final Biome AVOCADO = new BiomeAvocado();
	public static final Biome CHAKRA_INFUSED = new BiomeChakraInfused();
	
	public static void registerBiomes()
	{
		initBiome(AVOCADO, "avocado", BiomeType.WARM, Type.HILLS, Type.WET);
		initBiome(CHAKRA_INFUSED, "chakra_infused", BiomeType.WARM, Type.FOREST, Type.WET);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		UtilsLogger.getLogger().info("Biome Registered");
		BiomeDictionary.registerBiomeType(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		UtilsLogger.getLogger().info("Biome Loaded");	
		return biome;
	}
}