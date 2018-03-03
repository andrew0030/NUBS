package andrews.ubs.handler;

import andrews.ubs.capabilities.chakra.Chakra;
import andrews.ubs.capabilities.chakra.ChakraProvider;
import andrews.ubs.network.PacketHandler;
import andrews.ubs.utils.IChakra;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
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
            
            float f = player.rotationYaw * 0.017453292F;//The Yaw Direction
            
            if(player.isSprinting() == true)
            {
                if(player.moveForward == 1)
                {
                    if(player.moveStrafing == 1)
                    {
                        player.motionX -= (double)(MathHelper.sin(f + 15) * sprintingSpeedPush * -1);
                        player.motionY += add_Y_Sprint;
                        player.motionZ += (double)(MathHelper.cos(f + 15) * sprintingSpeedPush * -1);
                        player.playSound(UltimateBlockStormSoundHandler.jump, 1, 1);
                        chakra.consume(5);
                        Chakra.syncWithClient(player, chakra.getChakra());
                    }
                    else if (player.moveStrafing == -1)
                    {
                        player.motionX -= (double)(MathHelper.sin(f - 15) * sprintingSpeedPush * -1);
                        player.motionY += add_Y_Sprint;
                        player.motionZ += (double)(MathHelper.cos(f - 15) * sprintingSpeedPush * -1);
                        player.playSound(UltimateBlockStormSoundHandler.jump, 1, 1);
                        chakra.consume(5);
                        Chakra.syncWithClient(player, chakra.getChakra());
                    }
                    else
                    {
                        player.motionX -= (double)(MathHelper.sin(f) * sprintingSpeedPush);
                        player.motionY += add_Y_Sprint;
                        player.motionZ += (double)(MathHelper.cos(f) * sprintingSpeedPush);
                        player.playSound(UltimateBlockStormSoundHandler.jump, 1, 1);
                        chakra.consume(5);
                        Chakra.syncWithClient(player, chakra.getChakra());
                    }
                }
            }
            else if(player.isSprinting() == false)
            {
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

    //==================
    //Remove Fall Damage
    //==================
    @SubscribeEvent
    public void livingFall(LivingFallEvent event)
    {	
        /**		Entity entity = event.getEntity();

		if (entity.worldObj.isRemote || !(entity instanceof EntityPlayerMP)) return;

		EntityPlayer player = (EntityPlayer) entity;

		IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);

		UtilsLogger.getLogger().info("chakra fall event: " + chakra.getChakra());

		float points = chakra.getChakra();

		float cost = event.getDistance();

		if(event.getDistance() <= 18)
		{
			event.setDistance(0);
		}
		else if(event.getDistance() > 18)
		{
			if (points > cost)
			{
				chakra.consume(cost);

				event.setDistance(0);

				String message = String.format("You absorbed fall damage. It costed §7%d§r chakra, you have §7%d§r chakra left.", (int) cost, (int) chakra.getChakra());

				player.addChatMessage(new TextComponentString(message));
			}
		}*/

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
                    Chakra.syncWithClient((EntityPlayerMP) player, chakra.getChakra());

                    String message = String.format("Dodged death Bitch. It costed §7%d§r chakra, you have §7%d§r chakra left.", (int) cost, (int) chakra.getChakra());
                    player.addChatMessage(new TextComponentString(message));

                    UtilsLogger.getLogger().info(chakra.getChakra());
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

        String message = String.format("Hello there, you have §7%d§r chakra left.", (int) chakra.getChakra());

        player.addChatMessage(new TextComponentString(message));
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

        chakra.fill(100);
        Chakra.syncWithClient(player, chakra.getChakra());
        
        String message = String.format("You refreshed yourself in the bed. You restored your chakra, you have §7%d§r chakra left.", (int) chakra.getChakra());

        player.addChatMessage(new TextComponentString(message));

        UtilsLogger.getLogger().info("chakra wake up event: " + chakra.getChakra());
    }

    /**
	@SubscribeEvent
	public void onPlayerFalls(LivingFallEvent event)
	{
		Entity entity = event.getEntity();

		if (entity.worldObj.isRemote || !(entity instanceof EntityPlayerMP) || event.getDistance() < 3) return;

		EntityPlayer player = (EntityPlayer) entity;

		IMana mana = player.getCapability(ManaProvider.MANA_CAP, null);


		float points = mana.getMana();

		float cost = event.getDistance() * 2;

		if (points > cost)
		{
			mana.consume(cost);

			String message = String.format("You absorbed fall damage. It costed §7%d§r mana, you have §7%d§r mana left.", (int) cost, (int) mana.getMana());

			player.addChatMessage(new TextComponentString(message));


			event.setCanceled(true);
		}
	}
     */

    //============================================
    //Copy data from dead player to the new player
    //============================================
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event)
    {
        EntityPlayer player = event.getEntityPlayer();

        IChakra chakra = player.getCapability(ChakraProvider.CHAKRA_CAP, null);

        IChakra oldChakra = event.getOriginal().getCapability(ChakraProvider.CHAKRA_CAP, null);

        chakra.set(oldChakra.getChakra());

        UtilsLogger.getLogger().info("chakra is: " + chakra.getChakra());
        UtilsLogger.getLogger().info("old chakra is: " + chakra.getChakra());
    }
}