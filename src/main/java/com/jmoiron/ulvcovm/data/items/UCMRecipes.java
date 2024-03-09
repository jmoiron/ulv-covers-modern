package com.jmoiron.ulvcovm.data.items;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.jmoiron.ulvcovm.Config;
import com.jmoiron.ulvcovm.UCMCore;
import com.jmoiron.ulvcovm.data.covers.CoverItems;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent.Finish;

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
            'C', new UnificationEntry(wireGtSingle, Tin),
            'R', new UnificationEntry(rod, Copper),
            'M', new UnificationEntry(rod, IronMagnetic)
        );
        
        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_electric_piston"), UCMComponents.ULV_ELECTRIC_PISTON.asStack(),
            "PR ",
            "MG ",
            "   ", 
            'P', new UnificationEntry(plate, Copper),
            'R', new UnificationEntry(rod, Copper),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'G', new UnificationEntry(gearSmall, Copper)
        );

    }

    public static void initNormal(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_electric_motor"), UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            "CWR",
            "WMW",
            "RWC", 
            'C', new UnificationEntry(cableGtSingle, Lead),
            'W', new UnificationEntry(wireGtSingle, Tin),
            'R', new UnificationEntry(rod, Copper),
            'M', new UnificationEntry(rod, IronMagnetic)
        );
        
        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_electric_piston"), UCMComponents.ULV_ELECTRIC_PISTON.asStack(),
            "PPP",
            "CRR",
            "CMG", 
            'P', new UnificationEntry(plate, Copper),
            'C', new UnificationEntry(cableGtSingle, Lead),
            'R', new UnificationEntry(rod, Copper),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'G', new UnificationEntry(gearSmall, Copper)
        );
    }
    
    public static void initCovers(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_electric_conveyor"), CoverItems.CONVEYOR_MODULE_ULV.asStack(),
            "RRR",
            "MCM",
            "RRR",
            'R', GTItems.STICKY_RESIN.asStack(),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'C', new UnificationEntry(cableGtSingle, Lead)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_electric_pump"), CoverItems.ELECTRIC_PUMP_ULV.asStack(),
            "SFR",
            "sPw",
            "RMC",
            'S', new UnificationEntry(screw, Copper),
            'R', new UnificationEntry(ring, Rubber),
            'F', new UnificationEntry(rotor, Copper), 
            'P', new UnificationEntry(pipeNormalFluid, Copper),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'C', new UnificationEntry(cableGtSingle, Lead)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_robot_arm"), CoverItems.ROBOT_ARM_ULV.asStack(),
            "CCC",
            "MRM",
            "PVR",
            'R', new UnificationEntry(rod, Copper),
            'C', new UnificationEntry(cableGtSingle, Lead),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'P', UCMComponents.ULV_ELECTRIC_PISTON.asStack(),
            'V', GTItems.VACUUM_TUBE.asStack()
        );

        VanillaRecipeHelper.addShapedRecipe(provider, UCMCore.id("ulv_fluid_regulator"), CoverItems.FLUID_REGULATOR_ULV.asStack(),
            "SFR",
            "sPw",
            "RMC",
            'S', new UnificationEntry(screw, Copper),
            'R', GTItems.VACUUM_TUBE.asStack(),
            'F', new UnificationEntry(rotor, Copper), 
            'P', CoverItems.ELECTRIC_PUMP_ULV.asStack(),
            'M', UCMComponents.ULV_ELECTRIC_MOTOR.asStack(),
            'C', new UnificationEntry(cableGtSingle, Lead)
        );
    }
}
