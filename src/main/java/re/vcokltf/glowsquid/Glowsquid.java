package re.vcokltf.glowsquid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import re.vcokltf.glowsquid.block.GlowingGlass;
import re.vcokltf.glowsquid.block.UnderwaterTorch;
import re.vcokltf.glowsquid.block.UnderwaterTorchWall;
import re.vcokltf.glowsquid.entity.GlowSquidEntity;
import re.vcokltf.glowsquid.init.*;
import re.vcokltf.glowsquid.item.GlowingInkSac;
import re.vcokltf.glowsquid.mixin.BrewingRecipeRegistryAccessor;

public class Glowsquid implements ModInitializer {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("glowsquid", "group"),
            () -> new ItemStack(ItemInit.GLOWING_INK_SAC)
    );


    @Override
    public void onInitialize() {
        MegaInit.init();
    }
}
