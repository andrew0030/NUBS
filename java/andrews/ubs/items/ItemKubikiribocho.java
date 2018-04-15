package andrews.ubs.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemKubikiribocho extends ItemSword
{
	public ItemKubikiribocho(ToolMaterial material, String name)
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(UltimateBlockStormMod.instance.tooltab);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setMaxStackSize(1);
		this.setMaxDamage(20);
	}
	
//Used to repair the item when you kill a Mob
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{	
		if(!player.worldObj.isRemote)
		{
			if(entity instanceof EntityLivingBase)
			{
				if(((EntityLivingBase) entity).getHealth() <= 15)
				{
					if(stack.getItemDamage() <= stack.getMaxDamage())
					{
						if(stack.getItemDamage() <= 9)
						{
							stack.setItemDamage(0);
							
							if(UltimateBlockStormMod.DEVELOPER_MODE)
							{
								UtilsLogger.getLogger().info("[ItemKubikiribocho] Case 1 got called so the damage was less then 10");
								UtilsLogger.getLogger().info("[ItemKubikiribocho] the max Damage is: " + stack.getMaxDamage());
								UtilsLogger.getLogger().info("[ItemKubikiribocho] the Damage is: " + stack.getItemDamage());
							}
						}
						else if(stack.getItemDamage() > 9)
						{
							stack.setItemDamage(stack.getItemDamage() - 11);
							
							if(UltimateBlockStormMod.DEVELOPER_MODE)
							{
								UtilsLogger.getLogger().info("[ItemKubikiribocho] Case 2 got called so the damage was more then 10");
								UtilsLogger.getLogger().info("[ItemKubikiribocho] the max Damage is: " + stack.getMaxDamage());
								UtilsLogger.getLogger().info("[ItemKubikiribocho] the Damage is: " + stack.getItemDamage());
							}
						}
					}
				}
			}
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if(!worldIn.isRemote)
		{
			if(UltimateBlockStormMod.DEVELOPER_MODE)
			{
				UtilsLogger.getLogger().info("[ItemKubikiribocho] the Damage is: " + stack.getItemDamage());
			}
		}
		return super.onItemRightClick(stack, worldIn, playerIn, hand);
	}
	
//Used to add Item Information
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advancedToolTip)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			list.add("This Weapon will");
			list.add("gain" + "\u00A7a " + "Durability " + "\u00A77" + "every");
			list.add("time you kill a Mob");
	    }
		else
		{
	        list.add("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for More Information");
		}
	}
}
