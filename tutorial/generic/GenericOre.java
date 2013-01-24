package tutorial.generic;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

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
        return Generic.genericIngot.itemID;
    }
}
