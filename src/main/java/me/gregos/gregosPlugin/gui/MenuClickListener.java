package me.gregos.gregosPlugin.gui;

import me.gregos.gregosPlugin.manager.FeatureManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!event.getView().getTitle().equals("§6Plugin Menu")) return;

        event.setCancelled(true);

        int slot = event.getRawSlot();

        // sécurité
        if (slot < 0 || slot > 8) return;

        switch (slot) {

            case 0: // Slime
                FeatureManager.slimeEnabled = !FeatureManager.slimeEnabled;
                break;

            case 1: // Sneak death
                FeatureManager.sneakDeathEnabled = !FeatureManager.sneakDeathEnabled;
                break;

            case 2: // Ability
                FeatureManager.abilityEnabled = !FeatureManager.abilityEnabled;
                break;
        }

        event.getWhoClicked().openInventory(MainMenu.createMenu());
    }
}