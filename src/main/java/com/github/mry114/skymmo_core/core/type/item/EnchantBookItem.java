package com.github.mry114.skymmo_core.core.type.item;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemEnchant;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import com.github.mry114.skymmo_core.api.type.IEnchantType;
import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.data.item.Rarity;
import com.github.mry114.skymmo_core.data.item.context.basic.name.ItemNameModule;
import com.github.mry114.skymmo_core.data.item.context.basic.rarity.ItemRarityModule;
import com.github.mry114.skymmo_core.data.item.type.EnchantBookType;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EnchantBookItem implements ICustomItem, ICustomItemEnchant {
    @Override
    public @NotNull List<IEnchantType<? extends Enum<?>>> canEnchantType() {
        return List.of();
    }

    @Override
    public int getId() {
        return 3_000_001;
    }

    @Override
    public @NotNull Component getName() {
        return Component.text("Enchanted Book");
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.ENCHANTED_BOOK;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public @NotNull IItemType<EnchantBookType> getItemType() {
        return EnchantBookType.ENCHANT_BOOK_TYPE;
    }

    @Override
    public @NotNull List<IItemModule> getProcessorModule() {
        return List.of(
                ItemNameModule.getInstance(),
                ItemRarityModule.getInstance()
        );
    }
}
