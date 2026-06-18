package com.github.mry114.skymmo_core.api.player.data;

import com.github.mry114.skymmo_core.api.system.IIgniterEvent;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public interface IStatusCollectorModule extends IIgniterEvent {
    @Nullable StatusContainer getStatusData(Player player);
}
