package me.gregos.gregosPlugin.gui;

import me.gregos.gregosPlugin.manager.FeatureManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MainMenu {

    public static Inventory createMenu() {

        Inventory inv = Bukkit.createInventory(null, 9, "§6Plugin Menu");

        inv.setItem(0, createItem(
                FeatureManager.slimeEnabled ? Material.SLIME_BALL : Material.BARRIER,
                "§aSlime Spawn",
                FeatureManager.slimeEnabled ? "§7Enabled" : "§cDisabled"
        ));

        inv.setItem(1, createItem(
                FeatureManager.sneakDeathEnabled ? Material.IRON_BOOTS : Material.BARRIER,
                "§eSneak Death",
                FeatureManager.sneakDeathEnabled ? "§7Enabled" : "§cDisabled"
        ));

        inv.setItem(2, createItem(
                FeatureManager.abilityEnabled ? Material.BLAZE_ROD : Material.BARRIER,
                "§bAbility System",
                FeatureManager.abilityEnabled ? "§7Enabled" : "§cDisabled"
        ));

        // Slot Trap : affiche le bloc actuellement sélectionné ou TNT par défaut
        Material trapIcon;
        String trapLore;
        if (FeatureManager.trapBlockType != null) {
            trapIcon = FeatureManager.trapBlockType;
            trapLore = "§cActif : §f" + FeatureManager.trapBlockType.name().replace("_", " ").toLowerCase();
        } else {
            trapIcon = Material.TNT;
            trapLore = "§7Aucun bloc sélectionné";
        }

        inv.setItem(3, createItem(trapIcon, "§cTrap Blocks", trapLore + "\n§7Clic pour configurer"));

        return inv;
    }

    private static ItemStack createItem(Material mat, String name, String lore) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore, "§7Click to toggle"));

        item.setItemMeta(meta);
        return item;
    }

    public static void open(Player player) {
        player.openInventory(createMenu());
    }
}