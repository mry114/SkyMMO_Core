package com.github.mry114.skymmo_core.data.type;

public enum Status {
    //戦闘
    //実数
    ATTACK("Attack", false),
    DEFENCE("Defence", false),
    HP("Hp", false),
    MP("Mp", false),

    //パーセント
    ATTACK_PERCENT("Attack percent", true),
    DEFENCE_PERCENT("Defence percent", true),
    HP_PERCENT("Hp percent", true),
    MP_PERCENT("Mp percent", true),

    ATTACK_SPEED("Attack speed", true),
    CRITICAL_DAMAGE("Critical damage", true),
    CRITICAL_CHANCE("Critical chance", true),

    //採掘
    MINING_FORTUNE("Mining fortune", false),
    MINING_POWER("Mining power", false),

    //農業
    FARMING_FORTUNE("Farming fortune", false),

    //林業
    FORAGING_FORTUNE("Foraging fortune", false),

    //釣り
    FISHING_FORTUNE("Fishing fortune", false),
    FISHING_POWER("Fishing power", false),

    //総合的動作影響
    MOVE_SPEED("Move speed", true),
    JUMP_POWER("Jump power", true)
    ;

    private final String displayName;
    private final boolean isPercent;

    Status(String displayName, boolean isPercent) {
        this.isPercent = isPercent;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean getIsPercent() {
        return isPercent;
    }
}
