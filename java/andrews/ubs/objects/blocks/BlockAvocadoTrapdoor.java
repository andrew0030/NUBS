package andrews.ubs.objects.blocks;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class BlockAvocadoTrapdoor extends BlockTrapDoor implements IHasModel
{
	public BlockAvocadoTrapdoor(String name)
	{
		super(Material.WOOD);
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Reference.MODID, name));
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(Main.instance.blocktab);
        
        BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}