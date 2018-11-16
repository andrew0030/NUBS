package andrews.ubs.util.interfaces;

//=================
//Chakra capability
//=================

public interface IChakra
{
	public void consumeChakra(float points);

	public void fillChakra(float points);

	public void setChakra(float points);

	public float getChakra();
	
	public void setMaxChakra(float points);
	
	public float getMaxChakra();
	
	public void setCollectingChakra(boolean colleactingChakra);
	
	public boolean getCollectingChakra();
}