package andrews.ubs.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityShuriken extends EntityThrowable
{
    public EntityShuriken(World worldIn)
    {
        super(worldIn);
    }

    public EntityShuriken(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityShuriken(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

//Called when this EntityThrowable hits a block or entity.
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 6;

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
        }
        
        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}