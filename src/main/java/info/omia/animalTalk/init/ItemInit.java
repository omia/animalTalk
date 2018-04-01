package info.omia.animalTalk.init;

import info.omia.animalTalk.items.ItemBase;
import net.minecraft.item.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Animal
        //Monkey
        public static final Item monkey_tail = new ItemBase("tail_monkey");

    //Fruits
    public static final Item fruit_Banana = new ItemBase("fruit_Banana");

}
