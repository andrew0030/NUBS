package andrews.ubs.commands;

import andrews.ubs.utils.UtilsLogger;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class CommandSetChakra extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "ubssetchakra";
	}

	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "/<command>";
	}
	
//Return the required permission level for this command.
    public int getRequiredPermissionLevel()
    {
        return 4;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		World world = sender.getEntityWorld();
		if(world.isRemote)
		{
			UtilsLogger.getLogger().info("Not processing on the Client Side");
		}
		else
		{
			UtilsLogger.getLogger().info("Processing on the Server Side");
			
			EntityPlayerMP player = getCommandSenderAsPlayer(sender);
		}
	}

}
