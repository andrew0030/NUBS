package andrews.ubs.network.message.server;

import java.util.logging.Level;

import andrews.ubs.capabilities.ninja.NinjaCap;
import andrews.ubs.handlers.UBSDelayedMessageHandler;
import andrews.ubs.handlers.UBSDelayedMessageHandler.IDelayedMessage;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.logger.UBSLogger;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageNinjaUpdate implements IMessage, IMessageHandler<MessageNinjaUpdate, IMessage>, IDelayedMessage
{
    private int entityId;
    private NBTTagCompound compound;
    
    public MessageNinjaUpdate(int entityId, NBTTagCompound compound)
    {
        this.entityId = entityId;
        this.compound = compound;
    }
    
    public MessageNinjaUpdate() {}
    
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
    public IMessage onMessage(MessageNinjaUpdate message, MessageContext ctx)
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
                INinja ninjaCapability = NinjaCap.get((EntityLivingBase) entity);
                
                if (ninjaCapability != null)
                {
                    EntitySkinCapability.ENTITY_SKIN_CAP.getStorage().readNBT(EntitySkinCapability.ENTITY_SKIN_CAP, skinCapability, null, compound);
                }
            }
            else
            {
                UBSLogger.getLogger().info(Level.WARN, String.format("Failed to get entity with %d when updating IEntitySkinCapability.", entityId));
            }
        }
    }
}