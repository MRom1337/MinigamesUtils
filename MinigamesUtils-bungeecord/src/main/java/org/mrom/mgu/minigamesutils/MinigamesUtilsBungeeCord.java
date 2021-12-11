package org.mrom.mgu.minigamesutils;

import net.md_5.bungee.api.plugin.Plugin;

public final class MinigamesUtilsBungeeCord extends Plugin {
    private  static  MinigamesUtilsBungeeCord instance;
    @Override
    public void onEnable() {
        MinigamesUtilsBungeeCord.instance = this;
        getProxy().registerChannel("mgu:main");
    }
    public static  MinigamesUtilsBungeeCord getInstance(){
        return instance;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
