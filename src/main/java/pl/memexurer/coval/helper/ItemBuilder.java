package pl.memexurer.coval.helper;

import org.bukkit.enchantments.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class ItemBuilder
{
  private final ItemStack is;
  private final ItemMeta im;

  public ItemBuilder(final Material m, final int amount) {
    this.is = new ItemStack(m, amount);
    this.im = this.is.getItemMeta();
  }

  public ItemBuilder(final Material m, final int amount, final short durability) {
    this.is = new ItemStack(m, amount, durability);
    this.im = this.is.getItemMeta();
  }

  public ItemBuilder setName(final String name) {
    this.im.setDisplayName(ChatHelper.colored(name));
    this.is.setItemMeta(this.im);
    return this;
  }

  public ItemBuilder setLore(List<String> lore) {
    this.im.setLore(ChatHelper.colored(lore));
    this.is.setItemMeta(this.im);
    return this;
  }

  public ItemBuilder setLore(String... lore) {
    this.im.setLore(ChatHelper.colored(Arrays.asList(lore)));
    this.is.setItemMeta(this.im);
    return this;
  }

  public ItemBuilder setSkullOwner(final String owner) {
    ((SkullMeta)this.im).setOwner(owner);
    this.is.setItemMeta(this.im);
    return this;
  }

  public ItemBuilder addEnchant(final Enchantment enchantment, final int level) {
    this.is.addUnsafeEnchantment(enchantment, level);
    return this;
  }

  public ItemBuilder addEnchant(final Map<Enchantment, Integer> map) {
    this.is.addUnsafeEnchantments(map);
    return this;
  }

  public ItemBuilder addFlag(final ItemFlag... flag) {
    this.im.addItemFlags(flag);
    this.is.setItemMeta(this.im);
    return this;
  }

  public ItemBuilder setColor(final Color color) {
    ((LeatherArmorMeta)this.im).setColor(color);
    this.is.setItemMeta(this.im);
    return this;
  }

  public ItemStack build() {
    return this.is;
  }
}