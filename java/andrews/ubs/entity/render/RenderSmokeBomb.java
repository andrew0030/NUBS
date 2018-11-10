package andrews.ubs.entity.render;

import org.lwjgl.opengl.GL11;

import andrews.ubs.Reference;
import andrews.ubs.entity.EntitySmokeBomb;
import andrews.ubs.entity.model.ModelSmokeBomb;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSmokeBomb extends Render<EntitySmokeBomb>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/smoke_bomb.png");
	private ModelSmokeBomb model = new ModelSmokeBomb();

	public RenderSmokeBomb(RenderManager manager)
	{
		super(manager);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySmokeBomb entity) 
	{
		return TEXTURES;
	}
	
	@Override
	public void doRender(EntitySmokeBomb entity, double x, double y, double z, float entityYaw, float partialTicks) 
	{
		GL11.glPushMatrix();
		bindTexture(TEXTURES);
		GL11.glTranslated(x, y, z);
		GL11.glScalef(1.0F, -1F, -1F);
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
