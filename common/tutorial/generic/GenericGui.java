package tutorial.generic;

import havvy.minecraft.experience.CrystalizerContainer;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;

public class GenericGui extends GuiContainer {

	public GenericGui(InventoryPlayer inventory, GenericTileEntity tileEntity) {
		super(new GenericContainer(inventory, tileEntity));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer() {
	    //draw text and stuff here
	    //the parameters for drawString are: string, x, y, color
	    fontRenderer.drawString("Crystalizer", 8, 6, 4210752);
	    //draws "Inventory" or your regional equivalent
	    fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	    
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
	    //draw your Gui here, only thing you need to change is the path
	    int texture = mc.renderEngine.getTexture("/havvy/minecraft/experience/crystalizer.png");
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    mc.renderEngine.bindTexture(texture);
	    int screen_x = (width - xSize) / 2;
	    int screen_y = (height - ySize) / 2;
	    drawTexturedModalRect(screen_x, screen_y, 0, 0, xSize, ySize);
	}

}
