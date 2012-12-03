package tutorial.generic;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class GenericContainer extends Container {

    protected GenericTileEntity tile;
       
    public GenericContainer (InventoryPlayer inventoryPlayer, GenericTileEntity tile){
        this.tile = tile;

        //commonly used vanilla code that adds the player's inventory
        bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }


    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int ix = 0; ix < 3; ix++) {
            for (int jx = 0; jx < 9; jx++) {
                addSlotToContainer(new Slot(inventoryPlayer, jx + ix * 9 + 9,
                    8 + jx * 18, 84 + ix * 18));
            }
        }

        for (int ix = 0; ix < 9; ix++) {
            addSlotToContainer(new Slot(inventoryPlayer, ix, 8 + ix * 18, 142));
        }
    }
    
    // @Override FIXME
    public ItemStack transferStackInSlot (int slot) {
            ItemStack stack = null;
            Slot slotObject = (Slot) inventorySlots.get(slot);

            //null checks and checks if the item can be stacked (maxStackSize > 1)
            if (slotObject != null && slotObject.getHasStack()) {
                    ItemStack stackInSlot = slotObject.getStack();
                    stack = stackInSlot.copy();

                    //merges the item into player inventory since its in the tileEntity
                    if (slot == 0) {
                            if (!mergeItemStack(stackInSlot, 1,
                                            inventorySlots.size(), true)) {
                                    return null;
                            }
                    //places it into the tileEntity is possible since its in the player inventory
                    } else if (!mergeItemStack(stackInSlot, 0, 1, false)) {
                            return null;
                    }

                    if (stackInSlot.stackSize == 0) {
                            slotObject.putStack(null);
                    } else {
                            slotObject.onSlotChanged();
                    }
            }

            return stack;
    }
}