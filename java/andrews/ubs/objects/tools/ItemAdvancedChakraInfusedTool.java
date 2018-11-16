package andrews.ubs.objects.tools;

import com.google.common.collect.Sets;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;

public class ItemAdvancedChakraInfusedTool extends ItemTool implements IHasModel
{
	public ItemAdvancedChakraInfusedTool(String name, Item.ToolMaterial material)
    {
        super(0.0F, -2.4F, material, Sets.newHashSet(BlockInit.BLOCKS));
        this.setUnlocalizedName(name);
        this.setHarvestLevel("pickaxe", material.getHarvestLevel());
        this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.tooltab);
		
		ItemInit.ITEMS.add(this);
    }
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}