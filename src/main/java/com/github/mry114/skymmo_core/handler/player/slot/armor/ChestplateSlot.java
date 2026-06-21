package com.github.mry114.skymmo_core.handler.player.slot.armor;

import com.github.mry114.skymmo_core.api.item.content.capa.ICustomItemRequirement;
import com.github.mry114.skymmo_core.api.item.content.equipment.IEquipmentItem;
import com.github.mry114.skymmo_core.api.player.IEquipmentSlot;
import com.github.mry114.skymmo_core.model.item.type.ArmorType;
import org.bukkit.entity.Player;

public class ChestplateSlot implements IEquipmentSlot {
    @Override
    public int slotIndex() {
        return 102;
    }

    @Override
    public boolean canEquipped(IEquipmentItem item, Player player) {
        if (item instanceof ICustomItemRequirement requirement) {
            return item.getItemType() == ArmorType.CHESTPLATE && requirement.getRequirement().getItemCanUse(player);
        }
        else return false;
    }
}
