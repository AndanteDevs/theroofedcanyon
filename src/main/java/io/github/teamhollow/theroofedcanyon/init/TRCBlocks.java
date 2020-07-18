package io.github.teamhollow.theroofedcanyon.init;

import io.github.teamhollow.theroofedcanyon.TheRoofedCanyon;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

public class TRCBlocks {
    public static final Block TURFWOOD_LOG = register("turfwood_log", createLogBlock(MaterialColor.BROWN, MaterialColor.BROWN));
    public static final Block TURFWOOD_LEAVES = register("turfwood_leaves", createLeavesBlock());

    public TRCBlocks() {}

    public static Block register(String id, Block block, boolean registerItem) {
        return Registry.register(Registry.BLOCK, new Identifier(TheRoofedCanyon.MOD_ID, id), block);
    }
    public static Block register(String id, Block block) {
        return register(id, block, true);
    }

    public static PillarBlock createLogBlock(MaterialColor topMaterialColor, MaterialColor sideMaterialColor) {
        return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, (blockState) -> blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }
    public static LeavesBlock createLeavesBlock() {
        return new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque());
    }
}
