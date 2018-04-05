package andrews.ubs.handler;

import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.capabilities.stamina.StaminaProvider;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.IStamina;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class UltimateBlockStormClientEventHandler
{
    
    private static boolean haveChakraUpdate = false; //Chakra
    private static float chakraUpdate = 0F;
    private static float maxChakraUpdate = 0F;
    
    private static boolean haveStaminaUpdate = false; //Stamina
    private static float staminaUpdate = 0F;
    private static float maxStaminaUpdate = 0F;
    
//Chakra
    public static void setChakraUpdate(float chakra, float maxChakra)
    {
    	maxChakraUpdate = maxChakra;
        chakraUpdate = chakra;
        haveChakraUpdate = true;
    }
    
//Stamina
    public static void setStaminaUpdate(float stamina, float maxStamina)
    {
    	maxStaminaUpdate = maxStamina;
        staminaUpdate = stamina;
        haveStaminaUpdate = true;
    }
    
    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent event)
    {
        if (event.side == Side.SERVER)
        {
            return;
        }
        
    //Chakra
        if(haveChakraUpdate)
        {
            if (Minecraft.getMinecraft().thePlayer != null)
            {
                IChakra chakra = Minecraft.getMinecraft().thePlayer.getCapability(ChakraProvider.CHAKRA_CAP, null);
                
                chakra.setMaxChakra(maxChakraUpdate);
                chakra.set(chakraUpdate);
                if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
            	{
                	UtilsLogger.getLogger().info("[ClientEventHandler] Got chakra and maxChakra update from server, chakra is: " + chakra.getChakra() + " and maxChakra is: " + chakra.getMaxChakra());
            	}
                haveChakraUpdate = false;
            }
            else
            {
            	if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
            	{
            		UtilsLogger.getLogger().error("[ClientEventHandler] Got chakra update from server but the player was null.");
            	}
            }
        }
        
    //Stamina
        if(haveStaminaUpdate)
        {
            if (Minecraft.getMinecraft().thePlayer != null)
            {
                IStamina stamina = Minecraft.getMinecraft().thePlayer.getCapability(StaminaProvider.STAMINA_CAP, null);
                
                stamina.setMaxStamina(maxStaminaUpdate);
                stamina.set(staminaUpdate);
                if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
            	{
                	UtilsLogger.getLogger().info("[ClientEventHandler] Got stamina and maxStamina update from server, stamina is: " + stamina.getStamina() + " and maxStamina is: " + stamina.getMaxStamina());
            	}
                haveStaminaUpdate = false;
            }
            else
            {
            	if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
            	{
            		UtilsLogger.getLogger().error("[ClientEventHandler] Got stamina update from server but the player was null.");
            	}
            }
        }
    }
}
