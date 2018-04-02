package info.omia.animalTalk.init;

import info.omia.animalTalk.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block block_banana = new BlockBase("block_banana", Material.WOOD);

    public static final Block salt = new BlockOres("ore_salt");




}
