package andrews.ubs.handlers;

import java.util.ArrayList;

import andrews.ubs.Reference;
import andrews.ubs.util.interfaces.IChakra;
import andrews.ubs.util.interfaces.IStamina;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = { Side.CLIENT })
public final class UBSDelayedMessageHandler
{
    private static final ArrayList<IDelayedMessage> DELAYED_MESSAGES = new ArrayList<IDelayedMessage>();
    
    private UBSDelayedMessageHandler() {}
    
    @SubscribeEvent
    public static void onClientTick(ClientTickEvent event)
    {
        if (event.phase == Phase.END)
        {
            return;
        }
        synchronized (DELAYED_MESSAGES)
        {
            for (int i = 0; i < DELAYED_MESSAGES.size(); i++)
            {
                IDelayedMessage delayedMessage = DELAYED_MESSAGES.get(i);
                if (delayedMessage.isReady())
                {
                    delayedMessage.onDelayedMessage();
                    DELAYED_MESSAGES.remove(i);
                    i--;
                }
            }
        }
    }
    
    public static void addDelayedMessage(IDelayedMessage delayedMessage)
    {
        synchronized (DELAYED_MESSAGES)
        {
            DELAYED_MESSAGES.add(delayedMessage);
        }
    }
    
    public static interface IDelayedMessage
    {
        public boolean isReady();
        
        public void onDelayedMessage();
    }
}