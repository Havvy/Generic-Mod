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
    	int x = chunkX * 16;
    	int z = chunkZ * 16;
    	
        compass(random, x, z, world, chunkGenerator, chunkProvider);
        ore(random, x, z, world, chunkGenerator, chunkProvider);
    }

    private void compass (Random random, int x, int z, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        world.setBlock(x+8, 72, z+15, Block.obsidian.blockID);
        world.setBlock(x+7, 72, z, Block.cobblestoneMossy.blockID);
        world.setBlock(x, 72, z+7, Block.blockLapis.blockID);
        world.setBlock(x+15, 72, z+8, Block.blockGold.blockID);
    }
    
    private void ore (Random random, int x, int z, World world,
    		IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
    	// TODO
    }

}
