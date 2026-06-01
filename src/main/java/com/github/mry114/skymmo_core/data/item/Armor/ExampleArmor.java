package com.github.mry114.skymmo_core.data.item.Armor;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.api.item.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.can.IUseRequirement;
import com.github.mry114.skymmo_core.api.item.can.ItemSkill;
import com.github.mry114.skymmo_core.api.item.can.UseRequirement;
import com.github.mry114.skymmo_core.core.item.equipment.ArmorItem;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExampleArmor extends ArmorItem {
    public ExampleArmor() {
        super(
                new UseRequirement() {
                    @Override
                    public List<Component> getItemRequirementLore() {
                        return List.of(
                                Component.text("装備条件はありません")
                        );
                    }

                    @Override
                    public boolean getItemCanUse(Player player) {
                        return true;
                    }
                },
                new ItemSkill() {

                    @Override
                    public List<Component> getSkillLore() {
                        return List.of();
                    }

                    @Override
                    public void onSkillAction(Event event) {

                    }

                    @Override
                    public boolean getSkillCanUse(Player player) {
                        return false;
                    }
                });
    }

    @Override
    public @NotNull StatusContainer getMainStatus() {
        return new StatusContainer.Builder()
                .add(Status.DEFENCE, 10.0)
                .build();
    }

    @Override
    public @NotNull StatusContainer getBaseStatus() {
        return new StatusContainer.Builder()
                .add(Status.DEFENCE_PERCENT, 20.0)
                .add(Status.MOVE_SPEED, 10.0)
                .build();
    }

    @Override
    public @NotNull List<Component> getLore() {
        return List.of(
                Component.text("作成例です")
        );
    }

    @Override
    public int getId() {
        return 200_001;
    }

    @Override
    public @NotNull Component getName() {
        return Component.text("テストアーマー");
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.IRON_CHESTPLATE;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return Rarity.COMMON;
    }
}
