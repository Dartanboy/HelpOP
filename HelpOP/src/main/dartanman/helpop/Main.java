/**
* JavaPlugin class for the entire HelpOP plugin.
* @author Dartanman (Austin Dart)
**/

package main.dartanman.helpop;

import org.bukkit.plugin.java.JavaPlugin;

import main.dartanman.helpop.commands.HelpOPCmd;

public class Main extends JavaPlugin{
	
	/**
	* Enables the plugin by creating the configuration file and registering the /helpop command.
	**/
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		getCommand("helpop").setExecutor(new HelpOPCmd(this));
	}
	
	/**
	* Would disable the plugin, but nothing has to happen to disable HelpOP. The server handles it automatically.
	**/
	public void onDisable() {
		
	}

}
