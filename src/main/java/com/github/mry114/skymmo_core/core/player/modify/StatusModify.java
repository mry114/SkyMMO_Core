package com.github.mry114.skymmo_core.core.player.modify;

import com.github.mry114.skymmo_core.model.status.PlayerStatus;
import com.github.mry114.skymmo_core.util.Operator;

public record StatusModify(Operator operator, PlayerStatus targetStatusType, Double value) {
}
