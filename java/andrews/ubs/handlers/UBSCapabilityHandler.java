package andrews.ubs.handlers;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaFactory;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.capabilities.ninja.NinjaStorage;
import andrews.ubs.capabilities.stats.StatsFactory;
import andrews.ubs.capabilities.stats.StatsProvider;
import andrews.ubs.capabilities.stats.StatsStorage;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
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
	public static final ResourceLocation STATS_CAP = new ResourceLocation(Reference.MODID, "Stats");
	
	public static void register()
	{
        CapabilityManager.INSTANCE.register(INinja.class, new NinjaStorage(), new NinjaFactory());
        CapabilityManager.INSTANCE.register(IStats.class, new StatsStorage(), new StatsFactory());
	}
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	{
		if (!(event.getObject() instanceof EntityPlayer))
        return;

		event.addCapability(NINJA_CAP, new NinjaProvider((EntityLivingBase) event.getObject()));
		event.addCapability(STATS_CAP, new StatsProvider((EntityLivingBase) event.getObject()));
	}	
	
	@SubscribeEvent
    public void onStartTracking(PlayerEvent.StartTracking event)
	{
        if (event.getTarget() instanceof EntityLivingBase)
        {
            INinja ninjaCapability = event.getTarget().getCapability(NinjaProvider.NINJA_CAP, null);
            IStats statsCapability = event.getTarget().getCapability(StatsProvider.STATS_CAP, null);
            
            if (ninjaCapability != null)
            {
            	ninjaCapability.syncToPlayer((EntityPlayerMP) event.getEntityPlayer());
            }
            if (statsCapability != null)
            {
            	statsCapability.syncToPlayer((EntityPlayerMP) event.getEntityPlayer());
            }
        }
	}
	
	@SubscribeEvent
    public void onPlayerLoggedIn(PlayerLoggedInEvent event)
	{
        INinja ninjaCapability = event.player.getCapability(NinjaProvider.NINJA_CAP, null);
        IStats statsCapability = event.player.getCapability(StatsProvider.STATS_CAP, null);
        
        if(ninjaCapability != null)
        {
            ninjaCapability.syncToPlayer((EntityPlayerMP) event.player);
        }
        
        if(statsCapability != null)
        {
            statsCapability.syncToPlayer((EntityPlayerMP) event.player);
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
            
            //Ninja Capability
            INinja ninjaCapOld = event.getOriginal().getCapability(NinjaProvider.NINJA_CAP, null);
            INinja ninjaCapNew = player.getCapability(NinjaProvider.NINJA_CAP, null);
            IStorage<INinja> storageNinja = NinjaProvider.NINJA_CAP.getStorage();
            nbt = storageNinja.writeNBT(NinjaProvider.NINJA_CAP, ninjaCapOld, null);
            storageNinja.readNBT(NinjaProvider.NINJA_CAP, ninjaCapNew, null, nbt);
            //Stats Capability
            IStats statsCapOld = event.getOriginal().getCapability(StatsProvider.STATS_CAP, null);
            IStats statsCapNew = player.getCapability(StatsProvider.STATS_CAP, null);
            IStorage<IStats> storageStats = StatsProvider.STATS_CAP.getStorage();
            nbt = storageStats.writeNBT(StatsProvider.STATS_CAP, statsCapOld, null);
            storageStats.readNBT(StatsProvider.STATS_CAP, statsCapNew, null, nbt);
        }
	}
   
    @SubscribeEvent
    public void onRespawn(PlayerRespawnEvent event)
    {
    // Called after onPlayerClone. Used to sync after death.
        if (!event.isEndConquered())
        {
            INinja ninjaCap = event.player.getCapability(NinjaProvider.NINJA_CAP, null);
            IStats statsCap = event.player.getCapability(StatsProvider.STATS_CAP, null);
            ninjaCap.syncToAll();
            statsCap.syncToAll();
        }
    }
}
