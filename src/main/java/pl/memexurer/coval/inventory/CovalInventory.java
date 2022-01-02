package pl.memexurer.coval.inventory;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import java.util.Arrays;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import pl.memexurer.coval.CashblockCovalPlugin;
import pl.memexurer.coval.helper.ChatHelper;
import pl.memexurer.coval.helper.RandomHelper;

public class CovalInventory
{
  private final CashblockCovalPlugin cashblockCovalPlugin;

  public CovalInventory(CashblockCovalPlugin cashblockCovalPlugin) {
    this.cashblockCovalPlugin = cashblockCovalPlugin;
  }

  public void openCoval(Player player) {
    Gui gui = Gui.gui()
        .title(Component.text("Kowal"))
        .rows(6)
        .disableItemTake()
        .create();

    GuiItem upgradeBrush = ItemBuilder.from(Material.ANVIL)
        .name(Component.text(ChatHelper.colored("&a&lUlepsz Brusha")))
        .lore(Arrays.asList(Component.text(ChatHelper.colored("&7W tym miejscu możesz")),
            Component.text(ChatHelper.colored("&6&nulepszyć swojego Brusha"))))
        .asGuiItem(event -> upgrade(player));

    gui.setItem(12, upgradeBrush);
    gui.open(player);
  }

  public void upgrade(Player player) {
    if (RandomHelper.getChance(60)) {
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush2x2)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush2x2);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush3x3);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush3x3)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush3x3);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush4x4);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush4x4)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush4x4);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush5x5);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush5x5)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush5x5);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        return;
      }
      if (player.getItemInHand()
          .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6Premium)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6PremiumPlus);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        return;
      }
      if (player.getItemInHand()
          .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6PremiumPlus)) {
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youHaveMaxedBrush);
      }
    } else {
      downgrade(player);
    }
  }

  public void downgrade(Player player) {
    if (RandomHelper.getChance(30)) {
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6Premium)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush5x5);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush5x5)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush5x5);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush4x4);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush4x4)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush4x4);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush3x3);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush3x3)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush3x3);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush2x2);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush2x2)) {
        if (RandomHelper.getChance(10)) {
          player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush2x2);
          ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lost2x2);
        }
      }
    }
  }
}