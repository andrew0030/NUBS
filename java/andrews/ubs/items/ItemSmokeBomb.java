package andrews.ubs.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
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

public class ItemSmokeBomb extends Item 
{
	public ItemSmokeBomb(String name) 
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

	     worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, UltimateBlockStormSoundHandler.sb_thrown, SoundCategory.NEUTRAL, 1.0F, 1.0F);
	     playerIn.getCooldownTracker().setCooldown(this, 20);
	        
	     if (!worldIn.isRemote)
	     {
	    	 EntitySmokeBomb entity = new EntitySmokeBomb(worldIn, playerIn);
	         entity.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
	         worldIn.spawnEntityInWorld(entity);
	     }

	     playerIn.addStat(StatList.getObjectUseStats(this));
	     return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}
	 
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advancedToolTip)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			list.add("\u00A78" + "BLINDNESS" + "\u00A77" + ": 1");
			list.add("\u00A79" + "SLOWNESS" + "\u00A77" + ": 2");
	    }
		else
		{
	        list.add("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for More Information");
		}
	}
}