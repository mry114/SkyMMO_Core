package com.github.mry114.skymmo_core.core.player.status;

import com.github.mry114.skymmo_core.model.status.PlayerStatus;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public record PlayerStatusContainer(Map<PlayerStatus, Double> stats) {
    public static final PlayerStatusContainer EMPTY = new PlayerStatusContainer(Map.of());

    public PlayerStatusContainer {
        stats = Collections.unmodifiableMap(
                stats.isEmpty() ? new EnumMap<>(PlayerStatus.class) : new EnumMap<>(stats)
        );
    }

    public double get(PlayerStatus type) {
        return stats.getOrDefault(type, 0.0);
    }

    public PlayerStatusContainer marge(PlayerStatusContainer other) {
        Map<PlayerStatus, Double> newStats = new EnumMap<>(PlayerStatus.class);

        for (PlayerStatus type : PlayerStatus.values()) {
            double total = this.get(type) + other.get(type);
            if (total != 0) {
                newStats.put(type, total);
            }
        }
        return new PlayerStatusContainer(newStats);
    }

    public static class Builder {
        private final Map<PlayerStatus, Double> tempStats = new EnumMap<>(PlayerStatus.class);

        public Builder add(PlayerStatus type, double value) {
            tempStats.put(type, tempStats.getOrDefault(type, 0.0) + value);
            return this;
        }

        public PlayerStatusContainer build() {
            return new PlayerStatusContainer(tempStats);
        }
    }
}
