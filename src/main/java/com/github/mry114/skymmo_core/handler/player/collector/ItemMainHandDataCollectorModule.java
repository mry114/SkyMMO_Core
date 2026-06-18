package com.github.mry114.skymmo_core.handler.player.collector;

import com.github.mry114.skymmo_core.api.player.data.IStatusCollectorModule;
import com.github.mry114.skymmo_core.core.item.reader.ItemStatusReader;
import com.github.mry114.skymmo_core.core.player.collector.StatusCollector;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.jetbrains.annotations.Nullable;

public class ItemMainHandDataCollectorModule implements IStatusCollectorModule {
    @Override
    public @Nullable StatusContainer getStatusData(Player player) {
        player.sendMessage("メインハンド取得動作確認！");
        return ItemStatusReader.read(player.getInventory().getItemInMainHand());
    }

    @Override
    public void playerItemHeldEvent(PlayerItemHeldEvent event) {
        StatusCollector.collectStatus(event.getPlayer());
    }
}
