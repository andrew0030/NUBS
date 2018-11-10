package andrews.ubs.world.gen.generators;

import java.util.Random;

import andrews.ubs.Reference;
import andrews.ubs.util.interfaces.IStructure;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenWildTomato extends WorldGenerator implements IStructure
{
	public static String plantname;
	
	public WorldGenWildTomato(String name) 
	{
		this.plantname = name;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		this.generateWildTomato(worldIn, position);
		return true;
	}
	
	public static void generateWildTomato(World world, BlockPos pos)
	{
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Reference.MODID, plantname);
		Template template = manager.getTemplate(mcServer, location);
		
		if(template != null)
		{
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			template.addBlocksToWorldChunk(world, pos, settings);
		}
	}
}
