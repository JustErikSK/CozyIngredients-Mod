package net.withrage.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.withrage.block.entity.ModBlockEntities;
import net.withrage.block.entity.ToasterBlockEntity;
import org.jetbrains.annotations.Nullable;

public class ToasterBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ToasterBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    private static final VoxelShape SHAPE = Block.createCuboidShape(5, 0, 3, 11, 6, 13);

    @Override @SuppressWarnings("deprecation")
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

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ToasterBlockEntity(pos, state);
    }

    @Override @SuppressWarnings("deprecation")
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof ToasterBlockEntity toaster) {
                ItemScatterer.spawn(world, pos, toaster);
                world.updateComparators(pos, this);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof NamedScreenHandlerFactory factory) {
            player.openHandledScreen(factory);
        }
        return ActionResult.CONSUME;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient() ? null : (type == ModBlockEntities.TOASTER ? (BlockEntityTicker<T>) (world1, pos, state1, be) -> {
            ((ToasterBlockEntity) be).tick(world1, pos, state1);
        } : null);
    }
}