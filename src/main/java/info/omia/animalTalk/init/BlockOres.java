package info.omia.animalTalk.init;

import info.omia.animalTalk.animalTalk;
import info.omia.animalTalk.blocks.item.ItemBlockVariants;
import info.omia.animalTalk.util.handlers.Enum_Ore.Enum_Ore_salt;
import info.omia.animalTalk.util.interfaces.IHasModel;
import info.omia.animalTalk.util.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class BlockOres extends Block implements IHasModel, IMetaName {

    public static final PropertyEnum<Enum_Ore_salt.EnumType> VARIANT = PropertyEnum.<Enum_Ore_salt.EnumType>create("variant",Enum_Ore_salt.EnumType.class);
    private String name;

    public BlockOres(String name) {
        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Enum_Ore_salt.EnumType.saltdirt));

        this.name=name;

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return  ((Enum_Ore_salt.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return  ((Enum_Ore_salt.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return  this.getDefaultState().withProperty(VARIANT,Enum_Ore_salt.EnumType.byMetadata(meta));
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for(Enum_Ore_salt.EnumType variant : Enum_Ore_salt.EnumType.values())
        {
            items.add(new ItemStack(this, 1, variant.getMeta()));
        }
    }
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    @Override
    public String getSpecialName(ItemStack stack)
    {
        return Enum_Ore_salt.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void registerModels() {
        for (int i = 0; i<Enum_Ore_salt.EnumType.values().length; i++){
animalTalk.proxy.registerVariantRenderer(Item.getItemFromBlock(this),i,"ore_"+ Enum_Ore_salt.EnumType.values()[i].getName(),"inventory");
        }

    }
}