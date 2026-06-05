package com.github.mry114.skymmo_core.core.status;

import com.github.mry114.skymmo_core.data.Status;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public record StatusContainer(Map<Status, Double> stats) {
    public static final StatusContainer EMPTY = new StatusContainer(Map.of());

    public StatusContainer {
        stats = Collections.unmodifiableMap(
                stats.isEmpty() ? new EnumMap<>(Status.class) : new EnumMap<>(stats)
        );
    }

    public double get(Status type) {
        return stats.getOrDefault(type, 0.0);
    }

    public StatusContainer marge(StatusContainer other) {
        Map<Status, Double> newStats = new EnumMap<>(Status.class);

        for (Status type : Status.values()) {
            double total = this.get(type) + other.get(type);
            if (total != 0) {
                newStats.put(type, total);
            }
        }
        return new StatusContainer(newStats);
    }

    public static class Builder {
        private final Map<Status, Double> tempStats = new EnumMap<>(Status.class);

        public Builder add(Status type, double value) {
            tempStats.put(type, tempStats.getOrDefault(type, 0.0) + value);
            return this;
        }

        public StatusContainer build() {
            return new StatusContainer(tempStats);
        }
    }
}
