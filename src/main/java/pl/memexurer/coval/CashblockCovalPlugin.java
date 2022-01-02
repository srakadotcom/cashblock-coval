package pl.memexurer.coval;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.memexurer.coval.cmd.TestCovalCommand;
import pl.memexurer.coval.configuration.PluginConfiguration;

import java.io.File;
import pl.memexurer.coval.inventory.CovalInventory;

public class CashblockCovalPlugin extends JavaPlugin {
    private CovalInventory covalInventory;

    private final PluginConfiguration configuration = (PluginConfiguration) ConfigManager.create(PluginConfiguration.class)
            .withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit())
            .withBindFile(new File(getDataFolder(), "config.yml"))
            .saveDefaults()
            .load(true);

    @Override
    public void onEnable() {
        covalInventory = new CovalInventory(this);
        getCommand("testcoval").setExecutor(new TestCovalCommand());
        getLogger().info("Czy jestes niggerem: " + configuration.nigger);
    }

    public static CashblockCovalPlugin getInstance() {
        return JavaPlugin.getPlugin(CashblockCovalPlugin.class);
    }

    public CovalInventory getCovalInventory() {
        return covalInventory;
    }

    public PluginConfiguration getConfiguration() {
        return configuration;
    }
}
