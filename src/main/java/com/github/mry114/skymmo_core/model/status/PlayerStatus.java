package com.github.mry114.skymmo_core.model.status;

import org.jetbrains.annotations.NotNull;

public enum PlayerStatus {
    ATTACK("Attack Damage", false),
    DEFENSE("Defense", false),
    HP("HP", false),
    MP("MP", false),

    ATTACK_SPEED("Attack Speed", true),
    CRITICAL_DAMAGE("Critical Damage", true),
    CRITICAL_CHANCE("Critical Chance", true),

    //採掘
    MINING_BONUS("Mining Bonus", false),
    MINING_POWER("Mining Power", false),

    //農業
    FARMING_BONUS("Farming Bonus", false),

    //林業
    FORAGING_BONUS("Foraging Bonus", false),

    //釣り
    FISHING_BONUS("Fishing Bonus", false),
    FISHING_POWER("Fishing Power", false),

    //総合的動作影響
    MOVE_SPEED("Move Speed", true),
    JUMP_POWER("Jump Power", true)
    ;
    @NotNull
    private final String displayName;
    private final boolean isPercent;

    PlayerStatus(@NotNull String displayName, boolean isPercent) {
        this.displayName = displayName;
        this.isPercent = isPercent;
    }

    public @NotNull String getDisplayName() {
        return displayName;
    }

    public boolean getIsPercent() {
        return isPercent;
    }
}
