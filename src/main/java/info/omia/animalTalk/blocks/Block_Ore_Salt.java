package info.omia.animalTalk.blocks;

import info.omia.animalTalk.animalTalk;
import info.omia.animalTalk.blocks.item.ItemBlockVariants;
import info.omia.animalTalk.init.BlockInit;
import info.omia.animalTalk.init.ItemInit;
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

import java.util.Random;


public class Block_Ore_Salt extends Block implements IHasModel, IMetaName {

    public static final PropertyEnum<Enum_Ore_salt.EnumType> VARIANT = PropertyEnum.<Enum_Ore_salt.EnumType>create("variant", Enum_Ore_salt.EnumType.class);

    private String name;

    public Block_Ore_Salt(String name)
    {
        super(Material.SAND);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Enum_Ore_salt.EnumType.saltsand));
        this.name = name;

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        switch (this.getMetaFromState(blockState)){
            case 0: return 0.5f;
            case 1: return 0.5f;
            case 2: return 0.6f;
            case 3: return 0.4f;
            case 4: return 3.0f;

        }
        return 5f;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        switch (this.getMetaFromState(state)){
            case 0: return ItemInit.dust_salt_sand;
            case 1: return ItemInit.dust_salt_dirt;
            case 2: return ItemInit.dust_salt_gravel;
            case 3: return ItemInit.dust_salt_netherrack;
            case 4: return ItemInit.dust_salt_endstone;

        }
        return ItemInit.dust_salt_sand;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return 3+(fortune*2);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((Enum_Ore_salt.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Enum_Ore_salt.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    @Deprecated
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
    public void registerModels()
    {
        for(int i = 0; i < Enum_Ore_salt.EnumType.values().length; i++)
        {
            animalTalk.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "ore_" + Enum_Ore_salt.EnumType.values()[i].getName(), "inventory");
        }
    }
}