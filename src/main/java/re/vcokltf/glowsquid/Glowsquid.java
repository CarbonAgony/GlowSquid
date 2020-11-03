package re.vcokltf.glowsquid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import re.vcokltf.glowsquid.block.GlowingGlass;
import re.vcokltf.glowsquid.entity.GlowSquidEntity;
import re.vcokltf.glowsquid.init.Spawns;

public class Glowsquid implements ModInitializer {
    //public static final GlowingGlass GLOWING_GLASS = new GlowingGlass(FabricBlockSettings.copy(Blocks.GLASS));
    public static final GlowingGlass GLOWING_GLASS = new GlowingGlass();
    public static final EntityType<GlowSquidEntity> GLOW_SQUID = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("glowsquid", "glow_squid"),
            FabricEntityTypeBuilder.<GlowSquidEntity>create(SpawnGroup.CREATURE, GlowSquidEntity::new).dimensions(EntityDimensions.fixed(.75f, 0.75f)).build());

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("glowsquid", "glowing_glass"), GLOWING_GLASS);
        Registry.register(Registry.ITEM, new Identifier("glowsquid", "glowing_glass"), new BlockItem(GLOWING_GLASS, new Item.Settings().group(ItemGroup.MISC)));
        FabricDefaultAttributeRegistry.register(GLOW_SQUID, GlowSquidEntity.createMobAttributes());
//        BiomeKeys.DEEP_OCEAN.getEntitySpawnList(EntityCategory.MONSTER).add(new Biome.SpawnEntry(COOKIE_CREEPER, 100, 4, 4));
        //BiomeKeys.DEEP_OCEAN.
        Spawns.init();



    }
}
