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

        if (slot < 0 || slot > 8) return;

        switch (slot) {

            case 0:
                FeatureManager.slimeEnabled = !FeatureManager.slimeEnabled;
                event.getWhoClicked().openInventory(MainMenu.createMenu());
                break;

            case 1:
                FeatureManager.sneakDeathEnabled = !FeatureManager.sneakDeathEnabled;
                event.getWhoClicked().openInventory(MainMenu.createMenu());
                break;

            case 2:
                FeatureManager.abilityEnabled = !FeatureManager.abilityEnabled;
                event.getWhoClicked().openInventory(MainMenu.createMenu());
                break;

            case 3:
                // Ouvre le sous-menu de sélection du bloc piégé
                TrapBlockMenu.open((org.bukkit.entity.Player) event.getWhoClicked());
                break;
        }
    }
}