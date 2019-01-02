package andrews.ubs.handlers;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.util.interfaces.INinja;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public final class UBSDamageEventHandler
{
	@SubscribeEvent
    public static void playerAttackEvent(LivingHurtEvent event)
    {
    	if(event.getEntity() != null)
    	{
    		if(event.getSource().getTrueSource() instanceof EntityPlayer)
    		{    			
    			event.setAmount(event.getAmount() * 100);
    		}
    	}
    }
}
