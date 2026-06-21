package com.github.mry114.skymmo_core.content.item.armor;

import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import com.github.mry114.skymmo_core.model.item.Rarity;
import com.github.mry114.skymmo_core.model.status.Status;
import com.github.mry114.skymmo_core.core.type.ItemSkill;
import com.github.mry114.skymmo_core.core.type.UseRequirement;
import com.github.mry114.skymmo_core.core.type.item.ArmorItem;
import com.github.mry114.skymmo_core.model.item.type.ArmorType;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
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

                    @Override
                    public boolean getExistence() {
                        return false;
                    }
                },
                new ItemSkill() {

                    @Override
                    public @NotNull List<Component> getSkillLore() {
                        return List.of();
                    }

                    @Override
                    public void onSkillAction(PlayerInteractEvent event) {

                    }

                    @Override
                    public boolean getSkillCanUse(Player player) {
                        return false;
                    }

                    @Override
                    public boolean getExistence() {
                        return false;
                    }
                });
    }

    @Override
    public @NotNull StatusContainer getBaseStatus() {
        return new StatusContainer.Builder()
                .add(Status.DEFENCE, 10.0)
                .add(Status.DEFENCE_PERCENT, 0.2)
                .add(Status.MOVE_SPEED, 0.1)
                .build();
    }

    @Override
    public @NotNull List<Component> getEquipmentLore() {
        return List.of(
                Component.text("作成例です")
        );
    }

    @Override
    public int getId() {
        return 2_000_000;
    }

    @Override
    public @NotNull Component getName() {
        return Component.text("TestArmor");
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.IRON_CHESTPLATE;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public @NotNull IItemType<ArmorType> getItemType() {
        return ArmorType.CHESTPLATE;
    }

    @Override
    public @NotNull List<ElementData> getPassiveElementData() {
        return List.of();
    }
}
