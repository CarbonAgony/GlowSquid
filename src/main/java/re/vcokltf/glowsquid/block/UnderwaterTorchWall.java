package re.vcokltf.glowsquid.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Random;

public class UnderwaterTorchWall extends UnderwaterTorch implements Waterloggable {
    public static final BooleanProperty WATERLOGGED;

    public static final DirectionProperty FACING;
    private static final Map<Direction, VoxelShape> BOUNDING_SHAPES;

    public UnderwaterTorchWall(Settings settings) {
        super();
        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(FACING, Direction.NORTH));
    }

    public String getTranslationKey() {
        return this.asItem().getTranslationKey();
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getBoundingShape(state);
    }

    public static VoxelShape getBoundingShape(BlockState state) {
        return (VoxelShape) BOUNDING_SHAPES.get(state.get(FACING));
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = (Direction) state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isSideSolidFullSquare(world, blockPos, direction);
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = this.getDefaultState();
        WorldView worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction[] directions = ctx.getPlacementDirections();
        Direction[] var6 = directions;
        int var7 = directions.length;
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;

        for (int var8 = 0; var8 < var7; ++var8) {
            Direction direction = var6[var8];
            if (direction.getAxis().isHorizontal()) {
                Direction direction2 = direction.getOpposite();
                blockState = (BlockState) blockState.with(FACING, direction2);
                if (blockState.canPlaceAt(worldView, blockPos)) {
                    return blockState.with(WATERLOGGED, bl);
                }
            }
        }


        return null;
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if ((Boolean) state.get(WATERLOGGED)) {
            world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction direction = (Direction) state.get(FACING);
        double d = (double) pos.getX() + 0.5D;
        double e = (double) pos.getY() + 0.7D;
        double f = (double) pos.getZ() + 0.5D;
        double g = 0.22D;
        double h = 0.27D;
        Direction direction2 = direction.getOpposite();
        world.addParticle(ParticleTypes.SMOKE, d + 0.27D * (double) direction2.getOffsetX(), e + 0.22D, f + 0.27D * (double) direction2.getOffsetZ(), 0.0D, 0.0D, 0.0D);
        world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, d + 0.27D * (double) direction2.getOffsetX(), e + 0.22D, f + 0.27D * (double) direction2.getOffsetZ(), 0.0D, 0.0D, 0.0D);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState) state.with(FACING, rotation.rotate((Direction) state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction) state.get(FACING)));
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean) state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(WATERLOGGED);
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        BOUNDING_SHAPES = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(5.5D, 3.0D, 11.0D, 10.5D, 13.0D, 16.0D), Direction.SOUTH, Block.createCuboidShape(5.5D, 3.0D, 0.0D, 10.5D, 13.0D, 5.0D), Direction.WEST, Block.createCuboidShape(11.0D, 3.0D, 5.5D, 16.0D, 13.0D, 10.5D), Direction.EAST, Block.createCuboidShape(0.0D, 3.0D, 5.5D, 5.0D, 13.0D, 10.5D)));
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
    }
}