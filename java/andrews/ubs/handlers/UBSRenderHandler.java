package andrews.ubs.handlers;

import andrews.ubs.entity.EntityCrab;
import andrews.ubs.entity.EntityPoisonSmokeBomb;
import andrews.ubs.entity.EntitySmokeBomb;
import andrews.ubs.entity.render.RenderCrab;
import andrews.ubs.entity.render.RenderPoisonSmokeBomb;
import andrews.ubs.entity.render.RenderSmokeBomb;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

//This is used to Register the Renderer for the entities
public class UBSRenderHandler 
{
	public static void registerEntityRenderers()
	{
		
	//Registry For Crab
		RenderingRegistry.registerEntityRenderingHandler(EntityCrab.class, new IRenderFactory<EntityCrab>()
		{
			@Override
			public Render<? super EntityCrab> createRenderFor(RenderManager manager) 
			{
				return new RenderCrab(manager);
			}
		});
		
	//Registry For SmokeBomb
		RenderingRegistry.registerEntityRenderingHandler(EntitySmokeBomb.class, new IRenderFactory<EntitySmokeBomb>() 
		{
			@Override
			public Render<? super EntitySmokeBomb> createRenderFor(RenderManager manager) 
			{
				return new RenderSmokeBomb(manager);
			}
		});
		
	//Registry For PoisonSmokeBomb
		RenderingRegistry.registerEntityRenderingHandler(EntityPoisonSmokeBomb.class, new IRenderFactory<EntityPoisonSmokeBomb>()
		{
			@Override
			public Render<? super EntityPoisonSmokeBomb> createRenderFor(RenderManager manager) 
			{
				return new RenderPoisonSmokeBomb(manager);
			}
		});
		
	//Registry For Shuriken
//		RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class, new IRenderFactory<EntityShuriken>()
//		{
//			@Override
//			public Render<? super EntityShuriken> createRenderFor(RenderManager manager) 
//			{
//				return new RenderShuriken(manager);
//			}
//		});
	}
}