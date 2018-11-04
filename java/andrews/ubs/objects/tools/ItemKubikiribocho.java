package andrews.ubs.objects.tools;

import java.util.List;

import org.lwjgl.input.Keyboard;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import andrews.ubs.util.logger.UBSLogger;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemKubikiribocho extends ItemSword implements IHasModel
{
	public ItemKubikiribocho(String name, ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Main.instance.tooltab);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setMaxStackSize(1);
		
		ItemInit.ITEMS.add(this);
	}
	
//Used to repair the item when you kill a Mob
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{	
		if(!player.world.isRemote)
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
							
							if(Main.DEVELOPER_MODE)
							{
								UBSLogger.getLogger().info("[ItemKubikiribocho] Case 1 got called so the damage was less then 10");
								UBSLogger.getLogger().info("[ItemKubikiribocho] the max Damage is: " + stack.getMaxDamage());
								UBSLogger.getLogger().info("[ItemKubikiribocho] the Damage is: " + stack.getItemDamage());
							}
						}
						else if(stack.getItemDamage() > 9)
						{
							stack.setItemDamage(stack.getItemDamage() - 11);
							
							if(Main.DEVELOPER_MODE)
							{
								UBSLogger.getLogger().info("[ItemKubikiribocho] Case 2 got called so the damage was more then 10");
								UBSLogger.getLogger().info("[ItemKubikiribocho] the max Damage is: " + stack.getMaxDamage());
								UBSLogger.getLogger().info("[ItemKubikiribocho] the Damage is: " + stack.getItemDamage());
							}
						}
					}
				}
			}
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		if(!worldIn.isRemote)
		{
			if(Main.DEVELOPER_MODE)
			{
				UBSLogger.getLogger().info("[ItemKubikiribocho] the Damage is: " + playerIn.getHeldItem(handIn));
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
//Used to add Item Information
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			tooltip.add("This Weapon will");
			tooltip.add("gain" + "\u00A7a " + "Durability " + "\u00A77" + "every");
			tooltip.add("time you kill a Mob");
	    }
		else
		{
			tooltip.add("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for More Information");
		}
	}
		
		@Override
		public void registerModels()
		{
			Main.proxy.registerItemObjRenderer(this, 0, "inventory");
		}
	}