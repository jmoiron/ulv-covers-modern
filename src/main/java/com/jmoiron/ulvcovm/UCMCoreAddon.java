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
        for (var cover : Covers.ALL_COVERS) {
            GTRegistries.COVERS.register(cover.getId(), cover);
        }
    }
}
