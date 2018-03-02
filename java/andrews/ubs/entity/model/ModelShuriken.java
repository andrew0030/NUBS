package andrews.ubs.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * shuriken - andrew0030
 * Created using Tabula 6.0.0
 */
public class ModelShuriken extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape3;
    public ModelRenderer shape3_1;
    public ModelRenderer shape5;
    public ModelRenderer shape5_1;
    public ModelRenderer shape7;
    public ModelRenderer shape7_1;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape11_1;
    public ModelRenderer shape10_1;
    public ModelRenderer shape9_1;
    public ModelRenderer shape7_2;
    public ModelRenderer shape7_3;
    public ModelRenderer shape5_2;
    public ModelRenderer shape5_3;
    public ModelRenderer shape3_2;
    public ModelRenderer shape3_3;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape1_3;

    public ModelShuriken() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1 = new ModelRenderer(this, 0, 11);
        this.shape1.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.shape5 = new ModelRenderer(this, 8, 0);
        this.shape5.setRotationPoint(0.0F, -13.0F, -6.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.shape3_3 = new ModelRenderer(this, 50, 9);
        this.shape3_3.setRotationPoint(0.0F, -2.0F, 6.0F);
        this.shape3_3.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.shape11_1 = new ModelRenderer(this, 26, 5);
        this.shape11_1.setRotationPoint(0.0F, -5.0F, -1.0F);
        this.shape11_1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.shape9_1 = new ModelRenderer(this, 36, 0);
        this.shape9_1.setRotationPoint(0.0F, -12.0F, 2.0F);
        this.shape9_1.addBox(0.0F, 0.0F, 0.0F, 1, 12, 2, 0.0F);
        this.shape3 = new ModelRenderer(this, 4, 9);
        this.shape3.setRotationPoint(0.0F, -2.0F, -7.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.shape11 = new ModelRenderer(this, 26, 0);
        this.shape11.setRotationPoint(0.0F, -10.0F, -1.0F);
        this.shape11.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.shape1_3 = new ModelRenderer(this, 0, 0);
        this.shape1_3.setRotationPoint(0.0F, -14.0F, -8.0F);
        this.shape1_3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.shape3_2 = new ModelRenderer(this, 50, 0);
        this.shape3_2.setRotationPoint(0.0F, -14.0F, 6.0F);
        this.shape3_2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 54, 11);
        this.shape1_1.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.shape7_1 = new ModelRenderer(this, 12, 7);
        this.shape7_1.setRotationPoint(0.0F, -5.0F, -5.0F);
        this.shape7_1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.shape5_3 = new ModelRenderer(this, 46, 0);
        this.shape5_3.setRotationPoint(0.0F, -13.0F, 5.0F);
        this.shape5_3.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.shape7 = new ModelRenderer(this, 12, 0);
        this.shape7.setRotationPoint(0.0F, -13.0F, -5.0F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.shape9 = new ModelRenderer(this, 16, 0);
        this.shape9.setRotationPoint(0.0F, -12.0F, -4.0F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 1, 12, 2, 0.0F);
        this.shape7_2 = new ModelRenderer(this, 42, 0);
        this.shape7_2.setRotationPoint(0.0F, -13.0F, 4.0F);
        this.shape7_2.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.shape5_2 = new ModelRenderer(this, 46, 8);
        this.shape5_2.setRotationPoint(0.0F, -4.0F, 5.0F);
        this.shape5_2.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.shape10 = new ModelRenderer(this, 22, 0);
        this.shape10.setRotationPoint(0.0F, -11.0F, -2.0F);
        this.shape10.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
        this.shape3_1 = new ModelRenderer(this, 4, 0);
        this.shape3_1.setRotationPoint(0.0F, -14.0F, -7.0F);
        this.shape3_1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.shape10_1 = new ModelRenderer(this, 32, 0);
        this.shape10_1.setRotationPoint(0.0F, -11.0F, 1.0F);
        this.shape10_1.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
        this.shape7_3 = new ModelRenderer(this, 42, 7);
        this.shape7_3.setRotationPoint(0.0F, -5.0F, 4.0F);
        this.shape7_3.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.shape1_2 = new ModelRenderer(this, 54, 0);
        this.shape1_2.setRotationPoint(0.0F, -14.0F, 7.0F);
        this.shape1_2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.shape5_1 = new ModelRenderer(this, 8, 8);
        this.shape5_1.setRotationPoint(0.0F, -4.0F, -6.0F);
        this.shape5_1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
        this.shape5.render(f5);
        this.shape3_3.render(f5);
        this.shape11_1.render(f5);
        this.shape9_1.render(f5);
        this.shape3.render(f5);
        this.shape11.render(f5);
        this.shape1_3.render(f5);
        this.shape3_2.render(f5);
        this.shape1_1.render(f5);
        this.shape7_1.render(f5);
        this.shape5_3.render(f5);
        this.shape7.render(f5);
        this.shape9.render(f5);
        this.shape7_2.render(f5);
        this.shape5_2.render(f5);
        this.shape10.render(f5);
        this.shape3_1.render(f5);
        this.shape10_1.render(f5);
        this.shape7_3.render(f5);
        this.shape1_2.render(f5);
        this.shape5_1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
