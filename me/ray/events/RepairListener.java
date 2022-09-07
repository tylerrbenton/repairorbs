/*    */ package me.ray.events;
/*    */ 
/*    */ import me.ray.repairorbs.RepairOrbs;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.configuration.ConfigurationSection;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class RepairListener
/*    */   implements Listener
/*    */ {
/*    */   private ConfigurationSection section;
/*    */   private FileConfiguration configuration;
/*    */   
/*    */   public RepairListener(RepairOrbs repairOrbs) {
/* 21 */     this.section = repairOrbs.getConfig().getConfigurationSection("configuration.orb");
/* 22 */     this.configuration = repairOrbs.getConfig();
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onClick(InventoryClickEvent e) {
/* 27 */     ItemStack cursorItem = e.getCursor();
/* 28 */     ItemStack currentItem = e.getCurrentItem();
/*    */     
/* 30 */     if (!(e.getWhoClicked() instanceof Player)) {
/*    */       return;
/*    */     }
/* 33 */     Player player = (Player)e.getWhoClicked();
/*    */     
/*    */     try {
/* 36 */       if (currentItem.getTypeId() == this.section.getInt("item id") && currentItem.getItemMeta().getDisplayName()
/* 37 */         .equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.section.getString("name"))) && cursorItem
/* 38 */         .getType() != Material.AIR) {
/*    */         
/* 40 */         if (cursorItem.getDurability() == 0) {
/* 41 */           player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.configuration.getString("configuration.messages.max durability")));
/*    */           
/*    */           return;
/*    */         } 
/* 45 */         e.getCursor().setDurability((short)0);
/* 46 */         ItemStack newItem = new ItemStack(currentItem.getType().getId(), currentItem.getAmount() - 1);
/* 47 */         newItem.setItemMeta(currentItem.getItemMeta());
/* 48 */         e.getClickedInventory().setItem(e.getSlot(), (newItem.getAmount() == 0) ? new ItemStack(Material.AIR) : newItem);
/* 49 */         e.setCancelled(true);
/* 50 */         player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.configuration.getString("configuration.messages.item repaired")));
/*    */       } 
/* 52 */     } catch (NullPointerException nullPointerException) {}
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/RepairOrbs.jar!/me/ray/events/RepairListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */