package com.github.mry114.skymmo_core.core.type.item;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemEnchant;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.handler.item.context.enchant.ItemEnchantModule;
import com.github.mry114.skymmo_core.model.item.Rarity;
import com.github.mry114.skymmo_core.handler.item.context.name.ItemNameModule;
import com.github.mry114.skymmo_core.handler.item.context.rarity.ItemRarityModule;
import com.github.mry114.skymmo_core.model.item.type.EnchantBookType;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EnchantBookItem implements ICustomItem, ICustomItemEnchant {

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
        return EnchantBookType.ENCHANTED_BOOK;
    }

    @Override
    public @NotNull List<IItemModule> getProcessorModule() {
        return List.of(
                ItemNameModule.getInstance(),
                ItemEnchantModule.getInstance(),
                ItemRarityModule.getInstance()
        );
    }
}
