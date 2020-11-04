package re.vcokltf.glowsquid.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import re.vcokltf.glowsquid.Glowsquid;
import re.vcokltf.glowsquid.block.*;

public class BlockInit {

    public static final ItemGroup itemGroup = Glowsquid.ITEM_GROUP;


    public static UnderwaterTorchWall UNDERWATER_TORCH_WALL = new UnderwaterTorchWall(FabricBlockSettings.of(Material.REPAIR_STATION));
    public static UnderwaterTorch UNDERWATER_TORCH = new UnderwaterTorch();
    public static final GlowingGlass GLOWING_GLASS = new GlowingGlass();
//    public static final GlowingWool GLOWING_WOOL = new GlowingGlass();
//    public static final GlowingConcrete GLOWING_CONCRETE = new GlowingGlass();
//    public static final GlowingConcretePowder GLOWING_CONCRETE_POWDER = new GlowingGlass();
//    public static final GlowingTerracotta GLOWING_TERRACOTTA = new GlowingGlass();


    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "underwater_torch"), UNDERWATER_TORCH);
        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "underwater_torch_wall"), UNDERWATER_TORCH_WALL);
        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "glowing_glass"), GLOWING_GLASS);
//        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "glowing_wool"), GLOWING_WOOL);
//        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "glowing_concrete"), GLOWING_CONCRETE);
//        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "glowing_concrete_powder"), GLOWING_CONCRETE_POWDER);
//        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "glowing_terracotta"), GLOWING_TERRACOTTA);
        Registry.register(Registry.ITEM, new Identifier("glowsquid", "underwater_torch"), new WallStandingBlockItem(UNDERWATER_TORCH, UNDERWATER_TORCH_WALL, new Item.Settings().group(Glowsquid.ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("glowsquid", "glowing_glass"), new BlockItem(GLOWING_GLASS, new Item.Settings().group(Glowsquid.ITEM_GROUP)));


    }

}
