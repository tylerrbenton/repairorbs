/*    */ package me.ray.commands;
/*    */ 
/*    */ import me.ray.misc.Items;
/*    */ import me.ray.repairorbs.RepairOrbs;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.ConfigurationSection;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class GiveCommand implements CommandExecutor {
/*    */   private Items items;
/*    */   private ConfigurationSection section;
/*    */   
/*    */   public GiveCommand(RepairOrbs repairOrbs) {
/* 19 */     this.items = repairOrbs.getItems();
/* 20 */     this.section = repairOrbs.getConfig().getConfigurationSection("configuration.messages");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
/* 25 */     if (command.getName().equalsIgnoreCase("repairorbs")) {
/* 26 */       if (args.length != 3) {
/* 27 */         commandSender.sendMessage(ChatColor.RED + "/Repairorbs Give [Name] [Amount]");
/* 28 */         return false;
/*    */       } 
/* 30 */       if (args[0].equalsIgnoreCase("give")) {
/*    */         
/* 32 */         Player target = Bukkit.getPlayerExact(args[1]);
/* 33 */         if (target == null) {
/* 34 */           commandSender.sendMessage(ChatColor.RED + "Player could not be found.");
/* 35 */           return false;
/*    */         } 
/*    */         try {
/* 38 */           int amount = Integer.parseInt(args[2]);
/* 39 */           if (amount == 0) {
/* 40 */             commandSender.sendMessage(ChatColor.RED + "Please specify a number that is not zero.");
/*    */           } else {
/* 42 */             target.getInventory().addItem(new ItemStack[] { this.items.getRepairOrb(amount) });
/*    */             
/* 44 */             commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.section.getString("sent")
/* 45 */                   .replace("%receiver%", target.getName())
/* 46 */                   .replace("%amount%", String.valueOf(amount))));
/*    */             
/* 48 */             commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.section.getString("received")
/* 49 */                   .replace("%sender%", (commandSender instanceof Player) ? commandSender.getName() : "Console")
/* 50 */                   .replace("%amount%", String.valueOf(amount))));
/*    */           } 
/* 52 */         } catch (IllegalArgumentException exception) {
/* 53 */           commandSender.sendMessage(ChatColor.RED + "Please use a number.");
/*    */         } 
/*    */       } 
/*    */     } 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/RepairOrbs.jar!/me/ray/commands/GiveCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */