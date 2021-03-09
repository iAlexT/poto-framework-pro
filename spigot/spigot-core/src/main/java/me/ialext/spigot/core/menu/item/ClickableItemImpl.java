package me.ialext.spigot.core.menu.item;

import me.ialext.poto.spigot.api.menu.item.ClickableItem;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class ClickableItemImpl implements ClickableItem {
  
  private final int slot;
  private final ItemStack itemStack;
  private final Predicate<InventoryClickEvent> clickAction;
  
  public ClickableItemImpl(int slot,
                           ItemStack itemStack,
                           Predicate<InventoryClickEvent> clickAction) {
    this.slot = slot;
    this.itemStack = itemStack;
    this.clickAction = clickAction;
  }

  @Override
  public int getSlot() {
    return slot;
  }

  @Override
  public ItemStack getItemStack() {
    return itemStack;
  }

  @Override
  public Predicate<InventoryClickEvent> getClickAction() {
    return clickAction;
  }
}
