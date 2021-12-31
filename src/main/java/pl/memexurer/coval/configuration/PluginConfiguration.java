package pl.memexurer.coval.configuration;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class PluginConfiguration extends OkaeriConfig {
    @Comment("czy jestes niggerem")
    public String nigger = "tak";

    @Comment("lista itemow dla niggerow")
    public List<ItemStack> niggerList = Arrays.asList(
            new ItemStack(Material.STONE, 1)
    );
}
