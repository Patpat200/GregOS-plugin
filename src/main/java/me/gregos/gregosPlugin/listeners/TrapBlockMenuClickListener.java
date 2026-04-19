package me.gregos.gregosPlugin.gui;

import me.gregos.gregosPlugin.manager.FeatureManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TrapBlockMenuClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!event.getView().getTitle().equals(TrapBlockMenu.TITLE)) return;

        event.setCancelled(true);

        if (event.getCurrentItem() == null) return;

        Player player = (Player) event.getWhoClicked();
        Material clicked = event.getCurrentItem().getType();

        // Bouton retour
        if (clicked == Material.ARROW) {
            MainMenu.open(player);
            return;
        }

        // Bouton désactiver
        if (clicked == Material.BARRIER) {
            FeatureManager.trapBlockType = null;
            FeatureManager.trapBlockEnabled = false;
            player.sendMessage("§7Piège désactivé.");
            TrapBlockMenu.open(player);
            return;
        }

        // Sélection d'un bloc dans la liste
        int slot = event.getRawSlot();
        int lastRow = (event.getInventory().getSize() / 9 - 1) * 9;

        // Ignorer les clics sur la dernière rangée (boutons de contrôle)
        if (slot >= lastRow) return;

        if (slot < 0 || slot >= TrapBlockMenu.TRAP_CHOICES.size()) return;

        Material chosen = TrapBlockMenu.TRAP_CHOICES.get(slot);

        // Toggle : reclicker désélectionne
        if (FeatureManager.trapBlockType == chosen) {
            FeatureManager.trapBlockType = null;
            FeatureManager.trapBlockEnabled = false;
            player.sendMessage("§7Piège retiré pour §f" + chosen.name().replace("_", " ").toLowerCase() + "§7.");
        } else {
            FeatureManager.trapBlockType = chosen;
            FeatureManager.trapBlockEnabled = true;
            player.sendMessage("§c☠ Bloc piégé : §f" + chosen.name().replace("_", " ").toLowerCase());
        }

        // Rafraîchir le sous-menu
        TrapBlockMenu.open(player);
    }
}