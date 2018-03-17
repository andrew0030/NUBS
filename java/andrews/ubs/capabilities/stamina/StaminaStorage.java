package andrews.ubs.capabilities.stamina;

import andrews.ubs.utils.IStamina;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

//===============================================================================
//This class is responsible for saving and reading stamina data from or to server
//===============================================================================

public class StaminaStorage implements IStorage<IStamina>

{
	@Override
	public NBTBase writeNBT(Capability<IStamina> capability, IStamina instance, EnumFacing side)
	{
		float stamina = instance.getStamina();
	    UtilsLogger.getLogger().info("saving nbt " + stamina);
		return new NBTTagFloat(stamina);
	}

	@Override
	public void readNBT(Capability<IStamina> capability, IStamina instance, EnumFacing side, NBTBase nbt)
	{
		float stamina = ((NBTPrimitive) nbt).getFloat();
	    UtilsLogger.getLogger().info("loading nbt " + stamina);
		instance.set(stamina);
	}
}