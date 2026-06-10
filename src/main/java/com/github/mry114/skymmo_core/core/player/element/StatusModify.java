package com.github.mry114.skymmo_core.core.player.element;

import com.github.mry114.skymmo_core.data.player.PlayerStatus;

public record StatusModify(Operator operator, PlayerStatus targetStatusType, Double value) {
    public enum Operator {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
    }
}
