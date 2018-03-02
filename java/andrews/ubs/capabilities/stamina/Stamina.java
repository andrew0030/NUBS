package andrews.ubs.capabilities.stamina;

import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.IStamina;

//=================================
//Default implementation of IChakra
//=================================

public class Stamina implements IStamina
{
	private float stamina = 100.0F;
	 
	public void consume(float points)	
	{
		this.stamina -= points;
	
		if (this.stamina < 0.0F) this.stamina = 0.0F;
	}
	
	public void fill(float points)
	{
		this.stamina += points;
	 
		if (this.stamina > 100.0F) this.stamina = 100.0F;
	}
	 
	public void set(float points)
	{
		this.stamina = points;
	}
	 
	public float getStamina()
	{
		return this.stamina;
	}
}
