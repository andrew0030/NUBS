package andrews.ubs.util.interfaces;

import net.minecraft.entity.player.EntityPlayerMP;

public interface IStats
{
	//Syncing
	public void syncToAll();
    public void syncToPlayer(EntityPlayerMP entityPlayer);
    
	//Strength
	public float getStrength();
	public void setStrength(float points);
	public void fillStrength(float points);
	public void consumeStrength(float points);
	
	//Defense
	public float getDefense();
	public void setDefense(float points);
	public void fillDefense(float points);
	public void consumeDefense(float points);
	
	//Chakra
	public float getReserve();
	public void setReserve(float points);
	public void fillReserve(float points);
	public void consumeReserve(float points);
	
	//Meditation
	public float getMeditation();
	public void setMeditation(float points);
	public void fillMeditation(float points);
	public void consumeMeditation(float points);
	
	//Ninjutsu
	public float getNinjutsu();
	public void setNinjutsu(float points);
	public void fillNinjutsu(float points);
	public void consumeNinjutsu(float points);
	
	//Taijutsu
	public float getTaijutsu();
	public void setTaijutsu(float points);
	public void fillTaijutsu(float points);
	public void consumeTaijutsu(float points);
	
	//Genjutsu
	public float getGenjutsu();
	public void setGenjutsu(float points);
	public void fillGenjutsu(float points);
	public void consumeGenjutsu(float points);
	
	//Available Points
	public float getAvPoint();
	public void setAvPoint(float points);
	public void fillAvPoint(float points);
	public void consumeAvPoint(float points);
}
