package com.glasses_inc.icely.block;

import com.glasses_inc.icely.Icely;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static Block FROSTED_OAK_LOG = registerBlock("frosted_oak_log", new PillarBlock(PillarBlock.Settings
            .create()
            .strength(4f)
            .sounds(Blocks.OAK_LOG.getDefaultState().getSoundGroup())
            .solid()
            .burnable()
    ));

    public static Block FROSTED_OAK = registerBlock("frosted_oak", new PillarBlock(PillarBlock.Settings
            .create()
            .strength(4f)
            .sounds(Blocks.OAK_WOOD.getDefaultState().getSoundGroup())
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

    public static Block FROSTED_OAK_SLAB = registerBlock("frosted_oak_slab", new SlabBlock(SlabBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static Block FROSTED_OAK_TRAPDOOR = registerBlock("frosted_oak_trapdoor", new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)));

    public static Block FROSTED_OAK_STAIRS = registerBlock("frosted_oak_stairs", new StairsBlock(FROSTED_OAK_PLANKS.getDefaultState(), AbstractBlock.Settings.copyShallow(FROSTED_OAK_PLANKS)));

    public static Block FROSTED_OAK_DOOR = registerBlock("frosted_oak_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));

    public static Block FROSTED_OAK_BUTTON = registerBlock("frosted_oak_button", Blocks.createWoodenButtonBlock(BlockSetType.OAK));

    public static Block FROSTED_OAK_FENCE = registerBlock("frosted_oak_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));

    public static Block FROSTED_OAK_FENCE_GATE = registerBlock("frosted_oak_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));

    public static Block FROSTED_OAK_PRESSURE_PLATE = registerBlock("frosted_oak_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));

    public static Block FROSTED_STRIPPED_OAK_LOG = registerBlock("frosted_stripped_oak_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static Block FROSTED_STRIPPED_OAK_WOOD = registerBlock("frosted_stripped_oak_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

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
