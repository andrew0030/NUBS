package andrews.ubs.objects.items;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IChakra;
import andrews.ubs.util.interfaces.IHasModel;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStamina;
import andrews.ubs.util.logger.UBSLogger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemChopsticks extends Item implements IHasModel
{	
	public ItemChopsticks(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.itemtab);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn)
	{
		INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
		
		if(Main.DEVELOPER_MODE)
		{
			if(!worldIn.isRemote)
			{
				if(player.isSneaking())
				{
					ninjaCap.setMaxChakra(10);
					ninjaCap.setMaxStamina(10);
					ninjaCap.syncToAll((EntityPlayerMP) player);
					if(Main.DEVELOPER_MODE) //Developer Mode
					{   
						UBSLogger.logger.info("[ItemChopsticks] (Consume)-new Max Chakra is: " + ninjaCap.getMaxChakra() + " and the new Chakra amount is: " + ninjaCap.getChakra());
						UBSLogger.logger.info("[ItemChopsticks] (Consume)-new Max Stamina is: " + ninjaCap.getMaxStamina() + " and the new Stamina amount is: " + ninjaCap.getStamina());
					}
				}
				else
				{
					ninjaCap.setMaxChakra(110);
					ninjaCap.setMaxStamina(110);
					ninjaCap.syncToAll((EntityPlayerMP) player);
					if(Main.DEVELOPER_MODE) //Developer Mode
					{
						UBSLogger.logger.info("[ItemChopsticks] (Add)-new Max Chakra is: " + ninjaCap.getMaxChakra() + " and the new Chakra amount is: " + ninjaCap.getChakra());
						UBSLogger.logger.info("[ItemChopsticks] (Add)-new Max Stamina is: " + ninjaCap.getMaxStamina() + " and the new Stamina amount is: " + ninjaCap.getStamina());
					}
				}
			}
		}
		return super.onItemRightClick(worldIn, player, handIn);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
		
		if(Main.DEVELOPER_MODE)
		{
			if(!player.world.isRemote)
			{
				String message1 = String.format("chakra is: §7%d§r maxChakra is: §7%d§r", (int) ninjaCap.getChakra(), (int) ninjaCap.getMaxChakra());
				String message2 = String.format("stamina is: §7%d§r maxStamina is: §7%d§r", (int) ninjaCap.getStamina(), (int) ninjaCap.getMaxStamina());
		        player.sendMessage(new TextComponentString(message1));
		        player.sendMessage(new TextComponentString(message2));
			}
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}