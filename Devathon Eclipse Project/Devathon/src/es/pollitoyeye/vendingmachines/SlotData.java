package es.pollitoyeye.vendingmachines;

import org.bukkit.inventory.ItemStack;

public class SlotData {
	private ItemStack displayItem;
	private int price;
	private boolean empty;
	public SlotData(ItemStack displayItem, int price, boolean empty){
		this.displayItem = displayItem;
		this.price = price;
		this.empty = empty;
	}
	public void setDisplayItem(ItemStack s){
		this.displayItem = s;
	}
	public void setPrice(int p){
		this.price = p;
	}
	public void setEmpty(boolean b){
		this.empty = b;
	}
	public ItemStack getDisplayItem(){
		return displayItem.clone();
	}
	public int getPrice(){
		return price;
	}
	public boolean isEmpty(){
		return empty;
	}
}
