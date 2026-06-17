package com.github.mry114.skymmo_core.handler.player.element.module;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemPassive;
import com.github.mry114.skymmo_core.api.player.IElementCollectorModule;
import com.github.mry114.skymmo_core.api.player.IEquipmentSlot;
import com.github.mry114.skymmo_core.api.system.IIgniterEvent;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import com.github.mry114.skymmo_core.handler.item.context.MainModuleKeys;
import com.github.mry114.skymmo_core.handler.item.context.enchant.ItemEnchantModuleKeys;
import com.github.mry114.skymmo_core.handler.pdc.converter.EnchantConvertData;
import com.github.mry114.skymmo_core.registry.ItemRegistry;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EquipmentDataCollectorModule implements IElementCollectorModule, IIgniterEvent {
    @Override
    public @Nullable List<ElementData> getElementData(Player player) {
        List<IEquipmentSlot> slots = new ArrayList<>();
        ClassLoader serverClassLoader = player.getServer().getPluginManager().getClass().getClassLoader();

        try (io.github.classgraph.ScanResult scanResult = new io.github.classgraph.ClassGraph()
                .acceptPackages("com.github.mry114.skymmo_core")
                .addClassLoader(serverClassLoader)
                .scan()) {

            List<Class<IEquipmentSlot>> slotClasses = scanResult
                    .getClassesImplementing(IEquipmentSlot.class.getName())
                    .getStandardClasses()
                    .loadClasses(IEquipmentSlot.class);

            for (Class<IEquipmentSlot> clazz : slotClasses) {
                try {
                    if (!java.lang.reflect.Modifier.isAbstract(clazz.getModifiers())) {
                        slots.add(clazz.getDeclaredConstructor().newInstance());
                    }
                } catch (Exception ignored) {}
            }
        }

        List<ElementData> dataList = new ArrayList<>();

        for (IEquipmentSlot slot : slots) {
            ItemStack itemStack = player.getInventory().getItem(slot.slotIndex());
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                continue;
            }

            PDCWrapper pdc = new PDCWrapper(itemStack.getItemMeta());
            if (pdc.get(MainModuleKeys.PDC_ITEM_ID) == null) {
                ICustomItem customItem = ItemRegistry.getById(pdc.get(MainModuleKeys.PDC_ITEM_ID));
                if (customItem instanceof ICustomItemPassive passive) {
                    for (ElementData elementData : passive.getPassiveElementData()) {
                        if (elementData == null) break;
                        dataList.add(elementData);
                    }
                }
            }

            List<EnchantConvertData> enchantConvertDats = pdc.get(ItemEnchantModuleKeys.PDC_ENCHANT_DATA);
            if (enchantConvertDats != null) {
                for (EnchantConvertData enchantConvertData : enchantConvertDats) {
                    dataList.addAll(enchantConvertData.getEnchant().getElements(enchantConvertData.getLevel()));
                }
            }
        }

        return dataList;
    }
}
