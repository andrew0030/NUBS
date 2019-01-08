package andrews.ubs.network;

import andrews.ubs.Reference;
import andrews.ubs.network.message.client.MessageKeyBoardUpdate;
import andrews.ubs.network.message.client.MessageStatRaised;
import andrews.ubs.network.message.server.MessageChakraParticles;
import andrews.ubs.network.message.server.MessageJumpParticles;
import andrews.ubs.network.message.server.MessageNinjaUpdate;
import andrews.ubs.network.message.server.MessageSandCloudParticles;
import andrews.ubs.network.message.server.MessageStatsUpdate;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler
{
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
	
	private static int ID = 0;
	
	private static int nextID()
	{
		return ID++;
	}
	
	public static void init(String channelName)
	{
	//Server Side
		INSTANCE.registerMessage(MessageKeyBoardUpdate.class, MessageKeyBoardUpdate.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(MessageStatRaised.class, MessageStatRaised.class, nextID(), Side.SERVER);
		
	//Client Side
		INSTANCE.registerMessage(MessageNinjaUpdate.class, MessageNinjaUpdate.class, nextID(), Side.CLIENT);
		INSTANCE.registerMessage(MessageStatsUpdate.class, MessageStatsUpdate.class, nextID(), Side.CLIENT);
		INSTANCE.registerMessage(MessageChakraParticles.class, MessageChakraParticles.class, nextID(), Side.CLIENT);
		INSTANCE.registerMessage(MessageJumpParticles.class, MessageJumpParticles.class, nextID(), Side.CLIENT);
		INSTANCE.registerMessage(MessageSandCloudParticles.class, MessageSandCloudParticles.class, nextID(), Side.CLIENT);
	}
}
