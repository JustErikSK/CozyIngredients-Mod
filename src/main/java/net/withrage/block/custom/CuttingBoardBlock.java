package net.withrage.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class CuttingBoardBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public CuttingBoardBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    private static final VoxelShape SHAPE = Block.createCuboidShape(2.5, 0, 1, 13.5, 1, 15);

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(Properties.HORIZONTAL_FACING);
        return rotateShape(direction, SHAPE);
    }

    private static VoxelShape rotateShape(Direction direction, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, VoxelShapes.empty()};

        int times = switch (direction) {
            case SOUTH -> 3;
            case WEST -> 0;
            case EAST -> 2;
            default -> 1;
        };
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> {
                buffer[1] = VoxelShapes.union(
                        buffer[1],
                        VoxelShapes.cuboid(
                                1 - maxZ, minY, minX,
                                1 - minZ, maxY, maxX
                        )
                );
            });
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }
        return buffer[0];
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}

