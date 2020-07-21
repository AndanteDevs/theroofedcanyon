package io.github.teamhollow.theroofedcanyon.block;

import java.util.Random;

import io.github.teamhollow.theroofedcanyon.init.TRCBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

public class TurfwoodLeavesBlock extends GrassBlock {
    public TurfwoodLeavesBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos) || world.getBlockState(pos.up()).getBlock() == TRCBlocks.TURFWOOD.LEAVES) {
            world.setBlockState(pos, TRCBlocks.TURFWOOD.LOG.getDefaultState());
        } else {
            if (world.getLightLevel(pos.up()) >= 9) {
                BlockState blockState = this.getDefaultState();

                for (int i = 0; i < 4; ++i) {
                    BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (world.getBlockState(blockPos).isOf(TRCBlocks.TURFWOOD.LOG) && canSpread(blockState, world, blockPos)) {
                        world.setBlockState(blockPos, (BlockState) blockState.with(SNOWY, world.getBlockState(blockPos.up()).isOf(Blocks.SNOW)));
                    }
                }
            }

        }
    }

    private static boolean canSurvive(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = worldView.getBlockState(blockPos);
        if (blockState.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int i = ChunkLightProvider.getRealisticOpacity(worldView, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(worldView, blockPos));
            return i < worldView.getMaxLightLevel();
        }
    }
    private static boolean canSpread(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return canSurvive(state, worldView, pos) && !worldView.getFluidState(blockPos).isIn(FluidTags.WATER);
    }
}
