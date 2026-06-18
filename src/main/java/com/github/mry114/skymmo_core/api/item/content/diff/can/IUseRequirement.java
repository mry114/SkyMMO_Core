package com.github.mry114.skymmo_core.api.item.content.diff.can;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.List;

public interface IUseRequirement {
    List<Component> getItemRequirementLore();

    boolean getItemCanUse(Player player);

    boolean getExistence();
}
