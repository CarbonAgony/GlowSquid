package re.vcokltf.glowsquid.init;

import javafx.scene.effect.Glow;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import re.vcokltf.glowsquid.Glowsquid;
import re.vcokltf.glowsquid.item.GlowingInkSac;

public class ItemInit {
    public static final GlowingInkSac GLOWING_INK_SAC = new GlowingInkSac(new FabricItemSettings().group(Glowsquid.ITEM_GROUP));


    public static void init() {
        Registry.register(Registry.ITEM, new Identifier("glowsquid", "glowing_ink_sac"), GLOWING_INK_SAC);
        Registry.register(Registry.ITEM, new Identifier("glowsquid", "glowsquid_spawn_egg"), new SpawnEggItem(EntityInit.GLOW_SQUID, 0x007b7e, 0x54fbff, new Item.Settings().group(ItemGroup.MISC)));
    }

}
