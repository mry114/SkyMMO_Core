package com.github.mry114.skymmo_core.data.model.item.weapon;

import com.github.mry114.skymmo_core.data.type.Rarity;
import com.github.mry114.skymmo_core.data.type.Status;
import com.github.mry114.skymmo_core.api.item.can.ItemSkill;
import com.github.mry114.skymmo_core.api.item.can.UseRequirement;
import com.github.mry114.skymmo_core.core.item.type.equipment.WeaponItem;
import com.github.mry114.skymmo_core.util.status.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExampleWeapon extends WeaponItem {
    public ExampleWeapon() {
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
                    public void onSkillAction(PlayerInteractEvent event) {
                        Player player = event.getPlayer();
                        Location loc = player.getLocation();

                        Vector direction = loc.getDirection();
                        Vector blocksAhead = direction.multiply(5);

                        Location tpLocation = loc.add(blocksAhead);
                        player.teleport(tpLocation);
                        loc.getWorld().createExplosion(loc, 4.0F, false, false);
                    }

                    @Override
                    public boolean getSkillCanUse(Player player) {
                        return false;
                    }
                });
    }

    @Override
    public @NotNull StatusContainer getBaseStatus() {
        return new StatusContainer.Builder()
                .add(Status.ATTACK, 10.0)
                .add(Status.ATTACK_PERCENT, 0.2)
                .add(Status.ATTACK_SPEED, 0.1)
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
        return 100_000;
    }

    @Override
    public @NotNull Component getName() {
        return Component.text("テストウェポン");
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.IRON_SWORD;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return Rarity.MYTHIC;
    }
}
