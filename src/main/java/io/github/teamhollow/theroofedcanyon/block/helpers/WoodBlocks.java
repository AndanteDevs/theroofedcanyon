package io.github.teamhollow.theroofedcanyon.block.helpers;

import static io.github.teamhollow.theroofedcanyon.init.TRCBlocks.*;

import io.github.teamhollow.theroofedcanyon.block.helpers.cpublic.*;
import io.github.teamhollow.theroofedcanyon.init.TRCBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class WoodBlocks {
    public WoodBlocksConfig config;

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
        this.config = config;

        // declare defaults
        LOG = createLogBlock(config.logTopMaterialColor, config.logSideMaterialColor);
        STRIPPED_LOG = createLogBlock(config.strippedLogTopMaterialColor, config.strippedLogSideMaterialColor);
        WOOD = new PillarBlock(AbstractBlock.Settings.of(config.woodMaterial, config.woodMaterialColor).strength(2.0F).sounds(BlockSoundGroup.WOOD));
        STRIPPED_WOOD = new PillarBlock(AbstractBlock.Settings.of(config.strippedWoodMaterial, config.strippedWoodMaterialColor).strength(2.0F).sounds(BlockSoundGroup.WOOD));
        PLANKS = new Block(AbstractBlock.Settings.of(config.planksMaterial, config.planksMaterialColor).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
        LEAVES = createLeavesBlock();
        SLAB = new SlabBlock(AbstractBlock.Settings.of(config.planksMaterial, config.planksMaterialColor).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
        PRESSURE_PLATE = new PublicPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.of(config.planksMaterial, config.planksMaterialColor).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD));
        FENCE = new FenceBlock(AbstractBlock.Settings.of(config.woodMaterial, config.planksMaterialColor).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
        FENCE_GATE = new FenceGateBlock(AbstractBlock.Settings.of(config.woodMaterial, config.planksMaterialColor).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
        SAPLING = new PublicSaplingBlock(config.saplingGenerator, AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        TRAPDOOR = new PublicTrapdoorBlock(AbstractBlock.Settings.of(config.woodMaterial, config.woodMaterialColor).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque().allowsSpawning(TRCBlocks::never));
        BUTTON = new PublicWoodButtonBlock(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD));
        STAIRS = new PublicStairsBlock(PLANKS.getDefaultState(), AbstractBlock.Settings.copy(PLANKS));
        DOOR = new PublicDoorBlock(AbstractBlock.Settings.of(config.woodMaterial, config.planksMaterialColor).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
        // SIGN =

        // check config for default modifications
        if (config.LOG != null) LOG = config.LOG;
        if (config.STRIPPED_LOG != null) STRIPPED_LOG = config.STRIPPED_LOG;
        if (config.WOOD != null) WOOD = config.WOOD;
        if (config.STRIPPED_WOOD != null) STRIPPED_WOOD = config.STRIPPED_WOOD;
        if (config.PLANKS != null) PLANKS = config.PLANKS;
        if (config.LEAVES != null) LEAVES = config.LEAVES;
        if (config.SLAB != null) SLAB = config.SLAB;
        if (config.PRESSURE_PLATE != null) PRESSURE_PLATE = config.PRESSURE_PLATE;
        if (config.FENCE != null) FENCE = config.FENCE;
        if (config.FENCE_GATE != null) FENCE_GATE = config.FENCE_GATE;
        if (config.SAPLING != null) SAPLING = config.SAPLING;
        if (config.TRAPDOOR != null) TRAPDOOR = config.TRAPDOOR;
        if (config.BUTTON != null) BUTTON = config.BUTTON;
        if (config.STAIRS != null) STAIRS = config.STAIRS;
        if (config.DOOR != null) DOOR = config.DOOR;
        // if (config.SIGN != null) SIGN =

        // register blocks/items
        LOG = register(config.id + "_log", LOG);
        STRIPPED_LOG = register("stripped_" + config.id + "_log", STRIPPED_LOG);

        WOOD = register(config.id + "_wood", WOOD);
        STRIPPED_WOOD = register("stripped_" + config.id + "_wood", STRIPPED_WOOD);

        PLANKS = register(config.id + "_planks", PLANKS);
        LEAVES = register(config.id + "_leaves", LEAVES);
        SLAB = register(config.id + "_slab", SLAB);
        PRESSURE_PLATE = register(config.id + "_pressure_plate", PRESSURE_PLATE);
        FENCE = register(config.id + "_fence", FENCE);
        FENCE_GATE = register(config.id + "_fence_gate", FENCE_GATE);
        SAPLING = register(config.id + "_sapling", SAPLING);
        TRAPDOOR = register(config.id + "_trapdoor", TRAPDOOR);
        BUTTON = register(config.id + "_button", BUTTON);
        STAIRS = register(config.id + "_stairs", STAIRS);
        DOOR = register(config.id + "_door", DOOR);
        // SIGN =

        // block properties
        if (config.isFlammable) {
            int baseBurnChance = config.baseBurnChance;
            int largeBurnChance = baseBurnChance * 6;

            int baseSpreadChance = config.baseSpreadChance;
            int smallSpreadChance = baseSpreadChance / 4;
            int largeSpreadChance = baseSpreadChance * 3;

            FlammableBlockRegistry INSTANCE = FlammableBlockRegistry.getDefaultInstance();
            INSTANCE.add(PLANKS, baseBurnChance, baseSpreadChance);
            INSTANCE.add(SLAB, baseBurnChance, baseSpreadChance);
            INSTANCE.add(FENCE_GATE, baseBurnChance, baseSpreadChance);
            INSTANCE.add(FENCE, baseBurnChance, baseSpreadChance);
            INSTANCE.add(STAIRS, baseBurnChance, baseSpreadChance);
            INSTANCE.add(LOG, baseBurnChance, smallSpreadChance);
            INSTANCE.add(STRIPPED_LOG, baseBurnChance, smallSpreadChance);
            INSTANCE.add(STRIPPED_WOOD, baseBurnChance, smallSpreadChance);
            INSTANCE.add(WOOD, baseBurnChance, smallSpreadChance);
            INSTANCE.add(LEAVES, largeBurnChance, largeSpreadChance);
        }
        if (config.canBeUsedAsFuel) {
            int fenceFuelTime = 300;

            FuelRegistry INSTANCE = FuelRegistry.INSTANCE;
            INSTANCE.add(FENCE, fenceFuelTime);
            INSTANCE.add(FENCE_GATE, fenceFuelTime);
        }
    }
}
