package andrews.ubs.capabilities.stamina;

import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.IStamina;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
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
		NBTTagCompound compound = new NBTTagCompound();
		
	    float stamina = instance.getStamina();
	    float maxStamina = instance.getMaxStamina();
	    
	    compound.setFloat("stamina", stamina);
	    compound.setFloat("maxStamina", maxStamina);
	    
	    if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
	    {
	    	UtilsLogger.getLogger().info("[StaminaStorage] saving nbt, stamina is: " + stamina + " maxStamina is: " + maxStamina);
	    }
		return compound;
	}
	
	@Override
	public void readNBT(Capability<IStamina> capability, IStamina instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound compound = (NBTTagCompound) nbt;
		
	    float stamina = compound.getFloat("stamina");
	    float maxStamina = compound.getFloat("maxStamina");
	    
	    if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
	    {
	    	UtilsLogger.getLogger().info("[StaminaStorage] loading nbt stamina is: " + stamina + " maxStamina is: " + maxStamina);
	    }
	    instance.setMaxStamina(maxStamina);
		instance.set(stamina);
	}
}