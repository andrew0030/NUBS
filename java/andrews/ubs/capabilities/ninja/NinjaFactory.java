package andrews.ubs.capabilities.ninja;

import java.util.concurrent.Callable;

import andrews.ubs.util.interfaces.INinja;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class NinjaFactory implements Callable<INinja>
{

	@Override
	public INinja call() throws Exception
	{
		return new NinjaCap(null);
	}
	
}
