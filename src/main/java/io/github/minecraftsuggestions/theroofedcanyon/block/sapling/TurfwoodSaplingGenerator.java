package io.github.minecraftsuggestions.theroofedcanyon.block.sapling;

import java.util.Random;
import io.github.minecraftsuggestions.theroofedcanyon.init.TRCDecorators;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class TurfwoodSaplingGenerator extends LargeTreeSaplingGenerator {
    public ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return null;
    }

    public ConfiguredFeature<TreeFeatureConfig, ?> createLargeTreeFeature(Random random) {
        return Feature.TREE.configure(TRCDecorators.TURFWOOD_TREE_CONFIG);
    }
}
