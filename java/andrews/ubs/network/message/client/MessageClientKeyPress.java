package andrews.ubs.network.message.client;

import akka.io.Tcp.Message;
import andrews.ubs.network.PacketHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.network.ServerPinger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageClientKeyPress implements IMessage, IMessageHandler<MessageClientKeyPress, IMessage>
{
	
	byte KeyId;
	
	public MessageClientKeyPress(){}
	
	public MessageClientKeyPress(byte KeyId)
	{
		this.KeyId = KeyId;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.KeyId = buf.readByte();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeByte(KeyId);
	}
	
	@Override public IMessage onMessage(MessageClientKeyPress message, MessageContext ctx)
	{
		
	//========================
	//The Player (Server Side)
	//========================
		EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;
		
	//=======================
	//To Edit The Jump Height
	//=======================
		float add_Y_Walk = 0.2F;
		float add_Y_Sprint = 0.8F;
		
	//========================================
	//To Edit The Distance On The X and Z Axis
	//========================================
		float walkingSpeedPush = 0.2F;
		float sprintingSpeedPush = 0.6F;
		
	//=================
	//The Yaw Direction
	//=================
		float f = serverPlayer.rotationYaw * 0.017453292F;
		switch (message.KeyId)
		{
		
		case 1:
			serverPlayer.motionX -= (double)(MathHelper.sin(f + 15) * walkingSpeedPush * -1);
			serverPlayer.motionY += add_Y_Walk;
			serverPlayer.motionZ += (double)(MathHelper.cos(f + 15) * walkingSpeedPush * -1);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 1 Called");
		break;
		    
		case 7:
			serverPlayer.motionX -= (double)(MathHelper.sin(f - 15) * walkingSpeedPush * -1);
			serverPlayer.motionY += add_Y_Walk;
			serverPlayer.motionZ += (double)(MathHelper.cos(f - 15) * walkingSpeedPush * -1);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 7 Called");
		break;
		
		case 0:
			serverPlayer.motionX -= (double)(MathHelper.sin(f) * walkingSpeedPush);
			serverPlayer.motionY += add_Y_Walk;
			serverPlayer.motionZ += (double)(MathHelper.cos(f) * walkingSpeedPush);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 0 Called");
		break;

		case 5:
			serverPlayer.motionX -= (double)(MathHelper.sin(f - 15) * walkingSpeedPush);
			serverPlayer.motionY += add_Y_Walk;
			serverPlayer.motionZ += (double)(MathHelper.cos(f - 15) * walkingSpeedPush);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 5 Called");
		break;

		case 3:
			serverPlayer.motionX -= (double)(MathHelper.sin(f + 15) * walkingSpeedPush);
			serverPlayer.motionY += add_Y_Walk;
			serverPlayer.motionZ += (double)(MathHelper.cos(f + 15) * walkingSpeedPush);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 3 Called");
		break;

		case 4:
			serverPlayer.motionX -= (double)(MathHelper.sin(f) * walkingSpeedPush * -1);
			serverPlayer.motionY += add_Y_Walk;
			serverPlayer.motionZ += (double)(MathHelper.cos(f) * walkingSpeedPush * -1);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 4 Called");
		break;

		case 2:
			serverPlayer.motionX -= (double)(MathHelper.sin(f - 55) * walkingSpeedPush);
			serverPlayer.motionY += add_Y_Walk;
			serverPlayer.motionZ += (double)(MathHelper.cos(f - 55) * walkingSpeedPush);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 2 Called");
		break;

		case 6:
			serverPlayer.motionX -= (double)(MathHelper.sin(f + 55) * walkingSpeedPush);
			serverPlayer.motionY += add_Y_Walk;
			serverPlayer.motionZ += (double)(MathHelper.cos(f + 55) * walkingSpeedPush);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 6 Called");
		break;

		case 9:
			serverPlayer.motionX -= (double)(MathHelper.sin(f + 15) * sprintingSpeedPush * -1);
			serverPlayer.motionY += add_Y_Sprint;
			serverPlayer.motionZ += (double)(MathHelper.cos(f + 15) * sprintingSpeedPush * -1);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 9 Called");
		break;

		case 15:
			serverPlayer.motionX -= (double)(MathHelper.sin(f - 15) * sprintingSpeedPush * -1);
			serverPlayer.motionY += add_Y_Sprint;
			serverPlayer.motionZ += (double)(MathHelper.cos(f - 15) * sprintingSpeedPush * -1);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 15 Called");
		break;

		case 8:
			serverPlayer.motionX -= (double)(MathHelper.sin(f) * sprintingSpeedPush);
			serverPlayer.motionY += add_Y_Sprint;
			serverPlayer.motionZ += (double)(MathHelper.cos(f) * sprintingSpeedPush);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 8 Called");
		break;

		case 13:
			serverPlayer.motionX -= (double)(MathHelper.sin(f - 15) * sprintingSpeedPush);
			serverPlayer.motionY += add_Y_Sprint;
			serverPlayer.motionZ += (double)(MathHelper.cos(f - 15) * sprintingSpeedPush);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 13 Called");
		break;

		case 11:
			serverPlayer.motionX -= (double)(MathHelper.sin(f + 15) * sprintingSpeedPush);
			serverPlayer.motionY += add_Y_Sprint;
			serverPlayer.motionZ += (double)(MathHelper.cos(f + 15) * sprintingSpeedPush);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 11 Called");
		break;

		case 12:
			serverPlayer.motionX -= (double)(MathHelper.sin(f) * sprintingSpeedPush * -1);
			serverPlayer.motionY += add_Y_Sprint;
			serverPlayer.motionZ += (double)(MathHelper.cos(f) * sprintingSpeedPush * -1);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 12 Called");
		break;

		case 10:
			serverPlayer.motionX -= (double)(MathHelper.sin(f - 55) * sprintingSpeedPush);
			serverPlayer.motionY += add_Y_Sprint;
			serverPlayer.motionZ += (double)(MathHelper.cos(f - 55) * sprintingSpeedPush);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 10 Called");
		break;

		case 14:
			serverPlayer.motionX -= (double)(MathHelper.sin(f + 55) * sprintingSpeedPush);
			serverPlayer.motionY += add_Y_Sprint;
			serverPlayer.motionZ += (double)(MathHelper.cos(f + 55) * sprintingSpeedPush);
			serverPlayer.velocityChanged = true;
			System.out.print("Case 14 Called");
		}
		
	// No response packet
	    return null;
	}
}
	
	
	/**
	 * 
	 * 	//===========
	//Jump Normal
	//===========
		if (message.forward == true)
		{
			if(message.left == true)
			{
				serverPlayer.motionX -= (double)(MathHelper.sin(f + 15) * walkingSpeedPush * -1);
				serverPlayer.motionY += add_Y_Walk;
				serverPlayer.motionZ += (double)(MathHelper.cos(f + 15) * walkingSpeedPush * -1);
			}
			else if (message.right == true)
			{
				serverPlayer.motionX -= (double)(MathHelper.sin(f - 15) * walkingSpeedPush * -1);
				serverPlayer.motionY += add_Y_Walk;
				serverPlayer.motionZ += (double)(MathHelper.cos(f - 15) * walkingSpeedPush * -1);
			}
			else
			{
				serverPlayer.motionX -= (double)(MathHelper.sin(f) * walkingSpeedPush);
				serverPlayer.motionY += add_Y_Walk;
				serverPlayer.motionZ += (double)(MathHelper.cos(f) * walkingSpeedPush);
			}
		}
		else if(message.back == true)
		{
			if(message.left == true)
			{
				serverPlayer.motionX -= (double)(MathHelper.sin(f - 15) * walkingSpeedPush);
				serverPlayer.motionY += add_Y_Walk;
				serverPlayer.motionZ += (double)(MathHelper.cos(f - 15) * walkingSpeedPush);
			}
			else if (message.right == true)
			{
				serverPlayer.motionX -= (double)(MathHelper.sin(f + 15) * walkingSpeedPush);
				serverPlayer.motionY += add_Y_Walk;
				serverPlayer.motionZ += (double)(MathHelper.cos(f + 15) * walkingSpeedPush);
			}
			else
			{
				serverPlayer.motionX -= (double)(MathHelper.sin(f) * walkingSpeedPush * -1);
				serverPlayer.motionY += add_Y_Walk;
				serverPlayer.motionZ += (double)(MathHelper.cos(f) * walkingSpeedPush * -1);
			}
		}
		else if(message.right == true)
		{
			serverPlayer.motionX -= (double)(MathHelper.sin(f - 55) * walkingSpeedPush);
			serverPlayer.motionY += add_Y_Walk;
			serverPlayer.motionZ += (double)(MathHelper.cos(f - 55) * walkingSpeedPush);
		}
		else if(message.left == true)
		{
			serverPlayer.motionX -= (double)(MathHelper.sin(f + 55) * walkingSpeedPush);
			serverPlayer.motionY += add_Y_Walk;
			serverPlayer.motionZ += (double)(MathHelper.cos(f + 55) * walkingSpeedPush);
		}
		
	//==============
	//Jump Sprinting
	//==============
		if(message.sprint == true)
		{
			if (message.forward == true)
			{
				if(message.left == true)
				{
					serverPlayer.motionX -= (double)(MathHelper.sin(f + 15) * sprintingSpeedPush * -1);
					serverPlayer.motionY += add_Y_Sprint;
					serverPlayer.motionZ += (double)(MathHelper.cos(f + 15) * sprintingSpeedPush * -1);
				}
				else if (message.right == true)
				{
					serverPlayer.motionX -= (double)(MathHelper.sin(f - 15) * sprintingSpeedPush * -1);
					serverPlayer.motionY += add_Y_Sprint;
					serverPlayer.motionZ += (double)(MathHelper.cos(f - 15) * sprintingSpeedPush * -1);
				}
				else
				{
					serverPlayer.motionX -= (double)(MathHelper.sin(f) * sprintingSpeedPush);
					serverPlayer.motionY += add_Y_Sprint;
					serverPlayer.motionZ += (double)(MathHelper.cos(f) * sprintingSpeedPush);
				}
			}
			else if(message.back == true)
			{
				if(message.left == true)
				{
					serverPlayer.motionX -= (double)(MathHelper.sin(f - 15) * sprintingSpeedPush);
					serverPlayer.motionY += add_Y_Sprint;
					serverPlayer.motionZ += (double)(MathHelper.cos(f - 15) * sprintingSpeedPush);
				}
				else if (message.left == true)
				{
					serverPlayer.motionX -= (double)(MathHelper.sin(f + 15) * sprintingSpeedPush);
					serverPlayer.motionY += add_Y_Sprint;
					serverPlayer.motionZ += (double)(MathHelper.cos(f + 15) * sprintingSpeedPush);
				}
				else
				{
					serverPlayer.motionX -= (double)(MathHelper.sin(f) * sprintingSpeedPush * -1);
					serverPlayer.motionY += add_Y_Sprint;
					serverPlayer.motionZ += (double)(MathHelper.cos(f) * sprintingSpeedPush * -1);
				}
			}
			else if(message.right == true)
			{
				serverPlayer.motionX -= (double)(MathHelper.sin(f - 55) * sprintingSpeedPush);
				serverPlayer.motionY += add_Y_Sprint;
				serverPlayer.motionZ += (double)(MathHelper.cos(f - 55) * sprintingSpeedPush);
			}
			else if(message.left == true)
			{
				serverPlayer.motionX -= (double)(MathHelper.sin(f + 55) * sprintingSpeedPush);
				serverPlayer.motionY += add_Y_Sprint;
				serverPlayer.motionZ += (double)(MathHelper.cos(f + 55) * sprintingSpeedPush);
			}
		}
		return null;
	}
}






	public class KeyInputsHandler implements IMessageHandler<MessageClientKeyPress, IMessage>
	{
		@Override public IMessage onMessage(MessageClientKeyPress message, MessageContext ctx)
		{
			
		// This is the player the packet was sent to the server from
		    EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;
		    
		// The value that was sent
		    int forward = message.forward;
		    int right = message.right;
		    int left = message.left;
		    int back = message.back;
		    int sprint = message.sprint;
		    
		// Execute the action on the main server thread by adding it as a scheduled task
		    serverPlayer.getServerWorld().addScheduledTask(() -> {
		    	
		    	float f = serverPlayer.rotationYaw * 0.017453292F;//The Yaw Direction
		    	
		    //===========
			//Jump Normal
			//===========
		    	
		    	
		    	//==============
				//Jump Sprinting
				//==============
					if(org.lwjgl.input.Keyboard.isKeyDown(sprint))
					{
						if (org.lwjgl.input.Keyboard.isKeyDown(forward))
						{
							if(org.lwjgl.input.Keyboard.isKeyDown(left))
							{
								serverPlayer.motionX -= (double)(MathHelper.sin(f + 15) * sprintingSpeedPush * -1);
								serverPlayer.motionY += add_Y_Sprint;
								serverPlayer.motionZ += (double)(MathHelper.cos(f + 15) * sprintingSpeedPush * -1);
							}
							else if (org.lwjgl.input.Keyboard.isKeyDown(right))
							{
								serverPlayer.motionX -= (double)(MathHelper.sin(f - 15) * sprintingSpeedPush * -1);
								serverPlayer.motionY += add_Y_Sprint;
								serverPlayer.motionZ += (double)(MathHelper.cos(f - 15) * sprintingSpeedPush * -1);
							}
							else
							{
								serverPlayer.motionX -= (double)(MathHelper.sin(f) * sprintingSpeedPush);
								serverPlayer.motionY += add_Y_Sprint;
								serverPlayer.motionZ += (double)(MathHelper.cos(f) * sprintingSpeedPush);
							}
						}
						else if(org.lwjgl.input.Keyboard.isKeyDown(back))
						{
							if(org.lwjgl.input.Keyboard.isKeyDown(left))
							{
								serverPlayer.motionX -= (double)(MathHelper.sin(f - 15) * sprintingSpeedPush);
								serverPlayer.motionY += add_Y_Sprint;
								serverPlayer.motionZ += (double)(MathHelper.cos(f - 15) * sprintingSpeedPush);
							}
							else if (org.lwjgl.input.Keyboard.isKeyDown(right))
							{
								serverPlayer.motionX -= (double)(MathHelper.sin(f + 15) * sprintingSpeedPush);
								serverPlayer.motionY += add_Y_Sprint;
								serverPlayer.motionZ += (double)(MathHelper.cos(f + 15) * sprintingSpeedPush);
							}
							else
							{
								serverPlayer.motionX -= (double)(MathHelper.sin(f) * sprintingSpeedPush * -1);
								serverPlayer.motionY += add_Y_Sprint;
								serverPlayer.motionZ += (double)(MathHelper.cos(f) * sprintingSpeedPush * -1);
							}
						}
						else if(org.lwjgl.input.Keyboard.isKeyDown(right))
						{
							serverPlayer.motionX -= (double)(MathHelper.sin(f - 55) * sprintingSpeedPush);
							serverPlayer.motionY += add_Y_Sprint;
							serverPlayer.motionZ += (double)(MathHelper.cos(f - 55) * sprintingSpeedPush);
						}
						else if(org.lwjgl.input.Keyboard.isKeyDown(left))
						{
							serverPlayer.motionX -= (double)(MathHelper.sin(f + 55) * sprintingSpeedPush);
							serverPlayer.motionY += add_Y_Sprint;
							serverPlayer.motionZ += (double)(MathHelper.cos(f + 55) * sprintingSpeedPush);
						}
					}
					
					serverPlayer.velocityChanged = true;
		    });
		    
		// No response packet
		    return null;
		  }
	}*/

