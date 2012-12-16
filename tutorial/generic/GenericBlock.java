package tutorial.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GenericBlock extends Block {

	public GenericBlock (int id, int texture, Material material) {
		super(id, texture, material);
	}
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

}
