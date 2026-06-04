package com.github.mry114.skymmo_core.api.item.equipment;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.can.IUseRequirement;
import com.github.mry114.skymmo_core.util.status.StatusContainer;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface IEquipmentItem extends ICustomItem {
    /**
     * アイテムの固定ベースステータスを返します。
     * MainStatusとは別物となり、主に実数として表記されるかつ、そのアイテムクラス自体がメインで担当すべき
     * ステータス区分をこれで返すことを想定しています。
     */
    @NotNull StatusContainer getBaseStatus();

    /**
     * アイテムの説明文となるLoreを返します。
     */
    @NotNull List<Component> getLore();
}