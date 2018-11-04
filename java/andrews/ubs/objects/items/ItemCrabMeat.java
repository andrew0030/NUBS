package andrews.ubs.objects.items;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemCrabMeat extends ItemFood implements IHasModel
{
	public ItemCrabMeat(String name)
	{
		super(3, 4, false);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.foodtab);
		
		ItemInit.ITEMS.add(this);
	}
    
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	{
		if (!worldIn.isRemote)
		{
		//Effect1
			player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 800));
		}
	}
	
    @Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
