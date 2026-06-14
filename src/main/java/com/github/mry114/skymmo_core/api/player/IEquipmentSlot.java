package com.github.mry114.skymmo_core.api.player;

import com.github.mry114.skymmo_core.api.item.diff.equipment.IEquipmentItem;
import org.bukkit.entity.Player;

public interface IEquipmentSlot {
    int slotIndex();

    boolean canEquipped(IEquipmentItem item, Player player);
}
