package andrews.ubs.init;

import andrews.ubs.world.biomes.BiomeAvocado;
import andrews.ubs.world.biomes.BiomeChakraInfused;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;



public class BiomeInit 
{
	public static final Biome AVOCADO = new BiomeAvocado();
	public static final Biome CHAKRA_INFUSED = new BiomeChakraInfused();
	
	public static void registerBiomes()
	{
		initBiome(AVOCADO, "avocado", BiomeType.WARM);
		initBiome(CHAKRA_INFUSED, "chakra_infused", BiomeType.WARM);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}