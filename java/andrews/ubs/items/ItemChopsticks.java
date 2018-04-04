package andrews.ubs.items;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.capabilities.chakra.Chakra;
import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
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
		
		if(!worldIn.isRemote)
		{
			if(player.isSneaking())
			{
				chakra.setMaxChakra(10);
				Chakra.syncWithClient(player, chakra.getChakra(), chakra.getMaxChakra());
				if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
				{
					UtilsLogger.logger.info("[ItemChopsticks] (Consume)-new Max Chakra is: " + chakra.getMaxChakra() + " and the new Chakra amount is: " + chakra.getChakra());
				}
			}
			else
			{
				chakra.setMaxChakra(110);
				Chakra.syncWithClient(player, chakra.getChakra(), chakra.getMaxChakra());
				if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
				{
					UtilsLogger.logger.info("[ItemChopsticks] (Add)-new Max Chakra is: " + chakra.getMaxChakra() + " and the new Chakra amount is: " + chakra.getChakra());
				}
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, player, hand);
	}
}
