package com.jmoiron.ulvcovm.registry;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.jmoiron.ulvcovm.UCMCore;
import com.jmoiron.ulvcovm.covers.CoverItems;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class UCMCreativeModeTabs {
    @SuppressWarnings("null")
    public static RegistryEntry<CreativeModeTab> ITEM = UCMRegistries.REGISTRATE.defaultCreativeTab(UCMCore.MOD_ID,
            builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(UCMCore.MOD_ID, UCMRegistries.REGISTRATE))
                    .icon(CoverItems.ELECTRIC_PUMP_ULV::asStack)
                    .title(Component.literal("Quantum Skies Core"))
                    .build())
            .register();

    public static void init() {

    }
}