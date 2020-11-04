package re.vcokltf.glowsquid.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import re.vcokltf.glowsquid.Glowsquid;
import re.vcokltf.glowsquid.entity.GlowSquidEntity;

public class EntityInit {
    public static final EntityType<GlowSquidEntity> GLOW_SQUID = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("glowsquid", "glow_squid"),
            FabricEntityTypeBuilder.<GlowSquidEntity>create(SpawnGroup.CREATURE, GlowSquidEntity::new).dimensions(EntityDimensions.fixed(.75f, 0.75f)).build());

    public static void init() {
        FabricDefaultAttributeRegistry.register(GLOW_SQUID, GlowSquidEntity.createMobAttributes());
    }
}
