package com.github.mry114.skymmo_core.core.player.modify;

import com.github.mry114.skymmo_core.model.status.PlayerStatus;

public record StatusModify(Operator operator, PlayerStatus targetStatusType, Double value) {
    public enum Operator {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
    }
}
