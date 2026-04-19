package me.gregos.gregosPlugin.commands;

import me.gregos.gregosPlugin.manager.TrapBlockManager;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrapCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cCommande joueur uniquement.");
            return true;
        }

        if (args.length == 0) {
            sendHelp(player);
            return true;
        }

        switch (args[0].toLowerCase()) {

            case "set": {
                Block target = player.getTargetBlockExact(5);
                if (target == null) {
                    player.sendMessage("§cRegarde un bloc à moins de 5 blocs.");
                    return true;
                }
                TrapBlockManager.addTrap(target.getLocation());
                player.sendMessage("§a✔ Bloc piégé posé en §e" +
                        target.getX() + ", " + target.getY() + ", " + target.getZ() +
                        " §a(" + target.getType() + ")");
                break;
            }

            case "clear": {
                int removed = TrapBlockManager.clearAll();
                player.sendMessage("§a✔ §e" + removed + " §abloc(s) piégé(s) supprimé(s).");
                break;
            }

            case "count": {
                player.sendMessage("§7Blocs piégés actifs : §e" + TrapBlockManager.count());
                break;
            }

            default:
                sendHelp(player);
        }

        return true;
    }

    private void sendHelp(Player player) {
        player.sendMessage("§6/trap set §7— Piège le bloc que tu vises");
        player.sendMessage("§6/trap clear §7— Supprime tous les pièges");
        player.sendMessage("§6/trap count §7— Compte les pièges actifs");
    }
}