package andrews.ubs.network.message.client;

import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.capabilities.stats.StatsProvider;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStats;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageStatRaised implements IMessage, IMessageHandler<MessageStatRaised, IMessage>
{	
	private byte statId;
	
	public MessageStatRaised() {}
	
	public MessageStatRaised(byte statId)
	{
		this.statId = statId;
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeByte(statId);
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.statId = buf.readByte();
	}
	
	@Override
	public IMessage onMessage(MessageStatRaised message, MessageContext ctx)
	{
		EntityPlayer player = ctx.getServerHandler().player;

		IStats statsCap = player.getCapability(StatsProvider.STATS_CAP, null);
		INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
			
		switch(message.statId)
		{
		case 0:
			statsCap.fillStrength(1);
			statsCap.consumeAvPoint(1);
			break;
		case 1:
			statsCap.fillDefense(1);
			statsCap.consumeAvPoint(1);
			break;
		case 2:
			statsCap.fillReserve(1);
			statsCap.consumeAvPoint(1);
			ninjaCap.setMaxChakra(statsCap.getReserve() * 20);
			break;
		case 3:
			statsCap.fillMeditation(1);
			statsCap.consumeAvPoint(1);
			break;
		case 4:
			statsCap.fillNinjutsu(1);
			statsCap.consumeAvPoint(1);
			break;
		case 5:
			statsCap.fillTaijutsu(1);
			statsCap.consumeAvPoint(1);
			break;
		case 6:
			statsCap.fillGenjutsu(1);
			statsCap.consumeAvPoint(1);
			break;
		}
		statsCap.syncToAll();
		ninjaCap.syncToAll();
		return null;
	}
}