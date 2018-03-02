package andrews.ubs.items;

import com.google.common.collect.Sets;

import andrews.ubs.Reference;
import andrews.ubs.UltimateBlockStormMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;

public class ItemChakraInfusedTool extends ItemTool 
{
	public ItemChakraInfusedTool(Item.ToolMaterial material, String name)
    {
        super(0.0F, -2.8F, material, Sets.newHashSet(Block.REGISTRY));
        this.setUnlocalizedName(name);
//        setHarvestLevel("pickaxe", material.getHarvestLevel());
        this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(UltimateBlockStormMod.instance.tooltab);
    }
}
