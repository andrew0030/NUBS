package andrews.ubs.jutsus;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.network.PacketHandler;
import andrews.ubs.network.message.server.MessageSandCloudParticles;
import andrews.ubs.util.interfaces.INinja;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public final class JutsuSandCloud
{
	
	@SubscribeEvent
    public static void sandCloud(LivingUpdateEvent event)
	{
		if(event.getEntity() != null && event.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntity();
			INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
			
			if(!player.isCreative() && ninjaCap.getChakra() >= 50)
			{
				player.capabilities.allowFlying = true;
				
				if(player.capabilities.isFlying)
				{
					if((player.getEntityWorld().getTotalWorldTime() % 20) == 0)
						{
							if(!player.isCreative())
							{
								ninjaCap.consumeChakra(50);
								ninjaCap.syncToAll();
							}
						}
						
						if((player.getEntityWorld().getTotalWorldTime() % 10) == 0)
						{
							if(!player.getEntityWorld().isRemote)
							{
								PacketHandler.INSTANCE.sendToAllTracking(new MessageSandCloudParticles(player.getEntityId()), player);
		        				PacketHandler.INSTANCE.sendTo(new MessageSandCloudParticles(player.getEntityId()), (EntityPlayerMP) player);
							}
						}
				}
			}
			else if(!player.isCreative() && ninjaCap.getChakra() < 50)
			{
				player.capabilities.isFlying = false;
				player.capabilities.allowFlying = false;
			}
		}
	}
}
