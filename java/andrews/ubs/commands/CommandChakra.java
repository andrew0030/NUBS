package andrews.ubs.commands;

import java.util.List;

import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.util.interfaces.INinja;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class CommandChakra extends CommandBase
{
	 private static final String[] SUB_OPTIONS1 = new String[] {"set", "add", "remove"};
	 private static final String[] SUB_OPTIONS2 = new String[] {"amount", "max"};
	
	@Override
	public String getName()
	{
		return "chakra";
	}
	
	public int getRequiredPermissionLevel()
    {
        return 2;
    }

	@Override
	public String getUsage(ICommandSender sender)
	{
		return "commands.ubs." + getName() + ".usage";
	}
	
	@Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos)
	{
        if(args.length == 1)
        {
            return getListOfStringsMatchingLastWord(args, SUB_OPTIONS1);
        }
        else if(args.length == 2)
        {
        	return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
        }
        else if(args.length == 3)
        {
        	return getListOfStringsMatchingLastWord(args, SUB_OPTIONS2);
        }
        return super.getTabCompletions(server, sender, args, targetPos);
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if(args.length > 3)
		{	
			if("set".equals(args[0]))
			{
				EntityPlayer player = getPlayer(server, sender, args[1]);
				
				if("max".equals(args[2]))
				{	
					INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
					int maxChakra = parseInt(args[3], 10);
					
					ninjaCap.setMaxChakra(maxChakra);
					ninjaCap.syncToAll();
				}
				else if("amount".equals(args[2]))
				{
					INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
					int chakra = parseInt(args[3], 1, (int) Math.floor(ninjaCap.getMaxChakra()));
					
					ninjaCap.setChakra(chakra);
					ninjaCap.syncToAll();
				}
			}
			else if("add".equals(args[0]))
			{
				EntityPlayer player = getPlayer(server, sender, args[1]);
				
				if("max".equals(args[2]))
				{	
					INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
					int maxChakra = parseInt(args[3], 1);
					
					ninjaCap.setMaxChakra(ninjaCap.getMaxChakra() + maxChakra);
					ninjaCap.syncToAll();
				}
				else if("amount".equals(args[2]))
				{
					INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
					int chakra = parseInt(args[3], 1);
					
					ninjaCap.fillChakra(chakra);
					ninjaCap.syncToAll();
				}
			}
			else if("remove".equals(args[0]))
			{
				EntityPlayer player = getPlayer(server, sender, args[1]);
				
				if("max".equals(args[2]))
				{	
					INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
					int maxChakra = parseInt(args[3], 1, (int) Math.floor(ninjaCap.getMaxChakra() - 10));
					
					ninjaCap.setMaxChakra(ninjaCap.getMaxChakra() - maxChakra);
					ninjaCap.syncToAll();
				}
				else if("amount".equals(args[2]))
				{
					INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
					int chakra = parseInt(args[3], 1);
					
					ninjaCap.consumeChakra(chakra);
					ninjaCap.syncToAll();
				}
			}
		}
	}
}
