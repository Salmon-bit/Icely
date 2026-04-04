package com.glasses_inc.icely.item;

import com.glasses_inc.icely.Icely;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BLUE_ICE_ICICLE = registerItem("blue_ice_icicle", new Item(new Item.Settings()));
    public static final Item ICICLE = registerItem("icicle", new Item(new Item.Settings()));
    public static final Item RAW_CRYPONITE = registerItem("raw_cryptonite", new Item(new Item.Settings()));
    public static final Item CRYPTONITE_INGOT = registerItem("cryptonite_ingot", new Item(new Item.Settings()));
    public static final Item FREEZER_WAND = registerItem("freezer_wand", new FreezerWand(new Item.Settings().maxDamage(20)));

    private static Item registerItem(String name, Item item) {
        return  Registry.register(Registries.ITEM, Identifier.of(Icely.MOD_ID, name), item);
    }

    public static void registerItems() {
        Icely.LOGGER.info("Registering ModItems for " + Icely.MOD_ID);
    }
}
