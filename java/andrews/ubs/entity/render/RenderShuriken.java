package andrews.ubs.entity.render;

import org.lwjgl.opengl.GL11;

import andrews.ubs.Reference;
import andrews.ubs.entity.EntityPoisonSmokeBomb;
import andrews.ubs.entity.EntityShuriken;
import andrews.ubs.entity.EntitySmokeBomb;
import andrews.ubs.entity.model.ModelPoisonSmokeBomb;
import andrews.ubs.entity.model.ModelShuriken;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderShuriken extends Render<EntityShuriken>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/shuriken.png");
	private ModelShuriken model = new ModelShuriken();

	public RenderShuriken(RenderManager manager)
	{
		super(manager);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityShuriken entity) 
	{
		return TEXTURES;
	}
	
	@Override
	public void doRender(EntityShuriken entity, double x, double y, double z, float entityYaw, float partialTicks) 
	{
		GL11.glPushMatrix();
		bindTexture(TEXTURES);
		GL11.glTranslated(x, y, z);
		GL11.glScalef(0.3F, -0.3F, -0.3F);
		GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}