package andrews.ubs.handlers;

import java.util.Random;

import andrews.ubs.Main;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.capabilities.stats.StatsProvider;
import andrews.ubs.controlls.KeyBinds;
import andrews.ubs.gui.menu.GuiStats;
import andrews.ubs.network.PacketHandler;
import andrews.ubs.network.message.client.MessageKeyBoardUpdate;
import andrews.ubs.network.message.server.MessageChakraParticles;
import andrews.ubs.network.message.server.MessageJumpParticles;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStats;
import andrews.ubs.util.logger.UBSLogger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class UBSEventHandler
{
	private static boolean collecting_chakra;

    float walkingSpeedPush = 0.2F;
    float sprintingSpeedPush = 0.6F;

    float add_Y_Walk = 0.2F;
    float add_Y_Sprint = 0.8F;

    @SubscribeEvent
    public void onLivingJumpEvent(LivingJumpEvent event)
    {
        if (event.getEntity() != null && event.getEntity() instanceof EntityPlayer)
        {

            EntityPlayer player = (EntityPlayer)event.getEntity();
            Random rand = new Random();
            INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
            
            float f = player.rotationYaw * 0.017453292F;//The Yaw Direction
            
            if(player.isSprinting() == true)
            {
            	if(player.getActivePotionEffect(MobEffects.SLOWNESS) == null) //Used so if Player has Effect Slowness player wont be able to Jump
            	{
	            	if(ninjaCap.getChakra() >= 3 && ninjaCap.getStamina() >= 5)
	            	{
	            		if(!player.world.isRemote)
	            		{
	            			player.world.playSound(null, player.posX, player.posY, player.posZ, UBSSoundHandler.jump, SoundCategory.PLAYERS, 1.0F, 1.0F);
	            			PacketHandler.INSTANCE.sendToAllTracking(new MessageJumpParticles(player.getEntityId()), player);
	        				PacketHandler.INSTANCE.sendTo(new MessageJumpParticles(player.getEntityId()), (EntityPlayerMP) player);
	            		}
	            			
		            	if(!player.isCreative())
		            	{
		            		ninjaCap.consumeStamina(5);
		            		ninjaCap.consumeChakra(3);
		            		ninjaCap.syncToAll();
		            	}
		            	
		                if(player.moveForward == 1)
		                {
		                    if(player.moveStrafing == 1)
		                    {
		                        player.motionX -= (double)(MathHelper.sin(f + 15) * sprintingSpeedPush * -1);
		                        player.motionY += add_Y_Sprint;
		                        player.motionZ += (double)(MathHelper.cos(f + 15) * sprintingSpeedPush * -1);
		                    }
		                    else if (player.moveStrafing == -1)
		                    {
		                        player.motionX -= (double)(MathHelper.sin(f - 15) * sprintingSpeedPush * -1);
		                        player.motionY += add_Y_Sprint;
		                        player.motionZ += (double)(MathHelper.cos(f - 15) * sprintingSpeedPush * -1);
		                    }
		                    else
		                    {
		                        player.motionX -= (double)(MathHelper.sin(f) * sprintingSpeedPush);
		                        player.motionY += add_Y_Sprint;
		                        player.motionZ += (double)(MathHelper.cos(f) * sprintingSpeedPush);
		                    }
		                }
		            }
            	}
            }
            else if(player.isSprinting() == false)
            {
            	if(player.getActivePotionEffect(MobEffects.SLOWNESS) == null) //Used so if Player has Effect Slowness player wont be able to Jump
            	{
	            	if(ninjaCap.getStamina() >= 2)
	            	{
	            		if(!player.isCreative())
		            	{
		            		ninjaCap.consumeStamina(2);
		            		ninjaCap.syncToAll();
		            	}
	            		
		                if(player.moveForward == 1)
		                {
		                    if(player.moveStrafing == 1)
		                    {
		                        player.motionX -= (double)(MathHelper.sin(f + 15) * walkingSpeedPush * -1);
		                        player.motionY += add_Y_Walk;
		                        player.motionZ += (double)(MathHelper.cos(f + 15) * walkingSpeedPush * -1);
		                    }
		                    else if (player.moveStrafing == -1)
		                    {
		                        player.motionX -= (double)(MathHelper.sin(f - 15) * walkingSpeedPush * -1);
		                        player.motionY += add_Y_Walk;
		                        player.motionZ += (double)(MathHelper.cos(f - 15) * walkingSpeedPush * -1);
		                    }
		                    else
		                    {
		                        player.motionX -= (double)(MathHelper.sin(f) * walkingSpeedPush);
		                        player.motionY += add_Y_Walk;
		                        player.motionZ += (double)(MathHelper.cos(f) * walkingSpeedPush);
		                    }
		                }
		                else if(player.moveForward == -1)
		                {
		                    if(player.moveStrafing == 1)
		                    {
		                        player.motionX -= (double)(MathHelper.sin(f - 15) * walkingSpeedPush);
		                        player.motionY += add_Y_Walk;
		                        player.motionZ += (double)(MathHelper.cos(f - 15) * walkingSpeedPush);
		                    }
		                    else if (player.moveStrafing == -1)
		                    {
		                        player.motionX -= (double)(MathHelper.sin(f + 15) * walkingSpeedPush);
		                        player.motionY += add_Y_Walk;
		                        player.motionZ += (double)(MathHelper.cos(f + 15) * walkingSpeedPush);
		                    }
		                    else
		                    {
		                        player.motionX -= (double)(MathHelper.sin(f) * walkingSpeedPush * -1);
		                        player.motionY += add_Y_Walk;
		                        player.motionZ += (double)(MathHelper.cos(f) * walkingSpeedPush * -1);
		                    }
		                }
		                else if(player.moveStrafing == -1)
		                {
		                    player.motionX -= (double)(MathHelper.sin(f - 55) * walkingSpeedPush);
		                    player.motionY += add_Y_Walk;
		                    player.motionZ += (double)(MathHelper.cos(f - 55) * walkingSpeedPush);
		                }
		                else if(player.moveStrafing == 1)
		                {
		                    player.motionX -= (double)(MathHelper.sin(f + 55) * walkingSpeedPush);
		                    player.motionY += add_Y_Walk;
		                    player.motionZ += (double)(MathHelper.cos(f + 55) * walkingSpeedPush);
		                }
		                else if(player.moveForward == 0 && player.moveStrafing == 0)
		                {
		                    player.motionY += add_Y_Walk;
		                }
		            }
            	}
            }
        }
    }

    //==================
    //Remove Fall Damage
    //==================
    @SubscribeEvent
    public void livingFall(LivingFallEvent event)
    {	
        if (event.getEntityLiving() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)event.getEntityLiving();

            INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);

            if(event.getDistance() <= 18)
            {
                event.setDistance(0);
            }
            else if(event.getDistance() > 18)
            {
                if (player.world.isRemote || !(player instanceof EntityPlayer)) return;

                float points = ninjaCap.getChakra();

                float cost = event.getDistance();

                if (points > cost)
                {
                    ninjaCap.consumeChakra(cost);

                    event.setDistance(0);
                    ninjaCap.syncToAll();

                    String message = String.format("Dodged death Bitch. It costed �7%d�r chakra, you have �7%d�r chakra left.", (int) cost, (int) ninjaCap.getChakra());
                    player.sendMessage(new TextComponentString(message));

                    if(Main.DEVELOPER_MODE)
                    {
                    	UBSLogger.getLogger().info("[EventHandler] chakra after falling" + ninjaCap.getChakra());
                    }
                }
            }
        }
    }

    //=============
    //Walk on Water
    //=============
    @SubscribeEvent
    public void WaterWalking(LivingUpdateEvent event)
    {
        if (event.getEntity() != null && event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)event.getEntity();
            World world = player.world;
            BlockPos playerPos = new BlockPos(player.posX, player.posY + 0.0D, player.posZ);
            INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
            
            if(ninjaCap.getChakra() > 10)
            {
	            //If player is on top of water it allows him to stand on the water and also jump / do all things you can do on solid blocks
	            if (world.getBlockState(playerPos).getBlock() == Blocks.WATER)
	            {
	                player.motionY = 0;
	                player.onGround = true;
	                
	                if((player.getEntityWorld().getTotalWorldTime() % 20) == 0)
	    			{
	                	if(!player.isCreative())
	                	{
	                		ninjaCap.consumeChakra(10);
	                		ninjaCap.syncToAll();
	                	}
	    			}
	
	                //Checks if player is under water, and if thats the case it pushes him up
	                if(player.isInWater())
	                {
	                    player.motionY = 0.2;
	                }
	            }
            }
        }
    }

    //===========
    //Sleep Regen
    //===========
    @SubscribeEvent
    public void onPlayerWakeUp(PlayerWakeUpEvent event)
    {
        EntityPlayer player = event.getEntityPlayer();

        if (player.world.isRemote) return;

        INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);

        ninjaCap.fillStamina(1000);
        ninjaCap.fillChakra(1000);
        ninjaCap.syncToAll();
        
        String message = String.format("You refreshed yourself in the bed. You restored your chakra, you have �7%d�r chakra left.", (int) ninjaCap.getChakra());

        player.sendMessage(new TextComponentString(message));

        if(Main.DEVELOPER_MODE) //Developer Mode
        {
        	UBSLogger.getLogger().info("[EventHandler] chakra wake up event: " + ninjaCap.getChakra());
        	UBSLogger.getLogger().info("[EventHandler] stamina wake up event: " + ninjaCap.getStamina());
        }
    }
    
    //====================================================================
    //Used to Refill the Stamina and Chakra if the Player is Creative Mode 
    //====================================================================
    @SubscribeEvent
    public void CreativeRefill(LivingUpdateEvent event)
    {
        if (event.getEntity() != null && event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)event.getEntity();
            
            INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
            
            if(player.isCreative())
            {
            	if((ninjaCap.getChakra() < ninjaCap.getMaxChakra()) && (ninjaCap.getStamina() < ninjaCap.getMaxStamina()))
            	{
	                ninjaCap.fillChakra(ninjaCap.getMaxChakra());
	            	ninjaCap.fillStamina(ninjaCap.getMaxStamina());
	            	ninjaCap.syncToAll();
            	}
            }
        }
    }
    
    //=================
    //Key Input Manager
    //=================
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyTyped(InputEvent.KeyInputEvent event)
    {
    //Chakra 
    	if(KeyBinds.KEY_CHAKRA.isKeyDown())
    	{
    		if(!collecting_chakra)
    		{
    			PacketHandler.INSTANCE.sendToServer(new MessageKeyBoardUpdate(true));
    			collecting_chakra = true;
    			
    			if(Main.DEVELOPER_MODE)
    			{
    				UBSLogger.getLogger().info("[EventHandler] sent CollectingChakra value: " + collecting_chakra);
    			}
    		}
    	}
    	else if(collecting_chakra)
    	{
    		PacketHandler.INSTANCE.sendToServer(new MessageKeyBoardUpdate(false));
			collecting_chakra = false;
			
			if(Main.DEVELOPER_MODE)
			{
				UBSLogger.getLogger().info("[EventHandler] sent CollectingChakra value: " + collecting_chakra);
			}
    	}
    	
    //Mod menu
    	if(KeyBinds.KEY_MENU.isPressed())
    	{
    		Minecraft.getMinecraft().displayGuiScreen(new GuiStats());
    	}
    }
    
    
  	//=================================
    //Chakra Collecting and Max Setting
    //=================================
    @SubscribeEvent
    public void chakraCollectionEvent(LivingUpdateEvent event)
    {
    	if(event.getEntity() != null && event.getEntity() instanceof EntityPlayer )
	    {
    		EntityPlayer player = (EntityPlayer) event.getEntity();
    		
    		INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
    		IStats statsCap = player.getCapability(StatsProvider.STATS_CAP, null);
    		
    		if(ninjaCap.getCollectingChakra())
    		{	
    			if((player.getEntityWorld().getTotalWorldTime() % 10) == 0)
    			{	
    				PacketHandler.INSTANCE.sendToAllTracking(new MessageChakraParticles(player.getEntityId()), player);
    				PacketHandler.INSTANCE.sendTo(new MessageChakraParticles(player.getEntityId()), (EntityPlayerMP) player);
	    			ninjaCap.fillChakra(statsCap.getMeditation() * 10);
	    			ninjaCap.syncToAll();
	    		}
    		}
    		
    		if(statsCap.getReserve() * 20 != ninjaCap.getMaxChakra())
    		{
    			ninjaCap.setMaxChakra(statsCap.getReserve() * 20);
    			ninjaCap.syncToAll();
    		}
	    }
    }
}