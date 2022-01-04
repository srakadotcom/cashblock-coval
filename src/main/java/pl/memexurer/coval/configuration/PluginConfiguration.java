package pl.memexurer.coval.configuration;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.Exclude;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.memexurer.coval.helper.ChatHelper;
import pl.memexurer.coval.helper.ItemBuilder;

public class PluginConfiguration extends OkaeriConfig {
    @Comment("LORE DO MAGICZNEGO KAMIENIA")
    public List<String> magicStoneLore = Arrays.asList("LORE", "PIZDA OGIEN");
    @Comment("NAME DO MAGICZNEGO KAMIENIA")
    public String magicStoneName = "TWOJA STARA";
    @Comment("NAME DO MAGICZNEGO KAMIENIA")
    public String brush2x2Name = "TWOJA STARA";
    @Comment("LORE DO BRUSH2x2")
    public List<String> brush2x2Lore = Arrays.asList("LORE", "PIZDA OGIEN");
    @Comment("NAME DO BRUSH3x3")
    public String brush3x3Name = "TWOJA STARA";
    @Comment("LORE DO BRUSH3x3")
    public List<String> brush3x3Lore = Arrays.asList("LORE", "PIZDA OGIEN");
    @Comment("NAME DO BRUSH4x4")
    public String brush4x4Name = "TWOJA STARA";
    @Comment("LORE DO BRUSH4X4")
    public List<String> brush4x4Lore = Arrays.asList("LORE", "PIZDA OGIEN");
    @Comment("NAME DO BRUSH5X5")
    public String brush5x5Name = "TWOJA STARA";
    @Comment("LORE DO BRUSH5X5")
    public List<String> brush5x5Lore = Arrays.asList("LORE", "PIZDA OGIEN");
    @Comment("NAME DO BRUSH6X6")
    public String brush6x6Name = "TWOJA STARA";
    @Comment("LORE DO BRUSH6X6")
    public List<String> brush6x6Lore = Arrays.asList("LORE", "PIZDA OGIEN");
    @Comment("NAME DO BRUSH5X5")
    public String brush6x6PremiumName = "TWOJA STARA";
    @Comment("LORE DO BRUSH6X6PREMIUM")
    public List<String> brush6x6PremiumLore = Arrays.asList("LORE", "PIZDA OGIEN");
    @Comment("NAME DO BRUSH6x6Premium+")
    public String brush6x6PremiumPlusName = "TWOJA STARA";
    @Comment("LORE DO BRUSH6x6PREMIUM+")
    public List<String> brush6x6PremiumPlusLore = Arrays.asList("LORE", "PIZDA OGIEN");



    @Comment("brush 2x2") //info; nie uzylem tej listy bo po co do tego uzywac listy lol? Do totemow uzyje listy
    @Exclude
    public ItemStack brush2x2 = new ItemBuilder(Material.BLAZE_ROD, 1)
        .setName(brush2x2Name)
        .setLore(brush2x2Lore)
        .build();
    @Comment("brush 3x3")
    @Exclude
    public ItemStack brush3x3 = new ItemBuilder(Material.BLAZE_ROD, 1)
        .setName(brush3x3Name)
        .setLore(brush3x3Lore)
        .build();
    @Comment("brush 4x4")
    @Exclude
    public ItemStack brush4x4 = new ItemBuilder(Material.BLAZE_ROD, 1)
        .setName(brush4x4Name)
        .setLore(brush4x4Lore)
        .build();
    @Comment("brush 5x5")
    @Exclude
    public ItemStack brush5x5 = new ItemBuilder(Material.BLAZE_ROD, 1)
        .setName(brush5x5Name)
        .setLore(brush5x5Lore)
        .build();
    @Comment("brush 6x6")
    @Exclude
    public ItemStack brush6x6 = new ItemBuilder(Material.BLAZE_ROD, 1)
        .setName(brush6x6Name)
        .setLore(brush6x6Lore)
        .build();
    @Comment("brush 6x6 Premium")
    @Exclude
    public ItemStack brush6x6Premium = new ItemBuilder(Material.BLAZE_ROD, 1)
        .setName(brush6x6PremiumName)
        .setLore(brush6x6PremiumLore)
        .build();
    @Comment("brush 6x6Premium+")
    @Exclude
    public ItemStack brush6x6PremiumPlus = new ItemBuilder(Material.BLAZE_ROD, 1)
        .setName(brush6x6PremiumPlusName)
        .setLore(brush6x6PremiumPlusLore)
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
    @Exclude
    public ItemStack magicStone = new ItemBuilder(Material.BLAZE_ROD, 1)
        .setName(ChatHelper.colored(magicStoneName))
        .setLore(magicStoneLore)
        .build();
    @Comment("nie masz kamienia kurwo jebana")
    public String youDontHaveKamien = "NIE MASZ KAMIENIA RURO";
    @Comment("wiadomosc gdy nie masz brusha w lapie")
    public String youDontHaveBrush = "MUSISZ MIEC BRUSHA W REKU";
}
