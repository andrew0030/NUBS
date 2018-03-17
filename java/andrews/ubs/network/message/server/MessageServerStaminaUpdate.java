package andrews.ubs.network.message.server;

import andrews.ubs.handler.UltimateBlockStormClientEventHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageServerStaminaUpdate implements IMessage, IMessageHandler<MessageServerStaminaUpdate, IMessage>
{
    private float stamina;
    
    public MessageServerStaminaUpdate() {
    }
    
    public MessageServerStaminaUpdate(float stamina) {
        this.stamina = stamina;
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeFloat(stamina);
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
    	stamina = buf.readFloat();
    }

    @Override
    public IMessage onMessage(MessageServerStaminaUpdate message, MessageContext ctx)
    {
        updatePlayersStamina(message.stamina);
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    private void updatePlayersStamina(float stamina)
    {
        UltimateBlockStormClientEventHandler.setStaminaUpdate(stamina);
    }
}
