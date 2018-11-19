package andrews.ubs.network.message.server;

import java.util.Random;

import andrews.ubs.particles.ModParticleManager;
import andrews.ubs.particles.ParticleChakra;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageChakraParticles implements IMessage, IMessageHandler<MessageChakraParticles, IMessage>
{	
	private int entityId;
	
	public MessageChakraParticles() {}
	
	public MessageChakraParticles(int entityId)
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
	public IMessage onMessage(MessageChakraParticles message, MessageContext ctx)
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
		for(int i = 0; i < 4; i++)
		{	
			Random rand = new Random();
			double particleX = entity.posX + ((rand.nextDouble() - 0.5D) / (double)entity.width * 3.0D);
			double particleY = entity.posY + 1.3D + (rand.nextDouble() - 0.5D) / (double)entity.width * 3.0D;
			double particleZ = entity.posZ + (rand.nextDouble() - 0.5D) / (double)entity.width * 3.0D;
			
			ParticleChakra particle = new ParticleChakra(entity.getEntityWorld(), entity, particleX, particleY, particleZ, 0, 0, 0);
			ModParticleManager.spawnParticle(particle);
		}
	}
}