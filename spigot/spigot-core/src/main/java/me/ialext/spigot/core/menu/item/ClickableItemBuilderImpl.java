package me.ialext.spigot.core.menu.item;

import me.ialext.poto.spigot.api.menu.item.ClickableItem;
import me.ialext.poto.spigot.api.menu.item.ClickableItemBuilder;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class ClickableItemBuilderImpl implements ClickableItemBuilder {


  @Override
  public ClickableItem build() {
    return null;
  }

  @Override
  public ClickableItemBuilder slot(int slot) {
    return null;
  }

  @Override
  public ClickableItemBuilder itemStack(ItemStack itemStack) {
    return null;
  }

  @Override
  public ClickableItemBuilder clickAction(Predicate<InventoryClickEvent> clickAction) {
    return null;
  }
}
