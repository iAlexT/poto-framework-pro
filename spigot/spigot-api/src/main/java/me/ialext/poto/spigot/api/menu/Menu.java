package me.ialext.poto.spigot.api.menu;

import me.ialext.poto.spigot.api.menu.item.ClickableItem;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.List;
import java.util.function.Predicate;

public interface Menu {

  Inventory getInventory();

  default String getTitle() {
    return getInventory().getTitle();
  }

  default int getRows() {
    return getInventory().getSize() * 9;
  }

  Predicate<InventoryOpenEvent> getOpenAction();

  Predicate<InventoryCloseEvent> getCloseAction();

  List<ClickableItem> getItems();

}
