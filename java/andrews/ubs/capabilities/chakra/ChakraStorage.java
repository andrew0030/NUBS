package andrews.ubs.capabilities.chakra;

import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.UtilsLogger;
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
	    float chakra = instance.getChakra();
	    float maxChakra = instance.getMaxChakra();
	    
	    if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
	    {
	    	UtilsLogger.getLogger().info("[ChakraStorage] saving nbt, chakra is: " + chakra + " maxChakra is: " + maxChakra);
	    }
		return new NBTTagFloat(chakra);
	}
	
	@Override
	public void readNBT(Capability<IChakra> capability, IChakra instance, EnumFacing side, NBTBase nbt)
	{
	    float chakra = ((NBTPrimitive) nbt).getFloat();
	    float maxChakra = ((NBTPrimitive) nbt).getFloat();
	    
	    if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
	    {
	    	UtilsLogger.getLogger().info("[ChakraStorage] loading nbt chakra is: " + chakra + " maxChakra is: " + maxChakra);
	    }
		instance.set(chakra);
		instance.setMaxChakra(maxChakra);
	}
}