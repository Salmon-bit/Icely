package com.glasses_inc.icely.block;

import com.glasses_inc.icely.Icely;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Instrument;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static Block FROSTED_OAK_LOG = registerBlock("frosted_oak_log", new Block(AbstractBlock.Settings
            .create()
            .strength(4f)
            .sounds(Blocks.OAK_LOG.getDefaultState().getSoundGroup())
            .solid()
            .burnable()
    ));

    public static Block FROSTED_OAK = registerBlock("frosted_oak", new Block(AbstractBlock.Settings
            .create()
            .strength(4f)
            .sounds(Blocks.OAK_LOG.getDefaultState().getSoundGroup())
            .solid()
            .burnable()
    ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Icely.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Icely.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
        Icely.LOGGER.info("Registering Mod Blocks for " + Icely.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(FROSTED_OAK_LOG);
            entries.add(FROSTED_OAK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(FROSTED_OAK_LOG);
            entries.add(FROSTED_OAK);
        });
    }
}
