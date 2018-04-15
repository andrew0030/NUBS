package andrews.ubs.items;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTripleBladedScythe extends ItemSword
{
	public ItemTripleBladedScythe(ToolMaterial material, String name)
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(UltimateBlockStormMod.instance.tooltab);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setMaxStackSize(1);
	}
}
