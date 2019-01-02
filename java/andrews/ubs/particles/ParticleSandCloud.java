package andrews.ubs.particles;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleSandCloud extends Particle
{   
	private Entity target;
	
    public ParticleSandCloud(World worldIn, Entity target, double posX, double posY, double posZ, double motionX, double motionY, double motionZ)
    {
        super(worldIn, posX + 0.5F, posY + 0.5F, posZ + 0.5F);
        
        particleTextureIndexX = (int) (rand.nextFloat() * 8F);
        particleTextureIndexY = 1;
        
        setPosition(posX, posY, posZ);
        
        this.particleMaxAge = 100;
        
        this.particleScale = (rand.nextFloat() + 2.5F);//+ 0.5
        this.target = target;
        
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        
        this.canCollide = true;
    }
    
    @Override
    public void onUpdate()
    {
    	this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        
        double targetX = target.posX;
        double targetY = target.posY;
        double targetZ = target.posZ;
        
        targetY -= 0.5D;
        /*
        if (!UtilPlayer.isLocalPlayer(target)) {
            targetY += 1.6D;
        }
        */
        double maxSpeed = 0.5;
        double minRange = 1.0;
        
        //Kills Particles after (x) ticks
        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setExpired();
        }
        
        //Motion on the X axis
        if(posX + minRange < targetX)
        {
            this.motionX += 0.03F;
            this.motionX += (rand.nextFloat() - 0.5) * 0.05;
        }
        else if(posX - minRange > targetX)
        {
            this.motionX -= 0.03F;
            this.motionX -= (rand.nextFloat() - 0.5) * 0.05;
        }
        else
        {
            motionX *= 1.0D;
        }
        
     	//Motion on the Y axis
        if(posY + 0.4 < targetY)
        {
            this.motionY += 0.02F;
            this.motionY += (rand.nextFloat() - 0.5) * 0.05;
        }
        else if(posY  - 0.4 > targetY)
        {
            this.motionY -= 0.02F;
            this.motionY -= (rand.nextFloat() - 0.5) * 0.05;
        }
        else
        {
            motionY = 0.04D;
        }
        
        //Motion on the Z axis
        if(posZ + minRange < targetZ)
        {
            this.motionZ += 0.03F;
            this.motionZ += (rand.nextFloat() - 0.5) * 0.05;
        }
        else if(posZ - minRange > targetZ)
        {
            this.motionZ -= 0.03F;
            this.motionZ -= (rand.nextFloat() - 0.5) * 0.05;
        }
        else
        {
            motionZ *= 1.0D;
        }
        
        //Makes Particles get a Jelly like movement
//      this.motionX += (rand.nextFloat() - 0.5) * 0.02;
//      this.motionY += (rand.nextFloat() - 0.5) * 0.02;
//      this.motionZ += (rand.nextFloat() - 0.5) * 0.02;
        
        if(motionX > maxSpeed)
        {
            motionX = maxSpeed; 
        }
        
        if(motionX < -maxSpeed)
        {
            motionX = -maxSpeed; 
        }
        
        if(motionY > maxSpeed)
        {
            motionY = maxSpeed; 
        }
        
        if(motionY < -maxSpeed)
        {
            motionY = -maxSpeed; 
        }
        
        if(motionZ > maxSpeed)
        {
            motionZ = maxSpeed; 
        }
        
        if(motionZ < -maxSpeed)
        {
            motionZ = -maxSpeed; 
        }
        
        this.move(this.motionX, this.motionY, this.motionZ);
        
        if(this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
    
    @Override
    public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {
        int fadeTime = 2;
        int lifeLeft = particleMaxAge - particleAge;
        if (lifeLeft <= fadeTime)
        {
            this.particleAlpha = ((float)lifeLeft / (float)fadeTime);
        }
        
        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }
}