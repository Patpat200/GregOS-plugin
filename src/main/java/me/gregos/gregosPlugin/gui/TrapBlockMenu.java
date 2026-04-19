package me.gregos.gregosPlugin.gui;

import me.gregos.gregosPlugin.manager.FeatureManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class TrapBlockMenu {

    // Blocs proposés dans le sous-menu (modifiable à volonté)
    public static final List<Material> TRAP_CHOICES = Arrays.asList(
            Material.GRASS_BLOCK,
            Material.STONE,
            Material.DIRT,
            Material.OAK_LOG,
            Material.SAND,
            Material.GRAVEL,
            Material.COAL_ORE,
            Material.IRON_ORE,
            Material.GOLD_ORE,
            Material.DIAMOND_ORE,
            Material.OBSIDIAN,
            Material.NETHERRACK,
            Material.COBBLESTONE,
            Material.DEEPSLATE,
            Material.CHEST,
            Material.BARREL,
            Material.CRAFTING_TABLE,
            Material.FURNACE
    );

    public static final String TITLE = "§4☠ Choisir le bloc piégé";

    public static Inventory createMenu() {

        // +1 rangée pour les boutons de contrôle
        int size = (int) Math.ceil(TRAP_CHOICES.size() / 9.0) * 9 + 9;
        size = Math.min(size, 54);

        Inventory inv = Bukkit.createInventory(null, size, TITLE);

        for (int i = 0; i < TRAP_CHOICES.size(); i++) {
            Material mat = TRAP_CHOICES.get(i);
            boolean selected = mat == FeatureManager.trapBlockType;

            ItemStack item = new ItemStack(mat);
            ItemMeta meta = item.getItemMeta();

            String displayName = selected
                    ? "§a✔ §f" + formatName(mat)
                    : "§7" + formatName(mat);

            meta.setDisplayName(displayName);
            meta.setLore(selected
                    ? Arrays.asList("§aSélectionné", "§7Clic pour désélectionner")
                    : Arrays.asList("§7Clic pour piéger ce bloc"));

            item.setItemMeta(meta);
            inv.setItem(i, item);
        }

        // Bouton retour (dernière rangée, slot gauche)
        inv.setItem(size - 9, createControl(Material.ARROW, "§eRetour au menu", "§7Revenir au menu principal"));

        // Bouton désactiver (dernière rangée, slot droit)
        if (FeatureManager.trapBlockType != null) {
            inv.setItem(size - 1, createControl(Material.BARRIER, "§cDésactiver le piège", "§7Aucun bloc piégé"));
        }

        return inv;
    }

    private static ItemStack createControl(Material mat, String name, String lore) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    private static String formatName(Material mat) {
        String raw = mat.name().replace("_", " ");
        StringBuilder sb = new StringBuilder();
        for (String word : raw.split(" ")) {
            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return sb.toString().trim();
    }

    public static void open(Player player) {
        player.openInventory(createMenu());
    }
}