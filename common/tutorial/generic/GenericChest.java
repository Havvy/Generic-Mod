package tutorial.generic;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.World;

public class GenericChest extends BlockContainer {
	
	protected GenericTileEntity tile;

	public GenericChest(int id, int texture) {
		super(id, texture, Material.sand);
		setBlockName("genericContainer");
		setHardness(1.0F);
	}

	public String getTextureFile() {
	    return CommonProxy.BLOCK_PNG;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new GenericTileEntity();
	}
	
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (world.isRemote) {
            return true;
        }
        
        GenericTileEntity tile = (GenericTileEntity) world.getBlockTileEntity(x, y, z);
            
        if (tile == null || player.isSneaking()) {
                return false;
        }

        System.out.println("Opening Crystalizer GUI!");
        player.openGui(Generic.instance, 0, world, x, y, z);

        return true;
    }
}
