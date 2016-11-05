package es.pollitoyeye.vendingmachines;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import es.pollitoyeye.vendingmachines.utils.ItemUtil;

public class Machine {
	//TODO
	private HashMap<Integer,SlotData> slotsData = new HashMap<Integer,SlotData>();
	private Inventory userInv;
	private Inventory adminInv;
	private ArmorStand mainStand;
	public Machine(ArmorStand mainStand){
		userInv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Vending Machine");
		adminInv = Bukkit.createInventory(null, 45, ChatColor.BLUE + "Vending Machine Admin Menu");
		for(int x = 1; x < 10; x++){
			slotsData.put(x, new SlotData(new ItemStack(Material.AIR),0,true));
		}
		ItemStack emptySlot = ItemUtil.createItemStack(Material.STAINED_GLASS_PANE, (short) 0, " ", new String[]{});
		ItemStack increasePrice = ItemUtil.createItemStack(Material.STAINED_GLASS_PANE, (short) 4, ChatColor.YELLOW + "" + ChatColor.BOLD + "Increase price", new String[]{});
		ItemStack decreasePrice = ItemUtil.createItemStack(Material.STAINED_GLASS_PANE, (short) 5, ChatColor.GREEN + "" + ChatColor.BOLD + "Decrease price", new String[]{});
		ItemStack emptyItem = ItemUtil.createItemStack(Material.BARRIER, (short) 0, ChatColor.RED + "" + ChatColor.BOLD + "No Item Selected", new String[]{});
		for(int x = 0; x < 45; x+= 9){
			adminInv.setItem(x, emptySlot);
			adminInv.setItem(x + 4, emptySlot);
			adminInv.setItem(x + 8, emptySlot);
			if(x == 0 || x == 36){
				for(int y = 1; y < 8; y ++){
					adminInv.setItem(x + y, emptySlot);
				}
			}else{
				adminInv.setItem(x + 1, decreasePrice);
				adminInv.setItem(x + 2, emptyItem);
				adminInv.setItem(x + 3, increasePrice);
				adminInv.setItem(x + 5, decreasePrice);
				adminInv.setItem(x + 6, emptyItem);
				adminInv.setItem(x + 7, increasePrice);
			}
		}
	}
	public void open(Player p){
		p.openInventory(userInv);
	}
	public void openAdmin(Player p){
		p.openInventory(adminInv);
	}
	public boolean click(Inventory inv){
		if(inv.equals(adminInv)){
			return true;
		}else if(inv.equals(mainStand)){
			return true;
		}
		return false;
	}
	private void updateInvs(){
		
	}
}
