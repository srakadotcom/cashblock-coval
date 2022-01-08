package pl.memexurer.coval;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import pl.memexurer.coval.configuration.PluginConfiguration;
import pl.memexurer.coval.helper.ChatHelper;
import pl.memexurer.coval.inventory.CovalInventory;

public class CashblockCovalPlugin extends JavaPlugin implements Listener {

  private final PluginConfiguration configuration = (PluginConfiguration) ConfigManager.create(
          PluginConfiguration.class)
      .withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit())
      .withBindFile(new File(getDataFolder(), "config.yml"))
      .saveDefaults()
      .load(true);
  private CovalInventory covalInventory;

  public static CashblockCovalPlugin getInstance() {
    return JavaPlugin.getPlugin(CashblockCovalPlugin.class);
  }

  @Override
  public void onEnable() {
    covalInventory = new CovalInventory(this);
    getServer().getPluginManager().registerEvents(this, this);
  }

  @EventHandler
  private void onInteract(PlayerInteractAtEntityEvent event) {
    if (event.getRightClicked().getCustomName() != null && event.getRightClicked().getCustomName()
        .equals(
            ChatColor.translateAlternateColorCodes('&', configuration.npcName)
        )) {
      if(event.getPlayer().getItemInHand() == null || !isBrush(event.getPlayer().getItemInHand())) {
        event.getPlayer().sendMessage(configuration.youDontHaveBrush);
        return;
      }
      covalInventory.openCoval(event.getPlayer());
    }
  }
  
  private boolean isBrush(ItemStack itemStack) {
    return itemStack.isSimilar(configuration.brush2x2) ||
        itemStack.isSimilar(configuration.brush3x3) ||
        itemStack.isSimilar(configuration.brush4x4) ||
        itemStack.isSimilar(configuration.brush5x5) ||
        itemStack.isSimilar(configuration.brush6x6) ||
        itemStack.isSimilar(configuration.brush6x6Premium) ||
        itemStack.isSimilar(configuration.brush6x6PremiumPlus);
  }
  
  public PluginConfiguration getConfiguration() {
    return configuration;
  }
}
