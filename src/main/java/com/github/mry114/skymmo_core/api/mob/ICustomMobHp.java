package com.github.mry114.skymmo_core.api.mob;

public interface ICustomMobHp extends ICustomMob {
    double getHp();

    boolean getHpRecovery();

    double recoveryValue();
}
