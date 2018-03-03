package andrews.ubs.network.message.server;

import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.utils.IChakra;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageServerChakraUpdate implements IMessage, IMessageHandler<MessageServerChakraUpdate, IMessage>
{
    private float chakra;
    
    public MessageServerChakraUpdate(float chakra) {
        this.chakra = chakra;
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeFloat(chakra);
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        chakra = buf.readFloat();
    }

    @Override
    public IMessage onMessage(MessageServerChakraUpdate message, MessageContext ctx)
    {
        updatePlayersChakra(message.chakra);
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    private void updatePlayersChakra(float chakra) {
        IChakra iChakra = Minecraft.getMinecraft().thePlayer.getCapability(ChakraProvider.CHAKRA_CAP, null);
        iChakra.set(chakra);
    }
}
