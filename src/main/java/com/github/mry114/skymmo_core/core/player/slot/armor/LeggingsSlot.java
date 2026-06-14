package com.github.mry114.skymmo_core.core.player.slot.armor;

import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemRequirement;
import com.github.mry114.skymmo_core.api.item.diff.equipment.IEquipmentItem;
import com.github.mry114.skymmo_core.api.player.IEquipmentSlot;
import com.github.mry114.skymmo_core.data.item.type.ArmorType;
import org.bukkit.entity.Player;

public class LeggingsSlot implements IEquipmentSlot {
    @Override
    public int slotIndex() {
        return 101;
    }

    @Override
    public boolean canEquipped(IEquipmentItem item, Player player) {
        if (item instanceof ICustomItemRequirement requirement) {
            return item.getItemType() == ArmorType.LEGGINGS && requirement.getRequirement().getItemCanUse(player);
        }
        else return false;
    }
}
