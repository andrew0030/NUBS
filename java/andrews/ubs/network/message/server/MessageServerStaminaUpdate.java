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
    private float maxStamina;
    
    public MessageServerStaminaUpdate() {}
    
    public MessageServerStaminaUpdate(float stamina, float maxStamina)
    {
        this.stamina = stamina;
        this.maxStamina = maxStamina;
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeFloat(stamina);
        buf.writeFloat(maxStamina);
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
    	stamina = buf.readFloat();
    	maxStamina = buf.readFloat();
    }

    @Override
    public IMessage onMessage(MessageServerStaminaUpdate message, MessageContext ctx)
    {
        updatePlayersStamina(message.stamina, message.maxStamina);
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    private void updatePlayersStamina(float stamina, float maxStamina)
    {
        UltimateBlockStormClientEventHandler.setStaminaUpdate(stamina, maxStamina);
    }
}
