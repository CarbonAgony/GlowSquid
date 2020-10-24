package re.vcokltf.glowsquid.block;

import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;


public class GlowingGlass extends GlassBlock {
    public GlowingGlass() {
        super(Settings.of(Material.GLASS).luminance((state) -> { // Easiest way to make the glass glow. Possibly add glowing stained glass later?
            return 15;
        }));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) { // Prevents player from being able to see through walls/blocks when this block is placed on top of it.
        return VoxelShapes.cuboid(0f, 0f, 0f, 0.99999f, 0.99999f, 0.99999f);  //I don't know any other way to fix this so I'm using this
    }

}