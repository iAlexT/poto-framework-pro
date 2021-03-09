package me.ialext.poto.spigot.api.menu.item;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public interface ClickableItem {

  int getSlot();

  ItemStack getItemStack();

  Predicate<InventoryClickEvent> getClickAction();

}
