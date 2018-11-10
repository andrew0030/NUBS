package andrews.ubs.entity;

import java.util.Set;

import com.google.common.collect.Sets;

import andrews.ubs.handlers.UBSLootTableHandler;
import andrews.ubs.init.ItemInit;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCrab extends EntityAnimal
{
	private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(new Item[] {ItemInit.CALAMARI, ItemInit.CALAMARI_COOKED});
	
	public EntityCrab(World worldIn)
	{
		super(worldIn);
		this.setSize(0.6F, 0.4F);
	}
	
//To set the mob Attributes
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(7.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
    }

//The entity AI
	protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, false, TEMPTATION_ITEMS));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
    }
	
//Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on the animal type)
	@Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return false;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) 
	{
		return new EntityCrab(getEntityWorld());
	}
	
	
//To set the entities eye height
	@Override
	public float getEyeHeight() 
	{
		return 0.3F;
	}
		
//The ambient Sound
	@Override
	protected SoundEvent getAmbientSound()
	{
		return SoundEvents.ENTITY_GUARDIAN_AMBIENT;
	}
	
//The hurt Sound
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return SoundEvents.ENTITY_GUARDIAN_HURT;
	}
		
//The death sound
	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundEvents.ENTITY_GUARDIAN_DEATH;
	}
	
//To get the LootTable
	@Override
	protected ResourceLocation getLootTable() 
	{
		return UBSLootTableHandler.CRAB;
	}
}