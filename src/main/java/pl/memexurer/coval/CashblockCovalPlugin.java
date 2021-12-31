package pl.memexurer.coval;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.memexurer.coval.configuration.PluginConfiguration;

import java.io.File;

public class CashblockCovalPlugin extends JavaPlugin {
    private final PluginConfiguration configuration = (PluginConfiguration) ConfigManager.create(PluginConfiguration.class)
            .withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit())
            .withBindFile(new File(getDataFolder(), "config.yml"))
            .saveDefaults()
            .load(true);

    @Override
    public void onEnable() {
        getLogger().info("Czy jestes niggerem: " + configuration.nigger);
        getLogger().info("Lista itemow dla niggerow: " + configuration.niggerList);
    }
}
