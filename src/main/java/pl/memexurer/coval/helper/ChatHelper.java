package pl.memexurer.coval.helper;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class ChatHelper {
  private ChatHelper() {}

  public static String colored(String string) {
    return ChatColor.translateAlternateColorCodes('&', string.replace(">>", "»"));
  }

  public static void sendMessage(Player player, String string) {
    player.sendMessage(colored(string));
  }

  public static void broadcast(String string) {
    Bukkit.broadcastMessage(colored(string));
  }
}