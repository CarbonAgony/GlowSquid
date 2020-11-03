package re.vcokltf.glowsquid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import re.vcokltf.glowsquid.block.GlowingGlass;
import re.vcokltf.glowsquid.block.UnderwaterTorch;
import re.vcokltf.glowsquid.block.UnderwaterTorchWall;
import re.vcokltf.glowsquid.entity.GlowSquidEntity;
import re.vcokltf.glowsquid.init.Spawns;
import re.vcokltf.glowsquid.item.GlowingInkSac;

public class Glowsquid implements ModInitializer {
    //public static final Block UNDERWATER_TORCH_WALL;
    //public static final Block UNDERWATER_TORCH;

    public static UnderwaterTorchWall UNDERWATER_TORCH_WALL = new UnderwaterTorchWall(FabricBlockSettings.of(Material.REPAIR_STATION));
    public static UnderwaterTorch UNDERWATER_TORCH = new UnderwaterTorch();



    //public static final GlowingGlass GLOWING_GLASS = new GlowingGlass(FabricBlockSettings.copy(Blocks.GLASS));
    public static final GlowingGlass GLOWING_GLASS = new GlowingGlass();
    public static final GlowingInkSac GLOWING_INK_SAC = new GlowingInkSac(new FabricItemSettings().group(ItemGroup.MISC));
    //public static final UnderwaterTorch UNDERWATER_TORCH = new UnderwaterTorch(Block.Settings.of(Material.REPAIR_STATION));
    //public static final UnderwaterTorch UNDERWATER_TORCH = new UnderwaterTorch(FabricBlockSettings.of(Material.REPAIR_STATION));

    public static final EntityType<GlowSquidEntity> GLOW_SQUID = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("glowsquid", "glow_squid"),
            FabricEntityTypeBuilder.<GlowSquidEntity>create(SpawnGroup.CREATURE, GlowSquidEntity::new).dimensions(EntityDimensions.fixed(.75f, 0.75f)).build());

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "underwater_torch"), UNDERWATER_TORCH);
        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "underwater_torch_wall"), UNDERWATER_TORCH_WALL);
        Registry.register(Registry.ITEM, new Identifier("glowsquid", "underwater_torch"), new WallStandingBlockItem(UNDERWATER_TORCH, UNDERWATER_TORCH_WALL, new Item.Settings().group(ItemGroup.DECORATIONS)));










        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "glowing_glass"), GLOWING_GLASS);
        Registry.register(Registry.ITEM, new Identifier("glowsquid", "glowing_glass"), new BlockItem(GLOWING_GLASS, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("glowsquid", "glowing_ink_sac"), GLOWING_INK_SAC);
        //Registry.register(Registry.BLOCK, new Identifier("glowsquid", "underwater_torch"), UNDERWATER_TORCH);
        //Registry.register(Registry.ITEM, new Identifier("glowsquid", "underwater_torch"), new BlockItem(UNDERWATER_TORCH, new Item.Settings().group(ItemGroup.MISC)));




        FabricDefaultAttributeRegistry.register(GLOW_SQUID, GlowSquidEntity.createMobAttributes());
//        BiomeKeys.DEEP_OCEAN.getEntitySpawnList(EntityCategory.MONSTER).add(new Biome.SpawnEntry(COOKIE_CREEPER, 100, 4, 4));
        //BiomeKeys.DEEP_OCEAN.
        Spawns.init();



    }
}
