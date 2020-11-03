package re.vcokltf.glowsquid.renderer;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import re.vcokltf.glowsquid.entity.GlowSquidEntity;
import re.vcokltf.glowsquid.model.GlowSquidEntityModel;

public class GlowSquidEntityRenderer extends MobEntityRenderer<GlowSquidEntity, GlowSquidEntityModel> {

    public GlowSquidEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new GlowSquidEntityModel(), 0.7f);
    }
    @Override
    public Identifier getTexture(GlowSquidEntity entity) {
        return new Identifier("glowsquid", "textures/entity/glowsquid/glow_squid.png");
    }
    protected void setupTransforms(GlowSquidEntity squidEntity, MatrixStack matrixStack, float f, float g, float h) {
        float i = MathHelper.lerp(h, squidEntity.prevTiltAngle, squidEntity.tiltAngle);
        float j = MathHelper.lerp(h, squidEntity.prevRollAngle, squidEntity.rollAngle);
        matrixStack.translate(0.0D, 0.5D, 0.0D);
        matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180.0F - g));
        matrixStack.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(i));
        matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(j));
        matrixStack.translate(0.0D, -1.2000000476837158D, 0.0D);
    }

    protected float getAnimationProgress(GlowSquidEntity squidEntity, float f) {
        return MathHelper.lerp(f, squidEntity.prevTentacleAngle, squidEntity.tentacleAngle);
    }

}