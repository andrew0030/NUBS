package andrews.ubs.items;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.capabilities.chakra.Chakra;
import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.capabilities.stamina.Stamina;
import andrews.ubs.capabilities.stamina.StaminaProvider;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.IStamina;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemChopsticks extends Item
{	
	public ItemChopsticks(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.itemtab);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player, EnumHand hand)
	{
		IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);
		IStamina stamina = player.getCapability(StaminaProvider.STAMINA_CAP, null);
		
		if(UltimateBlockStormMod.DEVELOPER_MODE)
		{
			if(!worldIn.isRemote)
			{
				if(player.isSneaking())
				{
					chakra.setMaxChakra(10);
					stamina.setMaxStamina(10);
					Chakra.syncWithClient(player, chakra.getChakra(), chakra.getMaxChakra());
					Stamina.syncWithClient(player, stamina.getStamina(), stamina.getMaxStamina());
					if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
					{   
						UtilsLogger.logger.info("[ItemChopsticks] (Consume)-new Max Chakra is: " + chakra.getMaxChakra() + " and the new Chakra amount is: " + chakra.getChakra());
						UtilsLogger.logger.info("[ItemChopsticks] (Consume)-new Max Stamina is: " + stamina.getMaxStamina() + " and the new Stamina amount is: " + stamina.getStamina());
					}
				}
				else
				{
					chakra.setMaxChakra(110);
					stamina.setMaxStamina(110);
					Chakra.syncWithClient(player, chakra.getChakra(), chakra.getMaxChakra());
					Stamina.syncWithClient(player, stamina.getStamina(), stamina.getMaxStamina());
					if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
					{
						UtilsLogger.logger.info("[ItemChopsticks] (Add)-new Max Chakra is: " + chakra.getMaxChakra() + " and the new Chakra amount is: " + chakra.getChakra());
						UtilsLogger.logger.info("[ItemChopsticks] (Add)-new Max Stamina is: " + stamina.getMaxStamina() + " and the new Stamina amount is: " + stamina.getStamina());
					}
				}
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, player, hand);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);
		IStamina stamina = player.getCapability(StaminaProvider.STAMINA_CAP, null);
		
		if(UltimateBlockStormMod.DEVELOPER_MODE)
		{
			if(!player.worldObj.isRemote)
			{
				String message1 = String.format("chakra is: §7%d§r maxChakra is: §7%d§r", (int) chakra.getChakra(), (int) chakra.getMaxChakra());
				String message2 = String.format("stamina is: §7%d§r maxStamina is: §7%d§r", (int) stamina.getStamina(), (int) stamina.getMaxStamina());
		        player.addChatMessage(new TextComponentString(message1));
		        player.addChatMessage(new TextComponentString(message2));
			}
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
}
