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

    GuiItem upgradeBrushWithoutStone = ItemBuilder.from(Material.ANVIL)
        .name(Component.text(ChatHelper.colored("&a&lUlepsz Brusha &c&nBez kamienia")))
        .lore(Arrays.asList(Component.text(ChatHelper.colored("&7W tym miejscu możesz")),
            Component.text(ChatHelper.colored("&6&nulepszyć swojego Brusha"))))
        .asGuiItem(event -> upgradeWithoutStone(player));

    GuiItem upgradeBrushWithStone = ItemBuilder.from(Material.ANVIL)
        .name(Component.text(ChatHelper.colored("&a&lUlepsz Brusha &a&nZ kamieniem")))
        .lore(Arrays.asList(Component.text(ChatHelper.colored("&7W tym miejscu możesz")),
            Component.text(ChatHelper.colored("&6&nulepszyć swojego Brusha"))))
        .asGuiItem(event -> upgradeWithStone(player));

    gui.setItem(11, upgradeBrushWithoutStone);
    gui.setItem(13, upgradeBrushWithStone);
    gui.open(player);
  }

  public void upgradeWithoutStone(Player player) {
    if (RandomHelper.getChance(30)) {
      player.setItemInHand(null);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
      player.closeInventory();
    }
    else {
      if (RandomHelper.getChance(40)) {
        if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush2x2)) {
          player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush2x2);
          player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush3x3);
          ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
          player.closeInventory();
          return;
        }
        if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush3x3)) {
          player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush3x3);
          player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush4x4);
          ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
          player.closeInventory();
          return;
        }
        if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush4x4)) {
          player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush4x4);
          player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush5x5);
          ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
          player.closeInventory();
          return;
        }
        if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush5x5)) {
          player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush5x5);
          player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6);
          ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
          player.closeInventory();
          return;
        }
        if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6)) {
          player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6);
          player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
          ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
          player.closeInventory();
          return;
        }
        if (player.getItemInHand()
            .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6Premium)) {
          player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
          player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6PremiumPlus);
          ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
          player.closeInventory();
          return;
        }
        if (player.getItemInHand()
            .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6PremiumPlus)) {
          ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youHaveMaxedBrush);
          player.closeInventory();
        }
      } else {
        downgradeWithoutStone(player);
      }
    }
  }

  public void downgradeWithoutStone(Player player) {
    if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6Premium)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
      player.closeInventory();
      return;
    }
    if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush5x5);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
      player.closeInventory();
      return;
    }
    if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush5x5)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush5x5);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush4x4);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
      player.closeInventory();
      return;
    }
    if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush4x4)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush4x4);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush3x3);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
      player.closeInventory();
      return;
    }
    if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush3x3)) {
      player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush3x3);
      player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush2x2);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
      player.closeInventory();
      return;
    }
    if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush2x2)) {
      if (RandomHelper.getChance(80)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush2x2);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lost2x2);
        player.closeInventory();
      }
    }
  }

  public void upgradeWithStone(Player player) {
    if (RandomHelper.getChance(100)) {
      player.setItemInHand(null);
      ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
      player.closeInventory();
      return;
    } else {
      downgradeWithStone(player);
    }
    if (RandomHelper.getChance(80)) {
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush2x2)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush2x2);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush3x3);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush3x3)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush3x3);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush4x4);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush4x4)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush4x4);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush5x5);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush5x5)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush5x5);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand()
          .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6Premium)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().brush6x6Premium);
        player.getInventory().addItem(cashblockCovalPlugin.getConfiguration().brush6x6PremiumPlus);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().upgradedBrush);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand()
          .isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6PremiumPlus)) {
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youHaveMaxedBrush);
        player.closeInventory();
      }
    } else {
      downgradeWithStone(player);
    }
  }

  public void downgradeWithStone(Player player) {
    if (RandomHelper.getChance(80)) {
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6Premium)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush6x6)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush5x5)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush4x4)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush3x3)) {
        player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
        player.closeInventory();
        return;
      }
      if (player.getItemInHand().isSimilar(cashblockCovalPlugin.getConfiguration().brush2x2)) {
        if (RandomHelper.getChance(80)) {
          player.getInventory().remove(cashblockCovalPlugin.getConfiguration().magicStone);
          ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().lostStone);
          player.closeInventory();
        }
      }
      if (RandomHelper.getChance(80)) {
        player.setItemInHand(null);
        ChatHelper.sendMessage(player, cashblockCovalPlugin.getConfiguration().youLostBrush);
        player.closeInventory();
        return;
      } else {
        downgradeWithStone(player);
      }
    }
  }
}