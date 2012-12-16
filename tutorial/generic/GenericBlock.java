package tutorial.generic;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class GenericBlock extends Block {

	public GenericBlock (int id, int texture, Material material) {
		super(id, texture, material);
	}
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

}
