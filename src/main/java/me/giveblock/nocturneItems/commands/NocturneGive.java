package me.giveblock.nocturneItems.commands;

import me.giveblock.nocturneItems.NocturneItems;
import me.giveblock.nocturneItems.api.ItemHelper;
import me.giveblock.nocturneItems.api.MathHelper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class NocturneGive implements CommandExecutor {

    public NocturneGive(NocturneItems plugin) {}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!p.hasPermission("nocturneitems.give") && !p.isOp()){
                sender.sendMessage("You dont have permission to use this command!");
                return false;
            }
        }

        if (args.length < 2 || args.length > 3) {
            sender.sendMessage("Invalid Arguments!");
        }

        if (args.length == 2) {
            if (Bukkit.getPlayer(args[0]) != null) {
                Player target = Bukkit.getPlayer(args[0]);
                String material = args[1];
                ItemStack item = ItemHelper.getItem(material, 1);
                if (item != null) {
                    target.getInventory().addItem(item);
                    return true;
                }
                sender.sendMessage("Invalid Item!");
                return false;
            }
            sender.sendMessage("Invalid Player!");
        }
        if (args.length == 3) {
            if (Bukkit.getPlayer(args[0]) != null) {
                Player target = Bukkit.getPlayer(args[0]);
                String material = args[1];
                if (MathHelper.isNumeric(args[2])) {
                    int amount = Integer.parseInt(args[2]);
                    ItemStack item = ItemHelper.getItem(material, amount);
                    if (item != null) {
                        target.getInventory().addItem(item);
                        return true;
                    }
                    sender.sendMessage("Invalid Item!");
                    return false;
                }
            }
            sender.sendMessage("Invalid Player!");
        }


        return false;
    }

}
