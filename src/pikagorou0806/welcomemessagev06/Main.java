package pikagorou0806.welcomemessagev06;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Main extends JavaPlugin 
{
	
	@Override
    public void onEnable() {

        this.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new Listener() {
        	String lmsg = Main.this.getConfig().getString("loginmessage");
        	
            @EventHandler
            public void playerJoin(PlayerJoinEvent event) {
            	event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('%', lmsg));

            }
        }, this);
        
        this.getCommand("rules").setExecutor(new CommandExecutor() {
         	
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                List<String> rules = Main.this.getConfig().getStringList("rules");
                	sender.sendMessage(ChatColor.RED + "- - -サーバーのルール- - -");
                for (String s : rules)
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('%', s));
                {
            return true;
        }
     }
        });
        
            this.getCommand("updates").setExecutor(new CommandExecutor() {
            	 
            	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                    List<String> upd = Main.this.getConfig().getStringList("updates");
                    	sender.sendMessage(ChatColor.YELLOW + "- - -アップデート情報- - -");
                    for (String u : upd)
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('%', u));
                    {
            return true;
            }
                }
            });
	}
}