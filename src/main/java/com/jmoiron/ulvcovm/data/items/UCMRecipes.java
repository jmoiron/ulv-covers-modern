package com.jmoiron.ulvcovm.data.items;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.jmoiron.ulvcovm.Config;
import com.jmoiron.ulvcovm.UCMCore;
import com.jmoiron.ulvcovm.data.covers.CoverItems;

import net.minecraft.data.recipes.FinishedRecipe;

public class UCMRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        if (Config.easyRecipes) {
            initEasy(provider);
        } else {
            initNormal(provider);
        }

        initCovers(provider);
    }

    public static void initEasy(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider,  UCMCore.id("ulv_electric_motor"), UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            "CR ",
            "MC ",
            "   ",
            'C', new MaterialEntry(wireGtSingle, Tin),
            'R', new MaterialEntry(rod, Copper),
            'M', new MaterialEntry(rod, IronMagnetic)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_electric_piston"), UCMComponents.ULV_ELECTRIC_PISTON.asStack(),
            "PR ",
            "MG ",
            "   ",
            'P', new MaterialEntry(plate, Copper),
            'R', new MaterialEntry(rod, Copper),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'G', new MaterialEntry(gearSmall, Copper)
        );

    }

    public static void initNormal(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_electric_motor"), UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            "CWR",
            "WMW",
            "RWC",
            'C', new MaterialEntry(cableGtSingle, Lead),
            'W', new MaterialEntry(wireGtSingle, Tin),
            'R', new MaterialEntry(rod, Copper),
            'M', new MaterialEntry(rod, IronMagnetic)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_electric_piston"), UCMComponents.ULV_ELECTRIC_PISTON.asStack(),
            "PPP",
            "CRR",
            "CMG",
            'P', new MaterialEntry(plate, Copper),
            'C', new MaterialEntry(cableGtSingle, Lead),
            'R', new MaterialEntry(rod, Copper),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'G', new MaterialEntry(gearSmall, Copper)
        );
    }

    public static void initCovers(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_electric_conveyor"), CoverItems.CONVEYOR_MODULE_ULV.asStack(),
            "RRR",
            "MCM",
            "RRR",
            'R', GTItems.STICKY_RESIN.asStack(),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'C', new MaterialEntry(cableGtSingle, Lead)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_electric_pump"), CoverItems.ELECTRIC_PUMP_ULV.asStack(),
            "SFR",
            "sPw",
            "RMC",
            'S', new MaterialEntry(screw, Copper),
            'R', new MaterialEntry(ring, Rubber),
            'F', new MaterialEntry(rotor, Copper),
            'P', new MaterialEntry(pipeNormalFluid, Copper),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'C', new MaterialEntry(cableGtSingle, Lead)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_robot_arm"), CoverItems.ROBOT_ARM_ULV.asStack(),
            "CCC",
            "MRM",
            "PVR",
            'R', new MaterialEntry(rod, Copper),
            'C', new MaterialEntry(cableGtSingle, Lead),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'P', UCMComponents.ULV_ELECTRIC_PISTON.asStack(),
            'V', CustomTags.ULV_CIRCUITS
        );

        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_fluid_regulator"), CoverItems.FLUID_REGULATOR_ULV.asStack(),
            "SFR",
            "sPw",
            "RMC",
            'S', new MaterialEntry(screw, Copper),
            'R', CustomTags.ULV_CIRCUITS,
            'F', new MaterialEntry(rotor, Copper),
            'P', CoverItems.ELECTRIC_PUMP_ULV.asStack(),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'C', new MaterialEntry(cableGtSingle, Lead)
        );
    }
}
