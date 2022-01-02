package pl.memexurer.coval.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.memexurer.coval.CashblockCovalPlugin;

public class TestCovalCommand implements CommandExecutor
{

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    Player player = (Player) sender;
    CashblockCovalPlugin.getInstance().getCovalInventory().openCoval(player);
    return false;
  }
}
