package com.jmoiron.ulvcovm;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.jmoiron.ulvcovm.covers.Covers;
import com.jmoiron.ulvcovm.registry.UCMRegistries;

@GTAddon
public class UCMCoreAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return UCMRegistries.REGISTRATE;
    }

    @Override
    public void initializeAddon() {
    }

    @Override
    public String addonModId() {
        return UCMCore.MOD_ID;
    }
    
    @Override
    public void registerCovers() {
        GTRegistries.COVERS.register(Covers.ULV_PUMP.id, Covers.ULV_PUMP.definition);
        GTRegistries.COVERS.register(Covers.ULV_CONVEYOR.id, Covers.ULV_CONVEYOR.definition);
        GTRegistries.COVERS.register(Covers.ULV_FLUID_REGULATOR.id, Covers.ULV_FLUID_REGULATOR.definition);
        GTRegistries.COVERS.register(Covers.ULV_ROBOT_ARM.id, Covers.ULV_ROBOT_ARM.definition);
    }
}
