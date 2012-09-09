package tutorial.generic;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="Generic", name="Generic", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Generic {

	// Begin Basic Items
	public final static Item genericItem = new GenericItem(5000);
	public final static Item genericIngot = new GenericItem(5001)
		.setMaxStackSize(16).setIconIndex(1).setItemName("specificItem");
	// End Basic Items
	
	// Begin Basic Blocks
	public final static Block genericDirt = new GenericBlock(500, 0, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("genericDirt").setCreativeTab(CreativeTabs.tabDeco);
	public final static Block genericOre = new GenericOre(501, 1);
	
	// The instance of your mod that Forge uses.
	@Instance
	public static Generic instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="tutorial.generic.client.ClientProxy",
			serverSide="tutorial.generic.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		// Crafting and Smelting
		ItemStack dirtStack = new ItemStack(Block.dirt);
		ItemStack diamondsStack = new ItemStack(Item.diamond, 64);
		ItemStack blackWoolStack = new ItemStack(Block.cloth, 42, 15);
		ItemStack gravelStack = new ItemStack(Block.gravel);
		ItemStack cobbleStack = new ItemStack(Block.cobblestone);
		
		GameRegistry.addShapelessRecipe(diamondsStack, dirtStack);
		
		GameRegistry.addShapelessRecipe(diamondsStack,
				dirtStack, dirtStack, dirtStack,
				dirtStack, dirtStack, dirtStack,
				new ItemStack(Block.sand), gravelStack, cobbleStack);
		
		GameRegistry.addRecipe(new ItemStack(Block.cobblestone), "xy", "yx", 
		        'x', dirtStack, 'y', gravelStack);
		
		GameRegistry.addRecipe(new ItemStack(Block.stone), "xyx", "y y", "xyx",
		        'x', dirtStack, 'y', gravelStack);
		
		GameRegistry.addSmelting(Block.stone.blockID, 
				new ItemStack(Block.stoneBrick), 0.1f);
		// End Crafting and Smelting
		
		// Basic Items
		LanguageRegistry.addName(genericItem, "Generic Item");
		LanguageRegistry.addName(genericIngot, "Specific Item");
		// End Basic Items
		
		// Basic Blocks
		LanguageRegistry.addName(genericDirt, "Generic Dirt");
		MinecraftForge.setBlockHarvestLevel(genericDirt, "shovel", 0);
		
		LanguageRegistry.addName(genericOre, "Genreric Ore");
		MinecraftForge.setBlockHarvestLevel(genericOre, "pickaxe", 3);
		
		proxy.registerRenderers();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}