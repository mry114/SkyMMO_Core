package com.github.mry114.skymmo_core.listener;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.api.item.content.diff.capa.ICustomItemSkill;
import com.github.mry114.skymmo_core.api.system.IIgniterEvent;
import com.github.mry114.skymmo_core.content.enchant.ExampleEnchant;
import com.github.mry114.skymmo_core.content.item.armor.ExampleArmor;
import com.github.mry114.skymmo_core.content.item.enchant_book.NormalEnchantBook;
import com.github.mry114.skymmo_core.content.item.enchant_book.UltimateEnchantBook;
import com.github.mry114.skymmo_core.content.item.weapon.ExampleWeapon;
import com.github.mry114.skymmo_core.core.item.context.ItemGeneratorContext;
import com.github.mry114.skymmo_core.core.factory.CustomItemFactory;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import com.github.mry114.skymmo_core.handler.item.context.attribute.ItemAttributeModuleKeys;
import com.github.mry114.skymmo_core.handler.item.context.MainModuleKeys;
import com.github.mry114.skymmo_core.content.attribute.ExampleAttribute;
import com.github.mry114.skymmo_core.handler.item.context.enchant.ItemEnchantModuleKeys;
import com.github.mry114.skymmo_core.handler.pdc.converter.EnchantConvertData;
import com.github.mry114.skymmo_core.model.status.Status;
import com.github.mry114.skymmo_core.register.content.ItemRegistry;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventListener implements Listener {
    private final List<@NotNull IIgniterEvent> igniterInterfaceInheritanceClass;

    public EventListener() {
        List<IIgniterEvent> inheritance;

        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            inheritance = scanResult.getClassesImplementing(IIgniterEvent.class.getName())
                    .filter(classInfo -> !classInfo.isAbstract())
                    .stream()
                    .map(classInfo -> {
                        try {
                            Class<?> clazz = classInfo.loadClass();
                            return (IIgniterEvent) clazz.getDeclaredConstructor().newInstance();
                        } catch (Exception e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .toList();
        }
        this.igniterInterfaceInheritanceClass = inheritance;
    }

    @EventHandler
    private void onPlayerChat(AsyncChatEvent event) {
        String message = PlainTextComponentSerializer.plainText().serialize(event.message());
        Player player = event.getPlayer();

        ItemGeneratorContext context = new ItemGeneratorContext();

        switch (message) {
            case "1" -> {
                context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, new ExampleAttribute());
                context.put(ItemEnchantModuleKeys.ITEM_ENCHANT, List.of(
                        new EnchantConvertData(new ExampleEnchant(), 1)
                ));
                player.getInventory().setItem(0, new CustomItemFactory().create(new ExampleWeapon(), context));
            }

            case "2" -> {
                context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, new ExampleAttribute());
                context.put(ItemEnchantModuleKeys.ITEM_ENCHANT, List.of(
                        new EnchantConvertData(new ExampleEnchant(), 3)
                ));
                player.getInventory().setItem(0, new CustomItemFactory().create(new ExampleArmor(), context));
            }

            case "3" -> {
                context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, new ExampleAttribute());
                player.getInventory().setItem(0, new CustomItemFactory().create(new ExampleArmor(), context));
            }

            case "4" -> {
                context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, new ExampleAttribute());
                context.put(ItemEnchantModuleKeys.ITEM_ENCHANT, List.of(
                        new EnchantConvertData(new ExampleEnchant(), 6)
                ));
                player.getInventory().setItem(0, new CustomItemFactory().create(new NormalEnchantBook(), context));
            }

            case "5" -> {
                context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, new ExampleAttribute());
                player.getInventory().setItem(0, new CustomItemFactory().create(new UltimateEnchantBook(), context));
            }

            case "6" -> {
                StatusContainer statusContainer = SkyMMO_Core.statusCache.getPlayerStatus(player.getUniqueId());
                player.sendMessage(Component.text(statusContainer.get(Status.DAMAGE)));
            }
        }
    }

    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        ItemMeta meta = event.getPlayer().getInventory().getItemInMainHand().getItemMeta();
        if (meta == null) {
            return;
        }

        Integer id = new PDCWrapper(meta).get(MainModuleKeys.PDC_ITEM_ID);
        if (id == null) {
            return;
        }

        if (!(ItemRegistry.getById(id) instanceof ICustomItemSkill skill)) {
            return;
        }

        var itemSkill = skill.getItemSkill();
        if (itemSkill != null) {
            if (!itemSkill.getSkillCanUse(event.getPlayer())) return;
            itemSkill.onSkillAction(event);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity damaged = event.getEntity();

        // 1. プレイヤーが敵（他のエンティティ）を殴った場合
        if (damager instanceof Player player) {

            // 殴られた対象が生き物（モンスターなど）であるか判定
            if (damaged instanceof LivingEntity && !(damaged instanceof Player)) {
                double damage = event.getFinalDamage();

            }
        }

        // 2. プレイヤーが敵（他のエンティティ）に殴られた場合
        if (damaged instanceof Player player) {

            // 殴った側が生き物（モンスターなど）であるか判定
            if (damager instanceof LivingEntity && !(damager instanceof Player)) {
                double damage = event.getFinalDamage();

            }
        }
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        SkyMMO_Core.elementCache.createPlayer(player.getUniqueId());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        SkyMMO_Core.elementCache.removePlayer(player.getUniqueId());
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        for (IIgniterEvent igniterEvent : igniterInterfaceInheritanceClass) {
            igniterEvent.playerItemHeldEvent(event);
        }
    }
}
