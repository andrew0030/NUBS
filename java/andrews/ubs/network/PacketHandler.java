package andrews.ubs.network;

import andrews.ubs.Reference;
import andrews.ubs.network.message.server.MessageCollectingChakra;
import andrews.ubs.network.message.server.MessageNinjaUpdate;
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
		
	//Client Side
		INSTANCE.registerMessage(MessageNinjaUpdate.class, MessageNinjaUpdate.class, nextID(), Side.CLIENT);
		INSTANCE.registerMessage(MessageCollectingChakra.class, MessageCollectingChakra.class, nextID(), Side.CLIENT);
	}
}
