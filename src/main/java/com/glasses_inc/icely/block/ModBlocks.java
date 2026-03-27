package com.glasses_inc.icely.block;

import com.glasses_inc.icely.Icely;
import com.glasses_inc.icely.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

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

    public static Block FROSTED_OAK_PLANKS = registerBlock("frosted_oak_planks", new Block(AbstractBlock.Settings
            .create()
            .strength(4f)
            .sounds(Blocks.OAK_PLANKS.getDefaultState().getSoundGroup())
            .solid()
            .burnable()
    ));

    public static Block FROSTED_OAK_SLAB = registerBlock("frosted_oak_slab", new Block(Blocks.OAK_SLAB.getSettings()));

    public static Block FROSTED_OAK_TRAPDOOR = registerBlock("frosted_oak_trapdoor", new Block(Blocks.OAK_TRAPDOOR.getSettings()));

    public static Block CRYPTONITE_ORE = registerBlock("cryptonite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    Blocks.EMERALD_ORE.getSettings().mapColor(DyeColor.CYAN).requiresTool()));

    public static Block DEEPSLATE_CRYPTONITE_ORE = registerBlock("deepslate_cryptonite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    Blocks.DEEPSLATE_EMERALD_ORE.getSettings().mapColor(DyeColor.BLUE).requiresTool()));

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
    }
}
