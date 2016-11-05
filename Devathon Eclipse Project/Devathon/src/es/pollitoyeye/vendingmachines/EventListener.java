package es.pollitoyeye.vendingmachines;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;


public class EventListener implements Listener {
	@EventHandler
	public void onMachineDamage(EntityDamageEvent event){
		Entity en = event.getEntity();
		if(en instanceof ArmorStand && en.getCustomName() != null && (en.getCustomName().startsWith("VendingMachineCore;") || en.getCustomName().startsWith("VendingMachinePart;"))){
			event.setCancelled(true);
		}
	}
	@EventHandler
	public void onMachineInteract(PlayerInteractAtEntityEvent event){
		Entity en = event.getRightClicked();
		if(en instanceof ArmorStand && en.getCustomName() != null && (en.getCustomName().startsWith("VendingMachineCore;") || en.getCustomName().startsWith("VendingMachinePart;"))){
			event.setCancelled(true);
			String[] data = en.getCustomName().split(";");
			if(data.length > 1){
				String uuid = data[1];
				Player p = event.getPlayer();
				Machine m;
				if(VendingMachines.machinesMap.containsKey(uuid)){
					m = VendingMachines.machinesMap.get(uuid);
				}else{
					m = new Machine();
				}
				if(p.isSneaking() && p.hasPermission("VendingMachines.admin")){
					m.openAdmin(p);
				}else{
					m.open(p);
				}
			}
		}
	}
}