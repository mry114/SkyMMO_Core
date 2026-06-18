package com.github.mry114.skymmo_core.handler.item.reader;

import com.github.mry114.skymmo_core.api.item.content.diff.equipment.IEquipmentItem;
import com.github.mry114.skymmo_core.api.item.reader.IItemStatusReaderModule;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import com.github.mry114.skymmo_core.handler.item.context.MainModuleKeys;
import com.github.mry114.skymmo_core.register.content.ItemRegistry;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ItemMainStatusReader implements IItemStatusReaderModule {
    @Override
    public @Nullable StatusContainer getStatus(ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return null;
        }

        PDCWrapper pdc = new PDCWrapper(itemStack.getItemMeta());
        if (!(ItemRegistry.getById(pdc.get(MainModuleKeys.PDC_ITEM_ID)) instanceof IEquipmentItem equipmentItem)) {
            return null;
        }

        return equipmentItem.getBaseStatus();
    }
}
