package andrews.ubs.world.biome;

import andrews.ubs.init.UltimateBlockStormBlocks;
import andrews.ubs.world.gen.generators.WorldGenChakraInfusedTree;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenClay;

public class BiomeChakraInfused extends Biome 
{
	protected static final WorldGenAbstractTree TREE = new WorldGenChakraInfusedTree(false, false);

	public BiomeChakraInfused() 
	{
		super(new BiomeProperties("chakra_infused").setTemperature(0.70F).setRainfall(0.8F).setWaterColor(5041362));
		topBlock = UltimateBlockStormBlocks.chakra_infused_grass.getDefaultState();
		fillerBlock = Blocks.DIRT.getDefaultState();
		
		this.theBiomeDecorator.treesPerChunk = 0;
		this.theBiomeDecorator.extraTreeChance = 0;
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.grassPerChunk = 0;
		this.theBiomeDecorator.generateLakes = true;
		this.theBiomeDecorator.clayGen = new WorldGenClay(4);
		this.theBiomeDecorator.mushroomsPerChunk = 15;
        this.theBiomeDecorator.clayPerChunk = 1;
        this.theBiomeDecorator.sandPerChunk2 = 0;
        this.theBiomeDecorator.sandPerChunk = 0;
		
	}
	
	public static WorldGenAbstractTree getTree() 
	{
		return TREE;
	}
	
}
