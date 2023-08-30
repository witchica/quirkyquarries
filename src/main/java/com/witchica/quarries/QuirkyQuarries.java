package com.witchica.quarries;

import com.mojang.logging.LogUtils;
import com.witchica.quarries.block.QuarryBlock;
import com.witchica.quarries.block.entity.QuarryBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(QuirkyQuarries.MOD_ID)
public class QuirkyQuarries {
    public static final String MOD_ID = "quirky_quarries";
    public static final Logger LOGGER = LogUtils.getLogger();

    /**
     * REGISTRIES
     */
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);


    /**
     * BLOCKS
     */
    public static final RegistryObject<Block> STONE_QUARRY = BLOCKS.register("stone_quarry", () -> new QuarryBlock(BlockBehaviour.Properties.of(), 0));

    /**
     * ITEMS
     */
    public static final RegistryObject<Item> STONE_QUARRY_ITEM = ITEMS.register("stone_quarry", () -> new BlockItem(STONE_QUARRY.get(), new Item.Properties()));

    /**
     * CREATIVE MODE TABS
     */
    public static final RegistryObject<CreativeModeTab> QUIRKY_QUARRIES_TAB = CREATIVE_MODE_TABS.register(MOD_ID + "_general", () -> {
       return CreativeModeTab.builder()
               .icon(() -> new ItemStack(STONE_QUARRY.get(), 1))
               .title(Component.translatable("itemGroup.quirky_quarries.general"))
               .displayItems(QuirkyQuarries::tabDisplayItems).build();
    });

    /**
     * BLOCK ENTITY TYPES
     */

    public static final RegistryObject<BlockEntityType<QuarryBlockEntity>> QUARRY_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register("quarry_block", () -> BlockEntityType.Builder.of(QuarryBlockEntity::new, STONE_QUARRY.get()).build(null));

    private static void tabDisplayItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
        output.accept(STONE_QUARRY.get());
    }
    public QuirkyQuarries() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

    }
}
