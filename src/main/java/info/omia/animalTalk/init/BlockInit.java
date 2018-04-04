package info.omia.animalTalk.init;

import info.omia.animalTalk.blocks.BlockBase;
import info.omia.animalTalk.blocks.Block_Ore_Salt;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block block_banana = new BlockBase("block_banana", Material.WOOD);

    public static final Block salt = new Block_Ore_Salt("ore_salt");




}
