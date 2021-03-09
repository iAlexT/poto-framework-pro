package me.ialext.poto.spigot.api.menu.builder;

import me.ialext.poto.spigot.api.menu.Menu;
import me.ialext.poto.spigot.api.menu.item.ClickableItem;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.function.Predicate;

public interface MenuBuilder {

  MenuBuilder title(String title);

  MenuBuilder rows(int rows);

  MenuBuilder addItem(ClickableItem clickableItem);

  MenuBuilder openAction(Predicate<InventoryOpenEvent> openAction);

  MenuBuilder closeAction(Predicate<InventoryCloseEvent> closeAction);

  Menu build();

}
