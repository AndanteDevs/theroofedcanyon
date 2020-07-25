package io.github.minecraftsuggestions.theroofedcanyon.world.biome;

import io.github.minecraftsuggestions.theroofedcanyon.init.TRCDecorators;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;

public final class ModifiedRoofedCanyonBiome extends RoofedCanyonBiome {
    public static final String id = "modified_roofed_canyon";

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
