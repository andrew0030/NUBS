package andrews.ubs.capabilities.ninja;

import andrews.ubs.util.interfaces.INinja;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class NinjaProvider implements ICapabilitySerializable<NBTBase>
{
	@CapabilityInject(INinja.class)
	public static final Capability<INinja> NINJA_CAP = null;

	private INinja instance = NINJA_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == NINJA_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == NINJA_CAP ? NINJA_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT()
	{
		return NINJA_CAP.getStorage().writeNBT(NINJA_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt)
	{
		NINJA_CAP.getStorage().readNBT(NINJA_CAP, this.instance, null, nbt);
	}
}