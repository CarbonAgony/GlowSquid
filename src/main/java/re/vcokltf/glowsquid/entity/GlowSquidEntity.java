package re.vcokltf.glowsquid.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Random;

public class GlowSquidEntity extends SquidEntity {

    public GlowSquidEntity(EntityType<? extends SquidEntity> entityType, World world) {
        super(entityType, world);
    }
    public static boolean canGlowquidSpawn(EntityType<GlowSquidEntity> entity, WorldAccess world, SpawnReason reason, BlockPos pos, Random rand) {
        return pos.getY() > 45 && pos.getY() < world.getSeaLevel();
    }
    @Override
    public boolean canSpawn(WorldView worldreader) {
        return worldreader.intersectsEntities(this, VoxelShapes.cuboid(this.getBoundingBox()));
    }
    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new SwimAroundGoal(this, 1, 40));
        this.goalSelector.add(2, new EscapeDangerGoal(this, 1.2));
    }

}
