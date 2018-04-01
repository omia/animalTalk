package info.omia.animalTalk.blocks;

import info.omia.animalTalk.animalTalk;
import info.omia.animalTalk.init.BlockInit;
import info.omia.animalTalk.init.ItemInit;
import info.omia.animalTalk.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material) {
       super(material);
       setUnlocalizedName(name);
       setRegistryName(name);
       setCreativeTab(CreativeTabs.MISC);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        animalTalk.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }
}
