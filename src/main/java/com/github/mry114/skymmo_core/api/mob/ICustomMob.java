package com.github.mry114.skymmo_core.api.mob;

import com.github.mry114.skymmo_core.api.mob.module.IMobModule;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ICustomMob {
    int getId();

    Component getName();

    @NotNull EntityType getType();

    @NotNull List<IMobModule> getProcessorModule();
}
