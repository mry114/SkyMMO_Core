package com.github.mry114.skymmo_core.core.type.item;

import com.github.mry114.skymmo_core.api.item.diff.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.diff.can.IUseRequirement;
import com.github.mry114.skymmo_core.api.item.diff.can.ItemSkill;
import com.github.mry114.skymmo_core.api.item.diff.can.UseRequirement;
import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemAttribute;
import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemRequirement;
import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemSkill;
import com.github.mry114.skymmo_core.api.item.diff.equipment.IEquipmentItem;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import com.github.mry114.skymmo_core.api.type.IAttributeType;
import com.github.mry114.skymmo_core.data.attribute.AttributeType;
import com.github.mry114.skymmo_core.data.item.context.attribute.ItemAttributeModule;
import com.github.mry114.skymmo_core.data.item.context.basic.equipment.base_status.ItemBaseStatusModule;
import com.github.mry114.skymmo_core.data.item.context.basic.name.ItemNameModule;
import com.github.mry114.skymmo_core.data.item.context.basic.rarity.ItemRarityModule;
import com.github.mry114.skymmo_core.data.item.context.skill.ItemSkillModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class ArmorItem implements IEquipmentItem, ICustomItemRequirement, ICustomItemSkill, ICustomItemAttribute {


    private final UseRequirement useRequirement;

    private final ItemSkill itemSkill;

    public ArmorItem(UseRequirement useRequirement,  ItemSkill itemSkill) {
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
    public @Nullable List<IAttributeType<? extends Enum<?>>> canAttributeType() {
        return List.of(
                AttributeType.ALL
        );
    }

    @Override
    public @NotNull List<IItemModule> getProcessorModule() {
        return List.of(
                ItemNameModule.getInstance(),
                ItemBaseStatusModule.getInstance(),
                ItemAttributeModule.getInstance(),
                ItemSkillModule.getInstance(),
                ItemRarityModule.getInstance()
        );
    }
}
