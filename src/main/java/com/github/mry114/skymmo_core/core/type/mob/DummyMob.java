package com.github.mry114.skymmo_core.core.type.mob;

import com.github.mry114.skymmo_core.api.mob.ICustomMobHp;

public abstract class DummyMob implements ICustomMobHp {
    @Override
    public double getHp() {
        return 1_000_000d;
    }

    @Override
    public boolean getHpRecovery() {
        return true;
    }

    @Override
    public double recoveryValue() {
        return 114_514d;
    }
}
