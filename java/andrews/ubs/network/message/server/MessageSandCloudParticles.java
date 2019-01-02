package andrews.ubs.network.message.server;

import java.util.Random;

import andrews.ubs.particles.ModParticleManager;
import andrews.ubs.particles.ParticleChakra;
import andrews.ubs.particles.ParticleSandCloud;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageSandCloudParticles implements IMessage, IMessageHandler<MessageSandCloudParticles, IMessage>
{	
	private int entityId;
	
	public MessageSandCloudParticles() {}
	
	public MessageSandCloudParticles(int entityId)
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
	public IMessage onMessage(MessageSandCloudParticles message, MessageContext ctx)
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
		for(int i = 0; i < 20; i++)
		{	
			Random rand = new Random();
			double particleX = entity.posX + ((rand.nextDouble() - 0.5D) / (double)entity.width * 1.4D);
			double particleY = entity.posY + (rand.nextDouble() - 0.5D) / (double)entity.height * 1.0D;
			double particleZ = entity.posZ + (rand.nextDouble() - 0.5D) / (double)entity.width * 1.4D;
			
			ParticleSandCloud particle = new ParticleSandCloud(entity.getEntityWorld(), entity, particleX, particleY, particleZ, 0, 0, 0);
			ModParticleManager.spawnParticleSandCloud(particle);
		}
	}
}