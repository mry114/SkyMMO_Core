package com.github.mry114.skymmo_core.core.type.item;

import com.github.mry114.skymmo_core.api.item.content.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.content.can.IUseRequirement;
import com.github.mry114.skymmo_core.core.type.ItemSkill;
import com.github.mry114.skymmo_core.core.type.UseRequirement;
import com.github.mry114.skymmo_core.api.item.content.capa.*;
import com.github.mry114.skymmo_core.api.item.content.equipment.IEquipmentItem;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import com.github.mry114.skymmo_core.api.type.IAttributeType;
import com.github.mry114.skymmo_core.handler.item.context.enchant.ItemEnchantModule;
import com.github.mry114.skymmo_core.model.attribute.AttributeType;
import com.github.mry114.skymmo_core.handler.item.context.attribute.ItemAttributeModule;
import com.github.mry114.skymmo_core.handler.item.context.equipment.base_status.ItemBaseStatusModule;
import com.github.mry114.skymmo_core.handler.item.context.name.ItemNameModule;
import com.github.mry114.skymmo_core.handler.item.context.rarity.ItemRarityModule;
import com.github.mry114.skymmo_core.handler.item.context.skill.ItemSkillModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class ArmorItem implements IEquipmentItem, ICustomItemRequirement, ICustomItemSkill, ICustomItemAttribute, ICustomItemPassive {

    private final UseRequirement useRequirement;

    private final ItemSkill itemSkill;

    public ArmorItem(UseRequirement useRequirement,  ItemSkill itemSkill) {
        this.useRequirement = useRequirement;
        this.itemSkill = itemSkill;
    }

    @Override
    public @NotNull IUseRequirement getRequirement() {
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
                ItemEnchantModule.getInstance(),
                ItemRarityModule.getInstance()
        );
    }
}
