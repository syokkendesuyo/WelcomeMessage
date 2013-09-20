package com.github.pikagorou0806.wmv09;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Main extends JavaPlugin 
{
	/*
	 @author hyouga_0806(pikagorou0806)
	 */

	
    /*
     サーバー起動時の処理
     */
    
	@Override
    public void onEnable() {

        /*
         イベントの登録
         */
        
        getServer().getPluginManager().registerEvents(new Listener() {
        	
        	String lmsg = Main.this.getConfig().getString("loginmsg");
        	
            @EventHandler
            public void playerJoin(PlayerJoinEvent event) {

                List<String> rules = Main.this.getConfig().getStringList("rules");
                List<String> upd = Main.this.getConfig().getStringList("updates");
                
            	Player player = event.getPlayer();
            	
            	player.sendMessage("");
            	player.sendMessage(ChatColor.translateAlternateColorCodes('%', lmsg));

            	if(getConfig().getBoolean("loginrules")==true)
            	{
            		player.sendMessage(ChatColor.RED + "- - - -サーバーのルール- - - -");
            		for(String r : rules)
            		player.sendMessage(ChatColor.translateAlternateColorCodes('%', r));
            	}
            	if(getConfig().getBoolean("loginupdates")==true)
            	{
            		player.sendMessage(ChatColor.YELLOW + "- - - -アップデート情報- - - -");
                    for (String u : upd)
                    player.sendMessage(ChatColor.translateAlternateColorCodes('%', u));
                    player.sendMessage("");
            	}
            }
        }, this);
	}
        /*
         コマンドの登録
         */
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
            {
                List<String> rules = this.getConfig().getStringList("rules");
                List<String> upd = this.getConfig().getStringList("updates");
                
            	if(command.getName().equalsIgnoreCase("rules")){
                	sender.sendMessage(ChatColor.RED + "- - -サーバーのルール- - -");
                for (String s : rules)
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('%', s));
                
            }
            	if(command.getName().equalsIgnoreCase("updates")){
                    	sender.sendMessage(ChatColor.YELLOW + "- - -アップデート情報- - -");
                    for (String u : upd)
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('%', u));
            }
				return false;
      }
}