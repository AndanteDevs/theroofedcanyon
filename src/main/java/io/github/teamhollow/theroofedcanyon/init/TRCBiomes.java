package io.github.teamhollow.theroofedcanyon.init;

import io.github.teamhollow.theroofedcanyon.TheRoofedCanyon;
import io.github.teamhollow.theroofedcanyon.world.biome.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class TRCBiomes {
    public static final Biome ROOFED_CANYON = register("roofed_canyon", new RoofedCanyonBiome());

    public TRCBiomes() {}

    private static Biome register(String id, Biome biome) {
        return Registry.register(Registry.BIOME, new Identifier(TheRoofedCanyon.MOD_ID, id), biome);
    }
}
