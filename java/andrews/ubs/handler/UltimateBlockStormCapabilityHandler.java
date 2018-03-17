package andrews.ubs.handler;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.chakra.Chakra;
import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.capabilities.stamina.Stamina;
import andrews.ubs.capabilities.stamina.StaminaProvider;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.IStamina;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//=========================================================
//Capability handler									  #
//														  #
//This class is responsible for attaching our capabilities#
//=========================================================

public class UltimateBlockStormCapabilityHandler
{

    public static final ResourceLocation CHAKRA_CAP = new ResourceLocation(Reference.MODID, "Chakra");
    public static final ResourceLocation STAMINA_CAP = new ResourceLocation(Reference.MODID, "Stamina");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (!(event.getObject() instanceof EntityPlayer))
            return;

        event.addCapability(CHAKRA_CAP, new ChakraProvider());
        event.addCapability(STAMINA_CAP, new StaminaProvider());
    }

    /**
     * Sends the players chakra and stamina value when the login.
     * 
     * @param event
     */
    @SubscribeEvent
    public void onEntityJoinEvent(EntityJoinWorldEvent event)
    {
    	if (!event.getEntity().getEntityWorld().isRemote && event.getEntity() instanceof EntityPlayerMP)
    	{
    		EntityPlayerMP player = (EntityPlayerMP) event.getEntity();
    		
    		IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);
    		Chakra.syncWithClient((EntityPlayerMP) player, chakra.getChakra());
    		
    		IStamina stamina = player.getCapability(StaminaProvider.STAMINA_CAP, null);
    		Stamina.syncWithClient((EntityPlayerMP) player, stamina.getStamina());
    	}
    }
}
