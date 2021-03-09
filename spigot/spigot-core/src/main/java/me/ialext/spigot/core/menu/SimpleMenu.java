package me.ialext.spigot.core.menu;

import me.ialext.poto.spigot.api.menu.Menu;
import me.ialext.poto.spigot.api.menu.item.ClickableItem;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.List;
import java.util.function.Predicate;

public class SimpleMenu implements Menu {

  private final Inventory inventory;
  private final Predicate<InventoryOpenEvent> openAction;
  private final Predicate<InventoryCloseEvent> closeAction;
  private final List<ClickableItem> items;

  public SimpleMenu(String title,
                    int rows,
                    Predicate<InventoryOpenEvent> openAction,
                    Predicate<InventoryCloseEvent> closeAction,
                    List<ClickableItem> items) {
    this.items = items;
    this.openAction = openAction;
    this.closeAction = closeAction;
    inventory = Bukkit.createInventory(null, rows * 9, title);
    items.forEach(clickableItem -> inventory.addItem(clickableItem.getItemStack()));
  }

  @Override
  public Inventory getInventory() {
    return inventory;
  }

  @Override
  public Predicate<InventoryOpenEvent> getOpenAction() {
    return openAction;
  }

  @Override
  public Predicate<InventoryCloseEvent> getCloseAction() {
    return closeAction;
  }

  @Override
  public List<ClickableItem> getItems() {
    return items;
  }
}
