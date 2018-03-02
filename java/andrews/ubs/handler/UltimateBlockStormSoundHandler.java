package andrews.ubs.handler;

import andrews.ubs.Reference;
import andrews.ubs.utils.UtilsLogger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class UltimateBlockStormSoundHandler {
	
	private static int size = 0;
	
	public static SoundEvent sb_thrown;
	public static SoundEvent backpack;
	public static SoundEvent jump;
	
	public static void init() {
		size = SoundEvent.REGISTRY.getKeys().size();
		
		sb_thrown = register("sb_thrown");
		backpack = register("backpack");
		jump = register("jump");
	}
	
	public static SoundEvent register(String name) {
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent e = new SoundEvent(location);
		
		SoundEvent.REGISTRY.register(size, location, e);
		size++;
		UtilsLogger.getLogger().info("Registered Sound: " + name);
		return e;
	}

}
