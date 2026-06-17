package com.github.mry114.skymmo_core.content.item.enchant_book;

import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.core.type.item.EnchantBookItem;
import com.github.mry114.skymmo_core.model.item.Rarity;
import com.github.mry114.skymmo_core.model.item.type.EnchantBookType;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class UltimateEnchantBook extends EnchantBookItem {
    @Override
    public int getId() {
        return 3_000_002;
    }

    @Override
    public @NotNull Component getName() {
        return Component.text("Ultimate Enchanted Book");
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.ENCHANTED_BOOK;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public @NotNull IItemType<EnchantBookType> getItemType() {
        return EnchantBookType.ULTIMATE_ENCHANTED_BOOK;
    }
}
