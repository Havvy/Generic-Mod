public class TextureChangingBlock extends Block implements ITickHandler {
    // Wherever your texture starts in the texture file.
    @SideOnly(Side.CLIENT)
    private final int TEXTUREBASE = 32;

    // Number of textures to use.
    @SideOnly(Side.CLIENT)
    private final int TEXTURECOUNT = 4;

    // This value plus your TEXTUREBASE will determine which texture to show.
    private static int texture = 0;

    public TextureChangingBlock (int id) {
        /* The rest of your constuctor */

        FMLCommonHandler.instance().registerTickHandler(this, Side.CLIENT);
    }

    // Block Methods
    @Override
    getBlockTextureFromSideAndMetadata (int metadata, int side) {
        // Not actually using metadata or side...
        return TEXTUREBASE + texture;
    }

    // TickHandler Methods
    @Override
    @SideOnly(Side.CLIENT)
    public void tickStart (EnumSet<TickType> type, Object... tickData) {
        texture = (texture + 1) % TEXTURECOUNT;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void tickEnd (EnumSet<TickType> type, Object... tickData) {

    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumSet<TickType> ticks () {
        return EnumSet.of(TickType.CLIENT);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getLabel () {
        return null;
    }
}