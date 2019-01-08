package andrews.ubs.capabilities.stats;

import andrews.ubs.network.PacketHandler;
import andrews.ubs.network.message.server.MessageStatsUpdate;
import andrews.ubs.util.interfaces.IStats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class StatsCap implements IStats
{
	//Stats
	private float strength = 1F;
	private float defense = 1F;
	private float reserve = 1F;
	private float meditation = 1F;
	private float ninjutsu = 1F;
	private float taijutsu = 1F;
	private float genjutsu = 1F;
	private float avPoints = 0F;
	//Entity
	private final EntityLivingBase entity;
	
	public StatsCap(EntityLivingBase entity)
	{
	    this.entity = entity;
	}
	
//=====================
// All Strength editing
//=====================
	@Override
	public float getStrength()
	{
		return this.strength;
	}

	@Override
	public void setStrength(float points)
	{
		this.strength = points;
	}

	@Override
	public void fillStrength(float points)
	{
		this.strength += points;
	}

	@Override
	public void consumeStrength(float points)
	{
		this.strength -= points;

		if (this.strength < 1F)
			this.strength = 1F;
	}
	
//=====================
// All Defense editing
//=====================
	@Override
	public float getDefense()
	{
		return this.defense;
	}

	@Override
	public void setDefense(float points)
	{
		this.defense = points;
	}

	@Override
	public void fillDefense(float points)
	{
		this.defense += points;
	}

	@Override
	public void consumeDefense(float points)
	{
		this.defense -= points;

		if (this.defense < 1F)
			this.defense = 1F;
	}

//=====================
// All Reserve editing
//=====================
	@Override
	public float getReserve()
	{
		return this.reserve;
	}

	@Override
	public void setReserve(float points)
	{
		this.reserve = points;
	}

	@Override
	public void fillReserve(float points)
	{
		this.reserve += points;
	}

	@Override
	public void consumeReserve(float points)
	{
		this.reserve -= points;

		if (this.reserve < 1F)
			this.reserve = 1F;
	}

//=======================
// All Meditation editing
//=======================
	@Override
	public float getMeditation()
	{
		return this.meditation;
	}

	@Override
	public void setMeditation(float points)
	{
		this.meditation = points;
	}

	@Override
	public void fillMeditation(float points)
	{
		this.meditation += points;
	}

	@Override
	public void consumeMeditation(float points)
	{
		this.meditation -= points;

		if (this.meditation < 1F)
			this.meditation = 1F;
	}

//=====================
// All Ninjutsu editing
//=====================
	@Override
	public float getNinjutsu()
	{
		return this.ninjutsu;
	}

	@Override
	public void setNinjutsu(float points)
	{
		this.ninjutsu = points;
	}

	@Override
	public void fillNinjutsu(float points)
	{
		this.ninjutsu += points;
	}

	@Override
	public void consumeNinjutsu(float points)
	{
		this.ninjutsu -= points;

		if (this.ninjutsu < 1F)
			this.ninjutsu = 1F;
	}

//=====================
// All Taijutsu editing
//=====================
	@Override
	public float getTaijutsu()
	{
		return this.taijutsu;
	}

	@Override
	public void setTaijutsu(float points)
	{
		this.taijutsu = points;
	}

	@Override
	public void fillTaijutsu(float points)
	{
		this.taijutsu += points;
	}

	@Override
	public void consumeTaijutsu(float points)
	{
		this.taijutsu -= points;

		if (this.taijutsu < 1F)
			this.taijutsu = 1F;
	}

//=====================
// All Genjutsu editing
//=====================
	@Override
	public float getGenjutsu()
	{
		return this.genjutsu;
	}

	@Override
	public void setGenjutsu(float points)
	{
		this.genjutsu = points;
	}

	@Override
	public void fillGenjutsu(float points)
	{
		this.genjutsu += points;
	}

	@Override
	public void consumeGenjutsu(float points)
	{
		this.genjutsu -= points;

		if (this.genjutsu < 1F)
			this.genjutsu = 1F;
	}
	
//=============================
// All Available Points editing
//=============================
	@Override
	public float getAvPoint()
	{
		return this.avPoints;
	}

	@Override
	public void setAvPoint(float points)
	{
		this.avPoints = points;
	}

	@Override
	public void fillAvPoint(float points)
	{
		this.avPoints += points;
	}

	@Override
	public void consumeAvPoint(float points)
	{
		this.avPoints -= points;

		if (this.avPoints < 0F)
			this.avPoints = 0F;
	}
	
//=============================
//To sync The Client and Server
//=============================
	protected IMessage getUpdateMessage()
	{
        NBTTagCompound compound = (NBTTagCompound)StatsProvider.STATS_CAP.getStorage().writeNBT(StatsProvider.STATS_CAP, this, null);
        return new MessageStatsUpdate(entity.getEntityId(), compound);
    }
	
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
