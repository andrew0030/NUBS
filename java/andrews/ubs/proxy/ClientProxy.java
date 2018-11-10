package andrews.ubs.proxy;

import andrews.ubs.Reference;
import andrews.ubs.gui.overlay.Bars;
import andrews.ubs.handlers.UBSRenderHandler;
import andrews.ubs.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerItemObjRenderer(Item item, int meta, String id)
	{
		OBJLoader.INSTANCE.addDomain(Reference.MODID);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void registerItemVariantRenderer(Item item, int meta, String filename, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), id));
	}
	
	@Override
	public void preinit()
	{
		super.preinit();
		
	//To register the Entity Renderes
    	UBSRenderHandler.registerEntityRenderers();
	}
	
	@Override
	public void init()
	{
		super.init();
		registerBlockColorHandler(BlockInit.FALLING_TRAP_GRASS);
		registerBlockColorHandler(BlockInit.FALLING_TRAP_GRASS_SMART);
	}
	
	@Override
	public void postinit()
	{
		super.postinit();
	
	//Bars
		MinecraftForge.EVENT_BUS.register(new Bars());
	}
	
//Block ColorMap Handler
	private void registerBlockColorHandler(Block block)
	{
	    Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler( new IBlockColor()
	    {
	    	@Override
	    	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex)
	    	{
	    		return BiomeColorHelper.getGrassColorAtPos(worldIn, pos);
	    	}
	    }, block);
	}
	
}
