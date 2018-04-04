package andrews.ubs.network.message.server;

import andrews.ubs.handler.UltimateBlockStormClientEventHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageServerChakraUpdate implements IMessage, IMessageHandler<MessageServerChakraUpdate, IMessage>
{
    private float chakra;
    private float maxChakra;
    
    public MessageServerChakraUpdate() {}
    
    public MessageServerChakraUpdate(float chakra, float maxChakra)
    {
        this.chakra = chakra;
        this.maxChakra = maxChakra;
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeFloat(chakra);
        buf.writeFloat(maxChakra);
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        chakra = buf.readFloat();
        maxChakra = buf.readFloat();
    }

    @Override
    public IMessage onMessage(MessageServerChakraUpdate message, MessageContext ctx)
    {
        updatePlayersChakra(message.chakra, message.maxChakra);
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    private void updatePlayersChakra(float chakra, float maxChakra)
    {
        UltimateBlockStormClientEventHandler.setChakraUpdate(chakra, maxChakra);
    }
}
