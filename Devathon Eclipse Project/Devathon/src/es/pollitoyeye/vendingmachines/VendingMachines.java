package es.pollitoyeye.vendingmachines;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class VendingMachines extends JavaPlugin{
	private static VendingMachines pl;
	private static MachineManager mManager;
	private final static String pluginPrefix = ChatColor.YELLOW + "[" + ChatColor.GREEN + "VendingMachines" + ChatColor.YELLOW + "] ";
	public static HashMap<String,Machine> machinesMap = new HashMap<String,Machine>();
	public void onEnable(){
		pl = this;
		mManager = new MachineManager();
		Bukkit.getPluginManager().registerEvents(new EventListener(), this);
		
	}
	public void onDisable(){
		saveMachinesMap();
		saveConfig();
	}
	private void saveMachinesMap() {
		//TODO
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("createVendingMachine")){
			if(sender instanceof Player){
				mManager.placeMachine(((Player) sender).getLocation().getBlock());
				sender.sendMessage(pluginPrefix + ChatColor.AQUA + "A machine was created at your location.");
			}else{
				sender.sendMessage(pluginPrefix + ChatColor.RED + "You must be a player to use this command.");
			}
			return true;
		}
		return false;
	}
	public static VendingMachines getPlugin(){
		return pl;
	}
	public static MachineManager getMachineManager(){
		return mManager;
	}
	public static String getPluginPrefix(){
		return pluginPrefix;
	}
}