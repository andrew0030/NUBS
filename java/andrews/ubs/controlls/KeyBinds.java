package andrews.ubs.controlls;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBinds
{
	public static final KeyBinding KEY_CHAKRA = new KeyBinding("key.chakra", Keyboard.KEY_C, "key.categories.ubs");
	public static final KeyBinding KEY_MENU = new KeyBinding("key.menu", Keyboard.KEY_M, "key.categories.ubs");
			
	public static void register()
	{
		ClientRegistry.registerKeyBinding(KEY_CHAKRA);
		ClientRegistry.registerKeyBinding(KEY_MENU);
	}
}
