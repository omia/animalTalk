package info.omia.animalTalk.init;

import info.omia.animalTalk.Entity.*;
import info.omia.animalTalk.animalTalk;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import info.omia.animalTalk.util.reference;

public class EntityInit {

    public static void registerEntities(){
        registerEntity("Monkey",Monkey.class,reference.Monkey,50,11437146,000000);
    }

    private static void registerEntity(String Name, Class<? extends Entity> Entity,int Id, int range, int color1,int color2){
        EntityRegistry.registerModEntity(new ResourceLocation(reference.MODID+":"+Name),Entity,Name,Id, animalTalk.instance,range,1,true,color1,color2);
    }
}
