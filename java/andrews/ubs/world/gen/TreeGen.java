package andrews.ubs.world.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import andrews.ubs.world.biome.BiomeAvocado;
import andrews.ubs.world.biome.BiomeChakraInfused;
import andrews.ubs.world.gen.generators.WorldGenAvocadoTree;
import andrews.ubs.world.gen.generators.WorldGenChakraInfusedTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeJungle;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TreeGen implements IWorldGenerator 
{
	private final WorldGenerator AVOCADO = new WorldGenAvocadoTree(false, false);
	private final WorldGenerator CHAKRA_INFUSED = new WorldGenChakraInfusedTree(false, false);
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case 1:
			
			break;
			
		case 0:
			
			runGenerator(AVOCADO, world, random, chunkX, chunkZ, 1, -1, 0, BiomeJungle.class, BiomeAvocado.class);
			runGenerator(CHAKRA_INFUSED, world, random, chunkX, chunkZ, 1, -1, 0, BiomeChakraInfused.class);
			
			break;
			
		case -1:
			
		}
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, double chanchesToSpawn, int minHeight, int maxHeight, Class<?>... classes)
	{
		if(chanchesToSpawn < 1)
			if(rand.nextDouble() < chanchesToSpawn) chanchesToSpawn = 1;
			else chanchesToSpawn = 0;
		
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chanchesToSpawn; i++)
		{
			BlockPos pos = new BlockPos(chunkX * 16 + 10 + rand.nextInt(15), minHeight + rand.nextInt(heightDiff), chunkZ * 16 + 10 + rand.nextInt(15));
			if(minHeight < 0) pos = world.getHeight(pos);
			Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
			if(classesList.contains(biome) || classes.length == 0) generator.generate(world, rand, pos);
		}
	}
	
	public static void register()
	{
		GameRegistry.registerWorldGenerator(new TreeGen(), 0);
	}

}