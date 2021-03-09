package me.ialext.poto.spigot.api.menu.item;

import me.ialext.poto.common.api.builder.Builder;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public interface ClickableItemBuilder extends Builder<ClickableItem> {

  ClickableItemBuilder slot(int slot);

  ClickableItemBuilder itemStack(ItemStack itemStack);

  ClickableItemBuilder clickAction(Predicate<InventoryClickEvent> clickAction);

}
