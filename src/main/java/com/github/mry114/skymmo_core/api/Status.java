package com.github.mry114.skymmo_core.api;

public enum Status {
    //戦闘
    //実数
    ATTACK,
    DEFENCE,
    HP,
    MP,

    //パーセント
    ATTACK_PERCENT,
    DEFENCE_PERCENT,
    HP_PERCENT,
    MP_PERCENT,

    ATTACK_SPEED,
    CRITICAL_DAMAGE,
    CRITICAL_CHANCE,

    //採掘
    MINING_FORTUNE,
    MINING_POWER,

    //農業
    FARMING_FORTUNE,

    //林業
    FORAGING_FORTUNE,

    //釣り
    FISHING_FORTUNE,
    FISHING_POWER,

    //総合的動作影響
    MOVE_SPEED,
    JUMP_POWER
}
