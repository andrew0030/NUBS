package andrews.ubs.world.gen;

import java.util.Random;

import andrews.ubs.init.BlockInit;
import andrews.ubs.world.gen.predicate.EndGenPredicate;
import andrews.ubs.world.gen.predicate.NetherGenPredicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator
{	
	//World Generators
		private WorldGenerator salt_overworld;
		private WorldGenerator salt_nether;
		private WorldGenerator chakra_ore;
		private WorldGenerator nether_chakra_ore;
		private WorldGenerator end_chakra_ore;
		
	//Set the Blocks for the Generators
		public OreGen()
		{
			salt_overworld = new WorldGenMinable(BlockInit.STONE_SALT.getDefaultState(), 5);
			salt_nether = new WorldGenMinable(BlockInit.NETHER_SALT.getDefaultState(), 5, new NetherGenPredicate());
			chakra_ore = new WorldGenMinable(BlockInit.CHAKRA_ORE.getDefaultState(), 5);
			nether_chakra_ore = new WorldGenMinable(BlockInit.NETHER_CHAKRA_ORE.getDefaultState(), 5, new NetherGenPredicate());
			end_chakra_ore = new WorldGenMinable(BlockInit.END_CHAKRA_ORE.getDefaultState(), 5, new EndGenPredicate());
		}
		
	//Generation 
		private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight)
		{
			if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
				throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

			int heightDiff = maxHeight - minHeight + 1;
			for (int i = 0; i < chancesToSpawn; i ++)
			{
				int x = chunk_X * 16 + rand.nextInt(16);
			    int y = minHeight + rand.nextInt(heightDiff);
			    int z = chunk_Z * 16 + rand.nextInt(16);
			    generator.generate(world, rand, new BlockPos(x, y, z));
			}
		}

	//Gets the dimension
		@Override
		public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
		{
			switch(world.provider.getDimension())
			{
			case 0: //Overworld
				this.runGenerator(salt_overworld, world, random, chunkX, chunkZ, 20, 35, 64);
				this.runGenerator(chakra_ore, world, random, chunkX, chunkZ, 10, 10, 40);
			case 1: //End
				this.runGenerator(end_chakra_ore, world, random, chunkX, chunkZ, 10, 5, 120);
			case -1: //Nether
				this.runGenerator(salt_nether, world, random, chunkX, chunkZ, 20, 5, 120);
				this.runGenerator(nether_chakra_ore, world, random, chunkX, chunkZ, 10, 5, 120);
			}
		}
	}