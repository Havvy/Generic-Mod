package tutorial.generic;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	public static String ITEMS_PNG = "/mods/generic/res/items.png";
	public static String BLOCK_PNG = "/mods/generic/res/block.png";
	
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