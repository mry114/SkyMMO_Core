package com.github.mry114.skymmo_core.handler.mob.module.hp;

import com.github.mry114.skymmo_core.api.mob.ICustomMob;
import com.github.mry114.skymmo_core.api.mob.ICustomMobHp;
import com.github.mry114.skymmo_core.api.mob.module.IMobModule;
import com.github.mry114.skymmo_core.handler.mob.MobStatusKeys;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.entity.Entity;

public class MobHpModule implements IMobModule {
    private static final MobHpModule INSTANCE = new MobHpModule();

    public static MobHpModule getInstance() {
        return INSTANCE;
    }

    @Override
    public void entitySetup(ICustomMob customMob, Entity entity, PDCWrapper pdc) {
        if (customMob instanceof ICustomMobHp customMobHp) {
            pdc.set(MobStatusKeys.PDC_MOB_HP, customMobHp.getHp());
        }
    }
}
