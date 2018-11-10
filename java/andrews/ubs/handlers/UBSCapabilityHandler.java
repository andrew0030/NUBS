package andrews.ubs.handlers;

import java.util.concurrent.Callable;

import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaCap;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.capabilities.ninja.NinjaStorage;
import andrews.ubs.util.interfaces.INinja;
import andrews.ubs.util.interfaces.IStamina;
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
        CapabilityManager.INSTANCE.register(INinja.class, new NinjaStorage(), new Callable<INinja>()
        {
            @Override
            public INinja call() throws Exception 
            {
                return new NinjaCap();
            }
        });
	}
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	{
		if (!(event.getObject() instanceof EntityPlayer))
        return;

		event.addCapability(NINJA_CAP, new NinjaProvider());
	}	
	
	@SubscribeEvent
    public static void onStartTracking(PlayerEvent.StartTracking event)
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
    public static void onPlayerLoggedIn(PlayerLoggedInEvent event)
	{
        INinja ninjaCapability = event.player.getCapability(NinjaProvider.NINJA_CAP, null);
        
        if(ninjaCapability != null)
        {
            ninjaCapability.syncToAll((EntityPlayerMP) event.player);
        }
	}
	
//	@SubscribeEvent
//    public static void onPlayerClone(PlayerEvent.Clone event) 
//	{
//        World world = event.getEntityPlayer().getEntityWorld();
//        
//        if (event.isWasDeath())
//        {
//            NBTBase nbt = null;
//            INinja ninjaCap = event.getEntityPlayer().getCapability(NinjaProvider.NINJA_CAP, null)
//            IStorage<INinja> storageWardrobe = PlayerWardrobeCap.PLAYER_WARDROBE_CAP.getStorage();
//            nbt = storageWardrobe.writeNBT(PlayerWardrobeCap.PLAYER_WARDROBE_CAP, wardrobeCapOld, null);
//            storageWardrobe.readNBT(PlayerWardrobeCap.PLAYER_WARDROBE_CAP, wardrobeCapNew, null, nbt);
//            
//            IEntitySkinCapability skinCapOld = EntitySkinCapability.get(event.getOriginal());
//            IEntitySkinCapability skinCapNew = EntitySkinCapability.get(event.getEntityPlayer());
//            IStorage<IEntitySkinCapability> storageEntitySkin = EntitySkinCapability.ENTITY_SKIN_CAP.getStorage();
//            nbt = storageEntitySkin.writeNBT(EntitySkinCapability.ENTITY_SKIN_CAP, skinCapOld, null);
//            storageEntitySkin.readNBT(EntitySkinCapability.ENTITY_SKIN_CAP, skinCapNew, null, nbt);
//        }
//    }
//    
//    @SubscribeEvent
//    public static void onRespawn(PlayerRespawnEvent event) {
//        // Called after onPlayerClone. Used to sync after death.
//        if (!event.isEndConquered()) {
//            IPlayerWardrobeCap wardrobeCap = PlayerWardrobeCap.get(event.player);
//            wardrobeCap.syncToAllTracking();
//            wardrobeCap.syncToPlayer((EntityPlayerMP) event.player);
//            
//            IEntitySkinCapability skinCap = EntitySkinCapability.get(event.player);
//            skinCap.syncToAllTracking();
//            skinCap.syncToPlayer((EntityPlayerMP) event.player);
//        }
//}
}
