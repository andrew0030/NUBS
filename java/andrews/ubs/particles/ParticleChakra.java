package andrews.ubs.particles;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleChakra extends Particle
{   
	private Entity target;
	
    public ParticleChakra(World worldIn, Entity target, double posX, double posY, double posZ, double motionX, double motionY, double motionZ)
    {
        super(worldIn, posX + 0.5F, posY + 0.5F, posZ + 0.5F);
        
        particleTextureIndexX = (int) (rand.nextFloat() * 8F);
        
        setPosition(posX, posY, posZ);
        
        this.particleMaxAge = 70;
        
        this.particleScale = (rand.nextFloat() + 0.5F);//+ 0.5
        this.target = target;
        
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        
        this.canCollide = false;
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
        
        targetY += 0.3D;
        /*
        if (!UtilPlayer.isLocalPlayer(target)) {
            targetY += 1.6D;
        }
        */
        double maxSpeed = 0.042;
        double minRange = 0.25;
        
        //Kills Particles after (x) ticks
        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setExpired();
        }
        
        //Motion on the X axis
        if(posX + minRange < targetX)
        {
            this.motionX += 0.01F;
            this.motionX += (rand.nextFloat() - 0.5) * 0.05;
        }
        else if(posX - minRange > targetX)
        {
            this.motionX -= 0.01F;
            this.motionX -= (rand.nextFloat() - 0.5) * 0.05;
        }
        else
        {
            motionX *= 0.4D;
        }
        
     	//Motion on the Y axis
        if(posY + 1 < targetY)
        {
            this.motionY += 0.01F;
            this.motionY += (rand.nextFloat() - 0.5) * 0.05;
        }
        else if(posY  - 1> targetY)
        {
            this.motionY -= 0.01F;
            this.motionY -= (rand.nextFloat() - 0.5) * 0.05;
        }
        else
        {
            motionY *= 0.4D;
        }
        
        //Motion on the Z axis
        if(posZ + minRange < targetZ)
        {
            this.motionZ += 0.01F;
            this.motionZ += (rand.nextFloat() - 0.5) * 0.05;
        }
        else if(posZ - minRange > targetZ)
        {
            this.motionZ -= 0.01F;
            this.motionZ -= (rand.nextFloat() - 0.5) * 0.05;
        }
        else
        {
            motionZ *= 0.4D;
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
        int fadeTime = 50;
        int lifeLeft = particleMaxAge - particleAge;
        if (lifeLeft <= fadeTime)
        {
            this.particleAlpha = ((float)lifeLeft / (float)fadeTime);
        }
        
        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }
}