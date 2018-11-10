package andrews.ubs.entity.render;

import org.lwjgl.opengl.GL11;

import andrews.ubs.Reference;
import andrews.ubs.entity.EntityPoisonSmokeBomb;
import andrews.ubs.entity.model.ModelPoisonSmokeBomb;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPoisonSmokeBomb extends Render<EntityPoisonSmokeBomb>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/poison_smoke_bomb.png");
	private ModelPoisonSmokeBomb model = new ModelPoisonSmokeBomb();

	public RenderPoisonSmokeBomb(RenderManager manager)
	{
		super(manager);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPoisonSmokeBomb entity) 
	{
		return TEXTURES;
	}
	
	@Override
	public void doRender(EntityPoisonSmokeBomb entity, double x, double y, double z, float entityYaw, float partialTicks) 
	{
		GL11.glPushMatrix();
		bindTexture(TEXTURES);
		GL11.glTranslated(x, y, z);
		GL11.glScalef(1.0F, -1F, -1F);
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
