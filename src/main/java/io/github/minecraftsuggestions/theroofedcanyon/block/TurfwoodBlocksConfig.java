package io.github.minecraftsuggestions.theroofedcanyon.block;

import io.github.minecraftsuggestions.theroofedcanyon.block.helpers.WoodBlocksConfig;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.sapling.OakSaplingGenerator;

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
        // saplingGenerator = new TurfwoodSaplingGenerator();
        saplingGenerator = new OakSaplingGenerator();

        LEAVES = new TurfwoodLeavesBlock();
    }
}
