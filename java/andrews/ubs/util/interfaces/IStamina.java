package andrews.ubs.util.interfaces;

//==================
//Stamina capability
//==================

public interface IStamina
{
	public void consumeStamina(float points);

	public void fillStamina(float points);

	public void setStamina(float points);

	public float getStamina();
	
	public void setMaxStamina(float points);
	
	public float getMaxStamina();
}