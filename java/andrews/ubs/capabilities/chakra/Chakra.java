package andrews.ubs.capabilities.chakra;

import andrews.ubs.UltimateBlockStormMod;
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
	private float maxChakra = 100.0F;

//To consume the given amount from Chakra
	public void consume(float points)
	{
		this.chakra -= points;

		if (this.chakra < 0.0F)
			this.chakra = 0.0F;
		
		if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
		{
			UtilsLogger.getLogger().info("[Chakra] consume " + chakra);
		}
	}

//To add the given amount too Chakra 
	public void fill(float points)
	{
		this.chakra += points;

		if(this.chakra > this.maxChakra)
		   this.chakra = this.maxChakra;
		
		if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
		{
			UtilsLogger.getLogger().info("[Chakra] fill " + chakra);
		}
	}

//To set the Chakra amount
	public void set(float points)
	{
		this.chakra = points;
		if(this.chakra > this.maxChakra)
		   this.chakra = this.maxChakra;
		
		if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
		{
			UtilsLogger.getLogger().info("[Chakra] set " + chakra);
		}
	}

//To get the Chakra
	public float getChakra()
	{
		return this.chakra;
	}
	
//To the Max Chakra
	public void setMaxChakra(float points)
	{
		this.maxChakra = points;
		if(this.chakra > this.maxChakra)
		{
			this.chakra = points;
		}
		
		if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
		{
			UtilsLogger.getLogger().info("[Chakra] setMax " + maxChakra);
		}
	}

//To get Max Chakra
	public float getMaxChakra()
	{
		return this.maxChakra;
	}
	
//To sync The Client and Server
	public static void syncWithClient(EntityPlayer player, float chakraValue, float maxChakraValue)
	{
		if (player.worldObj.isRemote)
		{
			return;
		}
		PacketHandler.INSTANCE.sendTo(new MessageServerChakraUpdate(chakraValue, maxChakraValue), (EntityPlayerMP) player);
	}
}
