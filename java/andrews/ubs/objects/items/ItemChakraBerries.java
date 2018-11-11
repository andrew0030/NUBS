package andrews.ubs.objects.items;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.capabilities.ninja.NinjaProvider;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import andrews.ubs.util.interfaces.INinja;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemChakraBerries extends ItemFood implements IHasModel
{
	public ItemChakraBerries(String name) 
	{
		super(1, 2, false);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.foodtab);
		this.setAlwaysEdible();
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving)
	{
		if(!world.isRemote && entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entityLiving;
			INinja ninjaCap = player.getCapability(NinjaProvider.NINJA_CAP, null);
			
			ninjaCap.fillChakra(5);
			ninjaCap.syncToAll();
		}
		return super.onItemUseFinish(stack, world, entityLiving);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
