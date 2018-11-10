package andrews.ubs.capabilities.ninja;

import andrews.ubs.Main;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStamina;
import andrews.ubs.util.logger.UBSLogger;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class NinjaStorage implements IStorage<INinja>
{
	@Override
	public NBTBase writeNBT(Capability<INinja> capability, INinja instance, EnumFacing side)
	{
		NBTTagCompound compound = new NBTTagCompound();
		
	    float stamina = instance.getStamina();
	    float maxStamina = instance.getMaxStamina();
	    float chakra = instance.getChakra();
	    float maxChakra = instance.getMaxChakra();
	    
	    compound.setFloat("stamina", stamina);
	    compound.setFloat("maxStamina", maxStamina);
	    compound.setFloat("chakra", chakra);
	    compound.setFloat("maxChakra", maxChakra);
	    
	    if(Main.DEVELOPER_MODE) //Developer Mode
	    {
	    	UBSLogger.getLogger().info("[StaminaStorage] saving nbt, stamina is: " + stamina + " maxStamina is: " + maxStamina);
	    }
		return compound;
	}
	
	@Override
	public void readNBT(Capability<INinja> capability, INinja instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound compound = (NBTTagCompound) nbt;
		
	    float stamina = compound.getFloat("stamina");
	    float maxStamina = compound.getFloat("maxStamina");
	    float chakra = compound.getFloat("chakra");
	    float maxChakra = compound.getFloat("maxChakra");
	    
	    if(Main.DEVELOPER_MODE) //Developer Mode
	    {
	    	UBSLogger.getLogger().info("[StaminaStorage] loading nbt stamina is: " + stamina + " maxStamina is: " + maxStamina);
	    }
	    instance.setMaxStamina(maxStamina);
		instance.setStamina(stamina);
		instance.setMaxChakra(maxChakra);
		instance.setChakra(chakra);
	}
}