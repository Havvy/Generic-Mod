package tutorial.generic;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	public static final String ITEMS_PNG = "/tutorial/generic/items.png";
	public static final String BLOCK_PNG = "/tutorial/generic/block.png";
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
	
	//Client stuff
	public static void registerRenderInformation() {
		//Nothing here as this is the server side proxy
	}
}