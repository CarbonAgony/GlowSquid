package re.vcokltf.glowsquid.model;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SquidEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import re.vcokltf.glowsquid.entity.GlowSquidEntity;

public class GlowSquidEntityModel extends SquidEntityModel<GlowSquidEntity> {
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.getParts().forEach((modelPart) -> {
            modelPart.render(matrices, vertices, 6029544, overlay, red, green, blue, alpha);
        });
    }
}