package com.jmoiron.ulvcovm.data.items;

import com.jmoiron.ulvcovm.registry.UCMCreativeModeTabs;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.item.Item;

import static com.jmoiron.ulvcovm.registry.UCMRegistries.REGISTRATE;

public class UCMComponents {
    static {
        REGISTRATE.creativeModeTab(() -> UCMCreativeModeTabs.ITEM);
    }

    public static final ItemEntry<Item> ULV_ELECTRIC_MOTOR = REGISTRATE.item("ulv_electric_motor", Item::new)
        .lang("ULV Electric Motor")
        .register();
    
    public static final ItemEntry<Item> ULV_ELECTRIC_PISTON = REGISTRATE.item("ulv_electric_piston", Item::new)
        .lang("ULV Electric Piston")
        .register();

    public static void init() {}
}
