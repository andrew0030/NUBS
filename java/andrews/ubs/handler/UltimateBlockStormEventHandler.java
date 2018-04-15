package andrews.ubs.handler;

import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.capabilities.chakra.Chakra;
import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.capabilities.stamina.Stamina;
import andrews.ubs.capabilities.stamina.StaminaProvider;
import andrews.ubs.items.ItemKubikiribocho;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.IStamina;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class UltimateBlockStormEventHandler
{

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
            
            IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);
            IStamina stamina = player.getCapability(StaminaProvider.STAMINA_CAP, null);
            
            float f = player.rotationYaw * 0.017453292F;//The Yaw Direction
            
            if(player.isSprinting() == true)
            {
            	if(player.getActivePotionEffect(MobEffects.SLOWNESS) == null) //Used so if Player has Effect Slowness player wont be able to Jump
            	{
	            	if(chakra.getChakra() >= 3 && stamina.getStamina() >= 5)
	            	{
	            		player.worldObj.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, UltimateBlockStormSoundHandler.jump, SoundCategory.PLAYERS, 1.0F, 1.0F);
	            		
		            	if(!player.isCreative())
		            	{
		            		stamina.consume(5);
		            		Stamina.syncWithClient(player, stamina.getStamina(), stamina.getMaxStamina());
		            		chakra.consume(3);
		            		Chakra.syncWithClient(player, chakra.getChakra(), chakra.getMaxChakra());
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
	            	if(stamina.getStamina() >= 2)
	            	{
	            		if(!player.isCreative())
		            	{
		            		stamina.consume(2);
		            		Stamina.syncWithClient(player, stamina.getStamina(), stamina.getMaxStamina());
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

            IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);

            if(event.getDistance() <= 18)
            {
                event.setDistance(0);
            }
            else if(event.getDistance() > 18)
            {
                if (player.worldObj.isRemote || !(player instanceof EntityPlayer)) return;

                float points = chakra.getChakra();

                float cost = event.getDistance();

                if (points > cost)
                {
                    chakra.consume(cost);

                    event.setDistance(0);
                    Chakra.syncWithClient(player, chakra.getChakra(), chakra.getMaxChakra());

                    String message = String.format("Dodged death Bitch. It costed §7%d§r chakra, you have §7%d§r chakra left.", (int) cost, (int) chakra.getChakra());
                    player.addChatMessage(new TextComponentString(message));

                    if(UltimateBlockStormMod.DEVELOPER_MODE)
                    {
                    	UtilsLogger.getLogger().info("[EventHandler] chakra after falling" + chakra.getChakra());
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

            World world = player.worldObj;

            BlockPos playerPos = new BlockPos(player);

            //If player is on top of water it allows him to stand on the water and also jump / do all things you can do on solid blocks
            if (world.getBlockState(playerPos).getBlock() == Blocks.WATER)
            {
                player.motionY = 0;
                player.onGround = true;

                //Checks if player is under water, and if thats the case it pushes him up
                if(player.isInWater())
                {
                    player.motionY = 0.2;
                }
            }
        }
    }

    //=============
    //Login Message
    //=============
    @SubscribeEvent
    public void playerLogged(PlayerLoggedInEvent event)
    {
        EntityPlayer player = event.player;

        IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);
        IStamina stamina = player.getCapability(StaminaProvider.STAMINA_CAP, null);

        String message1 = String.format("Hello there, you have §7%d§r chakra and §7%d§r stamina left.", (int) chakra.getChakra(), (int) stamina.getStamina());
        String message2 = String.format("Hello there, you have §7%d§r maxChakra and §7%d§r maxStamina left.", (int) chakra.getMaxChakra(), (int) stamina.getMaxStamina());

        player.addChatMessage(new TextComponentString(message1));
        player.addChatMessage(new TextComponentString(message2));
    }

    //===========
    //Sleep Regen
    //===========
    @SubscribeEvent
    public void onPlayerWakeUp(PlayerWakeUpEvent event)
    {
        EntityPlayer player = event.getEntityPlayer();

        if (player.worldObj.isRemote) return;

        IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);
        IStamina stamina = player.getCapability(StaminaProvider.STAMINA_CAP, null);

        stamina.fill(100);
        Stamina.syncWithClient(player, stamina.getStamina(), stamina.getMaxStamina());
        chakra.fill(100);
        Chakra.syncWithClient(player, chakra.getChakra(), chakra.getMaxChakra());
        
        String message = String.format("You refreshed yourself in the bed. You restored your chakra, you have §7%d§r chakra left.", (int) chakra.getChakra());

        player.addChatMessage(new TextComponentString(message));

        if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
        {
        	UtilsLogger.getLogger().info("[EventHandler] chakra wake up event: " + chakra.getChakra());
        	UtilsLogger.getLogger().info("[EventHandler] stamina wake up event: " + stamina.getStamina());
        }
    }

    //============================================
    //Copy data from dead player to the new player
    //============================================
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event)
    {
        EntityPlayer player = event.getEntityPlayer();

        IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);
        IStamina stamina = player.getCapability(StaminaProvider.STAMINA_CAP, null);
        
        IChakra oldChakra = event.getOriginal().getCapability(ChakraProvider.CHAKRA_CAP, null);
        IStamina oldStamina = event.getOriginal().getCapability(StaminaProvider.STAMINA_CAP, null);

        chakra.setMaxChakra(oldChakra.getMaxChakra());
        chakra.set(oldChakra.getChakra());
        stamina.setMaxStamina(oldStamina.getMaxStamina());
        stamina.set(oldStamina.getStamina());

        if(UltimateBlockStormMod.DEVELOPER_MODE) //Developer Mode
        {
	        UtilsLogger.getLogger().info("[EventHandler] chakra is: " + chakra.getChakra() + " old chakra is: " + oldChakra.getChakra());
	        UtilsLogger.getLogger().info("[EventHandler] stamina is: " + stamina.getStamina() + " old stamina is: " + oldStamina.getStamina());
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
            
            IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);
            IStamina stamina = player.getCapability(StaminaProvider.STAMINA_CAP, null);
            
            if(player.isCreative())
            {
            	
            //Chakra
	            if(chakra.getChakra() < 20)
				{
	                chakra.fill(1000);
	                Chakra.syncWithClient(player, chakra.getChakra(), chakra.getMaxChakra());
				}
	        //Stamina
	            if(stamina.getStamina() < 20)
	            {
	            	stamina.fill(1000);
	            	Stamina.syncWithClient(player, stamina.getStamina(), stamina.getMaxStamina());
	            }
            }
        }
    }
}