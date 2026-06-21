package com.github.mry114.skymmo_core.core.factory;

import com.github.mry114.skymmo_core.api.mob.ICustomMob;
import com.github.mry114.skymmo_core.api.mob.module.IMobModule;
import com.github.mry114.skymmo_core.handler.mob.MobMainModuleKeys;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class CustomMobFactory {

    public void spawn(@NotNull ICustomMob customMob, Location location) {
        Entity entity = location.getWorld().spawnEntity(location, customMob.getType());
        PDCWrapper pdc = new PDCWrapper(entity);
        pdc.set(MobMainModuleKeys.PDC_MOB_ID, customMob.getId());

        for (IMobModule module : customMob.getProcessorModule()) {
            module.entitySetup(customMob, entity, pdc);
        }

        for (IMobModule module : customMob.getProcessorModule()) {
            module.entityProcess(customMob, entity, pdc);
        }

        LivingEntity livingEntity = (LivingEntity) entity;

        for (IMobModule module : customMob.getProcessorModule()) {
            module.livingEntityProcess(customMob, livingEntity, pdc);
        }
    }
}
