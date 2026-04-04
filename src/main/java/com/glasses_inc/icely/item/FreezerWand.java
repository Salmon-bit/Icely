package com.glasses_inc.icely.item;

import com.glasses_inc.icely.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

public class FreezerWand extends Item {
    private static final Map<Block, Block> FREESER_MAP = Map.ofEntries(
            Map.entry(Blocks.OAK_LOG, ModBlocks.FROSTED_OAK_LOG),
            Map.entry(Blocks.OAK_WOOD, ModBlocks.FROSTED_OAK),
            Map.entry(Blocks.OAK_TRAPDOOR, ModBlocks.FROSTED_OAK_TRAPDOOR),
            Map.entry(Blocks.OAK_PLANKS, ModBlocks.FROSTED_OAK_PLANKS),
            Map.entry(Blocks.OAK_SLAB, ModBlocks.FROSTED_OAK_SLAB),
            Map.entry(Blocks.OAK_STAIRS, ModBlocks.FROSTED_OAK_STAIRS),
            Map.entry(Blocks.OAK_BUTTON, ModBlocks.FROSTED_OAK_BUTTON),
            Map.entry(Blocks.OAK_DOOR, ModBlocks.FROSTED_OAK_DOOR),
            Map.entry(Blocks.OAK_FENCE, ModBlocks.FROSTED_OAK_FENCE),
            Map.entry(Blocks.OAK_FENCE_GATE, ModBlocks.FROSTED_OAK_FENCE_GATE),
            Map.entry(Blocks.STRIPPED_OAK_LOG, ModBlocks.FROSTED_STRIPPED_OAK_LOG),
            Map.entry(Blocks.STRIPPED_OAK_WOOD, ModBlocks.FROSTED_STRIPPED_OAK_WOOD),
            Map.entry(Blocks.OAK_PRESSURE_PLATE, ModBlocks.FROSTED_OAK_PRESSURE_PLATE)
    );

    public FreezerWand(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState oldState = world.getBlockState(pos);
        Block block = oldState.getBlock();

        if (FREESER_MAP.containsKey(block)) {
            if (!world.isClient) {
                Block newBlock = FREESER_MAP.get(block);
                BlockState newState = newBlock.getDefaultState();

                // Копируем свойства из старого состояния в новое
                for (Property<?> property : oldState.getProperties()) {
                    if (newState.getProperties().contains(property)) {
                        newState = copyProperty(oldState, newState, property);
                    }
                }

                world.setBlockState(pos, newState);

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, pos, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }

    private <T extends Comparable<T>> BlockState copyProperty(BlockState oldState, BlockState newState, Property<T> property) {
        return newState.with(property, oldState.get(property));
    }
}
