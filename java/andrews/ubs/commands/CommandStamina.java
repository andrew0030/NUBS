package andrews.ubs.commands;

import java.util.List;

import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.util.interfaces.INinja;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class CommandStamina extends CommandBase
{
	 private static final String[] SUB_OPTIONS1 = new String[] {"set"};
	 private static final String[] SUB_OPTIONS2 = new String[] {"amount", "max"};
	
	@Override
	public String getName()
	{
		return "stamina";
	}
	
	public int getRequiredPermissionLevel()
    {
        return 4;
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
        	return getListOfStringsMatchingLastWord(args, SUB_OPTIONS2);
        }
        return super.getTabCompletions(server, sender, args, targetPos);
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if(args.length > 2)
		{
			if("set".equals(args[0]))
			{
				EntityPlayerMP player = getCommandSenderAsPlayer(sender);
				
				if("max".equals(args[1]))
				{	
					INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
					int i1 = parseInt(args[2], 10);
					
					ninjaCap.setMaxStamina(i1);
					ninjaCap.syncToAll();
				}
				else if("amount".equals(args[1]))
				{
					INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
					int i2 = parseInt(args[2], 1, (int) Math.floor(ninjaCap.getMaxStamina()));
					
					ninjaCap.setStamina(i2);
					ninjaCap.syncToAll();
				}
			}
			
			if(sender instanceof EntityPlayer)
			{
				
			}
		}
	}
}