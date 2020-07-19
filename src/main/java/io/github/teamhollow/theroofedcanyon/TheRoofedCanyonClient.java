package io.github.teamhollow.theroofedcanyon;

import io.github.teamhollow.theroofedcanyon.init.TRCBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class TheRoofedCanyonClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> TRCBlocks.TURFWOOD.config.tintIndex, TRCBlocks.TURFWOOD.LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TRCBlocks.TURFWOOD.config.tintIndex, TRCBlocks.TURFWOOD.LEAVES);
    }
}
