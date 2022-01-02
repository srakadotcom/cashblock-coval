package pl.memexurer.coval.configuration;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.memexurer.coval.helper.ChatHelper;

public class PluginConfiguration extends OkaeriConfig {
    @Comment("czy jestes niggerem")
    public String nigger = "tak";

    @Comment("brush 2x2") //info; nie uzylem tej listy bo po co do tego uzywac listy lol? Do totemow uzyje listy
    public ItemStack brush2x2 = ItemBuilder.from(Material.BLAZE_ROD)
        .name(Component.text(ChatHelper.colored("&2&lbrush 2x2")))
        .build();
    @Comment("brush 3x3")
    public ItemStack brush3x3 = ItemBuilder.from(Material.BLAZE_ROD)
        .name(Component.text(ChatHelper.colored("&2&lbrush 3x3")))
        .build();
    @Comment("brush 4x4")
    public ItemStack brush4x4 = ItemBuilder.from(Material.BLAZE_ROD)
        .name(Component.text(ChatHelper.colored("&2&lbrush 4x4")))
        .build();
    @Comment("brush 5x5")
    public ItemStack brush5x5 = ItemBuilder.from(Material.BLAZE_ROD)
        .name(Component.text(ChatHelper.colored("&2&lbrush 5x5")))
        .build();
    @Comment("brush 6x6")
    public ItemStack brush6x6 = ItemBuilder.from(Material.BLAZE_ROD)
        .name(Component.text(ChatHelper.colored("&2&lbrush 6x6")))
        .build();
    @Comment("brush 6x6 Premium")
    public ItemStack brush6x6Premium = ItemBuilder.from(Material.BLAZE_ROD)
        .name(Component.text(ChatHelper.colored("&2&lbrush 6x6 Premium")))
        .build();
    @Comment("brush 6x6Premium+")
    public ItemStack brush6x6PremiumPlus = ItemBuilder.from(Material.BLAZE_ROD)
        .name(Component.text(ChatHelper.colored("&2&lbrush 6x6Premium+")))
        .build();
    @Comment("Wiadomosc gdy ulepszyles brusha")
    public String upgradedBrush = "&CBRAWO ULEPSZYLES BRUSHA GZ!";
    @Comment("Wiadomosc gdy osiagnales juz wymaksowany brush")
    public String youHaveMaxedBrush = "&c&lmordo masz juz brusha na maxa, nie mozesz dalej ulepszac";
    @Comment("Wiadomosc gdy komus nie siadzie ulepszenie")
    public String youLostBrush = "&cNie siadlo ci mordini, przez co dostajesz brusha o poziom mniejszego essa";
    @Comment("Wiadomosc gdy brush2x2 znika XDD")
    public String lost2x2 = "&cmordo masz takiego nie farta ze to chuj, straciles brusha XD";
}
