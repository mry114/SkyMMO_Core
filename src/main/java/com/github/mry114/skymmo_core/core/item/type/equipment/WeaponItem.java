package com.github.mry114.skymmo_core.core.item.type.equipment;

import com.github.mry114.skymmo_core.api.item.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.can.IUseRequirement;
import com.github.mry114.skymmo_core.api.item.can.ItemSkill;
import com.github.mry114.skymmo_core.api.item.can.UseRequirement;
import com.github.mry114.skymmo_core.api.item.equipment.capa.IEquipmentMainStatus;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.data.context.equipment.ItemBaseStatusModule;
import com.github.mry114.skymmo_core.data.context.main.name.ItemNameModule;
import com.github.mry114.skymmo_core.data.context.main.rarity.ItemRarityModule;
import com.github.mry114.skymmo_core.data.type.ItemType;
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
    public @NotNull ItemType getItemType() {
        return ItemType.WEAPON;
    }

    @Override
    public @NotNull List<IItemModule> getProcessorModule() {
        return List.of(
                ItemNameModule.getInstance(),
                ItemBaseStatusModule.getInstance(),
                ItemRarityModule.getInstance()
        );
    }
}
