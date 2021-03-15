package me.ialext.spigot.core.item;

import me.ialext.poto.spigot.api.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class SimpleItemBuilder implements ItemBuilder {

  private Material material;
  private String name;
  private List<String> lore;
  private int amount;
  private byte data;
  private final Set<ItemFlag> flags = new HashSet<>();
  private final Map<Enchantment, Integer> enchantments = new HashMap<>();

  @Override
  public ItemBuilder material(Material material) {
    this.material = material;

    return this;
  }

  @Override
  public ItemBuilder name(String name) {
    this.name = name;

    return this;
  }

  @Override
  public ItemBuilder lore(List<String> lore) {
    this.lore = lore;

    return this;
  }

  @Override
  public ItemBuilder amount(int amount) {
    this.amount = amount;

    return this;
  }

  @Override
  public ItemBuilder data(byte data) {
    this.data = data;

    return this;
  }

  @Override
  public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
    enchantments.put(enchantment, level);

    return this;
  }

  @Override
  public ItemBuilder addFlag(ItemFlag flag) {
    flags.add(flag);

    return this;
  }

  @Override
  public ItemStack build() {
    ItemStack itemStack = new ItemStack(material, amount, data);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(name);
    itemMeta.setLore(lore);
    flags.forEach(itemMeta::addItemFlags);
    enchantments.forEach((enchantment, integer) -> itemMeta.addEnchant(enchantment, integer, false));
    itemStack.setItemMeta(itemMeta);

    return itemStack;
  }
}
