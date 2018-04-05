package andrews.ubs.capabilities.stamina;

import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.network.PacketHandler;
import andrews.ubs.network.message.server.MessageServerChakraUpdate;
import andrews.ubs.network.message.server.MessageServerStaminaUpdate;
import andrews.ubs.utils.IStamina;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

//=================================
//Default implementation of IChakra
//=================================

public class Stamina implements IStamina
{
	private float stamina = 100.0F;
	private float maxStamina = 100.0F;

	public void consume(float points)
	{
		this.stamina -= points;

		if (this.stamina < 0.0F)
			this.stamina = 0.0F;
		if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
		{
			UtilsLogger.getLogger().info("[Stamina] consume " + stamina);
		}
	}

	public void fill(float points)
	{
		this.stamina += points;

		if (this.stamina > this.maxStamina)
			this.stamina = this.maxStamina;
		
		if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
		{
			UtilsLogger.getLogger().info("[Stamina] fill " + stamina);
		}
	}

	public void set(float points)
	{
		this.stamina = points;
		
		if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
		{
			UtilsLogger.getLogger().info("[Stamina] set " + stamina);
		}
	}

	public float getStamina()
	{
		return this.stamina;
	}
	
//To the Max Stamina
	public void setMaxStamina(float points)
	{
		this.maxStamina = points;
		if(this.stamina > this.maxStamina)
		{
			this.stamina = points;
		}
		
		if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
		{
			UtilsLogger.getLogger().info("[Stamina] setMax " + maxStamina);
		}
	}

//To get Max Stamina
	public float getMaxStamina()
	{
		return this.maxStamina;
	}
	
//To sync The Client and Server
	public static void syncWithClient(EntityPlayer player, float staminaValue, float maxStaminaValue)
	{
		if (player.worldObj.isRemote)
		{
			return;
		}
		PacketHandler.INSTANCE.sendTo(new MessageServerStaminaUpdate(staminaValue, maxStaminaValue), (EntityPlayerMP) player);
	}
}
