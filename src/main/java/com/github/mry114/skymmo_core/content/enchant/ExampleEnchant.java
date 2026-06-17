package com.github.mry114.skymmo_core.content.enchant;

import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import com.github.mry114.skymmo_core.core.player.modify.StatusModify;
import com.github.mry114.skymmo_core.core.type.enchant.Enchant;
import com.github.mry114.skymmo_core.model.enchant.EnchantTier;
import com.github.mry114.skymmo_core.model.item.ItemGroup;
import com.github.mry114.skymmo_core.model.status.PlayerStatus;
import com.github.mry114.skymmo_core.util.Operator;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExampleEnchant extends Enchant {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public @NotNull Component getEnchantName() {
        return Component.text("Test");
    }

    @Override
    public @NotNull List<Component> getEnchantLore() {
        return List.of(
                Component.text("Test用のエンチャントです", TextColor.color(0xC4C4C4))
        );
    }

    @Override
    public int getMaxLevel() {
        return 6;
    }

    @Override
    public @NotNull List<ElementData> getElements(int level) {
        return List.of(
                new ElementData() {
                    @Override
                    public void playerAttackedEntityEvent(EntityDamageByEntityEvent event) {
                        super.playerAttackedEntityEvent(event);
                    }

                    @Override
                    public List<StatusModify> getStatusModify() {
                        return List.of(
                                new StatusModify(Operator.ADDITION, PlayerStatus.ATTACK, 30.0 * level)
                        );
                    }
                }
        );
    }

    @Override
    public boolean getUseTargetTypeBool(IItemType<?> type) {
        return type.getItemGroup() == ItemGroup.ENCHANTED_BOOK || type.getItemGroup() == ItemGroup.WEAPON;
    }

    @Override
    public EnchantTier getTier() {
        return EnchantTier.NORMAL;
    }
}
