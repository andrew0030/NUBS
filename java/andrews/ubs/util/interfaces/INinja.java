package andrews.ubs.util.interfaces;

import net.minecraft.entity.player.EntityPlayerMP;

public interface INinja extends IChakra, IStamina
{
    public void syncToAll();
    
    public void syncToPlayer(EntityPlayerMP entityPlayer);
}
