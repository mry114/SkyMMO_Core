package com.github.mry114.skymmo_core.core.player.element.module;

import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemPassive;
import com.github.mry114.skymmo_core.api.player.IElementCollectorModule;
import com.github.mry114.skymmo_core.api.player.IEquipmentSlot;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import com.github.mry114.skymmo_core.data.item.context.basic.MainModuleKeys;
import com.github.mry114.skymmo_core.registry.ItemRegistry;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class EquipmentDataCollectorModule implements IElementCollectorModule {
    @Override
    public @Nullable List<ElementData> getElementData(Player player) {
        ServiceLoader<IEquipmentSlot> slots = ServiceLoader.load(IEquipmentSlot.class);
        List<ElementData> dataList = new ArrayList<>();

        for (IEquipmentSlot slot : slots) {
            ItemStack itemStack = player.getInventory().getItem(slot.slotIndex());
            if (itemStack == null) {
                continue;
            }

            PDCWrapper pdc = new PDCWrapper(itemStack.getItemMeta());
            if (ItemRegistry.getById(pdc.get(MainModuleKeys.PDC_ITEM_ID)) instanceof ICustomItemPassive passive) {

                for (ElementData elementData : passive.getPassiveElementData()) {
                    if (elementData == null) break;
                    dataList.add(elementData);
                }
            }
        }

        return dataList;
    }
}
