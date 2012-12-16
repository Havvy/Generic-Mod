package tutorial.generic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	public static String ITEMS_PNG = "/tutorial/generic/items.png";
	public static String BLOCK_PNG = "/tutorial/generic/block.png";
	
	// Client stuff
	public void registerRenderers () {
		// Nothing here as this is the server side proxy
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
        // TileEntity tile = world.getBlockTileEntity(x, y, z);
        
        /*
        if (!(tile instanceof CrystalizerTileEntity)) {
        	return null;
        }
        
        return new CrystalizerContainer(player.inventory, (CrystalizerTileEntity) tile);
        */
        
        return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
	    /*
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        
        if (!(tileEntity instanceof GenericTileEntity)) {
        	return null;
        }
        
        return new GenericGui(player.inventory, (GenericTileEntity) tileEntity);
        */
	    
	    return null;
	}
}