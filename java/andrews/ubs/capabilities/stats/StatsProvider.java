package andrews.ubs.capabilities.stats;

import andrews.ubs.capabilities.ninja.NinjaCap;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class StatsProvider implements ICapabilitySerializable<NBTBase>
{
	@CapabilityInject(IStats.class)
	public static final Capability<IStats> STATS_CAP = null;

	private final IStats instance;
	
	public StatsProvider(EntityLivingBase entity)
	{
	    instance = new StatsCap(entity);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == STATS_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == STATS_CAP ? STATS_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT()
	{
		return STATS_CAP.getStorage().writeNBT(STATS_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt)
	{
		STATS_CAP.getStorage().readNBT(STATS_CAP, this.instance, null, nbt);
	}
}