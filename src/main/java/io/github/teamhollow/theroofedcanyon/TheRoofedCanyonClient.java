package io.github.teamhollow.theroofedcanyon;

import org.apache.logging.log4j.Level;

import io.github.teamhollow.theroofedcanyon.init.TRCBlocks;
// import io.github.teamhollow.theroofedcanyon.init.TRCParticleTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class TheRoofedCanyonClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        log(Level.INFO, "Initializing client");

        // new TRCParticleTypes();

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> TRCBlocks.TURFWOOD.config.tintIndex, TRCBlocks.TURFWOOD.LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TRCBlocks.TURFWOOD.config.tintIndex, TRCBlocks.TURFWOOD.LEAVES);

        log(Level.INFO, "Initialized client");
    }

    public static void log(Level level, String message) {
        TheRoofedCanyon.log(level, message);
    }
}
