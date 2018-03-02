package andrews.ubs.items;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.entity.EntityShuriken;
import andrews.ubs.entity.EntitySmokeBomb;
import andrews.ubs.handler.UltimateBlockStormSoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemShuriken extends Item 
{
	public ItemShuriken(String name) 
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.tooltab);
		this.maxStackSize = 16;
	}
	
	/**
     * Called when the equipped item is right clicked.
     */
	 public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	 {
		 if (!playerIn.capabilities.isCreativeMode)
		 {
			 --itemStackIn.stackSize;
	     }
	        
	     if (!worldIn.isRemote)
	     {
	    	 EntityShuriken entity = new EntityShuriken(worldIn, playerIn);
	         entity.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
	         worldIn.spawnEntityInWorld(entity);
	     }

	     playerIn.addStat(StatList.getObjectUseStats(this));
	     return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	 }	 
}