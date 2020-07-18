package io.github.teamhollow.theroofedcanyon.block.helpers;

import static io.github.teamhollow.theroofedcanyon.init.TRCBlocks.*;

import io.github.teamhollow.theroofedcanyon.block.*;
import io.github.teamhollow.theroofedcanyon.init.TRCBlocks;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class WoodBlocks {
    public Block LOG;
    public Block STRIPPED_LOG;
    public Block WOOD;
    public Block STRIPPED_WOOD;
    public Block PLANKS;
    public Block LEAVES;
    public Block SLAB;
    public Block PRESSURE_PLATE;
    public Block FENCE;
    public Block FENCE_GATE;
    public Block SAPLING;
    public Block TRAPDOOR;
    public Block BUTTON;
    public Block STAIRS;
    public Block DOOR;
    // public Block SIGN;
    // public Entity BOAT;

    public WoodBlocks(WoodBlocksConfig config) {
        LOG = register(config.id + "_log", createLogBlock(config.logTopMaterialColor, config.logSideMaterialColor));
        STRIPPED_LOG = register(config.id + "stripped_log", createLogBlock(config.strippedLogTopMaterialColor, config.strippedLogSideMaterialColor));

        WOOD = register(config.id + "_wood", new PillarBlock(AbstractBlock.Settings.of(config.woodMaterial, config.woodMaterialColor).strength(2.0F).sounds(BlockSoundGroup.WOOD)));
        STRIPPED_WOOD = register(config.id + "_stripped_wood", new PillarBlock(AbstractBlock.Settings.of(config.strippedWoodMaterial, config.strippedWoodMaterialColor).strength(2.0F).sounds(BlockSoundGroup.WOOD)));

        PLANKS = register(config.id + "_planks", new Block(AbstractBlock.Settings.of(config.planksMaterial, config.planksMaterialColor).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
        LEAVES = register(config.id + "_leaves", createLeavesBlock());
        SLAB = register(config.id + "_slab", new SlabBlock(AbstractBlock.Settings.of(config.planksMaterial, config.planksMaterialColor).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
        PRESSURE_PLATE = register(config.id + "_pressure_plate", new PublicPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.of(config.planksMaterial, config.planksMaterialColor).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD)));
        FENCE = register(config.id + "_fence", new FenceBlock(AbstractBlock.Settings.of(config.woodMaterial, config.planksMaterialColor).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
        FENCE_GATE = register(config.id + "_fence_gate", new FenceGateBlock(AbstractBlock.Settings.of(config.woodMaterial, config.planksMaterialColor).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
        SAPLING = register(config.id + "_sapling", new PublicSaplingBlock(config.saplingGenerator, AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)));
        TRAPDOOR = register(config.id + "_trapdoor", new PublicTrapdoorBlock(AbstractBlock.Settings.of(config.woodMaterial, config.woodMaterialColor).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque().allowsSpawning(TRCBlocks::never)));
        BUTTON = register(config.id + "_button", new PublicWoodButtonBlock(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD)));
        STAIRS = register(config.id + "_stairs", new PublicStairsBlock(PLANKS.getDefaultState(), AbstractBlock.Settings.copy(PLANKS)));
        DOOR = register(config.id + "_door", new PublicDoorBlock(AbstractBlock.Settings.of(config.woodMaterial, config.planksMaterialColor).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
        // SIGN =
    }
}
