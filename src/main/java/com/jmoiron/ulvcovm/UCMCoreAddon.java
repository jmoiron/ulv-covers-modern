package com.jmoiron.ulvcovm;

import java.util.function.Consumer;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.jmoiron.ulvcovm.data.covers.Covers;
import com.jmoiron.ulvcovm.data.items.UCMRecipes;
import com.jmoiron.ulvcovm.registry.UCMRegistries;

import net.minecraft.data.recipes.FinishedRecipe;

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
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        UCMRecipes.init(provider);
    }
    
    @Override
    public void registerCovers() {
        GTRegistries.COVERS.register(Covers.ULV_PUMP.id, Covers.ULV_PUMP.definition);
        GTRegistries.COVERS.register(Covers.ULV_CONVEYOR.id, Covers.ULV_CONVEYOR.definition);
        GTRegistries.COVERS.register(Covers.ULV_FLUID_REGULATOR.id, Covers.ULV_FLUID_REGULATOR.definition);
        GTRegistries.COVERS.register(Covers.ULV_ROBOT_ARM.id, Covers.ULV_ROBOT_ARM.definition);
    }
}
