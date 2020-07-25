package io.github.minecraftsuggestions.theroofedcanyon.init;

import io.github.minecraftsuggestions.theroofedcanyon.TheRoofedCanyon;
import io.github.minecraftsuggestions.theroofedcanyon.item.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TRCItems {
    public static final Item VILE_BOTTLE = register(VileBottleItem.id, new VileBottleItem());
    public static final Item VILE_POTION = register(VilePotionItem.id, new VilePotionItem());

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TheRoofedCanyon.MOD_ID, id), item);
    }
}
