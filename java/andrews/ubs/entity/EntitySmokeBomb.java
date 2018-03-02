package andrews.ubs.entity;

import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntitySmokeBomb extends EntityThrowable
{
    public EntitySmokeBomb(World worldIn) 
    {
        super(worldIn);
    }

    public EntitySmokeBomb(World worldIn, EntityLivingBase throwerIn) 
    {
        super(worldIn, throwerIn);
    }
    
    public EntitySmokeBomb(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

//Called when this EntityThrowable hits a block or entity.
    protected void onImpact(RayTraceResult result)
    {	
    if (result.entityHit != null)
    {
    		int i = 0;

            if (result.entityHit instanceof EntityBlaze)
            {
                i = 3;
            }

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
        }

        for (int j = 0; j < 8; ++j)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }
        
    	for (int i = 5; i >= 0; i--)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX, this.posY + 4, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + 4, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX - 4, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX, this.posY, this.posZ + 4, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX, this.posY, this.posZ - 4, 0.0D, 0.0D, 0.0D, new int[0]);
        }

    //Deletes the Entity
        if (!this.worldObj.isRemote)
        {  	
            this.setDead();
        }
        
    //The Area Effect Cloud
        if (!this.worldObj.isRemote)
        {
        	
        //The Area Clouds
            EntityAreaEffectCloud cloud = new EntityAreaEffectCloud(worldObj, this.posX, this.posY, this.posZ);
            EntityAreaEffectCloud cloud1 = new EntityAreaEffectCloud(worldObj, this.posX, this.posY + 2.0D, this.posZ);
            EntityAreaEffectCloud cloud2 = new EntityAreaEffectCloud(worldObj, this.posX, this.posY + 4.0D, this.posZ);
            EntityAreaEffectCloud cloud3 = new EntityAreaEffectCloud(worldObj, this.posX, this.posY - 2.0D, this.posZ);
        //The Area Clouds Effects 
            cloud.addEffect(new PotionEffect(MobEffects.BLINDNESS, 300, 0));
            cloud1.addEffect(new PotionEffect(MobEffects.BLINDNESS, 300, 0));
            cloud2.addEffect(new PotionEffect(MobEffects.BLINDNESS, 300, 0));
            cloud3.addEffect(new PotionEffect(MobEffects.BLINDNESS, 300, 0));
            cloud.addEffect(new PotionEffect(MobEffects.SLOWNESS, 300, 1));
            cloud1.addEffect(new PotionEffect(MobEffects.SLOWNESS, 300, 1));
            cloud2.addEffect(new PotionEffect(MobEffects.SLOWNESS, 300, 1));
            cloud3.addEffect(new PotionEffect(MobEffects.SLOWNESS, 300, 1));
        //The Area Cloud Colors
            cloud.setColor(0xecf0f1);
            cloud1.setColor(0xecf0f1);
            cloud2.setColor(0xecf0f1);
            cloud3.setColor(0xecf0f1);
        //The Area Cloud Duration
            cloud.setDuration(15);
            cloud1.setDuration(15);
            cloud2.setDuration(15);
            cloud3.setDuration(15);
        //The Area Cloud Radius
            cloud.setRadius(7);
            cloud1.setRadius(6);
            cloud2.setRadius(5);
            cloud3.setRadius(6);
        //Spawn The Area Cloud In The World
            worldObj.spawnEntityInWorld(cloud);
            worldObj.spawnEntityInWorld(cloud1);
            worldObj.spawnEntityInWorld(cloud2);
            worldObj.spawnEntityInWorld(cloud3);
        //The Area Cloud Wait Time (Time Before It Spawns)
            cloud.setWaitTime(0);
            cloud1.setWaitTime(0);
            cloud2.setWaitTime(0);
            cloud3.setWaitTime(0);
        }
    }
}