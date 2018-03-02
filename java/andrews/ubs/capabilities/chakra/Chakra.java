package andrews.ubs.capabilities.chakra;

import andrews.ubs.utils.IChakra;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//=================================
//Default implementation of IChakra
//=================================
public class Chakra implements IChakra
{	
	private float chakra = 100.0F;
	 
	public void consume(float points)	
	{
		this.chakra -= points;
	
		if (this.chakra < 0.0F) this.chakra = 0.0F;
	}
	
	public void fill(float points)
	{
		this.chakra += points;
	 
		if (this.chakra > 100.0F) this.chakra = 100.0F;
	}
	 
	public void set(float points)
	{
		this.chakra = points;
	}
	 
	public float getChakra()
	{
		return this.chakra;
	}
}
