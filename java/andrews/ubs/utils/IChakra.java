package andrews.ubs.utils;

//=================
//Chakra capability
//=================

public interface IChakra
{
	public void consume(float points);

	public void fill(float points);

	public void set(float points);

	public float getChakra();
	
	public void setMaxChakra(float points);
	
	public float getMaxChakra();
}