package com.github.mry114.skymmo_core.api.type.status;

import org.jetbrains.annotations.NotNull;

public interface IPlayerStatus<T extends Enum<T> & IPlayerStatus<T>> {
    String name();

    @NotNull String getDisplayName();

    boolean getIsPercent();
}
