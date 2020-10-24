package re.vcokltf.glowsquid;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import re.vcokltf.glowsquid.block.GlowingGlass;

public class Glowsquid implements ModInitializer {
    //public static final GlowingGlass GLOWING_GLASS = new GlowingGlass(FabricBlockSettings.copy(Blocks.GLASS));
    public static final GlowingGlass GLOWING_GLASS = new GlowingGlass();

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "glowing_glass"), GLOWING_GLASS);
        Registry.register(Registry.ITEM, new Identifier("glowsquid", "glowing_glass"), new BlockItem(GLOWING_GLASS, new Item.Settings().group(ItemGroup.MISC)));

    }
}
