package me.ialext.poto.spigot.api.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

/**
 * Easily build {@link ItemStack}s with
 * fluent API support.
 */
public interface ItemBuilder {

  /**
   * Set the material for the resulting {@link ItemStack}.
   *
   * @param material The material.
   * @return This, fluent API.
   */
  ItemBuilder material(Material material);

  /**
   * Sets the name for the resulting {@link ItemStack}.
   *
   * @param name The name.
   * @return This, fluent API.
   */
  ItemBuilder name(String name);

  /**
   * Sets the lore for the resulting {@link ItemStack}.
   *
   * @param lore The lore.
   * @return This, fluent API.
   */
  ItemBuilder lore(List<String> lore);

  /**
   * @see #lore(List)
   */
  default ItemBuilder lore(String... lore) {
    return lore(Arrays.asList(lore));
  }

  /**
   * Sets the amount for the resulting {@link ItemStack}.
   *
   * @param amount The amount.
   * @return This, fluent API.
   */
  ItemBuilder amount(int amount);

  /**
   * Sets the data for the resulting {@link ItemStack}.
   *
   * @param data The data.
   * @return This, fluent API.
   */
  ItemBuilder data(byte data);

  /**
   * Adds an {@link Enchantment} for the resulting {@link ItemStack}.
   *
   * @param enchantment The enchantment.
   * @param level The enchantment's level.
   * @return This, fluent API.
   */
  ItemBuilder addEnchantment(Enchantment enchantment, int level);

  /**
   * Adds an {@link ItemFlag} for the resulting {@link ItemStack}.
   *
   * @param flag The flag.
   * @return This, fluent API.
   */
  ItemBuilder addFlag(ItemFlag flag);

  /**
   * Builds the {@link ItemStack}, using the given
   * values.
   *
   * @return The built {@link ItemStack}.
   */
  ItemStack build();

}
