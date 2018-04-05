package andrews.ubs.utils;

//==================
//Stamina capability
//==================

public interface IStamina
{
	public void consume(float points);

	public void fill(float points);

	public void set(float points);

	public float getStamina();
	
	public void setMaxStamina(float points);
	
	public float getMaxStamina();
}