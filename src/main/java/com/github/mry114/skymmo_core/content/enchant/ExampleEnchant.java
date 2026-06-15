package com.github.mry114.skymmo_core.content.enchant;

import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import com.github.mry114.skymmo_core.core.player.modify.StatusModify;
import com.github.mry114.skymmo_core.core.type.enchant.Enchant;
import com.github.mry114.skymmo_core.model.item.ItemGroup;
import com.github.mry114.skymmo_core.model.status.PlayerStatus;
import net.kyori.adventure.text.Component;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExampleEnchant extends Enchant {
    public ExampleEnchant() {
        super(List.of(
                new ElementData() {
                    @Override
                    public void playerAttackedEntityEvent(EntityDamageByEntityEvent event) {
                        super.playerAttackedEntityEvent(event);
                    }

                    @Override
                    public List<StatusModify> getStatusModify() {
                        return List.of(
                                new StatusModify(StatusModify.Operator.ADDITION, PlayerStatus.ATTACK, 30.0)
                        );
                    }
                }
        ));
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
                Component.text("テスト用エンチャント")
        );
    }

    @Override
    public int getMaxLevel() {
        return 6;
    }

    @Override
    public boolean getUseTargetTypeBool(IItemType<?> type) {
        return type.getItemGroup() == ItemGroup.ENCHANTED_BOOK || type.getItemGroup() == ItemGroup.WEAPON;
    }
}
