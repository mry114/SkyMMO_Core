package com.github.mry114.skymmo_core.core.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerDamageByEntityEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final Entity target;
    private double damage;
    private double criticalChance;
    private double criticalDamage;


    private boolean cancelled = false;

    public PlayerDamageByEntityEvent(Player player, Entity target, double damage, double criticalChance, double criticalDamage) {
        this.player = player;
        this.target = target;
        this.damage = damage;
        this.criticalChance = criticalChance;
        this.criticalDamage = criticalDamage;
    }

    public Player getPlayer() {
        return player;
    }

    public Entity getTarget() {
        return target;
    }

    public double getDamage() {
        return damage;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public double getCriticalDamage() {
        return criticalDamage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }

    public void setCriticalDamage(double criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
