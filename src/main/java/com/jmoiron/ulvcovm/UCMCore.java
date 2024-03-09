package com.jmoiron.ulvcovm;

import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.jmoiron.ulvcovm.covers.CoverItems;
import com.jmoiron.ulvcovm.data.UCMDatagen;
import com.jmoiron.ulvcovm.registry.UCMCreativeModeTabs;
import com.jmoiron.ulvcovm.registry.UCMRegistries;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UCMCore.MOD_ID)
public class UCMCore {
    public static final String MOD_ID = "ulvcovm";

    private static final Logger LOGGER = LogUtils.getLogger();

    public UCMCore()
    {
        UCMCore.init();
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);
    }

    public static void init() {
        ConfigHolder.init();

        LOGGER.info("initializing quantum skies coremod");
        CoverItems.init();
        UCMCreativeModeTabs.init();
        UCMDatagen.init();

        UCMRegistries.REGISTRATE.registerRegistrate();
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(MOD_ID, FormattingUtil.toLowerCaseUnder(name));
    }
}
