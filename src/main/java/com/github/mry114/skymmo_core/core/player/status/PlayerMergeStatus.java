package com.github.mry114.skymmo_core.core.player.status;

import com.github.mry114.skymmo_core.core.player.modify.StatusModify;
import com.github.mry114.skymmo_core.model.status.PlayerStatus;
import com.github.mry114.skymmo_core.util.Operator;

import java.util.List;

public class PlayerMergeStatus {
    private final PlayerStatusContainer baseContainer;
    private final List<StatusModify> modify;

    public PlayerMergeStatus(PlayerStatusContainer baseContainer, List<StatusModify> modify) {
        this.baseContainer = baseContainer;
        this.modify = modify;
    }

    public PlayerStatusContainer merge() {
        if (this.baseContainer == null) {
            return PlayerStatusContainer.EMPTY;
        }
        if (this.modify == null || this.modify.isEmpty()) {
            return this.baseContainer;
        }

        PlayerStatusContainer.Builder builder = new PlayerStatusContainer.Builder();

        for (PlayerStatus type : PlayerStatus.values()) {
            double result = this.baseContainer.get(type);

            // 1. 加減算
            for (StatusModify mod : this.modify) {
                if (mod == null || mod.targetStatusType() != type || mod.value() == null || mod.operator() == null) {
                    continue;
                }
                if (mod.operator() == Operator.ADDITION) {
                    result += mod.value();
                } else if (mod.operator() == Operator.SUBTRACTION) {
                    result -= mod.value();
                }
            }

            for (StatusModify mod : this.modify) {
                if (mod == null || mod.targetStatusType() != type || mod.value() == null || mod.operator() == null) {
                    continue;
                }
                if (mod.operator() == Operator.MULTIPLICATION) {
                    result *= mod.value();
                } else if (mod.operator() == Operator.DIVISION) {
                    if (mod.value() != 0) {
                        result /= mod.value();
                    }
                }
            }

            if (result != 0 || this.baseContainer.get(type) != 0) {
                builder.add(type, result);
            }
        }

        return builder.build();
    }
}
