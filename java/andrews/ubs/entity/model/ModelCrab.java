package andrews.ubs.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Crab - andrew0030
 * Created using Tabula 6.0.0
 */
public class ModelCrab extends ModelBase 
{
    public ModelRenderer BodyTop;
    public ModelRenderer BodyBottom;
    public ModelRenderer ArmBackRight;
    public ModelRenderer ArmBackLeft;
    public ModelRenderer ArmFrontRight;
    public ModelRenderer ArmFrontLeft;
    public ModelRenderer ScissorBigRight;
    public ModelRenderer ScissorBigLeft;
    public ModelRenderer ScissorSmallRight;
    public ModelRenderer ScissorSmallLeft;
    public ModelRenderer LegFrontRight;
    public ModelRenderer LegFrontLeft;
    public ModelRenderer LegFrontBackRight;
    public ModelRenderer LegFrontBackLeft;
    public ModelRenderer LegBackFrontRight;
    public ModelRenderer LegBackFrontLeft;
    public ModelRenderer LegBackRight;
    public ModelRenderer LegBackLeft;
    public ModelRenderer Body;

    public ModelCrab() 
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.ScissorBigRight = new ModelRenderer(this, 23, 10);
        this.ScissorBigRight.setRotationPoint(-4.5F, 21.5F, -3.3F);
        this.ScissorBigRight.addBox(-1.0F, -1.0F, -2.5F, 2, 2, 3, -0.3F);
        this.ArmBackRight = new ModelRenderer(this, 25, 1);
        this.ArmBackRight.setRotationPoint(-2.5F, 21.5F, 0.5F);
        this.ArmBackRight.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, -0.2F);
        this.setRotateAngle(ArmBackRight, 0.0F, 0.6981317007977318F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.Body.addBox(-3.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.BodyBottom = new ModelRenderer(this, 0, 15);
        this.BodyBottom.setRotationPoint(0.0F, 21.5F, 0.5F);
        this.BodyBottom.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
        this.ArmBackLeft = new ModelRenderer(this, 34, 1);
        this.ArmBackLeft.setRotationPoint(2.5F, 21.5F, 0.5F);
        this.ArmBackLeft.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, -0.2F);
        this.setRotateAngle(ArmBackLeft, 0.0F, -0.6981317007977318F, 0.0F);
        this.BodyTop = new ModelRenderer(this, 0, 8);
        this.BodyTop.setRotationPoint(0.0F, 20.5F, 0.5F);
        this.BodyTop.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
        this.LegFrontBackLeft = new ModelRenderer(this, 5, 28);
        this.LegFrontBackLeft.setRotationPoint(2.5F, 21.7F, 2.5F);
        this.LegFrontBackLeft.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, -0.2F);
        this.setRotateAngle(LegFrontBackLeft, -0.08726646259971647F, 0.0F, -1.0471975511965976F);
        this.LegBackLeft = new ModelRenderer(this, 5, 40);
        this.LegBackLeft.setRotationPoint(2.5F, 21.7F, 5.5F);
        this.LegBackLeft.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, -0.2F);
        this.setRotateAngle(LegBackLeft, 0.17453292519943295F, 0.0F, -1.0471975511965976F);
        this.ScissorBigLeft = new ModelRenderer(this, 34, 10);
        this.ScissorBigLeft.setRotationPoint(4.5F, 21.5F, -3.3F);
        this.ScissorBigLeft.addBox(-1.0F, -1.0F, -2.5F, 2, 2, 3, -0.3F);
        this.LegFrontRight = new ModelRenderer(this, 0, 22);
        this.LegFrontRight.setRotationPoint(-2.0F, 22.5F, 1.0F);
        this.LegFrontRight.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, -0.2F);
        this.setRotateAngle(LegFrontRight, -0.17453292519943295F, 0.0F, 1.0471975511965976F);
        this.LegBackFrontRight = new ModelRenderer(this, 0, 34);
        this.LegBackFrontRight.setRotationPoint(-2.0F, 22.5F, 4.0F);
        this.LegBackFrontRight.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, -0.2F);
        this.setRotateAngle(LegBackFrontRight, 0.08726646259971647F, 0.0F, 1.0471975511965976F);
        this.ArmFrontLeft = new ModelRenderer(this, 35, 6);
        this.ArmFrontLeft.setRotationPoint(4.3F, 21.5F, -1.3F);
        this.ArmFrontLeft.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, -0.2F);
        this.LegFrontBackRight = new ModelRenderer(this, 0, 28);
        this.LegFrontBackRight.setRotationPoint(-2.0F, 22.5F, 2.5F);
        this.LegFrontBackRight.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, -0.2F);
        this.setRotateAngle(LegFrontBackRight, -0.08726646259971647F, 0.0F, 1.0471975511965976F);
        this.ScissorSmallLeft = new ModelRenderer(this, 35, 16);
        this.ScissorSmallLeft.setRotationPoint(4.0F, 21.5F, -3.3F);
        this.ScissorSmallLeft.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(ScissorSmallLeft, 0.0F, 0.3490658503988659F, 0.0F);
        this.LegFrontLeft = new ModelRenderer(this, 5, 22);
        this.LegFrontLeft.setRotationPoint(2.5F, 21.7F, 1.0F);
        this.LegFrontLeft.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, -0.2F);
        this.setRotateAngle(LegFrontLeft, -0.17453292519943295F, 0.0F, -1.0471975511965976F);
        this.LegBackRight = new ModelRenderer(this, 0, 40);
        this.LegBackRight.setRotationPoint(-2.0F, 22.5F, 5.5F);
        this.LegBackRight.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, -0.2F);
        this.setRotateAngle(LegBackRight, 0.17453292519943295F, 0.0F, 1.0471975511965976F);
        this.ArmFrontRight = new ModelRenderer(this, 26, 6);
        this.ArmFrontRight.setRotationPoint(-4.3F, 21.5F, -1.3F);
        this.ArmFrontRight.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, -0.2F);
        this.ScissorSmallRight = new ModelRenderer(this, 26, 16);
        this.ScissorSmallRight.setRotationPoint(-4.0F, 21.5F, -3.3F);
        this.ScissorSmallRight.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(ScissorSmallRight, 0.0F, -0.3490658503988659F, 0.0F);
        this.LegBackFrontLeft = new ModelRenderer(this, 5, 34);
        this.LegBackFrontLeft.setRotationPoint(2.5F, 21.7F, 4.0F);
        this.LegBackFrontLeft.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, -0.2F);
        this.setRotateAngle(LegBackFrontLeft, 0.08726646259971647F, 0.0F, -1.0471975511965976F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
        this.ScissorBigRight.render(f5);
        this.ArmBackRight.render(f5);
        this.Body.render(f5);
        this.BodyBottom.render(f5);
        this.ArmBackLeft.render(f5);
        this.BodyTop.render(f5);
        this.LegFrontBackLeft.render(f5);
        this.LegBackLeft.render(f5);
        this.ScissorBigLeft.render(f5);
        this.LegFrontRight.render(f5);
        this.LegBackFrontRight.render(f5);
        this.ArmFrontLeft.render(f5);
        this.LegFrontBackRight.render(f5);
        this.ScissorSmallLeft.render(f5);
        this.LegFrontLeft.render(f5);
        this.LegBackRight.render(f5);
        this.ArmFrontRight.render(f5);
        this.ScissorSmallRight.render(f5);
        this.LegBackFrontLeft.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
    {
    	this.LegFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LegBackFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LegFrontBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F+ (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.LegBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F+ (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.LegFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.LegBackFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.LegFrontBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LegBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }   
}