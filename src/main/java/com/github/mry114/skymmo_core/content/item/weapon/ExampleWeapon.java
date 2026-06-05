package com.github.mry114.skymmo_core.content.item.weapon;

import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.data.item.Rarity;
import com.github.mry114.skymmo_core.data.Status;
import com.github.mry114.skymmo_core.api.item.diff.can.ItemSkill;
import com.github.mry114.skymmo_core.api.item.diff.can.UseRequirement;
import com.github.mry114.skymmo_core.core.item.type.equipment.WeaponItem;
import com.github.mry114.skymmo_core.data.item.type.WeaponType;
import com.github.mry114.skymmo_core.core.status.StatusContainer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
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
                    public @NotNull List<Component> getSkillLore() {
                        return List.of(
                                Component.text("5ブロック前にテレポートし、爆発を起こします", TextColor.color(0xC4C4C4))
                        );
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
                .add(Status.DAMAGE, 10.0)
                .add(Status.DAMAGE_PERCENT, 0.2)
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

    @Override
    public @NotNull IItemType<WeaponType> getItemType() {
        return WeaponType.SWORD;
    }
}
