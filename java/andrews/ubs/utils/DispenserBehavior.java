package andrews.ubs.utils;

import andrews.ubs.entity.EntityPoisonSmokeBomb;
import andrews.ubs.entity.EntitySmokeBomb;
import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 *This is used to make the dispensers throw the entity and not the item of an throwable
 */
public class DispenserBehavior 
{
	public static void DispenserBehaviorRegistry()
	{
		
	//Smoke Bomb
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(UltimateBlockStormItems.smoke_bomb, new BehaviorProjectileDispense()
    	{
            /**
             * Return the projectile entity spawned by this dispense behavior.
             */
            protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn)
            {
                return new EntitySmokeBomb(worldIn, position.getX(), position.getY(), position.getZ());
            }
        });
		
	//Poison Smoke Bomb
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(UltimateBlockStormItems.poison_smoke_bomb, new BehaviorProjectileDispense()
    	{
            /**
             * Return the projectile entity spawned by this dispense behavior.
             */
            protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn)
            {
                return new EntityPoisonSmokeBomb(worldIn, position.getX(), position.getY(), position.getZ());
            }
        });
	}
}
