package andrews.ubs.objects.items;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.capabilities.stats.StatsProvider;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import andrews.ubs.util.interfaces.IStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemBackpack extends Item implements IHasModel
{	
	public ItemBackpack(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.itemtab);
		this.setMaxStackSize(1);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		if(Main.DEVELOPER_MODE)
		{
			IStats statsCap = playerIn.getCapability(StatsProvider.STATS_CAP, null);
			statsCap.setStrength(1);
			statsCap.setDefense(1);
			statsCap.setReserve(1);
			statsCap.setMeditation(1);
			statsCap.setNinjutsu(1);
			statsCap.setTaijutsu(1);
			statsCap.setGenjutsu(1);
			statsCap.syncToAll();
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		if(Main.DEVELOPER_MODE)
		{
			IStats statsCap = player.getCapability(StatsProvider.STATS_CAP, null);
			statsCap.fillAvPoint(3);
			statsCap.syncToAll();
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}