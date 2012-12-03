package tutorial.generic;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockOre;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class GenericOre extends BlockOre {
    public GenericOre (int id, int texture) {
        super(id, texture);

        setHardness(4.0F); // 33% harder than diamond
        setStepSound(Block.soundStoneFootstep);
        setBlockName("genericOre");
        setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public String getTextureFile () {
        return CommonProxy.BLOCK_PNG;
    }

    @Override
    public int idDropped (int par1, Random random, int par2) {
        return Generic.genericIngot.shiftedIndex;
    }
}
