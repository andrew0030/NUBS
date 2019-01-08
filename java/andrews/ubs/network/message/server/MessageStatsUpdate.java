package andrews.ubs.network.message.server;

import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.capabilities.stats.StatsProvider;
import andrews.ubs.handlers.UBSDelayedMessageHandler;
import andrews.ubs.handlers.UBSDelayedMessageHandler.IDelayedMessage;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStats;
import andrews.ubs.util.logger.UBSLogger;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageStatsUpdate implements IMessage, IMessageHandler<MessageStatsUpdate, IMessage>, IDelayedMessage
{
    private int entityId;
    private NBTTagCompound compound;
    
    public MessageStatsUpdate(int entityId, NBTTagCompound compound)
    {
        this.entityId = entityId;
        this.compound = compound;
    }
    
    public MessageStatsUpdate() {}
    
    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(entityId);
        ByteBufUtils.writeTag(buf, compound);
    }
    
    @Override
    public void fromBytes(ByteBuf buf)
    {
        entityId = buf.readInt();
        compound = ByteBufUtils.readTag(buf);
    }
    
    @Override
    public IMessage onMessage(MessageStatsUpdate message, MessageContext ctx)
    {
        UBSDelayedMessageHandler.addDelayedMessage(message);
        return null;
    }

    @Override
    public boolean isReady()
    {
        if (Minecraft.getMinecraft().world != null)
        {
            return Minecraft.getMinecraft().world.getEntityByID(entityId) != null;
        }
        return false;
    }

    @Override
    public void onDelayedMessage()
    {
        if (Minecraft.getMinecraft().world != null)
        {
            Entity entity = Minecraft.getMinecraft().world.getEntityByID(entityId);
            
            if (entity != null)
            {
                IStats statsCapability = entity.getCapability(StatsProvider.STATS_CAP, null);
                
                if (statsCapability != null)
                {
                	StatsProvider.STATS_CAP.getStorage().readNBT(StatsProvider.STATS_CAP, statsCapability , null, compound);
                }
            }
            else
            {
                UBSLogger.getLogger().info("Failed to get entity with when updating.", entityId);
            }
        }
    }
}