package tutorial.generic;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class GenericItem extends Item {

	public GenericItem(int id) {
		super(id);
		
		// Constructor Configuration
        maxStackSize = 64;
        setTabToDisplayOn(CreativeTabs.tabMisc);
        setIconIndex(0);
        setItemName("genericItem");
	}
	
	public String getTextureFile() {
	    return CommonProxy.ITEMS_PNG;
	}
}
