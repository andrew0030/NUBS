package andrews.ubs.handler;

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
    
    private static boolean haveChakraUpdate = false;
    private static float chakraUpdate = 0F;
    private static boolean haveStaminaUpdate = false;
    private static float staminaUpdate = 0F;
    
//Chakra
    public static void setChakraUpdate(float chakra)
    {
        chakraUpdate = chakra;
        haveChakraUpdate = true;
    }
    
//Stamina
    public static void setStaminaUpdate(float stamina)
    {
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
                IChakra iChakra = Minecraft.getMinecraft().thePlayer.getCapability(ChakraProvider.CHAKRA_CAP, null);
                iChakra.set(chakraUpdate);
                UtilsLogger.getLogger().info("Got chakra update from server " + iChakra.getChakra());
                haveChakraUpdate = false;
            }
            else
            {
                UtilsLogger.getLogger().error("Got chakra update from server but the player was null.");
            }
        }
        
    //Stamina
        if(haveStaminaUpdate)
        {
            if (Minecraft.getMinecraft().thePlayer != null)
            {
                IStamina iStamina = Minecraft.getMinecraft().thePlayer.getCapability(StaminaProvider.STAMINA_CAP, null);
                iStamina.set(staminaUpdate);
                UtilsLogger.getLogger().info("Got stamina update from server " + iStamina.getStamina());
                haveStaminaUpdate = false;
            }
            else
            {
                UtilsLogger.getLogger().error("Got stamina update from server but the player was null.");
            }
        }
    }
}
