package re.vcokltf.glowsquid.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import re.vcokltf.glowsquid.Glowsquid;
import re.vcokltf.glowsquid.renderer.GlowSquidEntityRenderer;

@Environment(EnvType.CLIENT)
public class GlowsquidClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Glowsquid.GLOWING_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(Glowsquid.UNDERWATER_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Glowsquid.UNDERWATER_TORCH_WALL, RenderLayer.getCutout());

        EntityRendererRegistry.INSTANCE.register(Glowsquid.GLOW_SQUID, (dispatcher, context) -> {
            return new GlowSquidEntityRenderer(dispatcher);
        });
    }
}
