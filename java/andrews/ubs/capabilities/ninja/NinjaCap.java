package andrews.ubs.capabilities.ninja;

import andrews.ubs.Main;
import andrews.ubs.network.PacketHandler;
import andrews.ubs.network.message.server.MessageNinjaUpdate;
import andrews.ubs.util.interfaces.IChakra;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStamina;
import andrews.ubs.util.logger.UBSLogger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

//=================================
//Default implementation of IChakra
//=================================
public class NinjaCap implements INinja
{
	private float chakra = 100.0F;
	private float maxChakra = 100.0F;
	private float stamina = 100.0F;
	private float maxStamina = 100.0F;
	
	private boolean collectingChakra;
	
	private final EntityLivingBase entity;
	
	public NinjaCap(EntityLivingBase entity)
	{
	    this.entity = entity;
	}

//To consume the given amount from Chakra
	public void consumeChakra(float points)
	{
		this.chakra -= points;

		if (this.chakra < 0.0F)
			this.chakra = 0.0F;
		
		if(Main.DEVELOPER_MODE) //Developer Mode
		{
			UBSLogger.getLogger().info("[Chakra] consume " + chakra);
		}
	}

//To add the given amount too Chakra 
	public void fillChakra(float points)
	{
		this.chakra += points;

		if(this.chakra > this.maxChakra)
		   this.chakra = this.maxChakra;
		
		if(Main.DEVELOPER_MODE) //Developer Mode
		{
			UBSLogger.getLogger().info("[Chakra] fill " + chakra);
		}
	}

//To set the Chakra amount
	public void setChakra(float points)
	{
		this.chakra = points;
		if(this.chakra > this.maxChakra)
		   this.chakra = this.maxChakra;
		
		if(Main.DEVELOPER_MODE) //Developer Mode
		{
			UBSLogger.getLogger().info("[Chakra] set " + chakra);
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
		
		if(Main.DEVELOPER_MODE) //Developer Mode
		{
			UBSLogger.getLogger().info("[Chakra] setMax " + maxChakra);
		}
	}
	
	public void consumeStamina(float points)
	{
		this.stamina -= points;

		if (this.stamina < 0.0F)
			this.stamina = 0.0F;
		if(Main.DEVELOPER_MODE) //Developer Mode
		{
			UBSLogger.getLogger().info("[Stamina] consume " + stamina);
		}
	}

	public void fillStamina(float points)
	{
		this.stamina += points;

		if (this.stamina > this.maxStamina)
			this.stamina = this.maxStamina;
		
		if(Main.DEVELOPER_MODE) //Developer Mode
		{
			UBSLogger.getLogger().info("[Stamina] fill " + stamina);
		}
	}

	public void setStamina(float points)
	{
		this.stamina = points;
		
		if(Main.DEVELOPER_MODE) //Developer Mode
		{
			UBSLogger.getLogger().info("[Stamina] set " + stamina);
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
		
		if(Main.DEVELOPER_MODE) //Developer Mode
		{
			UBSLogger.getLogger().info("[Stamina] setMax " + maxStamina);
		}
	}

//To get Max Stamina
	public float getMaxStamina()
	{
		return this.maxStamina;
	}

//To get Max Chakra
	public float getMaxChakra()
	{
		return this.maxChakra;
	}
	
	public void setCollectingChakra(boolean collectingChakra)
	{
		this.collectingChakra = collectingChakra;
	}
	
	public boolean getCollectingChakra()
	{
		return this.collectingChakra;
	}
	
	protected IMessage getUpdateMessage()
	{
        NBTTagCompound compound = (NBTTagCompound)NinjaProvider.NINJA_CAP.getStorage().writeNBT(NinjaProvider.NINJA_CAP, this, null);
        return new MessageNinjaUpdate(entity.getEntityId(), compound);
    }
	
//To sync The Client and Server
	@Override
	public void syncToAll()
	{
		if (entity.getEntityWorld().isRemote)
		{
			return;
		}
		if (entity instanceof EntityPlayerMP)
		{
			syncToPlayer((EntityPlayerMP)entity);
		}
		syncToAllTracking();
	}
	
	@Override
    public void syncToPlayer(EntityPlayerMP entityPlayer)
    {
    	PacketHandler.INSTANCE.sendTo(getUpdateMessage(), entityPlayer);
    }

	public void syncToAllTracking() 
    {
    	PacketHandler.INSTANCE.sendToAllTracking(getUpdateMessage(), entity);
    }
}