package com.github.mry114.skymmo_core.api.mob.module;

import com.github.mry114.skymmo_core.api.mob.ICustomMob;
import com.github.mry114.skymmo_core.api.system.IIgniterEvent;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public interface IMobModule extends IIgniterEvent {
    default void entitySetup(ICustomMob customMob, Entity entity, PDCWrapper pdc) {}

    default void entityProcess(ICustomMob customMob, Entity entity, PDCWrapper pdc) {}

    default void livingEntityProcess(ICustomMob customMob, LivingEntity livingEntity, PDCWrapper pdc) {}
}
