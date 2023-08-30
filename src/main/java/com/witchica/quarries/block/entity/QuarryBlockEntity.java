package com.witchica.quarries.block.entity;

import com.witchica.quarries.QuirkyQuarries;
import com.witchica.quarries.block.QuarryBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

import java.util.HashMap;
import java.util.Map;

public class QuarryBlockEntity extends BlockEntity {
    public static Map<Integer, Vector2i> MAXIMUM_SIZES_PER_TIER = new HashMap<Integer, Vector2i>();
    public static Map<Integer, Integer> TICKS_BETWEEN_BLOCKS_PER_TIER = new HashMap<Integer, Integer>();
    public static float POWER_PER_BLOCK_MINED = 5.0f;


    static {
        MAXIMUM_SIZES_PER_TIER.put(0, new Vector2i(16,16));
        MAXIMUM_SIZES_PER_TIER.put(1, new Vector2i(24,24));
        MAXIMUM_SIZES_PER_TIER.put(2, new Vector2i(32,32));
        MAXIMUM_SIZES_PER_TIER.put(3, new Vector2i(40,40));
        MAXIMUM_SIZES_PER_TIER.put(4, new Vector2i(48,48));
        MAXIMUM_SIZES_PER_TIER.put(5, new Vector2i(64,64));

        TICKS_BETWEEN_BLOCKS_PER_TIER.put(0, 40);
        TICKS_BETWEEN_BLOCKS_PER_TIER.put(1, 35);
        TICKS_BETWEEN_BLOCKS_PER_TIER.put(2, 30);
        TICKS_BETWEEN_BLOCKS_PER_TIER.put(3, 25);
        TICKS_BETWEEN_BLOCKS_PER_TIER.put(4, 20);
        TICKS_BETWEEN_BLOCKS_PER_TIER.put(5, 15);
    }

    public QuarryBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(QuirkyQuarries.QUARRY_BLOCK_ENTITY_TYPE.get(), pPos, pBlockState);
    }

    public void tick() {
        QuirkyQuarries.LOGGER.error("AAAAAAAAA");
    }

    public static <QuarryBlockEntity> void ticker(Level level, BlockPos blockPos, BlockState blockState, QuarryBlockEntity quarryBlockEntity) {
        ((com.witchica.quarries.block.entity.QuarryBlockEntity) quarryBlockEntity).tick();
    }
}
