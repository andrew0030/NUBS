package andrews.ubs.items;

import javax.annotation.Nullable;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.init.UltimateBlockStormItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemTomatoSalad extends ItemFood {

	public ItemTomatoSalad(String name) {
		super(12, 9, false);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.foodtab);
		this.maxStackSize = 1;
	}
	
    @Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entity)
    {
        super.onItemUseFinish(stack, worldIn, entity);
        
        EntityItem item = new EntityItem(worldIn, entity.posX, entity.posY, entity.posZ, new ItemStack(UltimateBlockStormItems.chopsticks));
		item.setPickupDelay(0);
		worldIn.spawnEntityInWorld(item); //To Spawn the Item
        
        return new ItemStack(UltimateBlockStormItems.big_bowl);
    }

}
