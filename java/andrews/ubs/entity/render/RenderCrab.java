package andrews.ubs.entity.render;

import andrews.ubs.Reference;
import andrews.ubs.entity.EntityCrab;
import andrews.ubs.entity.model.ModelCrab;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCrab extends RenderLiving<EntityCrab>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/crab.png");

	public RenderCrab(RenderManager manager)
	{
		super(manager, new ModelCrab(), 0.25F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCrab entity) 
	{
		return TEXTURES;
	}	
}
