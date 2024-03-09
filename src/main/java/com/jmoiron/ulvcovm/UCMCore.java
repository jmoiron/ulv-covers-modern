package com.jmoiron.ulvcovm;

import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.jmoiron.ulvcovm.data.UCMDatagen;
import com.jmoiron.ulvcovm.data.covers.CoverItems;
import com.jmoiron.ulvcovm.data.items.UCMComponents;
import com.jmoiron.ulvcovm.registry.UCMCreativeModeTabs;
import com.jmoiron.ulvcovm.registry.UCMRegistries;
import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Copper;

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

        //LOGGER.info("initializing ulv covers modern");
        UCMCreativeModeTabs.init();

        CoverItems.init();
        UCMComponents.init();

        UCMDatagen.init();

        UCMRegistries.REGISTRATE.registerRegistrate();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(MOD_ID, FormattingUtil.toLowerCaseUnder(name));
    }

    @SubscribeEvent
    public void modifyMaterials(PostMaterialEvent event) {
        // add copper stuff
        Copper.addFlags(
            MaterialFlags.GENERATE_SMALL_GEAR, 
            MaterialFlags.GENERATE_ROTOR, 
            MaterialFlags.GENERATE_BOLT_SCREW
        );
    }
}
