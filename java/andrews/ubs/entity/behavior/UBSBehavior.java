package andrews.ubs.entity.behavior;

import andrews.ubs.entity.EntityPoisonSmokeBomb;
import andrews.ubs.entity.EntitySmokeBomb;
import andrews.ubs.init.ItemInit;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 *This is used to make the dispensers throw the entity and not the item of an throwable
 */
public class UBSBehavior 
{
	public static void DispenserBehaviorRegistry()
	{
		
	//Smoke Bomb
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(ItemInit.SMOKE_BOMB, new BehaviorProjectileDispense()
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
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(ItemInit.POISON_SMOKE_BOMB, new BehaviorProjectileDispense()
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