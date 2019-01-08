package andrews.ubs.capabilities.stats;

import andrews.ubs.Main;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStats;
import andrews.ubs.util.logger.UBSLogger;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class StatsStorage implements IStorage<IStats>
{
	@Override
	public NBTBase writeNBT(Capability<IStats> capability, IStats instance, EnumFacing side)
	{
		NBTTagCompound compound = new NBTTagCompound();
		
	    float strength = instance.getStrength();
	    float defense = instance.getDefense();
	    float reserve = instance.getReserve();
	    float meditation = instance.getMeditation();
	    float ninjutsu = instance.getNinjutsu();
	    float taijutsu = instance.getTaijutsu();
	    float genjutsu = instance.getGenjutsu();
	    float avPoint = instance.getAvPoint();
	    
	    compound.setFloat("strength", strength);
	    compound.setFloat("defense", defense);
	    compound.setFloat("reserve", reserve);
	    compound.setFloat("meditation", meditation);
	    compound.setFloat("ninjutsu", ninjutsu);
	    compound.setFloat("taijutsu", taijutsu);
	    compound.setFloat("genjutsu", genjutsu);
	    compound.setFloat("avPoint", avPoint);
	    
	    if(Main.DEVELOPER_MODE) //Developer Mode
	    {
	    	UBSLogger.getLogger().info("[StatsStorage] saving nbt");
	    }
		return compound;
	}
	
	@Override
	public void readNBT(Capability<IStats> capability, IStats instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound compound = (NBTTagCompound) nbt;
		
	    float strength = compound.getFloat("strength");
	    float defense = compound.getFloat("defense");
	    float reserve = compound.getFloat("reserve");
	    float meditation = compound.getFloat("meditation");
	    float ninjutsu = compound.getFloat("ninjutsu");
	    float taijutsu = compound.getFloat("taijutsu");
	    float genjutsu = compound.getFloat("genjutsu");
	    float avPoint = compound.getFloat("avPoint");
	    
	    if(Main.DEVELOPER_MODE) //Developer Mode
	    {
	    	UBSLogger.getLogger().info("[StatsStorage] loading nbt");
	    }
	    instance.setStrength(strength);
	    instance.setDefense(defense);
	    instance.setReserve(reserve);
	    instance.setMeditation(meditation);
	    instance.setNinjutsu(ninjutsu);
	    instance.setTaijutsu(taijutsu);
	    instance.setGenjutsu(genjutsu);
	    instance.setAvPoint(avPoint);
	}
}