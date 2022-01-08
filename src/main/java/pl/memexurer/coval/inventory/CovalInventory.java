package pl.memexurer.coval.inventory;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.GuiType;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import java.util.Arrays;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import pl.memexurer.coval.CashblockCovalPlugin;
import pl.memexurer.coval.helper.ChatHelper;
import pl.memexurer.coval.helper.RandomHelper;

public class CovalInventory {

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

    GuiItem upgradeBrushWithoutStone = ItemBuilder.from(Material.ANVIL)
        .name(Component.text(ChatHelper.colored("&a&lUlepsz Brusha &c&nBez kamienia")))
        .lore(Arrays.asList(Component.text(ChatHelper.colored("&7W tym miejscu możesz")),
            Component.text(ChatHelper.colored("&6&nulepszyć swojego Brusha"))))
        .asGuiItem(event -> {
          if (event.getWhoClicked().getItemInHand().getItemMeta() == null) {
            ChatHelper.sendMessage(player,
                CashblockCovalPlugin.getInstance().getConfiguration().youDontHaveBrush);
            return;
          }
          if (!event.getWhoClicked().getItemInHand().getItemMeta().getDisplayName()
              .contains(ChatHelper.colored("&f&lBrush"))) {
            ChatHelper.sendMessage(player,
                CashblockCovalPlugin.getInstance().getConfiguration().youDontHaveBrush);
            return;
          }

          double chance = RandomHelper.getRandDouble(0.0, 100.0);
          if (30 >= chance) {
            player.setItemInHand(null);
            ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
          } else if (40 >= chance) {
            upgradeWithoutStone(player);
          } else {
            downgradeWithoutStone(player);
          }

          player.closeInventory();
        });

    GuiItem upgradeBrushWithStone = ItemBuilder.from(Material.ANVIL)
        .name(Component.text(ChatHelper.colored("&a&lUlepsz Brusha &a&nZ kamieniem")))
        .lore(Arrays.asList(Component.text(ChatHelper.colored("&7W tym miejscu możesz")),
            Component.text(ChatHelper.colored("&6&nulepszyć swojego Brusha"))))
        .asGuiItem(event -> {
          if (event.getWhoClicked().getItemInHand().getItemMeta() == null) {
            ChatHelper.sendMessage(player,
                CashblockCovalPlugin.getInstance().getConfiguration().youDontHaveBrush);
            return;
          }
          if (!event.getWhoClicked().getItemInHand().getItemMeta().getDisplayName()
              .contains(ChatHelper.colored("&f&lBrush"))) {
            ChatHelper.sendMessage(player,
                CashblockCovalPlugin.getInstance().getConfiguration().youDontHaveBrush);
            return;
          }
          if (!event.getWhoClicked().getInventory()
              .contains(CashblockCovalPlugin.getInstance().getConfiguration().magicStone)) {
            ChatHelper.sendMessage(player,
                CashblockCovalPlugin.getInstance().getConfiguration().youDontHaveKamien);
            return;
          }

          double chance = RandomHelper.getRandDouble(0.0, 100.0);
          if (30 >= chance) {
            player.getInventory()
                .remove(CashblockCovalPlugin.getInstance().getConfiguration().magicStone);
            ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
          } else if (40 >= chance) {
            upgradeWithStone(player);
          } else {
            downgradeWithStone(player);
          }

          player.closeInventory();
        });

    gui.setItem(11, upgradeBrushWithoutStone);
    gui.setItem(13, upgradeBrushWithStone);
    gui.open(player);
  }

  public void upgradeWithoutStone(Player player) {
    if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush2x2)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush2x2);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush3x3);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush3x3)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush3x3);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush4x4);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush4x4)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush4x4);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush5x5);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush5x5)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush5x5);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6Premium)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6PremiumPlus);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6PremiumPlus)) {
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youHaveMaxedBrush);
    }
  }

  public void downgradeWithoutStone(Player player) {
    if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6Premium)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
    } else if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush5x5);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
    } else if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush5x5)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush5x5);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush4x4);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
    } else if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush4x4)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush4x4);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush3x3);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
    } else if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush3x3)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush3x3);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush2x2);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
    } else if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush2x2)) {
      if (RandomHelper.getChance(80)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush2x2);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lost2x2);
      }
    }
  }

  public void upgradeWithStone(Player player) {
    if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush2x2)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush2x2);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush3x3);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush3x3)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush3x3);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush4x4);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush4x4)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush4x4);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush5x5);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush5x5)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush5x5);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6Premium)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
      player.getInventory()
          .addItem(cashblockCovalPlugin.getConfiguration().brush6x6PremiumPlus);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
    } else if (player.getItemInHand()
        .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6PremiumPlus)) {
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youHaveMaxedBrush);
    }
  }

  public void downgradeWithStone(Player player) {
    if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6Premium)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
    } else if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
    } else if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush5x5)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
    } else if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush4x4)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
    } else if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush3x3)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
    } else if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush2x2)) {
      if (RandomHelper.getChance(80)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
      }
    }
  }
}