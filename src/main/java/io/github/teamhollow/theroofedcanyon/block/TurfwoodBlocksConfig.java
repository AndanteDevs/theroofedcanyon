package io.github.teamhollow.theroofedcanyon.block;

import io.github.teamhollow.theroofedcanyon.block.helpers.WoodBlocksConfig;
import io.github.teamhollow.theroofedcanyon.block.sapling.TurfwoodSaplingGenerator;
import io.github.teamhollow.theroofedcanyon.init.TRCBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class TurfwoodBlocksConfig extends WoodBlocksConfig {
    public TurfwoodBlocksConfig() {
        id = "turfwood";
        planksMaterial = Material.WOOD;
        planksMaterialColor = MaterialColor.WOOD;
        logTopMaterialColor = MaterialColor.WOOD;
        logSideMaterialColor = MaterialColor.WOOD;
        strippedLogTopMaterialColor = MaterialColor.WOOD;
        strippedLogSideMaterialColor = MaterialColor.WOOD;
        woodMaterial = Material.WOOD;
        woodMaterialColor = MaterialColor.WOOD;
        strippedWoodMaterial = Material.WOOD;
        strippedWoodMaterialColor = MaterialColor.WOOD;
        saplingGenerator = new TurfwoodSaplingGenerator();
        tintIndex = 6301995;

        LEAVES = new TurfwoodLeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(TRCBlocks::canSpawnOnLeaves).suffocates(TRCBlocks::never).blockVision(TRCBlocks::never));;
    }
}
