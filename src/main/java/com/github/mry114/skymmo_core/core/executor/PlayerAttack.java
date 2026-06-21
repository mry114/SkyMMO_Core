package com.github.mry114.skymmo_core.core.executor;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.core.event.PlayerAttackedEntityEvent;
import com.github.mry114.skymmo_core.core.event.PlayerDamageByEntityEvent;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import com.github.mry114.skymmo_core.core.player.modify.StatusModify;
import com.github.mry114.skymmo_core.core.player.status.PlayerMergeStatus;
import com.github.mry114.skymmo_core.core.player.status.PlayerStatusContainer;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import com.github.mry114.skymmo_core.handler.mob.MobStatusKeys;
import com.github.mry114.skymmo_core.model.status.PlayerStatus;
import com.github.mry114.skymmo_core.model.status.Status;
import com.github.mry114.skymmo_core.util.DamageIndicator;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.*;

public class PlayerAttack {
    private final Player player;
    private final Entity target;
    private final StatusContainer status;
    private final List<StatusModify> modify;

    public PlayerAttack(Player player, Entity target) {
        UUID uuid = player.getUniqueId();
        List<StatusModify> modify = new ArrayList<>();

        this.player = player;
        this.target = target;
        this.status = SkyMMO_Core.statusCache.getPlayerStatus(uuid);

        for (ElementData data : SkyMMO_Core.elementCache.getPlayerElementList(uuid)) {
            modify.addAll(data.getStatusModify());
        }
        this.modify = modify;
    }

    public void execute() {
        PlayerAttackedEntityEvent attackedEvent = new PlayerAttackedEntityEvent(player, target, status, modify);
        Bukkit.getPluginManager().callEvent(attackedEvent);
        if (attackedEvent.isCancelled()) {
            return;
        }

        PlayerStatusContainer statusContainer = calculatePlayerStatus();

        PlayerDamageByEntityEvent damageEvent = new PlayerDamageByEntityEvent(
                player,
                target,
                statusContainer.get(PlayerStatus.DAMAGE),
                statusContainer.get(PlayerStatus.CRITICAL_CHANCE),
                statusContainer.get(PlayerStatus.CRITICAL_DAMAGE)
        );

        Bukkit.getPluginManager().callEvent(damageEvent);
        if (damageEvent.isCancelled()) {
            return;
        }

        PDCWrapper pdc = new PDCWrapper(target);
        double damage = damageEvent.getDamage();
        double critChance = damageEvent.getCriticalChance();
        double critDamage = damageEvent.getCriticalDamage();
        boolean critical = false;

        if (Math.random() < critChance) {
            damage = damage * critDamage;
            critical = true;
        }

        DamageIndicator.spawn(target, damage, critical);
        pdc.set(MobStatusKeys.PDC_MOB_HP, pdc.get(MobStatusKeys.PDC_MOB_HP) - damage);
    }

    private PlayerStatusContainer calculatePlayerStatus() {
        PlayerStatusContainer statusContainer = new PlayerStatusContainer.Builder()
                .add(PlayerStatus.DAMAGE, status.get(Status.DAMAGE) * (status.get(Status.DAMAGE_PERCENT) + 1.0))
                .add(PlayerStatus.CRITICAL_DAMAGE, status.get(Status.CRITICAL_DAMAGE) + 1.0)
                .add(PlayerStatus.CRITICAL_CHANCE, status.get(Status.CRITICAL_CHANCE) + 1.0)
                .build();

        return new PlayerMergeStatus(statusContainer, modify).merge();
    }
}
