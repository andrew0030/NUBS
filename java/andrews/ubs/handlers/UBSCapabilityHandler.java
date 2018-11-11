package andrews.ubs.handlers;

import java.util.concurrent.Callable;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaCap;
import andrews.ubs.capabilities.ninja.NinjaFactory;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.capabilities.ninja.NinjaStorage;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStamina;
import andrews.ubs.util.logger.UBSLogger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

//=========================================================
//Capability handler									  #
//														  #
//This class is responsible for attaching our capabilities#
//=========================================================

public class UBSCapabilityHandler
{
	public static final ResourceLocation NINJA_CAP = new ResourceLocation(Reference.MODID, "Ninja");
	
	public static void register()
	{
        CapabilityManager.INSTANCE.register(INinja.class, new NinjaStorage(), new NinjaFactory());
	}
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	{
		if (!(event.getObject() instanceof EntityPlayer))
        return;

		event.addCapability(NINJA_CAP, new NinjaProvider((EntityLivingBase) event.getObject()));
	}	
	
	@SubscribeEvent
    public void onStartTracking(PlayerEvent.StartTracking event)
	{
        if (event.getTarget() instanceof EntityLivingBase)
        {
            INinja ninjaCapability = event.getTarget().getCapability(NinjaProvider.NINJA_CAP, null);
            
            if (ninjaCapability != null)
            {
            	ninjaCapability.syncToPlayer((EntityPlayerMP) event.getEntityPlayer());
            }
        }
	}
	
	@SubscribeEvent
    public void onPlayerLoggedIn(PlayerLoggedInEvent event)
	{
        INinja ninjaCapability = event.player.getCapability(NinjaProvider.NINJA_CAP, null);
        
        if(ninjaCapability != null)
        {
            ninjaCapability.syncToPlayer((EntityPlayerMP) event.player);
        }
	}
	
//Copy data from dead player to the new player
	@SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event)
	{
        World world = event.getEntityPlayer().getEntityWorld();
        EntityPlayer player = event.getEntityPlayer();
        
        if (event.isWasDeath())
        {
            NBTBase nbt = null;
            
            INinja ninjaCapOld = event.getOriginal().getCapability(NinjaProvider.NINJA_CAP, null);
            INinja ninjaCapNew = player.getCapability(NinjaProvider.NINJA_CAP, null);
            IStorage<INinja> storageNinja = NinjaProvider.NINJA_CAP.getStorage();
            nbt = storageNinja.writeNBT(NinjaProvider.NINJA_CAP, ninjaCapOld, null);
            storageNinja.readNBT(NinjaProvider.NINJA_CAP, ninjaCapNew, null, nbt);
        }
	}
   
    @SubscribeEvent
    public void onRespawn(PlayerRespawnEvent event)
    {
    // Called after onPlayerClone. Used to sync after death.
        if (!event.isEndConquered())
        {
            INinja ninjaCap = event.player.getCapability(NinjaProvider.NINJA_CAP, null);
            ninjaCap.syncToAll();
        }
    }
}
