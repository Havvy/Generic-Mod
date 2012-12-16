package tutorial.generic;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;

public class BasicWorldGen implements IWorldGenerator {

    @Override
    public void generate (Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        compass(random, chunkX * 16, chunkZ * 16, world, chunkGenerator, chunkProvider);
    }

    private void compass (Random random, int x, int z, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        world.setBlock(x, 72, z, Block.obsidian.blockID);
    }
    

}
