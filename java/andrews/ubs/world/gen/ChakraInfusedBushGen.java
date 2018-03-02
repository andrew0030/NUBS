package andrews.ubs.world.gen;

import java.util.ArrayList;
import java.util.Random;

import andrews.ubs.init.UltimateBlockStormBlocks;
import andrews.ubs.world.biome.BiomeChakraInfused;
import andrews.ubs.world.gen.generators.WorldGenChakraInfusedBush;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ChakraInfusedBushGen implements IWorldGenerator
{
	public static final WorldGenChakraInfusedBush BUSH = new WorldGenChakraInfusedBush("chakra_infused_bush");
	public static final WorldGenChakraInfusedBush BUSH1 = new WorldGenChakraInfusedBush("chakra_infused_bush");
	public static final WorldGenChakraInfusedBush BUSH2 = new WorldGenChakraInfusedBush("chakra_infused_bush");
	public static final WorldGenChakraInfusedBush BUSH3 = new WorldGenChakraInfusedBush("chakra_infused_bush");
	public static final WorldGenChakraInfusedBush BUSH4 = new WorldGenChakraInfusedBush("chakra_infused_bush");
	public static final WorldGenChakraInfusedBush BUSH5 = new WorldGenChakraInfusedBush("chakra_infused_bush");
	public static final WorldGenChakraInfusedBush BUSH6 = new WorldGenChakraInfusedBush("chakra_infused_bush");
	public static final WorldGenChakraInfusedBush BUSH7 = new WorldGenChakraInfusedBush("chakra_infused_bush");
	public static final WorldGenChakraInfusedBush BUSH8 = new WorldGenChakraInfusedBush("chakra_infused_bush");
	public static final WorldGenChakraInfusedBush BUSH9 = new WorldGenChakraInfusedBush("chakra_infused_bush");
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		case 1:
			
			break;
			
		case 0:
			
			generateChakraInfusedBush(BUSH, world, random, chunkX, chunkZ, 1, UltimateBlockStormBlocks.chakra_infused_grass, BiomeChakraInfused.class);
			generateChakraInfusedBush(BUSH1, world, random, chunkX, chunkZ, 1, UltimateBlockStormBlocks.chakra_infused_grass, BiomeChakraInfused.class);
			generateChakraInfusedBush(BUSH2, world, random, chunkX, chunkZ, 1, UltimateBlockStormBlocks.chakra_infused_grass, BiomeChakraInfused.class);
			generateChakraInfusedBush(BUSH3, world, random, chunkX, chunkZ, 1, UltimateBlockStormBlocks.chakra_infused_grass, BiomeChakraInfused.class);
			generateChakraInfusedBush(BUSH4, world, random, chunkX, chunkZ, 1, UltimateBlockStormBlocks.chakra_infused_grass, BiomeChakraInfused.class);
			generateChakraInfusedBush(BUSH5, world, random, chunkX, chunkZ, 1, UltimateBlockStormBlocks.chakra_infused_grass, BiomeChakraInfused.class);
			generateChakraInfusedBush(BUSH6, world, random, chunkX, chunkZ, 1, UltimateBlockStormBlocks.chakra_infused_grass, BiomeChakraInfused.class);
			generateChakraInfusedBush(BUSH7, world, random, chunkX, chunkZ, 1, UltimateBlockStormBlocks.chakra_infused_grass, BiomeChakraInfused.class);
			generateChakraInfusedBush(BUSH8, world, random, chunkX, chunkZ, 1, UltimateBlockStormBlocks.chakra_infused_grass, BiomeChakraInfused.class);
			generateChakraInfusedBush(BUSH9, world, random, chunkX, chunkZ, 1, UltimateBlockStormBlocks.chakra_infused_grass, BiomeChakraInfused.class);
			
			break;
			
		case -1:
		
		}
	}
	
	private void generateChakraInfusedBush(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(java.util.Arrays.asList(classes));
		
		int x = (chunkX * 16 + random.nextInt(5) + random.nextInt(15));
		int z = (chunkZ * 16 + random.nextInt(5) + random.nextInt(15));
		int y = calculateGenerationHeight(world, x, z, topBlock) + 1;
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(random.nextInt(chance) == 0)
				{
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0)
		{
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y;
	}
}
