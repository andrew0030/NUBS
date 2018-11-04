package andrews.ubs.objects.tools;

import com.google.common.collect.Sets;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;

public class ItemChakraInfusedTool extends ItemTool implements IHasModel
{
	public ItemChakraInfusedTool(String name, Item.ToolMaterial material)
    {
        super(0.0F, -2.8F, material, Sets.newHashSet(Block.REGISTRY));
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