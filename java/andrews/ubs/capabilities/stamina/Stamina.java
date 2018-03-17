package andrews.ubs.capabilities.stamina;

import andrews.ubs.network.PacketHandler;
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

	public void consume(float points)
	{
		this.stamina -= points;

		if (this.stamina < 0.0F)
			this.stamina = 0.0F;
		UtilsLogger.getLogger().info("consume " + stamina);
	}

	public void fill(float points)
	{
		this.stamina += points;

		if (this.stamina > 100.0F)
			this.stamina = 100.0F;
	}

	public void set(float points)
	{
		this.stamina = points;
	}

	public float getStamina()
	{
		return this.stamina;
	}

	public static void syncWithClient(EntityPlayer player, float staminaValue)
	{
		if (player.worldObj.isRemote)
		{
			return;
		}
		PacketHandler.INSTANCE.sendTo(new MessageServerStaminaUpdate(staminaValue), (EntityPlayerMP) player);
	}
}
