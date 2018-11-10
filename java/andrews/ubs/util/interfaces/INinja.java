package andrews.ubs.util.interfaces;

import net.minecraft.entity.player.EntityPlayerMP;

public interface INinja extends IChakra, IStamina
{
	/**
     * Syncs capability data to a player.
     * 
     * @param entityPlayer Player to sync to.
     */
    public void syncToPlayer(EntityPlayerMP entityPlayer);
    
    /**
     * Syncs capability data to all players tracking the entity.
     */
    public void syncToAllTracking();
}
