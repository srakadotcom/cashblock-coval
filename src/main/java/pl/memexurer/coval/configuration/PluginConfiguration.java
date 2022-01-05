package pl.memexurer.coval.configuration;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.memexurer.coval.helper.ItemBuilder;

import java.util.List;

public class PluginConfiguration extends OkaeriConfig {
    @Comment("brush 2x2") //info; nie uzylem tej listy bo po co do tego uzywac listy lol? Do totemow uzyje listy
    public ItemStack brush2x2 = new ItemBuilder(Material.BLAZE_ROD, 1)
            .setName("elo")
            .setLore(List.of("elo"))
            .build();

    @Comment("brush 3x3")
    public ItemStack brush3x3 = new ItemBuilder(Material.BLAZE_ROD, 1)
            .setName("elo")
            .setLore(List.of("elo"))
            .build();

    @Comment("brush 4x4")
    public ItemStack brush4x4 = new ItemBuilder(Material.BLAZE_ROD, 1)
            .setName("elo")
            .setLore(List.of("elo"))
            .build();

    @Comment("brush 5x5")
    public ItemStack brush5x5 = new ItemBuilder(Material.BLAZE_ROD, 1)
            .setName("elo")
            .setLore(List.of("elo"))
            .build();
    @Comment("brush 6x6")

    public ItemStack brush6x6 = new ItemBuilder(Material.BLAZE_ROD, 1)
            .setName("elo")
            .setLore(List.of("elo"))
            .build();

    @Comment("brush 6x6 Premium")
    public ItemStack brush6x6Premium = new ItemBuilder(Material.BLAZE_ROD, 1)
            .setName("elo")
            .setLore(List.of("elo"))
            .build();

    @Comment("brush 6x6Premium+")
    public ItemStack brush6x6PremiumPlus = new ItemBuilder(Material.BLAZE_ROD, 1)
            .setName("elo")
            .setLore(List.of("elo"))
            .build();

    @Comment("Wiadomosc gdy ulepszyles brusha")
    public String upgradedBrush = "&CBRAWO ULEPSZYLES BRUSHA GZ!";
    @Comment("Wiadomosc gdy osiagnales juz wymaksowany brush")
    public String youHaveMaxedBrush = "&c&lmordo masz juz brusha na maxa, nie mozesz dalej ulepszac";
    @Comment("Wiadomosc gdy komus nie siadzie ulepszenie")
    public String youLostBrush = "&cNie siadlo ci mordini, przez co dostajesz brusha o poziom mniejszego essa";
    @Comment("Wiadomosc gdy brush2x2 znika XDD")
    public String lost2x2 = "&cmordo masz takiego nie farta ze to chuj, straciles brusha XD";
    @Comment("wiadomosc gdy zabiera kamien a nie brusha")
    public String lostStone = "&dZabralo ci kamien tf tf";
    @Comment("magic kamien kurwa")
    public ItemStack magicStone = new ItemBuilder(Material.BLAZE_ROD, 1)
            .setName("elo")
            .setLore(List.of("elo"))
            .build();
    @Comment("nie masz kamienia kurwo jebana")
    public String youDontHaveKamien = "NIE MASZ KAMIENIA RURO";
    @Comment("wiadomosc gdy nie masz brusha w lapie")
    public String youDontHaveBrush = "MUSISZ MIEC BRUSHA W REKU";
}
