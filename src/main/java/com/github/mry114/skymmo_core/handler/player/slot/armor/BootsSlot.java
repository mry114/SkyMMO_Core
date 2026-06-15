package com.github.mry114.skymmo_core.handler.player.slot.armor;

import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemRequirement;
import com.github.mry114.skymmo_core.api.item.diff.equipment.IEquipmentItem;
import com.github.mry114.skymmo_core.api.player.IEquipmentSlot;
import com.github.mry114.skymmo_core.model.item.type.ArmorType;
import org.bukkit.entity.Player;

public class BootsSlot implements IEquipmentSlot {
    @Override
    public int slotIndex() {
        return 100;
    }

    @Override
    public boolean canEquipped(IEquipmentItem item, Player player) {
        if (item instanceof ICustomItemRequirement requirement) {
            return item.getItemType() == ArmorType.BOOTS && requirement.getRequirement().getItemCanUse(player);
        }
        else return false;
    }
}
