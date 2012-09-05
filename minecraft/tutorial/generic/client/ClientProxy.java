package tutorial.generic.client;

import net.minecraftforge.client.MinecraftForgeClient;
import tutorial.generic.CommonProxy;

public class ClientProxy extends CommonProxy {
	public static void registerRenderers() {
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(BLOCK_PNG);
	}
}