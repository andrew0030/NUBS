package andrews.ubs.capabilities.chakra;

import andrews.ubs.network.PacketHandler;
import andrews.ubs.network.message.server.MessageServerChakraUpdate;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

//=================================
//Default implementation of IChakra
//=================================
public class Chakra implements IChakra
{	
	private float chakra = 100.0F;
	 
	public void consume(float points)	
	{
		this.chakra -= points;
		
		if (this.chakra < 0.0F) this.chakra = 0.0F;
		UtilsLogger.getLogger().info("consume " + chakra);
	}
	
	public void fill(float points)
	{
		this.chakra += points;
	 
		if (this.chakra > 100.0F) this.chakra = 100.0F;
	}
	 
	public void set(float points)
	{
		this.chakra = points;
	}
	 
	public float getChakra()
	{
		return this.chakra;
	}
	
	public static void syncWithClient(EntityPlayer player, float chakraValue)
	 {
	    if (player.worldObj.isRemote) {
	        return;
	    }
	    PacketHandler.INSTANCE.sendTo(new MessageServerChakraUpdate(chakraValue), (EntityPlayerMP)player);
	 }
}
