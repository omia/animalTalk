package info.omia.animalTalk.init;

import info.omia.animalTalk.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block block_banana = new BlockBase("block_banana", Material.WOOD);

    public static final Block salt_sand = new BlockOres("ore_salt_sand");
    public static final Block salt_dirt = new BlockOres("ore_salt_dirt");
    public static final Block salt_gravel = new BlockOres("ore_salt_gravel");
    public static final Block salt_netherrack = new BlockOres("ore_salt_netherrack");
    public static final Block salt_endstone = new BlockOres("ore_salt_endstone");



}
