package io.github.teamhollow.theroofedcanyon.block;

import io.github.teamhollow.theroofedcanyon.block.helpers.WoodBlocksConfig;
import io.github.teamhollow.theroofedcanyon.block.sapling.TurfwoodSaplingGenerator;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;

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

        LEAVES = new TurfwoodLeavesBlock();
    }
}
