/*    */ package me.ray.repairorbs;
/*    */ 
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import me.ray.commands.GiveCommand;
/*    */ import me.ray.events.RepairListener;
/*    */ import me.ray.misc.Items;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.PluginDescriptionFile;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class RepairOrbs extends JavaPlugin {
/*    */   private Logger logger;
/*    */   private PluginDescriptionFile pluginDescription;
/*    */   private Items items;
/*    */   
/*    */   public void onEnable() {
/* 21 */     this.logger = getLogger();
/* 22 */     this.pluginDescription = getDescription();
/* 23 */     this.items = new Items(this);
/* 24 */     PluginManager pluginManager = getServer().getPluginManager();
/* 25 */     getConfig().options().copyDefaults(true);
/* 26 */     saveDefaultConfig();
/* 27 */     getCommand("repairorbs").setExecutor((CommandExecutor)new GiveCommand(this));
/* 28 */     pluginManager.registerEvents((Listener)new RepairListener(this), (Plugin)this);
/* 29 */     this.logger.log(Level.INFO, String.format("Plugin %s v%s was successfully loaded.", new Object[] { this.pluginDescription.getName(), this.pluginDescription.getVersion() }));
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDisable() {
/* 34 */     this.logger.log(Level.INFO, String.format("Plugin %s v%s was successfully stopped.", new Object[] { this.pluginDescription.getName(), this.pluginDescription.getVersion() }));
/*    */   }
/*    */   
/*    */   public Items getItems() {
/* 38 */     return this.items;
/*    */   }
/*    */ }


/* Location:              /home/tyler/Downloads/jar files/RepairOrbs.jar!/me/ray/repairorbs/RepairOrbs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */