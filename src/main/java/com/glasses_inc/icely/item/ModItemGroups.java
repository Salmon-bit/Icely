package com.glasses_inc.icely.item;

import com.glasses_inc.icely.Icely;
import com.glasses_inc.icely.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup APPEARANCE_ICELY_BLOCKS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Icely.MOD_ID, "decorative_block_item_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.FROSTED_OAK_LOG))
                    .displayName(Text.translatable("itemgroup.tutorialmod.decorative_icely_block_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FROSTED_OAK_LOG);
                        entries.add(ModBlocks.FROSTED_OAK);
                        entries.add(ModBlocks.FROSTED_OAK_PLANKS);
                        entries.add(ModBlocks.FROSTED_OAK_TRAPDOOR);
                        entries.add(ModBlocks.FROSTED_OAK_SLAB);
                        entries.add(ModBlocks.FROSTED_OAK_STAIRS);
                    })
                    .build());

    public static final ItemGroup ICELY = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Icely.MOD_ID, "icely_item_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.BLUE_ICE_ICICLE))
                    .displayName(Text.translatable("itemgroup.tutorialmod.icely"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ICICLE);
                        entries.add(ModItems.BLUE_ICE_ICICLE);
                        entries.add(ModBlocks.CRYPTONITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_CRYPTONITE_ORE);
                        entries.add(ModItems.RAW_CRYPONITE);
                        entries.add(ModItems.CRYPTONITE_INGOT);
                    })
                    .build());

    public static void registerItemGroups() {
        Icely.LOGGER.info("Registering ModItemGroups for " + Icely.MOD_ID);
    }
}
