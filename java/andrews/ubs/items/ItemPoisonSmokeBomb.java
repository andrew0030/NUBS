package andrews.ubs.items;

import java.util.List;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.entity.EntityPoisonSmokeBomb;
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

public class ItemPoisonSmokeBomb extends Item {
	
	public ItemPoisonSmokeBomb(String name) {
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
	            EntityPoisonSmokeBomb entity = new EntityPoisonSmokeBomb(worldIn, playerIn);
	            entity.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
	            worldIn.spawnEntityInWorld(entity);
	        }

	        playerIn.addStat(StatList.getObjectUseStats(this));
	        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	    }
	 
	 public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
	 {
		 par2List.add("\u00A78" + "BLINDNESS" + "\u00A77" + ": 1");
		 par2List.add("\u00A79" + "SLOWNESS" + "\u00A77" + ": 2");
		 par2List.add("\u00A7a" + "POISON" + "\u00A77" + ": 2");
	 }
	}