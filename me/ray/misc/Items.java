/*    */ package me.ray.misc;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.ray.repairorbs.RepairOrbs;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.configuration.ConfigurationSection;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ public class Items
/*    */ {
/*    */   private ConfigurationSection section;
/*    */   
/*    */   public Items(RepairOrbs repairOrbs) {
/* 17 */     this.section = repairOrbs.getConfig().getConfigurationSection("configuration.orb");
/*    */   }
/*    */   
/*    */   private ItemStack createItem(int itemId, int amount, int itemDataValue, String name, List<String> lore) {
/* 21 */     ItemStack item = new ItemStack(itemId, amount, (short)itemDataValue);
/* 22 */     ItemMeta meta = item.getItemMeta();
/* 23 */     meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
/* 24 */     meta.setLore(lore);
/* 25 */     item.setItemMeta(meta);
/* 26 */     return item;
/*    */   }
/*    */   
/*    */   public ItemStack getRepairOrb(int amount) {
/* 30 */     List<String> lore = new ArrayList<>();
/* 31 */     for (String line : this.section.getStringList("lore")) {
/* 32 */       lore.add(ChatColor.translateAlternateColorCodes('&', line));
/*    */     }
/* 34 */     return createItem(this.section.getInt("item id"), amount, this.section.getInt("data value"), this.section.getString("name"), lore);
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/RepairOrbs.jar!/me/ray/misc/Items.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */