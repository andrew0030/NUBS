package andrews.ubs.capabilities.chakra;

import andrews.ubs.utils.IChakra;
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

public class ChakraProvider implements ICapabilitySerializable<NBTBase>
{
	@CapabilityInject(IChakra.class)
	public static final Capability<IChakra> CHAKRA_CAP = null;

	private IChakra instance = CHAKRA_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == CHAKRA_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == CHAKRA_CAP ? CHAKRA_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT()
	{
		return CHAKRA_CAP.getStorage().writeNBT(CHAKRA_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt)
	{
		CHAKRA_CAP.getStorage().readNBT(CHAKRA_CAP, this.instance, null, nbt);
	}
}
