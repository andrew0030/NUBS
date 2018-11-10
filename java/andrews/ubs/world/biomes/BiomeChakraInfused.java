package andrews.ubs.world.biomes;

import andrews.ubs.init.BlockInit;
import andrews.ubs.world.gen.generators.WorldGenChakraInfusedTree;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenClay;

public class BiomeChakraInfused extends Biome 
{
	protected static final WorldGenAbstractTree TREE = new WorldGenChakraInfusedTree(false, false);

	public BiomeChakraInfused() 
	{
		super(new BiomeProperties("chakra_infused").setTemperature(0.70F).setRainfall(0.8F).setWaterColor(5041362));
		topBlock = BlockInit.CHAKRA_INFUSED_GRASS.getDefaultState();
		fillerBlock = Blocks.DIRT.getDefaultState();
		
		this.decorator.treesPerChunk = 0;
		this.decorator.extraTreeChance = 0;
		this.decorator.flowersPerChunk = 0;
		this.decorator.grassPerChunk = 0;
		this.decorator.generateFalls = true;
		this.decorator.clayGen = new WorldGenClay(4);
		this.decorator.mushroomsPerChunk = 15;
        this.decorator.clayPerChunk = 1;
	}
	
	public static WorldGenAbstractTree getTree() 
	{
		return TREE;
	}
	
}
