package info.omia.animalTalk.world.gen;

import info.omia.animalTalk.init.BlockInit;
import info.omia.animalTalk.init.BlockOres;
import info.omia.animalTalk.util.handlers.Enum_Ore.Enum_Ore_salt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenCustomOre implements IWorldGenerator {

    private WorldGenerator salt_sand, salt_dirt, salt_gravel,salt_netherrack,salt_endstone;


    public WorldGenCustomOre()
    {
        salt_sand = new WorldGenMinable(BlockInit.salt.getDefaultState().withProperty(BlockOres.VARIANT, Enum_Ore_salt.EnumType.saltsand), 15, BlockMatcher.forBlock(Blocks.SAND));
        salt_dirt = new WorldGenMinable(BlockInit.salt.getDefaultState().withProperty(BlockOres.VARIANT, Enum_Ore_salt.EnumType.saltdirt), 15, BlockMatcher.forBlock(Blocks.DIRT));
        salt_gravel = new WorldGenMinable(BlockInit.salt.getDefaultState().withProperty(BlockOres.VARIANT, Enum_Ore_salt.EnumType.saltgravel), 15, BlockMatcher.forBlock(Blocks.GRAVEL));
        salt_netherrack = new WorldGenMinable(BlockInit.salt.getDefaultState().withProperty(BlockOres.VARIANT, Enum_Ore_salt.EnumType.saltnetherrack), 15, BlockMatcher.forBlock(Blocks.NETHERRACK));
        salt_endstone = new WorldGenMinable(BlockInit.salt.getDefaultState().withProperty(BlockOres.VARIANT, Enum_Ore_salt.EnumType.saltendstone), 15, BlockMatcher.forBlock(Blocks.END_STONE));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.getDimension())
        {
            case -1:

                genunderblock(salt_netherrack, world, random, chunkX, chunkZ, 20, 0, 100,3,Material.LAVA);

                break;

            case 0:

               genunderblock(salt_sand, world, random, chunkX, chunkZ, 20, 0, 256,5,Material.WATER);
               genunderblock(salt_dirt, world, random, chunkX, chunkZ, 20, 0, 256,5,Material.WATER);
               genunderblock(salt_gravel, world, random, chunkX, chunkZ, 20, 0, 256,5,Material.WATER);

                break;

            case 1:

                runGenerator(salt_endstone, world, random, chunkX, chunkZ, 20, 0, 256);
        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
    {
        if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");

        int heightDiff = maxHeight - minHeight + 1;
        for(int i = 0; i < chance; i++)
        {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            gen.generate(world, rand, new BlockPos(x,y,z));
        }
    }

    private void genunderblock(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight,int under ,Material material){
        if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");

        int heightDiff = maxHeight - minHeight + 1;
        for(int i = 0; i < chance; i++)
        {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            int u = 0;

            for (; u<under; u++){
                if (world.getBlockState(new BlockPos(x,y+u,z)).getMaterial() != material ){
                    break;
                }
            }
            if (u==under){gen.generate(world, rand, new BlockPos(x,y,z));
            }

        }
    }
}