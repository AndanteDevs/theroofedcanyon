package io.github.teamhollow.theroofedcanyon.world.gen.foliage;

import java.util.Random;
import java.util.Set;

import io.github.teamhollow.theroofedcanyon.init.TRCBlocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;

public class TurfwoodFoliagePlacer extends DarkOakFoliagePlacer {
    public TurfwoodFoliagePlacer(int radius, int randomRadius, int offset, int randomOffset) {
        super(radius, randomRadius, offset, randomOffset);
    }

    @Override
    protected void generate(ModifiableTestableWorld world, Random random, TreeFeatureConfig config, BlockPos blockPos, int baseHeight, Set<BlockPos> set, int i, boolean giantTrunk, BlockBox blockBox) {
        int j = giantTrunk ? 1 : 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int k = -baseHeight; k <= baseHeight + j; ++k) {
            for (int l = -baseHeight; l <= baseHeight + j; ++l) {
                if (!this.method_27387(random, k, i, l, baseHeight, giantTrunk)) {
                    mutable.set((Vec3i) blockPos, k, i, l);
                    if (TreeFeature.canReplace(world, mutable)) {
                        world.setBlockState(mutable, TRCBlocks.TURFWOOD.LEAVES.getDefaultState(), 19);
                        world.setBlockState(mutable.down(), TRCBlocks.TURFWOOD.WOOD.getDefaultState(), 19);
                        blockBox.encompass(new BlockBox(mutable, mutable));
                        set.add(mutable.toImmutable());
                    }
                }
            }
        }
    }
}
