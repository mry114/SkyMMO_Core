package com.github.mry114.skymmo_core.api.item.diff.can;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IItemSkill {
    @NotNull List<Component> getSkillLore();

    void onSkillAction(PlayerInteractEvent event);

    boolean getSkillCanUse(Player player);

    boolean getExistence();
}
