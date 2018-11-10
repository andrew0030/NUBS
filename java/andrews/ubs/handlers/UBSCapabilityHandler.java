package andrews.ubs.handlers;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaCap;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStamina;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

//=========================================================
//Capability handler									  #
//														  #
//This class is responsible for attaching our capabilities#
//=========================================================

public class UBSCapabilityHandler
{
	public static final ResourceLocation NINJA_CAP = new ResourceLocation(Reference.MODID, "Ninja");

	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	{
		if (!(event.getObject() instanceof EntityPlayer))
        return;

		event.addCapability(NINJA_CAP, new NinjaProvider());
	}	
	
	@SubscribeEvent
    public static void onPlayerLoggedIn(PlayerLoggedInEvent event)
	{
        INinja ninjaCapability = event.player.getCapability(NinjaCap, null);
        
        if(ninjaCapability != null)
        {
            ninjaCapability.syncToPlayer((EntityPlayerMP) event.player);
        }
        
        IPlayerWardrobeCap wardrobeCapability = PlayerWardrobeCap.get(event.player);
        if (wardrobeCapability != null) {
            wardrobeCapability.syncToPlayer((EntityPlayerMP) event.player);
        }
}
}
