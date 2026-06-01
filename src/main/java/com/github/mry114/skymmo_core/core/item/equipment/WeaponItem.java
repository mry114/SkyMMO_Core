package com.github.mry114.skymmo_core.core.item.equipment;

import com.github.mry114.skymmo_core.api.item.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.can.IUseRequirement;
import com.github.mry114.skymmo_core.api.item.can.ItemSkill;
import com.github.mry114.skymmo_core.api.item.can.UseRequirement;
import com.github.mry114.skymmo_core.api.item.equipment.capa.IEquipmentMainStatus;
import com.github.mry114.skymmo_core.api.item.IItemProcessorModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class WeaponItem implements IEquipmentMainStatus {

    private final UseRequirement useRequirement;

    private final ItemSkill itemSkill;

    public WeaponItem(UseRequirement useRequirement,  ItemSkill itemSkill) {
        this.useRequirement = useRequirement;
        this.itemSkill = itemSkill;
    }

    @Override
    public @Nullable IUseRequirement getRequirement() {
        return useRequirement;
    }

    @Override
    public @Nullable IItemSkill getItemSkill() {
        return itemSkill;
    }

    @Override
    public @NotNull List<IItemProcessorModule> getProcessorModule() {
        return List.of(

        );
    }
}
