package com.github.mry114.skymmo_core.api.item.can;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public interface IItemSkill {
    List<Component> getSkillLore();

    void onSkillAction(PlayerInteractEvent event);

    boolean getSkillCanUse(Player player);
}
