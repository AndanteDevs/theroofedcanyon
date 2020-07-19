package io.github.teamhollow.theroofedcanyon.init;

import io.github.teamhollow.theroofedcanyon.TheRoofedCanyon;
import io.github.teamhollow.theroofedcanyon.item.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TRCItems {
    public static final Item VILE_BOTTLE = register(VileBottleItem.id, new VileBottleItem());

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TheRoofedCanyon.MOD_ID, id), item);
    }
}
