package io.github.teamhollow.theroofedcanyon;

import org.apache.logging.log4j.Level;

import io.github.teamhollow.theroofedcanyon.init.TRCBlocks;
import io.github.teamhollow.theroofedcanyon.init.TRCParticleTypes;
import io.github.teamhollow.theroofedcanyon.util.Utils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

public class TheRoofedCanyonClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        log(Level.INFO, "Initializing client");

        new Utils();
        TRCParticleTypes.registerFactories();

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            return world != null && pos != null 
                    ? BiomeColors.getGrassColor(world, pos)
                    : GrassColors.getColor(0.5D, 1.0D);
        }, TRCBlocks.TURFWOOD.LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            BlockState blockState = ((BlockItem) stack.getItem()).getBlock().getDefaultState();
            return new BlockColors().getColor(blockState, (BlockRenderView) null, (BlockPos) null, tintIndex);
        }, TRCBlocks.TURFWOOD.LEAVES);

        BlockRenderLayerMap.INSTANCE.putBlock(TRCBlocks.TURFWOOD.LEAVES, RenderLayer.getCutoutMipped());

        log(Level.INFO, "Initialized client");
    }

    public static void log(Level level, String message) {
        TheRoofedCanyon.log(level, message);
    }
}
