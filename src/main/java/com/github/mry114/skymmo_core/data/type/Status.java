package com.github.mry114.skymmo_core.data.type;

public enum Status {
    //戦闘
    //実数
    ATTACK("Attack", false),
    DEFENCE("Defence", false),
    HP("HP", false),
    MP("MP", false),

    //パーセント
    ATTACK_PERCENT("Attack Percent", true),
    DEFENCE_PERCENT("Defence Percent", true),
    HP_PERCENT("HP Percent", true),
    MP_PERCENT("MP Percent", true),

    ATTACK_SPEED("Attack Speed", true),
    CRITICAL_DAMAGE("Critical Damage", true),
    CRITICAL_CHANCE("Critical Chance", true),

    //採掘
    MINING_FORTUNE("Mining Fortune", false),
    MINING_POWER("Mining Power", false),

    //農業
    FARMING_FORTUNE("Farming Fortune", false),

    //林業
    FORAGING_FORTUNE("Foraging Fortune", false),

    //釣り
    FISHING_FORTUNE("Fishing Fortune", false),
    FISHING_POWER("Fishing Power", false),

    //総合的動作影響
    MOVE_SPEED("Move Speed", true),
    JUMP_POWER("Jump Power", true)
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
