package com.github.mry114.skymmo_core.handler.player.collector;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.api.player.data.IStatusCollectorModule;
import com.github.mry114.skymmo_core.api.system.IIgniterEvent;
import com.github.mry114.skymmo_core.core.item.reader.ItemStatusReader;
import com.github.mry114.skymmo_core.core.player.collector.StatusCollector;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ItemMainHandDataCollectorModule implements IStatusCollectorModule {
    @Override
    public @Nullable StatusContainer getStatusData(Player player) {
        return ItemStatusReader.read(player.getInventory().getItemInMainHand());
    }

    @Override
    public void playerItemHeldEvent(PlayerItemHeldEvent event) {
        UUID playerUUID = event.getPlayer().getUniqueId();

        Bukkit.getScheduler().runTask(SkyMMO_Core.getPlugin(SkyMMO_Core.class), () -> {
            Player currentPlayer = Bukkit.getPlayer(playerUUID);

            if (currentPlayer == null || !currentPlayer.isOnline()) {
                return;
            }
            StatusCollector.collectStatus(currentPlayer);
        });
    }
}
