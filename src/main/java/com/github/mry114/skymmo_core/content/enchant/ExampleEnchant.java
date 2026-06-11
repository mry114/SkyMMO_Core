package com.github.mry114.skymmo_core.content.enchant;

import com.github.mry114.skymmo_core.core.type.enchant.Enchant;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExampleEnchant extends Enchant {
    public ExampleEnchant() {
        super(List.of());
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public @NotNull Component getEnchantName() {
        return Component.text("テストエンチャント");
    }

    @Override
    public @NotNull List<Component> getEnchantLore() {
        return List.of(
                Component.text("テスト用のエンチャント")
        );
    }

    @Override
    public int getMaxLevel() {
        return 6;
    }
}
