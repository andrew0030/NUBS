package andrews.ubs.handler;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.capabilities.stamina.StaminaProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
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
		if (!(event.getObject() instanceof EntityPlayer)) return;
		 
		event.addCapability(CHAKRA_CAP, new ChakraProvider());
		event.addCapability(STAMINA_CAP, new StaminaProvider());
	}
}
