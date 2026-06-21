package com.github.mry114.skymmo_core.api.system;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;

public interface IIgniterEvent {
    default void playerAttackedEntityEvent(EntityDamageByEntityEvent event) {}

    default void entityAttackedPlayerEvent(EntityDamageByEntityEvent event) {}

    default void playerItemHeldEvent(PlayerItemHeldEvent event) {}

    default void MobDamageEvent(EntityDamageEvent event) {}
}
