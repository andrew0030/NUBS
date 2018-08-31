package andrews.ubs.objects.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import andrews.ubs.Main;
import andrews.ubs.Reference;
import andrews.ubs.init.BlockInit;
import andrews.ubs.init.ItemInit;
import andrews.ubs.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChakraInfusedGrass extends Block implements IHasModel
{
	public BlockChakraInfusedGrass(String name) 
	{
		super(Material.GRASS);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(Main.instance.blocktab);
		this.setSoundType(SoundType.PLANT);
		this.setHardness(0.6F);
		this.setTickRandomly(true);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
//Spawns the Particles
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        super.randomDisplayTick(stateIn, worldIn, pos, rand);

        if (rand.nextInt(5) == 0)
        {
            worldIn.spawnParticle(EnumParticleTypes.TOWN_AURA, (double)((float)pos.getX() + rand.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + rand.nextFloat()), 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }
	
//Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
//change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
//block, etc.
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
        super.neighborChanged(state, worldIn, pos, blockIn, pos);

        if (worldIn.getBlockState(pos.up()).isFullCube())
        {
            worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState());
        }
    }
    
//Get the Item that this Block should drop when harvested.
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), rand, fortune);
    }
    
//With this we enable it, so plants can generate and can be placed on this block
    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
    {
        IBlockState plant = plantable.getPlant(world, pos.offset(direction));
        net.minecraftforge.common.EnumPlantType plantType = plantable.getPlantType(world, pos.offset(direction));

        if (plant.getBlock() == net.minecraft.init.Blocks.CACTUS)
        {
            return false;
        }

        if (plant.getBlock() == net.minecraft.init.Blocks.REEDS)
        {
            return false;
        }

        if (plantable instanceof BlockBush)
        {
            return true;
        }
        
        if (plantable instanceof BlockMushroom)
        {
            return true;
        }

        return false;
    }
    
//this is used to set the tool type (shovel, pickaxe, axe...)
  	@Override
  	public String getHarvestTool(IBlockState state) 
  	{
  		return "shovel";
  	}
  	
//this is used to set the Tool level(Wood, Stone, Iron...)
  	@Override
  	public int getHarvestLevel(IBlockState state) 
  	{
  		return 0;
  	}
  	
//For the grass spread
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2)
            {
                worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState());
            }
            else
            {
                if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
                {
                    for (int i = 0; i < 4; ++i)
                    {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                        {
                            return;
                        }

                        IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                        if (iblockstate1.getBlock() == Blocks.DIRT && iblockstate1.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && worldIn.getLightFromNeighbors(blockpos.up()) >= 4 && iblockstate.getLightOpacity(worldIn, pos.up()) <= 2)
                        {
                            worldIn.setBlockState(blockpos, BlockInit.CHAKRA_INFUSED_GRASS.getDefaultState());
                        }
                    }
                }
            }
        }
    }
    
//To make the grass become farmland if block is used while holding a Hoe
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	if(!worldIn.isRemote)
	    {
    		ItemStack itemStack = playerIn.getHeldItem(hand);
    		Item item = playerIn.getHeldItem(hand).getItem();
    		
	    	if(itemStack != null)
			{
				if(item instanceof ItemHoe)
				{
					worldIn.setBlockState(pos, Blocks.FARMLAND.getDefaultState(), 2);
					worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_HOE_TILL, SoundCategory.PLAYERS, 1.0F, 1.0F);
					if(!playerIn.isCreative())
					{
						if(itemStack.getItemDamage() <= itemStack.getMaxDamage() - 1)
						{
							itemStack.setItemDamage(itemStack.getItemDamage() + 1 );
						}
						else
						{
							itemStack.shrink(1);
							worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
						}
					}
				}
			}
    	}
    	return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
    
    @Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
    
}

