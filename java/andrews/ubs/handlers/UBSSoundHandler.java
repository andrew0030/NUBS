package andrews.ubs.handlers;

import andrews.ubs.Reference;
import andrews.ubs.util.logger.UBSLogger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class UBSSoundHandler
{	
	private static int size = 0;
	
	public static SoundEvent sb_thrown;
	public static SoundEvent backpack;
	public static SoundEvent jump;
	public static SoundEvent fall_trap;
	
	public static void registerSounds()
	{
		size = SoundEvent.REGISTRY.getKeys().size();
		
		sb_thrown = registerSound("sb_thrown");
		backpack = registerSound("backpack");
		jump = registerSound("jump");
		fall_trap = registerSound("fall_trap");
	}
	
	public static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		UBSLogger.getLogger().info("Registered Sound: " + name);
		return event;
	}
}