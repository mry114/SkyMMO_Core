package com.github.mry114.skymmo_core.util;

import com.github.mry114.skymmo_core.api.Status;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public final class StatusContainer {
    private final Map<Status, Double> stats;

    public static final StatusContainer EMPTY = new StatusContainer(Map.of());

    private StatusContainer(Map<Status, Double> stats) {
        this.stats = Collections.unmodifiableMap(new EnumMap<>(stats));
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
