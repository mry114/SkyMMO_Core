package com.github.mry114.skymmo_core.listener;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.capa.ICustomItemSkill;
import com.github.mry114.skymmo_core.api.item.equipment.IEquipmentItem;
import com.github.mry114.skymmo_core.core.context.ItemGeneratorContext;
import com.github.mry114.skymmo_core.core.item.factory.CustomItemFactory;
import com.github.mry114.skymmo_core.data.context.attribute.ItemAttributeModuleKeys;
import com.github.mry114.skymmo_core.data.context.basic.MainModuleKeys;
import com.github.mry114.skymmo_core.data.model.attribute.Mysterious;
import com.github.mry114.skymmo_core.registry.ItemRegistry;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class EventListener implements Listener {
    @EventHandler
    private void onPlayerChat(AsyncChatEvent event) {
        String message = PlainTextComponentSerializer.plainText().serialize(event.message());

        switch (message) {
            case "[1]" -> {
                Player player = event.getPlayer();

                ItemGeneratorContext context = new ItemGeneratorContext();
                context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, new Mysterious());

                player.getInventory().setItem(0, new CustomItemFactory(ItemRegistry.HYPERION).create(context));
            }
        }
    }

    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent event) {
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
            itemSkill.onSkillAction(event);
        }
    }
}
