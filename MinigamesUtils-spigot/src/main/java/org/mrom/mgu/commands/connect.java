package org.mrom.mgu.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mrom.mgu.minigamesutils.MinigamesUtilsSpigot;

import javax.imageio.IIOException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class connect implements CommandExecutor {
    private final MinigamesUtilsSpigot plugin;

    public connect(MinigamesUtilsSpigot plugin){
        this.plugin = plugin;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if(args.length == 0){
            return false;
        }
        Player player = (Player) sender;
        sendServer(player, args[0]);
        return true;
    }
    private void sendServer(Player player, String server){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream das = new DataOutputStream(bos);
        try{
            das.writeUTF("Connect");
            das.writeUTF(server);
        }catch (IOException e){
            e.printStackTrace();
        }
        player.sendPluginMessage(MinigamesUtilsSpigot.getInstance(), "BungeeCord", bos.toByteArray());
    }
}
