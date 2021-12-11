package org.mrom.mgu.listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;

import java.util.EventListener;

public class bungeelistener implements Listener {
    public void on(PluginMessageEvent event)
    {
        if ( !event.getTag().equalsIgnoreCase( "mgu:main" ) )
        {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput( event.getData() );
        String subChannel = in.readUTF();
        if ( subChannel.equalsIgnoreCase( "stop" ) )
        {
            if ( event.getReceiver() instanceof ProxiedPlayer )
            {
                ProxiedPlayer receiver = (ProxiedPlayer) event.getReceiver();
                String server = in.readUTF();
            }
            // the receiver is a server when the proxy talks to a server
            if ( event.getReceiver() instanceof Server )
            {
                Server receiver = (Server) event.getReceiver();
                String server = in.readUTF();
            }


        }
    }
}
