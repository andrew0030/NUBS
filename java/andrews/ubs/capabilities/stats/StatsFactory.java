package andrews.ubs.capabilities.stats;

import java.util.concurrent.Callable;

import andrews.ubs.capabilities.ninja.NinjaCap;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStats;

public class StatsFactory implements Callable<IStats>
{
	@Override
	public IStats call() throws Exception
	{
		return new StatsCap(null);
	}
}
