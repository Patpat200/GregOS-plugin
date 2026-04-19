package me.gregos.gregosPlugin.commands;

import me.gregos.gregosPlugin.manager.FeatureManager;
import me.gregos.gregosPlugin.abilities.LightningAbility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AbilityCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if (!FeatureManager.abilityEnabled) {
            player.sendMessage("§cAbilities disabled!");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage("§cUse: /ability 1");
            return true;
        }

        if (args[0].equals("1")) {
            new LightningAbility().execute(player);
            return true;
        }

        player.sendMessage("§cUnknown ability!");
        return true;
    }
}