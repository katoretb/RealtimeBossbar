package me.Kato14123.RealTimeBossBar;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		System.out.println(format("&e-------------------------"));
		System.out.println(format("&e|    Plugin is enable   |"));
		System.out.println(format("&e|  &aCreate by Kato14123  &e|"));
		System.out.println(format("&e-------------------------"));
	}
	
	@Override
	public void onDisable() {
		System.out.println(format("&e-------------------------"));
		System.out.println(format("&e|   Plugin is disable   |"));
		System.out.println(format("&e|  &aCreate by Kato14123  &e|"));
		System.out.println(format("&e-------------------------"));
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(format("&e---------help---------"));
			sender.sendMessage(format("&e/rtbb reload"));
			sender.sendMessage(format("&e/rtbb list"));
			sender.sendMessage(format("&e/rtbb stop <bossbar name>"));
			sender.sendMessage(format("&e----------------------"));
			return true;
		}
		if (args.length > 0) {
			if (args[0].equalsIgnoreCase("reload")) {
				for (String msg : this.getConfig().getStringList("reload.message") ) {
					sender.sendMessage(format(msg));
				}
				this.reloadConfig();
				return true;
			}else if (args[0].equalsIgnoreCase("list")) {
				sender.sendMessage(format("&e-------Bossbar list-------"));
				this.getConfig().getConfigurationSection("message").getKeys(false).forEach(key -> {
					sender.sendMessage(format("&e- &b" + key));
				});
				sender.sendMessage(format("&e--------------------------"));
				return true;
			}
			return true;
		}
		return false;
	}	
	
	private String format(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}