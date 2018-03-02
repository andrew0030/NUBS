package andrews.ubs.capabilities.chakra;

import andrews.ubs.utils.IChakra;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

//==============================================================================
//This class is responsible for saving and reading chakra data from or to server
//==============================================================================

public class ChakraStorage implements IStorage<IChakra>

{
	@Override
	public NBTBase writeNBT(Capability<IChakra> capability, IChakra instance, EnumFacing side)
	{
		return new NBTTagFloat(instance.getChakra());
	}

	@Override
	public void readNBT(Capability<IChakra> capability, IChakra instance, EnumFacing side, NBTBase nbt)
	{
		instance.set(((NBTPrimitive) nbt).getFloat());
	}
}