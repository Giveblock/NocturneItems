package me.giveblock.nocturneItems;

import me.giveblock.nocturneItems.commands.NocturneGive;
import org.bukkit.plugin.java.JavaPlugin;

public final class NocturneItems extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        this.getCommand("nocturnegive").setExecutor(new NocturneGive(this));

    }


}
