package com.github.mry114.skymmo_core.api.system;

import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface IIgniterEvent {
    default void playerAttackedEntityEvent(EntityDamageByEntityEvent event) {}

    default void entityAttackedPlayerEvent(EntityDamageByEntityEvent event) {}
}
