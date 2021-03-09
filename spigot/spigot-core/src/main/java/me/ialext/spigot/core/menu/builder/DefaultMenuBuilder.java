package me.ialext.spigot.core.menu.builder;

import me.ialext.poto.spigot.api.menu.Menu;
import me.ialext.poto.spigot.api.menu.builder.MenuBuilder;
import me.ialext.poto.spigot.api.menu.item.ClickableItem;
import me.ialext.spigot.core.menu.SimpleMenu;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DefaultMenuBuilder implements MenuBuilder {

  private String title;
  private int rows;
  private final List<ClickableItem> items = new ArrayList<>();
  private Predicate<InventoryOpenEvent> openAction;
  private Predicate<InventoryCloseEvent> closeAction;

  @Override
  public MenuBuilder title(String title) {
    this.title = title;

    return this;
  }

  @Override
  public MenuBuilder rows(int rows) {
    this.rows = rows;

    return this;
  }

  @Override
  public MenuBuilder addItem(ClickableItem clickableItem) {
    items.add(clickableItem);

    return this;
  }

  @Override
  public MenuBuilder openAction(Predicate<InventoryOpenEvent> openAction) {
    this.openAction = openAction;

    return this;
  }

  @Override
  public MenuBuilder closeAction(Predicate<InventoryCloseEvent> closeAction) {
    this.closeAction = closeAction;

    return this;
  }

  @Override
  public Menu build() {
    return new SimpleMenu(
        title,
        rows,
        openAction,
        closeAction,
        items
    );
  }
}
