package andrews.ubs.capabilities.stamina;

import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.IStamina;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

//==================================================================================
//Chakra provider			 	  												   #
//																				   #
//This class is responsible for providing a capability. Other modders may 		   #
//attach their own provider with implementation that returns another 		       #
//implementation of IChakra to the target's (Entity, TE, ItemStack, etc.) disposal.#
//==================================================================================

public class StaminaProvider implements ICapabilitySerializable<NBTBase>
{
	@CapabilityInject(IStamina.class)
	public static final Capability<IStamina> STAMINA_CAP = null;

	private IStamina instance = STAMINA_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == STAMINA_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == STAMINA_CAP ? STAMINA_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT()
	{
		return STAMINA_CAP.getStorage().writeNBT(STAMINA_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt)
	{
		STAMINA_CAP.getStorage().readNBT(STAMINA_CAP, this.instance, null, nbt);
	}
}
