package re.vcokltf.glowsquid.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class UnderwaterTorch extends Block implements Waterloggable{
    public static final BooleanProperty WATERLOGGED;

    protected static final VoxelShape BOUNDING_SHAPE = Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);

    public UnderwaterTorch() {
        super(Settings.of(Material.REPAIR_STATION).luminance((state) -> { // Easiest way to make the glass glow. Possibly add glowing stained glass later?
            return 15;
        }).noCollision());
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;
        return (BlockState)super.getPlacementState(ctx).with(WATERLOGGED, bl);
    }

/*    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BOUNDING_SHAPE;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {}
*/


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return BOUNDING_SHAPE;
    }
    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState var1, World var2, BlockPos var3, Random var4) {
        double var5 = (double)var3.getX() + 0.5D;
        double var7 = (double)var3.getY() + 0.7D;
        double var9 = (double)var3.getZ() + 0.5D;
        var2.addParticle(ParticleTypes.SMOKE, var5, var7, var9, 0.0D, 0.0D, 0.0D);
        var2.addParticle(ParticleTypes.SOUL_FIRE_FLAME, var5, var7, var9, 0.0D, 0.0D, 0.0D);
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if ((Boolean)state.get(WATERLOGGED)) {
            world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }
    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }
    static {
        WATERLOGGED = Properties.WATERLOGGED;
    }

    }






/*
package re.vcokltf.glowsquid.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Random;

public class UnderwaterTorch extends Block {
    public UnderwaterTorch(Settings settings) {
        super(Settings.of(Material.REPAIR_STATION).luminance((state) -> { // Easiest way to make the glass glow. Possibly add glowing stained glass later?
            return 15;
        }).noCollision());
    }


    public static final VoxelShape BOUNDING_SHAPE = Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return BOUNDING_SHAPE;
    }
    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState var1, World var2, BlockPos var3, Random var4) {
        double var5 = (double)var3.getX() + 0.5D;
        double var7 = (double)var3.getY() + 0.7D;
        double var9 = (double)var3.getZ() + 0.5D;
        var2.addParticle(ParticleTypes.SMOKE, var5, var7, var9, 0.0D, 0.0D, 0.0D);
        var2.addParticle(ParticleTypes.SOUL_FIRE_FLAME, var5, var7, var9, 0.0D, 0.0D, 0.0D);
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }
}
*/