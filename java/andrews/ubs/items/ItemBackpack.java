package andrews.ubs.items;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import andrews.ubs.gui.InventoryBackpack;
import andrews.ubs.handler.UltimateBlockStormSoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemBackpack extends Item 
{	
	public ItemBackpack(String name) 
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.itemtab);
		this.setMaxStackSize(1);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		super.onCreated(stack, worldIn, playerIn);
		new InventoryBackpack(stack);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) 
	{
	//Used to play the sound
		worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, UltimateBlockStormSoundHandler.backpack, SoundCategory.MASTER, 1.0F, 1.0F);
		
		if(!worldIn.isRemote)
		{
			playerIn.openGui(UltimateBlockStormMod.instance, Reference.BACKPACK, worldIn, 0, 0, 0);
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
}
