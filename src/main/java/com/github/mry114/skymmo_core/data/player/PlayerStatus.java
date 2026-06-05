package com.github.mry114.skymmo_core.data.player;

import com.github.mry114.skymmo_core.api.type.status.IPlayerStatus;
import org.jetbrains.annotations.NotNull;

public enum PlayerStatus implements IPlayerStatus<PlayerStatus> {
    ATTACK("Attack Damage", false),
    DEFENSE("Defense", false),
    HP("HP", false),
    MP("MP", false),

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
    @NotNull
    private final String displayName;
    private final boolean isPercent;

    PlayerStatus(@NotNull String displayName, boolean isPercent) {
        this.displayName = displayName;
        this.isPercent = isPercent;
    }

    @Override
    public @NotNull String getDisplayName() {
        return displayName;
    }

    @Override
    public boolean getIsPercent() {
        return isPercent;
    }
}
