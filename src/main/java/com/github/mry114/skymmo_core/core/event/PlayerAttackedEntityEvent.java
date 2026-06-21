package com.github.mry114.skymmo_core.core.event;

import com.github.mry114.skymmo_core.core.player.modify.StatusModify;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlayerAttackedEntityEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Entity target;
    private final StatusContainer playerStatus;
    private final List<StatusModify> playerStatusModify;

    private boolean cancelled = false;

    public PlayerAttackedEntityEvent(Player player, Entity target, StatusContainer playerStatus, List<StatusModify> playerStatusModify) {
        this.player = player;
        this.target = target;
        this.playerStatus = playerStatus;
        this.playerStatusModify = playerStatusModify;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public Player getPlayer() {
        return player;
    }

    public Entity getTarget() {
        return target;
    }

    public StatusContainer getPlayerStatus() {
        return playerStatus;
    }

    public List<StatusModify> getPlayerStatusModify() {
        return playerStatusModify;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
