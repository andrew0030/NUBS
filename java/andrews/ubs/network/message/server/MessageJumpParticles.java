package andrews.ubs.network.message.server;

import java.util.Random;

import andrews.ubs.particles.ModParticleManager;
import andrews.ubs.particles.ParticleChakra;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageJumpParticles implements IMessage, IMessageHandler<MessageJumpParticles, IMessage>
{	
	private int entityId;
	
	public MessageJumpParticles() {}
	
	public MessageJumpParticles(int entityId)
	{
		this.entityId = entityId;
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(entityId);
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.entityId = buf.readInt();
	}
	
	@Override
	public IMessage onMessage(MessageJumpParticles message, MessageContext ctx)
	{
		Entity entity = Minecraft.getMinecraft().world.getEntityByID(message.entityId);
		if(entity != null)
		{
			spawnParticles(entity, entity.posX, entity.posY, entity.posZ);
		}
		return null;
	}
	
	@SideOnly(Side.CLIENT)
	public void spawnParticles(Entity entity, double posX, double posY, double posZ)
	{		
		entity.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, posX, posY, posZ, 0, 0, 0);
	}
}