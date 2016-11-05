package es.pollitoyeye.vendingmachines;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import es.pollitoyeye.vendingmachines.utils.ItemUtil;

public class Machine {
	//TODO
	private HashMap<Integer,Integer> slotPrices = new HashMap<Integer,Integer>();
	private Inventory userInv;
	private Inventory adminInv;
	public Machine(){
		userInv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Vending Machine");
		adminInv = Bukkit.createInventory(null, 45, ChatColor.BLUE + "Vending Machine Admin Menu");
		ItemStack emptySlot = ItemUtil.createItemStack(Material.STAINED_GLASS_PANE, (short) 4, "", new String[]{});
		for(int x = 0; x < 45; x+= 9){
			adminInv.setItem(x, emptySlot);
			adminInv.setItem(x + 4, emptySlot);
			adminInv.setItem(x + 8, emptySlot);
			if(x == 0 || x == 36){
				for(int y = 1; y < 8; y ++){
					adminInv.setItem(x + y, emptySlot);
				}
			}
		}
	}
	public void open(Player p){
		p.openInventory(userInv);
	}
	public void openAdmin(Player p){
		p.openInventory(adminInv);
	}
	public void click(){
		
	}
	private void updateInvs(){
		
	}
}
