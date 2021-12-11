package org.mrom.mgu.minigamesutils;

import org.bukkit.plugin.java.JavaPlugin;
import org.mrom.mgu.commands.connect;

public final class MinigamesUtilsSpigot extends JavaPlugin {
    private static MinigamesUtilsSpigot instance;
    @Override
    public void onEnable() {
        instance = this;
        getCommand("connect").setExecutor(new connect(this));
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
    }
    public static MinigamesUtilsSpigot getInstance() {
        return instance;
    }
}
