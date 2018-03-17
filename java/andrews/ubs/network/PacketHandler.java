package andrews.ubs.network;

import andrews.ubs.Reference;
import andrews.ubs.network.message.client.MessageClientKeyPress;
import andrews.ubs.network.message.server.MessageServerChakraUpdate;
import andrews.ubs.network.message.server.MessageServerStaminaUpdate;
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
		INSTANCE.registerMessage(MessageClientKeyPress.class, MessageClientKeyPress.class, nextID(), Side.SERVER);
		
	//Client Side
		INSTANCE.registerMessage(MessageServerChakraUpdate.class, MessageServerChakraUpdate.class, nextID(), Side.CLIENT);
		INSTANCE.registerMessage(MessageServerStaminaUpdate.class, MessageServerStaminaUpdate.class, nextID(), Side.CLIENT);
	}
}
