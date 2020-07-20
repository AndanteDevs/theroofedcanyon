package io.github.teamhollow.theroofedcanyon.world.biome;

import io.github.teamhollow.theroofedcanyon.init.TRCDecorators;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;

public final class ModifiedRoofedCanyonBiome extends RoofedCanyonBiome {
    public ModifiedRoofedCanyonBiome() {
        super();
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.MELON_PATCH_CONFIG).createDecoratedFeature(
                        Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.configure(TRCDecorators.VILEPOT_PATCH_CONFIG).createDecoratedFeature(
                        Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
    }
}
