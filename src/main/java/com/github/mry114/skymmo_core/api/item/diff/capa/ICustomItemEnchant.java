package com.github.mry114.skymmo_core.api.item.diff.capa;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.type.IEnchantType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ICustomItemEnchant extends ICustomItem {
    @NotNull List<IEnchantType<? extends Enum<?>>> canEnchantType();
}
