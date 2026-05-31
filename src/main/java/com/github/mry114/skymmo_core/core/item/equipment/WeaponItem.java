package com.github.mry114.skymmo_core.core.item.equipment;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.item.equipment.capa.IEquipmentMainStatus;
import com.github.mry114.skymmo_core.api.item.IItemProcessorModule;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class WeaponItem implements IEquipmentMainStatus {

    @Override
    public @NotNull List<IItemProcessorModule> getProcessorModule() {
        return List.of(

        );
    }
}
