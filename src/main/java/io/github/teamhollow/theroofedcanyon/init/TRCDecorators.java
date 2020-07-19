package io.github.teamhollow.theroofedcanyon.init;

import com.google.common.collect.ImmutableList;

import io.github.teamhollow.theroofedcanyon.TheRoofedCanyon;
import io.github.teamhollow.theroofedcanyon.block.helpers.WoodBlocks;
import io.github.teamhollow.theroofedcanyon.world.gen.decorator.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;

public class TRCDecorators {
    public static WoodBlocks TURFWOOD = TRCBlocks.TURFWOOD;

    public static final TreeFeatureConfig TURFWOOD_TREE_CONFIG = new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(TURFWOOD.LOG.getDefaultState()), new SimpleBlockStateProvider(TURFWOOD.LEAVES.getDefaultState()), new DarkOakFoliagePlacer(8, 2, 0, 0), new DarkOakTrunkPlacer(6, 2, 1), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(TURFWOOD.LEAVES.getDefaultState())))).build();

    public static final Decorator<NopeDecoratorConfig> TURFWOOD_TREE = register("turfwood_tree", new TurfwoodTreeDecorator(NopeDecoratorConfig.field_24891));

    public TRCDecorators() {}

    private static <T extends DecoratorConfig, G extends Decorator<T>> G register(String id, G decorator) {
        return Registry.register(Registry.DECORATOR, new Identifier(TheRoofedCanyon.MOD_ID, id), decorator);
    }
}
