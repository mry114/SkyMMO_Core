package com.github.mry114.skymmo_core.content.item.weapon;

import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import com.github.mry114.skymmo_core.model.item.Rarity;
import com.github.mry114.skymmo_core.model.status.Status;
import com.github.mry114.skymmo_core.api.item.content.diff.can.ItemSkill;
import com.github.mry114.skymmo_core.api.item.content.diff.can.UseRequirement;
import com.github.mry114.skymmo_core.core.type.item.WeaponItem;
import com.github.mry114.skymmo_core.model.item.type.WeaponType;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
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

                    @Override
                    public boolean getExistence() {
                        return false;
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
                        Location startLoc = player.getLocation(); // 元の位置
                        Vector direction = startLoc.getDirection();

                        org.bukkit.util.RayTraceResult rayTrace = startLoc.getWorld().rayTraceBlocks(
                                startLoc,
                                direction,
                                5.0,
                                org.bukkit.FluidCollisionMode.NEVER,
                                true
                        );

                        Location tpLocation;

                        if (rayTrace != null && rayTrace.getHitBlock() != null) {
                            tpLocation = rayTrace.getHitPosition().toLocation(startLoc.getWorld());
                            tpLocation.subtract(direction.normalize().multiply(0.5));
                            tpLocation.setDirection(direction);
                        } else {
                            tpLocation = startLoc.clone().add(direction.multiply(5));
                        }

                        player.teleport(tpLocation);
                        tpLocation.getWorld().createExplosion(tpLocation, 0.0F);
                    }

                    @Override
                    public boolean getSkillCanUse(Player player) {
                        return true;
                    }

                    @Override
                    public boolean getExistence() {
                        return true;
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
    public @NotNull List<Component> getEquipmentLore() {
        return List.of(
                Component.text("作成例です")
        );
    }

    @Override
    public int getId() {
        return 1_000_000;
    }

    @Override
    public @NotNull Component getName() {
        return Component.text("TestWeapon");
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

    @Override
    public @NotNull List<ElementData> getPassiveElementData() {
        return List.of();
    }
}
