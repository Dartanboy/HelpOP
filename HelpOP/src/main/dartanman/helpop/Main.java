package main.dartanman.helpop;

import org.bukkit.plugin.java.JavaPlugin;

import main.dartanman.helpop.commands.HelpOPCmd;

public class Main extends JavaPlugin{
	
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		getCommand("helpop").setExecutor(new HelpOPCmd(this));
	}
	
	public void onDisable() {
		
	}

}
