package com.github.mry114.skymmo_core.core.item.type.equipment;

import com.github.mry114.skymmo_core.api.item.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.can.IUseRequirement;
import com.github.mry114.skymmo_core.api.item.can.ItemSkill;
import com.github.mry114.skymmo_core.api.item.can.UseRequirement;
import com.github.mry114.skymmo_core.api.item.capa.ICustomItemRequirement;
import com.github.mry114.skymmo_core.api.item.capa.ICustomItemSkill;
import com.github.mry114.skymmo_core.api.item.equipment.IEquipmentItem;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.data.context.attribute.ItemAttributeModule;
import com.github.mry114.skymmo_core.data.context.basic.equipment.base_status.ItemBaseStatusModule;
import com.github.mry114.skymmo_core.data.context.basic.name.ItemNameModule;
import com.github.mry114.skymmo_core.data.context.basic.rarity.ItemRarityModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class WeaponItem implements IEquipmentItem, ICustomItemRequirement, ICustomItemSkill {

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
    public @NotNull List<IItemModule> getProcessorModule() {
        return List.of(
                ItemNameModule.getInstance(),
                ItemBaseStatusModule.getInstance(),
                ItemAttributeModule.getInstance(),
                ItemRarityModule.getInstance()
        );
    }
}
