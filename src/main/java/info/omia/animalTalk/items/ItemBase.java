package info.omia.animalTalk.items;

import info.omia.animalTalk.animalTalk;
import info.omia.animalTalk.init.ItemInit;
import info.omia.animalTalk.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        animalTalk.proxy.registerItemRenderer(this,0,"inventory");
    }
}
