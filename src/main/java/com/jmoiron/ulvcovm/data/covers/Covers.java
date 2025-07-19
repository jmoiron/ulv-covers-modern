package com.jmoiron.ulvcovm.data.covers;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.common.cover.*;
import com.jmoiron.ulvcovm.UCMCore;
import com.gregtechceu.gtceu.client.renderer.cover.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Covers {

    public static final List<CoverDefinition> ALL_COVERS = new ArrayList<>(4);

    private static IOCoverRenderer CONVEYOR_RENDERER = new IOCoverRenderer(
            GTCEu.id("block/cover/conveyor"),
            null,
            GTCEu.id("block/cover/conveyor_emissive"),
            GTCEu.id("block/cover/conveyor_inverted_emissive"));

    private static IOCoverRenderer ROBOT_ARM_RENDERER = new IOCoverRenderer(
            GTCEu.id("block/cover/arm"),
            null,
            GTCEu.id("block/cover/arm_emissive"),
            GTCEu.id("block/cover/arm_inverted_emissive"));

    public static CoverDefinition ULV_CONVEYOR = registerULV("conveyor", ConveyorCover::new,
            () -> () -> CONVEYOR_RENDERER);

    public static CoverDefinition ULV_PUMP = register("pump", (def, cov, side) ->
                    new PumpCover(def, cov, side, GTValues.ULV, 32),
            () -> () -> IOCoverRenderer.PUMP_LIKE_COVER_RENDERER);

    public static CoverDefinition ULV_ROBOT_ARM = registerULV("robot_arm", RobotArmCover::new,
            () -> () -> ROBOT_ARM_RENDERER);

    public static CoverDefinition ULV_FLUID_REGULATOR = register("fluid_regulator",
            (def, cov, side) -> new FluidRegulatorCover(def, cov, side, GTValues.ULV, 32),
            () -> () -> IOCoverRenderer.PUMP_LIKE_COVER_RENDERER);

    public static CoverDefinition registerULV(
            String id,
            CoverDefinition.TieredCoverBehaviourProvider behavior,
            Supplier<Supplier<ICoverRenderer>> renderer
    ) {
        return register(
                id,
                (def, cov, side) -> behavior.create(def, cov, side, GTValues.ULV),
                renderer);
    }

    public static CoverDefinition register(
            String id,
            CoverDefinition.CoverBehaviourProvider behavior,
            Supplier<Supplier<ICoverRenderer>> renderer
        ) {

        var definition = new CoverDefinition(UCMCore.id(id), behavior, renderer);
        ALL_COVERS.add(definition);
        return definition;
    }
}
