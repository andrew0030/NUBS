package andrews.ubs.network.message.server;

import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.util.interfaces.INinja;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCollectingChakra implements IMessage, IMessageHandler<MessageCollectingChakra, IMessage>
{	
	private boolean collecting_chakra;
	
	public MessageCollectingChakra() {}
	
	public MessageCollectingChakra(boolean collecting_chakra)
	{
		this.collecting_chakra = collecting_chakra;
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeBoolean(collecting_chakra);
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.collecting_chakra = buf.readBoolean();
	}
	
	@Override
	public IMessage onMessage(MessageCollectingChakra message, MessageContext ctx)
	{
		EntityPlayer player = ctx.getServerHandler().player;

		INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
			
		ninjaCap.setCollectingChakra(message.collecting_chakra);
		
		return null;
	}
}
