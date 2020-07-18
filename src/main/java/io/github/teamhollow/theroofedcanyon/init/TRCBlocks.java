package io.github.teamhollow.theroofedcanyon.init;

import io.github.teamhollow.theroofedcanyon.TheRoofedCanyon;
import io.github.teamhollow.theroofedcanyon.block.TurfwoodBlocksConfig;
import io.github.teamhollow.theroofedcanyon.block.helpers.WoodBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class TRCBlocks {
    public static final WoodBlocks TURFWOOD = new WoodBlocks(new TurfwoodBlocksConfig());

    public TRCBlocks() {}

    public static Block register(String id, Block block, boolean registerItem) {
        Block registeredBlock = Registry.register(Registry.BLOCK, new Identifier(TheRoofedCanyon.MOD_ID, id), block);
        if (registerItem) Registry.register(Registry.ITEM, new Identifier(TheRoofedCanyon.MOD_ID, id), new BlockItem(registeredBlock, new Item.Settings().maxCount(64)));

        return registeredBlock;
    }
    public static Block register(String id, Block block) {
        return register(id, block, true);
    }

    public static PillarBlock createLogBlock(MaterialColor topMaterialColor, MaterialColor sideMaterialColor) {
        return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, (blockState) -> blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }
    public static LeavesBlock createLeavesBlock() {
        return new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(TRCBlocks::canSpawnOnLeaves).suffocates(TRCBlocks::never).blockVision(TRCBlocks::never));
   }

    public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }
    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }
    public static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }
}
