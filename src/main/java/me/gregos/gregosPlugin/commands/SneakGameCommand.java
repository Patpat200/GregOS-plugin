package me.gregos.gregosPlugin.commands;

import me.gregos.gregosPlugin.manager.FeatureManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SneakGameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage("§cUse: /sneakgame <on|off>");
            return true;
        }

        if (args[0].equalsIgnoreCase("on")) {
            FeatureManager.sneakDeathEnabled = true;
            sender.sendMessage("§aSneak death ENABLED");
            return true;
        }

        if (args[0].equalsIgnoreCase("off")) {
            FeatureManager.sneakDeathEnabled = false;
            sender.sendMessage("§cSneak death DISABLED");
            return true;
        }

        sender.sendMessage("§cUse: /sneakgame <on|off>");
        return true;
    }
}