package andrews.ubs.objects.items;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemRamen extends ItemFood implements IHasModel
{
	public ItemRamen(String name)
	{
		super(20, 10, false);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.foodtab);
		this.maxStackSize = 1;
		
		ItemInit.ITEMS.add(this);
	}
    
//Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using the Item before the action is complete.
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entity)
    {
        super.onItemUseFinish(stack, worldIn, entity);
        
        if(!worldIn.isRemote)
        {
        	EntityItem item = new EntityItem(worldIn, entity.posX, entity.posY, entity.posZ, new ItemStack(ItemInit.CHOPSTICKS));
        	item.setPickupDelay(0);
        	worldIn.spawnEntity(item); //To Spawn the Item
        }
		
        return new ItemStack(ItemInit.BIG_BOWL);
    }
    
    @Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
