package com.github.mry114.skymmo_core.handler.mob.module.name;

import com.github.mry114.skymmo_core.api.mob.ICustomMob;
import com.github.mry114.skymmo_core.api.mob.ICustomMobHp;
import com.github.mry114.skymmo_core.api.mob.module.IMobModule;
import com.github.mry114.skymmo_core.handler.mob.MobMainModuleKeys;
import com.github.mry114.skymmo_core.handler.mob.MobStatusKeys;
import com.github.mry114.skymmo_core.register.content.MobRegistry;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;

public class MobNameModule implements IMobModule {
    private static final MobNameModule INSTANCE = new MobNameModule();

    public static MobNameModule getInstance() {
        return INSTANCE;
    }

    @Override
    public void livingEntityProcess(ICustomMob customMob, LivingEntity livingEntity, PDCWrapper pdc) {
        displayName(livingEntity);
    }

    @Override
    public void MobDamageEvent(EntityDamageEvent event) {
        displayName((LivingEntity) event.getEntity());
    }

    public void displayName(LivingEntity entity) {
        PDCWrapper pdc = new PDCWrapper(entity);
        ICustomMob customMob = MobRegistry.getById(pdc.get(MobMainModuleKeys.PDC_MOB_ID));
        if (customMob instanceof ICustomMobHp hp) {
            entity.customName(customMob.getName().append(Component.text(" ❤" + pdc.get(MobStatusKeys.PDC_MOB_HP) + "/" + hp.getHp(), TextColor.color(240, 94, 102))));
        }
    }
}
