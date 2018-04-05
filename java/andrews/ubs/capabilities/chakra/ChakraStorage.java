package andrews.ubs.capabilities.chakra;

import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
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
		NBTTagCompound compound = new NBTTagCompound();
		
	    float chakra = instance.getChakra();
	    float maxChakra = instance.getMaxChakra();
	    
	    compound.setFloat("chakra", chakra);
	    compound.setFloat("maxChakra", maxChakra);
	    
	    if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
	    {
	    	UtilsLogger.getLogger().info("[ChakraStorage] saving nbt, chakra is: " + chakra + " maxChakra is: " + maxChakra);
	    }
		return compound;
	}
	
	@Override
	public void readNBT(Capability<IChakra> capability, IChakra instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound compound = (NBTTagCompound) nbt;
		
	    float chakra = compound.getFloat("chakra");
	    float maxChakra = compound.getFloat("maxChakra");
	    
	    if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
	    {
	    	UtilsLogger.getLogger().info("[ChakraStorage] loading nbt chakra is: " + chakra + " maxChakra is: " + maxChakra);
	    }
	    instance.setMaxChakra(maxChakra);
		instance.set(chakra);
	}
}