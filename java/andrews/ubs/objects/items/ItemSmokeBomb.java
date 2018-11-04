package andrews.ubs.objects.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
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

public class ItemSmokeBomb extends Item implements IHasModel 
{
	public ItemSmokeBomb(String name) 
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.tooltab);
		this.maxStackSize = 16;
		
		ItemInit.ITEMS.add(this);
	}
	
	/**
	* Called when the equipped item is right clicked.

	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if (!playerIn.capabilities.isCreativeMode)
		{
			itemStackIn.shrink(1);
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
	*/
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			tooltip.add("\u00A78" + "BLINDNESS" + "\u00A77" + ": 1");
			tooltip.add("\u00A79" + "SLOWNESS" + "\u00A77" + ": 2");
		}
		else
		{
			tooltip.add("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for More Information");
		}
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}